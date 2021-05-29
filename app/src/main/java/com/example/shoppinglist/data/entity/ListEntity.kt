package com.example.shoppinglist.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_list")
data class ListEntity(
    @ColumnInfo
    var name : String,
    @ColumnInfo
    var amount : Int
) {
    @PrimaryKey(autoGenerate = true)
    var a : Int? = null
}