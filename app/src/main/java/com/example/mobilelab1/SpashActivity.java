package com.example.mobilelab1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class SpashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        Animation anim = null;
        anim= AnimationUtils.loadAnimation(this, R.anim.opacity);
        View btStart = findViewById(R.id.btStart); // Replace 'your_button_id' with the actual ID
        btStart.startAnimation(anim);

        Animation anim2 = null;
        anim2= AnimationUtils.loadAnimation(this, R.anim.opacity);
        View btClever= findViewById(R.id.btClever); // Replace 'your_button_id' with the actual ID
        btClever.startAnimation(anim2);

        Animation anim3 = null;
        anim3= AnimationUtils.loadAnimation(this, R.anim.scale);
        View textView= findViewById(R.id.textView); // Replace 'your_button_id' with the actual ID
        textView.startAnimation(anim3);
    }

    public void navigateToSecondActivity(View view) {



        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void navigateTo3Activity(View view) {
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }

    public void navigateBackD(View view) {
        finishAffinity();
    }
}
