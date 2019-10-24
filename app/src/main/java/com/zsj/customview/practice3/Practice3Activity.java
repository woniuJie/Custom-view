package com.zsj.customview.practice3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.zsj.customview.PageFragment;
import com.zsj.customview.R;
import com.zsj.customview.practice3.view.CameraRotateXYHittingFaceView;
import com.zsj.customview.practice3.view.ClipPathView;
import com.zsj.customview.practice3.view.MyImageView;
import com.zsj.customview.practice3.view.StaticLayoutView;
import com.zsj.customview.practice3.view.drawTextOnPathView;

import java.util.ArrayList;
import java.util.List;

public class Practice3Activity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager pager;
    List<PageModel> pageModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice3);


        {
            pageModels.add(new PageModel("drawTextOnPath", new drawTextOnPathView(this)));
            pageModels.add(new PageModel("StaticLayout", new StaticLayoutView(this)));
            pageModels.add(new PageModel("范围裁切", new ClipPathView(this)));
            pageModels.add(new PageModel("camera", new CameraRotateXYHittingFaceView(this)));
            pageModels.add(new PageModel("imageview", new MyImageView(this)));

        }
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                PageModel pageModel = pageModels.get(position);
                return new PageFragment(pageModel.layoutView);
            }

            @Override
            public int getCount() {
                return pageModels.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return pageModels.get(position).titleRes;
            }
        });

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(pager);

        pager.setCurrentItem(pageModels.size() - 1);
    }

    private class PageModel {

        String titleRes;
        View layoutView;

        PageModel(String titleRes, View view) {
            this.titleRes = titleRes;
            this.layoutView = view;
        }
    }
}
