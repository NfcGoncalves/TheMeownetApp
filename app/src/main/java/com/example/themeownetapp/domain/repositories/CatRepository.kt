package com.example.themeownetapp.domain.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.themeownetapp.core.Constants.MAX_SIZE
import com.example.themeownetapp.core.Constants.PAGE_SIZE
import com.example.themeownetapp.data.request.CatRequestApi
import com.example.themeownetapp.domain.paging.CatPagingSource
import javax.inject.Inject
import javax.inject.Singleton

//Let's get some DI on to the repository so we can make an api request
@Singleton
class CatRepository @Inject constructor(
    private val catImageApi: CatRequestApi
) {

    //This will then be called by the ViewModel
    //it will return a pager from the paging library
    fun getCatImages(
        mimeTypes: String
    ) = Pager(
        config = PagingConfig(
            //A page size of 30 and a max size of 100 looks good to make a demonstration
            pageSize = PAGE_SIZE,
            maxSize = MAX_SIZE,
            enablePlaceholders = false
        ),
        pagingSourceFactory = { CatPagingSource(catImageApi, mimeTypes) }
    ).liveData

}