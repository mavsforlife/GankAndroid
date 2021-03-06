package com.victor.gankandroid.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.victor.gankandroid.Model.base.DetailData;
import com.victor.gankandroid.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by victor on 16-5-8.
 */
public class DetailListAdapter extends RecyclerView.Adapter<DetailListAdapter.ViewHolder> {

    private Context mContext;
    private List<DetailData> mLists;

    public DetailListAdapter(Context context) {
        mContext = context;
        mLists = new ArrayList<>();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        return new ViewHolder(inflater.inflate(R.layout.item_detail, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        if (null != mLists) {
            holder.mTvAuthor.setText(mLists.get(position).getWho());
            holder.mTvCreateDate.setText(mLists.get(position).getCreatedAt());
            holder.mTvDesc.setText(mLists.get(position).getDesc());
            holder.mTvUrl.setText(mLists.get(position).getUrl());
        }
    }

    @Override
    public int getItemCount() {
        return mLists.size();
    }

    public List<DetailData> getList() {
        return mLists;
    }

    public void addMoreData(List<DetailData> list) {
        mLists.addAll(list);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_author)
        TextView mTvAuthor;
        @BindView(R.id.tv_create_date)
        TextView mTvCreateDate;
        @BindView(R.id.tv_desc)
        TextView mTvDesc;
        @BindView(R.id.tv_url)
        TextView mTvUrl;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
