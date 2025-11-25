package com.sdp;

public class Printer {
    private static Printer INSTANCE;
    private Printer(){
        System.out.println("0-Param constructor");
    };

    public static Printer getInstance(){
        if(INSTANCE == null){
            INSTANCE = new Printer();
        }

        return INSTANCE;
    }

}
