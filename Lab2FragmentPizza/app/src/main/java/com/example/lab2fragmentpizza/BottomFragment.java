package com.example.lab2fragmentpizza;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class BottomFragment extends Fragment {

    // private TextView textView;

    public BottomFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom, container, false);
    }

    public void modifyTextView(String link) {
        TextView textView = (TextView) getView().findViewById(R.id.text);
        textView.setText(link);
    }

}
