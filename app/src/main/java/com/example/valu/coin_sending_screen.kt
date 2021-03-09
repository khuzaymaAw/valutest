package com.example.valu

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.MotionEvent
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.LinearInterpolator
import com.airbnb.lottie.LottieAnimationView

class coin_sending_screen : AppCompatActivity() {

    protected lateinit var coin: View
    protected lateinit var frameLayout: View
    protected var screenHeight = 0f

    var xDown = 0f
    var yDown = 0f

    var downloading: Boolean = true

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_sending_screen)

        coin = findViewById(R.id.lottie)
        frameLayout = findViewById(R.id.container)
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        screenHeight = displayMetrics.heightPixels.toFloat()

        val DEFAULT_ANIMATION_DURATION = 1500L

        val lottieAnimation: LottieAnimationView = findViewById(R.id.lottie)

        lottieAnimation.addAnimatorUpdateListener { valueAnimator ->
            // Set animation progress
            val progress = (valueAnimator.animatedValue as Float * 100).toInt()

            if (downloading && progress >= 40) {
                lottieAnimation.progress = 0f
            }
        }

        coin.setOnTouchListener(View.OnTouchListener { view, event ->
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
                        valueAnimator.interpolator = AccelerateInterpolator(1.5f)
                        valueAnimator.duration = DEFAULT_ANIMATION_DURATION

//6
                        downloading = false
                        valueAnimator.start()
                    }
                }
            }
            true
        })

        /*

//1
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

 */

    }
}