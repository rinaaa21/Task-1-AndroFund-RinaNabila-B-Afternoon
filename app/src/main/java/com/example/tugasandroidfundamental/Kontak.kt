package com.example.tugasandroidfundamental

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Kontak(
    val nama:String,
    val notelp:String
):Parcelable
