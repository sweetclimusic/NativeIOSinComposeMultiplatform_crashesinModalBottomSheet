package com.plcoding.nativeiosincompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Suppress("ktlint:standard:function-naming")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App() {
    MaterialTheme {
        var showBottomSheet by rememberSaveable { mutableStateOf(false) }
        val sheetState = rememberModalBottomSheetState()
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            NativeButton(
                onClick = {
                    showBottomSheet = !showBottomSheet
                },
                modifier = Modifier.align(Alignment.CenterHorizontally),
            )
            Text("Click ⬆️ Native Button for ModalBottomSheet", modifier = Modifier.padding(0.dp, 4.dp))
            Text("Compose Button, ⬇️ does the same job", modifier = Modifier.padding(0.dp, 4.dp))
            Button(
                onClick = {
                    showBottomSheet = !showBottomSheet
                },
                modifier = Modifier.align(Alignment.CenterHorizontally),
                content = {
                    Text("Click for ModalBottomSheet")
                },
            )
        }
        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = {
                    showBottomSheet = false
                },
                modifier =
                    Modifier.fillMaxSize(),
                sheetState = sheetState,
                tonalElevation = 16.dp,
                content = {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        var counter by remember {
                            mutableIntStateOf(0)
                        }
                        NativeButton(
                            onClick = {
                                counter++
                            },
                        )
                        Text("Counter: $counter")
                    }
                },
            )
        }
    }
}
