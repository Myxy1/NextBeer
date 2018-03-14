package com.example.petrik.nextbeerround;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageV_bottle;
    private Random r;
    private Button btn_submit;
    private int angle; //szög
    private Boolean game;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (game)
                {
                    angle= angle%360;
                    RotateAnimation rotateAnimation = new RotateAnimation(angle, 0,
                            RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                    rotateAnimation.setFillAfter(true);
                    rotateAnimation.setDuration(1000);
                    rotateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());

                    imageV_bottle.startAnimation(rotateAnimation);
                    btn_submit.setText("Sorsolás");
                    game = false;

                }else
                {
                    angle=r.nextInt()+360;
                    RotateAnimation rotateAnimation = new RotateAnimation(0, angle,
                            RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                    rotateAnimation.setFillAfter(true);
                    rotateAnimation.setDuration(1000);
                    rotateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());

                    imageV_bottle.startAnimation(rotateAnimation);
                    btn_submit.setText("Újrasorsolás");
                    game = true;

                }
            }
        });
    }

    private void init()
    {
        btn_submit = (Button) findViewById(R.id.btn_submit);
        imageV_bottle = (ImageView) findViewById(R.id.imgV_bottle);
        r = new Random();
        game = false;
    }
}
