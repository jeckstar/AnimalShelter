package com.example.android.animalshelter.view.home.create_animal.presenter;

public interface ICreateAnimalCardPresenter {

    void onCreate();

    void onSaveCardClicked(String kind, String name, int age, int sex, int walkPeriod);
}
