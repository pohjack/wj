package com.mybatis.helloworld;

import com.mybatis.helloworld.bean.Merchant;

public interface MerchantMapper {

	public Merchant selectMerchant(String merchant_id);
	
}
