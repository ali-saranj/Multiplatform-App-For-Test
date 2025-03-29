package org.company.test.presenter.video

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.util.reflect.TypeInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import org.company.test.core.network.ApiClient
import org.company.test.core.network.toResult
import org.company.test.data.models.CategoryVideosResponse
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun VideoScreen(
    modifier: Modifier = Modifier, viewModel: VideoViewModel = koinViewModel()
) {
    val state = viewModel.state.collectAsStateWithLifecycle()

//    var isError by remember { mutableStateOf(false) }
//    rememberCoroutineScope().launch {
//        viewModel.effect.collect {
//            when (it) {
//                VideoScreenEffect.Error -> {
//                    isError = true
//                }
//            }
//        }
//    }

    LaunchedEffect(Unit) {
        viewModel.sendEvent(VideoScreenEvent.GetVideo)
    }

    if (!state.value.error.isNullOrBlank()) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(state.value.error ?: "aaa")
        }
    }

    if (state.value.isLoading) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator()
        }
    }

    Box(modifier.fillMaxSize().padding(8.dp)) {
        LazyColumn {
            items(state.value.videos) {
                Text(text = it.title)
            }
        }
    }
}

