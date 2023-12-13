package de.p72b.coincollection

import android.app.Application
import de.p72b.coincollection.di.appModule
import de.p72b.coincollection.util.Logger
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CoinCollectionApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        Logger.setEnabled(BuildConfig.BUILD_TYPE !== "release")

        startKoin {
            androidContext(this@CoinCollectionApplication)
            androidLogger()
            modules(listOf(appModule))
        }
    }
}