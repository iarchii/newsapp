package news.agoda.com.sample.old;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class represents a media item
 */
public class MediaEntity2 {
    private String url;
    private String format;
    private int height;
    private int width;
    private String type;
    private String subType;
    private String caption;
    private String copyright;

    public MediaEntity2(JSONObject jsonObject) throws JSONException {
        url = jsonObject.getString("url");
        format = jsonObject.getString("format");
        height = jsonObject.getInt("height");
        width = jsonObject.getInt("width");
        type = jsonObject.getString("type");
        subType = jsonObject.getString("subtype");
        if(jsonObject.has( "capton" )){
            caption = jsonObject.getString("capton");
        }
        copyright = jsonObject.getString("copyright");
    }

    public String getUrl() {
        return url;
    }

    public String getFormat() {
        return format;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public String getType() {
        return type;
    }

    public String getSubType() {
        return subType;
    }

    public String getCaption() {
        return caption;
    }

    public String getCopyright() {
        return copyright;
    }

}