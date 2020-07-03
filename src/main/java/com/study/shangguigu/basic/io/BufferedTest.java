package com.study.shangguigu.basic.io;

import org.junit.Test;

import java.io.*;

/**
 * @description: 处理流之缓冲流的使用
 * @date: 2020/4/12 16:51
 * @author: lizhenhong
 */
public class BufferedTest {

    /**
     * 用缓冲流实现图片的复制
     */
    @Test
    public void bufferedStreamTest() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1. 造文件
            File srcFile = new File("截屏.jpg");
            File destFile = new File("截屏2.jpg");
            //2. 造流的对象
            //2.1 首先要造节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //3. 复制
            byte[] buffer = new byte[5];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 关闭流操作(要求先关闭外层的流，再关闭内层的流)
            //说明：当外层的流关闭的时候，实际上程序会将其内层的流也关闭
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
//        fos.close();
//        fis.close();
        }
    }
    
}
