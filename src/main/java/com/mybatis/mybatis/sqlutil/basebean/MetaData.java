package com.mybatis.mybatis.sqlutil.basebean;

import java.util.Map;

/**
 * @author: wj
 * @version: v1
 * @date:2018年1月5日 上午9:54:18
 * @description:元数据类，bean注解信息
 */
public class MetaData {
	private String tableName;
	private Map<String, Object> columns;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Map<String, Object> getColumns() {
		return columns;
	}

	public void setColumns(Map<String, Object> columns) {
		this.columns = columns;
	}

	@Override
	public String toString() {
		return "MetaData [tableName=" + tableName + ", columns=" + columns + "]";
	}
	
}
