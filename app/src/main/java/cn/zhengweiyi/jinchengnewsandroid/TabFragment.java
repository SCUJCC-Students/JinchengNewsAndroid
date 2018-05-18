package cn.zhengweiyi.jinchengnewsandroid;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TabFragment extends Fragment {

    public TabFragment() {

    }

    /*public static TabFragment newInstance(String text){
        Bundle bundle = new Bundle();
        bundle.putString("text",text);
        TabFragment tabFragment = new TabFragment();
        tabFragment.setArguments(bundle);
        return  tabFragment;
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_tab, container, false);
        inflater.inflate(R.layout.fragment_tab, container, false);
        TextView textView = (TextView) view.findViewById(R.id.pager_text);
        textView.setText("测试文本，锦城头条");

        return view;
    }

    /*@Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = (TextView) view.findViewById(R.id.pager_text);
        //textView.setText(getArguments().getString("text"));
        textView.setText("测试文本，锦城头条");
    }*/
}
