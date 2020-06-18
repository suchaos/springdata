package com.suchaos.jpa.dao;

import com.suchaos.jpa.domain.Article;
import com.suchaos.jpa.domain.ArticleData;
import com.suchaos.jpa.domain.Comment;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.*;

@SpringBootTest
@Slf4j
public class OneToManyTest {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private ArticleDataDao articleDataDao;

    @Autowired
    private CommentDao commentDao;

    @Test
    public void testOntToManySave() {
        Article article = Article.builder().author("co222").title("测试comment2222").
                createTime(LocalDateTime.now()).build();

        ArticleData data = ArticleData.builder().article(article).content("222222").build();

        Comment comment1 = Comment.builder().article(article).comment("c1222").build();
        Comment comment2 = Comment.builder().article(article).comment("c2222").build();
        Comment comment3 = Comment.builder().article(article).comment("c3222").build();
        Set<Comment> commentSet = new HashSet<Comment>() {
            {
                add(comment1);
                add(comment2);
                add(comment3);

            }
        };

        log.info("-----------------save article--------------------------------");
        Article a1 = articleDao.save(article);
        log.info("输出: {}", a1);
        log.info("-----------------save article data--------------------------------");
        ArticleData d1 = articleDataDao.save(data);
        log.info("输出: {}", d1);
        log.info("-----------------save article comments--------------------------------");
        List<Comment> comments = commentDao.saveAll(commentSet);
        for (Comment comment : comments) {
            log.info("comment: {}", comment);
        }
    }

    @Test
    public void testOntToManyQuery1() {
        List<Comment> list = commentDao.findAll(Sort.by(Sort.Direction.DESC, "cid"));
        list.forEach(comment -> log.info("comment: {}", comment));
    }

    @Test
    public void testOntToManyQuery2() {
        Integer id = 1;
        Optional<Article> optional = articleDao.findById(id);
        optional.ifPresent(article -> {
            article.getComments().forEach(comment -> log.info("comment for {}:{}", article.getAid(), comment));
        });
    }

    @Test
    public void testOntToManyQuery3() {
        List<Article> all = articleDao.findAll();
        all.forEach(article -> {
            article.getComments().forEach(comment -> log.info("comment for {}:{}", article.getAid(), comment));
        });
    }
}