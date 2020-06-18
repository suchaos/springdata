package com.suchaos.dao;

import com.suchaos.domain.Article;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:applicationContext-jpa.xml")
@Slf4j
public class ArticleDaoTest {

    @Autowired
    private ArticleDao articleDao;

    @Test
    public void testSave() {
        Article article = new Article();
        article.setTitle("title test");
        article.setCreateTime(LocalDateTime.now());
        article.setAuthor("苏超");

        Article save = articleDao.save(article);
        log.info("save: {}", save);
    }

    @Test
    public void testFindById() {
        Optional<Article> optionalArticle = articleDao.findById(3);
        optionalArticle.ifPresent(article -> log.info("article: {}", article));
    }

    @Test
    public void testFindAll() {
        List<Article> all = articleDao.findAll();
        all.forEach(article -> log.info("article: {}", article));
    }

    @Test
    public void testUpdate() {
        Optional<Article> optionalArticle = articleDao.findById(3);
        if (optionalArticle.isPresent()) {
            Article article = optionalArticle.get();
            article.setTitle("update 修改了");
            Article save = articleDao.save(article);
            log.info("save: {}", save);
        }
    }

    @Test
    public void testDelte() {
        articleDao.deleteById(1);
    }
}