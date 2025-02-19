package com.plcoding.nativeiosincompose

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
actual fun NativeButton(onClick: () -> Unit, modifier: Modifier) {
    Button(
        onClick = onClick,
        modifier = modifier
    ) {
        Text("Android button")
    }
}