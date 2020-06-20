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
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * RedisTest
 *
 * @author suchao
 * @date 2020/6/19
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class RedisHashTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

//    @Autowired
//    private RedisTemplate<String, User> userRedisTemplate;


    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private HashOperations<String, String, Article> opsForHash;

    @Before
    public void init() {
        opsForHash = redisTemplate.opsForHash();
    }

    @Test
    public void testSave() {
        Article article = new Article();
        article.setAuthor("苏超");
        article.setCreteTime(LocalDateTime.now());
        article.setName("论文");
        opsForHash.put("articles", "2", article);
        Article find = opsForHash.get("articles", "2");
        log.info("article1: {}", find);
    }
}
