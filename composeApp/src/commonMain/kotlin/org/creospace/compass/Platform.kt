package org.creospace.compass

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform