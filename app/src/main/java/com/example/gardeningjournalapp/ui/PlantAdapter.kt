package com.example.gardeningjournalapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.gardeningjournalapp.databinding.PlantLayoutBinding
import com.example.gardeningjournalapp.db.Plant
import com.example.gardeningjournalapp.R

class PlantAdapter(private val plants:List<Plant>):RecyclerView.Adapter<PlantAdapter.PlantViewHolder>() {

    private lateinit var binding:PlantLayoutBinding
    inner class PlantViewHolder(val view:View):RecyclerView.ViewHolder(view){
        fun bind(plant:Plant){
            binding.plantTitle.text=plant.name
            binding.plantType.text=plant.type
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.plant_layout,parent,false)
        binding=PlantLayoutBinding.bind(view)
        return PlantViewHolder(view)
    }

    override fun getItemCount()= plants.size

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
         holder.bind(plants[position])
         holder.view.setOnClickListener{
             val action = GardenLogFragmentDirections.actionGardenLogFragmentToPlanDetailsFragment(plants[position])
             Navigation.findNavController(it).navigate(action)

         }

    }
}