package com.mybatis.mybatis.sqlutil;
/** 
 * @author: wj
 * @version:  v1
 * @date:2017年12月23日 下午2:48:15
 * @description:
 */
public class TestSql {
	public static void main(String[] args) {
		SQL sql=new SQL();
		sql.SELECT("bm.mall_id","bm.mall_name","bm.brand_id","bb.brand_name","bmf.flool_id","bmf.floor_name","af.file_location")
		.SELECT("bm.build_img")
		.FROM("b_mall bm")
		.LEFT_OUTER_JOIN("b_brand bb on bb.brand_id=bm.brand_id","b_mall_floor bmf on bmf.mall_id=bm.mall_id","attach_file af on af.file_id=bm.build_img")
		.WHERE("mall_id=? and bm.state='00A'");
		
		System.out.println(sql.toString());
		
	}
	

}
