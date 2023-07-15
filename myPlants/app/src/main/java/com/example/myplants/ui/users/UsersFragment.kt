package com.example.myplants.ui.users

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myplants.R
import com.example.myplants.data.model.PlantModel
import com.example.myplants.data.model.UserModel
import com.example.myplants.databinding.FragmentPlantsBinding
import com.example.myplants.databinding.FragmentUsersBinding
import com.example.myplants.ui.plants.recyclerview.PlantRecyclerViewAdapter
import com.example.myplants.ui.users.recyclerview.UserRecyclerAdapter
import com.example.myplants.ui.users.viewmodel.UsersViewModel
import kotlinx.coroutines.launch


class UsersFragment : Fragment() {

    private lateinit var bindingUsersFragment: FragmentUsersBinding
    private lateinit var adapter: UserRecyclerAdapter
    private val userViewModel : UsersViewModel by activityViewModels {
        UsersViewModel.Factory
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingUsersFragment = DataBindingUtil.inflate(inflater,R.layout.fragment_users,container,false)
        return bindingUsersFragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView(view)
        bindingUsersFragment.homeButtonNavbar.setOnClickListener(){
            it.findNavController().navigate(R.id.action_usersFragment_to_homeFragment)
        }
        /*
        bindingUsersFragment.userButtonNavbar.setOnClickListener(){
            it.findNavController().navigate(R.id.action_usersFragment_to_userFragment)
        }
        */

        bindingUsersFragment.plantsButtonNavbar.setOnClickListener(){
            it.findNavController().navigate(R.id.action_usersFragment_to_plantsFragment)
        }
    }
    private fun setRecyclerView(view:View){
        bindingUsersFragment.usersRecyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = UserRecyclerAdapter { selectedUser -> showSelectedItem(selectedUser) }
        bindingUsersFragment.usersRecyclerView.adapter = adapter
        displayUsers()//mostrando los card
    }
    private fun showSelectedItem(user: UserModel){
        userViewModel.setSelectedUser(user)

    }
    private fun displayUsers(){
        lifecycleScope.launch {
            adapter.setData(userViewModel.getUser())
            adapter.notifyDataSetChanged()//notifica si hay un cambio
        }

    }

}