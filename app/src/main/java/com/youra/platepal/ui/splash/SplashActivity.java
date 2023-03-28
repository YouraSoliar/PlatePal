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

public class SplashActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private Boolean isIntro = true;
    private Intent intent;

    private static final String SHARED_PREF = "platepal";
    private static final String INTRO = "intro";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        sharedPreferences = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        isIntro = sharedPreferences.getBoolean(INTRO, true);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isIntro) {
                    intent = new Intent(SplashActivity.this, IntroActivity.class);

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean(INTRO, false);
                    editor.apply();
                } else {
                    intent = new Intent(SplashActivity.this, MainActivity.class);
                }
                startActivity(intent);
                finish();
            }
        },2000);


    }
}