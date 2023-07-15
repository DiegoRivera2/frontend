package com.example.myplants.ui.nursery.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.myplants.data.model.NurseryModel
import com.example.myplants.data.model.UserModel
import com.example.myplants.databinding.FragmentItemNurseryBinding
import com.example.myplants.databinding.FragmentItemUserBinding

class NurseryRecyclerViewHolder (private val binding: FragmentItemNurseryBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(nursery: NurseryModel, clickListener: (NurseryModel) -> Unit) {
        binding.nurseryNameTextView.text = nursery.name
        binding.nurseryUbicationTextView.text = nursery.ubucation
        binding.nurseryVideoTextView.text = nursery.video
        binding.nurseryDescriptionTextView.text = nursery.description
    }
}