package com.deviyan.tvshowsmvvm.network;

import com.deviyan.tvshowsmvvm.models.TVShowsModel;
import com.deviyan.tvshowsmvvm.responses.TVShowDetailsResponse;
import com.deviyan.tvshowsmvvm.responses.TVShowsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("most-popular")
    Call<TVShowsResponse> getMostPopularTVShows(@Query("page") int page);

    @GET("show-details")
    Call<TVShowDetailsResponse> getTVShowDetails(@Query("q") String tvShowID);


}
