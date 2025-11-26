package com.sdp;

public class Printer {
    private static Printer INSTANCE = new Printer();
    private Printer(){
        System.out.println("0-param constructor");
    }
    //b.method
    public void printMessage(String msg){
        System.out.println(msg);
    }


    //Static factory method
    public static Printer getInstance(){
        return INSTANCE;
    }

}
