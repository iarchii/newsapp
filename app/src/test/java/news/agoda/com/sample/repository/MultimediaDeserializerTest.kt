package news.agoda.com.sample.repository

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializationContext
import com.google.gson.reflect.TypeToken
import news.agoda.com.sample.mock.mockEmptyJson
import news.agoda.com.sample.mock.mockJsonNoMediaResponse
import news.agoda.com.sample.mock.mockJsonResponse
import news.agoda.com.sample.model.MediaEntity
import news.agoda.com.sample.model.NewsEntity
import news.agoda.com.sample.model.NewsResponse
import news.agoda.com.sample.repository.remote.deserializers.MultimediaDeserializer
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import java.lang.reflect.Type

@RunWith(MockitoJUnitRunner::class)
class MultimediaDeserializerTest{

    private lateinit var deserializer: MultimediaDeserializer
    private lateinit var type: Type

    @Mock lateinit var deserializeContext : JsonDeserializationContext


    @Before
    fun setUp() {
        deserializer = MultimediaDeserializer()
        type=  object : TypeToken<List<@JvmSuppressWildcards MediaEntity>>() {}.type
    }

    @Test
    fun `when not a json array then should return empty list`(){
       val list = deserializer.deserialize(mockEmptyJson,type, deserializeContext )
        Assert.assertEquals(emptyList<NewsEntity>(), list)
    }

    @Test
    fun `when json with 4 media element then should return element list with 4 media`(){
        val t =  object : TypeToken<List<@JvmSuppressWildcards MediaEntity>>() {}.type
        val gson = GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(t, MultimediaDeserializer())
                .create()
        val obj = gson.fromJson(mockJsonResponse, NewsResponse::class.java )

        Assert.assertEquals(4, obj.results.first().valmediaEntityList?.size)
    }

    @Test
    fun `when json with no media element then should return empty list`(){
        val t =  object : TypeToken<List<@JvmSuppressWildcards MediaEntity>>() {}.type
        val gson = GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(t, MultimediaDeserializer())
                .create()
        val obj = gson.fromJson(mockJsonNoMediaResponse, NewsResponse::class.java )

        Assert.assertEquals(0, obj.results.first().valmediaEntityList?.size)
    }

}