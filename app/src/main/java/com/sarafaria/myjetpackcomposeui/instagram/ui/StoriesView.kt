package com.sarafaria.myjetpackcomposeui.instagram.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sarafaria.myjetpackcomposeui.R
import com.sarafaria.myjetpackcomposeui.instagram.model.Story

@Composable
fun StoriesView(stories: List<Story>) {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(6.dp)) {
        BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                state = rememberLazyListState()
            ) {
                itemsIndexed(stories) { _, item ->
                    Column(
                        modifier = Modifier
                            .padding(start = 12.dp, end = 12.dp)
                            .width(60.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center) {

                        Image(
                            painter = painterResource(id = R.drawable.avatar),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            alignment = Alignment.Center,
                            modifier = Modifier
                                .width(52.dp)
                                .height(52.dp)
                                .clip(RoundedCornerShape(50.dp))
                        )

                        Text(
                            text = item.userName,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.caption,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}