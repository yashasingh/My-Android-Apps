package com.example.yasha.editor3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.nashapp.androidsummernote.Summernote;

/**
 * Created by yasha on 10/2/17.
 */

public class Myfragment extends Fragment {


    static Summernote summernote;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.myfragment_layout,container,false);
        return view;
    }

}
