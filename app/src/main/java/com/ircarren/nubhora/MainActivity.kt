package com.ircarren.nubhora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ircarren.nubhora.navigation.AppNavigation
import com.ircarren.nubhora.ui.theme.NubhoraTheme
import java.sql.Time

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NubhoraTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    TheApp()
                    //AppNavigation()
                }
            }
        }
    }
}

@Composable
fun Header() {
    Column() {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFF6BCDFD)
                )
                .height(100.dp),
            ) {

            Image(
                painter = painterResource(id = R.drawable.person),
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(80.dp)
                    .border(width = 2.dp, color = Color.White, shape = CircleShape)
            )

            Text(
                text = "¡Hola Jaume!",
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(CenterVertically)
                    .padding(start = 10.dp),
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@Composable
fun Body() {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
//    Column() {

        Map()
        Avisos()
        Jornada()
        Day()
        Registro()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Map() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(Color.White),
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.mapa),
                contentDescription = null, Modifier.border(8.dp, Color.White)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Avisos() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(Color.White),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Avisos",
                modifier = Modifier.padding(20.dp),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineSmall
            )
            Icon(
                imageVector = Icons.Filled.Notifications,
                contentDescription = "Avisos",
                modifier = Modifier
                    .padding(20.dp)
                    .size(30.dp)
            )
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Jornada() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(Color.White),
    ) {
        Row(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column() {
                Text(text = "Jornada Partida de 9:00h - 18:00h", style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Bold)
                Text(text = "Teórico: 8h")
            }
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "color",
                modifier = Modifier.size(50.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Day() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(Color.White),
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = "Jueves 16 de febrero de 2023")
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = "00:36:37",
                style = MaterialTheme.typography.displayMedium,
                color = Color.Gray,
                fontWeight = FontWeight.Bold,
            )
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color.Red),
                modifier = Modifier.align(Alignment.CenterVertically),
            ) {
                Text(text = "Salida")
            }
        }
    }
}

@Composable
fun Registro() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .height(400.dp)
    ) {
        items(TimeProvider.RegistroHorario.size) { index ->
            ItemRegistro(TimeProvider.RegistroHorario[index])
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemRegistro(horario: Registros) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(Color.White),
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = "Entrada", fontWeight = FontWeight.Bold)
            Text(text = "Salida", fontWeight = FontWeight.Bold)
        }
        Row(
            horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = horario.entrada)
            Text(text = horario.salida)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TheApp() {
    Scaffold(bottomBar = { BottomNavigation() }) { paddingValues ->
        HomeScreen(paddingValues)
    }
}

@Composable
fun HomeScreen(paddingValues: PaddingValues) {
    Surface(
        color = Color(0xFFEFF0F0),
        modifier = Modifier.padding(paddingValues)
    ) {
        Column {
            Header()
            Body()
        }
    }
}

@Composable
fun BottomNavigation() {
    var selectedItem by remember { mutableStateOf(0) }
    val items = MenuProvider.menuItems
    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.name) },
                label = { Text(item.name) },
                selected = selectedItem == index,
                onClick = { selectedItem = index },
            )
        }
    }
}