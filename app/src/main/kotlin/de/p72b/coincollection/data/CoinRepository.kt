package de.p72b.coincollection.data

import de.p72b.coincollection.data.mapper.CoinMapper
import de.p72b.coincollection.data.room.CoinDatabase
import de.p72b.coincollection.data.room.CoinEntity
import de.p72b.coincollection.data.util.Resource
import de.p72b.coincollection.data.util.Status
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CoinRepository(
    private val coinDatabase: CoinDatabase,
    private val coinMapper: CoinMapper
) {

    suspend fun getCoinCollection(): Resource<List<Coin>> {
        // TODO also fetch coins from remote
        return withContext(Dispatchers.IO) {
            Resource(status = Status.SUCCESS, data = mapCoins(coinDatabase.coinDao().getAll()))
        }
    }

    private fun mapCoins(input: List<CoinEntity>): List<Coin> {
        return input.filter { it.name != null }.map {
            coinMapper.map(it)
        }
    }
}