package com.jptest.realogyapp.ui

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.jptest.realogyapp.R
import com.jptest.realogyapp.viewmodel.SharedViewModel


class FragmentDetail : Fragment() {
    var titleView: TextView? = null
    var detailView: TextView? = null
    var imageView: ImageView? = null
    var viewModel=SharedViewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_detail, container, false)
        titleView = rootView.findViewById(R.id.name_view)
        detailView = rootView.findViewById(R.id.detail_view)
        imageView = rootView.findViewById(R.id.image_view)
        return rootView
    }
    fun displayDetails(name: String, image: String, detail: String) {
        val imageUrl = if (image?.isEmpty() == true) {
            R.drawable.image_duck
        } else {
            "https://duckduckgo.com$image"
        }
        imageView?.let { Glide.with(requireActivity()).load(imageUrl).into(it) }
        titleView?.text =name
        detailView?.text = detail

    }
}
