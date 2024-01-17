package com.example.gardeningjournalapp.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Plant(
    val name:String,
    val type:String,
    val waterFreq:String,
    val plantingDate:String
):Serializable {
    @PrimaryKey(autoGenerate = true)
    var id:Int =0
}