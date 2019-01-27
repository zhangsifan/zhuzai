package com.zhuzai.homework.zhuzai;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.zhuzai.homework.zhuzai.messagePage.MessagePage;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private ViewPager viewPager;
    private TextView firstPage;
    private TextView about;
    private TextView recommend;
    private TextView massage;
    private Button video;
    private List<Fragment> list;
    private FragmentPagerAdapter myPagerAdpter;
    private double exitTime = 0.1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
        setSelected(0);

    }


    private void initView(){
        viewPager = findViewById(R.id.view_pager);
        firstPage = findViewById(R.id.tab_firstpage);
        about = findViewById(R.id.tab_aboutme);
        recommend = findViewById(R.id.tab_recommend);
        massage = findViewById(R.id.tab_massage);
        Fragment firstPageFragment = new MessagePage();
        list = new ArrayList<>();
        list.add(firstPageFragment);

        myPagerAdpter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }
        };
        viewPager.setAdapter(myPagerAdpter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void initEvent()
    {
        firstPage.setOnClickListener(this);
        recommend.setOnClickListener(this);
        about.setOnClickListener(this);
        massage.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        initTab();
        switch (view.getId()){
            case R.id.tab_firstpage:
                firstPage.setTextColor(getResources().getColor(R.color.tab_press));
                viewPager.setCurrentItem(0,false);;
                break;
            case R.id.tab_recommend:
                recommend.setTextColor(getResources().getColor(R.color.tab_press));
                //viewPager.setCurrentItem(1,false);;
                break;
            case R.id.tab_video:

                //     setSelected(1);
                break;
            case R.id.tab_massage:
                massage.setTextColor(getResources().getColor(R.color.tab_press));
                //    setSelected(1);
                break;
            case R.id.tab_aboutme:
                about.setTextColor(getResources().getColor(R.color.tab_press));
                //   setSelected(1);
                break;
            default:break;
        }
    }
    private  void initTab(){
        firstPage.setTextColor(getResources().getColor(R.color.tab_unpress));
        recommend.setTextColor(getResources().getColor(R.color.tab_unpress));
        massage.setTextColor(getResources().getColor(R.color.tab_unpress));
        about.setTextColor(getResources().getColor(R.color.tab_unpress));
    }
    private void setSelected(int i){
        viewPager.setCurrentItem(i,false);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction () == KeyEvent.ACTION_DOWN){
            if((System.currentTimeMillis()-exitTime)>2000) {

                Toast.makeText(getApplicationContext(),"再按一次退出程序",Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            }
        }
        else {
            finish();
            System.exit(0);
        }
        return super.onKeyDown(keyCode,event);
    }

}
