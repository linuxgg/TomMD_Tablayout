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
import java.util.List;

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
    private View view1, view2, view3, view4, view5;
    private List<View> mViewList = new ArrayList<>();
    private List<String> imgList = new ArrayList<>();


    private LayoutInflater mInflater;
    private List<String> mTitleList = new ArrayList<>();
    private TabLayout mTablayout;

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp_view);
        mTablayout = (TabLayout) findViewById(R.id.tabs);
        mInflater = LayoutInflater.from(this);
        view1 = mInflater.inflate(R.layout.sub_layout, null);
        view2 = mInflater.inflate(R.layout.sub_layout, null);
        view3 = mInflater.inflate(R.layout.sub_layout, null);
        view4 = mInflater.inflate(R.layout.sub_layout, null);
        view5 = mInflater.inflate(R.layout.sub_layout, null);


        mViewList.add(view1);
        mViewList.add(view2);
        mViewList.add(view3);
        mViewList.add(view4);
        mViewList.add(view5);

        mTitleList.add("1sssss");
        mTitleList.add("2sss");
        mTitleList.add("3dsf");
        mTitleList.add("4asf");
        mTitleList.add("5d");

//        mTablayout.setTabMode(TabLayout.MODE_FIXED);
        mTablayout.setTabMode(TabLayout.MODE_FIXED);
        for (String i : mTitleList) {
            mTablayout.addTab(mTablayout.newTab().setText(i));
        }

        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(mViewList);
        vp.setAdapter(myPagerAdapter);
        mTablayout.setupWithViewPager(vp);
        mTablayout.setTabsFromPagerAdapter(myPagerAdapter);

        imgList.add("http://i.imgur.com/DvpvklR.png");
        imgList.add("http://g.hiphotos.baidu.com/image/h%3D200/sign=406968d52f381f3081198aa999004c67/242dd42a2834349bdd7d3468ceea15ce37d3bee0.jpg");
        imgList.add("http://www.deskcar.com/desktop/fengjing/200895150214/21.jpg");
        imgList.add("http://image.tuwang.com/Nature/FengGuang-1600-1200/FengGuang_pic_abx@DaTuKu.org.jpg");
        imgList.add("http://image.tianjimedia.com/uploadImages/2011/286/8X76S7XD89VU.jpg");


    }

    class MyPagerAdapter extends PagerAdapter {
        private List<View> mViewList;

        public MyPagerAdapter(List<View> mViewList) {
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
            container.addView(mViewList.get(position));
            Log.d("adfaf", "start to load img");
            try {

                Picasso p = Picasso.with(getApplicationContext());
                p.setLoggingEnabled(BuildConfig.DEBUG);
                p.load(imgList.get(position)).into((ImageView) mViewList.get(position).findViewById(R.id.pic));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return mViewList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

            container.removeView(mViewList.get(position));
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitleList.get(position);
        }
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
}
