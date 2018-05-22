package cn.zhengweiyi.jinchengnewsandroid;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class NewsListAdapter extends ArrayAdapter<News> {
    private int resourecId;

    public NewsListAdapter(Context context, int resource, List<News> objects) {
        super( context, resource, objects);
        // TODO Auto-generated constructor stub
        resourecId = resource;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        /* return super.getView(position, convertView, parent); */
        News news = getItem( position);
        View view;
        if (news!=null) {

            if (convertView == null) {
                view = LayoutInflater.from(getContext()).inflate(resourecId, null);
            } else {
                view = convertView;
            }
            //设置新闻标题
            TextView newTitleText = (TextView) view.findViewById(R.id.newsTitle);
            newTitleText.setText(news.getTitle());
            //设置新闻作者
            TextView newAuthorText = (TextView) view.findViewById(R.id.newsAuthor);
            newAuthorText.setText(news.getAuthor());
            //设置新闻浏览量
            // TODO move getResources() to Activity
            TextView newViewsText = (TextView) view.findViewById(R.id.newsViews);
            String t = String.format(getResources().getString(R.string.news_views), news.getViews());
            newViewsText.setText(t);
            //设置新闻图片
            ImageView newImageSrc = (ImageView) view.findViewById(R.id.newsImage);
        }
        return view;
    }
}
