package com.example.asus1.helloworld.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus1.helloworld.Constants;
import com.example.asus1.helloworld.R;


public class FragmentOne extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_third,container,false);

        return view;
    }

    public static FragmentOne newInstance(String s){
        Bundle bundle = new Bundle();
        bundle.putString(Constants.KEY_ARGS,s);
        FragmentOne fragment = new FragmentOne();
        fragment.setArguments(bundle);
        return fragment;
    }

}
