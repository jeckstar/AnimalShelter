package com.example.android.animalshelter.view.home.shelter_list.route_choosing.presenter;

import com.jeka.golub.shelter.domain.animal.Animal;
import com.jeka.golub.shelter.domain.animal.AnimalRepository;
import com.jeka.golub.shelter.domain.route.Location;
import com.jeka.golub.shelter.domain.route.Route;
import com.jeka.golub.shelter.domain.route.RouteRepository;
import com.jeka.golub.shelter.domain.route.RouteService;
import com.jeka.golub.shelter.domain.volunteer.Volunteer;
import com.jeka.golub.shelter.domain.volunteer.VolunteerRepository;
import com.jeka.golub.shelter.domain.walk.Walk;
import com.jeka.golub.shelter.domain.walk.WalkRepository;

public class RoutesFacade {

    private final VolunteerRepository volunteerRepository;
    private final AnimalRepository animalRepository;
    private final WalkRepository walkRepository;
    private final RouteRepository routeRepository;
    private final RouteService routeService;

    public RoutesFacade(VolunteerRepository volunteerRepository,
                        AnimalRepository animalRepository,
                        WalkRepository walkRepository,
                        RouteRepository routeRepository,
                        RouteService routeService) {
        this.volunteerRepository = volunteerRepository;
        this.animalRepository = animalRepository;
        this.walkRepository = walkRepository;
        this.routeRepository = routeRepository;
        this.routeService = routeService;
    }

    public Animal getAnimalById(long id) {
        return animalRepository.getById(id);
    }

    public Volunteer getVolunteerById(long id) {
        return volunteerRepository.getById(id);
    }

    public void addWalk(Walk walk) {
        walkRepository.add(walk);
    }
    public long getWalkInfo(Walk walk){
        return walkRepository.getWalkId(walk);
    }

    public void updateAnimal(long shelterId, Animal updatedAnimal) {
        animalRepository.update(updatedAnimal, shelterId);
    }

    public Route getRoute(Location from, Location to) {
        return routeService.getRoute(from, to);
    }

    public void addRoute(Route route) {
        routeRepository.add(route);
    }
}
