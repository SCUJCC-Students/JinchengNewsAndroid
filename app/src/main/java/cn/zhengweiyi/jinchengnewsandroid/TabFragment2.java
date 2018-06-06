/*
 author 郑维一

 File：TabFragment2.java
 Description：The Fragment for second Tab
 Site：www.zhengweiyi.cn
 */

package cn.zhengweiyi.jinchengnewsandroid;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cn.zhengweiyi.jinchengnewsandroid.object.News;
import cn.zhengweiyi.jinchengnewsandroid.object.NewsLab;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragment2 extends Fragment implements AdapterView.OnItemClickListener {
    private List<News> newsList;
    private NewsListAdapter adapter;
    // private boolean isTwoPane;

    @Override
    public void onAttach(Activity activity) {
        // TODO Auto-generated method stub
        super.onAttach(activity);
        //获取Application
        MyApplication app = (MyApplication) getActivity().getApplication();
        //读取新闻
        NewsLab newsLab = new NewsLab(app.getDaoSession().getNewsDao());
        newsList = newsLab.getNewsByCat(1L);
        //显示新闻列表
        adapter = new NewsListAdapter(activity, R.layout.news_title_item_pic_1, newsList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.fragment_tab_fragment2, container, false);
        ListView newsTitleListView = view.findViewById(R.id.tab_fragment2_list_view);
        newsTitleListView.setAdapter(adapter);
        newsTitleListView.setOnItemClickListener(this);
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        // TODO Auto-generated method stub
        News news = newsList.get(position);
        // 手机横屏显示逻辑
        /*
        if( isTwoPane){
            //双页模式，刷新NewsContentFragment中的内容
            NewsContentFragment newsContentFragment=(NewsContentFragment) getFragmentManager().findFragmentById(R.id.news_content_fragment );
            newsContentFragment.refresh( news.getTitle(), news.getContent());
        } else{
            contentActivity. actionStart(getActivity(), news.getTitle(), news.getContent());
        }
        */
        contentActivity.actionStart(getActivity(), news.getTitle(), news.getContent());
    }
}