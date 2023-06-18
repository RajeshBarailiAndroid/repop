package com.jptest.realogyapp.ui

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jptest.realogyapp.R
import com.jptest.realogyapp.model.Characters
import com.jptest.realogyapp.ui.adapter.CharacterAdapter
import com.jptest.realogyapp.utils.Response
import com.jptest.realogyapp.viewmodel.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: CharacterViewModel by viewModels()

    private lateinit var recyclerView: RecyclerView
    private lateinit var search: SearchView
  //  private lateinit var dataViewModel: SimpsonsViewModel
    var load: ProgressBar? = null
    var error: TextView? = null
   private var characterAdapter = CharacterAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // setUI()
        loadUI()
    }

    private fun loadUI() {
      viewModel.character.observe(this){
          Log.e(TAG, "loadUI: ------------"+it.data)
          when (it) {

//              is Response.Loading -> {
//                  load?.visibility = View.VISIBLE
//                  recyclerView.visibility = View.GONE
//                  error?.visibility = View.GONE
//              }
//
//              is Response.Success -> {
//                  load?.visibility = View.GONE
//                  error?.visibility = View.GONE
//                  recyclerView.visibility = View.VISIBLE
//                  loadData(it)
//              }
//
//              is Response.Error -> {
//                  error?.visibility = View.VISIBLE
//                  recyclerView.visibility = View.GONE
//                  load?.visibility = View.GONE
              }
          }
      }
    }

//    private fun setUI() {
//        recyclerView = findViewById(R.id.recyclerview_id)
//        load = findViewById(R.id.load)
//        error = findViewById(R.id.error_msg)
//        search = findViewById(R.id.search)
//        search.clearFocus()
//        this.recyclerView.layoutManager = LinearLayoutManager(applicationContext)
//      this.characterAdapter.also { this.recyclerView.adapter = it }
//    }
//
//    private fun loadData(it: Response<Characters>) {
//        var data = it.data?.RelatedTopics
//        data?.sortedBy { it.Text }
//        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                // Handle search query submission
//                return true
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                val filterData = data?.filter { it.Result.contains(newText.toString(), true) }
//                if (filterData != null) {
//                    characterAdapter.setData(filterData)
//                }
//                return true
//            }
//        })
//        if (data != null) {
//            characterAdapter.setData(data)
//        }
//    }
    //var ss=BuildConfig.
//}