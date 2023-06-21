package com.jptest.realogyapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.jptest.realogyapp.R


class FragmentDetail : Fragment() {
    var titleView: TextView? = null
    var detailView: TextView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_detail, container, false)
        titleView = rootView.findViewById(R.id.name_view)
        detailView = rootView.findViewById(R.id.detail_view)
        return rootView
    }


    fun displayDetails(title: String, description: String) {
        titleView?.text = title
        detailView?.text = description

    }
}
