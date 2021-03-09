package com.example.valu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FlingAnimation;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class drag_view extends AppCompatActivity {
    ImageView imageView;
    TextView xMovment;
    TextView yMovment;

    float xDown = 0, yDown = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_view);
        xMovment = findViewById(R.id.xMovment);
        yMovment =  findViewById(R.id.yMovement);
        imageView = findViewById(R.id.star);
       // FlingAnimation fling = new FlingAnimation(imageView, DynamicAnimation.Y );

        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {

                switch (event.getActionMasked()){
                    case MotionEvent.ACTION_DOWN:
                        xDown = event.getX();
                        yDown = event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        float movedX, movedY;
                        movedX = event.getX();
                        movedY = event.getY();

                        //calculation
                        float distanceX = movedX-xDown;
                        float distanceY = movedY-yDown;

                        float absoluteDistanceX = Math.abs(distanceX);
                        float absoluteDistanceY = Math.abs(distanceY);

                        String distanceXString = Float.toString(distanceX);
                        String distanceYString = Float.toString(distanceY);

                         xMovment.setText(distanceXString);
                         yMovment.setText(distanceYString);


                        //now move the view to that
                        if(distanceY < 0 && absoluteDistanceY > 39){
                            ValueAnimator imageViewYpositionAnimator = ValueAnimator.ofFloat(yDown,yDown-100);
                            imageViewYpositionAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                                @Override
                                public void onAnimationUpdate(ValueAnimator animation) {
                                    imageView.setY((Float) animation.getAnimatedValue());
                                    imageView.requestLayout();
                                }
                            });
                            imageViewYpositionAnimator.setDuration(3000);
                            // fling.setStartVelocity()
                           // imageView.setY(imageView.getY() - (absoluteDistanceY*10));
                            /*ObjectAnimator test1 = ObjectAnimator.ofFloat(imageView, "y", 300f ).setDuration(3000);
                            AnimatorSet set = new AnimatorSet();
                            set.start(); */

                        }


                        break;
                }
                return true;
            }
        });
    }
}