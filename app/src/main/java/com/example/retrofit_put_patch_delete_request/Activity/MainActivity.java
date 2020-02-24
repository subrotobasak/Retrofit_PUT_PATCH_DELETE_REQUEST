package com.example.retrofit_put_patch_delete_request.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.widget.Toast;

import com.example.retrofit_put_patch_delete_request.Adapter.UserAdapter;
import com.example.retrofit_put_patch_delete_request.Interface.ApiInterface;
import com.example.retrofit_put_patch_delete_request.Model.Model;
import com.example.retrofit_put_patch_delete_request.R;
import com.example.retrofit_put_patch_delete_request.Retrofit.ApiClient;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private List<Model> models;
    private ApiInterface apiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        getData();
        //updatePost();
        deletePost();
    }

    private void getData() {
//        Using @POST request
        apiInterface = ApiClient.getInstance().getApi();
        Call<List<Model>> call = apiInterface.getAllData();
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {

                models = response.body();
                userAdapter = new UserAdapter(models);
                recyclerView.setAdapter(userAdapter);

            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {

                Toast.makeText(MainActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void updatePost() {
        Model model = new Model(12, null, "New Text");

//        Using @PUT request
//        Call<Model> call = apiInterface.putPost(5,model);

//        Using @PATCH request

        Call<Model> call = apiInterface.putPatch(5, model);
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                Toast.makeText(MainActivity.this, "Update Response Code:" + response.code(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Toast.makeText(MainActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    //    Using @DELETE request
    private void deletePost() {
        Call<Void> call = apiInterface.deletePost(5);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(MainActivity.this, "Delete Response code:" + response.code(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(MainActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void init() {
        recyclerView = findViewById(R.id.userRecyclerViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        models = new ArrayList<>();


    }
}