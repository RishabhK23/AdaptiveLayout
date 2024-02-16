package com.example.adaptivelayouts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LargeNavigation() {
    //Couldn't figure out how to use a PermanentNavigationDrawer so just Colomnized this one.
    Column(
        modifier = Modifier
            .wrapContentWidth()
            .padding(end = 40.dp)
    ) {
        Row(modifier = Modifier.padding(10.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = Icons.Filled.Home, contentDescription = "Home")
            Spacer(modifier = Modifier.size(20.dp))
            Text(text = "Home")
        }
        Row(modifier = Modifier.padding(10.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = Icons.Filled.Settings, contentDescription = "Settings")
            Spacer(modifier = Modifier.size(20.dp))
            Text(text = "Settings")
        }
        Row(modifier = Modifier.padding(10.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = Icons.Filled.AccountCircle, contentDescription = "Account")
            Spacer(modifier = Modifier.size(20.dp))
            Text(text = "Account")
        }
    }

}

@Composable
fun MediumNavigation() {
    NavigationRail {
        NavigationRailItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = { Icon(imageVector = Icons.Filled.Home, contentDescription = "Home") },
            label = { Text(text = "Home") }
        )
        NavigationRailItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = "Settings"
                )
            },
            label = { Text(text = "Settings") }
        )
        NavigationRailItem(
            selected = true,
            onClick = { /*TODO*/ },
            icon = {
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = "Account"
                )
            },
            label = { Text(text = "Account") }
        )
    }
}

@Composable
fun CompactNavigation() {
    BottomAppBar {
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = { Icon(imageVector = Icons.Filled.Home, contentDescription = "Home") },
            label = { Text(text = "Home") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = "Settings"
                )
            },
            label = { Text(text = "Settings") }
        )
        NavigationBarItem(
            selected = true,
            onClick = { /*TODO*/ },
            icon = {
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = "Account"
                )
            },
            label = { Text(text = "Account") }
        )
    }
}

/**
 * Even in case of topAppBar, we can create an adaptive TopAppBar which will be adjusting based on
 * the screen size. Notice that here we are not using the WindowSizeClass, but instead we are using
 * the extension method of getDisplaySize. This enables us to make an individual component adaptive
 * and not depend or pass on the windowSizeClass composable around.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdaptiveTopBar() {
    val context = LocalContext.current
    val displayType by remember {
        mutableStateOf(context.getDisplaySize())
    }

    val title = stringResource(id = R.string.app_name)
    val navigationIcon = Icons.AutoMirrored.Filled.ArrowBack
    val colors = TopAppBarColors(
        containerColor = MaterialTheme.colorScheme.primary,
        scrolledContainerColor = MaterialTheme.colorScheme.onPrimaryContainer,
        navigationIconContentColor = Color.Black,
        titleContentColor = MaterialTheme.colorScheme.inversePrimary,
        actionIconContentColor = MaterialTheme.colorScheme.inversePrimary
    )

    when (displayType) {
        DisplayType.LARGE -> LargeTopAppBar(title = { Text(text = title) }, navigationIcon = {
            Icon(
                imageVector = navigationIcon,
                contentDescription = "Back"
            )
        }, colors = colors)
        DisplayType.MEDIUM -> MediumTopAppBar(title = { Text(text = title) }, navigationIcon = {
            Icon(
                imageVector = navigationIcon,
                contentDescription = "Back"
            )
        }, colors = colors)
        DisplayType.SMALL -> TopAppBar(title = { Text(text = title) }, navigationIcon = {
            Icon(
                imageVector = navigationIcon,
                contentDescription = "Back"
            )
        }, colors = colors)
    }
}

@Preview(showBackground = true)
@Composable
fun NavigationPreview() {
    LargeNavigation()
}