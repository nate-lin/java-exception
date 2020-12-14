# Java-异常的处理

- Java异常处理的五个关键字：**try、catch、finally、throw、throws**

### 1.1、抛出异常throw

> 在编写程序时，我们必须要考虑程序出现的情况。比如，在定义方法时，方法需要接受参数。那么，当调用方法接受的参数时，首先需要先对参数数据进行合法的判断，数据若不合法，就应该告诉调用者，传递合法的数据进来。这时需要使用抛出异常的方式告诉调用者。

<!-- more -->

在java中，提供一个throw关键字，它用来抛出一个指定的异常对象。那么，一个抛出异常具体如何操作呢？

- 创建一个异常对象。封装一些提示信息（信息内容可以自己编写）。
- 需要将这个异常对象告知给调用者。怎么告知呢？怎么将这个异常对象传递到调用者呢?通过关键字throw就可以完成。throw异常对象。

> throw用在方法内，用来抛出一个异常对象，将这个异常对象传递到调用者处，并结束当前方法的执行。

**使用格式：**

```java
throw new 异常类名(参数);
```

例如：

**传递的数组的值是null**

```java
package com.itheima.demo01.Exception;

import java.util.Arrays;

/**
 * @date Created by 林春燕 on 2020/12/13 21:51
 * @微信公众号 浅悦的编程时光
 * @博客 https://nate-lin.gitee.io
 * @GitHub https://github.com/nate-lin
 * @Gitee https://gitee.com/nate-lin
 */

/*
    throw关键字
    作用：
        可以使用throw关键字在指定的方法中抛出指定的异常
    使用格式：
        throw new xxxException("异常产生的原因");
    注意：
        1.throw关键字必须写在方法内部
        2.throw关键字后边new的对象必须是Exception或者Exception的子类对象
        3.throw关键字抛出指定的异常对象，我们就必须处理这个异常对象
            throw关键字后边创建的是RuntimeException或者是RuntimeExcetion的子类对象，
            我们可以不处理，默认交给JVM处理（打印异常对象，中断程序）
            throw关键字后创建的是编程异常（写代码的时候报错），我们就必须处理这个异常。要么throws,要么try...catch
 */
public class Demo03Throw {
    public static void main(String[] args) {
        int[] arr=null;
       int e=getElement(arr,0);
        System.out.println(e);
    }
    /**
     * 定义一个方法，获取数组指定索引的元素
     * 参数：
     *  int[] arr
     *  int index
     *  以后（工作中）我们首先必须对方法传递过来的参数进行合法性的校验
     *  如果参数不合法。那么我们就必须使用抛出异常的方式，告知方法的调用者，传递的参数有问题
     */
    public static int getElement(int[] arr, int index) {
        /*
            我们可以对传递过来的参数数组，进行合法性校验
            如果数组arr的值是null
            那么我们就抛出空指针异常，告知方法的调用者“传递的数组的值null”
         */
        if (arr==null){
            throw new NullPointerException("传递的数组的值是null");
        }
        int ele=arr[index];
        return ele;
    }
}

```

运行效果图

