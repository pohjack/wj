package com.springannotationconfig.springtest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springannotationconfig.JavaConfig;

/** 
 * @author: wj
 * @version:  v1
 * @date:2017年12月25日 下午4:50:16
 * @description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={JavaConfig.class})
@ActiveProfiles("dev")
public class SpringJunitTest {
	
	@Autowired
	private CalculateService service;
	
	@Test
	public void testAdd(){
		int result=service.add(1, 5);
		Assert.assertEquals(6, result);
	}
	
	@Test
	public void testSub(){
		int result=service.add(8, 5);
		Assert.assertEquals(3, result);
	}
}
