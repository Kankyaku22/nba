package pgl.practica3.nbafantasy.routes

sealed class Rutas (val ruta: String){

    object MenuPrincipal: Rutas(ruta = "menu")
    object CrearJugadores: Rutas(ruta = "crearjugadores")
    object Detalles: Rutas(ruta = "details")

    object
}