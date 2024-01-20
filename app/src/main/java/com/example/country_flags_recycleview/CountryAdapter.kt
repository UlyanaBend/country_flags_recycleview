package com.example.country_flags_recycleview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.country_flags_recycleview.databinding.CountryItemBinding

class CountryAdapter: ListAdapter<Country, CountryAdapter.Holder>(Comparator()) {

    class Holder (item: View) : RecyclerView.ViewHolder (item) {
        private val binding  = CountryItemBinding.bind(item)
        fun bind (country: Country) = with(binding) {
            nameCountry.text = country.name
            Glide.with(root.context)
                .load(country.imageURl)
                .into(flagCountry)
        }
    }

    class Comparator : DiffUtil.ItemCallback<Country> (){
        override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem.name == newItem.name
        }
        override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.country_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }
}