package com.example.valu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.airbnb.lottie.LottieAnimationView
import com.example.valu.R

class lottie_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lottie_screen)
      val lottieAnimation: LottieAnimationView = findViewById(R.id.lottie)

            var touched = false
            lottieAnimation.playAnimation()

            lottieAnimation.addAnimatorUpdateListener { valueAnimator ->
                // Set animation progress
                val progress = (valueAnimator.animatedValue as Float * 100).toInt()
                if ( progress >= 40 && !touched) {
                    lottieAnimation.progress = 0f
                  }


            }



    }
}