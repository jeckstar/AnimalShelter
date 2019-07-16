package com.example.android.animalshelter.view.home.main_screen;

import android.os.Bundle;

import com.example.android.animalshelter.R;
import com.example.android.animalshelter.backbone.ShelterActivity;
import com.example.android.animalshelter.view.home.main_screen.main_menu_fragment.MainMenuFragment;
import com.example.android.animalshelter.view.home.main_screen.presenter.IShelterHomePresenter;
import com.example.android.animalshelter.view.home.main_screen.presenter.ShelterHomePresenter;
import com.example.android.animalshelter.view.home.main_screen.view.IShelterHomeView;
import com.example.android.animalshelter.view.home.main_screen.view.ShelterHomeView;

import javax.inject.Inject;

import androidx.fragment.app.FragmentTransaction;

public class ShelterHomeScreenActivity extends ShelterActivity {
    private static final String TAG = ShelterHomeScreenActivity.class.getSimpleName();

    @Inject
    IShelterHomePresenter presenter;
    @Inject
    IShelterHomeView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter_home);
        if (savedInstanceState == null) {
            final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fl_home_screen_fragment_layout, new MainMenuFragment());
            fragmentTransaction.commit();
        }
        getShelterApplication().dependencyInjection().inject(this);
        presenter.onCreate();
    }

}
