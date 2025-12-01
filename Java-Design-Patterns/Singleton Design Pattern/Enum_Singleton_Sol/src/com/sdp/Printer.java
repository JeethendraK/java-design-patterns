package com.sdp;


//perfect Singleton Java class
public enum Printer {
    INSTANCE; //ENUM Constant --> It is internally 
            // public static Printer INSTANCE = new Printer(); //Eager instantiaion which is thread safe.

    public static Printer getInstance() {
        return INSTANCE;
    }


    public void getmsg(String msg) {
        System.out.println(msg);
    }

}
