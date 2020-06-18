package com.suchaos.jpa.dao;

import com.suchaos.jpa.domain.Article;
import com.suchaos.jpa.domain.ArticleData;
import com.suchaos.jpa.domain.Comment;
import com.suchaos.jpa.domain.Type;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@SpringBootTest
@Slf4j
public class ManyToManyTest {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private ArticleDataDao articleDataDao;

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private TypeDao typeDao;

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
        log.info("-----------------save article type--------------------------------");
        Set<Article> articleSet = new HashSet<>();
        articleSet.add(article);
        Type type1 = Type.builder().name("船").articles(articleSet).build();
        Type type2 = Type.builder().name("水").articles(articleSet).build();
        Set<Type> typeSet = new HashSet<Type>(){{
            add(type1);
            add(type2);
        }};
        List<Type> types = typeDao.saveAll(typeSet);
        types.forEach(type -> log.info("type: {}", type));
    }

    @Test
    public void testOntToManyQuery() {
        Optional<Article> optional = articleDao.findById(3);
        optional.ifPresent(article -> {
            log.info("article: {}", article);
        });
    }

    @Test
    public void testOntToManyQuery2() {
        List<Type> all = typeDao.findAll();
        all.forEach(type -> {
            log.info("type.tid {}, name {}", type.getTid(), type.getName());
            log.info("type.articles: ");
            type.getArticles().forEach(article -> log.info("article: {}", article.getAid()));
        });
    }
}