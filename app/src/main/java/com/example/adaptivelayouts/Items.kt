package com.example.adaptivelayouts

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun Item(
    modif: Modifier,
    screenSize: Int,
    onClick: (String) -> Unit
) {

    if (screenSize == LARGE_SIZE) {
        val text = "LargeSize Icon"
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = modif.padding(10.dp).clickable { onClick(text) }
        ) {
            Box(
                modifier = Modifier.size(50.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.error)
            )
            Text(text = "Item")
        }
    } else if(screenSize == MEDIUM_SIZE) {
        val text = "Medium Size Icon"
        Column(
            modifier = modif.padding(16.dp).clickable { onClick(text) },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Box(
                modifier = Modifier.size(50.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
            )
            Text(text = "Item")
        }
    }else {
        val text = "Small Size Icon"
        Column(
            modifier = modif.padding(16.dp).clickable { onClick(text) },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Box(
                modifier = Modifier.size(50.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.error)
            )
            Text(text = "Item")
        }
    }

}
