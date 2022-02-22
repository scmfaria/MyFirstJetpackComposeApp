package com.sarafaria.myjetpackcomposeui.form.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AddUser(
    val name: String = "",
    val email: String = ""
) : Parcelable
