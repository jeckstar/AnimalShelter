package com.example.android.animalshelter.backbone;

public interface Consumer2<T, R> {
    void accept(T t, R r) throws Exception;
}
