package my.mildotdev.hubungdetail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import my.mildotdev.hubung.ui.theme.HubungTheme

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HubungTheme {
                DetailScreen()
            }
        }
    }
}

@Composable
fun DetailScreen() {
    Box {
        Text("This is details screen!")
    }
}