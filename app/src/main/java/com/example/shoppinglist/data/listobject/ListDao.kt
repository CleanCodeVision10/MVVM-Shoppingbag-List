package com.example.shoppinglist.data.listobject

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.shoppinglist.data.entity.ListEntity

@Dao
interface ListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item : ListEntity)
    @Delete
    suspend fun delete(item: ListEntity)
    @Query("SELECT * from shopping_list")
    fun showAllItem() : LiveData<List<ListEntity>>
}