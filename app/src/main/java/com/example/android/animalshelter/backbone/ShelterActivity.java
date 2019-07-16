package com.example.android.animalshelter.backbone;

import com.example.android.animalshelter.ShelterApplication;

import androidx.appcompat.app.AppCompatActivity;

public abstract class ShelterActivity extends AppCompatActivity implements ShelterBaseFrame{

    @Override
    public ShelterApplication getShelterApplication() {
        return (ShelterApplication) super.getApplication();
    }
}
