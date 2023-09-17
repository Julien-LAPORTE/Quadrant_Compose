package fr.samneo.quadrantcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.samneo.quadrantcompose.ui.theme.QuadrantComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuadrantComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainWindow()
                }
            }
        }
    }
}

@Composable
fun MainWindow() {
    Column {
        Row(Modifier.weight(1f)) {
            ComposableQuadrant(
                stringResource(id = R.string.top_left_title),
                stringResource(id = R.string.top_left_content),
                colorResource(id = R.color.TopLeftColor),
                Modifier.weight(1f)
            )
            ComposableQuadrant(
                stringResource(id = R.string.top_right_title),
                stringResource(id = R.string.top_right_content),
                colorResource(id = R.color.TopRightColor),
                Modifier.weight(1f)
            )
        }

        Row(Modifier.weight(1f)) {
            ComposableQuadrant(
                stringResource(id = R.string.bottom_left_title),
                stringResource(id = R.string.bottom_left_content),
                colorResource(id = R.color.BottomLeftColor),
                Modifier.weight(1f)
            )
            ComposableQuadrant(
                stringResource(id = R.string.bottom_right_title),
                stringResource(id = R.string.bottom_right_content),
                colorResource(id = R.color.BottomRightColor),
                Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun ComposableQuadrant(title: String, content: String, backgroundColor: Color, modifier: Modifier = Modifier){
    Column(
        modifier
            .background(backgroundColor)
            .padding(16.dp)
            .fillMaxSize(),
        Arrangement.Center,
        Alignment.CenterHorizontally) {
        Text(title, Modifier.padding(bottom = 16.dp) ,fontWeight =  FontWeight.Bold)
        Text(content, textAlign = TextAlign.Justify)
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    QuadrantComposeTheme {
        MainWindow()
    }
}
@Preview(showBackground = true)
@Composable
fun ComposableQuadrantPreview(){
    ComposableQuadrant("Je suis un titre",
        "Je suis le contenu qui concerne l'explication du titre",
        Color.Blue)
}