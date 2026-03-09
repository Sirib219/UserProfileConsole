package com.example.userprofileconsole
import com.example.userprofileconsole.BusinessCardLayout
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import com.example.userprofileconsole.ui.theme.UserProfileConsoleTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            UserProfileConsoleTheme {

                Surface {
                    BusinessCardLayout()
                }

            }
        }
    }
}