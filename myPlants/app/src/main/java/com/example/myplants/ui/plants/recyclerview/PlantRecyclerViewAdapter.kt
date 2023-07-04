package com.example.myplants.ui.plants.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myplants.R
import com.example.myplants.data.model.PlantModel
import com.example.myplants.databinding.FragmentItemPlantBinding


class PlantRecyclerViewAdapter(private val clickListener: (PlantModel)->Unit):RecyclerView.Adapter<PlantRecyclerViewHolder>() {
    private val plants = ArrayList<PlantModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantRecyclerViewHolder {
        val binding = FragmentItemPlantBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PlantRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return plants.size
    }

    override fun onBindViewHolder(holder: PlantRecyclerViewHolder, position: Int) {
        val plant = plants[position]
        holder.bind(plant,clickListener)
    }
    fun setData(plantList: List<PlantModel>){
        plants.clear()
        plants.addAll(plantList)
    }
}