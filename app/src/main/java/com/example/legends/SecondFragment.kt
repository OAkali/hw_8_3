package com.example.legends

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.legends.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLister()
    }

    private fun initLister() {
        val args = arguments
        if (args != null) {
            val photoPath = args.getString("key1")

            if (!photoPath.isNullOrEmpty()) {

                val imageView = binding.ivPhoto
                Glide.with(this).load(photoPath)
                    .into(imageView)
            }
            binding.tvLive.text = arguments?.getString("key2")
            binding.tvName.text = arguments?.getString("key3")
        }

    }
}