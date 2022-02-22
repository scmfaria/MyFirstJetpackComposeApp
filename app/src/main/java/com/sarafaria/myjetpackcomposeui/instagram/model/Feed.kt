package com.sarafaria.myjetpackcomposeui.instagram.model
import com.sarafaria.myjetpackcomposeui.R

data class Feed(
    val userName: String,
    val image: String,
    var like: Like
) {
    data class Like(
        var iconState: Int = R.drawable.ic_like,
        var isLiked: Boolean = false,
        var qtd: Int = 0
    )
}