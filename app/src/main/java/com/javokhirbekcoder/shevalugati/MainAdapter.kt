package com.javokhirbekcoder.shevalugati

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.javokhirbekcoder.shevalugati.databinding.RvItemBinding
import java.util.Locale

/*
Created by Javokhirbek on 30/04/2024 at 18:21
*/

class MainAdapter(var list: ArrayList<ItemModel>) :
    RecyclerView.Adapter<MainAdapter.MyViewHolder>(), Filterable {

        private var filteredList: ArrayList<ItemModel> = list

    inner class MyViewHolder(private val binding: RvItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(position: Int) {
            binding.shevaTv.text = list[position].soz
            binding.manosiTv.text = list[position].manosi
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return filteredList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val filteredResults = mutableListOf<ItemModel>()
                val query = constraint.toString().lowercase().trim()

                if (query.isEmpty()) {
                    filteredResults.addAll(list)
                } else {
                    for (item in list) {
                        if (item.soz.lowercase().contains(query)) {
                            filteredResults.add(item)
                        }
                    }
                }

                val filterResults = FilterResults()
                filterResults.values = filteredResults
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredList = results?.values as ArrayList<ItemModel>
                notifyDataSetChanged()
            }
        }
    }
}