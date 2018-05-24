/*
 author 郑维一

 File：NewsListAdapter.java
 Description：Adapter of News List
 Site：www.zhengweiyi.cn
 */

package cn.zhengweiyi.jinchengnewsandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class NewsListAdapter extends ArrayAdapter<News> {
    private int resourceId;

    public NewsListAdapter(Context context, int resource, List<News> objects) {
        super( context, resource, objects);
        // TODO Auto-generated constructor stub
        resourceId = resource;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
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
            TextView newTitleText = (TextView) view.findViewById(R.id.newsTitle);
            newTitleText.setText(news.getTitle());

            //设置新闻作者
            TextView newAuthorText = (TextView) view.findViewById(R.id.newsAuthor);
            newAuthorText.setText(news.getAuthor());

            //设置新闻浏览量
            TextView newViewsText = (TextView) view.findViewById(R.id.newsViews);
            String t = String.format(context.getString(R.string.news_views), news.getViews());
            newViewsText.setText(t);

            //设置新闻图片
            ImageView newImageSrc = (ImageView) view.findViewById(R.id.newsImage);

            return view;
        }

        //如果News为空，则返回空
    return null;
    }
}
