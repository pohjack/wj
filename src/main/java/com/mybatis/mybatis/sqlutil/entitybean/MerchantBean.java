package com.mybatis.mybatis.sqlutil.entitybean;

import java.util.Map;

import com.mybatis.mybatis.sqlutil.annotation.DataMapping;
import com.mybatis.mybatis.sqlutil.basebean.AbstractBaseBean;
import com.mybatis.mybatis.sqlutil.basebean.BaseBean;

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
		return getMetaData().getTableName()+"==="+getMetaData().getColumns();
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
