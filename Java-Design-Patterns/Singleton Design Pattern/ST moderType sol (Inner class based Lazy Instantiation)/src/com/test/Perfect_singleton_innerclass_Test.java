package com.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

import com.sdp.Printer;

public class Perfect_singleton_innerclass_Test {
    public static void main(String[] args) {
        System.out.println("==========================");
        Printer p1 = Printer.getInstance();
        Printer p2 = Printer.getInstance();
        System.out.println("Hash Code :: " + p1.hashCode() + " " + p2.hashCode());
        System.out.println("p1==p2? " + (p1 == p2));

        // Multi Thread test with data
        System.out.println("------------Multi Threading------------------");
        TicketBookingOperation op = new TicketBookingOperation();
        Thread t1 = new Thread(op);
        Thread t2 = new Thread(op);
        Thread t3 = new Thread(op);
        // start Threads
        t1.start();
        t2.start();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        t3.start();

        // Serilization and de Serilization
        System.out.println("-------------Serilization and De serilization------------");
        Printer p4 = Printer.getInstance();
        // perform serilziation on the single obj of the singelton class
        doSerilization(p4);
        System.out.println("-----------------------------");
        Printer p5 = (Printer) doDeserilization();
        Printer p6 = (Printer) doDeserilization();
        System.out.println(p4.hashCode() + "  " + p5.hashCode() + "  " + p6.hashCode());
        // Cloning Test
        System.out.println("--------------Cloning Test-----------------");
        Printer p7 = Printer.getInstance();
        try {
            Printer p8 = (Printer) p7.clone();
            System.out.println(p7.hashCode() + "  " + p8.hashCode());
            System.out.println("p7==p8 ? " + (p7 == p8));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        // reflection API Proof
        ReflectionAPIsolution();

    }// main method

    // to work for all printer we had paramter as Object
    public static void doSerilization(Object obj) {
        // try with resources
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.ser"))) {
            oos.writeObject(obj); // serilization
            oos.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Object serilization is done");
    }// method

    public static Object doDeserilization() {
        Object p = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.ser"))) {
            p = (Object) ois.readObject(); // De serilization
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Object de serilziation is done");

        return p;
    }// method

    public static void ReflectionAPIsolution() {
        System.out.println("----------------Reflection API-----------------");
        // Loading the Singleton Java class
        try {
            Class c = Class.forName("com.sdp.Printer"); // or we can use Class.forName(args[0])
                                                        // so that total class comes at run time
            // or
            // we can use like Class c = Printer.class;

            // get all the declared constructor of the class
            Constructor[] cons = c.getDeclaredConstructors();

            // Break encapsulation: allow access to private constructor--> Danger method
            // which will break entire eancapsulation
            cons[0].setAccessible(true);

            Printer p1 = (Printer) cons[0].newInstance();
            Printer p2 = (Printer) cons[0].newInstance();
            Printer p3 = Printer.getInstance();

            System.out.println("p1: " + p1.hashCode() +
                    "  p2: " + p2.hashCode() +
                    "  p3: " + p3.hashCode());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

/* //----Output-----
==========================
0-param constructor
Hash Code :: 1554547125 1554547125
p1==p2? true
------------Multi Threading------------------
TickerBooking.run()
TickerBooking.run()
Run method hash code : 1554547125
Run method hash code : 1554547125
-------------Serilization and De serilization------------
TickerBooking.run()
Run method hash code : 1554547125
Object serilization is done
-----------------------------
Object de serilziation is done
Object de serilziation is done
1554547125  1554547125  1554547125
--------------Cloning Test-----------------
1554547125  1554547125
p7==p8 ? true
----------------Reflection API-----------------
java.lang.reflect.InvocationTargetException
        at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
        at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:77) */