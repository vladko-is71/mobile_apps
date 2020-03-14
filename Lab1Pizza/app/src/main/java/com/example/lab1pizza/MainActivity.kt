package com.example.lab1pizza

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast
import android.widget.RadioButton
import java.lang.StringBuilder


class MainActivity : AppCompatActivity() {

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
            val stringBuilder = StringBuilder()

            if (margherita.isChecked) {
                stringBuilder.append("Margherita pizza, ").append(size).append("\n")
            }
            if (four_cheese.isChecked) {
                stringBuilder.append("Four-cheese pizza, ").append(size).append("\n")
            }

            if (stringBuilder.toString() == "") {
                val noPizza = Toast.makeText(applicationContext, "No pizza was selected",
                    Toast.LENGTH_LONG).show()
            }
            else {
                if (textInputEditText.text.toString() == "") {
                    stringBuilder.append("to (empty address) :(((")
                }
                else {
                    stringBuilder.append("to ").append(textInputEditText.text.toString())
                }

                val finalText = stringBuilder.toString()
                output.text = finalText
            }
        }
    }
}
