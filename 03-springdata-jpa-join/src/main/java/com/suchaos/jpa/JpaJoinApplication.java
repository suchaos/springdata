package com.suchaos.jpa;

import com.suchaos.jpa.dao.ArticleDao;
import com.suchaos.jpa.domain.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDateTime;

/**
 * SpringBootApplication
 *
 * @author suchao
 * @date 2020/6/18
 */
@SpringBootApplication
@Slf4j
@EnableJpaRepositories
public class JpaJoinApplication implements CommandLineRunner {

    @Autowired
    private ArticleDao articleDao;

    public static void main(String[] args) {
        SpringApplication.run(JpaJoinApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Article article = Article.builder().author("suchao").title("题目").
//                createTime(LocalDateTime.now()).build();
//        Article save = articleDao.save(article);
//        log.info("save: {}", save);
    }
}
