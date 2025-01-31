package com.example.proyectoequipo3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.proyectoequipo3.databinding.FragmentRegisterBinding
import androidx.fragment.app.viewModels // Importante para usar el delegado viewModels()
import androidx.navigation.fragment.findNavController
import com.example.proyectoequipo3.viewmodel.RegisterViewModel // Importa el ViewModel de la ubicación correcta
import com.example.proyectoequipo3.viewmodel.loginViewModel


class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<RegisterViewModel>()
    lateinit var  communicator: FragmentCommunicator


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        setupview()
        communicator=requireActivity() as FragmentCommunicator
        setupobservers()
        return binding.root
    }

    private fun setupobservers() {
        viewModel.isLoading.observe(viewLifecycleOwner){
            communicator.manageLoader(it)

        }
        viewModel.registerResult.observe(viewLifecycleOwner){
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    private fun setupview() {
        binding.registerButton.setOnClickListener{
            viewModel.registerUser(binding.registerEmail.text.toString(), binding.registerPassword.text.toString())
        }
    }


}
