package materialdesign.example.linuxgg.com.tommaterialdesign;

import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import materialdesign.example.linuxgg.com.tommaterialdesign.fragments.BaseFragment;
import materialdesign.example.linuxgg.com.tommaterialdesign.fragments.SubFragment;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        initView();


    }

    private ViewPager vp;
    private List<String> imgList = new ArrayList<>();


    private TabLayout mTablayout;
    private Map<String, BaseFragment> mFragmentMap = new HashMap<String, BaseFragment>();

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp_view);
        mTablayout = (TabLayout) findViewById(R.id.tabs);

        for (int i = 0; i < 10; i++) { //玩儿的就是心跳。。。。
            mFragmentMap.put(i + "", new SubFragment());
        }


        mTablayout.setTabMode(TabLayout.MODE_SCROLLABLE); //用滑动的方式展示页面，展示的个数，根据title定义
//        mTablayout.setTabMode(TabLayout.MODE_FIXED);//将所有tab都显示出来


        imgList.add("http://i.imgur.com/DvpvklR.png");
        imgList.add("http://g.hiphotos.baidu.com/image/h%3D200/sign=406968d52f381f3081198aa999004c67/242dd42a2834349bdd7d3468ceea15ce37d3bee0.jpg");
        imgList.add("http://www.deskcar.com/desktop/fengjing/200895150214/21.jpg");
        imgList.add("http://image.tuwang.com/Nature/FengGuang-1600-1200/FengGuang_pic_abx@DaTuKu.org.jpg");
        imgList.add("http://image.tianjimedia.com/uploadImages/2011/286/8X76S7XD89VU.jpg");


        MyFragmentAdapter myPagerAdapter = new MyFragmentAdapter(getSupportFragmentManager(), mFragmentMap);
        vp.setAdapter(myPagerAdapter);
        mTablayout.setupWithViewPager(vp);

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mFragmentMap.get(position + "").setText("text::" + position);
                Picasso.with(getApplicationContext()).load(imgList.get(position % imgList.size()))
                        .into(mFragmentMap.get(position + "").getPic());
            }

            @Override
            public void onPageSelected(int position) {
                mFragmentMap.get(position + "").setText("text::" + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_base, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//========================================================

    class MyFragmentAdapter extends FragmentPagerAdapter {
        Map<String, BaseFragment> mFragmentMap;

        public MyFragmentAdapter(FragmentManager fm, Map<String, BaseFragment> mFragmentMap) {
            super(fm);
            this.mFragmentMap = mFragmentMap;
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            return mFragmentMap.get(position + "");
        }

        @Override
        public int getCount() {
            return mFragmentMap.size();
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return "Title" + position;
        }
    }
}
