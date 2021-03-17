package com.itheima.demo06.Thread;

/**
 * @date Created by 林春燕 on 2021/3/17 22:30
 * @微信公众号 浅悦的编程时光
 * @博客 https://nate-lin.gitee.io
 * @GitHub https://github.com/nate-lin
 * @Gitee https://gitee.com/nate-lin
 */
//1.创建一个Thread类的子类
public class MyThread extends Thread{
    //2.在Thread类中的子类中重写Thread类中的run方法，设置线程任务（开启线程要做什么？）
    @Override
    public void run(){
        for (int i = 0; i <10 ; i++) {
            System.out.println("run:"+i);
            
        }
    }
}
