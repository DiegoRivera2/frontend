package com.example.myplants.ui.users.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.myplants.data.model.PlantModel
import com.example.myplants.data.model.UserModel
import com.example.myplants.databinding.FragmentItemPlantBinding
import com.example.myplants.databinding.FragmentItemUserBinding

class UserRecyclerViewHolder(private val binding: FragmentItemUserBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(user: UserModel, clickListener: (UserModel) -> Unit) {
        binding.userNameTextView.text = user.name
        binding.userAgeTextView.text = user.age.toString()
        binding.userEmailTextView.text = user.email
        binding.userPositionTextView.text = user.position
    }
}