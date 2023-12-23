package com.example.feednews


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar


class MainActivity : AppCompatActivity(), OnSelectedTextViewListener {


    private var currentIndex = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
    }


    override fun onTextViewSelected(textViewIndex: Int) {
        currentIndex = textViewIndex
        val fragmentManager = supportFragmentManager
        val secondFragment =
            fragmentManager.findFragmentById(R.id.second_fragment) as SecondFragment
        secondFragment.setDescription(textViewIndex)
        updateSecondFragment()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.arrow_right -> {
                if (currentIndex < 6) {
                    currentIndex++
                    updateSecondFragment()
                }
                true
            }
            R.id.arrow_left -> {
                if (currentIndex > 1) {
                    currentIndex--
                    updateSecondFragment()
                }
                true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }
    private fun updateSecondFragment() {
        val fragmentManager = supportFragmentManager
        val secondFragment = fragmentManager.findFragmentById(R.id.second_fragment) as SecondFragment

        if (currentIndex >= 1 && currentIndex < resources.getStringArray(R.array.title).size) {
            secondFragment.setDescription(currentIndex)
        }
    }
}