/*
 author 郑维一

 File：NewsListFragment.java
 Description：News List Fragment
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

public class NewsListFragment extends Fragment implements AdapterView.OnItemClickListener {
    private ListView newsTitleListView;
    private List<News> newsList;
    private NewsListAdapter adapter;
    // private boolean isTwoPane;

    @Override
    public void onAttach(Activity activity) {
        // TODO Auto-generated method stub
        super.onAttach( activity);
        // 初始化数据
        newsList = getNews();
        adapter=new NewsListAdapter( activity, R.layout. news_title_item_pic_1, newsList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view= inflater.inflate(R.layout. fragment_tab_fragment2, container, false);
        newsTitleListView= view.findViewById(R.id. tab_fragment2_list_view);
        newsTitleListView.setAdapter( adapter);
        newsTitleListView.setOnItemClickListener( this);
        return view;

    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated( savedInstanceState);
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

    /*
     * 初始化数据
     */
    private List<News> getNews() {
        // TODO Auto-generated method stub
        List<News> newsList1 = new ArrayList<News>();
        News new1 = new News();
        News new2 = new News();
        new1.setTitle( "再不睡觉就要死了！熬最长的夜，住最贵的ICU");
        new1.setContent( "说真的，好久没有好好睡个觉了。现在熬夜和面膜都不配了，最配的都变成ICU了。锦城猪健文日了解一下？" );
        new1.setAuthor("郑维一");
        new1.setViews(526);
        new2.setTitle( "2018年四川省高校国旗护卫队联盟会操暨锦城国旗护卫队十周年庆典在我校举行");
        new2.setContent( "锦城国旗护卫队讯 2018年5月26日，2018年四川省高校国旗护卫队联盟会操暨锦城国旗护卫队十周年庆典在我校第一运动场举行，来自四川省27所高校国旗护卫队、国旗班、仪仗队的战友们齐聚锦城。" );
        new2.setAuthor("锦城国旗护卫队");
        new2.setViews(0);
        newsList1.add( new1);
        newsList1.add( new2);
        return newsList1;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        // TODO Auto-generated method stub
        News news= newsList.get( position);
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
        contentActivity. actionStart(getActivity(), news.getTitle(), news.getContent());
    }
}
