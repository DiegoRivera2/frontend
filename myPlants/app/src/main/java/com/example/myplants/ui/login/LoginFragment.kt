package com.example.myplants.ui.login

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.myplants.DigitalApplication
import com.example.myplants.R
import com.example.myplants.databinding.FragmentLoginBinding
import com.example.myplants.network.digitalapi.DigitaltInstance
import com.example.myplants.repository.CredentialsRepository
import com.example.myplants.ui.login.viewmodel.LoginViewModel
import java.util.zip.Inflater

class LoginFragment : Fragment() {

    private val loginViewModel: LoginViewModel by activityViewModels {
        LoginViewModel.Factory
    }

    private lateinit var bindingLogin: FragmentLoginBinding

    val app by lazy {
        requireActivity().application as DigitalApplication
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingLogin = FragmentLoginBinding.inflate(inflater,container,false)
        return bindingLogin.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        observeStatus()


        bindingLogin.newCountButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }


    private fun setViewModel() {
        bindingLogin.viewmodel = loginViewModel
    }

    private fun observeStatus() {
        loginViewModel.status.observe(viewLifecycleOwner) { status ->
            handleUiStatus(status)
        }
    }


    private fun handleUiStatus(status: LoginUiStatus) {
        when(status) {
            is LoginUiStatus.Error -> {
                Toast.makeText(requireContext(), "An error has occurred", Toast.LENGTH_SHORT).show()
            }
            is LoginUiStatus.ErrorWithMessage -> {
                Toast.makeText(requireContext(), status.message, Toast.LENGTH_SHORT).show()
            }
            is LoginUiStatus.Success -> {
                loginViewModel.clearStatus()
                loginViewModel.clearData()
                app.saveAuthToken(status.token)
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
            }

            else -> {}
        }
    }
}