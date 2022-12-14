package com.example.gdsccomposecampfirstappday2
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gdsccomposecampfirstappday2.ui.theme.GDSCComposeCampFirstAppDay2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GDSCComposeCampFirstAppDay2Theme {
                // A surface container using the 'background' color from the theme
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp(names : List<String> = listOf("Android", "Compose", "World")) {
    Column(
        modifier = Modifier.padding(4.dp)
    ) {
        for(name in names)
        {
            Greeting(name = name)
        }
    }
}
@Composable
fun Greeting(name: String) {
    val expanded = remember{ mutableStateOf(false) }
    val extraPadding = if(expanded.value) 48.dp else 0.dp


    Surface(color = MaterialTheme.colors.primary, modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(modifier = Modifier
                .weight(1f)
                .padding(bottom = extraPadding)) {
                Text(text = "Hello ")
                Text(text = "$name!")
            }
            OutlinedButton(onClick = { expanded.value = !expanded.value }) {
                if(expanded.value)
                    Text("Show Less")
                else
                    Text("Show More")

            }
        }
    }
}

@Preview(showBackground = true, widthDp = 350)
@Composable
fun DefaultPreview() {
    GDSCComposeCampFirstAppDay2Theme {
        MyApp()
    }
}
