package com.b5eg.sergburlaka.keyboard

import android.databinding.BaseObservable
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.b5eg.sergburlaka.keyboard.databinding.AnimalListItemBinding


data class Animal(
        var nameAnimal: String
) : BaseObservable()
class AnimalAdapter(private val items: ArrayList<Animal>) : RecyclerView.Adapter<AnimalAdapter.Companion.ViewHolder>() {

    companion object {
        class ViewHolder(val binding: AnimalListItemBinding) : RecyclerView.ViewHolder(binding.root)
    }

    private var layoutInflater: LayoutInflater? = null

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.context)
        }
        return ViewHolder(DataBindingUtil.inflate(layoutInflater!!, R.layout.animal_list_item, parent, false))

    }

    // Binds each animal in the ArrayList to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        items[position].apply {
            holder.binding.animal = this
        }

    }
}

