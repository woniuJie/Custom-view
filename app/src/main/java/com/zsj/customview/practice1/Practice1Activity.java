package com.zsj.customview.practice1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.zsj.customview.PageFragment;
import com.zsj.customview.R;
import com.zsj.customview.practice1.view.DrawArcView;
import com.zsj.customview.practice1.view.DrawBingTuView;
import com.zsj.customview.practice1.view.DrawBitmapView;
import com.zsj.customview.practice1.view.DrawCircleView;
import com.zsj.customview.practice1.view.DrawColorView;
import com.zsj.customview.practice1.view.DrawLineView;
import com.zsj.customview.practice1.view.DrawOvalView;
import com.zsj.customview.practice1.view.DrawPathView;
import com.zsj.customview.practice1.view.DrawPointView;
import com.zsj.customview.practice1.view.DrawRectView;
import com.zsj.customview.practice1.view.DrawRoundRectView;
import com.zsj.customview.practice1.view.DrawTextView;

import java.util.ArrayList;
import java.util.List;

public class Practice1Activity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager pager;
    List<PageModel> pageModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_one);

        {
            pageModels.add(new PageModel("画颜色", new DrawColorView(this)));
            pageModels.add(new PageModel("画圆", new DrawCircleView(this)));
            pageModels.add(new PageModel("画矩形", new DrawRectView(this)));
            pageModels.add(new PageModel("画椭圆", new DrawOvalView(this)));
            pageModels.add(new PageModel("画线", new DrawLineView(this)));
            pageModels.add(new PageModel("画圆角矩形", new DrawRoundRectView(this)));
            pageModels.add(new PageModel("画扇形", new DrawArcView(this)));
            pageModels.add(new PageModel("画自定义图形", new DrawPathView(this)));
            pageModels.add(new PageModel("画Bitmap", new DrawBitmapView(this)));
            pageModels.add(new PageModel("画字", new DrawTextView(this)));
            pageModels.add(new PageModel("画饼图", new DrawBingTuView(this)));



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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
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
