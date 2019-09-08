package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView tvSplash,tvSubSplash;
ImageView ivSplash;
Button btnget;

Animation atg,btgone,bgtwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvSplash=(TextView)findViewById(R.id.tvSplash);
        tvSubSplash=(TextView)findViewById(R.id.tvSubSplash);
        btnget=(Button)findViewById(R.id.btnget);
        ivSplash=(ImageView)findViewById(R.id.ivSplash);
        atg= AnimationUtils.loadAnimation(this,R.anim.atg);
        btgone= AnimationUtils.loadAnimation(this,R.anim.btgone);
        bgtwo= AnimationUtils.loadAnimation(this,R.anim.bgtwo);
        tvSplash.startAnimation(btgone);
        tvSubSplash.startAnimation(btgone);
        btnget.startAnimation(bgtwo);
        ivSplash.startAnimation(atg);



        btnget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,StopAct.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);


            }
        });



        Typeface MLight= Typeface.createFromAsset(getAssets(),"font/MLight.ttf");
        Typeface MMedium= Typeface.createFromAsset(getAssets(),"font/MMedium.ttf");
        Typeface MRegular= Typeface.createFromAsset(getAssets(),"font/MRegular.ttf");

        tvSplash.setTypeface(MRegular);
        tvSubSplash.setTypeface(MLight);
        btnget.setTypeface(MMedium);

    }
}
