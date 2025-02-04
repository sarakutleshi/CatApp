package com.example.catapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.catapp.databinding.FragmentHomeBinding
import com.example.catapp.models.CatImage

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val catImage = CatImage(
            id = "abc123",
            url = "https://i.pinimg.com/736x/fc/59/f5/fc59f5945ba4d316ddf4128bcb5db3ac.jpg",
            width = 500,
            height = 400
        )

        binding.button.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeToDetails(catImage)
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}