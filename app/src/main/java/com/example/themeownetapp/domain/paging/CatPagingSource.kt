package com.example.themeownetapp.domain.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.themeownetapp.core.Constants.STARTING_PAGE_INDEX
import com.example.themeownetapp.data.request.CatRequestApi
import com.example.themeownetapp.data.response.CatImage
import retrofit2.HttpException
import java.io.IOException

//Added paging as I found it to be the best way to display the cat images without adding fragments and navigation
class CatPagingSource(
    private val catApi: CatRequestApi,
    private val mimeType: String
) : PagingSource<Int, CatImage>() {
    override fun getRefreshKey(state: PagingState<Int, CatImage>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CatImage> {
        //first we need to know what page we're currently on
        val position = params.key ?: STARTING_PAGE_INDEX

        //now we make the call
        //if everything goes well, we load the results, otherwise we catch the IO or and HTTP exceptions
        return try {
            val response = catApi.getAllCatImages(mimeType, position)

            LoadResult.Page(
                data = response,
                prevKey = if (position == STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (response.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }
}
