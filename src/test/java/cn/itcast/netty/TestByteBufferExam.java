package cn.itcast.netty;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class TestByteBufferExam {
    public static void main(String[] args) {
        /*
        网络有多条数据发送给服务器，数据之间使用\n 进行分离
        但由于某种原因，这些数据接收时，被进行重新组合，例如原始数据有3条
        hello world\n
        i`m zhangsan\n
        how are you\n
        变成了下面两个 bytebuffer(黏包，半包)
        hello world\ni`m zhangsan\nho
        w are you\n
        * */
        ByteBuffer source = ByteBuffer.allocate(32);
        source.put("hello,world\ni`m zhangsan\nho".getBytes());
        split(source);
        source.put("w are you\n".getBytes());
        split(source);

    }

    public static void split(ByteBuffer source ){
        source.flip();
        for (int i=0 ;i<source.limit();i++){
            //找到完整消息
            if(source.get(i) == '\n')
            {
                int length = i + 1 - source.position();
                //将完整空间存入新的Bytebuffer
                ByteBuffer target = ByteBuffer.allocate(length);
                //从source向target写
                for (int j =0 ;j<length;j++){
                    target.put(source.get());
                }
                System.out.println(target);
            }

        }
        source.compact();

    }
}
