package com.mybatis.mybatis.bean;

public class ProductCode {
	
	private Integer codeId;
	private String productId;
	private String code;
	private String shortUrl;
	public Integer getCodeId() {
		return codeId;
	}
	public void setCodeId(Integer codeId) {
		this.codeId = codeId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getShortUrl() {
		return shortUrl;
	}
	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}
	@Override
	public String toString() {
		return "ProductCode [codeId=" + codeId + ", productId=" + productId + ", code=" + code + ", shortUrl="
				+ shortUrl + "]";
	}
	
	
	
	

}
