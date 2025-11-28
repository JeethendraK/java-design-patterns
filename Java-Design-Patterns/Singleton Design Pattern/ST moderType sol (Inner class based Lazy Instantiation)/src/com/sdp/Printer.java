package com.sdp;

import com.test.CommonsUtils;

//perfect Singleton Java class
public class Printer extends CommonsUtils {
    private static boolean isInstantiated = false;

    private Printer() {
        if (isInstantiated) {
            throw new RuntimeException("Object is already Created");
        }else{
            isInstantiated = true;
        }
        System.out.println("0-param constructor");
    }

    private static class InnerPrinter {
        // Inner class based eager Instantiation
        // front outer is lazy Instantiation
        private static Printer INSTANCE = new Printer();

    }

    public static Printer getInstance() {
        return InnerPrinter.INSTANCE;
    }

    // protection from cloning
    @Override
    public Object clone() throws CloneNotSupportedException {
        return InnerPrinter.INSTANCE;
    }

    // protecting from deserilziation
    public Object readResolve() {
        return InnerPrinter.INSTANCE;
    }

    public void getmsg(String msg) {
        System.out.println(msg);
    }

}
