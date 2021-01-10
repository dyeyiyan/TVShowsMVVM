package com.deviyan.tvshowsmvvm.responses;

import com.deviyan.tvshowsmvvm.models.TVShowDetailsModel;
import com.deviyan.tvshowsmvvm.models.TVShowsModel;
import com.google.gson.annotations.SerializedName;

public class TVShowDetailsResponse {

    @SerializedName("tvShow")
    private TVShowDetailsModel tvShowDetailsModel;

    public TVShowDetailsModel getTvShowDetailsModel(){
        return tvShowDetailsModel;
    }


}
