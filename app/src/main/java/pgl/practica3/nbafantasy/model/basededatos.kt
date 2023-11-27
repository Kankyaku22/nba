package pgl.practica3.nbafantasy.model

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.google.gson.Gson
import pgl.practica3.nbafantasy.R
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

object BaseDeDatos{

    val projectPath = File(".")
    val archivo = "${projectPath.canonicalPath}/app/src/main/res/raw/jugadores.dat"

    fun writeData(jugadores: ArrayList<Jugador>){
        ObjectOutputStream(FileOutputStream(archivo)).use {
            stream -> stream.writeObject(jugadores)
        }
    }

    fun readData(): ArrayList<Jugador>{
        return arrayListOf(
            Jugador("Lebron James", "Los Angeles Lakers", arrayOf("PF","C","PG").toList(),29,"rival",
                "9/11/2001"
            ),
            Jugador("Donovan Mitchell", "Boston Celtics", arrayOf("SF").toList(),12,"rival",
                "9/11/2001"
            ),
            Jugador("Aperen Sengun", "Golden State Warriors", arrayOf("C","PG").toList(),10,"rival",
                "9/11/2001"
            ),

            Jugador("Naz Reid", "Miami Heat", arrayOf("PF,SG,SF").toList(),10,"rival",
                "10/10/2002"
            ),
            Jugador("Paco Perez", "Miwaukee", arrayOf("C").toList(),10,"rival",
                "20/02/2003"
            ),
            Jugador("Roberto Melon", "bulls", arrayOf("SG","C").toList(),10,"rival",
                "30/10/2004"
            ),
            Jugador("Marki lokura", "bulls", arrayOf("PF").toList(),10,"rival",
                "31/12/2004"
            ),
            Jugador("Pablo Motos", "bulls", arrayOf("C","PG").toList(),10,"rival",
                "03/04/2005"
            )
        )
    }



    /*
    fun readData(): ArrayList<Jugador>{
        var listaJugadores: ArrayList<Jugador>
        ObjectInputStream(FileInputStream(archivo)).use {
            stream -> listaJugadores = stream.readObject() as ArrayList<Jugador>
        }
        return listaJugadores
    }
    */

}