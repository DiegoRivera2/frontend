package com.example.myplants.ui.users_navbar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.myplants.R
import com.example.myplants.databinding.FragmentUserBinding


class UserFragment : Fragment() {

    private lateinit var bindinguser : FragmentUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindinguser = DataBindingUtil.inflate(inflater,R.layout.fragment_user,container,false)
        return bindinguser.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindinguser.userButton.setOnClickListener(){
            it.findNavController().navigate(R.id.action_userFragment_to_usersFragment)
        }
        bindinguser.homeButtonNavbar.setOnClickListener(){
            it.findNavController().navigate(R.id.action_userFragment_to_homeFragment)
        }
        bindinguser.plantsButtonNavbar.setOnClickListener(){
            it.findNavController().navigate(R.id.action_userFragment_to_plantsFragment)
        }
    }

    companion object {

    }
}