package com.example.lab4media

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView
import android.net.Uri
import android.view.View
import android.widget.Button
import android.widget.MediaController

class VideoPlayerActivity : AppCompatActivity() {

    var videoPlayer : VideoView? = null
    var playButton: Button? = null
    var pauseButton: Button? = null
    var stopButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)

        videoPlayer = findViewById<VideoView>(R.id.videoPlayer)
        val myVideoUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.train)
        val videoURI = videoPlayer?.setVideoURI(myVideoUri)

        playButton = findViewById<Button>(R.id.play)
        pauseButton = findViewById<Button>(R.id.pause)
        stopButton = findViewById<Button>(R.id.stop)

        pauseButton?.isEnabled = false
        stopButton?.isEnabled = false

        val mc = MediaController(this)
        videoPlayer?.setMediaController(mc)
    }

    fun play(view : View) {
        videoPlayer?.start()

        playButton?.isEnabled = false
        pauseButton?.isEnabled = true
        stopButton?.isEnabled = true
    }

    fun pause (view : View) {
        videoPlayer?.pause()
        playButton?.isEnabled = true
        pauseButton?.isEnabled = false
        stopButton?.isEnabled = true
    }

    fun stop (view : View) {
        videoPlayer?.stopPlayback()
        videoPlayer?.resume()
        playButton?.isEnabled = true
        pauseButton?.isEnabled = false
        stopButton?.isEnabled = false
    }
}
