import androidx.compose.ui.window.ComposeUIViewController
import org.company.test.App
import org.company.test.di.netWorkModule
import org.company.test.di.repositoryModule
import org.company.test.di.useCaseModule
import org.company.test.di.viewModelModule
import org.koin.core.context.startKoin
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
