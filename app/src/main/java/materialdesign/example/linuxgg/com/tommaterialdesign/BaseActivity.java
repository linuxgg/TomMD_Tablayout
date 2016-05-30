package materialdesign.example.linuxgg.com.tommaterialdesign;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private Map<String, View> mViewMap = new HashMap<String, View>();

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp_view);
        mTablayout = (TabLayout) findViewById(R.id.tabs);

        for (int i = 0; i < 100; i++) { //玩儿的就是心跳。。。。
            mViewMap.put(i + "", LayoutInflater.from(this).inflate(R.layout.sub_layout, null));
        }


        mTablayout.setTabMode(TabLayout.MODE_SCROLLABLE); //用滑动的方式展示页面，展示的个数，根据title定义
//        mTablayout.setTabMode(TabLayout.MODE_FIXED);//将所有tab都显示出来

        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(mViewMap);
        vp.setAdapter(myPagerAdapter);
        mTablayout.setupWithViewPager(vp);

        imgList.add("http://i.imgur.com/DvpvklR.png");
        imgList.add("http://g.hiphotos.baidu.com/image/h%3D200/sign=406968d52f381f3081198aa999004c67/242dd42a2834349bdd7d3468ceea15ce37d3bee0.jpg");
        imgList.add("http://www.deskcar.com/desktop/fengjing/200895150214/21.jpg");
        imgList.add("http://image.tuwang.com/Nature/FengGuang-1600-1200/FengGuang_pic_abx@DaTuKu.org.jpg");
        imgList.add("http://image.tianjimedia.com/uploadImages/2011/286/8X76S7XD89VU.jpg");


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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//========================================================

    class MyPagerAdapter extends PagerAdapter {
        private Map<String, View> mViewList;

        public MyPagerAdapter(Map<String, View> mViewList) {
            this.mViewList = mViewList;
        }

        @Override
        public int getCount() {
            return mViewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View v = mViewList.get(position + "");
            container.addView(v);
            try {
                Picasso p = Picasso.with(getApplicationContext());
                p.setLoggingEnabled(BuildConfig.DEBUG);
                p.load(imgList.get(position % imgList.size())).into((ImageView) v.findViewById(R.id.pic));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return mViewList.get(position + "");
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            Picasso.with(getApplicationContext()).cancelRequest((ImageView) mViewList.get(position + "").findViewById(R.id.pic));
            container.removeView(mViewList.get(position + ""));
        }

        @Override
        public CharSequence getPageTitle(int position) {

            return "Title_" + position;
        }
    }

}
