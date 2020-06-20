package com.suchaos.redis.config;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * RedisConfig
 *
 *
 * redis 列化器的问题解读：https://cloud.tencent.com/developer/article/1497568
 *
 * @author suchao
 * @date 2020/6/19
 */
@Configuration
@Slf4j
public class RedisConfig {

    // Redis 配置类
    // 自定义的RedisTemplate的Bean名称必须为 redisTemplate。当方法名不为 redisTemplate时，可通过name显示指定bean名称，@Bean(name="redisTemplate")
    @Bean(name = "redisTemplate")
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        // 设置String Key序列化器
        template.setKeySerializer(getKeySerializer());
        template.setValueSerializer(getValueSerializer());
        // 设置Hash Key序列化器
        template.setHashKeySerializer(getKeySerializer());
        template.setHashValueSerializer(getValueSerializer());
        log.info("自定义RedisTemplate配置完成 ... ");
        return template;
    }

    // key 采用String序列化器
    private RedisSerializer<String> getKeySerializer() {
        //return new StringRedisSerializer();
        return RedisSerializer.string();
    }

    // value 采用Json序列化器
    private RedisSerializer<Object> getValueSerializer() {
//        ObjectMapper objectMapper = new ObjectMapper()
//                .registerModule(new ParameterNamesModule())
//                .registerModule(new Jdk8Module())
//                .registerModule(new JavaTimeModule());

//        ObjectMapper om = new ObjectMapper();
//        om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//        om.registerModule(new JavaTimeModule());
//        om.registerModule((new SimpleModule())
//                .addSerializer(new NullValueSerializer()));
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
//        GenericJackson2JsonRedisSerializer  serializer = new GenericJackson2JsonRedisSerializer(om);
        return new GenericJackson2JsonRedisSerializer();
    }
}
