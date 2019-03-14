package com.example.samplestickerapp;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter{

    Context context;
    LayoutInflater layoutInflater;
    //constructor
    public SliderAdapter(Context context) {

        this.context = context;
    }

    //Arrays
    public int[] slide_images = {

            R.drawable.logo,
            R.drawable.logo_ooo,
            R.drawable.logo_crazy
    };
    public int[] slide_background = {

            R.drawable.logoback,
            R.drawable.logoback_ooo,
            R.drawable.logoback_crazy
    };

    public String[] slide_headings = {

            "Crazy Stickers",
            "Exiting Stickers!!!",
            "Get Started"
    };

    public String[] slide_descs = {

            "Hi There !! You are just 3 step away from creating exiting stickers for WhatsApp...Good Luck!!",
            "Choose from exiting new stickers to express yourself even better ",
            "What are u waiting for lets Go!!!!"
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == (RelativeLayout) o;
    }
    //create the three introductory pages
    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_desc);
        RelativeLayout relativeLayout=(RelativeLayout) view.findViewById(R.id.relativeLayout);
        slideHeading.setShadowLayer(5, 0, 0, Color.rgb(255, 153, 51));
        slideDescription.setShadowLayer(5, 0, 0, Color.rgb(255, 153, 51));

        relativeLayout.setBackgroundResource(slide_background[position]);
        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_descs[position]);

        container.addView(view);

        return view;

    }


    @Override
    public void destroyItem (ViewGroup container, int position, Object object) {

        container.removeView((RelativeLayout)object);
    }
}
