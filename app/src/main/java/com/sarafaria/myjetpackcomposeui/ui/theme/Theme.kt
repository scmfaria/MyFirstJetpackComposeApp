package com.sarafaria.myjetpackcomposeui.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sarafaria.myjetpackcomposeui.R

val primary = Color(0xFFF8F8F8)
val primaryDark = Color(0xFFECECEC)

private val themeColors = lightColors(
    primary = primary,
    onPrimary = Color.Black
)

@Composable
fun MyThemeApp(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = themeColors) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Image(
                            painter = painterResource(id = R.drawable.insta_name),
                            contentDescription = null,
                            modifier = Modifier.width(100.dp).height(40.dp)
                        )
                    },
                    navigationIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.insta_logo),
                            contentDescription = null,
                            modifier = Modifier.width(40.dp).height(40.dp)
                        )
                    },
                )
            }
        ) {
            content()
        }
    }
}