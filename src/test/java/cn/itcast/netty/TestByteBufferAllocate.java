package cn.itcast.netty;

import java.nio.ByteBuffer;

public class TestByteBufferAllocate {
    public static void main(String[] args) {
        System.out.println(ByteBuffer.allocate(14).getClass());
        System.out.println(ByteBuffer.allocateDirect(14).getClass());

        //class java.nio.HeapByteBuffer  java堆内存，读写效率低，受到GC垃圾回收器的影响
        //class java.nio.DirectByteBuffer 直接内存，读写效率高（少一次拷贝）不会受GC影响。

    }
}
