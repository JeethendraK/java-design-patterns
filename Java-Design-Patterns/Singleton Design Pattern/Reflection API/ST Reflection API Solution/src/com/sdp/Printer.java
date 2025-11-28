package com.sdp;

public class Printer {
    private static Printer INSTANCE;
    private static boolean isInstantiated = false;

    private Printer() {
        if (isInstantiated) {
            throw new RuntimeException("Object is already created");
        } else {
            isInstantiated = true;
        }
        System.out.println("0-Param constrcutor");

    }

    // public static factory method having singleton login in syhchronized block
    public static Printer getInstance() {
        if (INSTANCE == null) {
            synchronized (Printer.class) {
                if (INSTANCE == null) {

                    try {
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Printer();

                }
            }
        }
        return INSTANCE;
    }

}
