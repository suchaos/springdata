package com.suchaos.redis.controller;

import com.suchaos.redis.domain.Article;
import com.suchaos.redis.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * RedisTest
 *
 * @author suchao
 * @date 2020/6/19
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class RedisListTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private ListOperations<String, Object> listOperations;

    @Before
    public void init() {
        listOperations = redisTemplate.opsForList();
    }

    @Test
    public void testSave() {
        Article article1 = Article.builder().author("zhangsan").creteTime(LocalDateTime.now()).name("论A").build();
        Article article2 = Article.builder().author("zhangsan2").creteTime(LocalDateTime.now()).name("论A2").build();
        Article article3 = Article.builder().author("zhangsan3").creteTime(LocalDateTime.now()).name("论A3").build();
        Long number = listOperations.leftPushAll("article_list2", article1, article2, article3);
    }

    @Test
    public void testGet() {
        List<Object> article_list = listOperations.range("article_list2", 0, -1);
        article_list.forEach(article -> log.info("article: {}", article));
    }
}
