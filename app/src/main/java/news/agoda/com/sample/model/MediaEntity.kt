package news.agoda.com.sample.model


data class MediaEntity(
        val url: String,
        val format: String,
        val height: Int,
        val width: Int,
        val type: String,
        val subType: String,
        val caption: String? = null,
        val copyright: String
)