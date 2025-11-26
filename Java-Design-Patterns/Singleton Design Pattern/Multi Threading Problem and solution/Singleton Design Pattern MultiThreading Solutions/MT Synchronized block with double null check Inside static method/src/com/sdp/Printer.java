package com.sdp;

public class Printer {
    private static Printer INSTANCE;
    private Printer(){
        System.out.println("0-param constructor");
    }

    //b.method
    public void printMessage(String msg){
        System.out.println(msg);
    }

    
    public static Printer getInstance(){
        if(INSTANCE==null){
            System.out.println("Printer.getInstance()(Outside sync block):: "+ Thread.currentThread().getName());
            synchronized(Printer.class){
                System.out.println("Printer.getInstance()(Inside sync block):: "+ Thread.currentThread().getName());
                if(INSTANCE==null){
                    try{
                        Thread.sleep(1000);
                    }catch(Exception e){
                        e.printStackTrace();
                    }//catch
                    INSTANCE = new Printer();
                }//if
            }//sync
        }//if
        return INSTANCE;
    }

}
