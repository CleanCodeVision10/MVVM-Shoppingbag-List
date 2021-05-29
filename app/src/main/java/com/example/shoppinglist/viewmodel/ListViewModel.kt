package com.example.shoppinglist.viewmodel

import androidx.lifecycle.ViewModel
import com.example.shoppinglist.data.entity.ListEntity
import com.example.shoppinglist.repository.ListRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListViewModel(
    private val repository: ListRepository
) : ViewModel(){
    fun upsert(item : ListEntity) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item: ListEntity) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun showAllItem() = repository.getAllList()
}