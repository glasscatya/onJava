package com.glasscat.files;

import java.nio.file.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Directories {
    //获取到当前目录下test目录 无论test是否存在 都会获得 ./test
    static Path test = Paths.get("test");
    //获取当前文件系统的分隔符 win是"\" linux和mac是"/"
    static String sep = FileSystems.getDefault().getSeparator();
    static List<String> parts = Arrays.asList("foo", "bar", "baz", "bag");

    static Path makeVariant() {
        //将parts按照每个元素右移1的顺序，编程心得parts
        Collections.rotate(parts, 1);
        //
        System.out.println("----------------------" + String.join(sep, parts));
        //返回test/xxx/xxx/xxx/xxx
        return Paths.get("test", String.join(sep, parts));
    }
    //刷新test目录
    static void refreshTestDir() throws Exception {
        if (Files.exists(test)) {
            RmDir.rmdir(test);
        }
        if (!Files.exists(test)) {
            Files.createDirectory(test);
        }
    }

    static void populateTestDir() throws Exception {
        //生成四次
        for (int i = 0; i < parts.size(); i++) {
            //每一次都获得一个新的 test/xxx/xxx/...
            Path variant = makeVariant();
            if (!Files.exists(variant)) {
                //createDirectories可以创造多层目录
                Files.createDirectories(variant);
                //将当前目录下的pom.xml复制到variant的file.txt中(没有将会新建该文件
                Files.copy(Paths.get("pom.xml"), variant.resolve("File.txt"));
                //创建临时文件 我们没有指定前缀与后缀，故文件名为 <随机数.tmp>
                Files.createTempFile(variant, null, null);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        //先刷新test
        refreshTestDir();
        //在当前目录下新建一个Hello.txt 如果已有会覆盖。
        Files.createFile(test.resolve("Hello.txt"));
        Path variant = makeVariant();
        try {
            //这个方法只能创建单层目录 且 目录不能重名。
            Files.createDirectory(variant);
        } catch (Exception e) {
            System.out.println("Nope. that ");
        }
        //用该方法创造四个四层目录，里面全是file.txt和<随机数.tmp>
        populateTestDir();
        //创建一个临时文件夹 名为 前缀_随机数
        Path tempdir = Files.createTempDirectory(test, "DIR_");
        //创建一个临时文件 名为 前缀随机数.后缀
        Files.createTempFile(tempdir, "pre", ".non");
        //转换成流，打印test目录
        Files.newDirectoryStream(test)
             .forEach(System.out::println);

        System.out.println("*********");
        //walk遍历test目录的所有文件和文件夹，后打印
        Files.walk(test).forEach(System.out::println);
    }
}
