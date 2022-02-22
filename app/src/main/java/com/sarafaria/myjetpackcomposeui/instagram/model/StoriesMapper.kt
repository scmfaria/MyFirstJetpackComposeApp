package com.sarafaria.myjetpackcomposeui.instagram.model

import com.sarafaria.myjetpackcomposeui.R

object StoriesMapper {

    fun getMockStories(): List<Story> {
        val stories: MutableList<Story> = ArrayList()

        val story1 = Story(R.drawable.avatar, "name 1")
        val story2 = Story(R.drawable.avatar, "name 2")
        val story3 = Story(R.drawable.avatar, "name 3")
        val story4 = Story(R.drawable.avatar, "name 4")
        val story5 = Story(R.drawable.avatar, "name 5")
        val story6 = Story(R.drawable.avatar, "name 6")
        val story7 = Story(R.drawable.avatar, "name 7")
        val story8 = Story(R.drawable.avatar, "name 8")
        val story9 = Story(R.drawable.avatar, "name 9")
        val story10 = Story(R.drawable.avatar, "name 10")

        stories.add(story1)
        stories.add(story2)
        stories.add(story3)
        stories.add(story4)
        stories.add(story5)
        stories.add(story6)
        stories.add(story7)
        stories.add(story8)
        stories.add(story9)
        stories.add(story10)

        return stories
    }
}