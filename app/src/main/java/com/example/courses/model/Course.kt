package com.example.courses.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Course(
    @StringRes val courseNameId:Int,
    val quantity:Int,
    @DrawableRes val imageResourceId:Int,
)
