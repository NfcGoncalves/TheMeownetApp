package com.example.themeownetapp.presentation.adapters

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.themeownetapp.data.response.CatImage
import com.example.themeownetapp.databinding.ItemCardCatBinding

//TODO add diffUtil
class CatImageAdapter :
    PagingDataAdapter<CatImage, CatImageAdapter.PhotoViewHolder>() {

    inner class PhotoViewHolder(private val binding: ItemCardCatBinding) :
        RecyclerView.ViewHolder(binding.root) {


    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        TODO("Not yet implemented")
    }
}