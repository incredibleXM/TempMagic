package com.example.asus1.helloworld.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus1.helloworld.Constants;
import com.example.asus1.helloworld.R;



public class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sta,container,false);

        Bundle bundle = getArguments();
        String args = bundle.getString(Constants.KEY_ARGS);


        return view;
    }
}
