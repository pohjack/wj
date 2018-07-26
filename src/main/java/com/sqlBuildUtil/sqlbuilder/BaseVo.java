package com.sqlBuildUtil.sqlbuilder;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.sqlBuildUtil.annotation.TableField;
import com.sqlBuildUtil.annotation.TableName;
import com.sqlBuildUtil.annotation.TablePKField;

/**
 * 根据VO对象动态生成sql
 */
public  abstract class BaseVo {

    private String tableName;
    private String tablePkValue;
    private String tablePkName;
    private boolean fieldNameConvert;
    private Map<String, String> columns;
    public BaseVo self;
    private static final int UPDATE = 1;
    private static final int INSERT = 2;
    private static final int SELECT = 3;
    private static final int DELETE = 4;
    private SQL sqlBuilder = null;

    public abstract void setSelf();

    private void initMataInfo() throws IllegalAccessException {
        TableName ta = self.getClass().getAnnotation(TableName.class);
        this.tableName = ta.table();
        this.fieldNameConvert = ta.fieldNameConvert();
        Field[] fields = self.getClass().getDeclaredFields();
        columns = new HashMap<String, String>();
        if (fields != null && fields.length > 0) {
            for (Field f : fields) {
                f.setAccessible(true);
                if (f.isAnnotationPresent(TablePKField.class)) {
                    this.tablePkName = f.getName();
                    this.tablePkValue = f.get(self) == null ? "" : (String) f.get(self);
                }
                if (f.isAnnotationPresent(TableField.class)) {
                    String type = f.getAnnotation(TableField.class).type();
                    String fName = f.getName();
                    if (type.equals(TableField.TYPE_DATE)) {
                        String format = f.getAnnotation(TableField.class).dateFormat();
                        String value = f.get(self) == null ? "" : (String) f.get(self);
                        if (StringUtils.isEmpty(value)) {
                            value = "sysdate";
                        } else {
                            value = "to_date(" + value + " '" + format + "')";
                        }
                        columns.put(fName, value);
                    } else {
                        columns.put(fName, f.get(self) == null ? "" : (String) f.get(self));
                    }
                }
            }
        }

    }

    private String generateSql(int operation) {
        sqlBuilder = new SQL();
        switch (operation) {
            case UPDATE:
                sqlBuilder.UPDATE(tableName).WHERE(tablePkName + "=" + tablePkValue);
                if (columns != null && columns.size() > 0) {
                    for (Map.Entry<String, String> m : columns.entrySet()) {
                        if (fieldNameConvert) {
                            sqlBuilder.SET(CommonStringUtils.camelToUnderline(m.getKey()) + "=" + m.getValue());
                        } else {
                            sqlBuilder.SET(m.getKey() + "=" + m.getValue());
                        }
                    }
                }
                break;
            case INSERT:
                sqlBuilder.INSERT_INTO(tableName);
                if (columns != null && columns.size() > 0) {
                    for (Map.Entry<String, String> m : columns.entrySet()) {
                        if (fieldNameConvert) {
                            sqlBuilder.INTO_COLUMNS(CommonStringUtils.camelToUnderline(m.getKey())).INTO_VALUES(m.getValue());
                        } else {
                            sqlBuilder.INTO_COLUMNS(m.getKey()).INTO_VALUES(m.getValue());
                        }
                    }
                    sqlBuilder.INTO_COLUMNS(tablePkName).INTO_VALUES(tablePkValue);
                }
                break;
            case DELETE:
                sqlBuilder.DELETE_FROM(tableName).WHERE(tablePkName + "=" + tablePkValue);
                break;
            case SELECT:
                if (columns != null && columns.size() > 0) {
                    for (Map.Entry<String, String> m : columns.entrySet()) {
                        if (fieldNameConvert) {
                            sqlBuilder.SELECT(CommonStringUtils.camelToUnderline(m.getKey()));
                        } else {
                            sqlBuilder.SELECT(m.getKey());
                        }
                    }
                    sqlBuilder.WHERE(tablePkName + "=" + tablePkValue);
                }
                break;
        }
        return sqlBuilder.toString();
    }

    public String update() throws IllegalAccessException {
        initMataInfo();
        return this.generateSql(UPDATE);
    }

    public String insert() throws IllegalAccessException {
        initMataInfo();
        return this.generateSql(INSERT);
    }

    public String delete() throws IllegalAccessException {
        initMataInfo();
        return this.generateSql(DELETE);
    }

    public String select() throws IllegalAccessException {
        initMataInfo();
        return this.generateSql(SELECT);
    }

    public void readFromMap(Map<String, String> param, boolean needConvert) throws NoSuchFieldException, IllegalAccessException {
        if (param == null || param.size() == 0) {
            return;
        } else {
            for (Map.Entry<String, String> m : param.entrySet()) {
                Field f = null;
                if (needConvert) {
                    f = self.getClass().getDeclaredField(CommonStringUtils.underlineToCamel(m.getKey()));
                } else {
                    f = self.getClass().getDeclaredField(m.getKey());
                }
                f.setAccessible(true);
                f.set(self, m.getValue());
            }
        }
    }
}
