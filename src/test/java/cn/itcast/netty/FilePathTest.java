package cn.itcast.netty;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FilePathTest {
    public static void main(String[] args) throws IOException {
        Path source = Paths.get("1.txt"); //相对路径
        Path source1 = Paths.get("d:\\1.txt"); //绝对路径 代表了d:\1.txt
        Path source2 = Paths.get("d:/1.txt"); //代表了d:\1.txt
        Path source3 = Paths.get("d:\\1.txt","projects"); //代表了d:\1.txt\projects
        //Path source4 = Paths.get("d:\\data\\projects\\a\\..\b");
        System.out.println(Files.exists(source3));
        System.out.println(source3);
        //System.out.println(source4.normalize());
        Path p1 = Paths.get("hello/d1");
        Files.createDirectory(p1);
        Files.copy(source,source2, StandardCopyOption.REPLACE_EXISTING);
    }
}
