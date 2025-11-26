package com.sdp;

public class Printer {
    //Private constructor
    private Printer(){
        System.out.println("Printer :: 0-param constructor");
    }

    //static inner class/nested class/nested inner class
    private static class PrinterInner {
        private static Printer INSTANCE = new Printer();//Inner class based eager instantiation
                                                        //Front outer is a Lazy Instantiation
        
    }

    //static factory method
    public static Printer getInstance(){
        return PrinterInner.INSTANCE;
    }

    //b.method
    public void printmsg(String msg){
        System.out.println(msg);
    }

}
