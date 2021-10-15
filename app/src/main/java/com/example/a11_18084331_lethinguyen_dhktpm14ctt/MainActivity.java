package com.example.a11_18084331_lethinguyen_dhktpm14ctt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView img1, img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img1 = findViewById(R.id.imageView);
        img2 = findViewById(R.id.imageView2);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation);
        img2.startAnimation(animation);
        img1.startAnimation(animation);
    }
}