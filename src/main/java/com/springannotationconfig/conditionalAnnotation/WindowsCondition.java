package com.springannotationconfig.conditionalAnnotation;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/** 
 * @author: wj
 * @version:  v1
 * @date:2017年12月25日 下午3:42:19
 * @description:spring条件类，实现Condition接口
 */
public class WindowsCondition implements Condition {

	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		return context.getEnvironment().getProperty("os.name").contains("Windows");
	}

}
