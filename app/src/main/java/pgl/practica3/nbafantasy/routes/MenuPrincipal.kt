package pgl.practica3.nbafantasy.routes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarColors
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import pgl.practica3.nbafantasy.R
import pgl.practica3.nbafantasy.model.Jugador
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuPrincipal(navController: NavController?, listaImportada: ArrayList<Jugador>) {

    var listaJugadores = remember { mutableListOf(listaImportada) }
    val scrollState = rememberScrollState()
    var editMode by remember { mutableStateOf(false) }
        Column (
            modifier = Modifier.fillMaxWidth()
        ){
            Text(text = "Bienvenido a tu fantasy league", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth().padding(5.dp))
            SearchBar(
                query = "", onQueryChange = {}, onSearch = {}, active = false, onActiveChange = {},
                shape = RectangleShape,
                placeholder = { Text(text = "Busca a jugadores por equipo") },
                colors = SearchBarDefaults.colors(containerColor = Color(R.color.black)),
                leadingIcon = {
                    Icon(painter = painterResource(id = R.drawable.baseline_sports_basketball_24), contentDescription = "")
                },
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Text(text = "Busca a jugadores por equipo...")
            }
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ){
                listaImportada.forEachIndexed{ _, jugador ->
                    item{
                        JugadorComponent(jugador = jugador, editMode)
                    }
                }
            }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)

        ) {
            ExtendedFloatingActionButton(onClick = { /*TODO*/ }) {
                Text(text = "Add")
                Icon(painter = painterResource(id = R.drawable.baseline_add_circle_24), contentDescription = "")
            }
            ExtendedFloatingActionButton(onClick = { editMode = !editMode}) {
                Text(text = "Delete")
                Icon(painter = painterResource(id = R.drawable.baseline_delete_24), contentDescription = "")
            }

        }
    }
}

@Composable
fun JugadorComponent(jugador: Jugador, editMode: Boolean){

    var checked by remember { mutableStateOf(false) }
    val teamColor = when(jugador.equipo) {
        "Los Angeles Lakers" -> R.color.lakers
        "Boston Celtics" -> R.color.celtics
        "Golden State Warriors" -> R.color.warriors
        "Miami Heat" -> R.color.heat
        "Milwaukee Bucks" -> R.color.bucks
        "Brooklyn Nets" -> R.color.nets
        else -> R.color.purple_700
    }

    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(5.dp)
    ) {
        Row (
            Modifier
                .fillMaxWidth()
                .background(Color(teamColor)),
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(painter = painterResource(id = R.drawable.lebron), contentDescription = "",
                contentScale = ContentScale.Crop, modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape),
                )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.weight(2f)
            ) {
                Text(text = jugador.nombre)
                Text(text = "VS ${jugador.equipoRival}, ${jugador.fechaPartido}")
                Text(text = "" + jugador.puntos + "PP")
            }
            if(editMode){
                Checkbox(checked = checked, onCheckedChange = { newState ->
                    checked = newState
                }, enabled = true, modifier = Modifier.weight(1f))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuPreview(){
    MenuPrincipal(
        navController = null, listaImportada = arrayListOf(
                Jugador("Lebron James", "Los Angeles Lakers", arrayOf("a","b","c").toList(),29,"rival",
                    "9/11/2001"
                ),
                Jugador("Donovan Mitchell", "Boston Celtics", arrayOf("a","b","c").toList(),12,"rival",
                    "9/11/2001"
                ),
                Jugador("Aperen Sengun", "Golden State Warriors", arrayOf("a","b","c").toList(),10,"rival",
                    "9/11/2001"
                ),

                Jugador("Naz Reid", "bulls", arrayOf("a","b","c").toList(),10,"rival",
                    "10/10/2002"
                ),
                Jugador("Lebron James", "bulls", arrayOf("a","b","c").toList(),10,"rival",
                    "20/02/2003"
                ),
                Jugador("Lebron James", "bulls", arrayOf("a","b","c").toList(),10,"rival",
                    "30/10/2004"
                ),
                Jugador("Lebron James", "bulls", arrayOf("a","b","c").toList(),10,"rival",
                    "31/12/2004"
                ),
                Jugador("Lebron James", "bulls", arrayOf("a","b","c").toList(),10,"rival",
                    "03/04/2005"
                ),
                /*
                Jugador("Lebron James", "bulls", arrayOf("a","b","c").toList(),10,"rival",
                    Date(2001,11,9)
                ),
                Jugador("Lebron James", "bulls", arrayOf("a","b","c").toList(),10,"rival",
                    Date(2001,11,9)
                ),
                Jugador("Lebron James", "bulls", arrayOf("a","b","c").toList(),10,"rival",
                    Date(2001,11,9)
                ),
                * */
            ))
}



/*
@Preview(showBackground = true)
@Composable
fun JugadorCardPreview(){
    JugadorComponent(jugador = Jugador("Lebron James", "bulls", arrayOf("a","b","c").toList(),10,"rival",Date(2001,11,9)))
}*/