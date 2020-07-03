package com.study.shangguigu.basic.tcp;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: lizhenhong
 * @description: 从客户端发送文件给服务端，服务端保存到本地，然后返回"保存成功"给客户端，并关闭相应的连接
 * @date: 2020/4/19 16:48
 */
public class TcpTest2 {

    /**
     * 客户端
     */
    @Test
    public void testCliect() {
        Socket socket = null;
        OutputStream outputStream = null;
        FileInputStream fis = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
            outputStream = socket.getOutputStream();
            fis = new FileInputStream("截屏.jpg");
            byte[] buffer = new byte[1024];
            int len;
            //这里的.read()方法是一个线程阻塞的方法，需要给它一个明确的指示才能停止，否则会一直在这个循环里
            while ((len = fis.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }
            //图片文件传输完成后，关闭图片的输出
            socket.shutdownOutput();

            //客户端接收服务端你的反馈并显示到控制台上
            is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] bytes = new byte[24];
            int len1;
            while ((len1 = is.read(bytes)) != -1) {
                baos.write(bytes, 0, len1);
            }
            System.out.print(baos.toString());  //图片传输完成
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
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
     * 服务器端
     */
    @Test
    public void testServer() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        OutputStream os = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            serverSocket = new ServerSocket(9090);
            socket = serverSocket.accept();
            is = socket.getInputStream();
            fos = new FileOutputStream("截屏3.jpg");
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            System.out.println("服务端图片传输完成");  //服务端图片传输完成
            //服务端给予客户端反馈
            os = socket.getOutputStream();
            os.write("图片传输完成".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
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
