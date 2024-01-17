package com.example.gardeningjournalapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gardeningjournalapp.R
import com.example.gardeningjournalapp.databinding.FragmentGardenLogBinding
import com.example.gardeningjournalapp.db.PlantDatabase
import kotlinx.coroutines.launch


class GardenLogFragment: BaseFragment(){
    private lateinit var binding:FragmentGardenLogBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_garden_log,container,false)
        binding= FragmentGardenLogBinding.bind(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager= LinearLayoutManager(context)
        launch {
            context?.let {
                val plants = PlantDatabase(it).getPlantDAO().getAllPlants()
                val plantAdapter= PlantAdapter(plants)
                binding.recyclerView.adapter= plantAdapter
            }
        }

        binding.addPlantBtn.setOnClickListener{
            findNavController().navigate(R.id.action_gardenLogFragment_to_addPlantFragment)
        }


    }

}
