package com.itheima.demo05.Thread;

/**
 * @date Created by 林春燕 on 2021/2/9 23:16
 * @微信公众号 浅悦的编程时光
 * @博客 https://nate-lin.gitee.io
 * @GitHub https://github.com/nate-lin
 * @Gitee https://gitee.com/nate-lin
 */

import java.util.Arrays;

/**
 *  主线程：执行主（main）方法的线程
 *
 *  单线程程序：java程序中只有一个线程
 *  执行从main方法开始，从上到下依次执行
 *
 *  JVM执行main方法，main方法会进入到栈内存
 * JVM会栈操作系统开辟一条main方法通向cpu的执行路径
 * cpu就可以通过这个路径来执行main方法
 * 而这个路径有一个名字叫main（主）线程
 */

public class Demo01MainThread {
    public static void main(String[] args) {
        Person p1=new Person("浅悦");
        p1.run();
        System.out.println(0/0);//ArithmeticException: / by zero
        //出现异常时，后面的“林春燕”不能执行，这就是单线程。
        Person p2=new Person("林春燕");
        p2.run();
    }
}
