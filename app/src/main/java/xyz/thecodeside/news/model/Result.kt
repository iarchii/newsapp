package xyz.thecodeside.news.model


data class Resources<out T>(
        val data: T?,
        val throwable: Throwable?
)