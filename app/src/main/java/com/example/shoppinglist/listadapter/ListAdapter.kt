package com.example.shoppinglist.listadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.data.entity.ListEntity
import com.example.shoppinglist.databinding.CustomListBinding
import com.example.shoppinglist.viewmodel.ListViewModel

class ListAdapter( var list : List<ListEntity>,
    private val viewModel : ListViewModel ) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    inner class ViewHolder(val binding : CustomListBinding ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent.context)
    val viewBinding = CustomListBinding.inflate(view,parent,false)
    return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentPosition = list[position]
        holder.binding.tvName.text = currentPosition.name
        holder.binding.tvAmount.text = currentPosition.amount.toString()
        holder.binding.ivMinus.setOnClickListener {
            if(currentPosition.amount > 0){
                currentPosition.amount--
                viewModel.upsert(currentPosition)
            }
        }
        holder.binding.ivPlus.setOnClickListener {
            currentPosition.amount++
            viewModel.upsert(currentPosition)

        }
        holder.binding.ivDelete.setOnClickListener {
            viewModel.delete(currentPosition)
        }
    }

    override fun getItemCount(): Int {
        return  list.size
    }

}