package pgl.practica3.nbafantasy.model

import java.util.Date

data class Jugador(val nombre: String, val equipo: String, val posiciones : List<String>,val puntos: Int,val equipoRival: String, val fechaPartido: String)