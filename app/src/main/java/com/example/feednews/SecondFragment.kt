package com.example.feednews

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class SecondFragment : Fragment() {

    private lateinit var titleArray: Array<String>
    private lateinit var authorArray: Array<String>
    private lateinit var descriptionArray: Array<String>
    private lateinit var titleTextView: TextView
    private lateinit var authorTextView: TextView
    private lateinit var textArticle: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        titleArray = resources.getStringArray(R.array.title)
        titleTextView = view.findViewById(R.id.title)
        authorArray = resources.getStringArray(R.array.author)
        authorTextView = view.findViewById(R.id.author)
        descriptionArray = resources.getStringArray(R.array.description)
        textArticle = view.findViewById(R.id.text_article)


    }
    fun setDescription(index: Int){
        val title: String = titleArray[index]
        titleTextView.text = title
        val author: String = authorArray[index]
        authorTextView.text = author
        val textTv: String = descriptionArray[index]
        textArticle.text = textTv
    }

}