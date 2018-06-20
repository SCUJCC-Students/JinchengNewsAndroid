/*
 author 郑维一

 File：TabFragment.java
 Description：The Fragment for first Tab
 Site：www.zhengweiyi.cn
 */

package cn.zhengweiyi.jinchengnewsandroid.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.Objects;

import cn.zhengweiyi.jinchengnewsandroid.MyApplication;
import cn.zhengweiyi.jinchengnewsandroid.R;
import cn.zhengweiyi.jinchengnewsandroid.object.News;
import cn.zhengweiyi.jinchengnewsandroid.object.NewsLab;

public class TabFragment extends Fragment {
    private List<News> newsList;

    /**
     * 从数据库中读取数据，调用NewsAdapter加载item
     * @param inflater LayoutInflater
     * @param container ViewGroup
     * @param savedInstanceState Bundle
     * @return item View
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.fragment_tab, container, false);
        //获取Application
        MyApplication app = (MyApplication) Objects.requireNonNull(getActivity()).getApplication();
        //读取新闻列表
        NewsLab newsLab = new NewsLab(app.getDaoSession().getNewsDao());
        newsList = newsLab.getNewsByCat(0L);
        //显示新闻列表
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        NewsAdapter adapter = new NewsAdapter(newsList);
        recyclerView.setAdapter(adapter);

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