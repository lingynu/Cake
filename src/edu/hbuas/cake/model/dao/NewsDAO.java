package edu.hbuas.cake.model.dao;

import edu.hbuas.cake.model.javabean.News;

import java.util.List;

public interface NewsDAO {
    public List<News> listAllNews();

    //后台
    public boolean addNews(News news);
    public boolean deleteNews(int newsId);
}
