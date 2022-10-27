package com.example.weatherforecastapp.database

//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import com.example.weatherforecastapp.dao.WheaterDao
//import com.example.weatherforecastapp.entities.WheaterEntity
//
//@Database(entities = [WheaterEntity::class], version = 1, exportSchema = false)
//abstract class WheaterDatabase : RoomDatabase() {
//
//    abstract fun wheaterDao(): WheaterDao
//
//    companion object {
//        @Volatile
//        private var INSTANCE: WheaterDatabase? = null
//
//        fun getDatabase(context: Context): WheaterDatabase{
//            val tempInstance = INSTANCE
//            if(tempInstance != null){
//                return tempInstance
//            }
//            synchronized(this){
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    WheaterDatabase::class.java,
//                    "user_database"
//                ).build()
//                INSTANCE = instance
//                return instance
//            }
//        }
//    }
//
//}