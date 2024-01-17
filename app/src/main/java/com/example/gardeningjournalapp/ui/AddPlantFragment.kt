package com.example.gardeningjournalapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gardeningjournalapp.R
import com.example.gardeningjournalapp.databinding.FragmentAddPlantBinding
import com.example.gardeningjournalapp.databinding.FragmentGardenLogBinding
import com.example.gardeningjournalapp.databinding.FragmentPlanDetailsBinding
import com.example.gardeningjournalapp.db.Plant
import com.example.gardeningjournalapp.db.PlantDatabase
import kotlinx.coroutines.launch


class AddPlantFragment: BaseFragment(){
    private lateinit var binding:FragmentAddPlantBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_add_plant,container,false)
        binding= FragmentAddPlantBinding.bind(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.saveBtn.setOnClickListener {

            val name= binding.name.text.toString()

            if(name.isEmpty()){
                binding.name.error="Name required"
                binding.name.requestFocus()
                return@setOnClickListener
            }
            val type = binding.type.text.toString()
            if(type.isEmpty()){
                binding.type.error="Type required"
                binding.type.requestFocus()
                return@setOnClickListener
            }
            val waterFreq = binding.freq.text.toString()
            if(waterFreq.isEmpty()){
                binding.freq.error="Water Frequency required"
                binding.freq.requestFocus()
                return@setOnClickListener
            }
            val planningDate = binding.planDate.text.toString()

            if(planningDate.isEmpty()){
                binding.planDate.error="Plan Date required"
                binding.planDate.requestFocus()
                return@setOnClickListener
            }
        launch {
            context?.let {
                val plant = Plant(name,type,waterFreq,planningDate)
                PlantDatabase(it).getPlantDAO().addPlant(plant)
                it.toast("Plant Added")
                findNavController().navigate(R.id.action_addPlantFragment_to_gardenLogFragment)
            }
        }
        }


    }

}
