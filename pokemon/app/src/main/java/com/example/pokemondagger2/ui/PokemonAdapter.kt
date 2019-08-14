package com.example.pokemondagger2.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemondagger2.data.Pokemon

class PokemonAdapter: RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    private var items: List<Pokemon> = emptyList()

    fun setItems(newItems: List<Pokemon>) {
        this.items = newItems.sortedBy { it.name }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(android.R.layout.simple_list_item_1, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text.text = items[position].name
    }

    override fun getItemCount() = items.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val text = itemView as TextView
    }
}

