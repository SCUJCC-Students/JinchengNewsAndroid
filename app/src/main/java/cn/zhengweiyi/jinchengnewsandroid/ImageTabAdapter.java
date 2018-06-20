package cn.zhengweiyi.jinchengnewsandroid;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ImageTabAdapter extends FragmentPagerAdapter {

    private String[] tabTitle = {"精选","趣图","故事"};
    private List<Fragment> fragmentList = new ArrayList<Fragment>();

    /**
     * 定义fragmentList
     * @param fm FragmentManager
     * @param fragmentList List of Fragment
     */
    public ImageTabAdapter(FragmentManager fm, List<Fragment> fragmentList) {
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
