/*
 author 郑维一

 File：MainActivity.java
 Description：Main activity
 Site：www.zhengweiyi.cn
 */

package cn.zhengweiyi.jinchengnewsandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import cn.zhengweiyi.jinchengnewsandroid.MyApplication;
import cn.zhengweiyi.jinchengnewsandroid.R;
import cn.zhengweiyi.jinchengnewsandroid.TabAdapter;
import cn.zhengweiyi.jinchengnewsandroid.VideoTabAdapter;
import cn.zhengweiyi.jinchengnewsandroid.fragment.TabFragment;
import cn.zhengweiyi.jinchengnewsandroid.fragment.TabFragment2;
import cn.zhengweiyi.jinchengnewsandroid.fragment.TabFragment3;
import cn.zhengweiyi.jinchengnewsandroid.object.NewsLab;

public class VideoActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TabLayout tab;
    private ViewPager pager;
    private List<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        /*初始化数据*/
        MyApplication app = (MyApplication) getApplication();
        NewsLab newsLab = new NewsLab(app.getDaoSession().getNewsDao());
        if (newsLab.getNewsById(1L) == null) {
            app.initData();
        }
        // TODO 访问网络
        initViews();
        /*设置Adapter*/
        TabFragment tabFragment = new TabFragment();
        fragmentList =new ArrayList<>();
        fragmentList.add(tabFragment);
        fragmentList.add(new TabFragment2());
        fragmentList.add(new TabFragment3());
        pager.setAdapter(new VideoTabAdapter(getSupportFragmentManager(),fragmentList));

        /*Tab与ViewPager绑定*/
        tab.setupWithViewPager(pager);
    }

    /*初始化界面*/
    private void initViews() {
        this.pager =  findViewById(R.id.pager);
        this.tab = findViewById(R.id.tab);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /**
     * 创建右上角菜单按钮
     * @param menu 菜单
     * @return 返回布尔值
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * 选中右上角菜单选项
     * @param item 菜单选项
     * @return 返回布尔值
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            Intent intent = new Intent(this,SearchActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * 左滑菜单
     * @param item 菜单项
     * @return 返回布尔值
     */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_news) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {
            Intent intent = new Intent(this, ImageActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_video) {
            //Intent intent = new Intent(this, VideoActivity.class);
            //startActivity(intent);
        } else if (id == R.id.nav_setting) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
