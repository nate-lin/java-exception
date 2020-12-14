package com.itheima.demo02.Exception;

import javax.security.auth.login.FailedLoginException;
import java.io.IOException;
import java.util.Arrays;

/**
 * @date Created by 林春燕 on 2020/12/14 19:42
 * @微信公众号 浅悦的编程时光
 * @博客 https://nate-lin.gitee.io
 * @GitHub https://github.com/nate-lin
 * @Gitee https://gitee.com/nate-lin
 */
/*
    try...catch:异常处理的第二种方式，自己处理异常
    格式：
        try{
            可能产生异常的代码
        }catch(){
            异常的处理逻辑，异常对象之后，怎么处理异常对象
            一般在工作中，会把异常的信息记录到一个日志中
        }
        ...
        catch(异常类名 变量名){

        }
     注意：
        1.try中可能会抛出多个异常对象，那么就可以使用多个catch来处理这些异常对象
        2.如果try中产生了异常，那么就会执行catch中异常处理逻辑，执行完try的代码，继续执行try...catch之后的代码
 */
public class Demo01TryCatch {
    public static void main(String[] args) {
        try {
            //可能产生异常的代码
            readFile("d:\\a.txt");
        //try中抛出什么异常对象，catch就定义什么异常变量，用来接收这个异常对象
        }catch (IOException e){
        //异常的处理逻辑，异常对象之后，怎么处理异常对象
            System.out.println("catch-传递的文件后缀不是.txt");
        }
        System.out.println("后续代码");
    }

    /*
        如果传递的路径不是txt结尾
        那么我们就抛出IO异常对象，告知方法的调用者，文件的后缀名不对
     */
    public static void readFile(String fileName) throws IOException{

        if (!fileName.endsWith(".txt")){
        throw new IOException("文件的后缀名不对");
    }
        System.out.println("路径没有问题，读取文件");
    }
}
