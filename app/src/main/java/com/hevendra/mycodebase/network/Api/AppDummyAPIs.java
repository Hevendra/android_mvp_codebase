package com.hevendra.mycodebase.network.Api;

import com.hevendra.mycodebase.network.Responces.ImageListResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Hevendra.Jadaun on 3/23/2018.
 */

public interface AppDummyAPIs {
    @GET("get.php")
    Call<ImageListResponse> getNewestWallPaper(@Query("auth") String auth, @Query("method") String method, @Query("page") String page_number, @Query("info_level") int level);

    @GET("get.php")
    Call<ImageListResponse> getHighestRated(@Query("auth") String auth, @Query("method") String method, @Query("info_level") int level);
}
