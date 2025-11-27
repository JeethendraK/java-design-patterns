package com.test;

import java.lang.reflect.Constructor;

import com.sdp.Printer;

public class Singletonclass_ReflectionAPI_Test {

    public static void main(String[] args) {
        // Loading the Singleton Java class
        try {
            Class c = Class.forName("com.sdp.Printer"); // or we can use Class.forName(args[0])
                                                        // so that total class comes at run time
            // or
            // we can use like Class c = Printer.class;

            // get all the declared constructor of the class
            Constructor[] cons = c.getDeclaredConstructors();

            // Break encapsulation: allow access to private constructor--> Danger method which will break entire eancapsulation
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
/*
 * Output :
 * Printer :: 0-param constructor
 * Printer :: 0-param constructor
 * Printer.getInstance() outside sync block :: main
 * Printer :: 0-param constructor
 * 603742814 1067040082 1325547227
 * 
 */
