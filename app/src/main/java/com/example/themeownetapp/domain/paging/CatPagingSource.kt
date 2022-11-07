package com.example.themeownetapp.domain.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.themeownetapp.data.request.CatRequestApi
import com.example.themeownetapp.data.response.CatImage

//Added paging as I found it to be the best way to display the cat images without adding fragments and navigation
class CatPagingSource(
    private val catApi: CatRequestApi,
    private val mimeType: String
) : PagingSource<Int, CatImage>() {
    override fun getRefreshKey(state: PagingState<Int, CatImage>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CatImage> {
        TODO("Not yet implemented")
    }
}
