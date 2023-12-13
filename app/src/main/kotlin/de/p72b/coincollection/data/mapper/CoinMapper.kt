package de.p72b.coincollection.data.mapper

import de.p72b.coincollection.data.Coin
import de.p72b.coincollection.data.room.CoinEntity

class CoinMapper : Mapper<CoinEntity, Coin> {
    override fun map(input: CoinEntity): Coin =
        Coin(
            name = input.name
        )
}