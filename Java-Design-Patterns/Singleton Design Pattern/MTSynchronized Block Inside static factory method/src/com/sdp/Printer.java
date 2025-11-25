package com.sdp;

public class Printer {
    private static Printer INSTANCE;
    private Printer(){
        System.out.println("0-param constructor");
    }
    public static Printer getInstance(){
        //singleton logic
        synchronized (Printer.class) {//class level locking(all static properties will be locked)
            if(INSTANCE==null){
                try{
                    Thread.sleep(1000);
                }catch(Exception e){
                    e.printStackTrace();
                }
                INSTANCE = new Printer();
            }
        }
        return INSTANCE;
    }

}
/*
 * We cannot use "this" inside static methods, so we cannot pass "this" to a synchronized block.
 *
 * In a Singleton class, if we use a static factory method (getInstance()),
 * we must apply synchronization to protect shared static properties.
 *
 * Since passing a parameter to the synchronized block is mandatory,
 * and "this" is not available in static context, we must perform
 * class-level locking.
 *
 * To achieve class-level locking, we pass the class name in the form of a
 * java.lang.Class object to the synchronized block, like:
 *
 * synchronized (Printer.class) {
 *     // thread-safe logic
 * }
 *
 * This ensures that all threads use the same lock and prevents multiple
 * instances from being created in a multithreaded environment.
 */

