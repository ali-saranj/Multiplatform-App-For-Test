package org.company.test

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import multiplatform_app_for_test.composeapp.generated.resources.*
import org.company.test.theme.AppTheme
import org.company.test.theme.LocalThemeIsDark
import kotlinx.coroutines.isActive
import org.company.test.di.netWorkModule
import org.company.test.di.repositoryModule
import org.company.test.di.useCaseModule
import org.company.test.di.viewModelModule
import org.company.test.presenter.video.VideoScreen
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
import org.koin.compose.KoinApplication

@Composable
internal fun App() = AppTheme {
    KoinApplication(application = {
        modules(netWorkModule, repositoryModule, useCaseModule, viewModelModule)
    }) {
        VideoScreen()
    }
}
