package com.example.retrofit;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Employees {
    @GET("employees/{employee}")
    Call<Post> getPost(@Path("employee") String employee);

    @GET("employees/2")
    Call<Post> getPost2();

    @GET("employees")
    Call<List<Post>> getPosts();
}