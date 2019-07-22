package com.example.android.network.bridge;

import com.example.android.network.exception.RequestFailedException;
import com.example.android.network.route.RetrofitRouteController;
import com.example.android.network.route.dto.RootRoutesDTO;

import java.io.IOException;

import retrofit2.Response;

public class RetrofitRouteBridge {
    private final RetrofitRouteController origin;

    public RetrofitRouteBridge(RetrofitRouteController origin) {
        this.origin = origin;
    }

    public RootRoutesDTO getRoute(String fromPoint, String toPoint) {
        try {
            Response<RootRoutesDTO> response = origin.getRoute(fromPoint, toPoint).execute();

            if (response.isSuccessful()) {
                return response.body();
            } else {
                throw new RequestFailedException(response);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}