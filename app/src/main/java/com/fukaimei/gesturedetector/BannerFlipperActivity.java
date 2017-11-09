package com.fukaimei.gesturedetector;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

import com.fukaimei.gesturedetector.util.DisplayUtil;
import com.fukaimei.gesturedetector.widget.BannerFlipper;

public class BannerFlipperActivity extends AppCompatActivity implements BannerFlipper.BannerClickListener {
    private static final String TAG = "BannerFlipperActivity";
    private TextView tv_flipper;
    private BannerFlipper mBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_flipper);
        tv_flipper = (TextView) findViewById(R.id.tv_flipper);

        mBanner = (BannerFlipper) findViewById(R.id.banner_flipper);
        LayoutParams params = (LayoutParams) mBanner.getLayoutParams();
        params.height = (int) (DisplayUtil.getSreenWidth(this) * 250f / 640f);
        mBanner.setLayoutParams(params);

        ArrayList<Integer> imageList = new ArrayList<Integer>();
        imageList.add(Integer.valueOf(R.drawable.banner_1));
        imageList.add(Integer.valueOf(R.drawable.banner_2));
        imageList.add(Integer.valueOf(R.drawable.banner_3));
        imageList.add(Integer.valueOf(R.drawable.banner_4));
        imageList.add(Integer.valueOf(R.drawable.banner_5));
        mBanner.setImage(imageList);
        mBanner.setOnBannerListener(this);
    }

    @Override
    public void onBannerClick(int position) {
        String desc = String.format("您点击了第%d张图片", position + 1);
        tv_flipper.setText(desc);
    }

}