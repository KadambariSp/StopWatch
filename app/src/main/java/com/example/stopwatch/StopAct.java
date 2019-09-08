package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopAct extends AppCompatActivity {

Button btnstart,btnpause,btnreset;
    ImageView icanchor;
    Animation roundingalone;
    Chronometer timer;
    boolean running;
    long PauseOffSet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop);
        btnstart = (Button) findViewById(R.id.btnStart);
        btnpause = (Button) findViewById(R.id.btnStop);
        btnreset = (Button) findViewById(R.id.btnReset);

        icanchor = (ImageView) findViewById(R.id.icanchor);


        timer = (Chronometer) findViewById(R.id.timer);
        timer.setFormat("Time: %s");
        timer.setBase(SystemClock.elapsedRealtime());


        roundingalone = AnimationUtils.loadAnimation(this, R.anim.roundingalone);


        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!running) {

                    timer.setBase(SystemClock.elapsedRealtime() - PauseOffSet);

                    timer.start();
                    icanchor.startAnimation(roundingalone);
                    running = true;
                }
            }
        });


        btnpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (running) {


                    timer.stop();
                    PauseOffSet = SystemClock.elapsedRealtime() - timer.getBase();
                    running = false;
                }
            }
        });


        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                timer.setBase(SystemClock.elapsedRealtime());
                PauseOffSet = 0;
            }
        });


    }





       /* btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if (!running){

                        timer.setBase(SystemClock.elapsedRealtime()-PauseOffSet);

                        timer.start();
                        icanchor.startAnimation(roundingalone);
                        running=true;

                    }

                btnStop.animate().alpha(1).translationY(-80).setDuration(300).start();
                btnStop.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(running){

                            timer.stop();
                            roundingalone.cancel();
                                PauseOffSet=SystemClock.elapsedRealtime()-timer.getBase();
                            running=false;
                        }
                    }
                });
                btnReset.animate().alpha(2).translationY(-80).setDuration(300).start();
                btnReset.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(running){
                        timer.setBase(SystemClock.elapsedRealtime());
                        PauseOffSet=0;
                    }

                 btnStart.animate().alpha(0).translationY(-80).setDuration(300).start();
                        btnStart.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if (!running){

                                    timer.setBase(SystemClock.elapsedRealtime()-PauseOffSet);

                                    timer.start();
                                    icanchor.startAnimation(roundingalone);
                                    running=true;

                                }
                            }
                        });

                    }



                });






            }
        });

    }*/
    }
