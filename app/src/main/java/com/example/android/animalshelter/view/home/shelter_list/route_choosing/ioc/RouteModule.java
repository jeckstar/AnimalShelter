package com.example.android.animalshelter.view.home.shelter_list.route_choosing.ioc;

import com.example.android.animalshelter.view.home.shelter_list.route_choosing.presenter.IRoutePresenter;
import com.example.android.animalshelter.view.home.shelter_list.route_choosing.presenter.RoutePresenter;
import com.example.android.animalshelter.view.home.shelter_list.route_choosing.presenter.RoutesFacade;
import com.example.android.network.route.MapQuestRetrofitRouteService;
import com.example.android.network.route.RetrofitRouteController;
import com.example.android.network.route.RouteFactory;
import com.jeka.golub.shelter.domain.animal.AnimalRepository;
import com.jeka.golub.shelter.domain.route.RouteRepository;
import com.jeka.golub.shelter.domain.volunteer.VolunteerRepository;
import com.jeka.golub.shelter.domain.walk.WalkRepository;

import java.util.concurrent.Executors;

import dagger.Module;
import dagger.Provides;

@Module
@RouteScope
public class RouteModule {

    private final long animalId;
    private final long shelterId;
    private final long volunteerId;

    public RouteModule(long animalId,
                       long shelterId,
                       long volunteerId) {

        this.animalId = animalId;
        this.shelterId = shelterId;
        this.volunteerId = volunteerId;
    }

    @Provides
    @RouteScope
    public IRoutePresenter getAnimalCardPresenter(VolunteerRepository volunteerRepository,
                                                  AnimalRepository animalRepository,
                                                  WalkRepository walkRepository,
                                                  RouteRepository routeRepository,
                                                  RetrofitRouteController controller
    ) {
        return new RoutePresenter(
                new RoutesFacade(
                        volunteerRepository,
                        animalRepository,
                        walkRepository,
                        routeRepository,
                        new MapQuestRetrofitRouteService(
                                controller,
                                new RouteFactory())
                ),
                Executors.newCachedThreadPool(),
                this.animalId,
                this.shelterId,
                this.volunteerId);
    }
}
