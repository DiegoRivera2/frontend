package com.example.myplants.ui.nursery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myplants.R
import com.example.myplants.data.model.NurseryModel
import com.example.myplants.data.model.UserModel
import com.example.myplants.databinding.FragmentNurseriesBinding
import com.example.myplants.ui.nursery.recyclerview.NurseryRecyclerAdapter
import com.example.myplants.ui.nursery.viewmodel.NurseryViewModel
import com.example.myplants.ui.users.recyclerview.UserRecyclerAdapter
import com.example.myplants.ui.users.viewmodel.UsersViewModel
import kotlinx.coroutines.launch


class NurseriesFragment : Fragment() {

    private lateinit var bindingNurseryFragment: FragmentNurseriesBinding
    private lateinit var adapter: NurseryRecyclerAdapter
    private val nurseryViewModel : NurseryViewModel by activityViewModels {
        NurseryViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingNurseryFragment = DataBindingUtil.inflate(inflater,R.layout.fragment_nurseries,container,false)
        return bindingNurseryFragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView(view)
        bindingNurseryFragment.homeButtonNavbar.setOnClickListener(){
            it.findNavController().navigate(R.id.action_nurseriesFragment_to_homeFragment)
        }

        bindingNurseryFragment.userButtonNavbar.setOnClickListener(){
            it.findNavController().navigate(R.id.action_nurseriesFragment_to_userFragment)
        }

        bindingNurseryFragment.plantsButtonNavbar.setOnClickListener(){
            it.findNavController().navigate(R.id.action_nurseriesFragment_to_plantsFragment)
        }
    }
    private fun setRecyclerView(view:View){
        bindingNurseryFragment.nurseryRecyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = NurseryRecyclerAdapter { selectedNursery -> showSelectedItem(selectedNursery) }
        bindingNurseryFragment.nurseryRecyclerView.adapter = adapter
        displayNursery()//mostrando los card
    }
    private fun showSelectedItem(nursery: NurseryModel){
        nurseryViewModel.setSelectedUser(nursery)
    }
    private fun displayNursery(){
        lifecycleScope.launch {
            adapter.setData(nurseryViewModel.getNursery())
            adapter.notifyDataSetChanged()//notifica si hay un cambio
        }

    }

}