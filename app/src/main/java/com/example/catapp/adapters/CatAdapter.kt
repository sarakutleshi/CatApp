package com.example.catapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.catapp.R
import com.example.catapp.models.CatImage
import com.squareup.picasso.Picasso

class CatAdapter(private val onClick: (CatImage) -> Unit) :
    RecyclerView.Adapter<CatAdapter.ViewHolder>() {

    private var catImages: List<CatImage> = emptyList()

    fun submitList(list: List<CatImage>) {
        catImages = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cat, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(catImages[position])
    }

    override fun getItemCount(): Int = catImages.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val catImage: ImageView = itemView.findViewById(R.id.catImage)

        fun bind(catImageData: CatImage) {
            Picasso.get().load(catImageData.url).into(catImage)
            itemView.setOnClickListener { onClick(catImageData) }
        }
    }
}