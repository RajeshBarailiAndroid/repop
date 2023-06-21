package com.jptest.realogyapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.jptest.realogyapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(),MyCommunicator {
    private var mIsDualPane = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      val fragmentBView = findViewById<View>(R.id.fragmentB)
       mIsDualPane = fragmentBView?.visibility == View.VISIBLE

    }

    override fun displayDetails(title: String, imageUrl: Any, description: String) {

        if (mIsDualPane) { // If we are in Tablet
            val fragmentB = supportFragmentManager.findFragmentById(R.id.fragmentB) as FragmentDetail?
            fragmentB?.displayDetails(title, description)
        } else { // When we are in Smart phone
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("title", title)
            intent.putExtra("description", description)
            startActivity(intent)
        }
    }
}