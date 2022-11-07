package com.example.themeownetapp.data.request

import com.example.themeownetapp.data.response.CatImage
import retrofit2.http.GET
import retrofit2.http.Query

interface CatRequestApi {

    //Let's create the query with the parameters we need
    @GET("images/search/")
    suspend fun getAllCatImages(
        @Query("mime_types") mimeTypes: String
    ): List<CatImage>
}