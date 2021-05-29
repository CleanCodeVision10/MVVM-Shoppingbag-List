package com.example.shoppinglist.data.listobject

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.shoppinglist.data.entity.ListEntity

@Database(
    entities = [ListEntity::class],
    version = 1
)
abstract class ListDatabase : RoomDatabase() {
    abstract fun getListDao() : ListDao

    companion object{
        @Volatile
        var instance : ListDatabase? = null
       private val LOCK = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context)=
            Room.databaseBuilder(context.applicationContext,ListDatabase::class.java,
            "Custom_list-db").build()
    }

}