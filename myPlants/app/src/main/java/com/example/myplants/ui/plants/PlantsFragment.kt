package com.example.myplants.ui.plants

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myplants.R
import com.example.myplants.data.model.PlantModel
import com.example.myplants.databinding.FragmentHomeBinding
import com.example.myplants.databinding.FragmentPlantsBinding
import com.example.myplants.ui.plants.recyclerview.PlantRecyclerViewAdapter
import com.example.myplants.ui.plants.viewmodel.PlantsViewModel

class PlantsFragment : Fragment() {

    private lateinit var bindingplant: FragmentPlantsBinding
    private lateinit var adapter: PlantRecyclerViewAdapter
    private val plantViewModel: PlantsViewModel by activityViewModels{
        PlantsViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingplant = DataBindingUtil.inflate(inflater,R.layout.fragment_plants,container,false)
        return bindingplant.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView(view)
        bindingplant.homeButtonNavbar.setOnClickListener(){
            it.findNavController().navigate(R.id.action_plantsFragment_to_homeFragment)
        }
        bindingplant.userButtonNavbar.setOnClickListener(){
            it.findNavController().navigate(R.id.action_plantsFragment_to_userFragment)
        }
    }
    //llenando datos en el recycler
    private fun setRecyclerView(view:View){
        bindingplant.plantsRecyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = PlantRecyclerViewAdapter { selectedFood -> showSelectedItem(selectedFood) }
        bindingplant.plantsRecyclerView.adapter = adapter
        displayPlant()//mostrando los card
    }
    private fun showSelectedItem(plant: PlantModel){
        plantViewModel.setSelectedPlant(plant)
        findNavController().navigate(R.id.action_plantsFragment_to_plantDetailFragment)
    }

    private fun displayPlant(){
        adapter.setData(plantViewModel.getFood())
        adapter.notifyDataSetChanged()//notifica si hay un cambio
    }
    companion object {

    }
}