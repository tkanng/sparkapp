package com.tkanng.jvm;
import java.lang.ClassLoader;

public class TestClassLoader {
    public static void main(String[] args) {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return super.loadClass(name);
            }
        };
    }
}
