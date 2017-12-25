package com.springannotationconfig.conditionalAnnotation;
/** 
 * @author: wj
 * @version:  v1
 * @date:2017年12月25日 下午3:46:17
 * @description:
 */
public class LinuxService implements IService {

	public void doExecute() {
		System.err.println("this is linux service");
		
	}

}
