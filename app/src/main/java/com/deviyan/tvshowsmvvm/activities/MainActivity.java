package com.deviyan.tvshowsmvvm.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.deviyan.tvshowsmvvm.R;
import com.deviyan.tvshowsmvvm.adapters.TVShowsAdapter;
import com.deviyan.tvshowsmvvm.databinding.ActivityMainBinding;
import com.deviyan.tvshowsmvvm.models.TVShowsModel;
import com.deviyan.tvshowsmvvm.viewmodels.MostPopularTVShowsViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MostPopularTVShowsViewModel viewModel;
    private ActivityMainBinding activityMainBinding;
    private List<TVShowsModel> tvShowsModels = new ArrayList<>();
    private TVShowsAdapter tvShowsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //setContentView(R.layout.activity_main);
        doInitialization();
    }

    private void doInitialization() {
        activityMainBinding.tvShowsRecyclerView.setHasFixedSize(true);
        viewModel = new ViewModelProvider(this).get(MostPopularTVShowsViewModel.class);
        tvShowsAdapter = new TVShowsAdapter(tvShowsModels);
        activityMainBinding.tvShowsRecyclerView.setAdapter(tvShowsAdapter);
        getMostPopularTVShows();
    }

    private void getMostPopularTVShows() {
        viewModel.getMostPopularTVShows(0).observe(this, mostPopularTVShowsResponse -> {
            activityMainBinding.setIsLoading(false);
            if(mostPopularTVShowsResponse != null){
                if(mostPopularTVShowsResponse.getTvShowsModels() != null){
                    tvShowsModels.addAll(mostPopularTVShowsResponse.getTvShowsModels());
                    tvShowsAdapter.notifyDataSetChanged();
                }
            }
        });
    }


}