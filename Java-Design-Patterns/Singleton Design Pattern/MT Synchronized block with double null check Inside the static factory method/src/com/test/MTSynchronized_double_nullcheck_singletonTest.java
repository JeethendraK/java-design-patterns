package com.test;
public class MTSynchronized_double_nullcheck_singletonTest {
    public static void main(String[] args){
        TicketBookingOperation op = new TicketBookingOperation();
        Thread t1 = new Thread(op);
        Thread t2 = new Thread(op);
        Thread t3 = new Thread(op);
        t1.start();
        t2.start();
        t3.start();
    }
}
/* Output: 
TicketBooking Opetation.run()
TicketBooking Opetation.run()
TicketBooking Opetation.run()
Printer.getInstance()(Outside sync block):: Thread-1
Printer.getInstance()(Outside sync block):: Thread-0
Printer.getInstance()(Outside sync block):: Thread-2
Printer.getInstance()(Inside sync block):: Thread-1
0-param constructor
40378339
Printer.getInstance()(Inside sync block):: Thread-2
40378339
Printer.getInstance()(Inside sync block):: Thread-0
40378339 */