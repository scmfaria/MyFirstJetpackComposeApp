package com.sarafaria.myjetpackcomposeui.instagram.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sarafaria.myjetpackcomposeui.R
import com.sarafaria.myjetpackcomposeui.instagram.model.Feed

@Composable
fun FeedContentView(feeds: List<Feed>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        feeds.forEach {
            FeedHeader(it)
            FeedMediaActions(it)
        }
    }
}

@Composable
private fun FeedHeader(feed: Feed) {
    Row(modifier = Modifier.padding(16.dp)) {
        Row(modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically) {
            Image(
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp)
                    .clip(RoundedCornerShape(50.dp)),
                painter = painterResource(id = R.drawable.avatar),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center
            )

            Text(
                modifier = Modifier.padding(start = 8.dp),
                textAlign = TextAlign.Center,
                text = feed.userName,
            )
        }

        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_more),
            contentDescription = null,
            modifier = Modifier
                .width(30.dp)
                .height(30.dp)
                .padding(3.dp)
        )
    }
}

@Composable
private fun FeedMediaActions(feed: Feed) {
    Column {
        Image(
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.insta_cover_image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 120.dp)
        )

        Row(modifier = Modifier.padding(start = 12.dp, end = 12.dp, bottom = 8.dp, top = 8.dp)) {
            Row(modifier = Modifier.weight(1f)) {

                IconContainer(iconResId = R.drawable.ic_like)
                IconContainer(iconResId = R.drawable.ic_comment)
                IconContainer(iconResId = R.drawable.ic_share)
            }

            IconContainer(iconResId = R.drawable.ic_save)
        }

        Text(
            text = "${feed.like.qtd} curtidas",
            modifier = Modifier.padding(start = 12.dp),
            style = MaterialTheme.typography.subtitle2.copy(fontWeight = FontWeight.Medium)
        )
    }
}

@Composable
private fun IconContainer(iconResId: Int) {
    Image(
        painter = painterResource(id = iconResId),
        contentDescription = null,
        modifier = Modifier
            .padding(end = 5.dp, start = 5.dp)
            .width(30.dp)
            .height(30.dp)
    )
}