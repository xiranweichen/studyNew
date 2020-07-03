package com.study.shangguigu.basic.tcp;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: lizhenhong
 * @description: 网络编程之TCP协议
 * @date: 2020/4/19 16:05
 */
public class TcpTest {

    /**
     * 客户端(后启动)
     */
    @Test
    public void testCliect(){
        Socket socket = null;
        OutputStream stream = null;
        try {
            //1. 创建socket对象，指明服务器端的ip和端口号
            InetAddress address = InetAddress.getByName("127.0.0.1");
            socket = new Socket(address, 8899);
            //2. 获取输出流用于输出数据
            stream = socket.getOutputStream();
            //3. 写数据
            stream.write("lizhenhong".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 关闭outputStream && Socket资源
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 服务端(要先启动)
     */
    @Test
    public void testServer() {

        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        ByteArrayOutputStream baos = null;
        try {
            //1. 创建ServerSocket对象，指明自己的端口号
            serverSocket = new ServerSocket(8899);
            //2. 接收来自客户端的请求
            socket = serverSocket.accept();
            //3. 获取输入流
            inputStream = socket.getInputStream();
            //显示到控制台
            //不建议这么写，因为在utf8中，汉字占三个字节
//        byte[] buffer = new byte[20];
//        int len;
//        if ((len = inputStream.read(buffer)) != -1) {
//            String str = new String(buffer, 0, len);
//            System.out.print(str);
//        }
            //可以用下面的这个类来做
            //4. 读取输入流中的数据
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                //这样写的话，baos会将所有字符进行拼接，暂时写到ByteArrayOutputStream类中，
                baos.write(buffer, 0, len);
            }
            System.out.print(baos.toString());  //lizhenhong
            System.out.println();
            System.out.println("收到了来自于：" + socket.getInetAddress().getHostAddress() + "的数据"); //收到了来自于：127.0.0.1的数据
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5. 关闭资源
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
