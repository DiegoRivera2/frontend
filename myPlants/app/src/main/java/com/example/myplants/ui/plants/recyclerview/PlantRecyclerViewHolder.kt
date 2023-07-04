package com.example.myplants.ui.plants.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.myplants.R
import com.example.myplants.data.model.PlantModel
import com.example.myplants.databinding.FragmentItemPlantBinding
import com.squareup.picasso.Picasso

class PlantRecyclerViewHolder (private val binding: FragmentItemPlantBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(plant : PlantModel, clickListener:(PlantModel)->Unit){
        //cargando datos en el card
        binding.namePlantTextView.text = plant.name
        Picasso.get()
            .load(plant.image)
            .error(R.mipmap.ic_launcher)
            .into(binding.plantImageView)
        binding.descriptionFoodTextView.text = plant.description

    }
}