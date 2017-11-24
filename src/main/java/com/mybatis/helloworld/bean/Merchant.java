package com.mybatis.helloworld.bean;

import org.apache.ibatis.type.Alias;

@Alias("mm")
public class Merchant {
	private String merchant_id;
	private String brand_id;
	private String merchant_name;
	private String merchant_type;
	private String area_id;
	public String getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(String merchant_id) {
		this.merchant_id = merchant_id;
	}
	public String getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(String brand_id) {
		this.brand_id = brand_id;
	}
	public String getMerchant_name() {
		return merchant_name;
	}
	public void setMerchant_name(String merchant_name) {
		this.merchant_name = merchant_name;
	}
	public String getMerchant_type() {
		return merchant_type;
	}
	public void setMerchant_type(String merchant_type) {
		this.merchant_type = merchant_type;
	}
	public String getArea_id() {
		return area_id;
	}
	public void setArea_id(String area_id) {
		this.area_id = area_id;
	}
	@Override
	public String toString() {
		return "Merchant [merchant_id=" + merchant_id + ", brand_id=" + brand_id + ", merchant_name=" + merchant_name
				+ ", merchant_type=" + merchant_type + ", area_id=" + area_id + "]";
	}
	
	
	
}
