package com.suchaos.service;

import com.suchaos.dao.ArticleDao;
import com.suchaos.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ArticleService
 *
 * @author suchao
 * @date 2020/6/17
 */
@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Transactional
    public void save(Article article) {
        articleDao.save(article);
        throw new RuntimeException("测试数据库回滚");
    }
}
