package com.company;

import java.io.File;

//删除文件夹的时候需要先递归把文件夹里的文件删除了，才能删除文件夹
//创建文件夹的时候如果写的是 ./test 则默认在工作目录下创建 test文件夹
public class DeleteDir {

    public static void main(String[] args){
        File file = new File(".\\src\\hyy\\zal");
        file.mkdirs();
        dirIsEmpty(new File(".\\src\\hyy"));

         deleteDir(new File(".\\src\\hyy"));
    }

    public static boolean deleteDir(File dir){
        System.out.println("FileName:" + dir.getName() + " is dir:  "+ dir.isDirectory());
        if (dir.isDirectory()) {
            String[] childs = dir.list();
            for (int i = 0; i < childs.length; i++) {
                File file = new File(dir, childs[i]);
                if (!deleteDir(file)) {
                    return false;
                }
            }
        }

        if (dir.delete()) {
            System.out.println("Delete Dir successful");
            return true;
        }else {
            System.out.println("Delete Dir Failed");
            return false;
        }
    }

    public static boolean dirIsEmpty(File dir){
        if (dir.isDirectory()) {
           return dir.list()!= null && dir.list().length > 0;
        }
        return  false;
    }
}
