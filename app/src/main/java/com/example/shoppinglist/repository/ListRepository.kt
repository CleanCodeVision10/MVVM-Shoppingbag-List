package com.example.shoppinglist.repository

import com.example.shoppinglist.data.entity.ListEntity
import com.example.shoppinglist.data.listobject.ListDatabase

class ListRepository(
    private val db : ListDatabase
) {
    suspend fun upsert(item : ListEntity) = db.getListDao().upsert(item)
    suspend fun delete(item: ListEntity) = db.getListDao().delete(item)
    fun getAllList() = db.getListDao().showAllItem()
}