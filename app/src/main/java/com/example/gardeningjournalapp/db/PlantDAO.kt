package com.example.gardeningjournalapp.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface PlantDAO {
    @Insert
    suspend fun addPlant(plant: Plant)

    @Query("SELECT * FROM PLANT ORDER BY ID DESC")
    suspend fun getAllPlants():List<Plant>

    @Query("SELECT * FROM PLANT WHERE id=:id")
    suspend fun getOnePlant(id:Int):Plant

    @Update
    suspend fun updatePlant(plant:Plant)
    @Delete
    suspend fun deletePlant(plant:Plant)



}