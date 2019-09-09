package com.example.android.animalshelter.view.home.create_animal;

public interface CreateAnimalEventConsumer {

    void onSaveClick(String kind, String name, int age, int sex, int walkPeriod);
}
