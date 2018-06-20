package cn.zhengweiyi.jinchengnewsandroid.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Objects;

import cn.zhengweiyi.jinchengnewsandroid.MyApplication;
import cn.zhengweiyi.jinchengnewsandroid.R;
import cn.zhengweiyi.jinchengnewsandroid.greendao.NewsDao;
import cn.zhengweiyi.jinchengnewsandroid.object.News;
import cn.zhengweiyi.jinchengnewsandroid.object.NewsLab;

public class ScrollingContentActivity extends AppCompatActivity {
    private NewsLab newsLab;
    News news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling_content);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //接收intent数据
        Intent intent = getIntent();
        Long id = intent.getLongExtra("newsId", 0L);

        //加载页面内容
        setNewsContent(id);

        //收藏按钮
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "收藏功能开发中", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @SuppressLint("SimpleDateFormat")
    private void setNewsContent(Long id) {
        TextView newsTitle = findViewById(R.id.newsTitle);
        TextView newsAuthor = findViewById(R.id.newsAuthor);
        TextView newsTime = findViewById(R.id.newsTime);
        TextView newsContent = findViewById(R.id.newsContent);
        TextView newsViews = findViewById(R.id.newsViews);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分");
        String time;    //发布/更新时间

        //获取Application
        MyApplication app = (MyApplication) getApplication();
        //获取新闻
        newsLab = new NewsLab(app.getDaoSession().getNewsDao());
        news = newsLab.getNewsById(id);
        //设置发布/更新时间
        if(news != null) {
            //判断更新时间是否为空
            if (news.getUpdateTime() == null) {
                time = dateFormat.format(news.getReleaseTime());
            } else {
                time = dateFormat.format(news.getUpdateTime());
            }
            //增加阅读量
            news.setViews(news.getViews() + 1);
            //获取阅读量字符串
            String views = String.format(getApplicationContext().getString(R.string.news_views), news.getViews());

            //设置内容
            newsTitle.setText(news.getTitle());
            newsAuthor.setText(news.getAuthor());
            newsTime.setText(time);
            newsContent.setText(news.getContent());
            toolbarLayout.setBackgroundResource(news.getImages());
            newsViews.setText(views);
            news.update();
        }
    }
}
