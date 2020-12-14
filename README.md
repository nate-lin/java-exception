

## Java-异常的处理

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
    public static void readFile(String fileName) throws FailedLoginException ,IOException{

        if (!fileName.equals("d:\\a.txt")){
            throw new FailedLoginException("传递的文件路径不是c:\\a.txt");
        }
        /*
            如果传递的路径不是txt结尾
            那么我们就抛出IO异常对象，告知方法的调用者，文件的后缀名不对
         */
        if (!fileName.endsWith(".txt")){
            throw new IOException("文件的后缀名不对");
        }

        System.out.println("路径没有问题，读取文件");
    }
}

```

运行效果图

![image-20201214202034961](http://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20201214202034961.png)

### 1.4、捕获异常try...catch

> - try中可能会抛出多个异常对象，那么就可以使用多个catch来处理这些异常对象
> - 如果try中产生了异常，那么就会执行catch中异常处理逻辑，执行完try的代码，继续执行try...catch之后的代码

try...catch的代码演示：

```java
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

```

运行效果图

![image-20201214202150771](http://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20201214202150771.png)



### 1.5、Throwable

如何获取异常信息：

Throwable类中定义了一些查看方法：

- `public String getMessage()`:获取异常的描述信息，原因（提示给用户的时候，就提示错误原因）
- `public String toString()`:获取异常的类型和描述信息（不用）
- `public void printStackTrace()`:打印异常的跟踪栈信息并输出到控制台。

包含了异常的类型，异常的原因还包括异常出现的位置，在开发和调试阶段都得使用printStackTrace。在开发中呢，也是可以在catch将编译期异常转换运行期异常处理

多个异常使用捕获又该如何处理呢？

- 1.多个异常分别处理

- 2.多个异常一次捕获一次处理

- 3.多个异常一次捕获，多次处理

代码如下：

```java
package com.itheima.demo02.Exception;

import javax.security.auth.login.FailedLoginException;
import java.io.IOException;
import java.sql.SQLOutput;
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
            readFile("d:\\a.tx");
        //try中抛出什么异常对象，catch就定义什么异常变量，用来接收这个异常对象
        }catch (IOException e){
        //异常的处理逻辑，异常对象之后，怎么处理异常对象
            // System.out.println("catch-传递的文件后缀不是.txt");
        /*
            Throwable类中定义了3个异常处理的方法
                String getMessage() 返回此throwable的简短描述
                String toString() 返回此throwable的详细消息字符串
                void printStackTrace() JVM打印异常对象，默认此方法，打印的异常信息是最全面的
        */
            System.out.println(e.getMessage());//文件的后缀名不对
            System.out.println(e.toString());//java.io.IOException: 文件的后缀名不对
            System.out.println(e);//java.io.IOException: 文件的后缀名不对

            /*
                java.io.IOException: 文件的后缀名不对
            	at com.itheima.demo02.Exception.Demo01TryCatch.readFile(Demo01TryCatch.java:62)
            	at com.itheima.demo02.Exception.Demo01TryCatch.main(Demo01TryCatch.java:36)
             */
            e.printStackTrace();
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

```

运行效果图

![image-20201214205639479](http://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20201214205639479.png)



### 1.6、finally代码块

**finally**：有一些特定的代码无论异常是否发生，都需要执行。另外，因为异常会引发程序跳转，导致有些语句执行不到。而finally代码块中存放的代码都是一定会执行的。

什么时候的代码必须最终执行？

当我们在try语句中打开了一些物理资源（磁盘文件/网络连接/数据库连接等），我们都得在使用完之后，最终关闭打开的资源。

finally的语法：

try...catch...finally:自身需要处理异常，最终还得关闭资源。

> 注意：finally不能单独使用

比如在我们之后学习的IO流中，当打开了一个关联文件的资源，最后程序不管结果如何，都需要把这个资源关闭掉

finally代码参考如下：

```java
package com.itheima.demo02.Exception;

import java.io.IOException;
import java.util.Arrays;

/**
 * @date Created by 林春燕 on 2020/12/14 21:09
 * @微信公众号 浅悦的编程时光
 * @博客 https://nate-lin.gitee.io
 * @GitHub https://github.com/nate-lin
 * @Gitee https://gitee.com/nate-lin
 */

/*
    finally代码块
    格式：
        try{
            可能产生异常的代码
        }catch(){
            异常的处理逻辑，异常对象之后，怎么处理异常对象
            一般在工作中，会把异常的信息记录到一个日志中
        }
        ...
        catch(异常类名 变量名){

        }finally{
            无论是否出现异常都会执行
        }
       注意：
        1.finally不能单独使用，必须和try一起使用
        2.finally一般用于资源释放（资源回收），无论程序是否出现异常，最后都要资源释放（IO）
 */
public class Demo02TryCatchFinally {
    public static void main(String[] args) {
        try {
            //可能会产生异常的代码
            readFile("c:\\a.tx");
        } catch (IOException e) {
            //异常的处理逻辑
            e.printStackTrace();
        }finally {
            //无论是否出现异常，都会执行
            System.out.println("资源释放");
        }
    }
    /*
           如果传递的路径不是txt结尾
           那么我们就抛出IO异常对象，告知方法的调用者，文件的后缀名不对
        */
    public static void readFile(String fileName) throws IOException {

        if (!fileName.endsWith(".txt")){
            throw new IOException("文件的后缀名不对");
        }
        System.out.println("路径没有问题，读取文件");
    }
}

```

运行效果图

![image-20201214211821401](http://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20201214211821401.png)



### 1.7、异常注意事项

- 多个异常使用捕获又该如何处理呢？

  - 1.多个异常分别处理

  - 2.多个异常一次捕获一次处理

  - 3.多个异常一次捕获，多次处理

一般我们是使用一次捕获多次处理方式，格式如下：

```java
try{
    编写可能会出现异常的代码
}catch(异常类型A e){	当try中出现A类异常，就用该catch来捕获。
    处理异常的代码
    //记录日志/打印异常信息/继续抛出异常
}catch(异常类型B e){	当try中出现B类异常，就用该catch来捕获。
    处理异常的代码
    //记录日志/打印异常信息/继续抛出异常
}
```

> 注意：这种异常处理方式，要求多个catch中的异常不能相同，并且若catch中的多个异常之间有子父类异常的关系，那么子类异常要求在上面的catch处理，父类异常在下面的catch处理。

- 运行时异常被抛出可以不处理。即不捕获也不声明抛出。
- 如果父类抛出了多个异常，子类覆盖父类方法时，只能抛出相同的异常或者是他的子集。
- 父类方法没有抛出异常，子类覆盖父类该方法时也不可抛出异常。此时子类产生该异常，只能捕获处理，不能声明抛出。
- 在try/catch后可以追加finally代码块，其中的代码一定会执行，通常用于资源回收。
- 如果finally有return语句，永远返回finally中的结果，避免该情况。