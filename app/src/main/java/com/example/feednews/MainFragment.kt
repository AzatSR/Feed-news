package com.example.feednews

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

interface OnSelectedTextViewListener {
    fun onTextViewSelected(textViewIndex: Int)
}

class MainFragment : Fragment(), View.OnClickListener {

    private var index = -1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textClickedFirst: TextView = view.findViewById(R.id.tv_first)
        val textClickedSecond: TextView = view.findViewById(R.id.tv_second)
        val textClickedThird: TextView = view.findViewById(R.id.tv_third)
        val textClickedFourth: TextView = view.findViewById(R.id.tv_fourth)
        val textClickedFifth: TextView = view.findViewById(R.id.tv_fifth)
        val textClickedSixth: TextView = view.findViewById(R.id.tv_sixth)
        textClickedFirst.setOnClickListener(this)
        textClickedSecond.setOnClickListener(this)
        textClickedThird.setOnClickListener(this)
        textClickedFourth.setOnClickListener(this)
        textClickedFifth.setOnClickListener(this)
        textClickedSixth.setOnClickListener(this)
    }


    override fun onClick(p0: View?) {
        val tvIndex = translatedToIndex(p0!!.id)
        val listener = activity as OnSelectedTextViewListener?
        listener?.onTextViewSelected(tvIndex)
    }

    private fun translatedToIndex(id: Int): Int {

        when (id) {
            R.id.tv_first -> index = 1
            R.id.tv_second -> index = 2
            R.id.tv_third -> index = 3
            R.id.tv_fourth -> index = 4
            R.id.tv_fifth -> index = 5
            R.id.tv_sixth -> index = 6
        }
        return index
    }
}