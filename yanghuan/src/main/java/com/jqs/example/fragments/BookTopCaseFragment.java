package com.jqs.example.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.jqs.example.activity.BookCaseDeleteActivity;
import com.jqs.example.beans.MyCaseItemBean;
import com.yanghuan.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiangsheng on 2016/5/19.
 */
public class BookTopCaseFragment extends Fragment {
    public static final String MY_MANAGE = "BookTopCaseFragment";
    View mView;
    TextView mTextView;
    ArrayList<MyCaseItemBean> mList;


    Context mContext;
    boolean isflag=false;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mContext=activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       mView= inflater.inflate(R.layout.book_case_top,null);
        mList=new ArrayList<>();

        mTextView= (TextView) mView.findViewById(R.id.case_top_guanli);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent=new Intent(mContext, BookCaseDeleteActivity.class);
               startActivity(intent);

            }
        });

        return mView;
    }

}
