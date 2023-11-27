package pgl.practica3.nbafantasy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pgl.practica3.nbafantasy.model.BaseDeDatos
import pgl.practica3.nbafantasy.model.Jugador
import pgl.practica3.nbafantasy.routes.Navigator
import pgl.practica3.nbafantasy.ui.theme.NBAFantasyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            NBAFantasyTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Navigator()
                }
            }
        }
    }
}
