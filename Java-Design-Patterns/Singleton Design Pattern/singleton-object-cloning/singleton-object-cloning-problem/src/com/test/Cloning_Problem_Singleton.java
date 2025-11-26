package com.test;

import com.sdp.Printer;
public class Cloning_Problem_Singleton {
    public static void main(String[] args) {
        Printer p1 = Printer.getInstance();
        try{
            Printer p2 = (Printer) p1.clone();
            System.out.println(p1.hashCode()+" : "+p2.hashCode());
            System.out.println("p1==p2 ?"+ (p1==p2));
        }catch (Exception e){
            e.printStackTrace();
        }
        
    }
}
/* 
//Output :
Printer getInstance() (Outside sync block) :: main
Printer getInstance() (Inside sync block) :: main
Printer::0-param cons
603742814 : 1067040082
p1==p2 ?false */
