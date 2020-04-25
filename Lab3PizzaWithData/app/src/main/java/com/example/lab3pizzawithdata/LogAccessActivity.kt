package com.example.lab3pizzawithdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import java.io.FileInputStream
import java.io.IOException
import android.text.method.ScrollingMovementMethod


class LogAccessActivity : AppCompatActivity() {

    private val FILE_NAME = "content.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_access)
        var fin: FileInputStream? = null
        val logText = findViewById<TextView>(R.id.logText)
        try {
            fin = openFileInput(FILE_NAME)
            val bytes = ByteArray(fin!!.available())
            fin.read(bytes)
            val text = String(bytes)
            if (text != "")
                logText.text = text
        } catch (ex: IOException) {
            Toast.makeText(this, ex.message, Toast.LENGTH_SHORT).show()
        } finally {
            try {
                fin?.close()
            } catch (ex: IOException) {
                Toast.makeText(this, ex.message, Toast.LENGTH_SHORT).show()
            }
        }
        logText.movementMethod = ScrollingMovementMethod()
    }
}
