package com.example.weatherforecastapp.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope

//import com.example.weatherforecastapp.database.WheaterDatabase
//import com.example.weatherforecastapp.entities.WheaterEntity
//import com.example.weatherforecastapp.repository.WheaterRepository
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//
//class WheaterViewModel(application: Application): AndroidViewModel(application) {
//
//    private val readAllData: LiveData<List<WheaterEntity>>
//    private val repository: WheaterRepository
//
//    init {
//        val wheaterDao = WheaterDatabase.getDatabase(application).wheaterDao()
//        repository = WheaterRepository(wheaterDao)
//        readAllData = repository.readAllData
//    }
//
//    fun addUser(wheater: WheaterEntity){
//        viewModelScope.launch(Dispatchers.IO) {
//            repository.addUser(wheater)
//        }
//    }
//
//}