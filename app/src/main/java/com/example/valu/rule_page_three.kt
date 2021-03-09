package com.example.valu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.ImageView
import android.widget.TextView

class rule_page_three : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rule_page_three)

        val preFixedText: TextView = findViewById(R.id.rules_page_three_text_id)
        preFixedText.setText(Html.fromHtml(getString(R.string.rules_page_three_text)))

        val home_button: ImageView = findViewById(R.id.home_button)

        val home_page_intent = Intent(this,junction_screen::class.java)

        home_button.setOnClickListener {
            startActivity(home_page_intent) }

        val prev_arrow_button: ImageView = findViewById(R.id.previous_arrow_button)

        val rule_page_two_intent = Intent(this,rules_page_two::class.java)

        prev_arrow_button.setOnClickListener {
            startActivity(rule_page_two_intent) }

        val next_arrow_button: ImageView = findViewById(R.id.forward_arrow_button)

        val rule_page_four_intent = Intent(this,rules_page_four::class.java)

        next_arrow_button.setOnClickListener {
            startActivity(rule_page_four_intent) }
    }
}