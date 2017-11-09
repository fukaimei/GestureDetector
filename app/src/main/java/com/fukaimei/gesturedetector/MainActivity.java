package com.fukaimei.gesturedetector;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_gesture_detector).setOnClickListener(this);
        findViewById(R.id.btn_view_flipper).setOnClickListener(this);
        findViewById(R.id.btn_banner_flipper).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_gesture_detector) {
            Intent intent = new Intent(this, GestureDetectorActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_view_flipper) {
            Intent intent = new Intent(this, ViewFlipperActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_banner_flipper) {
            Intent intent = new Intent(this, BannerFlipperActivity.class);
            startActivity(intent);
        }
    }

    private boolean bExit = false;

//	@Override
//	public void onBackPressed() {
//		if (bExit) {
//			finish();
//			return;
//		}
//		bExit = true;
//		Toast.makeText(this, "再按一次返回键退出!", Toast.LENGTH_SHORT).show();
//	}

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (bExit) {
                finish();
            }
            bExit = true;
            Toast.makeText(this, "再按一次返回键退出!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

}