![image-20201213221130986](http://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20201213221130986.png)

**传递的索引超出了数组的使用范围**

```java
package com.itheima.demo01.Exception;

import java.util.Arrays;

/**
 * @date Created by 林春燕 on 2020/12/13 21:51
 * @微信公众号 浅悦的编程时光
 * @博客 https://nate-lin.gitee.io
 * @GitHub https://github.com/nate-lin
 * @Gitee https://gitee.com/nate-lin
 */

/*
    throw关键字
    作用：
        可以使用throw关键字在指定的方法中抛出指定的异常
    使用格式：
        throw new xxxException("异常产生的原因");
    注意：
        1.throw关键字必须写在方法内部
        2.throw关键字后边new的对象必须是Exception或者Exception的子类对象
        3.throw关键字抛出指定的异常对象，我们就必须处理这个异常对象
            throw关键字后边创建的是RuntimeException或者是RuntimeExcetion的子类对象，
            我们可以不处理，默认交给JVM处理（打印异常对象，中断程序）
            throw关键字后创建的是编程异常（写代码的时候报错），我们就必须处理这个异常。要么throws,要么try...catch
 */
public class Demo03Throw {
    public static void main(String[] args) {
        //int[] arr=null;
        int[] arr=new int[3];

        int e=getElement(arr,3);
        System.out.println(e);
    }
    /**
     * 定义一个方法，获取数组指定索引的元素
     * 参数：
     *  int[] arr
     *  int index
     *  以后（工作中）我们首先必须对方法传递过来的参数进行合法性的校验
     *  如果参数不合法。那么我们就必须使用抛出异常的方式，告知方法的调用者，传递的参数有问题
     *  注意：
     *      NullPointerException是一个运行异常，我们不用处理，默认交给JVM处理
     */
    public static int getElement(int[] arr, int index) {
        /*
            我们可以对传递过来的参数数组，进行合法性校验
            如果数组arr的值是null
            那么我们就抛出空指针异常，告知方法的调用者“传递的数组的值null”
         */
        if (arr==null){
            throw new NullPointerException("传递的数组的值是null");
        }
        /*
            我们可以对传递过来的参数数组，进行合法性校验
            如果数组arr的值是null
            那么我们就抛出索引越界异常，告知方法的调用者“传递的索引超出了数组的使用范围”
         */
        if (index<0||index>arr.length-1){
            throw new ArrayIndexOutOfBoundsException("传递的索引超出了数组的使用范围");
        }
        int ele=arr[index];
        return ele;
    }
}

```

运行效果图

![image-20201213221949000](http://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20201213221949000.png)



### 1.2、Object非空判断

> 还记得我们学习过一个类Object吗,曾经提过它由一些静态的实用方法组成，这些方法是null-save(空指针安全的)或者null-tolerant(容忍空指针的)，那么在它的源码中，对对象为null的值进行了抛出异常操作。

- `public static <T> T requireNonNull(T obj)`:查看指定引用对象不是null.

查看源码发现这里对null的进行了抛出异常操作：

```java
public static <T> T requireNonNull(T obj){
    if(obj==null)
        throw new NullPointerException();
    return obj;
}
```

Object非空判断的代码演示

```java
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

```

运行效果图

![image-20201213231123279](http://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20201213231123279.png)

### 1.3、声明异常throws

**声明异常**：将问题标识出来，报告给调用者。如果方法内通过throw抛出了编译时异常，而没有捕获处理，那么必须通过throws进行声明，让调用者去处理。

关键字**throws**运用于方法声明之上，用于表示当前方法不处理异常，而是提醒该方法的调用者来处理异常（抛出异常）。

**声明异常格式：**

```java
修饰符 返回值 方法名（参数） throws 异常类名1，异常类名2...{}
```

声明异常的代码演示：

```java
package com.itheima.demo01.Exception;

import javax.security.auth.login.FailedLoginException;
import java.io.IOException;

/**
 * @date Created by 林春燕 on 2020/12/14 15:09
 * @微信公众号 浅悦的编程时光
 * @博客 https://nate-lin.gitee.io
 * @GitHub https://github.com/nate-lin
 * @Gitee https://gitee.com/nate-lin
 */
/*
    throws关键字：异常处理的第一种方式，交给别人处理
    作用：
        当方法内部异常对象的时候，那么我们就必须处理这个异常
        可以使用throws关键字处理异常对象，会把异常对象声明抛出给方法的调用者处理
        （自己不处理，给别处理），最终交给JVM处理-->中断处理
        使用格式：在方法声明时使用
            修饰符 返回值类型 方法名（参数列表） throws AAAException,BBBException...{
                throws new AAAException("产生原因");
                throws new AAAException("产生原因");
                ...
            }
         注意：
            1.throws关键字必须写在方法声明处
            2.throws关键字后面声明的异常必须是Exception或者是Exception的子类
            3.方法内部如果抛出了多个异常对象，那么throws后面必须也声明多个异常
                如果抛出了多个异常对象有父类关系，那么直接声明父类异常即可
            4.调用了一个声明抛出异常的方法，我们就必须的处理声明的异常
                要么继续使用throws声明抛出，交给方法的调用者处理，最终交给JVM
                要么try...catch自己处理异常
 */
public class Demo05Throws {
    /*
        FailedLoginException extends IOException
        如果抛出的多个异常对象有子父类关系，那么直接声明父类异常即可
     */
    //public static void main(String[] args) throws FailedLoginException ,IOException{
    public static void main(String[] args) throws Exception{
        readFile("c:\\a.txt");
    }


    /*
    定义一个方法，对文件的路径进行合法判断
    如果路径不是“c:\\a.txt”,那么我们就抛出文件找不到异常对象，告知方法的调用者
     注意：
       FailedLoginException 是编译异常，抛出了编译异常，就必须处理这个异常
       可以使用throws继续声明抛出FailedLoginException这个异常对象，让方法的调用者处理
     */
    private static void readFile(String fileName) throws FailedLoginException ,IOException{

        if (!fileName.equals("c:\\a.txt")){
            throw new FailedLoginException("传递的文件路径不是c:\\a.txt");
        }
        /*
            如果传递的路径不是txt结尾
            那么我们就抛出IO异常对象，告知方法的调用者，文件的后缀名不对
         */
        if (!fileName.equals(".txt")){
            throw new IOException("文件的后缀名不对");
        }

        System.out.println("路径没有问题，读取文件");
    }
}

```

运行效果图

![image-20201214184917621](http://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20201214184917621.png)



