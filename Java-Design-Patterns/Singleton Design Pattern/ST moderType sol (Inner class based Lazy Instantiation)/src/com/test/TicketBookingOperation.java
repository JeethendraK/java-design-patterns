package com.test;

import com.sdp.Printer;

public class TicketBookingOperation implements Runnable {

    @Override
    public void run() {
        System.out.println("TickerBooking.run()");
        Printer p = Printer.getInstance();
        System.out.println("Run method hash code : " + p.hashCode());
    }

}
