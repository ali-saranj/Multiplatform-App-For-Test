package org.company.test.presenter.video.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.compose.rememberAsyncImagePainter
import multiplatform_app_for_test.composeapp.generated.resources.Res
import multiplatform_app_for_test.composeapp.generated.resources.ic_cyclone
import multiplatform_app_for_test.composeapp.generated.resources.ic_launcher_background
import org.company.test.domein.home.model.Video
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)

@Composable
fun CardVideo(
    modifier: Modifier = Modifier,
    video: Video
) {
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = modifier
    ) {
        Card(modifier = Modifier.fillMaxWidth().height(250.dp)) {
            Box(
                modifier = Modifier,
            ) {
                AsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    clipToBounds = true,
                    model = video.thumbnailUrl,
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
                    error = painterResource(Res.drawable.ic_launcher_background)
                )
            }
        }
        Text(video.title, style = MaterialTheme.typography.titleMedium)
    }
}
