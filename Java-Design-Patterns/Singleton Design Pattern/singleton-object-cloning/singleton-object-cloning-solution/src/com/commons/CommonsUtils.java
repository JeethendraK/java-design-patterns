package com.commons;

public class CommonsUtils implements Cloneable {

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning not allowed");
    }

}
