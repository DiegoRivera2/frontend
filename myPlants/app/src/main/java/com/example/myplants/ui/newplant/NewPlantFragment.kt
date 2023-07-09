package com.example.myplants.ui.newplant

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.myplants.R
import com.example.myplants.databinding.FragmentNewPlantBinding
import com.example.myplants.ui.newplant.viewmodel.NewPlantViewModel
import com.example.myplants.ui.register.RegisterUiStatus


class NewPlantFragment : Fragment() {

    private lateinit var bindingNewPlant: FragmentNewPlantBinding
    private val newPlantViewModel: NewPlantViewModel by activityViewModels {
        NewPlantViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingNewPlant = DataBindingUtil.inflate(inflater,R.layout.fragment_new_plant,container,false)
        return bindingNewPlant.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        observeStatus()


        bindingNewPlant.newCreateButton.setOnClickListener(){
            it.findNavController().navigate(R.id.action_newPlantFragment_to_plantsFragment)
        }
    }

    private fun setViewModel() {
        bindingNewPlant.viewmodel = newPlantViewModel
    }
    private fun observeStatus() {
        newPlantViewModel.status.observe(viewLifecycleOwner) { status ->
            handleUiStatus(status)
        }
    }
    private fun handleUiStatus(status: RegisterUiStatus) {
        when(status) {
            is RegisterUiStatus.Error -> {
                Toast.makeText(requireContext(), "An error has occurred", Toast.LENGTH_SHORT).show()
            }
            is RegisterUiStatus.ErrorWithMessage -> {
                Toast.makeText(requireContext(), status.message, Toast.LENGTH_SHORT).show()
            }
            is RegisterUiStatus.Success -> {
                newPlantViewModel.clearStatus()
                newPlantViewModel.clearData()
                findNavController().navigate(R.id.action_newPlantFragment_to_plantsFragment)
            }

            else -> {}
        }
    }
    companion object {

    }
}