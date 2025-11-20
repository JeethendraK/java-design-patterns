package com.jk.test;

import com.jk.sdp.Printer;

public class SingletonClasstest {
    public static void main(String[] args) {
       // Printer p = new Printer(); //Invalid as constructor is private
       Printer p1 = Printer.getInstance();
       Printer p2 = Printer.getInstance();
       System.out.println(p1.hashCode()+"  "+p2.hashCode());
       System.out.println("p1==p2?"+(p1==p2));
    }

}
/* Output
Printer :: 0-param constructor
2055281021  2055281021
p1==p2?true */
