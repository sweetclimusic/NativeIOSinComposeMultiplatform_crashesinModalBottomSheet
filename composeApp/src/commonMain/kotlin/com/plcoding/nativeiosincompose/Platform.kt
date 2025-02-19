package com.plcoding.nativeiosincompose

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform