package com.test;

import com.sdp.Printer;
public class Cloning_Solution_Singleton {
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
//Output 1 -> for returing Instance:
Printer getInstance() (Outside sync block) :: main
Printer getInstance() (Inside sync block) :: main
Printer::0-param cons
603742814 : 603742814
p1==p2 ?true

Output 2 -> for throwing and make sure no clone is ever created.
Printer getInstance() (Outside sync block) :: main
Printer getInstance() (Inside sync block) :: main
Printer::0-param cons
java.lang.CloneNotSupportedException: Cloning not allowed for Singleton
        at com.sdp.Printer.clone(Printer.java:44)
        at com.test.Cloning_Problem_Singleton.main(Cloning_Problem_Singleton.java:8)
 */
