package com.example.BLPS_l1.services.news.service.web;

import java.util.List;
import java.util.stream.Collectors;

import com.example.BLPS_l1.services.mail.models.Message;
import com.example.BLPS_l1.services.news.models.Comment;
import com.example.BLPS_l1.services.news.models.News;
import com.example.BLPS_l1.services.news.service.logic.NewsBusinessLogic;
import com.example.BLPS_l1.services.news.service.web.model.dto.CommentDto;
import com.example.BLPS_l1.services.news.service.web.model.dto.NewsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@CrossOrigin
@RestController
@RequestMapping("/api/news")
public class NetworkNewsController {

    @Autowired
    NewsBusinessLogic newsBusinessLogic;

    @Autowired
    ConversionService conversionService;

    @GetMapping("/getNews")
    public List<NewsDto> getNews() {
        return newsBusinessLogic.getNews().stream().map(e -> conversionService.convert(e, NewsDto.class)).collect(Collectors.toList());
    }

    @PostMapping("/likeNews")
    public void likeNew(@Valid @RequestBody NewsDto newsDto) {
        newsBusinessLogic.likeNews(conversionService.convert(newsDto, News.class));
    }

    @PostMapping("/commentNews")
    public void commentNew(@Valid @RequestBody CommentDto commentDto) {
        newsBusinessLogic.commentNews(conversionService.convert(commentDto, Comment.class));
    }
}
