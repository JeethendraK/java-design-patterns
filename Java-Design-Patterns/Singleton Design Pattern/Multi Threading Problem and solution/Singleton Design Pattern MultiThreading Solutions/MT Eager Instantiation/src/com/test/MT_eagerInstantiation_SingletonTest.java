package com.test;
public class MT_eagerInstantiation_SingletonTest {
    public static void main(String[] args) {
        try{
            Class.forName("com.sdp.Printer"); //loading class
        }catch(Exception e){
            e.printStackTrace();
        }
   }
}
//Output --> 0-param constructor
