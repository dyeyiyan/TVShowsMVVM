package com.deviyan.tvshowsmvvm.responses;

import com.deviyan.tvshowsmvvm.models.TVShowsModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TVShowsResponse {

    @SerializedName("page")
    private int page;

    @SerializedName("pages")
    private int totalPages;

    @SerializedName("tv_shows")
    private List<TVShowsModel> tvShowsModels;

    public int getPage() {
        return page;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public List<TVShowsModel> getTvShowsModels() {
        return tvShowsModels;
    }
}
