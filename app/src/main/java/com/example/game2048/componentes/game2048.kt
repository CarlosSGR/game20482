package com.example.game2048.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun PantallaPrincipal() {
    var pantallaActual by remember { mutableStateOf(0) }
    val numerosJuego = remember { mutableStateListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0) }
    var nombreUsuario by remember { mutableStateOf("") }

    if (numerosJuego.any { it > 2048 } && pantallaActual == 0) {
        pantallaActual = 2
    }

    Column(Modifier.fillMaxSize().background(color = Color(0xFFF8F6EE))) {

        Box(modifier = Modifier.weight(1f)) {
            when (pantallaActual) {
                0 -> PantallaJuegoDinamico(numerosJuego, nombreUsuario, { nombreUsuario = it })
                1 -> PantallaEstatica()
                2 -> PantallaGameOver(nombreUsuario) {
                    for(i in 0 until 16) numerosJuego[i] = 0
                    pantallaActual = 0
                }
            }
        }

        Row(modifier = Modifier.fillMaxWidth().padding(30.dp)) {
            Box(modifier = Modifier.fillMaxWidth().height(90.dp).background(Color(0xFFE7E3D6), shape = RoundedCornerShape(30.dp)), contentAlignment = Alignment.Center) {
                Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp), horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically) {

                    Box(Modifier.clickable { pantallaActual = 1 }) {
                        BotonHerramienta(Icons.Default.ArrowBack, Color(0xFFBBADA0))
                    }

                    Box(Modifier.clickable { pantallaActual = 2 }) {
                        BotonHerramienta(Icons.Default.Refresh, Color(0xFFBBADA0))
                    }

                    Box(Modifier.clickable { pantallaActual = 0 }) {
                        BotonHerramienta(Icons.Default.Menu, Color(0xFFD6CDBF))
                    }
                }
            }
        }
    }
}

@Composable
fun PantallaJuegoDinamico(numeros: MutableList<Int>, nombre: String, onNombreChange: (String) -> Unit) {
    val score = numeros.sum()
    val best = numeros.maxOrNull() ?: 0

    Column {
        Box(modifier = Modifier.fillMaxWidth().padding(all = 15.dp)) {
            Icon(Icons.Default.Menu, "Menú", tint = Color.Black, modifier = Modifier.size(30.dp).align(Alignment.CenterStart))
            Text("2048", fontSize = 40.sp, fontWeight = FontWeight.Bold, modifier = Modifier.align(Alignment.Center))
            Icon(Icons.Default.Refresh, "Refresh", tint = Color.Black, modifier = Modifier.size(30.dp).align(Alignment.CenterEnd))
        }

        Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp)) {
            Box(modifier = Modifier.weight(1f).background(Color(0xFFE8E5D8), shape = RoundedCornerShape(8.dp)).padding(vertical = 10.dp), contentAlignment = Alignment.Center) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Text("SCORE", color = Color(0xFF978775), modifier = Modifier.padding(start = 10.dp))
                    Text("$score", color = Color(0xFF978775), modifier = Modifier.padding(end = 10.dp))
                }
            }
            Spacer(modifier = Modifier.width(10.dp))
            Box(modifier = Modifier.weight(1f).border(width = 2.dp, color = Color(0xFFC2BFB9), shape = RoundedCornerShape(8.dp)).background(Color(0xFFF8F6EE), shape = RoundedCornerShape(8.dp)).padding(vertical = 10.dp), contentAlignment = Alignment.Center) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Text("BEST", color = Color(0xFF978775), modifier = Modifier.padding(start = 10.dp))
                    Text("$best", color = Color(0xFF978775), modifier = Modifier.padding(end = 10.dp))
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Row(Modifier.fillMaxWidth().padding(horizontal = 20.dp)) {
            Box(
                modifier = Modifier.fillMaxWidth().aspectRatio(1f).padding(horizontal = 20.dp)
                    .background(Color(0xFF9A8573), shape = RoundedCornerShape(8.dp)).padding(10.dp)
            ) {
                Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(7.dp)) {
                    Row(modifier = Modifier.weight(1f).fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(7.dp)) {
                        CeldaInteligente(Modifier.weight(1f), numeros[0]) { numeros[0] = sigValor(numeros[0]) }
                        CeldaInteligente(Modifier.weight(1f), numeros[1]) { numeros[1] = sigValor(numeros[1]) }
                        CeldaInteligente(Modifier.weight(1f), numeros[2]) { numeros[2] = sigValor(numeros[2]) }
                        CeldaInteligente(Modifier.weight(1f), numeros[3]) { numeros[3] = sigValor(numeros[3]) }
                    }
                    Row(modifier = Modifier.weight(1f).fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(7.dp)) {
                        CeldaInteligente(Modifier.weight(1f), numeros[4]) { numeros[4] = sigValor(numeros[4]) }
                        CeldaInteligente(Modifier.weight(1f), numeros[5]) { numeros[5] = sigValor(numeros[5]) }
                        CeldaInteligente(Modifier.weight(1f), numeros[6]) { numeros[6] = sigValor(numeros[6]) }
                        CeldaInteligente(Modifier.weight(1f), numeros[7]) { numeros[7] = sigValor(numeros[7]) }
                    }
                    Row(modifier = Modifier.weight(1f).fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(7.dp)) {
                        CeldaInteligente(Modifier.weight(1f), numeros[8]) { numeros[8] = sigValor(numeros[8]) }
                        CeldaInteligente(Modifier.weight(1f), numeros[9]) { numeros[9] = sigValor(numeros[9]) }
                        CeldaInteligente(Modifier.weight(1f), numeros[10]) { numeros[10] = sigValor(numeros[10]) }
                        CeldaInteligente(Modifier.weight(1f), numeros[11]) { numeros[11] = sigValor(numeros[11]) }
                    }
                    Row(modifier = Modifier.weight(1f).fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(7.dp)) {
                        CeldaInteligente(Modifier.weight(1f), numeros[12]) { numeros[12] = sigValor(numeros[12]) }
                        CeldaInteligente(Modifier.weight(1f), numeros[13]) { numeros[13] = sigValor(numeros[13]) }
                        CeldaInteligente(Modifier.weight(1f), numeros[14]) { numeros[14] = sigValor(numeros[14]) }
                        CeldaInteligente(Modifier.weight(1f), numeros[15]) { numeros[15] = sigValor(numeros[15]) }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = nombre,
            onValueChange = onNombreChange,
            label = { Text("Ingresa tu nombre") },
            modifier = Modifier.fillMaxWidth().padding(horizontal = 30.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF9A8573),
                unfocusedBorderColor = Color(0xFFBBADA0)
            )
        )
    }
}

