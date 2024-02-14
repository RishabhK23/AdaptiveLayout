package com.example.adaptivelayouts

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.window.layout.WindowMetricsCalculator
import com.example.adaptivelayouts.ui.theme.AdaptiveLayoutsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdaptiveLayoutsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var displayText by rememberSaveable {
                        mutableStateOf("Nothing Clicked")
                    }
                    val context = LocalContext.current
                    val displaySize by remember {
                        mutableIntStateOf(context.getDisplaySize())
                    }

                    Box(modifier = Modifier.fillMaxSize()){
                        if (displaySize == LARGE_SIZE) {
                            Row {
                                Greeting(name = displayText)
                                AdaptivePanel(onItemClick = {
                                    displayText = it
                                })
                            }
                        } else {
                            Column {
                                Greeting(name = displayText)
                                AdaptivePanel(onItemClick = {
                                    displayText = it
                                })
                            }
                        }
                        Toast.makeText(this@MainActivity, "Recomposition", Toast.LENGTH_SHORT).show()
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AdaptiveLayoutsTheme {
        Greeting("Android")
    }
}

@Composable
fun AdaptivePanel(
    onItemClick: (String) -> Unit
) {

    val context = LocalContext.current
    val displaySize by remember {
        mutableIntStateOf(context.getDisplaySize())
    }

    Row(modifier = Modifier.fillMaxWidth()) {
        if (displaySize == SMALL_SIZE) {
            Item(modif = Modifier, screenSize = displaySize) {
                onItemClick(it)
            }
            Item(modif = Modifier, screenSize = displaySize) {
                onItemClick(it)
            }
        } else if (displaySize == MEDIUM_SIZE) {
            Item(modif = Modifier.weight(1f), screenSize = displaySize) {
                onItemClick(it)
            }
            Item(modif = Modifier.weight(1f), screenSize = displaySize) {
                onItemClick(it)
            }
            Item(modif = Modifier.weight(1f), screenSize = displaySize) {
                onItemClick(it)
            }
            Item(modif = Modifier.weight(1f), screenSize = displaySize) {
                onItemClick(it)
            }
        } else {
            Item(modif = Modifier.weight(1f), screenSize = displaySize) {
                onItemClick(it)
            }
            Item(modif = Modifier.weight(1f), screenSize = displaySize) {
                onItemClick(it)
            }
            Item(modif = Modifier.weight(1f), screenSize = displaySize) {
                onItemClick(it)
            }
            Item(modif = Modifier.weight(1f), screenSize = displaySize) {
                onItemClick(it)
            }
            Item(modif = Modifier.weight(1f), screenSize = displaySize) {
                onItemClick(it)
            }
            Item(modif = Modifier.weight(1f), screenSize = displaySize) {
                onItemClick(it)
            }
        }
    }


}

val SMALL_SIZE = 0
val MEDIUM_SIZE = 1
val LARGE_SIZE = 2

fun Context.getDisplaySize(): Int {
    val portraitMobile = 600
    val tabletPortrait = 840

    val metrics = WindowMetricsCalculator.getOrCreate().computeCurrentWindowMetrics(this)
    val width = metrics.bounds.width()
    val density = resources.displayMetrics.density

    val windowSizeInDp = width.div(density)

    return when {
        windowSizeInDp < portraitMobile -> SMALL_SIZE
        windowSizeInDp > portraitMobile && windowSizeInDp < tabletPortrait -> MEDIUM_SIZE
        else -> LARGE_SIZE
    }
}