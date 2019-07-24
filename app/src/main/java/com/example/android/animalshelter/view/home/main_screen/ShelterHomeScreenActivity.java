package com.example.android.animalshelter.view.home.main_screen;

import android.os.Bundle;

import com.example.android.animalshelter.R;
import com.example.android.animalshelter.backbone.ShelterActivity;
import com.example.android.animalshelter.view.home.main_screen.ioc.HomeScreenViewFactory;
import com.example.android.animalshelter.view.home.main_screen.main_menu_fragment.MainMenuFragment;
import com.example.android.animalshelter.view.home.main_screen.presenter.IShelterHomePresenter;
import com.example.android.animalshelter.view.home.main_screen.view.IShelterHomeView;

import javax.inject.Inject;

import androidx.fragment.app.FragmentTransaction;

public class ShelterHomeScreenActivity extends ShelterActivity {
    private static final String TAG = ShelterHomeScreenActivity.class.getSimpleName();

    @Inject
    IShelterHomePresenter presenter;
    @Inject
    HomeScreenViewFactory factory;
    private IShelterHomeView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter_home);
        if (savedInstanceState == null) {
            final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fl_home_screen_fragment_layout, new MainMenuFragment());
            fragmentTransaction.commit();
            getShelterApplication().dependencyInjection().openShelterHomeScreenScope();
        }
        getShelterApplication().dependencyInjection().inject(this);
        this.view = factory.createView(this);
        presenter.attachView(view);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.presenter.detachView();
        if (isFinishing()) {
            getShelterApplication().dependencyInjection().closeShelterHomeScreenScope();
        }
    }
}
