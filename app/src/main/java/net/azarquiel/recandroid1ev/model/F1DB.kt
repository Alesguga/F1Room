package net.azarquiel.recandroid1ev.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Driver::class,Team::class], version = 1)
abstract class F1DB: RoomDatabase() {
    abstract fun driverDao():DriverDao
    abstract fun teamDao():TeamDao

    companion object {
        // Singleton prevents multiple instances of database opening at the same time.
        @Volatile
        private var INSTANCE:  F1DB? = null

        fun getDatabase(context: Context): F1DB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    F1DB::class.java,   "f1.sqlite"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
