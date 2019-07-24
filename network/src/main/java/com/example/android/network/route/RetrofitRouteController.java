package com.example.android.network.route;

import com.example.android.network.route.dto.RootRoutesDTO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitRouteController {

    String KEY_ROUTE = "vjcfcYUfvnhWpoVkPE3cGEabBSp1Er7R";

    @GET("directions/v2/route?key=" + KEY_ROUTE)
    Call<RootRoutesDTO> getRoute(
            @Query(value = "from", encoded = true) String fromPoint,
            @Query(value = "to", encoded = true) String toPoint
    );
}
