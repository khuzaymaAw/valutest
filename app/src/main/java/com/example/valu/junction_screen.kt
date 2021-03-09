package com.example.valu

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class junction_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_junction_screen)

        val take_a_tour_button: ImageView = findViewById(R.id.take_a_tour_button)

        val rules_page_one_intent = Intent(this, rules_page_one::class.java)

        take_a_tour_button.setOnClickListener {
            startActivity(rules_page_one_intent)
        }

        val start_button: ImageView = findViewById(R.id.start_button)
        val coin_sending_screen_intent = Intent(this, coin_sending_screen::class.java)

        start_button.setOnClickListener {
            startActivity(coin_sending_screen_intent)
        }

        /* val lottie_screen_intent = Intent(this, lottie_screen::class.java)

        start_button.setOnClickListener {
            startActivity(lottie_screen_intent)
        }
        */


    }
}