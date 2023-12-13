package de.p72b.coincollection.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CoinDao {
    @Query("SELECT * FROM coinEntity")
    fun getAll(): List<CoinEntity>

    @Query("SELECT * FROM coinEntity WHERE uid IN (:coinIds)")
    fun loadAllByIds(coinIds: IntArray): List<CoinEntity>

    @Query("SELECT * FROM coinEntity WHERE name LIKE :name LIMIT 1")
    fun findByName(name: String): CoinEntity

    @Insert
    fun insertAll(vararg coins: CoinEntity)

    @Delete
    fun delete(coin: CoinEntity)
}