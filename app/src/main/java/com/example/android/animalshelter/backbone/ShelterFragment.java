package com.example.android.animalshelter.backbone;

import com.example.android.animalshelter.ShelterApplication;

import androidx.fragment.app.Fragment;

public abstract class ShelterFragment extends Fragment implements ShelterProvider {

    @Override
    public ShelterApplication getShelterApplication() {
        return (ShelterApplication) super.getActivity().getApplication();
    }

}
