package com.jptest.realogyapp.ui

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.jptest.realogyapp.R

class DetailActivity:AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Retrieve data coming from MainActivity.java
        val description = intent.getStringExtra("description")
        val title = intent.getStringExtra("title")

        // Pass the data to fragmentDetails to display it
        val fragmentDetails = supportFragmentManager.findFragmentById(R.id.fragmentDetails) as FragmentDetail
        if (title != null) {
            if (description != null) {
                Log.e(TAG, "onCreate:------------------------ "+title )
                fragmentDetails?.displayDetails()
            }
        }
    }
}
