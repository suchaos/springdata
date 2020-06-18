package com.suchaos.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * TransConfig -- 和配置文件中的 <tx:annotation-driven transaction-manager="transactionManager"/> 一个作用
 *
 * @author suchao
 * @date 2020/6/17
 */
@Configuration
@EnableTransactionManagement
public class TransConfig {
}
