package com.angelo.codingchallenge

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.angelo.codingchallenge.databinding.ListItemBinding
import com.angelo.codingchallenge.model.Country

class CountryAdapter : RecyclerView.Adapter<CountryViewHolder>() {
    private lateinit var binding: ListItemBinding
    private lateinit var countries: List<Country>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return CountryViewHolder(binding)
    }

    fun updateCountryList(countries: List<Country>) {
        this.countries = countries
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    override fun getItemCount(): Int =
        countries.size
}

class CountryViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(country: Country) {
        binding.countryName.text = country.name
        binding.countryDescription.text = country.description
    }
}