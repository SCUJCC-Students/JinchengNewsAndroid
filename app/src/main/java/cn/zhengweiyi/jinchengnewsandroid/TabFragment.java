/*
 author 郑维一

 File：TabFragment.java
 Description：The Fragment for first Tab
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

public class TabFragment extends Fragment implements AdapterView.OnItemClickListener {
    private List<News> newsList;
    private NewsListAdapter adapter;
    // private boolean isTwoPane;

    @Override
    public void onAttach(Activity activity) {
        // TODO Auto-generated method stub
        super.onAttach(activity);
        // 初始化数据
//        newsList = getNews();
        MyApplication app = (MyApplication) getActivity().getApplication();
        NewsLab newsLab = new NewsLab(app.getDaoSession().getNewsDao());
        newsList = newsLab.getNews();
        adapter = new NewsListAdapter(activity, R.layout.news_title_item_pic_1, newsList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.fragment_tab, container, false);
        ListView newsTitleListView = view.findViewById(R.id.tab_fragment_list_view);
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

    /*
     * 初始化数据
     */
    private List<News> getNews() {
        // TODO Auto-generated method stub
        List<News> newsList1 = new ArrayList<>();
        News new1 = new News();
        News new2 = new News();
        News new3 = new News();
        News new4 = new News();
        News new5 = new News();
        News new6 = new News();
        News new7 = new News();
        News new8 = new News();
        new1.setTitle("再不睡觉就要死了！熬最长的夜，住最贵的ICU");
        new1.setContent("说真的，好久没有好好睡个觉了。现在熬夜和面膜都不配了，最配的都变成ICU了。锦城猪健文日了解一下？");
        new1.setAuthor("郑维一");
        new1.setViews(526);
        new2.setTitle("2018年四川省高校国旗护卫队联盟会操暨锦城国旗护卫队十周年庆典在我校举行");
        new2.setContent("锦城国旗护卫队讯 2018年5月26日，2018年四川省高校国旗护卫队联盟会操暨锦城国旗护卫队十周年庆典在我校第一运动场举行，来自四川省27所高校国旗护卫队、国旗班、仪仗队的战友们齐聚锦城。");
        new2.setAuthor("锦城国旗护卫队");
        new2.setViews(2387);
        new3.setTitle("毕业季，3招教你拍出网红毕业照");
        new3.setContent("no");
        new3.setAuthor("锦城青年");
        new3.setViews(127);
        new4.setTitle("和西瓜最配的动画电影");
        new4.setContent("no");
        new4.setAuthor("四川大学锦城学院");
        new4.setViews(36);
        new5.setTitle("我校第十二届大学生创新创业大赛总决赛暨颁奖典礼精彩预告");
        new5.setContent("no");
        new5.setAuthor("四川大学锦城学院");
        new5.setViews(90);
        new6.setTitle("小便带你回顾去年做客锦大的那些明星");
        new6.setContent("no");
        new6.setAuthor("四川大学锦城学院");
        new6.setViews(1370);
        new7.setTitle("民谣伴你度周末！");
        new7.setContent("no");
        new7.setAuthor("四川大学锦城学院");
        new7.setViews(130);
        new8.setTitle("思考未来 方可赢得未来 —— 《未来型教育论坛学术论文集》");
        new8.setContent("no");
        new8.setAuthor("四川大学锦城学院");
        new8.setViews(38);
        newsList1.add(new1);
        newsList1.add(new2);
        newsList1.add(new3);
        newsList1.add(new4);
        newsList1.add(new5);
        newsList1.add(new6);
        newsList1.add(new7);
        newsList1.add(new8);
        return newsList1;
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