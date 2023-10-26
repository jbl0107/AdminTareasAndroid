package com.example.admintareas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.admintareas.ui.theme.AdminTareasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdminTareasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FinalCheck()
                }
            }
        }
    }
}


@Composable
fun FinalCheck() {
    Check(
        image = painterResource(id = R.drawable.ic_task_completed),
        info = stringResource(R.string.all_tasks_completed),
        congratulations = stringResource(R.string.nice_work)
    )
}

@Composable
fun Check(image: Painter, info: String, congratulations: String, modifier: Modifier = Modifier) {

    Column (verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {

        Image(
            painter = image,
            contentDescription = null,

        )

        Text(
            //NO aparece aqui, pero: fillMaxWidth() es para hacer que el bloque del txt ocupe todo el ancho. Es como el
            //display: bloc de css. fillMaxHeight() es para hacer q un texto (por ej) ocupe todo el espacio vertical disponible
            text = info,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 24.dp, bottom = 8.dp)
        )

        Text(
            text = congratulations,
            fontSize = 16.sp,

        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    AdminTareasTheme {
        FinalCheck()
    }
}