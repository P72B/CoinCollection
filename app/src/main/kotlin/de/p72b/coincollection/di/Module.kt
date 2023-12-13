package de.p72b.coincollection.di

import de.p72b.coincollection.data.CoinRepository
import de.p72b.coincollection.data.mapper.CoinMapper
import de.p72b.coincollection.data.room.CoinDatabase
import de.p72b.coincollection.ui.Navigator
import de.p72b.coincollection.ui.model.collection.CollectionViewModel
import de.p72b.coincollection.ui.model.dashboard.DashboardViewModel
import de.p72b.coincollection.usecase.GetCoinCollectionUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { Navigator() }
    single {
        CoinDatabase.provide(
            context = get()
        )
        CoinRepository(
            coinDatabase = CoinDatabase.database,
            coinMapper = CoinMapper()
        )
    }
    factory {
        GetCoinCollectionUseCase(
            repository = get()
        )
    }
    viewModel { DashboardViewModel(
        getCoinCollectionUseCase = get()
    ) }
    viewModel { CollectionViewModel() }
}