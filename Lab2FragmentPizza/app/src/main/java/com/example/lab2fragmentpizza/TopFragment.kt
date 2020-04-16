package com.example.lab2fragmentpizza

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_top.*


class TopFragment : Fragment() {

    private var mListener: OnFragmentInteractionListener? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_top, container, false)
        val button = view.findViewById<View>(R.id.button) as Button
        button.setOnClickListener {
            val textToChange = showOrder()
            mListener?.onFragmentInteraction(textToChange)
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener)
            mListener = context
        else
            throw ClassCastException("$context has to implement an interface")
    }

    internal interface OnFragmentInteractionListener {
        fun onFragmentInteraction(link: String?)
    }

    private fun showOrder() : String {

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