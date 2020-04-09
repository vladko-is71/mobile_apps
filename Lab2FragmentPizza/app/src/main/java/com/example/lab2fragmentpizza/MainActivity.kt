package com.example.lab2fragmentpizza

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity() : AppCompatActivity(), TopFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager = supportFragmentManager

        val topFragment = TopFragment()
        manager.beginTransaction().replace(R.id.topLayout, topFragment, topFragment.tag)
            .commit()

        val bottomFragment = BottomFragment()
        manager.beginTransaction().replace(R.id.bottomLayout, bottomFragment, bottomFragment.tag)
            .commit()
    }

    override fun onFragmentInteraction(newText : String) {
        var secondFragment = supportFragmentManager.findFragmentById(R.id.bottomLayout)
                as BottomFragment?
        if (secondFragment != null && secondFragment.isInLayout)
            secondFragment.setText(newText)

    }

}