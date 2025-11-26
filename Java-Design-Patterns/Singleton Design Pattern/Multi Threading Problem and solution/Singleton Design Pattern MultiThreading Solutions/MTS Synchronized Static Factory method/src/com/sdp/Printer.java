package com.sdp;

public class Printer {
    private static Printer INSTANCE;
    private Printer(){
        System.out.println("0-param constructor");

    }
    //If we make staic factory method as synchronized method it allows only one thread into the method and avoids multithreading issues.
    public synchronized static Printer getInstance(){
        if(INSTANCE == null){
            try{
                Thread.sleep(1000);
            }catch(Exception e){
                e.printStackTrace();
            }
            INSTANCE = new Printer();
    }
        return INSTANCE;
    }

}
