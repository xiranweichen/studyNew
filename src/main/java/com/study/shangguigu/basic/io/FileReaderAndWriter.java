package com.study.shangguigu.basic.io;

import org.junit.Test;

import java.io.*;

/**
 * @description: 
 * @date: 2020/4/8 17:11
 * @author: lizhenhong
 */
public class FileReaderAndWriter {

    /**
     * 将本model下面的hello.txt文件中的内容读取到程序中，并打印再控制台上
     * 说明：为了保证流资源一定执行关闭操作，要进行try/catch/finally操作
     *       要求读入的文件一定要存在，否则会抛FileNotFoundException
     * @throws IOException
     */
    @Test
    public void test() throws IOException {
        FileReader fr = null;
        try {
            //1. 实例化File对象并指明要操作的文件
            File file = new File("hello.txt"); //要求读入的文件一定要存在，否则会抛FileNotFoundException
            //2. 提供具体的流
            fr = new FileReader(file);
            //3. 数据的读入
            //read():返回读入的一个字符，如果达到了文件的末尾，则返回-1
            int read = fr.read();
            while (read != -1) {
                System.out.print((char) read);
                read = fr.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 关闭流(这个一定要有)
            if (fr != null) {
                fr.close();
            }
        }
    }

    /**
     * 对上面的read()方法的优化：用read(char[] cbuf)
     */
    @Test
    public void test1(){
        //1. 实例化File对象
        FileReader fr = null;
        try {
            File file = new File("hello.txt");
            //2. 实例化具体的流
            fr = new FileReader(file);
            //3. 读入的操作
            char[] cbuf = new char[4];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                //方式一：
//                for (int i = 0; i < len; i++) {
//                    System.out.print(cbuf[i]);  //lizhenhong
//                }
                //错误的写法(原因：这里的数组是赋值操作，当最后的字符少于len时，会有没赋值的元素被输出)
//                for (int i = 0; i < cbuf.length; i++) {
//                    System.out.print(cbuf[i]);  //lizhenhongho
//                }
                //方式二:用String()构造器
                String str = new String(cbuf, 0, len);
                System.out.print(str);  //lizhenhong
                //错误的写法(原因和方式一的错误写法类似)
//                String str = new String(cbuf);
//                System.out.print(str);   //lizhenhongho
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 关闭流
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 从内存中向硬盘的文件中写数据
     *  File对应的硬盘中的文件如果不存在，在输出的过程中会自动创建文件；
     *  File对应的硬盘中的文件如果存在：
     *      如果流使用的构造器是FileWriter(file, false)/Filewriter(file),会对原有文件进行覆盖；
     *      如果流使用的构造器是FileWriter(file, true)，不会对原有文件进行覆盖，会在原有内容后面追加。
     */
    @Test
    public void testFileWriter() {
        FileWriter fw = null;
        try {
            //1. 提供File类的对象(这里如果指明的文件不存在的话，程序会在相应的位置新建一个)
            File file = new File("hello1.txt");
            //2. 提供FileWriter对象，用于写数据
            fw = new FileWriter(file);
            //3. 写数据的操作
            fw.write("my name is lizhenhong!");
            fw.write("hello!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 关闭流的操作
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用FileReader和FileWriter实现文本文件的复制
     */
    @Test
    public void testReaderAndWriter() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            //1. 创建File类的对象，指明读入文件和写出文件
            File srcFile = new File("hello.txt");
            File destFile = new File("hello1.txt");
            //2. 创建输入流和输出流的对象
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);
            //3. 数据的读入和写出操作
            char[] cbuf = new char[5];
            int len;  //记录每次读入的数组中的字符的个数
            while ((len = fr.read(cbuf)) != -1) {
                //每次写出len个字符
                fw.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 关闭流的操作
            if (fr != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fw != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
}
