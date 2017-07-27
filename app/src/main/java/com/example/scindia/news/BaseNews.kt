package com.example.scindia.news

/**
 * Created by SCINDIA on 7/10/2017.
 */

data class BaseNews (
    var author: String,
    var title: String,
    var description: String,
    var url: String,
    var urlToImage: String,
    var publishedAt: String
)
