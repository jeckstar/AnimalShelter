package com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.route_display.presenter;

import android.annotation.SuppressLint;
import android.util.Log;

import com.example.android.animalshelter.view.home.shelter_list.route_choosing.model.LocationPM;
import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.route_display.view.IRouteDisplayView;
import com.jeka.golub.shelter.domain.route.Route;
import com.jeka.golub.shelter.domain.route.RouteRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Executor;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static io.reactivex.Single.fromCallable;

public class RouteDisplayPresenter implements IRouteDisplayPresenter {

    private IRouteDisplayView view;
    private final RouteRepository routeRepository;
    private final Executor executor;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private Collection<Route> routeSegments = new ArrayList<>();
    private final long currentWalk;


    public RouteDisplayPresenter(RouteRepository routeRepository, Executor executor, long currentWalk) {
        this.routeRepository = routeRepository;
        this.executor = executor;
        this.currentWalk = currentWalk;
    }

    @Override
    public void onCreate(IRouteDisplayView view) {
        attachView(view);
    }


    @SuppressWarnings("ResultOfMethodCallIgnored")
    @SuppressLint("CheckResult")
    @Override
    public void onDisplayRoute() {
        fromCallable(() -> {
            Route route = routeRepository.getRouteByWalkId(currentWalk);
            routeSegments.add(route);
            return route;
        })
                .map(Route::getLocations)
                .flatMapObservable(Observable::fromIterable)
                .map(LocationPM::new)
                .toList()
                .doOnSubscribe(compositeDisposable::add)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(view::drawPolyline,
                        error -> Log.e("Route", "Error occurred", error));
    }


    @Override
    public void attachView(IRouteDisplayView view) {
        this.view = view;
        onDisplayRoute();
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
