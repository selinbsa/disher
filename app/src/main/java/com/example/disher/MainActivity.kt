package com.example.disher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.disher.category.viewmodel.MainViewModel
import com.example.disher.navigation.DisherNavigation
import com.example.disher.ui.theme.DisherTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().apply {
            setKeepVisibleCondition{
                viewModel.isLoading.value
            }

        }

        setContent {
            DisherTheme {
                DisherApp()
            }
        }
    }
}


@Composable
fun DisherApp() {
    DisherNavigation()
}


//www.themealdb.com/api/json/v1/1/categories.php