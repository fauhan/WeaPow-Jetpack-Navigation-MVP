package com.inpows.weapow.city.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.inpows.weapow.databinding.ItemCityCardBinding
import com.inpows.weapow.di.GlideApp
import com.inpows.weapow.domain.city.model.CityDomain
import com.inpows.weapow.city.listener.CityRVClickListener


/**
 * @author Fauhan Handay Pugar (fauhan.pugar@dana.id)
 * @version CityAdapter, v 0.1 25/04/22 09.20 by Fauhan Handay Pugar
 */
class CityAdapter(private val cityList: List<CityDomain>): RecyclerView.Adapter<CityAdapter.ViewHolder>() {

    var listener: CityRVClickListener? = null
    inner class ViewHolder(val binding: ItemCityCardBinding)
        :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCityCardBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(cityList[position]){
                binding.cityName.text = name
                binding.cityId.text = id
                GlideApp
                    .with(holder.itemView.context)
                    .load(imageUrl)
                    .into(binding.cityImage)

                holder.itemView.setOnClickListener {
                    listener?.onItemClicked(it, cityList[position].id)
                }
            }
        }
    }

    override fun getItemCount(): Int = cityList.size
}