package my.mildotdev.hubung

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.google.android.gms.instantapps.InstantApps
import my.mildotdev.hubung.ui.theme.HubungTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HubungTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
        //showInstallPrompt()
    }

    private fun showInstallPrompt() {
        val postInstall = Intent(Intent.ACTION_MAIN)
            .addCategory(Intent.CATEGORY_DEFAULT)
            .setPackage("my.mildotdev.hubungdetail")

        InstantApps.showInstallPrompt(this, postInstall, 1, null)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Column {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        Button(onClick = {
            val detailUri = Uri.parse("hubung://my.mildotdev.hubungdetail/detail/123")
            val intent = Intent(Intent.ACTION_VIEW, detailUri).also { it.`package` = context.packageName }
            context.startActivity(intent)
        }) {
            Text(text = "Go to detail screen")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HubungTheme {
        Greeting("Android")
    }
}