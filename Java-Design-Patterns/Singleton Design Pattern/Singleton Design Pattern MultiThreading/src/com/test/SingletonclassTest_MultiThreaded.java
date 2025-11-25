package com.test;

public class SingletonclassTest_MultiThreaded {

    public static void main(String[] args) {
        TicketBookingOperation op = new TicketBookingOperation();
        Thread t1 = new Thread(op);
        Thread t2 = new Thread(op);
        Thread t3 = new Thread(op);
        //start threads
        t1.start();
        t2.start();
        t3.start();
        
    }
}
/* Output: -
TicketBookingOperation.run()
TicketBookingOperation.run()
TicketBookingOperation.run()
0-Param constructor
0-Param constructor
389589790
0-Param constructor
1274973646
557988408

Note: During Multi threaded environment, the order of execution is not guranteed. */