package com.example.weatherforecastapp.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson

import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


@Entity(tableName = "Wheater")
data class WheaterEntity (
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo(name = "city") var city: String,
    @ColumnInfo(name = "date") var date: String,
    @ColumnInfo(name = "description") var description: String,
    @ColumnInfo(name = "temp") var temp: String,
    @ColumnInfo(name = "time") var time: String,
)

@Entity
data class ForecastEntity (
    var date: String,
    var weekday: String,
    var max: String,
    var min: String,
)

object Converters {
    @TypeConverter
    fun fromString(value: String?): ArrayList<String> {
        val listType: Type = object : TypeToken<ArrayList<String?>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: ArrayList<String?>?): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}