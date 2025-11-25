package com.test;

public class MTSynchronized_block_inside_static_method {
    public static void main(String[] args) throws Exception {
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
TicketBooking Operation.run()
TicketBooking Operation.run()
TicketBooking Operation.run()
0-param constructor
1274973646
1274973646
1274973646 */