package com.youra.platepal.ui.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.youra.platepal.ui.main.MainActivity;
import com.youra.platepal.R;
import com.youra.platepal.ui.intro.IntroActivity;
import com.youra.platepal.util.PrefService;

public class SplashActivity extends AppCompatActivity {

    private PrefService pref;
    private Boolean isIntro = true;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        pref = new PrefService(getApplicationContext());
        isIntro = pref.getIntro();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isIntro) {
                    intent = new Intent(SplashActivity.this, IntroActivity.class);

                    pref.setIntro(false);
                } else {
                    intent = new Intent(SplashActivity.this, MainActivity.class);
                }
                startActivity(intent);
                finish();
            }
        },2000);


    }
}