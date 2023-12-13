package de.p72b.coincollection.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        CoinEntity::class
    ],
    version = 1
)
abstract class CoinDatabase : RoomDatabase() {
    abstract fun coinDao(): CoinDao

    companion object {
        lateinit var database: CoinDatabase
            private set

        fun provide(context: Context) {
            database = Room.databaseBuilder(context, CoinDatabase::class.java, "coinCollection.db")
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}