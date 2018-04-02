package com.company;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	    // write your code here
        String dir = "D:\\a\\b\\c\\d\\e\\f\\g\\h\\i";
        File file = new File(dir);
        boolean status = file.mkdirs();
        System.out.println("Status:" + status);
        System.out.println("File exists :" + file.exists());
    }
}
