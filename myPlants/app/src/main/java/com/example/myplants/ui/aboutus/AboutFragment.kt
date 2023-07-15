package com.example.myplants.ui.aboutus

import android.database.DatabaseUtils
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.myplants.R
import com.example.myplants.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {

    private lateinit var bindingAboutFragment: FragmentAboutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingAboutFragment = DataBindingUtil.inflate(inflater,R.layout.fragment_about,container,false)
        return bindingAboutFragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindingAboutFragment.homeButtonNavbar.setOnClickListener(){
            it.findNavController().navigate(R.id.action_aboutFragment_to_homeFragment)
        }

        bindingAboutFragment.userButtonNavbar.setOnClickListener(){
            it.findNavController().navigate(R.id.action_aboutFragment_to_userFragment)
        }

        bindingAboutFragment.plantsButtonNavbar.setOnClickListener(){
            it.findNavController().navigate(R.id.action_aboutFragment_to_plantsFragment)
        }
    }

}