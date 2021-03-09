package com.example.valu

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import java.util.concurrent.ScheduledExecutorService

class video_explanation_page : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_explanation_page)

        val blue_home_button: ImageView = findViewById(R.id.blue_home_button)

        val home_page_intent = Intent(this,junction_screen::class.java)

        blue_home_button.setOnClickListener {
            startActivity(home_page_intent) }

        val textView: TextView = findViewById(R.id.textView)
        val videoView: VideoView = findViewById(R.id.videoView)
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)

        val offLineUri = Uri.parse("android.resource://$packageName/${R.raw.keanu_reeves_on_the_matrix}")



        videoView.setMediaController(mediaController)
        videoView.setVideoURI(offLineUri)
        videoView.setMediaController(null)
        videoView.start()

        videoView.setOnPreparedListener {
            val running = true
            val duration = videoView.duration
            Thread {
                do {
                    textView.post(Runnable {
                        val time = videoView.currentPosition / 1000
                        textView.setText(time.toString() + "")

                    })
                    try {
                        Thread.sleep(500)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                    if (!running) break
                } while (videoView.currentPosition < duration)
            }.start()
        }

        /*
        val pos: Int = videoView.getCurrentPosition();
        Toast.makeText(this,"Current Position:" + pos +"(ms)", Toast.LENGTH_LONG).show();

         */
    }
}

