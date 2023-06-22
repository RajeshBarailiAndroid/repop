package com.jptest.realogyapp.ui

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar

import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jptest.realogyapp.R
import com.jptest.realogyapp.model.Characters
import com.jptest.realogyapp.model.RelatedTopics
import com.jptest.realogyapp.ui.adapter.CharacterAdapter
import com.jptest.realogyapp.utils.Response
import com.jptest.realogyapp.viewmodel.CharacterViewModel
import com.jptest.realogyapp.viewmodel.SharedViewModel


class FragmentList : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var search: SearchView
    var shareViewModel = SharedViewModel()
    var adapter = CharacterAdapter()
    var load: ProgressBar? = null
    var error: TextView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_list, container, false)
        var viewModel = ViewModelProvider(requireActivity())[CharacterViewModel::class.java]
        shareViewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
        loadUI(viewModel)
        setUI(rootView)
        return rootView
    }

    private fun loadUI(viewModel: CharacterViewModel) {
        viewModel.character.observe(viewLifecycleOwner) {

            when (it) {

                is Response.Loading -> {
                    load?.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                    error?.visibility = View.GONE
                }

                is Response.Success -> {
                    load?.visibility = View.GONE
                    error?.visibility = View.GONE
                    recyclerView.visibility = View.VISIBLE
                    loadData(it)
                }

                is Response.Error -> {
                    error?.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                    load?.visibility = View.GONE
                }
            }
        }
    }

    private fun setUI(rootView: View) {
        recyclerView = rootView.findViewById(R.id.recyclerview_id)
        load = rootView.findViewById(R.id.load)
        error = rootView.findViewById(R.id.error_msg)
        search = rootView.findViewById(R.id.search_text)
        search.clearFocus()
        val recyclerView = rootView.findViewById(R.id.recyclerview_id) as RecyclerView
        recyclerView.adapter = adapter
        val manager = LinearLayoutManager(activity)
        manager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = manager
    }

    private fun loadData(it: Response<Characters>) {
        var data = it.data?.RelatedTopics
        data?.sortedBy { it.Text }

        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            var filterData = listOf<RelatedTopics>()
            override fun onQueryTextSubmit(query: String?): Boolean {
                // Handle search query submission
                if (!query.isNullOrEmpty()) {
                    filterData = data?.filter { it.Result.contains(query.toString(), true) }!!
                    return false
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                filterData = data?.filter { it.Result.contains(newText.toString(), true) }!!

                if (filterData != null && data != null) {
                    Log.e(TAG, "onQueryTextChange: " + filterData.size)
                    adapter.setData(filterData, context, shareViewModel)

                }
                return true
            }
        })

        if (data != null) {
            adapter.setData(data, context, shareViewModel)
        }
    }
}
