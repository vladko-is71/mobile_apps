package com.example.lab2fragmentpizza

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_top.*


class TopFragment : Fragment() {

    private var mListener: OnFragmentInteractionListener? = null


    override fun onAttach(context : Context) {
        try {
            super.onAttach(context)
            mListener = context as OnFragmentInteractionListener
        } catch (e: Exception) {
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val button = view?.findViewById(R.id.button) as Button?
        button?.setOnClickListener(View.OnClickListener {
            val finalString = showOrder()
            mListener?.onFragmentInteraction(finalString)
        })

        return inflater.inflate(R.layout.fragment_top, container, false)
    }

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(newText: String)
    }

    private fun showOrder () : String {

        val id = radioGroup.checkedRadioButtonId
        if (id == -1) {
            Toast.makeText(activity, "No size was selected", Toast.LENGTH_LONG).show()
        }

        else {
            val size = activity?.findViewById<RadioButton>(id)?.text
            val stringBuilder = StringBuilder()

            if (margherita.isChecked) {
                stringBuilder.append("Margherita pizza, ").append(size).append("\n")
            }
            if (four_cheese.isChecked) {
                stringBuilder.append("Four-cheese pizza, ").append(size).append("\n")
            }

            if (stringBuilder.toString() == "") {
                Toast.makeText(activity, "No pizza was selected", Toast.LENGTH_LONG).show()
            }
            else {
                if (textInputEditText.text.toString() == "") {
                    stringBuilder.append("to (empty address) :(((")
                }
                else {
                    stringBuilder.append("to ").append(textInputEditText.text.toString())
                }

                return stringBuilder.toString()
            }
        }
        return ""
    }

}
