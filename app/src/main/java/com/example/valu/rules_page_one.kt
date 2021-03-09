package com.example.valu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.ImageView
import android.widget.TextView

class rules_page_one : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rules_page_one)
        val preFixedText: TextView = findViewById(R.id.rules_page_one_text_id)
        preFixedText.setText(Html.fromHtml(getString(R.string.rules_page_one_text)))

        val next_button: ImageView = findViewById(R.id.next_button)

        val rules_page_two_intent = Intent(this, rules_page_two::class.java)

        next_button.setOnClickListener {
            startActivity(rules_page_two_intent)
        }

        val home_button: ImageView = findViewById(R.id.home_button)

        val home_page_intent = Intent(this,junction_screen::class.java)

        home_button.setOnClickListener {
            startActivity(home_page_intent) }

    }
}