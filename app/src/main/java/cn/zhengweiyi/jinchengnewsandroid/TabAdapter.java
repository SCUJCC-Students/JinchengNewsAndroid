/*
 @author 郑维一

 File：TabAdapter.java
 Description：Adapter
 Site：www.zhengweiyi.cn
 */

package cn.zhengweiyi.jinchengnewsandroid;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class TabAdapter extends FragmentPagerAdapter {

    private String[] tabTitle = {"头条","社团","活动"};
    private List<Fragment> fragmentList = new ArrayList<Fragment>();

    /**
     * 定义fragmentList
     * @param fm FragmentManager
     * @param fragmentList List of Fragment
     */
    public TabAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitle[position];
    }
}
