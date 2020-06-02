package com.example.lab4media

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.media.MediaPlayer
import android.widget.Button
import android.view.View
import android.widget.Toast
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import kotlinx.android.synthetic.main.activity_audio_player.*


class AudioPlayerActivity : AppCompatActivity() {

    var mPlayer: MediaPlayer? = null
    var playButton: Button? = null
    var pauseButton:Button? = null
    var stopButton:Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio_player)

        playButton = findViewById<Button>(R.id.play)
        pauseButton = findViewById<Button>(R.id.pause)
        stopButton = findViewById<Button>(R.id.stop)

        playButton?.isEnabled = false
        pauseButton?.isEnabled = false
        stopButton?.isEnabled = false
    }

    fun chooseSound(view: View) {
        stopActual()
        if (buttonAlarmSound.isChecked) {
            mPlayer = MediaPlayer.create(this, R.raw.alarm)
            Toast.makeText(this, "Alarm sound set", Toast.LENGTH_LONG).show()
        }
        else if (buttonMiaowSound.isChecked) {
            mPlayer = MediaPlayer.create(this, R.raw.miaow)
            Toast.makeText(this, "Miaow sound set", Toast.LENGTH_LONG).show()
        }
        mPlayer?.setOnCompletionListener { stopActual() }
        playButton?.isEnabled = true
    }

    fun play(view : View) {
        mPlayer?.start()
        playButton?.isEnabled = false
        pauseButton?.isEnabled = true
        stopButton?.isEnabled = true
    }

    fun pause(view : View) {
        mPlayer?.pause()
        playButton?.isEnabled = true
        pauseButton?.isEnabled = false
        stopButton?.isEnabled = true
    }

    private fun stopActual() {
        mPlayer?.stop()
        pauseButton?.isEnabled = false
        stopButton?.isEnabled = false
        try {
            mPlayer?.prepare()
            mPlayer?.seekTo(0)
            playButton?.isEnabled = true
        }
        catch (t : Throwable) {
            Toast.makeText(this, t.message, Toast.LENGTH_SHORT).show()
        }
    }

    fun stop(view : View) {
        stopActual()
    }

    public override fun onDestroy() {
        super.onDestroy()
        if (mPlayer?.isPlaying == true) {
            stopActual()
        }
    }
}
