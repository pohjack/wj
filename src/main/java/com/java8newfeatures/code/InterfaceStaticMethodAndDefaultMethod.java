package com.java8newfeatures.code;

/**
 * java8新特性-接口默认方法和静态方法
 * @author wj
 */
public interface InterfaceStaticMethodAndDefaultMethod {

    /**
     * 接口默认方法的“类优先原则”
     * 1、选择父类中的方法。如果一个父类提供了具体的实现，那么接口中具有相同名称和参数的默认方法会被忽略
     * 2、接口冲突。如果一个父接口提供一个默认方法，而另一个接口也提供了一个具有相同名称和参数列表的方法（不管方法
     * 是否是默认方法），那么必须覆盖该方法来解决冲突
     */

    String getName();

    /**
     * 接口默认方法
     *
     * @return
     */
    default String getAddress() {
        return "广州";
    }

    /**
     * 接口静态方法
     * @return
     */
    static String desc(){
        return "接口静态方法";
    }

}