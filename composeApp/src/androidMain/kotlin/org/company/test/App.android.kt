package org.company.test

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.company.test.core.network.ApiClient
import org.company.test.data.datasource.NetWorkDataSourceImpl
import java.lang.Exception
import java.net.UnknownHostException

class AppActivity : ComponentActivity() {
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        try {
            setContent {
                App()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("error", e.message ?: "")
        }
    }
}

@Preview(name = "Test")
@Composable
fun AppPreview() {
    App()
}

