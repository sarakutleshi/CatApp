package com.example.catapp.fragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.catapp.databinding.FragmentDetailsBinding
import com.example.catapp.models.CatImage
import com.squareup.picasso.Picasso

class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private val args: DetailsFragmentArgs by navArgs() // Use Safe Args

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Retrieve the CatImage object using Safe Args
        val catImage: CatImage = args.catImage

        // Display the cat image using Picasso
        Picasso.get().load(catImage.url).into(binding.catImage)

        // Display additional details
        binding.catDetails.text = """
            ID: ${catImage.id}
            Width: ${catImage.width}
            Height: ${catImage.height}
        """.trimIndent()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}