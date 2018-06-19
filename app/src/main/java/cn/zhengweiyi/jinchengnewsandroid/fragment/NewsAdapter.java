package cn.zhengweiyi.jinchengnewsandroid.fragment;

/*
 * author : 郑维一
 *
 * File : NewsAdapter.java
 * Description : 为 RecycleView 创建 ViewHolder 及其要显示的视图
 * Site : www.zhengweiyi.cn
 */

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.zhengweiyi.jinchengnewsandroid.R;
import cn.zhengweiyi.jinchengnewsandroid.activity.ScrollingContentActivity;
import cn.zhengweiyi.jinchengnewsandroid.object.News;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{
    private List<News> mNewsList;


    static class ViewHolder extends RecyclerView.ViewHolder {
        View newsView;
        TextView newsTitle;
        TextView newsAuthor;
        TextView newsViews;
        ImageView newsImage;
        Context context;

        public ViewHolder(View itemView) {
            super(itemView);
            newsView = itemView;
            newsTitle = itemView.findViewById(R.id.newsTitle);
            newsAuthor = itemView.findViewById(R.id.newsAuthor);
            newsViews = itemView.findViewById(R.id.newsViews);
            newsImage = itemView.findViewById(R.id.newsImage);
            context = itemView.getContext();
        }
    }

    public NewsAdapter(List<News> newsList) {
        mNewsList = newsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_title_item_pic_1, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.newsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, ScrollingContentActivity.class);
                context.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        News news = mNewsList.get(position);
        String t = String.format(holder.context.getString(R.string.news_views), news.getViews());
        holder.newsTitle.setText(news.getTitle());
        holder.newsAuthor.setText(news.getAuthor());
        holder.newsViews.setText(t);
        holder.newsImage.setImageResource(news.getImages());
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

}
