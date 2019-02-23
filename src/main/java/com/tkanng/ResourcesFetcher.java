package com.tkanng;

import java.io.*;
import java.net.URL;
import java.util.Enumeration;

// 利用Java加载资源文件.资源文件可能在jar包中，也可能在不同文件目录下面
public class ResourcesFetcher {
    public static void main(String[] args) {
        Enumeration<URL> urls = null;
        try {
            // classLoader会从classpath下面加载test.txt，可能会有很多个test.txt.
            // 将代码打包成jar包，根目录下有一个test.txt文件, /home/tkanng/Desktop下面也有一个test.txt
            // 将/home/tkanng/Desktop加入到程序的classpath下面
            // 然后运行  java -cp /home/tkanng/Desktop/:sparkapp-1.0-SNAPSHOT-shaded.jar com.tkanng.ResourcesFetcher
            // getResources会得到一个大小为2的URL枚举对象
            // ["file:/home/tkanng/Desktop/test.txt"," jar:file:/home/tkanng/IdeaProjects/sparkapp/target/sparkapp-1.0-SNAPSHOT-shaded.jar!/test.txt"]
            // 然后利用得到的URL对象得到InputStream
            urls = Thread.currentThread().getContextClassLoader().getResources("test.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (urls != null) {
            while (urls.hasMoreElements()) {
                URL u = urls.nextElement();
                System.out.println("URL: " + u);
                System.out.println(readURL(u));
            }
        }else {
            System.out.println("urls==null");
        }
    }

    public static String readURL(URL url) {
        InputStream in = null;
        try {
            in = url.openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert in != null;
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        br = new BufferedReader(new InputStreamReader(in));
        while (true) {
            String st = null;
            try {
                st = br.readLine();
                if (st == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            sb.append(st);
        }
        return sb.toString();
    }
}

