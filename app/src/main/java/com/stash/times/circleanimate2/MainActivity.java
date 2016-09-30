package com.stash.times.circleanimate2;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Circle c;
    Button b;
    TextView tv;
    int x = 0;
    int getValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c = (Circle) findViewById(R.id.circle);
        b = (Button) findViewById(R.id.button);
        tv = (TextView) findViewById(R.id.textView);

        CircleAngleAnimation animation = new CircleAngleAnimation(c, 360);
        animation.setDuration(5000);
        animateTextView(0,100,tv);
        c.startAnimation(animation);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                x = x + 1;
                if (x % 2 == 1) {
                    CircleAngleAnimation animation = new CircleAngleAnimation(c, 0);
                    animation.setDuration(5000);
                    c.startAnimation(animation);
                    animateTextView(getValue,0,tv);
                } else {
                    CircleAngleAnimation animation = new CircleAngleAnimation(c, 360);
                    animation.setDuration(5000);
                    c.startAnimation(animation);
                    animateTextView(0,100,tv);
                }


            }
        });
    }
        public void animateTextView(int initialValue, int finalValue, final TextView  textview) {

            ValueAnimator valueAnimator = ValueAnimator.ofInt(initialValue, finalValue);
            valueAnimator.setDuration(5000);

            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    String s = valueAnimator.getAnimatedValue().toString();
                    textview.setText(s);
                    getValue = Integer.parseInt(s);

                }
            });
            valueAnimator.start();


        }
    }
