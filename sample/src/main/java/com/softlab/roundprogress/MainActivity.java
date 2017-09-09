package com.softlab.roundprogress;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.softlab.circleprogresslib.CircleProgress;

public class MainActivity extends AppCompatActivity {

    private CircleProgress mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startAnimationBtn = (Button) findViewById(R.id.btn_start_animation);
        Button stopAnimationBtn = (Button) findViewById(R.id.btn_stop_animation);


        startAnimationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mProgress.startAnimation();
            }
        });

        stopAnimationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgress.stopAnimation();
            }
        });
        mProgress = (CircleProgress) findViewById(R.id.test_progress);


    }


    @Override
    protected void onResume() {
        super.onResume();
       // mProgress.startAnimation();
    }
}
