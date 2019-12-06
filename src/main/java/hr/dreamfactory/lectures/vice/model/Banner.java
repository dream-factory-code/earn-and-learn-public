package hr.dreamfactory.lectures.vice.model;

import com.google.gson.annotations.SerializedName;

public class Banner {
    private String title;
    private String url;
    private String id;

    @SerializedName("image_url")
    private String imageUrl;

    @SerializedName("recommendation_id")
    private String recommendationId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getRecommendationId() {
        return recommendationId;
    }

    public void setRecommendationId(String recommendationId) {
        this.recommendationId = recommendationId;
    }
}
