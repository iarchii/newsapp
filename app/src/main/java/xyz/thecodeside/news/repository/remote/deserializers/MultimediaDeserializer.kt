package xyz.thecodeside.news.repository.remote.deserializers

import com.google.gson.*
import xyz.thecodeside.news.model.MediaEntity
import java.lang.reflect.Type

internal class MultimediaDeserializer : JsonDeserializer<List<MediaEntity>> {
    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): List<MediaEntity> =
            if (json is JsonArray) {
                val test = context.deserialize<Array<MediaEntity>>(json, Array<MediaEntity>::class.java)
                test.toList()
            } else emptyList()
}