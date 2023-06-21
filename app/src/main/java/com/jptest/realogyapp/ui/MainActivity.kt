package com.jptest.realogyapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.jptest.realogyapp.R
import com.jptest.realogyapp.viewmodel.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(){
    private var mIsDualPane = false

         var viewModel=SharedViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
viewModel=ViewModelProvider(this)[SharedViewModel::class.java]
      val fragmentDetailsView = findViewById<View>(R.id.fragmentDetails)
       mIsDualPane = fragmentDetailsView?.visibility == View.VISIBLE
setUi()
    }

    private fun setUi() {
        viewModel.details.observe(this){
            if (mIsDualPane) { // If we are in Tablet

            } else { // When we are in Smart phone

                val intent = Intent(this, DetailActivity::class.java)

                startActivity(intent)
            }
        }


    }

}