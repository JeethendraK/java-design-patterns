package com.sdp;

import com.commons.CommonsUtils;

public class Printer extends CommonsUtils{

    //private static ref variable
    private static Printer INSTANCE;

    //PRIVATE constructor
    private Printer(){
        System.out.println("Printer::0-param cons");
    }


    public static Printer getInstance(){
        if(INSTANCE==null){
            System.out.println("Printer getInstance() (Outside sync block) :: "+Thread.currentThread().getName());
            synchronized(Printer.class){
                System.out.println("Printer getInstance() (Inside sync block) :: "+Thread.currentThread().getName());
                if(INSTANCE==null){
                    try{
                        Thread.sleep(1000);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    INSTANCE = new Printer();
                }//if
            }//sync
        }//if
        return INSTANCE;
    }

    //business method
    public void getMsg(String msg){
        System.out.println(msg);;
    }
}
