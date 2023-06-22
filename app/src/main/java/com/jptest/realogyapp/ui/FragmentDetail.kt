package com.jptest.realogyapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.jptest.realogyapp.R
import com.jptest.realogyapp.viewmodel.SharedViewModel


class FragmentDetail : Fragment() {
    var isTablet=false
    var titleView: TextView? = null
    var detailView: TextView? = null
    var imageView: ImageView? = null
    var viewModel = SharedViewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_detail, container, false)
       setUI(rootView)

        setMenu(rootView)
        return rootView
    }

    private fun setUI(rootView: View?) {
        titleView = rootView?.findViewById(R.id.name_view)
        detailView = rootView?.findViewById(R.id.detail_view)
        imageView = rootView?.findViewById(R.id.image_view)
       isTablet=resources.getBoolean(R.bool.is_tablet)
    }

    private fun setMenu(rootView: View) {
        if (!isTablet){
        setHasOptionsMenu(true)
        var toolbar = (activity as? AppCompatActivity)?.supportActionBar
        toolbar?.setDisplayHomeAsUpEnabled(true)}
    }

    fun displayDetails(name: String, image: String, detail: String) {
        val imageUrl = if (image.isEmpty() == true) {
            R.drawable.image_duck
        } else {
            "https://duckduckgo.com$image"
        }
        imageView?.let { Glide.with(requireActivity()).load(imageUrl).into(it) }
        titleView?.text = name
        detailView?.text = detail

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            // Navigate back to the previous fragment
            activity?.onBackPressed()
            return true
        }

        return false
    }
}
