/*
 author 郑维一

 File：NewsListAdapter.java
 Description：Adapter of News List
 Site：www.zhengweiyi.cn
 */

package cn.zhengweiyi.jinchengnewsandroid;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.zhengweiyi.jinchengnewsandroid.object.News;

public class NewsListAdapter extends ArrayAdapter<News> {
    private int resourceId;

    NewsListAdapter(Context context, int resource, List<News> objects) {
        super( context, resource, objects);
        // TODO Auto-generated constructor stub
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // TODO Auto-generated method stub
        /* return super.getView(position, convertView, parent); */
        News news = getItem( position);
        View view;
        Context context = getContext();

        if (news!=null) {

            if (convertView == null) {
                view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            } else {
                view = convertView;
            }

            //设置新闻标题
            TextView newTitleText = view.findViewById(R.id.newsTitle);
            newTitleText.setText(news.getTitle());

            //设置新闻作者
            TextView newAuthorText = view.findViewById(R.id.newsAuthor);
            newAuthorText.setText(news.getAuthor());

            //设置新闻浏览量
            TextView newViewsText = view.findViewById(R.id.newsReader);
            String t = String.format(context.getString(R.string.news_views), news.getViews());
            newViewsText.setText(t);

            //设置新闻图片
            ImageView newImageSrc = view.findViewById(R.id.newsImage);

            return view;
        }

        //如果News为空，则返回空
    return null;
    }
}
