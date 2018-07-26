package com.mybatis.mybatis.sqlutil;

import java.util.HashMap;
import java.util.Map;

import com.mybatis.mybatis.sqlutil.entitybean.MerchantBean;

/** 
 * @author: wj
 * @version:  v1
 * @date:2017年12月23日 下午2:48:15
 * @description:基于vo对象，实现增删改查，动态拼接sql(SQL工具类)，VOUtils(vo工具类)  
 */
public class TestSql {
	public static void main(String[] args) {
		/*SQL sql=new SQL();
		sql.SELECT("bm.mall_id","bm.mall_name","bm.brand_id","bb.brand_name","bmf.flool_id","bmf.floor_name","af.file_location")
		.SELECT("bm.build_img")
		.FROM("b_mall bm")
		.LEFT_OUTER_JOIN("b_brand bb on bb.brand_id=bm.brand_id","b_mall_floor bmf on bmf.mall_id=bm.mall_id","attach_file af on af.file_id=bm.build_img")
		.WHERE("mall_id=? and bm.state='00A'");
		System.out.println(sql.toString());*/
		
		MerchantBean bean=new MerchantBean();
		System.out.println(bean.generateSql());
		Map data=new HashMap();
		data.put("merchant_id", "1000");
		data.put("merchant_name", "肯德基");
		data.put("brand", "34");
		MerchantBean bean1=(MerchantBean) MerchantBean.getInstance(data);
		bean1.setBrand("34");
		bean1.setMerchantId("1234");
		bean1.setMerchantName("肯德基");
		System.out.println(bean1);
		System.out.println(bean1.generateSql());
	}
	

}
