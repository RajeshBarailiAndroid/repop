package com.jptest.realogyapp.ui.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jptest.realogyapp.R
import com.jptest.realogyapp.model.RelatedTopics
import com.jptest.realogyapp.ui.MyCommunicator

class CharacterAdapter(private val context: Context?, private var list: List<RelatedTopics>) :
    RecyclerView.Adapter<CharacterAdapter.MyViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = inflater.inflate(R.layout.card_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val current = list[position]

        //        val current = item[position]
        val nameLong = current.Text.split("-")
        val name = nameLong.first()
        val image = current.Icon.URL
        val detail = nameLong.last()

        // Set the text and image for the views
        holder.text.text = name
        val imageUrl = if (image.isEmpty() == true) {
            R.drawable.image_duck
        } else {
            "https://duckduckgo.com$image"
        }
        Glide.with(holder.imageCard.context).load(imageUrl).into(holder.imageCard)


        holder.arrow.setOnClickListener { view ->
            val myCommunicator = context as MyCommunicator
            myCommunicator.displayDetails(name,imageUrl,detail)

        }
    }

    override fun getItemCount(): Int = list.size

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text: TextView = itemView.findViewById(R.id.text_view)
        var arrow: ImageView = itemView.findViewById(R.id.arrowImageView)
        var card: LinearLayout = itemView.findViewById(R.id.card)
        var imageCard: ImageView = itemView.findViewById(R.id.card_image_view)
    }


//        lateinit var current: RelatedTopics
//
//        fun setData(current: RelatedTopics, position: Int) {
//            itemView.text.text = current.
//
//            this.pos = position
//            this.current = current
//        }

//        fun setListeners() {
//
//            itemView.setOnClickListener {
//                val myCommunicator = context as MyCommunicator
//                myCommunicator.displayDetails(current.title, current.description)
//            }
//        }

}

//class CharacterAdapter(filterData: List<RelatedTopics>) : RecyclerView.Adapter<CharacterAdapter.MyViewHolder>() {
// private var item = filterData
////    private val expandedPositions = mutableSetOf<Int>()
////    fun setData(data: List<RelatedTopics>) {
////        item = data
////        notifyDataSetChanged()
////    }
//    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val text: TextView = itemView.findViewById(R.id.text_view)
//        var arrow:ImageView = itemView.findViewById(R.id.arrowImageView)
//        var card:LinearLayout = itemView.findViewById(R.id.card)
//        var imageCard:ImageView = itemView.findViewById(R.id.card_image_view)
//
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
//        return MyViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        val current = item[position]
//        val nameLong = current.Text.split("-")
//        val name = nameLong.first()
//        val image = current.Icon.URL
//        val detail = nameLong.last()
//
//        // Set the text and image for the views
//        holder.text.text = name
//        val imageUrl = if (image?.isEmpty() == true) {
//            R.drawable.image_duck
//        } else {
//            "https://duckduckgo.com$image"
//        }
//        Glide.with(holder.imageCard.context).load(imageUrl).into(holder.imageCard)
//
//        // Set the click listener for the arrow view
//        holder.arrow.setOnClickListener { view ->
//            val myCommunicator = context as MyCommunicator
//            myCommunicator.displayDetails(current.Text, current.FirstURL)
////            if (view.resources.getBoolean(R.bool.is_tablet)){
////                val isExpanded = expandedPositions.contains(position)
////                if (isExpanded) {
////                    // If the item is already expanded, collapse it
////                    expandedPositions.remove(position)
////                    holder.arrow.setImageResource(R.drawable.arrow_forward)
////                    holder.card.visibility = View.GONE
////                } else {
////                    // If the item is not expanded, expand it
////                    expandedPositions.add(position)
////                    holder.arrow.setImageResource(R.drawable.expand_less)
////                    holder.arrow.scaleType = ImageView.ScaleType.FIT_XY
////                    holder.nameCard.text = name
////                    holder.detailCard.text = detail
////                    holder.card.visibility = View.VISIBLE
////                }
////            }else{var int = Intent(view.context, DetailView::class.java)
////                int.putExtra("name",name)
////                int.putExtra("image",image)
////                int.putExtra("result",detail)
////                view.context.startActivity(int)}
////
////
//        }
//
//        // Set the visibility of the card view based on the expanded state
////        holder.card.visibility = if (expandedPositions.contains(position)) {
////            View.VISIBLE
////        } else {
////            View.GONE
////        }
//    }
//
//    override fun getItemCount() = item.size
//
//
//}


