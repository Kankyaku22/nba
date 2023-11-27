package pgl.practica3.nbafantasy.routes

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pgl.practica3.nbafantasy.model.BaseDeDatos
import pgl.practica3.nbafantasy.model.Jugador
import java.util.Date

@Composable
fun Navigator(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Rutas.MenuPrincipal.ruta){

        var listaJugadores: ArrayList<Jugador> = BaseDeDatos.readData()

        composable(Rutas.)



        composable(Rutas.MenuPrincipal.ruta){

            MenuPrincipal(navController = navController, listaJugadores)
        }
        composable(Rutas.CrearJugadores.ruta){

            CrearJugadores(navController = navController, jugadores = listaJugadores)

        }
        composable(Rutas.Detalles.ruta){

        }
    }

}