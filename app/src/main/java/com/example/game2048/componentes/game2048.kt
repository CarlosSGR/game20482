package com.example.game2048.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun PantallaPrincipal(){
    Column(Modifier.fillMaxSize().background(color = Color(0xFFF8F6EE))) {
        Box(modifier = Modifier.fillMaxWidth().padding(all=15.dp)) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Icono de Menú",
                tint = Color.Black,
                modifier = Modifier.size(30.dp).align(Alignment.CenterStart)
            )

            Text("2048", fontSize = 40.sp, fontWeight = FontWeight.Bold, modifier=Modifier.align(
                Alignment.Center)
            )

            Icon(
                imageVector = Icons.Default.Refresh,
                contentDescription = "Icono de Refresh",
                tint = Color.Black,
                modifier = Modifier.size(30.dp).align(Alignment.CenterEnd)
            )
        }

        Row(modifier=Modifier.fillMaxWidth().padding(horizontal = 10.dp)) {
            Box(modifier = Modifier.weight(1f).background(Color(0xFFE8E5D8), shape = RoundedCornerShape(8.dp)).padding(vertical = 10.dp),
                contentAlignment = Alignment.Center){
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Text("SCORE", color =  Color(0xFF978775), modifier = Modifier.padding(start = 10.dp))
                    Text("1692", color =  Color(0xFF978775), modifier = Modifier.padding(end = 10.dp))
                }
            }
            Spacer(modifier = Modifier.width(10.dp))
            Box(
                modifier = Modifier
                    .weight(1f)
                    .border(width = 2.dp, color = Color(0xFFC2BFB9), shape = RoundedCornerShape(8.dp))
                    .background(Color(0xFFF8F6EE), shape = RoundedCornerShape(8.dp))
                    .padding(vertical = 10.dp),
                contentAlignment = Alignment.Center
            ){
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Text("BEST", color =  Color(0xFF978775), modifier = Modifier.padding(start = 10.dp))
                    Text("7000", color =  Color(0xFF978775), modifier = Modifier.padding(end = 10.dp))
                }

            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Row(Modifier.fillMaxWidth().padding(horizontal=20.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .padding(horizontal = 20.dp)
                    .background(Color(0xFF9A8573), shape = RoundedCornerShape(8.dp))
                    .padding(10.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(7.dp)
                ) {


                    Row(
                        modifier = Modifier.weight(1f).fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(7.dp)
                    ) {
                        CeldaInteligente(Modifier.weight(1f), "4")
                        CeldaInteligente(Modifier.weight(1f), "32")
                        CeldaInteligente(Modifier.weight(1f), "8")
                        CeldaInteligente(Modifier.weight(1f), "32")
                    }


                    Row(
                        modifier = Modifier.weight(1f).fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(7.dp)
                    ) {
                        CeldaInteligente(Modifier.weight(1f), "")
                        CeldaInteligente(Modifier.weight(1f), "16")
                        CeldaInteligente(Modifier.weight(1f), "64")
                        CeldaInteligente(Modifier.weight(1f), "4")
                    }


                    Row(
                        modifier = Modifier.weight(1f).fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(7.dp)
                    ) {
                        CeldaInteligente(Modifier.weight(1f), "")
                        CeldaInteligente(Modifier.weight(1f), "2")
                        CeldaInteligente(Modifier.weight(1f), "128")
                        CeldaInteligente(Modifier.weight(1f), "64")
                    }


                    Row(
                        modifier = Modifier.weight(1f).fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(7.dp)
                    ) {
                        CeldaInteligente(Modifier.weight(1f), "")
                        CeldaInteligente(Modifier.weight(1f), "")
                        CeldaInteligente(Modifier.weight(1f), "8")
                        CeldaInteligente(Modifier.weight(1f), "")
                    }
                }
            }

        }

        Spacer(modifier = Modifier.height(15.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .background(Color(0xFFE7E3D6), shape = RoundedCornerShape(30.dp)),
                contentAlignment = Alignment.Center
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BotonHerramienta(Icons.Default.ArrowBack, Color(0xFFBBADA0))

                    BotonHerramienta(Icons.Default.Refresh, Color(0xFFBBADA0))

                    BotonHerramienta(Icons.Default.ExitToApp, Color(0xFFD6CDBF))
                }
            }
        }
    }
}

@Composable
fun CeldaInteligente(modifier: Modifier = Modifier, texto: String) {
    val colorFondo = when(texto) {
        "2" -> Color(0xFFEDE2D8)
        "4" -> Color(0xFFE9D7B5)
        "8" -> Color(0xFFF0AE71)
        "16" -> Color(0xFFF38E58)
        "32" -> Color(0xFFF47556)
        "64" -> Color(0xFFF35836)
        "128" -> Color(0xFFF0CD56)
        else -> Color(0xFFBCAB97)
    }

    val colorTexto = when(texto) {
        "2", "4" -> Color(0xFF746351)
        else -> Color.White
    }

    CajaIndividual(modifier, texto, colorTexto, colorFondo)
}

@Composable
fun CajaIndividual(modifier: Modifier, texto: String, colorTexto: Color, colorFondo: Color) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(colorFondo, shape = RoundedCornerShape(5.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(texto, color = colorTexto, fontSize = 25.sp, fontWeight = FontWeight.ExtraBold)
    }
}

@Composable
fun BotonHerramienta(icono: androidx.compose.ui.graphics.vector.ImageVector, colorFondo: Color) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(60.dp)
                .background(colorFondo, shape = RoundedCornerShape(10.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icono,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(35.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))


        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {

            Box(
                modifier = Modifier
                    .width(20.dp)
                    .height(4.dp)
                    .background(Color(0xFFCDC1B4), shape = RoundedCornerShape(50))
            )

            Box(
                modifier = Modifier
                    .width(20.dp)
                    .height(4.dp)
                    .background(Color(0xFFCDC1B4), shape = RoundedCornerShape(50))
            )
        }
    }
}