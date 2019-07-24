package com.example.android.animalshelter.view.home.shelter_list.route_choosing.presenter;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.example.android.animalshelter.view.home.shelter_list.route_choosing.model.LocationPM;
import com.example.android.animalshelter.view.home.shelter_list.route_choosing.view.IRouteView;
import com.jeka.golub.shelter.domain.animal.Animal;
import com.jeka.golub.shelter.domain.route.Location;
import com.jeka.golub.shelter.domain.route.Route;
import com.jeka.golub.shelter.domain.volunteer.Volunteer;
import com.jeka.golub.shelter.domain.walk.Walk;
import com.jeka.golub.shelter.domain.walk.WalkException;

import java.util.Date;
import java.util.concurrent.ExecutorService;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static io.reactivex.Single.fromCallable;

public class RoutePresenter implements IRoutePresenter {

    private final RoutesFacade facade;
    private final ExecutorService executor;
    private final long currentAnimalId;
    private final long shelterId;
    private final long currentVolunteerId;
    private IRouteView view;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    public RoutePresenter(
            RoutesFacade facade, ExecutorService executor,
            long currentAnimal,
            long shelterId,
            long currentVolunteerId) {
        this.facade = facade;
        this.executor = executor;
        this.currentAnimalId = currentAnimal;
        this.shelterId = shelterId;
        this.currentVolunteerId = currentVolunteerId;
    }

    @Override
    public void onShowSelectedItem() {
        executor.execute(() -> {
            final Animal currentAnimal = facade.getAnimalById(currentAnimalId);
            final Volunteer currentVolunteer = facade.getVolunteerById(currentVolunteerId);
            new Handler(Looper.getMainLooper()).post(() -> view.showSelectedItem(
                    currentAnimal.getKind(),
                    currentAnimal.getName(),
                    currentVolunteer.getFirstName(),
                    currentVolunteer.getLastName())
            );
        });
    }

    @SuppressWarnings({"ResultOfMethodCallIgnored", "ConstantConditions"})
    @SuppressLint("CheckResult")
    @Override
    public void onTakeAnimalForAWalk() {
        executor.execute(() -> {
            try {
                final Volunteer volunteer = facade.getVolunteerById(currentVolunteerId);
                final Animal currentAnimal = facade.getAnimalById(currentAnimalId);
                final Date now = new Date();
                final Walk walk = volunteer.takeToTheWalk(currentAnimal, now);
                final Animal updateAnimal = currentAnimal.setLastWalkTime(now);
                facade.addWalk(walk);
                facade.updateAnimal(shelterId, updateAnimal);
                new Handler(Looper.getMainLooper()).post(() -> view.showThatVolunteerTakeAnimalForAWalkSuccessfully());
            } catch (WalkException e) {
                e.printStackTrace();
                new Handler(Looper.getMainLooper()).post(view::showWarningMassage);
            }
        });
//        fromSingleSources(
//                fromCallable(() -> facade.getVolunteerById(currentVolunteerId)),
//                fromCallable(() -> facade.getAnimalById(currentAnimalId)),
//                this::takeAnimalForAWalk
//        )
//                .doOnSubscribe(compositeDisposable::add)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(view::showThatVolunteerTakeAnimalForAWalkSuccessfully, e -> view.showWarningMassage());
    }

    private void takeAnimalForAWalk(Volunteer volunteer, Animal animal) {
        final Date now = new Date();
        final Walk walk = volunteer.takeToTheWalk(animal, now);
        final Animal updateAnimal = animal.setLastWalkTime(now);
        facade.addWalk(walk);
        facade.updateAnimal(shelterId, updateAnimal);
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @SuppressLint("CheckResult")
    @Override
    public void onCreateRoute(Location from, Location to) {
        fromCallable(() -> facade.getRoute(from, to))
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
    public void attachView(IRouteView view) {
        this.view = view;
        onShowSelectedItem();
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
