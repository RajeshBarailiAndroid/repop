package com.jptest.realogyapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jptest.realogyapp.R

class DetailActivity:AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Retrieve data coming from MainActivity.java
        val description = intent.getStringExtra("description")
        val title = intent.getStringExtra("title")

        // Pass the data to FragmentB to display it
        val fragmentB = supportFragmentManager.findFragmentById(R.id.fragmentB) as FragmentDetail?
        if (title != null) {
            if (description != null) {
                fragmentB?.displayDetails(title, description)
            }
        }
    }
}
