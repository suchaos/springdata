package com.suchaos.jpa.dao;

import com.suchaos.jpa.domain.Article;
import com.suchaos.jpa.domain.ArticleData;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@Slf4j
public class OneToOneTest {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private ArticleDataDao articleDataDao;

    @Test
    public void testOntToOneSave() {
        Article article = Article.builder().author("巡航").title("船的运行原理").
                createTime(LocalDateTime.now()).build();

        ArticleData data = ArticleData.builder().article(article).content("原理比较复杂").build();
        //
        // data.setArticle(article);

        Article a1 = articleDao.save(article);
        log.info("输出: {}", a1);
        ArticleData d1 = articleDataDao.save(data);
        log.info("输出: {}", d1);
    }

    @Test
    public void testOntToOneSave2() {
        String articleTitle = "测试";
        Article article = articleDao.findTopByTitle(articleTitle);

        ArticleData data = ArticleData.builder().article(article).content("原理比较复杂").build();

        ArticleData d1 = articleDataDao.save(data);
        log.info("输出: {}", d1);
    }

    @Test
    public void testOntToOneQuery() {
        log.info("开始: ");
        //List<ArticleData> all = articleDataDao.findAll();
        List<Article> all = articleDao.findAll();
        all.forEach(data -> log.info("data: {}", data));
        log.info("结束: ");
    }

}