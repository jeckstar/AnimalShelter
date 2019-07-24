package com.jeka.golub.shelter.function;

public interface Consumer<T> {

    void apply(T subject);

    void fail(Throwable throwable);

}
