package com.example.android.animalshelter.view.home.main_screen;

import android.os.Bundle;

import com.example.android.animalshelter.R;
import com.example.android.animalshelter.view.home.main_screen.main_menu_fragment.MainMenu;
import com.example.android.animalshelter.view.home.main_screen.presenter.IShelterHomePresenter;
import com.example.android.animalshelter.view.home.main_screen.presenter.ShelterHomePresenter;
import com.example.android.animalshelter.view.home.main_screen.view.IShelterHomeView;
import com.example.android.animalshelter.view.home.main_screen.view.ShelterHomeView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class ShelterHomeScreen extends AppCompatActivity {
    private static final String TAG = ShelterHomeScreen.class.getSimpleName();

    private IShelterHomePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter_home);
        if (savedInstanceState == null) {
            final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fl_home_screen_fragment_layout, new MainMenu());
            fragmentTransaction.commit();
        }
        final IShelterHomeView view =
                new ShelterHomeView(this);
        presenter = new ShelterHomePresenter(view);
        presenter.onCreate();
    }

}
