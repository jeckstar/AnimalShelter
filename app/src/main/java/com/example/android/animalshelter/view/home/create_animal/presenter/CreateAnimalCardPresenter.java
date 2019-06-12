package com.example.android.animalshelter.view.home.create_animal.presenter;

import com.example.android.animalshelter.view.home.create_animal.view.ICreateAnimalCardView;

public class CreateAnimalCardPresenter implements ICreateAnimalCardPresenter {

    private final ICreateAnimalCardView view;

    public CreateAnimalCardPresenter(ICreateAnimalCardView view) {
        this.view = view;
    }

    @Override
    public void onCreate() {

    }

}
