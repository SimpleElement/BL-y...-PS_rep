package com.example.BLPS_l1.services.news.dao;

import com.example.BLPS_l1.services.news.models.News;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NewsRepository extends CrudRepository<News, Integer> {
    List<News> findAll();

    News findNewsById(Integer id);

    boolean existsById(Integer id);
}
