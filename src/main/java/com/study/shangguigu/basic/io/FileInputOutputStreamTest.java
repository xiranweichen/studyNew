package com.study.shangguigu.basic.io;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @description: 字节输入流FileInputStream && 字节输出流FileOutputStream
 * @date: 2020/4/12 15:02
 * @author: lizhenhong
 */
public class FileInputOutputStreamTest {

    /**
     * 实现对图片的复制操作
     * 读取本model下面的”截屏.jpg”并写入同目录的”截屏1.jpg”
     */
    @Test
    public void test() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File("截屏.jpg");
            File destFile = new File("截屏1.jpg");
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            byte[] buffer = new byte[6];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            System.out.println("图片复制成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
}
