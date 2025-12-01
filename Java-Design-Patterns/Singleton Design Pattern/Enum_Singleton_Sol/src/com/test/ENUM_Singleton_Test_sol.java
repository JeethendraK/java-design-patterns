// src/com/test/ENUM_Singleton_Test_sol.java
package com.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

import com.sdp.Printer;

public class ENUM_Singleton_Test_sol {

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

        t1.start();
        t2.start();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        t3.start();

        // Serialization and De-serialization
        System.out.println("-------------Serialization and De-serialization------------");
        Printer p4 = Printer.getInstance();
        doSerialization(p4);
        System.out.println("-----------------------------");
        Printer p5 = (Printer) doDeserialization();
        Printer p6 = (Printer) doDeserialization();
        System.out.println(p4.hashCode() + "  " + p5.hashCode() + "  " + p6.hashCode());

        // Reflection API test
        reflectionAPITest();
    }

    // Serialization helper
    public static void doSerialization(Object obj) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.ser"))) {
            oos.writeObject(obj);
            oos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Object serialization is done");
    }

    // Deserialization helper
    public static Object doDeserialization() {
        Object p = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.ser"))) {
            p = ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Object de-serialization is done");
        return p;
    }

    public static void reflectionAPITest() {
        System.out.println("----------------Reflection API-----------------");
        try {
            // Load enum singleton class
            Class<?> c = Class.forName("com.sdp.Printer");
            Constructor<?>[] cons = c.getDeclaredConstructors();

            // Try to break singleton using reflection
            cons[0].setAccessible(true);

            // These lines will throw an exception for enums
            Object o1 = cons[0].newInstance();
            Object o2 = cons[0].newInstance();
            Printer p3 = Printer.getInstance();

            System.out.println("Reflection instances created:");
            System.out.println("o1: " + o1.hashCode() +
                               "  o2: " + o2.hashCode() +
                               "  p3: " + p3.hashCode());

        } catch (Exception e) {
            e.printStackTrace(); // You’ll see InvocationTargetException / IllegalArgumentException here
        }
    }
}

/* //Output :
==========================
Hash Code :: 918221580 918221580
p1==p2? true
------------Multi Threading------------------
TickerBooking.run()
TickerBooking.run()
Run method hash code : 918221580
Run method hash code : 918221580
-------------Serialization and De-serialization------------
TickerBooking.run()
Run method hash code : 918221580
Object serialization is done
-----------------------------
Object de-serialization is done
Object de-serialization is done
918221580  918221580  918221580
----------------Reflection API-----------------
java.lang.IllegalArgumentException: Cannot reflectively create enum objects
        at java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:492) */
