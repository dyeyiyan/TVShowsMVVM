package com.deviyan.tvshowsmvvm.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;

import com.deviyan.tvshowsmvvm.R;
import com.deviyan.tvshowsmvvm.databinding.ActivityTVShowDetailsBinding;
import com.deviyan.tvshowsmvvm.models.TVShowDetailsModel;
import com.deviyan.tvshowsmvvm.viewmodels.TVShowDetailsViewModel;

public class TVShowDetailsActivity extends AppCompatActivity {

    private ActivityTVShowDetailsBinding activityTVShowDetailsBinding;
    private TVShowDetailsViewModel tvShowDetailsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityTVShowDetailsBinding = DataBindingUtil.setContentView(this, R.layout.activity_t_v_show_details);
        //setContentView(R.layout.activity_t_v_show_details);
        doInitialization();

    }

    private void doInitialization(){
        tvShowDetailsViewModel = new ViewModelProvider(this).get(TVShowDetailsViewModel.class);
        getTVShowDetails();

    }

    private void getTVShowDetails() {
        String tvShowId = String.valueOf(getIntent().getIntExtra("id", -1));

        tvShowDetailsViewModel.getTVShowDetails(tvShowId).observe(
                this, tvShowDetailsResponse -> {
                    activityTVShowDetailsBinding.setIsLoading(false);
                    Toast.makeText(getApplicationContext(), tvShowDetailsResponse.getTvShowDetailsModel().getUrl(),
                            Toast.LENGTH_SHORT).show();
                });
    }

}