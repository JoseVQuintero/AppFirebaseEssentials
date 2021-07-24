package com.danisable.appfirebaseessentials.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.danisable.appfirebaseessentials.data.local.dao.UsersDao
import com.danisable.appfirebaseessentials.data.local.entity.UsersEntity

@Database(entities = [UsersEntity::class], version = 1, exportSchema = false)
abstract class PersistenceDatabase: RoomDatabase() {
    abstract fun usersDao(): UsersDao

    companion object{
        @Volatile
        private var instance: PersistenceDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context:Context) =
            Room.databaseBuilder(context, PersistenceDatabase::class.java, "App-01")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
    }

}