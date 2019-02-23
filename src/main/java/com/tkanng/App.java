package com.tkanng;

import com.tkanng.helloworld.HelloWorld;

public class App {
    public static void main(String[] args) {
        int i = 0;
        try {
            while (true) {
                i++;
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
