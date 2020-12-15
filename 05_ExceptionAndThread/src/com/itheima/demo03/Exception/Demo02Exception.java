package com.itheima.demo03.Exception;

/**
 * @date Created by 林春燕 on 2020/12/15 17:20
 * @微信公众号 浅悦的编程时光
 * @博客 https://nate-lin.gitee.io
 * @GitHub https://github.com/nate-lin
 * @Gitee https://gitee.com/nate-lin
 */
/*
    如果finally有return语句,永远返回finally中的结果，避免该情况
 */
public class Demo02Exception {
    public static void main(String[] args) {

    }
    //定义一个方法，返回变量a的值
    public static int getA(){
        int a=10;
        try {
            return a;
        }catch (Exception e){
            System.out.println(e);
        }finally {
            //一定会执行的代码
            a=100;
            return a;
        }
    }
}
