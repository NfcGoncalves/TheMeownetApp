package com.example.themeownetapp.data.response

data class CatImage(
    val id: String,
    val url: String,
    val categories: Category
)

data class Category(
    val id: Int,
    val name: String
)
