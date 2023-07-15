package com.example.myplants.ui.nursery.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myplants.data.model.NurseryModel
import com.example.myplants.data.model.UserModel
import com.example.myplants.databinding.FragmentItemNurseryBinding
import com.example.myplants.databinding.FragmentItemUserBinding
import com.example.myplants.ui.users.recyclerview.UserRecyclerViewHolder

class NurseryRecyclerAdapter (private val clickListener: (NurseryModel)->Unit): RecyclerView.Adapter<NurseryRecyclerViewHolder>() {
    private val nurseries = ArrayList<NurseryModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NurseryRecyclerViewHolder {
        val binding = FragmentItemNurseryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NurseryRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return nurseries.size
    }

    override fun onBindViewHolder(holder: NurseryRecyclerViewHolder, position: Int) {
        val nursery = nurseries[position]
        holder.bind(nursery,clickListener)
    }
    fun setData(nurseryList: List<NurseryModel>){
        nurseries.clear()
        nurseries.addAll(nurseryList)
    }
}