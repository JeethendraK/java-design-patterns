package com.test;
public class Mt_innerclass_LazyInstantiation_Singleton {
    public static void main(String[] args) {
        TicketBookingOperation op =  new TicketBookingOperation();
        Thread t1 = new Thread(op);
        Thread t2 = new Thread(op);
        Thread t3 = new Thread(op);
        t1.start();
        t2.start();
        try{
            Thread.sleep(2000);
        }catch(Exception e){
            e.printStackTrace();
        }
        t3.start();

    }
}
/* //output
TicketBooking Opetration.run() method
TicketBooking Opetration.run() method
Printer :: 0-param constructor
1274973646
1274973646
TicketBooking Opetration.run() method
1274973646 */


