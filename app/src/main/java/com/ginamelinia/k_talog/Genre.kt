package com.ginamelinia.k_talog

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Genre(
    val name: String,
    val dramaList: List<String>
) : Parcelable

