package com.example.gardeningjournalapp.ui

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gardeningjournalapp.R
import com.example.gardeningjournalapp.databinding.FragmentGardenLogBinding
import com.example.gardeningjournalapp.databinding.FragmentPlanDetailsBinding
import com.example.gardeningjournalapp.db.Plant
import com.example.gardeningjournalapp.db.PlantDatabase
import kotlinx.coroutines.launch


class PlanDetailsFragment: BaseFragment(){
    private lateinit var binding:FragmentPlanDetailsBinding
    private val navArgs:PlanDetailsFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_plan_details,container,false)
        binding= FragmentPlanDetailsBinding.bind(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val plant = navArgs.plant

        binding.plantName.text = plant.name
        binding.plantType.text = plant.type
        binding.waterFreq.text = plant.waterFreq
        binding.plantingDate.text = plant.plantingDate

        binding.delBtn.setOnClickListener {
            AlertDialog.Builder(context).apply {
                setTitle("Delete Plant")
                setMessage("Are you sure you want to delete this plant?")
                setPositiveButton("Yes") {_,_ ->
                    launch {
                        context?.let {
                            PlantDatabase(it).getPlantDAO().deletePlant(plant)
                            it.toast("Plant Deleted")
                            findNavController().navigate(R.id.action_planDetailsFragment_to_gardenLogFragment)
                        }
                    }
                }
                setNegativeButton("No") {_,_ ->{}}
            }.create().show()

        }

    }

}
