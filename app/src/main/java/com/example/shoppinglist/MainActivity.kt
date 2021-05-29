package com.example.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppinglist.data.entity.ListEntity
import com.example.shoppinglist.data.listobject.ListDatabase
import com.example.shoppinglist.databinding.ActivityMainBinding
import com.example.shoppinglist.listdialog.ListCustomDialog
import com.example.shoppinglist.listdialog.ListDialog
import com.example.shoppinglist.repository.ListRepository
import com.example.shoppinglist.viewmodel.ListViewModel
import com.example.shoppinglist.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val database = ListDatabase(this)
        val repository = ListRepository(database)
        val factory = ViewModelFactory(repository)
        val viewModel = ViewModelProvider(this,factory).get(ListViewModel::class.java)
        val adapter = com.example.shoppinglist.listadapter.ListAdapter(listOf(),viewModel)


        binding.rvList.layoutManager = LinearLayoutManager(this)
        binding.rvList.adapter = adapter
        /*binding.rvList.addItemDecoration(
            DividerItemDecoration(
                binding.rvList.context, LinearLayoutManager(this).orientation)
            )*/

        viewModel.showAllItem().observe(this, Observer {

            adapter.list = it
            adapter.notifyDataSetChanged()
        })

        binding.faButton.setOnClickListener {
            ListCustomDialog(this, object : ListDialog {
                override fun addNewItem(item: ListEntity) {
                    viewModel.upsert(item)
                }
            }).show()

        }


    }
}