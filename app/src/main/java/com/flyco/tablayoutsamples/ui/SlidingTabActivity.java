package com.flyco.tablayoutsamples.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.flyco.tablayout.widget.MsgView;
import com.flyco.tablayoutsamples.R;
import com.flyco.tablayoutsamples.utils.ViewFindUtils;

import java.util.ArrayList;

public class SlidingTabActivity extends AppCompatActivity implements OnTabSelectListener {
    private Context mContext = this;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private final String[] mTitles = {
            "热门", "iOS", "Android"
            , "前端", "后端", "设计", "工具资源"
    };
    private MyPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_tab);

        for (String title : mTitles) {
            mFragments.add(SimpleCardFragment.getInstance(title));
        }


        View decorView = getWindow().getDecorView();
        final ViewPager vp = ViewFindUtils.find(decorView, R.id.vp);
        mAdapter = new MyPagerAdapter(getSupportFragmentManager());
        vp.setAdapter(mAdapter);

        /** 默认 */
//        SlidingTabLayout tabLayout_1 = ViewFindUtils.find(decorView, R.id.tl_1);
//        /**自定义部分属性*/
        final SlidingTabLayout tabLayout_2 = ViewFindUtils.find(decorView, R.id.tl_2);
//        /** 字体加粗,大写 */
//        SlidingTabLayout tabLayout_3 = ViewFindUtils.find(decorView, R.id.tl_3);
//        /** tab固定宽度 */
//        SlidingTabLayout tabLayout_4 = ViewFindUtils.find(decorView, R.id.tl_4);
//        /** indicator固定宽度 */
//        SlidingTabLayout tabLayout_5 = ViewFindUtils.find(decorView, R.id.tl_5);
//        /** indicator圆 */
//        SlidingTabLayout tabLayout_6 = ViewFindUtils.find(decorView, R.id.tl_6);
//        /** indicator矩形圆角 */
//        final SlidingTabLayout tabLayout_7 = ViewFindUtils.find(decorView, R.id.tl_7);
        /** indicator三角形 */
//        SlidingTabLayout tabLayout_8 = ViewFindUtils.find(decorView, R.id.tl_8);
//        /** indicator圆角色块 */
//        SlidingTabLayout tabLayout_9 = ViewFindUtils.find(decorView, R.id.tl_9);
//        /** indicator圆角色块 */
//        SlidingTabLayout tabLayout_10 = ViewFindUtils.find(decorView, R.id.tl_10);

//        tabLayout_1.setViewPager(vp);
        tabLayout_2.setViewPager(vp);
//        tabLayout_2.setOnTabSelectListener(this);
//        tabLayout_3.setViewPager(vp);
//        tabLayout_4.setViewPager(vp);
//        tabLayout_5.setViewPager(vp);
//        tabLayout_6.setViewPager(vp);
//        tabLayout_7.setViewPager(vp, mTitles);
//        tabLayout_7.setViewPager(vp);
//        tabLayout_8.setViewPager(vp, mTitles, this, mFragments);
//        tabLayout_9.setViewPager(vp);
//        tabLayout_10.setViewPager(vp);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mAdapter.setCount(2);
                mAdapter.notifyDataSetChanged();
                tabLayout_2.notifyDataSetChanged();
//                vp.removeOnPageChangeListener(tabLayout_7);
//                vp.setAdapter(mAdapter);
//                tabLayout_7.setViewPager(vp);
            }
        }, 2000);

        vp.setCurrentItem(4);

//        tabLayout_1.showDot(4);
//        tabLayout_3.showDot(4);
        tabLayout_2.showDot(4);

        tabLayout_2.showMsg(3, 5);
        tabLayout_2.setMsgMargin(3, 0, 10);
        MsgView rtv_2_3 = tabLayout_2.getMsgView(3);
        if (rtv_2_3 != null) {
            rtv_2_3.setBackgroundColor(Color.parseColor("#6D8FB0"));
        }
//
        tabLayout_2.showMsg(5, 5);
        tabLayout_2.setMsgMargin(5, 0, 10);

//        tabLayout_7.setOnTabSelectListener(new OnTabSelectListener() {
//            @Override
//            public void onTabSelect(int position) {
//                Toast.makeText(mContext, "onTabSelect&position--->" + position, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onTabReselect(int position) {
//                mFragments.add(SimpleCardFragment.getInstance("后端"));
//                mAdapter.notifyDataSetChanged();
//                tabLayout_7.addNewTab("后端");
//            }
//        });
    }

    @Override
    public void onTabSelect(int position) {
        Toast.makeText(mContext, "onTabSelect&position--->" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTabReselect(int position) {
        Toast.makeText(mContext, "onTabReselect&position--->" + position, Toast.LENGTH_SHORT).show();
    }

    private class MyPagerAdapter extends FragmentStatePagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void setCount(int count) {
            this.count = count;
        }

        int count = 3;

        @Override
        public Fragment getItem(int position) {
            return SimpleCardFragment.getInstance("--" + position);
        }

        @Override
        public int getCount() {
            return count;
        }

        // 必须重写此方法，不然，数据源改变，fragment数据不刷新
        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "" + position;
        }
    }
}
