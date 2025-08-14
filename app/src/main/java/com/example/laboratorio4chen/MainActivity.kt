package com.example.laboratorio4chen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.laboratorio4chen.ui.theme.Laboratorio4chenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Laboratorio4chenTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PortadaCentradaScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun PortadaCentradaScreen(modifier: Modifier = Modifier) {
    // Marco verde exterior
    Box(
        modifier = modifier
            .fillMaxSize()
            .border(6.dp, Color(0xFF1B5E20), RoundedCornerShape(0.dp))
            .padding(10.dp)
    ) {
        // Página blanca con borde negro
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White, RoundedCornerShape(0.dp))
                .border(2.dp, Color(0xFF212121), RoundedCornerShape(0.dp))
                .padding(horizontal = 24.dp, vertical = 16.dp)
        ) {
            // Logo tenue de fondo (se dibuja primero para quedar atrás)
            Image(
                painter = painterResource(R.drawable.logo_uvg),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxWidth(0.68f)
                    .alpha(0.08f),
                contentScale = ContentScale.Fit
            )

            // ===== Bloque principal centrado =====
            Column(
                modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Universidad del Valle\nde Guatemala",
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Black,
                    textAlign = TextAlign.Center
                )

                Spacer(Modifier.height(16.dp))

                Text(
                    text = "Programación de plataformas\nmóviles, Sección 30",
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center
                )

                Spacer(Modifier.height(24.dp))

                // INTEGRANTES
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.Top
                ) {
                    Text(
                        text = "INTEGRANTES",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.weight(1f))
                    Column {
                        Text("Juan Durini")
                        Text("Cristiano Ronaldo")
                        Text("Lionel Messi")
                        // Cambia por tus nombres
                    }
                }

                Spacer(Modifier.height(16.dp))

                // CATEDRÁTICO
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "CATEDRÁTICO",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.weight(1f))
                    Text("Juan Carlos Durini")
                }
            }

            // ===== Datos del alumno anclados abajo =====
            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Emilio Josue Chen Borrayo")
                Text("24841")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PortadaPreview() {
    Laboratorio4chenTheme { PortadaCentradaScreen() }
}
