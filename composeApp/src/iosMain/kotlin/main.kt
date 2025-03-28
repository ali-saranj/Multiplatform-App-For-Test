import androidx.compose.ui.window.ComposeUIViewController
import org.company.test.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
