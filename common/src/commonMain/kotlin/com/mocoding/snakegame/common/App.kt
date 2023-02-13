package com.mocoding.snakegame.common

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }
    val platformName = getPlatformName()

    val mapState by remember {
        mutableStateOf(
            List(10) { y ->
                List(10) { x ->
                    if (y == 5 || x == 5)
                        MapPixelState.Body
                    else
                        MapPixelState.Empty
                }
            }
        )
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(60.dp)
    ) {
        Box(
            modifier = Modifier
                .aspectRatio(1f)
                .fillMaxSize()
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                mapState.forEachIndexed { y, rowState ->
                    Row(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                    ) {
                        rowState.forEachIndexed { x, pixelState ->
                            when(pixelState) {
                                MapPixelState.Body -> Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .fillMaxHeight()
                                        .background(Color.Green)
                                )
                                else -> Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .fillMaxHeight()
                                        .background(Color.Transparent)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
