package vip.cdms.allay4a

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import vip.cdms.allay4a.ui.AllayApp
import vip.cdms.allay4a.ui.theme.Allay4ATheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Allay4ATheme {
                AllayApp()
            }
        }
    }
}
