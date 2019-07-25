package com.example.android.network.route;

import com.example.android.network.route.dto.request.RouteDefinitionDTO;
import com.example.android.network.route.dto.response.RootRoutesDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RetrofitRouteController {

    String KEY_ROUTE = "vjcfcYUfvnhWpoVkPE3cGEabBSp1Er7R";

    @Headers({"Content-Type:application/json"})
    @POST("directions/v2/route?key=" + KEY_ROUTE)
    Call<RootRoutesDTO> getRoute(
            @Body RouteDefinitionDTO request
    );
}
