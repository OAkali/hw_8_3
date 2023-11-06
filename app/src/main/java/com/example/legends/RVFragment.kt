package com.example.legends

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.legends.databinding.FragmentRVBinding

class RVFragment : Fragment() {
    private lateinit var binding:FragmentRVBinding
    private var iconsList= arrayListOf(
IconsL("https://upload.wikimedia.org/wikipedia/commons/thumb/9/9f/Beatles_ad_1965_just_the_beatles_crop.jpg/1280px-Beatles_ad_1965_just_the_beatles_crop.jpg","Dead","The Beatles"),
        IconsL("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d5/Bob_Dylan_-_Azkena_Rock_Festival_2010_1.jpg/800px-Bob_Dylan_-_Azkena_Rock_Festival_2010_1.jpg","Alive","Боб Ди́лан "),
        IconsL("https://upload.wikimedia.org/wikipedia/commons/thumb/9/99/Elvis_Presley_promoting_Jailhouse_Rock.jpg/800px-Elvis_Presley_promoting_Jailhouse_Rock.jpg","Dead","Э́лвис Аро́н "),
        IconsL("https://upload.wikimedia.org/wikipedia/commons/thumb/1/17/Mick_Jagger_and_Ron_Wood_-_Rolling_Stones_-_1975.jpg/800px-Mick_Jagger_and_Ron_Wood_-_Rolling_Stones_-_1975.jpg","Dead","The Rolling Stones"),
        IconsL("https://upload.wikimedia.org/wikipedia/commons/thumb/8/81/Stevie_Wonder.jpg/375px-Stevie_Wonder.jpg","Alive","Сти́ви Уа́ндер "),
        IconsL("https://upload.wikimedia.org/wikipedia/ru/thumb/5/55/PinkFloyd-album-saucerfulofsecrets.jpg/1024px-PinkFloyd-album-saucerfulofsecrets.jpg","Dead","Pink Floyd"),

    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentRVBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()

    }

    private fun initAdapter() {
        val adapter = AdapterLegends(iconsList,this::onClick)
        binding.recyclerV.adapter = adapter
    }
    private fun onClick(icon: IconsL){
        findNavController().navigate(R.id.secondFragment, bundleOf("key1" to icon.photo,"key2" to icon.live,"key3" to icon.name))
    }


}