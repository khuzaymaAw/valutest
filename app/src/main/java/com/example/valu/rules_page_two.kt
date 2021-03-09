package com.example.valu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.ImageView
import android.widget.TextView

class rules_page_two : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rules_page_two)
        val preFixedText: TextView = findViewById(R.id.rules_page_two_text_id)
        preFixedText.setText(Html.fromHtml(getString(R.string.rules_page_two_text)))

        val home_button: ImageView = findViewById(R.id.home_button)

        val home_page_intent = Intent(this,junction_screen::class.java)

        home_button.setOnClickListener {
            startActivity(home_page_intent) }

        val prev_arrow_button: ImageView = findViewById(R.id.previous_arrow_button)

        val rule_page__one_intent = Intent(this,rules_page_one::class.java)

        prev_arrow_button.setOnClickListener {
            startActivity(rule_page__one_intent) }

        val next_arrow_button: ImageView = findViewById(R.id.forward_arrow_button)

        val rule_page_three_intent = Intent(this,rule_page_three::class.java)

        next_arrow_button.setOnClickListener {
            startActivity(rule_page_three_intent) }
    }
}