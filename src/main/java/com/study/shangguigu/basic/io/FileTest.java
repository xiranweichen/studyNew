package com.study.shangguigu.basic.io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @description: IO流之File类的使用
 * @date: 2020/4/6 15:13
 * @author: lizhenhong
 */
public class FileTest {

    //实例化(此时的各个file只是内存中的几个对象，还并没有涉及到硬盘)
    @Test
    public void test1() {
        //1. File(String pathName): 
        File file1 = new File("hello.txt"); //相对路径
        File file2 = new File("D:\\study\\day25_泛型与File\\hello.txt");  //绝对路径

        System.out.println(file1);  //hello.txt
        System.out.println(file2);  //D:\study\day25_泛型与File\hello.txt

        //File(String parentPath, String childPath): (parentPath:上一层目录, chilePath: 本层目录)
        File file3 = new File("D:\\study\\day25_泛型与File", "hello.txt");
        System.out.println(file3);  //D:\study\day25_泛型与File\hello.txt
        
        //File(File file, String childPath):
        File file4 = new File(file2, "hello.txt");
        System.out.println(file4);  //D:\study\day25_泛型与File\hello.txt\hello.txt
    }

    //常用方法
    @Test
    public void test2() {
        File file1 = new File("hello.txt");
        File file2 = new File("D:\\study\\day25_泛型与File");
        
        //获取绝对路径
        System.out.println(file1.getAbsolutePath()); //D:\work\work\shangxuetang\shangguigu.basic.duoxiancheng\hello.txt
        //获取路径
        System.out.println(file1.getPath());  //hello.txt
        //获取名称
        System.out.println(file1.getName());  //hello.txt
        //获取上层文件目录路径。如果没有则返回null
        System.out.println(file1.getParent()); //null
        //获取文件长度(字节数)，不能获取目录的长度
        System.out.println(file1.length());  //0
        //最后一次修改时间(毫秒值)
        System.out.println(file1.lastModified());  //0

        System.out.println("*****************************");
        System.out.println(file2.getAbsolutePath()); //D:\study\day25_泛型与File
        System.out.println(file2.getPath()); //D:\study\day25_泛型与File
        System.out.println(file2.getName());  //day25_泛型与File
        System.out.println(file2.getParent());  //D:\study
        System.out.println(file2.length());  //4096
        System.out.println(file2.lastModified());  //1579306381776

        //list(): 返回指定文件目录下的文件的文件名String类型数组(要求是这个路径必须存在，否则空指针)
        File file3 = new File("D:\\work\\work\\shangxuetang");
        String[] fileList = file3.list();
        for (String s : fileList) {
            System.out.print(s + ","); //.idea,shangguigu.basic.duoxiancheng,out,shangxuetang.iml,src,
        }
        System.out.println();
        
        //listFiles(): 以文件的绝对路径返回文件数组
        File[] files = file3.listFiles();
        for (File file : files) {
            System.out.print(file + ", ");  //D:\work\work\shangxuetang\.idea, D:\work\work\shangxuetang\shangguigu.basic.duoxiancheng, D:\work\work\shangxuetang\out, D:\work\work\shangxuetang\shangxuetang.iml, D:\work\work\shangxuetang\src,
        }
        System.out.println();
    }

    @Test
    public void test3() {
        //renameTo(File file): 把文件重命名为指定的文件路径(要想保证返回true，必须保证file1在硬盘中存在，file2不能在硬盘中存在)
        File file1 = new File("hello.txt");
        File file2 = new File("D:\\study\\day25_泛型与File\\hi.txt");
        boolean renameTo = file2.renameTo(file1);
        System.out.println(renameTo);  //true
    }

    @Test
    public void test4() {
        File file1 = new File("hello.txt");
        System.out.println(file1.isDirectory());  //false
        System.out.println(file1.isFile());  //true
        System.out.println(file1.exists());  //true
        System.out.println(file1.canRead());  //true
        System.out.println(file1.canWrite());  //true
        System.out.println(file1.isHidden());  //false
    }

    @Test
    public void test5() throws IOException {
        //创建、删除硬盘中对应的文件或目录(删除是不走回收站的)
        File file1 = new File("hi.txt");
        if (!file1.exists()) {
            //如果不存在，则创建这个文件
            file1.createNewFile();
            System.out.println("创建\"hi.txt\"成功");
        }else {
            //如果存在，将这个文件删除
            file1.delete();
            System.out.println("删除\"hi.txt\"成功");
        }
        
    }
    
    
}
