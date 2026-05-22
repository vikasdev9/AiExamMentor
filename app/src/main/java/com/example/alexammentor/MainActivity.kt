package com.example.alexammentor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.alexammentor.core.navigation.Screen
import com.example.alexammentor.presentation.scan.ScanScreen
import com.example.alexammentor.ui.theme.AlExamMentorTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlExamMentorTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Screen.Dashboard.route,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(Screen.Dashboard.route) {
                            DashboardScreen(onNavigateToOCR = { navController.navigate(Screen.OCR.route) })
                        }
                        composable(Screen.OCR.route) {
                            ScanScreen(
                                onNavigateToResult = { text ->
                                    navController.navigate(Screen.QuestionGen.route + "?text=$text")
                                }
                            )
                        }
                        composable(Screen.QuestionGen.route + "?text={text}") {
                            // TODO: Implement QuestionGenScreen
                            Text("Extracted Text: ${it.arguments?.getString("text")}")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DashboardScreen(onNavigateToOCR: () -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Dashboard")
        Button(onClick = onNavigateToOCR) {
            Text(text = "Go to OCR")
        }
    }
}
