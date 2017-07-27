package com.example.scindia.news

/**
 * Created by SCINDIA on 7/10/2017.
 */

data class Newsfeed (
    var status: String,
    var source: String,
    var sortBy: String,
    var articles: Array<BaseNews>

)
