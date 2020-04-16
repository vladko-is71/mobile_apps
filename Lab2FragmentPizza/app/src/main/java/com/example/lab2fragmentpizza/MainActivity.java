package com.example.lab2fragmentpizza;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
        implements TopFragment.OnFragmentInteractionListener {

    private FrameLayout topLayout;
    private FrameLayout bottomLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topLayout = (FrameLayout) findViewById(R.id.top);
        bottomLayout = (FrameLayout) findViewById(R.id.bottom);

        FragmentManager fm = getSupportFragmentManager();


        Fragment topFragment = fm.findFragmentById(R.id.top);
        if (topFragment == null) {
            topFragment = new TopFragment();
            fm.beginTransaction()
                    .add(R.id.top, topFragment)
                    .commit();
        }

        Fragment bottomFragment = fm.findFragmentById(R.id.bottom);
        if (bottomFragment == null) {
            bottomFragment = new BottomFragment();
            fm.beginTransaction()
                    .add(R.id.bottom, bottomFragment)
                    .commit();
        }
    }

    @Override
    public void onFragmentInteraction(String link) {
        FragmentManager fm = getSupportFragmentManager();
        BottomFragment bottomFragment = (BottomFragment) fm.findFragmentById(R.id.bottom);
        bottomFragment.modifyTextView(link);
    }
}