@Composable
fun PantallaEstatica() {
    Column {
        Box(modifier = Modifier.fillMaxWidth().padding(all = 15.dp)) {
            Icon(Icons.Default.Menu, "Menú", tint = Color.Black, modifier = Modifier.size(30.dp).align(Alignment.CenterStart))
            Text("2048", fontSize = 40.sp, fontWeight = FontWeight.Bold, modifier = Modifier.align(Alignment.Center))
            Icon(Icons.Default.Refresh, "Refresh", tint = Color.Black, modifier = Modifier.size(30.dp).align(Alignment.CenterEnd))
        }

        Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp)) {
            Box(modifier = Modifier.weight(1f).background(Color(0xFFE8E5D8), shape = RoundedCornerShape(8.dp)).padding(vertical = 10.dp), contentAlignment = Alignment.Center) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Text("SCORE", color = Color(0xFF978775), modifier = Modifier.padding(start = 10.dp))
                    Text("1692", color = Color(0xFF978775), modifier = Modifier.padding(end = 10.dp))
                }
            }
            Spacer(modifier = Modifier.width(10.dp))
            Box(modifier = Modifier.weight(1f).border(width = 2.dp, color = Color(0xFFC2BFB9), shape = RoundedCornerShape(8.dp)).background(Color(0xFFF8F6EE), shape = RoundedCornerShape(8.dp)).padding(vertical = 10.dp), contentAlignment = Alignment.Center) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Text("BEST", color = Color(0xFF978775), modifier = Modifier.padding(start = 10.dp))
                    Text("7000", color = Color(0xFF978775), modifier = Modifier.padding(end = 10.dp))
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Row(Modifier.fillMaxWidth().padding(horizontal = 20.dp)) {
            Box(
                modifier = Modifier.fillMaxWidth().aspectRatio(1f).padding(horizontal = 20.dp)
                    .background(Color(0xFF9A8573), shape = RoundedCornerShape(8.dp)).padding(10.dp)
            ) {
                Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(7.dp)) {
                    Row(modifier = Modifier.weight(1f).fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(7.dp)) {
                        CeldaInteligente(Modifier.weight(1f), 4) {}
                        CeldaInteligente(Modifier.weight(1f), 32) {}
                        CeldaInteligente(Modifier.weight(1f), 8) {}
                        CeldaInteligente(Modifier.weight(1f), 32) {}
                    }
                    Row(modifier = Modifier.weight(1f).fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(7.dp)) {
                        CeldaInteligente(Modifier.weight(1f), 0) {}
                        CeldaInteligente(Modifier.weight(1f), 16) {}
                        CeldaInteligente(Modifier.weight(1f), 64) {}
                        CeldaInteligente(Modifier.weight(1f), 4) {}
                    }
                    Row(modifier = Modifier.weight(1f).fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(7.dp)) {
                        CeldaInteligente(Modifier.weight(1f), 0) {}
                        CeldaInteligente(Modifier.weight(1f), 2) {}
                        CeldaInteligente(Modifier.weight(1f), 128) {}
                        CeldaInteligente(Modifier.weight(1f), 64) {}
                    }
                    Row(modifier = Modifier.weight(1f).fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(7.dp)) {
                        CeldaInteligente(Modifier.weight(1f), 0) {}
                        CeldaInteligente(Modifier.weight(1f), 0) {}
                        CeldaInteligente(Modifier.weight(1f), 8) {}
                        CeldaInteligente(Modifier.weight(1f), 0) {}
                    }
                }
            }
        }

    }
}

