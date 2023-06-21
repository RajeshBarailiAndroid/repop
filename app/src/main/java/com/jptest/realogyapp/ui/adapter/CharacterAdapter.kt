package com.jptest.realogyapp.ui.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jptest.realogyapp.R
import com.jptest.realogyapp.model.RelatedTopics
import com.jptest.realogyapp.viewmodel.SharedViewModel

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.MyViewHolder>() {
 private var item= listOf<RelatedTopics>()
var viewModel:SharedViewModel?=null
    var context:Context?=null
    fun setData(data: List<RelatedTopics>, context: Context?, shareViewModel: SharedViewModel) {
        item = data
        viewModel=shareViewModel
        this.context =context
        notifyDataSetChanged()
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text: TextView = itemView.findViewById(R.id.text_view)
        var arrow:ImageView = itemView.findViewById(R.id.arrowImageView)
        var card:LinearLayout = itemView.findViewById(R.id.card)
        var imageCard:ImageView = itemView.findViewById(R.id.card_image_view)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val current = item[position]
        val nameLong = current.Text.split("-")
        val name = nameLong.first()
        val image = current.Icon.URL
        val detail = nameLong.last()

        // Set the text and image for the views
        holder.text.text = name
        val imageUrl = if (image?.isEmpty() == true) {
            R.drawable.image_duck
        } else {
            "https://duckduckgo.com$image"
        }
        //Glide.with(holder.imageCard.context).load(imageUrl).into(holder.imageCard)

        // Set the click listener for the arrow view
        holder.arrow.setOnClickListener { view ->
        viewModel?.set(current)
          //  val myCommunicator = context as MyCommunicator
        //  myCommunicator.displayDetails(current)
      }

    }

    override fun getItemCount() = item.size


}


