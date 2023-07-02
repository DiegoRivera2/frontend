package com.example.myplants.ui.register

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
import com.example.myplants.databinding.FragmentRegisterBinding
import com.example.myplants.ui.register.viewmodel.RegisterViewModel


class RegisterFragment : Fragment() {

    private lateinit var bindingRegister: FragmentRegisterBinding

    private val registerViewModel: RegisterViewModel by activityViewModels {
        RegisterViewModel.Factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingRegister = DataBindingUtil.inflate(inflater, R.layout.fragment_register,container,false)
        return bindingRegister.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        observeStatus()

        bindingRegister.newCreateButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }
    private fun setViewModel() {
        bindingRegister.viewmodel = registerViewModel
    }
    private fun observeStatus() {
        registerViewModel.status.observe(viewLifecycleOwner) { status ->
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
                registerViewModel.clearStatus()
                registerViewModel.clearData()
                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
            }

            else -> {}
        }
    }


}