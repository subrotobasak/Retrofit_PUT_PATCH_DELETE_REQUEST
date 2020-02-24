package com.example.retrofit_put_patch_delete_request.Interface;

import com.example.retrofit_put_patch_delete_request.Model.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiInterface {


//    Using @POST request
    @GET("posts")
    Call<List<Model>> getAllData();

//    Using @PUT request
    @PUT ("posts/{id}")
    Call<Model>putPost(@Path("id") int id, @Body Model model);

//    Using @PATCH request
    @PATCH("posts/{id}")
    Call<Model>putPatch(@Path("id") int id, @Body Model model);

//    Using @DELETE request
    @DELETE("posts/{id}")
    Call<Void> deletePost(@Path("id")int id);
}


