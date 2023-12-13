package de.p72b.coincollection.usecase

import de.p72b.coincollection.data.Coin
import de.p72b.coincollection.data.CoinRepository
import de.p72b.coincollection.data.util.Resource

class GetCoinCollectionUseCase(
    private val repository: CoinRepository
) {
    suspend fun invoke(): Resource<List<Coin>> {
        return repository.getCoinCollection()
    }
}