package com.example.myplants.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.myplants.R
import com.example.myplants.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var bindinghome: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindinghome = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        return bindinghome.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindinghome.plantsButtonNavbar.setOnClickListener(){
            it.findNavController().navigate(R.id.action_homeFragment_to_plantsFragment)
        }
        bindinghome.userButtonNavbar.setOnClickListener(){
            it.findNavController().navigate(R.id.action_homeFragment_to_userFragment)
        }
    }

    companion object {
    }
}