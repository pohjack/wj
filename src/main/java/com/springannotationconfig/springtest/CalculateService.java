package com.springannotationconfig.springtest;

import org.springframework.stereotype.Service;

/** 
 * @author: wj
 * @version:  v1
 * @date:2017年12月25日 下午4:47:53
 * @description:
 */
@Service
public class CalculateService {
	
	public int add(int i,int j){
		return j+i;
	}
	
	public int sub(int i,int j){
		return i-j;
	}
	
}
