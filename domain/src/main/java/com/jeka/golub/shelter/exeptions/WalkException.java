package com.jeka.golub.shelter.exeptions;

public class WalkException extends RuntimeException {

    public WalkException() {
    }

    public WalkException(String s) {
        super(s);
    }

    public WalkException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public WalkException(Throwable throwable) {
        super(throwable);
    }

    public WalkException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}