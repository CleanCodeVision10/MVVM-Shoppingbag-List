package com.example.shoppinglist.listdialog

import com.example.shoppinglist.data.entity.ListEntity

interface ListDialog {
    fun addNewItem(item : ListEntity)
}