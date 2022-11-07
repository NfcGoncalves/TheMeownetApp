package com.example.themeownetapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.themeownetapp.R
import com.example.themeownetapp.data.response.CatImage
import com.example.themeownetapp.databinding.ItemCardCatBinding

class CatImageAdapter :
    PagingDataAdapter<CatImage, CatImageAdapter.PhotoViewHolder>(DIFF_UTIL) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding =
            ItemCardCatBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: PhotoViewHolder, position: Int) {
        val currentItem = getItem(position)

        if (currentItem != null) {
            viewHolder.bind(currentItem)
        }
    }

    inner class PhotoViewHolder(private val binding: ItemCardCatBinding) :
        RecyclerView.ViewHolder(binding.root) {

        //We load and bind the image here with Glide
        //according to convention, bind function is created inside the viewholder
        fun bind(photo: CatImage) {
            binding.apply {
                Glide.with(itemView)
                    .load(photo.url)
                    .centerCrop()
                    .error(R.drawable.ic_broken_image)
                    .into(binding.imageViewCat)
            }
        }
    }

    //Diffutil, a standard in an adapter
    companion object {
        private val DIFF_UTIL = object : DiffUtil.ItemCallback<CatImage>() {
            override fun areItemsTheSame(oldItem: CatImage, newItem: CatImage) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: CatImage, newItem: CatImage) =
                oldItem == newItem
        }
    }
}