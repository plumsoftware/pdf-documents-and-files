package ru.plumsoftware.pdf_doc_files

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.plumsoftware.pdf_doc_files.presentation.screens.recent.RecentScreen
import ru.plumsoftware.pdf_doc_files.presentation.theme.ExtendedTheme
import ru.plumsoftware.pdf_doc_files.presentation.theme.PdfTheme

class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExtendedTheme {
                PdfTheme {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        val navHost = rememberNavController()

                        NavHost(navController = navHost, startDestination = Routing.RECENT) {
                            composable(route = Routing.RECENT) {
                                RecentScreen(navHostController = navHost)
                            }
                        }
                    }
                }
            }
        }
    }
}
