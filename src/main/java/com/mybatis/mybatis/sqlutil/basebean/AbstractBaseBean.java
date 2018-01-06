package com.mybatis.mybatis.sqlutil.basebean;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.mybatis.mybatis.sqlutil.SQL;
import com.mybatis.mybatis.sqlutil.annotation.DataMapping;

/**
 * @author: wj
 * @version: v1
 * @date:2018年1月5日 上午9:50:46
 * @description:bean抽象父类，定义获取bean注解信息，提供sql构建工具类，
 */
public abstract class AbstractBaseBean implements BaseBean {
	private MetaData metaData;
	private BaseBean bean;
	protected SQL sqlCreater;

	public AbstractBaseBean() {
		setSelf();
		metaData = initMetaData();
		sqlCreater=new SQL();
	}

	protected void setBean(BaseBean bean) {
		this.bean = bean;
	}
	
	protected MetaData getMetaData(){
		return this.metaData;
	}
	
	/**
	 * 获取bean注解信息
	 */
	private MetaData initMetaData() {
		MetaData metaData = new MetaData();
		if (bean == null) {
			setSelf();
		}
		metaData.setTableName(bean.getClass().getAnnotation(DataMapping.class).value());
		Field[] fields = bean.getClass().getDeclaredFields();
		Map<String, Object> data = new HashMap<String, Object>();
		for (Field field : fields) {
			try {
				field.setAccessible(true);
				String columnName = field.getAnnotation(DataMapping.class).value();
				String columnValue = field.get(bean) == null ? "" : (String) field.get(bean);
				String fieldName=field.getName();
				data.put(columnName, new FieldInfo(fieldName,columnName,columnValue));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		metaData.setColumns(data);
		return metaData;
	}
	
	/**
	 * @author: wj
	 * @version:  v1
	 * @date:2018年1月6日 下午3:34:46
	 * @description:将map数据映射到bean中
	 * @param data :数据字段值
	 * @return
	 */
	protected BaseBean getBeanInstance(Map<String,String> data){
		Class<? extends BaseBean> clazz=bean.getClass();
		for(Map.Entry<String, String> entry:data.entrySet()){
			FieldInfo info=(FieldInfo) metaData.getColumns().get(entry.getKey());
			try {
				Field field=clazz.getDeclaredField(info.getFieldName());
				field.setAccessible(true);
				field.set(bean, entry.getValue());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return bean;
	}

	/**
	 * 子类必须重写此方法，注入自身
	 */
	protected abstract void setSelf();

	/**
	 * 构建sql,留给子类实现
	 */
	public abstract String generateSql(); /*{
		SQL sqlCreater=new SQL();
		sqlCreater.UPDATE(metaData.getTableName());
		for(Map.Entry entry:metaData.getColumns().entrySet()){
			sqlCreater.SET(entry.getKey()+"="+entry.getValue());
		}
		return "create sql..."+metaData.getTableName()+" "+metaData.getColumns()+"===="+sqlCreater.toString();
	}*/
}
