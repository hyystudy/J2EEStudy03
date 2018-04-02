package com.company;

import com.sun.deploy.util.Property;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Properties;

public class ReadFilesFromDir {

    public static void main(String[] args) {

        File[] listRoots = File.listRoots();
        for (int i = 0; i < listRoots.length; i++) {
            System.out.println(listRoots[i].toString());
        }


        File file = new File("D:\\");
        File[] files = file.listFiles();
        System.out.println("files size:" + files.length);
        FileFilter fileFilter = new FileFilter() {

            @Override
            public boolean accept(File file) {
                return file.isDirectory();
            }
        };

        FilenameFilter filenameFilter = new FilenameFilter() {
            @Override
            public boolean accept(File file, String s) {
                return s.startsWith("a");
            }
        };

        File[] files1 = file.listFiles(filenameFilter);

        if (files1 == null || files1.length == 0) {
            System.out.println("File is not a directory");
        }else {
            for (int i = 0; i < files1.length; i++) {
                System.out.println(files1[i].getName());
            }
        }

        //获取当前工作目录
        String property = System.getProperty("user.dir");
        System.out.println("Cur work dir:" + property);

        visitAllDirAndFiles(new File(property));
    }

    //遍历目录下所有文件和文件夹
    public static void visitAllDirAndFiles(File dir){
        System.out.println(dir);

        if (dir.isDirectory()) {
            String[] files = dir.list();
            for (int i = 0; i < files.length; i++) {
                visitAllDirAndFiles(new File(dir, files[i]));
            }
        }

    }
}
