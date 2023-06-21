package com.jptest.realogyapp.ui

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.jptest.realogyapp.R
import com.jptest.realogyapp.viewmodel.SharedViewModel


class FragmentDetail : Fragment() {
    var titleView: TextView? = null
    var detailView: TextView? = null
    var viewModel=SharedViewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
viewModel=ViewModelProvider(requireActivity())[SharedViewModel::class.java]
        val rootView = inflater.inflate(R.layout.fragment_detail, container, false)
        titleView = rootView.findViewById(R.id.name_view)
        detailView = rootView.findViewById(R.id.detail_view)
        return rootView
    }

    fun displayDetails() {
        viewModel.details.observe(requireActivity()){
            Log.e(TAG, "displayDetails: "+it.FirstURL)
        }
//        titleView?.text = viewModel.title.value
//        detailView?.text = viewModel.detail.value

    }
}
