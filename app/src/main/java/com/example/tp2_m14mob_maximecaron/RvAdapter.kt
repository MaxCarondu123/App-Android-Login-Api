package com.example.tp2_m14mob_maximecaron

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RvAdapter(val todos:List<Todo>) : RecyclerView.Adapter<RvAdapter.VH>() {

    inner class VH(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo, parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.itemView.apply {
            findViewById<TextView>(R.id.tvSymbol).text = todos[position].symbol
            findViewById<TextView>(R.id.tvPrice).text = todos[position].lastPrice.toString() + " $"
            findViewById<TextView>(R.id.tvPriceChange).text = todos[position].priceChange.toString() + " $"
            findViewById<TextView>(R.id.tvPriceChangePourcent).text = todos[position].priceChangePercent.toString() + " %"
        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }
}