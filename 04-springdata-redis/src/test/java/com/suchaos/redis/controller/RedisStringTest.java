package com.suchaos.redis.controller;

import com.suchaos.redis.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;

/**
 * RedisTest
 *
 * @author suchao
 * @date 2020/6/19
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisStringTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

//    @Autowired
//    private RedisTemplate<String, User> userRedisTemplate;


    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void testSave() {
        stringRedisTemplate.opsForValue().set("aaa", "value for aaa");
    }

    @Test
    public void testSave2() {
        redisTemplate.opsForValue().set("ccc", "value for ccc 3", Duration.ofMinutes(5));
    }

    @Test
    public void testSave3() {
        User user = new User();
        user.setAge(12);
        user.setId(1);
        user.setName("张三");
        redisTemplate.opsForValue().set("user", user);
    }

    @Test
    public void testIncr() {
        stringRedisTemplate.opsForValue().set("age", "18");
        stringRedisTemplate.opsForValue().increment("age");
        Assert.assertEquals("19", stringRedisTemplate.opsForValue().get("age"));
    }

    @Test
    public void testGet() {
        String s = stringRedisTemplate.opsForValue().get("aaa");
        System.out.println(s);
    }
}
