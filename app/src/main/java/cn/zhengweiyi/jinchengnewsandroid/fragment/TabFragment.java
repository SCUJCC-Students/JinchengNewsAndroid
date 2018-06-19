/*
 author 郑维一

 File：TabFragment.java
 Description：The Fragment for first Tab
 Site：www.zhengweiyi.cn
 */

package cn.zhengweiyi.jinchengnewsandroid.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import cn.zhengweiyi.jinchengnewsandroid.MyApplication;
import cn.zhengweiyi.jinchengnewsandroid.R;
import cn.zhengweiyi.jinchengnewsandroid.activity.MainActivity;
import cn.zhengweiyi.jinchengnewsandroid.activity.ScrollingContentActivity;
import cn.zhengweiyi.jinchengnewsandroid.object.News;
import cn.zhengweiyi.jinchengnewsandroid.object.NewsLab;

public class TabFragment extends Fragment {
    private List<News> newsList;
    //private NewsAdapter adapter;
    // private boolean isTwoPane;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.fragment_tab, container, false);
        //获取Application
        MyApplication app = (MyApplication) getActivity().getApplication();

        NewsLab newsLab = new NewsLab(app.getDaoSession().getNewsDao());
        newsList = newsLab.getNewsByCat(0L);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        NewsAdapter adapter = new NewsAdapter(newsList);
        recyclerView.setAdapter(adapter);
        //暂时注释掉ListView
        //ListView newsTitleListView = view.findViewById(R.id.tab_fragment_list_view);
        //newsTitleListView.setAdapter(adapter);
        //newsTitleListView.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        // 手机横屏显示逻辑
        /*
        if (getActivity().findViewById(R.id.news_content_layout )!=null) {
            //可以找到news_content-fragment布局的时候，为双页布局
            isTwoPane= true;
        } else {
            isTwoPane= false;
        }
        */
    }

}