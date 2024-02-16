package com.example.adaptivelayouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.adaptivelayouts.ui.theme.AdaptiveLayoutsTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdaptiveLayoutsTheme {
                //WindowSizeClass requires activity and for that reason we need to declare it on
                //activity level and pass it along. Also, it is a composable under the hood, we don't
                //need to use remember as it gets recomposed.
                val windowSizeClass = calculateWindowSizeClass(activity = this)
                // A surface container using the 'background' color from the theme
                MainScreen(windowSizeClass = windowSizeClass)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(windowSizeClass: WindowSizeClass?) {

    Box(modifier = Modifier.fillMaxSize()) {

        Column(modifier = Modifier.fillMaxWidth()) {
            //Can be replaced by AdaptiveTopAppBar
            TopAppBar(title = {
                Text(text = "Adaptive Layout")
            }, colors = TopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                scrolledContainerColor = MaterialTheme.colorScheme.onPrimaryContainer,
                navigationIconContentColor = Color.Black,
                titleContentColor = MaterialTheme.colorScheme.inversePrimary,
                actionIconContentColor = MaterialTheme.colorScheme.inversePrimary
            ))

            windowSizeClass?.let {
                when (it.widthSizeClass) {
                    WindowWidthSizeClass.Compact -> {
                        AdaptivePanel(
                            windowSizeClass = windowSizeClass, modifier = Modifier
                                .weight(1f)
                        )
                        CompactNavigation()
                    }

                    WindowWidthSizeClass.Medium -> {
                        Row {
                            MediumNavigation()
                            AdaptivePanel(
                                windowSizeClass = windowSizeClass,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }

                    WindowWidthSizeClass.Expanded -> {
                        Row {
                            LargeNavigation()
                            AdaptivePanel(
                                modifier = Modifier.weight(1f),
                                windowSizeClass = windowSizeClass
                            )
                        }
                    }
                }
            }

        }


    }
}

@Composable
fun AdaptivePanel(modifier: Modifier, windowSizeClass: WindowSizeClass?) {

    val context = LocalContext.current
    val displayType by remember {
        mutableStateOf(context.getDisplaySize())
    }
    windowSizeClass?.let {
        when (it.widthSizeClass) {
            WindowWidthSizeClass.Compact -> {
                SmallPanel(modifier = modifier)
            }

            WindowWidthSizeClass.Medium -> {
                MediumPanel(modifier = modifier)
            }

            WindowWidthSizeClass.Expanded -> {
                LargePanel(modifier = modifier)
            }
        }
    } ?: run {
        when (displayType) {
            DisplayType.SMALL -> {
                SmallPanel(modifier)
            }

            DisplayType.MEDIUM -> {
                MediumPanel(modifier = modifier)
            }

            DisplayType.LARGE -> {
                LargePanel(modifier = modifier)
            }
        }
    }

}



@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    Column {
        AdaptiveTopBar()
        Row{
            LargeNavigation()
            LargePanel(modifier = Modifier.weight(1f))
        }
    }
}


