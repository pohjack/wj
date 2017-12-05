package com.mybatis.mybatis.sql;

import org.apache.ibatis.jdbc.SQL;


/**
 * mybatis  sql构建类
 * @author wj
 *
 */
public class SqlProvider {

	public String getMerchantSql(){
		/*return new SQL(){{
			SELECT("merchant_id,merchant_name");
			SELECT("brand_id,merchant_type");
			WHERE("state=?");
			FROM("b_merchant");
		}}.toString();*/
		SQL sql=new SQL();
		sql.SELECT("merchant_id,merchant_name")
		.SELECT("b.brand_id,merchant_type")
		.WHERE("state=?")
		.WHERE("brand_id=?")
		.FROM("b_merchant m")
		.FROM("b_brand b").WHERE("m.brand_id=b.brand_id");
		return sql.toString();
	}
	public static void main(String[] args) {
		SqlProvider provider=new SqlProvider();
		String sql=provider.getMerchantSql();
		System.out.println(sql);
	}
}
