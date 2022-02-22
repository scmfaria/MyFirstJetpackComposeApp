package com.sarafaria.myjetpackcomposeui.instagram.model

object FeedsMapper {

    fun getMockFeeds(): List<Feed> {
        val feeds: MutableList<Feed> = ArrayList()

        val feed1 = Feed("name 1", "", Feed.Like())
        val feed2 = Feed("name 2", "", Feed.Like(isLiked = true))
        val feed3 = Feed("name 3", "", Feed.Like())
        val feed4 = Feed("name 4", "", Feed.Like(isLiked = true))

        feeds.add(feed1)
        feeds.add(feed2)
        feeds.add(feed3)
        feeds.add(feed4)

        return feeds
    }
}