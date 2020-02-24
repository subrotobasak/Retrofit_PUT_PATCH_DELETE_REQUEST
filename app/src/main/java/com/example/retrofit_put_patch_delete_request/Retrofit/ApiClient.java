package com.example.retrofit_put_patch_delete_request.Retrofit;

import com.example.retrofit_put_patch_delete_request.Interface.ApiInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static ApiClient apiClient;
    private static Retrofit retrofit;

    //Constructor Instance

    public ApiClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiClient getInstance() {
        if (apiClient == null) {
            apiClient = new ApiClient();
        }

        return apiClient;
    }

    public ApiInterface getApi() {
        return retrofit.create(ApiInterface.class);
    }


}

// This mechanism all time same for all projects, just "BASE_URL" will be changed.

