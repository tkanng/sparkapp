package com.tkanng.jvm;

public class ReferenceCountingGc {
    public Object instance1= null;
    private static final  int _1MB=1024*1024;
    public Object instance2 = null;
    private byte[] bytes = new byte[_1MB];

    public static void main(String[] args) {
        ReferenceCountingGc a = new ReferenceCountingGc();
        ReferenceCountingGc b = new ReferenceCountingGc();
        a.instance1=b;
        a.instance2="a.instance2";
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
