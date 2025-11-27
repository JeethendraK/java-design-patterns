package com.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.sdp.Printer;

public class Singletonclass_Serilization_Deserilization_Test {

    public static void main(String[] args) {
        //Get singleton java class object
        Printer p1 = Printer.getInstance();
        //perform serilization on the singleton object of singleton class
        doSerilization(p1);
        System.out.println("==========================");
        // Perform deserialization multiple times
        Printer p2 = doDeserilization();
        Printer p3 = doDeserilization();
        System.out.println("p1:"+p1.hashCode()+"  p2:"+p2.hashCode()+"  p3:"+p3.hashCode());
    }

    public static void doSerilization(Printer p) {
        //try with resource
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.ser"))){
            oos.writeObject(p); //Doing serilization
            oos.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("-----Object serilization is done--------");
    }//method

    public static Printer doDeserilization(){
        Printer p1 = null;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.ser"))){
            p1 = (Printer)ois.readObject();//Doing de serilization
        }catch(Exception e){
            e.printStackTrace();
        }
        return p1;
    }
}
/* Output 1: with throwing exception when readObject
Printer.getInstance() outside sync block :: main
Printer :: 0-param constructor 
-----Object serilization is done--------
==========================
java.lang.IllegalArgumentException: Deserilization is not allowed on this class

Output 2: returing same INSTANCE 

Printer.getInstance() outside sync block :: main
Printer :: 0-param constructor 
-----Object serilization is done--------
==========================
p1:501263526  p2:501263526  p3:501263526*/


