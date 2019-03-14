package com.example.samplestickerapp;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private SliderAdapter sliderAdapter;
    Button next,prev;
    int mCurrent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prev=(Button)findViewById(R.id.prev);
        next=(Button)findViewById(R.id.next);

        mSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);//to enable sliding between different pages
        sliderAdapter = new SliderAdapter(this);

        mSlideViewPager.setAdapter(sliderAdapter);
        mSlideViewPager.addOnPageChangeListener(viewListener);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mCurrent==2)//the starting pages have been visited and user is navigated to the page showing the sticker packs
                {
                    startActivity(new Intent(MainActivity.this,EntryActivity.class));
                }
                else
                    mSlideViewPager.setCurrentItem(mCurrent+1);
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(mCurrent-1);
            }
        });
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {
            //Log.i("HI",Integer.toString(i));
        }
        //configure the prev and next buttons in the different pages
        @Override
        public void onPageSelected(int i) {
            mCurrent=i;
            if (i == 0) {
                next.setEnabled(true);
                prev.setEnabled(false);
                prev.setVisibility(View.INVISIBLE);
                next.setText("Next");
            }
            else if(i==1){
                next.setEnabled(true);
                prev.setEnabled(true);
                prev.setVisibility(View.VISIBLE);
                next.setText("Next");
                prev.setText("Back");
            }
            else{
                next.setEnabled(true);
                prev.setEnabled(true);
                prev.setVisibility(View.VISIBLE);
                next.setText("Finish");
                prev.setText("Back");
            }

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };



}
