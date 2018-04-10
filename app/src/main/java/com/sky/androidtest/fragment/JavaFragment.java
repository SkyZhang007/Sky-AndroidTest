package com.sky.androidtest.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sky.androidtest.R;

/**
 * Java 学习列表页面
 */
public class JavaFragment extends Fragment {

    public JavaFragment() {
    }

    public static JavaFragment newInstance() {
        return new JavaFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

}
