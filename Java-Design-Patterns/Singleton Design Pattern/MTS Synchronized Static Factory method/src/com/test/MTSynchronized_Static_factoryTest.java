package com.test;

public class MTSynchronized_Static_factoryTest {
    public static void main(String[] args) {
        TicketBookingOperation op = new TicketBookingOperation();
        Thread t1 = new Thread(op);
        Thread t2 = new Thread(op);
        Thread t3 = new Thread(op);
        t1.start();
        t2.start();
        t3.start();
    }
}
/* output: 
TicketBookingOperation.run()
TicketBookingOperation.run()
TicketBookingOperation.run()
0-param constructor
436160393
436160393
436160393 */