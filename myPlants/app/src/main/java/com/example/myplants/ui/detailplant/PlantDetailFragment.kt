package com.example.myplants.ui.detailplant

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.example.myplants.R
import com.example.myplants.databinding.FragmentPlantDetailBinding
import com.example.myplants.ui.plants.viewmodel.PlantsViewModel
import com.squareup.picasso.Picasso


class PlantDetailFragment : Fragment() {

    private lateinit var bindingDetailPlant : FragmentPlantDetailBinding
    private val viewModel : PlantsViewModel by activityViewModels {
        PlantsViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingDetailPlant = DataBindingUtil.inflate(inflater,R.layout.fragment_plant_detail,container,false)
        return bindingDetailPlant.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindingDetailPlant.viewmodel = viewModel

        Picasso.get()
            .load(viewModel.image.value)
            .error(R.drawable.girasol)
            .into(bindingDetailPlant.plantImageView)
    }

}