package com.example.themeownetapp.presentation

import androidx.lifecycle.ViewModel
import com.example.themeownetapp.domain.repositories.CatRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

//Also DI here so we can call the Repository
@HiltViewModel
class CatGalleryViewModel @Inject constructor(private val repository: CatRepository) : ViewModel() {

}