package com.itheima.demo04.MyException;

/**
 * @date Created by 林春燕 on 2021/2/7 21:57
 * @微信公众号 浅悦的编程时光
 * @博客 https://nate-lin.gitee.io
 * @GitHub https://github.com/nate-lin
 * @Gitee https://gitee.com/nate-lin
 */
/*
    自定义异常类：
        java提供的异常类，不够我们使用，需要自己自定义一些异常类
    格式：
        public class xxxException extends Exception | RuntimeException{
            添加一个空函数的构造方法
            添加一个带异常信息的构造方法
        }
     注意：
        1.自定义异常一般都是以Exception结尾。说明类是一个异常类
        2.自定义异常类，必须的继承Exception或者RuntimeException
            继承Exception：那么自定义的异常类就是一个运行期异常，无需处理，交给虚拟机处理（中断处理）
*/

public class RegisterException extends /*Exception*/RuntimeException{
    //添加一个空参数的构造方法
    public RegisterException(){
        super();
    }

/*
    添加一个带异常信息的构造方法
    查看源码发现，所有的异常类都会一个带有异常信息的构造方法，方法内部会调用父类带异常信息的构造方法，让父类来处理这个异常信息
*/
    public RegisterException(String message){
        super(message);
    }
}



