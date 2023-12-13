package de.p72b.coincollection.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CoinEntity(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "name") val name: String?
)