@Composable
fun PantallaGameOver(nombre: String, onReset: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Game Over", fontSize = 50.sp, fontWeight = FontWeight.Bold, color = Color(0xFF776E65))
        Spacer(modifier = Modifier.height(20.dp))
        Text("$nombre sigue participando", fontSize = 25.sp, fontWeight = FontWeight.Bold, color = Color.Black)
        Spacer(modifier = Modifier.height(40.dp))
        Button(
            onClick = onReset,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8F7A66)),
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier.padding(10.dp)
        ) {
            Text("Play Again", fontSize = 20.sp, modifier = Modifier.padding(10.dp))
        }
    }
}

fun sigValor(actual: Int): Int {
    return if (actual == 0) 2 else actual * 2
}

@Composable
fun CeldaInteligente(modifier: Modifier = Modifier, valor: Int, onCeldaClick: () -> Unit) {
    val texto = if (valor == 0) "" else valor.toString()
    val colorFondo = when(valor) {
        0 -> Color(0xFFBCAB97)
        2 -> Color(0xFFEDE2D8)
        4 -> Color(0xFFE9D7B5)
        8 -> Color(0xFFF0AE71)
        16 -> Color(0xFFF38E58)
        32 -> Color(0xFFF47556)
        64 -> Color(0xFFF35836)
        128 -> Color(0xFFF0CD56)
        256 -> Color(0xFFEDCC61)
        512 -> Color(0xFFEDC850)
        1024 -> Color(0xFFEDC53F)
        2048 -> Color(0xFFEDC22E)
        else -> Color(0xFF3C3A32)
    }
    val colorTexto = if (valor < 8) Color(0xFF746351) else Color.White
    CajaIndividual(
        modifier = modifier.clickable { onCeldaClick() },
        texto = texto,
        colorTexto = colorTexto,
        colorFondo = colorFondo
    )
}

@Composable
fun CajaIndividual(modifier: Modifier, texto: String, colorTexto: Color, colorFondo: Color) {
    Box(
        modifier = modifier.fillMaxSize().background(colorFondo, shape = RoundedCornerShape(5.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(texto, color = colorTexto, fontSize = 25.sp, fontWeight = FontWeight.ExtraBold)
    }
}

@Composable
fun BotonHerramienta(icono: androidx.compose.ui.graphics.vector.ImageVector, colorFondo: Color) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier.size(60.dp).background(colorFondo, shape = RoundedCornerShape(10.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(imageVector = icono, contentDescription = null, tint = Color.White, modifier = Modifier.size(35.dp))
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            Box(Modifier.width(20.dp).height(4.dp).background(Color(0xFFCDC1B4), shape = RoundedCornerShape(50)))
            Box(Modifier.width(20.dp).height(4.dp).background(Color(0xFFCDC1B4), shape = RoundedCornerShape(50)))
        }
    }
}