package com.mybatis.helloworld;

import org.apache.ibatis.annotations.Select;

import com.mybatis.helloworld.bean.Merchant;

public interface MerchantMapperAnnotation {
	
	@Select("select * from b_merchant where merchant_id=#{id}")
	public Merchant selectMerchant(String merchant_id);
	
}
