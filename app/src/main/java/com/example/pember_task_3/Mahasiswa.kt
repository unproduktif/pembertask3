package com.example.pember_task_3

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Mahasiswa(
    val nama: String,
    val nim: String,
    val prodi: String,
    val gender: String,
    val hobi: String
) : Parcelable