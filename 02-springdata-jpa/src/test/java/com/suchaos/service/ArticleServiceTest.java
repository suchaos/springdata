package com.suchaos.service;

import com.suchaos.config.TransConfig;
import com.suchaos.domain.Article;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-jpa.xml")
@Slf4j
public class ArticleServiceTest {

    @Autowired
    private ArticleService articleService;

    @Test(expected = RuntimeException.class)
    public void testRollback() {
        Article article = new Article();
        article.setAuthor("suchao");
        article.setTitle("rollback");
        article.setCreateTime(LocalDateTime.now());
        articleService.save(article);
    }

}