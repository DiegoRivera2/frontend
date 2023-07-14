package com.example.myplants.ui.users.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myplants.data.model.PlantModel
import com.example.myplants.data.model.UserModel
import com.example.myplants.databinding.FragmentItemPlantBinding
import com.example.myplants.databinding.FragmentItemUserBinding
import com.example.myplants.ui.plants.recyclerview.PlantRecyclerViewHolder

class UserRecyclerAdapter (private val clickListener: (UserModel)->Unit): RecyclerView.Adapter<UserRecyclerViewHolder>() {
    private val users = ArrayList<UserModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserRecyclerViewHolder {
        val binding = FragmentItemUserBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UserRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UserRecyclerViewHolder, position: Int) {
        val user = users[position]
        holder.bind(user,clickListener)
    }
    fun setData(userList: List<UserModel>){
        users.clear()
        users.addAll(userList)
    }
}