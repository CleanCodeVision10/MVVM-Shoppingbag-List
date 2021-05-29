package com.example.shoppinglist.listdialog

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.shoppinglist.data.entity.ListEntity
import com.example.shoppinglist.databinding.CustomDialogBinding

class ListCustomDialog (context: Context , val dialog: ListDialog) : AppCompatDialog(context){
    private lateinit var binding: CustomDialogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CustomDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnOk.setOnClickListener{
            val name = binding.etItem.text.toString().trim()
            val amount = binding.etAmount.text.toString().trim()
            if(name.isEmpty() || amount.isEmpty()){
                Toast.makeText(context,"please enter all the fields",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val item = ListEntity(name,amount.toInt())
            dialog.addNewItem(item)
            dismiss()
        }
        binding.btnCancel.setOnClickListener{
            cancel()
        }
    }
}