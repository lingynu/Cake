package edu.hbuas.cake.model.javabean;

//这是新闻类
public class News {
    private int newsId;
    private String imageUrl;
    private String details;
    private String title;

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "News{" +
                "newsId=" + newsId +
                ", imageUrl='" + imageUrl + '\'' +
                ", details='" + details + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
