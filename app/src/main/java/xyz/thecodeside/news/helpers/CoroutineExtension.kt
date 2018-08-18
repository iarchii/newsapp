package xyz.thecodeside.news.helpers

import kotlinx.coroutines.experimental.Deferred
import xyz.thecodeside.news.model.Resources


suspend fun <T> Deferred<T>.awaitResources(): Resources<T> {
    return try {
        Resources(await(), null)
    } catch (e: Exception) {
        Resources(null, e)
    }
}