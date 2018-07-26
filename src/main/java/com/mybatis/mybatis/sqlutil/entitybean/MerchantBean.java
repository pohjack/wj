package com.mybatis.mybatis.sqlutil.entitybean;

import java.util.Map;

import com.mybatis.mybatis.sqlutil.SQL;
import com.mybatis.mybatis.sqlutil.annotation.DataMapping;
import com.mybatis.mybatis.sqlutil.basebean.AbstractBaseBean;
import com.mybatis.mybatis.sqlutil.basebean.BaseBean;
import com.mybatis.mybatis.sqlutil.basebean.FieldInfo;

/**
 * @author: wj
 * @version: v1
 * @date:2018年1月5日 上午10:29:10
 * @description:定义实体类，继承抽象父类AbstractBaseBean，重写setSelf()注入自身
 */
@DataMapping("b_merchant")
public class MerchantBean extends AbstractBaseBean {
	@DataMapping("merchant_id")
	private String merchantId;

	@DataMapping("merchant_name")
	private String merchantName;

	@DataMapping("brand")
	private String brand;

	public MerchantBean() {
		super();
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	protected void setSelf() {
		setBean(this);
	}

	@Override
	public String generateSql() {
		String tableName=getMetaData().getTableName();
		Map<String, Object> columns=getMetaData().getColumns();
		SQL sqlBuilder=new SQL();
		sqlBuilder.UPDATE(tableName).WHERE("table_pk_value=123");
		if(columns!=null && columns.size()>0){
			for(Map.Entry<String, Object> m :columns.entrySet()){
				FieldInfo f=(FieldInfo) m.getValue();
				sqlBuilder.SET(f.getAnnotationName()+"="+f.getFieldValue());
			}
			return sqlBuilder.toString();
		}else{
			return "";
		}
	}

	public static BaseBean getInstance(Map<String, String> data) {
		MerchantBean bean=new MerchantBean();
		return (MerchantBean)bean.getBeanInstance(data);
	}

	@Override
	public String toString() {
		return "MerchantBean [merchantId=" + merchantId + ", merchantName=" + merchantName + ", brand=" + brand + "]";
	}

}
