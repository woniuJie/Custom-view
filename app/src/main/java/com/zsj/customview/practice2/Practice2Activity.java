package com.zsj.customview.practice2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.zsj.customview.PageFragment;
import com.zsj.customview.R;
import com.zsj.customview.practice1.Practice1Activity;
import com.zsj.customview.practice1.view.DrawArcView;
import com.zsj.customview.practice1.view.DrawBingTuView;
import com.zsj.customview.practice1.view.DrawBitmapView;
import com.zsj.customview.practice1.view.DrawCircleView;
import com.zsj.customview.practice1.view.DrawColorView;
import com.zsj.customview.practice1.view.DrawLineView;
import com.zsj.customview.practice1.view.DrawOvalView;
import com.zsj.customview.practice1.view.DrawPathView;
import com.zsj.customview.practice1.view.DrawRectView;
import com.zsj.customview.practice1.view.DrawRoundRectView;
import com.zsj.customview.practice1.view.DrawTextView;
import com.zsj.customview.practice2.view.BitmapShaderView;
import com.zsj.customview.practice2.view.BlurMaskFilterView;
import com.zsj.customview.practice2.view.ComposeShaderView;
import com.zsj.customview.practice2.view.LightingColorFilterView;
import com.zsj.customview.practice2.view.LinerGradientView;
import com.zsj.customview.practice2.view.PathEffectView;
import com.zsj.customview.practice2.view.RadialGradientView;
import com.zsj.customview.practice2.view.StrokeJoinView;
import com.zsj.customview.practice2.view.SweepGradientView;

import java.util.ArrayList;
import java.util.List;

public class Practice2Activity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager pager;
    List<PageModel> pageModels = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice2);


        {
            pageModels.add(new PageModel("线性渐变", new LinerGradientView(this)));
            pageModels.add(new PageModel("辐射渐变", new RadialGradientView(this)));
            pageModels.add(new PageModel("扫描渐变", new SweepGradientView(this)));
            pageModels.add(new PageModel("BitmapShader", new BitmapShaderView(this)));
            pageModels.add(new PageModel("混合Bitmap", new ComposeShaderView(this)));
            pageModels.add(new PageModel("LightingColorFilter", new LightingColorFilterView(this)));
            pageModels.add(new PageModel("StrokeJoin", new StrokeJoinView(this)));
            pageModels.add(new PageModel("PathEffect", new PathEffectView(this)));
            pageModels.add(new PageModel("BlurMaskFilter", new BlurMaskFilterView(this)));

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
