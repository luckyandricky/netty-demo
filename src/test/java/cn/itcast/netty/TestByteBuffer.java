package cn.itcast.netty;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


@Slf4j
public class TestByteBuffer {
    public static void main(String [] args){
        try (FileChannel channel = new FileInputStream("data.txt").getChannel()) {

            ByteBuffer buffer = ByteBuffer.allocate(10);
           while(true){
               int len =  channel.read(buffer);
               log.debug("读取到的字节数{}",len);
               if(len==-1){
                   break;
               }
               //打印buffer内容
               buffer.flip();//切换读模式

               while(buffer.hasRemaining()){
                   byte b = buffer.get();
                   log.debug("实际字节{}",(char) b);
               }

               //切换到写模式
               buffer.clear();
           }


        } catch (IOException e) {
        }
    }
}
