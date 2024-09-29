package com.glasscat.files;

import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class FileSystemDemo {
    public static void show(String s, Object p) {
        System.out.println(s + p);
    }

    public static void main(String[] args) {
        //获取文件系统
        FileSystem fsys = FileSystems.getDefault();
        //系统硬盘
        for(FileStore fs : fsys.getFileStores())
            show("File Store : ", fs);
        //根路径
        for(Path rd : fsys.getRootDirectories())
            show("Root Dir : ", rd);
        //当前操作系统的文件分割符号
        show("Sep", fsys.getSeparator());
        //FileSystem类的提供者
        show("FileSystemProvider : ", fsys.provider());

        //获取当前文件系统支持的功能， [user, owner, dos, acl, basic]
        // user:允许用户定义文件属性
        //owner:允许查看修改Owner
        //dos: 对dos文件属性的使用
        //acl:允许访问控制列表（ACL）的管理，用于定义文件的访问权限。
        show("File Attr Views : ", fsys.supportedFileAttributeViews());
    }
}
