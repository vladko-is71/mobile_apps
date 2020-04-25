package com.example.lab3pizzawithdata

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast
import android.widget.RadioButton
import java.lang.StringBuilder
import java.io.FileOutputStream
import java.io.IOException
import android.content.Intent


class MainActivity : AppCompatActivity() {

    private val FILE_NAME = "content.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showOrder (view : View) {

        val id = radioGroup.checkedRadioButtonId
        if (id == -1) {
            val noSize = Toast.makeText(applicationContext, "No size was selected",
                Toast.LENGTH_LONG).show()
        }

        else {
            val size = findViewById<RadioButton>(id).text
            val stringBuilder = StringBuilder().append("The order is:\n")
            if (margherita.isChecked)
                stringBuilder.append("Margherita pizza, ").append(size).append("\n")
            if (four_cheese.isChecked)
                stringBuilder.append("Four-cheese pizza, ").append(size).append("\n")

            if (stringBuilder.toString() == "") {
                val noPizza = Toast.makeText(applicationContext, "No pizza was selected",
                    Toast.LENGTH_LONG).show()
            }
            else {
                if (textInputEditText.text.toString() == "")
                    stringBuilder.append("to (empty address) :(((")
                else
                    stringBuilder.append("to ").append(textInputEditText.text.toString())
                stringBuilder.append("\n")
                val finalText = stringBuilder.toString()
                output.text = finalText
                saveText(view, finalText)
            }
        }
    }

    private fun saveText(view: View, text: String) {
        var fos: FileOutputStream? = null
        try {
            fos = openFileOutput(FILE_NAME, Context.MODE_APPEND)
            fos!!.write(text.toByteArray())
            Toast.makeText(this, "File is saved", Toast.LENGTH_SHORT).show()
        } catch (ex: IOException) {
            Toast.makeText(this, ex.message, Toast.LENGTH_SHORT).show()
        } finally {
            try {
                fos?.close()
            } catch (ex: IOException) {
                Toast.makeText(this, ex.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun launchLogs(view: View) {
        val intent = Intent(this, LogAccessActivity::class.java)
        startActivity(intent)
    }

}
