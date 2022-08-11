package cn.itcast.netty;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;

public class TestFilesWalkFileTree {
    public static void main(String[] args) throws IOException {
        AtomicInteger dircount = new AtomicInteger();
        AtomicInteger filecount = new AtomicInteger();
        final int count = 0;
        Files.walkFileTree(Paths.get("C:\\Program Files\\Java\\jdk-17.0.1"), new SimpleFileVisitor<Path>(){

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println("====>"+ dir);
                dircount.incrementAndGet();
                return super.preVisitDirectory(dir, attrs);
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                filecount.incrementAndGet();
                return super.visitFile(file, attrs);
            }
        });
        System.out.println("dircount: "+ dircount);
        System.out.println("file count :"+ filecount);

    }
}
