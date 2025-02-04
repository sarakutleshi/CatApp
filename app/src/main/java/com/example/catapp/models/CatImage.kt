package com.example.catapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CatImage(
    val id: String,
    val url: String,
    val width: Int,
    val height: Int
) : Parcelable