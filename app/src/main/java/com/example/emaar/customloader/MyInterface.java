package com.example.emaar.customloader;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by emaar on 5/8/17.
 */

public interface MyInterface {
    // Synchronous declaration
    @GET("/posts")
    Call<List<Post>> getPosts();
}
