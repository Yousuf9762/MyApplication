package com.antechs.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.antechs.about.AboutActivity;
import com.antechs.profile.ProfileActivity;
import com.antechs.themeselect.SharedPref;

import java.util.Locale;

public class HomeActivity extends AppCompatActivity {

    RadioGroup rdgSelectedTheme, rdgSelectedLanguage;
    RadioButton rdDay, rdNight, rdHindi, rdEnglish;
    Button btnAbout,btnProfile;
    SharedPref sharedPref;
    int checkPageLoad = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();
        sharedPref = new SharedPref();
        rdDay = findViewById(R.id.rd_day);
        rdNight = findViewById(R.id.rd_night);
        rdEnglish = findViewById(R.id.rd_english);
        rdHindi = findViewById(R.id.rd_hindi);
        rdgSelectedTheme = findViewById(R.id.rdg_selected_theme);
        rdgSelectedLanguage = findViewById(R.id.rdg_selected_language);
        btnAbout = findViewById(R.id.btn_about);
        btnProfile = findViewById(R.id.btn_profile);

        btnAbout.setOnClickListener(v->{
            Intent intent=new Intent(getApplication(), AboutActivity.class);
            startActivity(intent);
        });
        btnProfile.setOnClickListener(v->{
            Intent intent=new Intent(getApplication(), ProfileActivity.class);
            startActivity(intent);
        });

        rdDay.setOnClickListener(v -> {
            if (rdDay.isChecked()) {
                sharedPref.setTheme("day", getApplication());
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        });
        rdNight.setOnClickListener(v -> {
            if (rdNight.isChecked()) {
                sharedPref.setTheme("night", getApplication());
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

            }
        });
        rdEnglish.setOnClickListener(v -> {
            if (rdEnglish.isChecked()) {
                checkPageLoad=1;
                sharedPref.setLanguage("english", getApplication());
                setLocaleLanguage("en");
            }
        });
        rdHindi.setOnClickListener(v -> {
            if (rdHindi.isChecked()) {
                checkPageLoad=1;
                sharedPref.setLanguage("hindi", getApplication());
                setLocaleLanguage("hi");
            }
        });

        String getTheme = sharedPref.getTheme(getApplication());
        String getLanguage = sharedPref.getLanguage(getApplication());


        Log.e("yousuf",getLanguage);
        if (getTheme.equals("night")) {
            rdgSelectedTheme.check(R.id.rd_night);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

        } else {
            rdgSelectedTheme.check(R.id.rd_day);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        if (getLanguage.equals("hindi")) {
            rdgSelectedLanguage.check(R.id.rd_hindi);
            setLocaleLanguage("hi");
        } else {
            rdgSelectedLanguage.check(R.id.rd_english);
            setLocaleLanguage("en");
        }
    }


    public void setLocaleLanguage(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        if(checkPageLoad!=0)
        {
            Intent refresh = new Intent(this, HomeActivity.class);
            startActivity(refresh);
            finish();
        }
    }

}