package com.test;

import java.lang.reflect.Constructor;

import com.sdp.Printer;

public class ST_Reflection_API_Solution_Test {
    public static void main(String[] args) {
        try {

            // load the singleton java class
            Class c = Class.forName("com.sdp.Printer");

            // get all the declared constructors of the class
            Constructor cons[] = c.getDeclaredConstructors();

            // Access the private constructors (if any)
            cons[0].setAccessible(true);

            // object creation for singleton class using accessed private constructor
            Printer p1 = (Printer) cons[0].newInstance();
            Printer p2 = (Printer) cons[0].newInstance();
            Printer p3 = Printer.getInstance();
            System.out.println(p1.hashCode() + "  " + p2.hashCode() + "  " + p3.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
/*
 * Output withour fixing
 * 0-Param constrcutor
 * 0-Param constrcutor
 * 0-Param constrcutor
 * 918221580 2055281021 1554547125
 * output post fixing---->
 * 0-Param constrcutor
 * java.lang.reflect.InvocationTargetException
 * 
 * Explanation
 * isInstantiated is false initially. Constructor runs: isInstantiated becomes
 * true.
 * Prints: 0-Param constrcutor
 * p1 is created successfully.
 * • In while creating object Now isInstantiated is already true. • Constructor
 * immediately throws:
 * throw new RuntimeException("Object is already created");
 * • This exception is wrapped inside an InvocationTargetException by
 * reflection.
 * • Control jumps straight to your catch (Exception e) { ... }.
 * • So:
 * • p2 is never assigned.
 * • p3 = Printer.getInstance() never executes.
 * • System.out.println(...) never executes.
 * 
 * 
 */
