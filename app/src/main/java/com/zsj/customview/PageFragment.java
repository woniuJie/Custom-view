package com.zsj.customview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PageFragment extends Fragment {
    private View mLayoutView;

    public PageFragment(View mLayoutView) {
        this.mLayoutView = mLayoutView;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);

        RelativeLayout rl = view.findViewById(R.id.rl_container);
        if(mLayoutView.getParent()!=null){
            ((ViewGroup)mLayoutView.getParent()).removeView(mLayoutView);
        }
        rl.addView(mLayoutView);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
