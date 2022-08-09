package cn.itcast.netty;

import java.nio.ByteBuffer;

public class TestByteBufferRead {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put(new byte[]{'a','b','c','d'});
        buffer.flip();

        buffer.get(new byte[4]);

        //rewind从头开始读
        buffer.rewind();
        //System.out.println((char)buffer.get());

        //mark & reset
        //mark 做一个标记，记录position位置，reset是将position重置到mark位置
        buffer.rewind();
        System.out.println((char) buffer.get());
        System.out.println((char) buffer.get());
        buffer.mark(); //加标记，索引为2的位置
        System.out.println((char) buffer.get());
        System.out.println((char) buffer.get());
        buffer.reset();//将position重置索引2
        System.out.println((char) buffer.get());
        System.out.println((char) buffer.get());

    }
}
