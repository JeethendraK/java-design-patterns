package com.sdp;

import com.test.CommonUtils;

public class Printer extends CommonUtils{

    private static final long serialVersionUID = 1L;
    int a = 11;
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
                    Thread.sleep(2000);
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

 /*    //solution 1 for place readResolve() method throwing exception(Internally called readObject() method Deserilization)
    public Object readResolve(){
        throw new IllegalArgumentException("Deserilization is not allowed on this class");
    }
     */
    //solution 2 for place readResolve() method throwing exception(Internally called readObject() method Deserilization)
    public Object readResolve(){
        return INSTANCE;
    }
    //business method
    public void getMsg(String msg){
        System.out.println(msg);
    }

}
