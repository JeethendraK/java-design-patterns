package com.sdp;

import com.test.CommonUtils;

public class Printer extends CommonUtils{

    //private static final long serialVersioUID = 1L;
    int a = 10;
    //private static ref var
    private static Printer INSTANCE;

    //private Constructor
    private Printer(){
        System.out.println("Printer :: 0-param constructor ");
    }

    //public static factory method having singleton lofic in synchronized block
    public static Printer getInstance(){
        if(INSTANCE==null){
            System.out.println("Printer.getInstance() outside sync block :: "+Thread.currentThread().getName());
            synchronized(Printer.class){
                try{
                    Thread.sleep(1000);
                }catch(Exception e){
                    e.printStackTrace();
                }
                INSTANCE = new Printer();
            }
        }
        return INSTANCE;
    }

   /*  //solution 1 for cloning issue
    public Object clone() throws CloneNotSupportedException{
        return INSTANCE;
    } */

    //Best solution for cloning
    public Object clone() throws CloneNotSupportedException{
        throw new CloneNotSupportedException("In this singleton class is restricted");
    }

    //business method
    public void getMsg(String msg){
        System.out.println(msg);
    }

}
