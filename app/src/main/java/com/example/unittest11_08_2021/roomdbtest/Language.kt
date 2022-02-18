package com.example.unittest11_08_2021.roomdbtest

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "language")
data class Language(
    val languageName : String="",
    val experience : String=""
) {
    @PrimaryKey(autoGenerate = true)
    var id : Long=0
}
