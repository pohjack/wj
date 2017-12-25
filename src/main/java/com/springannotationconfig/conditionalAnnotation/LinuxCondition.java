package com.springannotationconfig.conditionalAnnotation;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/** 
 * @author: wj
 * @version:  v1
 * @date:2017年12月25日 下午3:44:42
 * @description:
 */
public class LinuxCondition implements Condition {
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		return context.getEnvironment().getProperty("os.name").contains("windows");
	}
}
