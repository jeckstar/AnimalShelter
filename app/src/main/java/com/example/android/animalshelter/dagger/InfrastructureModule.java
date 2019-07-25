package com.example.android.animalshelter.dagger;

import android.content.Context;

import com.example.android.network.route.RetrofitRouteController;
import com.jeka.golub.shelter.domain.animal.AnimalRepository;
import com.jeka.golub.shelter.domain.route.RouteRepository;
import com.jeka.golub.shelter.domain.shelter.ShelterRepository;
import com.jeka.golub.shelter.domain.volunteer.VolunteerRepository;
import com.jeka.golub.shelter.domain.walk.WalkRepository;
import com.jeka.golub.shelter.persistence.ShelterDatabase;
import com.jeka.golub.shelter.persistence.animal.AnimalEntityConverter;
import com.jeka.golub.shelter.persistence.animal.SQLiteAnimalRepository;
import com.jeka.golub.shelter.persistence.migration.DatabaseMigration;
import com.jeka.golub.shelter.persistence.migration.DatabaseMigrationRouteTable;
import com.jeka.golub.shelter.persistence.route.RouteEntityConverter;
import com.jeka.golub.shelter.persistence.route.SQLiteRouteRepository;
import com.jeka.golub.shelter.persistence.shelter.SQLiteShelterRepository;
import com.jeka.golub.shelter.persistence.shelter.ShelterEntityConverter;
import com.jeka.golub.shelter.persistence.volunteer.SQLiteVolunteerRepository;
import com.jeka.golub.shelter.persistence.volunteer.VolunteerEntityConverter;
import com.jeka.golub.shelter.persistence.walk.SQLiteWalkRepository;
import com.jeka.golub.shelter.persistence.walk.WalkEntityConverter;

import javax.inject.Singleton;

import androidx.room.Room;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class InfrastructureModule {

    private static final String FILE_NAME = "shelter.db";
    public static final String MAPQUEST_DOMAIN = "http://open.mapquestapi.com/";

    @Singleton
    @Provides
    public ShelterDatabase shelterDatabase(Context context) {
        synchronized (ShelterDatabase.class) {
            return Room.databaseBuilder(context, ShelterDatabase.class, FILE_NAME)
                    .addMigrations(DatabaseMigration.MIGRATION_1_2)
                    .addMigrations(DatabaseMigrationRouteTable.MIGRATION_2_3)
                    .build();
        }
    }

    @Singleton
    @Provides
    public AnimalRepository animalRepository(ShelterDatabase database) {
        return new SQLiteAnimalRepository(database.getAnimalDao(), new AnimalEntityConverter());
    }

    @Singleton
    @Provides
    public ShelterRepository shelterRepository(ShelterDatabase database) {
        return new SQLiteShelterRepository(database.getShelterDao(), new ShelterEntityConverter());
    }

    @Singleton
    @Provides
    public VolunteerRepository volunteerRepository(ShelterDatabase database) {
        return new SQLiteVolunteerRepository(database.getVolunteerDao(), new VolunteerEntityConverter());
    }

    @Singleton
    @Provides
    public WalkRepository walkRepository(ShelterDatabase database) {
        return new SQLiteWalkRepository(database.getWalkDao(), new WalkEntityConverter());
    }

    @Singleton
    @Provides
    public RouteRepository routeRepository(ShelterDatabase database) {
        return new SQLiteRouteRepository(database.getRouteDao(), new RouteEntityConverter());
    }

    @Singleton
    @Provides
    public Retrofit buildRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(MAPQUEST_DOMAIN)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    @Singleton
    @Provides
    public RetrofitRouteController buildRetrofitRouteController(Retrofit retrofit) {
        return retrofit.create(RetrofitRouteController.class);
    }

}
