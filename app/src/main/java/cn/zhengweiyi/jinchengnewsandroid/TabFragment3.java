/*
 author 郑维一

 File：TabFragment3.java
 Description：The Fragment for third Tab
 Site：www.zhengweiyi.cn
 */

package cn.zhengweiyi.jinchengnewsandroid;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragment3 extends Fragment {


    public TabFragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_tab_fragment3, container, false);
        inflater.inflate(R.layout.fragment_tab_fragment3, container, false);
        TextView textView = (TextView) view.findViewById(R.id.fragment_3_text);
        textView.setText("测试文本，锦城头条，活动页");

        return inflater.inflate(R.layout.fragment_tab_fragment3, container, false);
    }

}
