package com.example.themeownetapp.presentation.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.themeownetapp.R
import com.example.themeownetapp.core.Constants
import com.example.themeownetapp.databinding.ActivityMainBinding
import com.example.themeownetapp.presentation.adapters.CatImageAdapter
import com.example.themeownetapp.presentation.viewmodels.CatGalleryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<CatGalleryViewModel>()
    private val adapter = CatImageAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = adapter
        }

        //here we observe the livecycle data from the images
        viewModel.images.observe(this) {
            adapter.submitData(this.lifecycle, it)
        }

        //Set up the bottom navigation so that it changes the query when pressed
        binding.fragmentGalleryBottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.imagesFragment -> viewModel.changeImageType(Constants.IMAGE_TYPE_IMAGE)
                R.id.gifsFragment -> viewModel.changeImageType(Constants.IMAGE_TYPE_GIF)
                R.id.bothFragment -> viewModel.changeImageType(Constants.IMAGE_TYPE_BOTH)
            }
            true
        }
    }
}