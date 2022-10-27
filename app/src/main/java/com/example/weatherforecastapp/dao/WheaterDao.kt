package com.example.weatherforecastapp.dao
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.weatherforecastapp.entities.WheaterEntity

//@Dao
//interface WheaterDao {
//    @Insert(onConflict =  OnConflictStrategy.IGNORE)
//    suspend fun add(wheater: WheaterEntity)
//
//    @Query("SELECT * FROM Wheater")
//    fun getAll(): LiveData<List<WheaterEntity>>
//}