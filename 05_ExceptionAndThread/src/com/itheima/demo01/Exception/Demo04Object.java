package com.itheima.demo01.Exception;

import java.util.Objects;

/**
 * @date Created by 林春燕 on 2020/12/13 22:59
 * @微信公众号 浅悦的编程时光
 * @博客 https://nate-lin.gitee.io
 * @GitHub https://github.com/nate-lin
 * @Gitee https://gitee.com/nate-lin
 */
/*
    Object类中的静态方法
    public static <T> T requireNonNull(T obj)`:查看指定引用对象不是null.
    源码：
        public static <T> T requireNonNull(T obj){
        if(obj==null)
            throw new NullPointerException();
        return obj;
        }
 */
public class Demo04Object {
    public static void main(String[] args) {
        method(null);
    }

    private static void method(Object obj) {
        //对传递过来的参数进行合法性判断，判断是否为null
       /*
        if(obj==null){
            throw new NullPointerException("传递的对象是null")
        }*/
        //Objects.requireNonNull(obj);
         Objects.requireNonNull(obj,"传递的对象是null");
    }

}
