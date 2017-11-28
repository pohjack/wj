package mybatis.sql;

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
		.SELECT("brand_id,merchant_type")
		.WHERE("state=?")
		.FROM("b_merchant");
		return sql.toString();
	}
	public static void main(String[] args) {
		SqlProvider provider=new SqlProvider();
		String sql=provider.getMerchantSql();
		System.out.println(sql);
	}
}
