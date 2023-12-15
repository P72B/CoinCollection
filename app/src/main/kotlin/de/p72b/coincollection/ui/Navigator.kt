package de.p72b.coincollection.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class Navigator {

    private val _sharedFlow =
        MutableSharedFlow<NavTarget>(extraBufferCapacity = 1)
    val sharedFlow = _sharedFlow.asSharedFlow()

    fun navigateTo(navTarget: NavTarget) {
        _sharedFlow.tryEmit(navTarget)
    }

    enum class NavTarget(
        val label: String,
        val icon: ImageVector? = null
    ) {
        Dashboard("dashboard", Icons.Outlined.Home),
        Collection("collection", Icons.Outlined.List),
        AddCoin("add_coin"),
        CoinDetails("coin_details")
    }
}