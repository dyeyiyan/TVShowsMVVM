package com.deviyan.tvshowsmvvm.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.deviyan.tvshowsmvvm.DataBinderMapperImpl;
import com.deviyan.tvshowsmvvm.R;
import com.deviyan.tvshowsmvvm.databinding.ItemContainerTvShowBinding;
import com.deviyan.tvshowsmvvm.models.TVShowsModel;

import java.util.List;

public class TVShowsAdapter extends RecyclerView.Adapter<TVShowsAdapter.TVShowViewHolder> {

    private List<TVShowsModel> tvShowsModels;
    private LayoutInflater layoutInflater;

    public TVShowsAdapter(List<TVShowsModel> tvShowsModels) {
        this.tvShowsModels = tvShowsModels;
    }

    @NonNull
    @Override
    public TVShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(layoutInflater == null) {
            layoutInflater = layoutInflater.from(parent.getContext());
        }
        ItemContainerTvShowBinding tvShowBinding = DataBindingUtil.inflate(
          layoutInflater, R.layout.item_container_tv_show, parent, false
        );

        return new TVShowViewHolder(tvShowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull TVShowViewHolder holder, int position) {
        holder.bindTVShow(tvShowsModels.get(position));
    }


    @Override
    public int getItemCount() {
        return tvShowsModels.size();
    }


    static class TVShowViewHolder extends RecyclerView.ViewHolder{

        private ItemContainerTvShowBinding itemContainerTvShowBinding;

        public TVShowViewHolder(ItemContainerTvShowBinding itemContainerTvShowBinding){
            super(itemContainerTvShowBinding.getRoot());
            this.itemContainerTvShowBinding = itemContainerTvShowBinding;
        }

        public void bindTVShow(TVShowsModel tvShowsModel){
            itemContainerTvShowBinding.setTvShows(tvShowsModel);
            itemContainerTvShowBinding.executePendingBindings();
        }

    }
}
