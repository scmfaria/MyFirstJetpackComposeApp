package com.sarafaria.myjetpackcomposeui.instagram

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.sarafaria.myjetpackcomposeui.form.model.AddUser
import com.sarafaria.myjetpackcomposeui.form.FormActivity
import com.sarafaria.myjetpackcomposeui.instagram.model.Feed
import com.sarafaria.myjetpackcomposeui.instagram.model.FeedsMapper
import com.sarafaria.myjetpackcomposeui.instagram.model.StoriesMapper
import com.sarafaria.myjetpackcomposeui.instagram.model.Story
import com.sarafaria.myjetpackcomposeui.instagram.ui.FeedContentView
import com.sarafaria.myjetpackcomposeui.instagram.ui.StoriesView
import com.sarafaria.myjetpackcomposeui.ui.theme.*
import com.sarafaria.myjetpackcomposeui.R

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyThemeApp {
                MainScreen(
                    stories = StoriesMapper.getMockStories(),
                    feeds = FeedsMapper.getMockFeeds()
                )
                FabView()
            }
        }
    }

    @Composable
    private fun FabView() {
        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier.fillMaxWidth()) {
            Row(
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier.fillMaxHeight()) {
                FloatingActionButton(
                    modifier = Modifier.padding(16.dp),
                    onClick = {
                        showFormActivity()
                    },
                    backgroundColor = colorResource(id = R.color.purple_500)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
        }
    }

    private fun showFormActivity() {
        resultLauncher.launch(Intent(this, FormActivity::class.java))
    }

    private var resultLauncher = registerForActivityResult(StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            val user = data?.getParcelableExtra("user_state") as AddUser?
            Toast.makeText(this,
                "Name: ${user?.name}, E-mail: ${user?.email}", Toast.LENGTH_LONG).show()
        }
    }
}

@Composable
private fun MainScreen(stories: List<Story>, feeds: List<Feed>) {
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())) {
        StoriesView(stories = stories)
        Divider(color = primaryDark)
        FeedContentView(feeds = feeds)
    }
}