package com.example.asus1.helloworld.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.asus1.helloworld.Constants;
import com.example.asus1.helloworld.CustomCurveChart;
import com.example.asus1.helloworld.R;

import java.util.ArrayList;
import java.util.List;


public class FragmentTwo extends Fragment {
    private LinearLayout customCurveChart1,customCurveChart2;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sta,container,false);

        customCurveChart1 = (LinearLayout) view.findViewById(R.id.customCurveChart1);
        initCurveChart1();
        customCurveChart2 = (LinearLayout) view.findViewById(R.id.customCurveChart2);
        initCurveChart2();

        return view;
    }

    public static FragmentTwo newInstance(String s){
        Bundle bundle = new Bundle();
        bundle.putString(Constants.KEY_ARGS,s);
        FragmentTwo fragment = new FragmentTwo();
        fragment.setArguments(bundle);
        return fragment;
    }

    private void initCurveChart1() {
        String[] xLabel = {"0分", "5分", "10分", "15分", "20分", "25分", "30分", "35分", "40分", "45分", "50分", "55分", "60分"};
        String[] yLabel = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
        int[] data3 = {500, 700, 750, 700, 500, 900, 1000, 950, 750, 800, 600, 500, 400};
        List<int[]> data = new ArrayList<>();
        List<Integer> color = new ArrayList<>();
        data.add(data3);
        color.add(R.color.color25);
        customCurveChart1.addView(new CustomCurveChart(view.getContext(), xLabel, yLabel, data, color, false));
    }

    private void initCurveChart2() {
        String[] xLabel = {"0点", "2点", "4点", "6点", "8点", "10点", "12点", "14点", "16点", "18点", "20点", "22点", "24点"};
        String[] yLabel = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
        int[] data1 = {600, 630, 750, 720, 710, 780, 850, 910, 870, 750, 720, 710, 710};
        int[] data2 = {710, 730, 790, 740, 700, 810, 890, 1030, 930, 900, 860, 850, 830};
        List<int[]> data = new ArrayList<>();
        List<Integer> color = new ArrayList<>();
        data.add(data1);
        color.add(R.color.color26);
        data.add(data2);
        color.add(R.color.color14);
        customCurveChart2.addView(new CustomCurveChart(view.getContext(), xLabel, yLabel, data, color, true));
    }


}
