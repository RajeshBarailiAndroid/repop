package com.jptest.realogyapp.ui

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.jptest.realogyapp.R
import com.jptest.realogyapp.viewmodel.SharedViewModel

class DetailActivity:AppCompatActivity(){
var viewModel=SharedViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        var detail = intent.getStringExtra("description")
        var image = intent.getStringExtra("image")
        var name = intent.getStringExtra("name")

        // Pass the data to FragmentB to display it
        val fragmentB = supportFragmentManager.findFragmentById(R.id.fragmentDetails) as FragmentDetail?
        detail=detail?:""
        image=image?:""
        name=name?:""
        fragmentB?.displayDetails(name,image,detail)

     }

        // Pass the data to fragmentDetails to display it

        }


