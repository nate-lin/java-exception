package com.itheima.demo01.Exception;

/**
 * @date Created by 林春燕 on 2020/11/27 20:26
 * @微信公众号 浅悦的编程时光
 * @博客 https://nate-lin.gitee.io
 * @GitHub https://github.com/nate-lin
 * @Gitee https://gitee.com/nate-lin
 */

public class Demo02Exception {
    public static void main(String[] args) {
        //创建int类型的数组，并赋值
        int[] arr = {1, 2, 3};
        //访问了数组的3索引，而数组是没有3索引的，这时候JVM就会检测出程序会出现异常
        //JVM会做两件事情：
        //  1.JVM会根据异常产生的原因创建一个异常对象，这个异常对象包含了异常产生的（内容，原因，位置）
        //      new ArrayIndexOutOfBoundsException("3");
        //  2.在getElement方法中，没有异常的处理逻辑（try…catch），那么JVM就会把异常对象抛出给方法的调用者main方法来处理这个异常。
        //    main方法接收到了这个异常对象new ArrayIndexOutOfBoundsException(“3”)，
        //    main方法也没有异常的处理逻辑继续把对象抛出给main方法的调用者JVM来处理。
        //**JVM再一次接收到这个异常对象，做了两件事情。**
        //JVM接收到了这个异常new ArrayIndexOutOfBoundsException(“3”)
        //  1.把异常对象（内容，原因，位置）以红色的字体打印到控制台。
        //  2.JVM会终止当前正在执行的JAVA程序–>中断处理。
        int e = getElement(arr, 3);
        System.out.println(e);
    }
        /**
         * 定义一个方法，获取数组指定索引的元素
         * 参数：
         *  int[] arr
         *  int index
         */
    public static int getElement(int[] arr, int index) {
        int ele=arr[index];
        return ele;
    }
}
