package com.sarafaria.myjetpackcomposeui.form

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import com.sarafaria.myjetpackcomposeui.R
import com.sarafaria.myjetpackcomposeui.form.model.AddUser
import kotlinx.coroutines.launch

class FormActivity : ComponentActivity() {

    private val addUserState = MutableLiveData(AddUser())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FormContent()
        }
    }

    @Composable
    private fun FormContent() {
        Scaffold(
            topBar = { FormTopBar() }
        ) {
            FormField()
        }

    }

    @Composable
    private fun FormTopBar() {
        TopAppBar(
            title = { Text(text = stringResource(id = R.string.form_title)) },
            navigationIcon = {
                IconButton(onClick = { onBackPressed() }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null) }
            },
            contentColor = Color.White,
            backgroundColor = colorResource(id = R.color.purple_500)
        )
    }

    @Composable
    private fun FormField() {
        val nameState = remember { mutableStateOf("") }
        val emailState = remember { mutableStateOf("") }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {

            OutlinedTextField(
                modifier = Modifier.padding(top = 20.dp),
                value = nameState.value,
                onValueChange = {
                    nameState.value = it
                    addUserState.value = addUserState.value?.copy(name = it)
                },
                label = { Text(text = stringResource(id = R.string.form_label_name))}
            )

            OutlinedTextField(
                modifier = Modifier.padding(top = 15.dp),
                value = emailState.value,
                onValueChange = {
                    emailState.value = it
                    addUserState.value = addUserState.value?.copy(email = it)
                },
                label = { Text(text = stringResource(id = R.string.form_label_email))}
            )
        }

        Row(verticalAlignment = Alignment.Bottom,
            modifier = Modifier.fillMaxHeight()) {
            Button(
                onClick = { addUser() },
                modifier = Modifier
                    .padding(10.dp)
                    .border(border = BorderStroke(5.dp, Color.Transparent), shape = RectangleShape)
                    .fillMaxWidth()) {
                Text(
                    text = stringResource(id = R.string.button_save),
                    style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
                )
            }
        }

    }

    private fun addUser() {
        val userState = addUserState.value ?: return

        if(userState.name.isNotEmpty() &&
                userState.email.isNotEmpty()) {
            lifecycleScope.launch {
                setResult(RESULT_OK, Intent().apply {
                    putExtra("user_state", userState)
                })
            }
            finish()
        }
    }
}