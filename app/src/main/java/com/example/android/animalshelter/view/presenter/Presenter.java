package com.example.android.animalshelter.view.presenter;

public interface Presenter<T> {

    void attachView(T view);

    void detachView();
}
