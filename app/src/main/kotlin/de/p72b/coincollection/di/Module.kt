package de.p72b.coincollection.di

import de.p72b.coincollection.ui.Navigator
import de.p72b.coincollection.ui.model.collection.CollectionViewModel
import de.p72b.coincollection.ui.model.dashboard.DashboardViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { Navigator() }
    viewModel { DashboardViewModel() }
    viewModel { CollectionViewModel() }
}