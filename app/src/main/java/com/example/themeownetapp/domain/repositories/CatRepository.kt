package com.example.themeownetapp.domain.repositories

import com.example.themeownetapp.data.request.CatRequestApi
import javax.inject.Inject
import javax.inject.Singleton

//Let's get some DI on to the repository so we can make an api request
@Singleton
class CatRepository @Inject constructor(
    private val catImageApi: CatRequestApi
) {

}