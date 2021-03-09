package com.example.valu

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.MotionEvent
import android.view.View.OnTouchListener
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class javaToKotlin : AppCompatActivity() {
    var imageView: ImageView = findViewById(R.id.star)
    var xMovment: TextView = findViewById(R.id.xMovment)
    var yMovment: TextView = findViewById(R.id.yMovement)
    var xDown = 0f
    var yDown = 0f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_java_to_kotlin)
        xMovment = findViewById(R.id.xMovment)
        yMovment = findViewById(R.id.yMovement)
        imageView = findViewById(R.id.star)
     /*   imageView.setOnTouchListener(OnTouchListener { view, event ->
            when (event.actionMasked) {
                MotionEvent.ACTION_DOWN -> {
                    xDown = event.x
                    yDown = event.y
                }
                MotionEvent.ACTION_MOVE -> {
                    val movedX: Float
                    val movedY: Float
                    movedX = event.x
                    movedY = event.y

                    //calculation
                    val distanceX = movedX - xDown
                    val distanceY = movedY - yDown
                    val absoluteDistanceX = Math.abs(distanceX)
                    val absoluteDistanceY = Math.abs(distanceY)
                    val distanceXString = java.lang.Float.toString(distanceX)
                    val distanceYString = java.lang.Float.toString(distanceY)
                    xMovment.setText(distanceXString)
                    yMovment.setText(distanceYString)


                    //now move the view to that
                    if (distanceY < 0 && absoluteDistanceY > 39) {

                        val valueAnimator = ValueAnimator.ofFloat(0f, -screenHeight)

//2
                        valueAnimator.addUpdateListener {
                            // 3
                            val value = it.animatedValue as Float
                            // 4
                            coin.translationY = value
                        }

//5
                        valueAnimator.interpolator = LinearInterpolator()
                        valueAnimator.duration = DEFAULT_ANIMATION_DURATION

//6
                        valueAnimator.start()
                    }
                }
            }
            true
        }) */
    }
}

/*    val imageViewYpositionAnimator = ValueAnimator.ofFloat(yDown, yDown - 100)
                        imageViewYpositionAnimator.addUpdateListener { animation ->
                            imageView.setY((animation.animatedValue as Float))
                            imageView.requestLayout()
                        }
                        imageViewYpositionAnimator.duration = 3000
                        // fling.setStartVelocity()
                        // imageView.setY(imageView.getY() - (absoluteDistanceY*10));
                        /*ObjectAnimator test1 = ObjectAnimator.ofFloat(imageView, "y", 300f ).setDuration(3000);
                            AnimatorSet set = new AnimatorSet();
                            set.start(); */   */