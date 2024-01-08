package com.chuwa.mongoblog.service.impl;

import com.chuwa.mongoblog.dao.ArticleRepository;
import com.chuwa.mongoblog.entity.Article;
import com.chuwa.mongoblog.payload.ArticleDto;
import com.chuwa.mongoblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public ArticleDto createArticle(ArticleDto articleDto) {

        // Specify the desired time zone
        String timeZoneId = "America/New_York"; // Change this to your desired time zone
        // Get the current time in the specified time zone
        LocalDateTime currentTime = LocalDateTime.now(ZoneId.of(timeZoneId));

        Article tobeSaved = new Article();
        tobeSaved.setTitle(articleDto.getTitle());
        tobeSaved.setContent(articleDto.getContent());
        tobeSaved.setCreateDateTime(currentTime);
        tobeSaved.setUpdataDateTime(currentTime);

        Article save = this.articleRepository.save(tobeSaved);
        ArticleDto response = new ArticleDto();
        response.setTitle(save.getTitle());
        response.setContent(save.getContent());
        response.setCreateDateTime(save.getCreateDateTime());
        response.setUpdataDateTime(save.getUpdataDateTime());


        return response;
    }
}
