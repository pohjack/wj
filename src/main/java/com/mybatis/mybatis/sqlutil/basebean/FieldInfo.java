package com.mybatis.mybatis.sqlutil.basebean;
/** 
 * @author: wj
 * @version:  v1
 * @date:2018年1月6日 上午11:31:30
 * @description:bean属性
 */
public class FieldInfo {
	private String fieldName;
	private String annotationName;
	private String fieldValue;
	public FieldInfo() {
		super();
	}
	
	public FieldInfo(String fieldName, String annotationName, String fieldValue) {
		super();
		this.fieldName = fieldName;
		this.annotationName = annotationName;
		this.fieldValue = fieldValue;
	}

	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getAnnotationName() {
		return annotationName;
	}
	public void setAnnotationName(String annotationName) {
		this.annotationName = annotationName;
	}
	public String getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
	@Override
	public String toString() {
		return "FieldInfo [fieldName=" + fieldName + ", annotationName=" + annotationName + ", fieldValue=" + fieldValue
				+ "]";
	}
	

}
