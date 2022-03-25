package com.antechs.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import com.antechs.home.HomeActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button btnHome, btnAbout, btnProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnHome = findViewById(R.id.btn_home);
        btnAbout = findViewById(R.id.btn_about);
        btnProfile = findViewById(R.id.btn_profile);

        btnHome.setOnClickListener(view -> {
            Intent intent = new Intent(getApplication(), HomeActivity.class);
            startActivity(intent);
        });

        Context context = this;
        btnHome.setText(context.getText(com.antechs.languageselect.R.string.btn_home));
        btnAbout.setOnClickListener(view -> {
            setLocale("en");
        });

        btnProfile.setOnClickListener(view -> {
            setLocale("hi");
        });

    }

    public void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, MainActivity.class);
//        finish();
        startActivity(refresh);

        if(lang.equals("en")){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        }
    }
}