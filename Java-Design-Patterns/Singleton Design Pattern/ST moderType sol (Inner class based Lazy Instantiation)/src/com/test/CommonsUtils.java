package com.test;

import java.io.Serializable;

public class CommonsUtils implements Cloneable, Serializable {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
