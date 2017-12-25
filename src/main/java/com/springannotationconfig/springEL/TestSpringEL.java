package com.springannotationconfig.springEL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author: wj
 * @version: v1
 * @date:2017年12月23日 上午10:31:17
 * @description:springEL与资源注入
 */
@Component
public class TestSpringEL {

	@Value("${jdbc.username}") // 注入property文件中配置的属性
	private String jdbcUserName;

	@Value("${jdbc.password}")
	private String jdbcPassword;

	@Value("${jdbc.url}")
	private String url;

	@Value("${jdbc.driver}")
	private String driver;

	// @Value("#{systemPropertis['os.name']}") //注入系统变量
	// private String osName;

	@Value("#{tbean.desc}") // 注入bean的属性值
	private String beanProperty;

	@Autowired // 注入spring环境配置
	private Environment env;

	@Override
	public String toString() {
		return "TestSpringEL [jdbcUserName=" + jdbcUserName + ", jdbcPassword=" + jdbcPassword + ", url=" + url
				+ ", driver=" + driver + ", beanProperty=" + beanProperty + " " + "env.systemProperties=" + env + "]";
	}
}
