package com.deviyan.tvshowsmvvm.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.deviyan.tvshowsmvvm.repositories.TVShowDetailsRepository;
import com.deviyan.tvshowsmvvm.responses.TVShowDetailsResponse;

public class TVShowDetailsViewModel extends ViewModel {

    private TVShowDetailsRepository tvShowDetailsRepository;

    public TVShowDetailsViewModel() {
        tvShowDetailsRepository = new TVShowDetailsRepository();
    }

    public LiveData<TVShowDetailsResponse> getTVShowDetails (String tvShowId){
        return tvShowDetailsRepository.getTVShowDetails(tvShowId);
    }

}
