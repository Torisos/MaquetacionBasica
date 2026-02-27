package com.nicolasduarte.maquetacionbasica

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nicolasduarte.maquetacionbasica.ui.theme.MaquetacionBasicaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Taller()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun Taller() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // CABECERA
        Image(
            painter = painterResource(id = R.drawable.ciclismo), // Cambia por tu recurso
            contentDescription = "Foto de perfil",
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Juan Pérez", fontSize = 24.sp, fontWeight = FontWeight.Bold)

        Text(
            text = "Desarrollador Android apasionado por la tecnología y el diseño.",
            textAlign = androidx.compose.ui.text.style.TextAlign.Center,
            modifier = Modifier.padding(horizontal = 32.dp, vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // ESTADÍSTICAS
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            EstadisticaCol(valor = "150", etiqueta = "Posts")
            EstadisticaCol(valor = "2.3K", etiqueta = "Seguidores")
            EstadisticaCol(valor = "980", etiqueta = "Likes")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // BOTONES
        Row(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = {},
                modifier = Modifier.weight(1f).height(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6750A4)),
                shape = RoundedCornerShape(24.dp)
            ) {
                Text("Seguir")
            }
            Spacer(modifier = Modifier.width(16.dp))
            OutlinedButton(
                onClick = {},
                modifier = Modifier.weight(1f).height(48.dp),
                shape = RoundedCornerShape(24.dp)
            ) {
                Text("Mensaje", color = Color(0xFF6750A4))
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Intereses",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Start)
        )

        Row(modifier = Modifier.fillMaxWidth()) {
            SuggestionChip(onClick = { }, label = { Text("Ciclismo") })
            Spacer(modifier = Modifier.width(33.dp))
            SuggestionChip(onClick = { }, label = { Text("Programación") })
            Spacer(modifier = Modifier.width(33.dp))
            SuggestionChip(onClick = { }, label = { Text("UI/UX") })
        }

// Segunda fila de intereses
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            SuggestionChip(onClick = { }, label = { Text("Música") })
            Spacer(modifier = Modifier.width(33.dp))
            SuggestionChip(onClick = { }, label = { Text("Viajes") })
            Spacer(modifier = Modifier.width(33.dp))
            SuggestionChip(onClick = { }, label = { Text("Gaming") })
        }

        Spacer(modifier = Modifier.height(24.dp))

        // PROYECTOS RECIENTES
        Text(
            text = "Proyectos Recientes",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Gray)
        ) {
            Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.ciclismo), // Cambia por tu recurso
                    contentDescription = null,
                    modifier = Modifier.size(100.dp).clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
                Column(modifier = Modifier.padding(start = 16.dp)) {
                    Text("App de Ciclismo", fontWeight = FontWeight.Bold)
                    Text("Aplicación para rastrear rutas de ciclismo con mapas y estadisticas.", fontSize = 14.sp)
                    Button(
                        onClick = { },
                        modifier = Modifier.align(Alignment.End).padding(top = 8.dp),
                        contentPadding = PaddingValues(horizontal = 30.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6750A4))
                    ) {
                        Text("Ver más", fontSize = 15.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun EstadisticaCol(valor: String, etiqueta: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = valor, fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Text(text = etiqueta, fontSize = 12.sp, color = Color.Gray)
    }
}
