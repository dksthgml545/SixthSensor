package kr.ac.kopo.hdyw0w.sixthsensor;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import kr.ac.kopo.hdyw0w.sixthsensor.item.Code;

public class SplashActivity extends AppCompatActivity {

    /** 로딩 화면이 떠있는 시간(밀리초단위)  **/
    private final int SPLASH_DISPLAY_LENGTH = 2000;

    /** 처음 액티비티가 생성될때 불려진다. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_splash);

        /* SPLASH_DISPLAY_LENGTH 뒤에 메뉴 액티비티를 실행시키고 종료한다.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* 메뉴액티비티를 실행하고 로딩화면을 죽인다.*/

                if (getSharedPreferences(Code.pref_id, 0).getString(Code.pref_token, "").length() > 1) {
                    Intent mainIntent = new Intent(SplashActivity.this, NavActivity.class);
                    SplashActivity.this.startActivity(mainIntent);
                    SplashActivity.this.finish();
                } else {
                    Intent mainIntent = new Intent(SplashActivity.this,LoginActivity.class);
                    SplashActivity.this.startActivity(mainIntent);
                    SplashActivity.this.finish();
                }

            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}