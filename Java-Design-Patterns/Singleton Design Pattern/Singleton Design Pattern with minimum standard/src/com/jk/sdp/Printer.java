package com.jk.sdp;

public class Printer {
    //private static ref variable of class type
    private static Printer INSTANCE;

    //private constructor
    private Printer(){
        System.out.println("Printer :: 0-param constructor");
    }

    //public static factory method having singleton logic
    public static Printer getInstance(){
        if(INSTANCE==null){
            INSTANCE = new Printer();
        }
        return INSTANCE;
    }

    //B.method
    public void printMessage(String msg){
        System.out.println(msg);
    }
}
