package me.naingaungluu.kmmdevfest2022

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform