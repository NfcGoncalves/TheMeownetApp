package com.example.themeownetapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.themeownetapp.data.response.CatImage
import com.example.themeownetapp.databinding.ItemCardCatBinding

class CatImageAdapter :
    PagingDataAdapter<CatImage, CatImageAdapter.PhotoViewHolder>(DIFF_UTIL) {

    inner class PhotoViewHolder(private val binding: ItemCardCatBinding) :
        RecyclerView.ViewHolder(binding.root) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding =
            ItemCardCatBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: PhotoViewHolder, position: Int) {
        TODO("Not yet implemented")
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