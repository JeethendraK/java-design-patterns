package com.test;

import com.sdp.Printer;

public class TicketBookingOperation implements Runnable{

     @Override
    public void run() {
        System.out.println("TicketBooking Opetation.run()");
        Printer p = Printer.getInstance();
        System.out.println(p.hashCode());
    }
    
}
