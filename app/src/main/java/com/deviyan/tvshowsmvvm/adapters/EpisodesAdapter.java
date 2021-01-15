package com.deviyan.tvshowsmvvm.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.deviyan.tvshowsmvvm.R;
import com.deviyan.tvshowsmvvm.databinding.ItemContainerEpisodeBinding;
import com.deviyan.tvshowsmvvm.models.EpisodeModel;

import java.util.List;

public class EpisodesAdapter extends RecyclerView.Adapter<EpisodesAdapter.EpisodeViewHolder>{

    private List<EpisodeModel> episodeModelList;
    private LayoutInflater layoutInflater;

    public EpisodesAdapter(List<EpisodeModel> episodeModelList) {
        this.episodeModelList = episodeModelList;
    }

    @NonNull
    @Override
    public EpisodeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(layoutInflater == null){
            layoutInflater = layoutInflater.from(parent.getContext());
        }
        ItemContainerEpisodeBinding itemContainerEpisodeBinding = DataBindingUtil.inflate(
          layoutInflater, R.layout.item_container_episode, parent, false
        );
        return new EpisodeViewHolder(itemContainerEpisodeBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull EpisodeViewHolder holder, int position) {
        holder.bindEpisode(episodeModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return episodeModelList.size();
    }

    static class EpisodeViewHolder extends RecyclerView.ViewHolder{

        private ItemContainerEpisodeBinding itemContainerEpisodeBinding;

        public EpisodeViewHolder(ItemContainerEpisodeBinding itemContainerEpisodeBinding){
            super(itemContainerEpisodeBinding.getRoot());
            this.itemContainerEpisodeBinding = itemContainerEpisodeBinding;
        }

        public void bindEpisode(EpisodeModel episodeModel){
            String title = "s";
            String season = episodeModel.getSeason();
            if(season.length() ==1){
                season = "0".concat(season);
            }
            String episodesNumber = episodeModel.getEpisode();
            if(episodesNumber.length() ==1) {
                episodesNumber = "0".concat(episodesNumber);
            }
            episodesNumber = "E".concat(episodesNumber);
            title = title.concat(season).concat(episodesNumber);
            itemContainerEpisodeBinding.setTitle(title);
            itemContainerEpisodeBinding.setName(episodeModel.getName());
            itemContainerEpisodeBinding.setAirDate(episodeModel.getAirDate());
        }

    }
}
