package cn.itcast.netty;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class TestBufferString {
    public static void main(String[] args) {
        //字符串转换为ByteBuffer
        ByteBuffer buffer = ByteBuffer.allocate(16);
        buffer.put("hello".getBytes());
        buffer.flip();

        System.out.println((char) buffer.get());

        //ChaeSet
        ByteBuffer buffer2 = StandardCharsets.UTF_8.encode("hello");
        System.out.println((char)buffer2.get());
        System.out.println(buffer2);

        //wrap   NIO提供的工具类，用于字节数组与字符串之间转换
        ByteBuffer buffer3 = ByteBuffer.wrap("hello".getBytes());
        System.out.println((char) buffer.get());

        String str1 = StandardCharsets.UTF_8.decode(buffer2).toString();
        System.out.println(str1);
//        byte [] a = "hello".getBytes();
//        for (byte a1 : a){
//            System.out.println((char)a1);
//        }

    }
}
