package com.example.adaptivelayouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SmallPanel(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.weight(1f),
            painter = painterResource(id = R.drawable.cat1),
            contentDescription = "Cat 1"
        )
        Spacer(modifier = Modifier.size(10.dp))
        Image(
            modifier = Modifier.weight(1f),
            painter = painterResource(id = R.drawable.dog),
            contentDescription = "Dog"
        )
    }
}

@Composable
fun MediumPanel(modifier: Modifier) {
    Column(
        modifier = modifier
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.weight(1f),
                painter = painterResource(id = R.drawable.cat1),
                contentDescription = "Cat 1"
            )
            Spacer(modifier = Modifier.size(10.dp))
            Image(
                modifier = Modifier.weight(1f),
                painter = painterResource(id = R.drawable.dog),
                contentDescription = "Dog"
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.weight(1f),
                painter = painterResource(id = R.drawable.cat2),
                contentDescription = "Cat 1"
            )
            Spacer(modifier = Modifier.size(10.dp))
            Image(
                modifier = Modifier.weight(1f),
                painter = painterResource(id = R.drawable.dog1),
                contentDescription = "Dog"
            )
        }
    }
}

@Composable
fun LargePanel(modifier: Modifier) {
    Column(modifier = modifier) {
        MediumPanel(modifier = modifier.weight(1f))
        SmallPanel(modifier = modifier.weight(1f))
    }
}

@Preview(showBackground = true)
@Composable
fun PanelPreview(){
    LargePanel(modifier = Modifier.fillMaxWidth())
}