package com.autoscuela.scheduler.offline

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                OfflineDemoApp()
            }
        }
    }
}

@Composable
fun OfflineDemoApp() {
    var count by remember { mutableStateOf(0) }
    val slots = listOf(
        "08:30 - 09:15 (Libre)",
        "09:15 - 10:00 (Libre)",
        "10:00 - 10:45 (Libre)",
        "11:00 - 11:45 (Libre)",
        "11:45 - 12:30 (Libre)",
        "12:30 - 13:15 (Libre)",
        "16:00 - 16:45 (Libre)",
        "16:45 - 17:30 (Libre)",
        "17:30 - 18:15 (Libre)",
        "18:30 - 19:15 (Libre)",
        "19:15 - 20:00 (Libre)",
        "20:00 - 20:45 (Libre)",
    )
    Scaffold(topBar = { CenterAlignedTopAppBar(title = { Text("Autoescuela Offline Demo") }) }) { padding ->
        Column(Modifier.padding(padding).padding(16.dp)) {
            Text("Contador de prueba: $count")
            Row(Modifier.padding(vertical = 8.dp)) {
                Button(onClick = { count++ }) { Text("Pulsar") }
                Spacer(Modifier.width(8.dp))
                Button(onClick = { count = 0 }) { Text("Reiniciar") }
            }
            Divider(Modifier.padding(vertical = 8.dp))
            Text("Horario (demo):")
            LazyColumn {
                items(slots) { s -> Text("• $s", modifier = Modifier.padding(vertical = 4.dp)) }
            }
        }
    }
}
