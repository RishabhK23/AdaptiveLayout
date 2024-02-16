package com.example.adaptivelayouts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LargeNavigation() {
    Column(modifier = Modifier.width(150.dp)) {
        Row(modifier = Modifier.padding(10.dp)) {
            Icon(imageVector = Icons.Filled.Home, contentDescription = "Home")
            Spacer(modifier = Modifier.size(20.dp))
            Text(text = "Home")
        }
        Row(modifier = Modifier.padding(10.dp)){
            Icon(imageVector = Icons.Filled.Settings, contentDescription = "Home")
            Spacer(modifier = Modifier.size(20.dp))
            Text(text = "Settings")
        }
        Row(modifier = Modifier.padding(10.dp)){
            Icon(imageVector = Icons.Filled.AccountCircle, contentDescription = "Home")
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