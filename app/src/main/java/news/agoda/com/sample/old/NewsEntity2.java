package news.agoda.com.sample.old;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * This represents a news item
 */
public class NewsEntity2 {
    private static final String TAG = NewsEntity2.class.getSimpleName();
    private String title;
    private String summary;
    private String articleUrl;
    private String byline;
    private String publishedDate;
    private List<MediaEntity2> mediaEntityList;

    public NewsEntity2(JSONObject jsonObject) {
        try {
            mediaEntityList = new ArrayList<>();
            title = jsonObject.getString("title");
            summary = jsonObject.getString("abstract");
            articleUrl = jsonObject.getString("url");
            byline = jsonObject.getString("byline");
            publishedDate = jsonObject.getString("published_date");
            if(jsonObject.has("multimedia") && !jsonObject.getString("multimedia").isEmpty()){
                JSONArray mediaArray = jsonObject.getJSONArray("multimedia");
                for (int i = 0; i < mediaArray.length(); i++) {
                    JSONObject mediaObject = mediaArray.getJSONObject(i);
                    MediaEntity2 mediaEntity = new MediaEntity2(mediaObject);
                    mediaEntityList.add(mediaEntity);
                }
            }
        } catch (JSONException exception) {
            Log.e(TAG, exception.getMessage());
        }
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public String getArticleUrl() {
        return articleUrl;
    }

    public String getByline() {
        return byline;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public List<MediaEntity2> getMediaEntity() {
        return mediaEntityList;
    }
}
