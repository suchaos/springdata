package com.suchaos.jpa.dao;

import com.suchaos.jpa.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * dao 层
 *
 * @author suchao
 * @date 2020/6/17
 */
public interface ArticleDao extends JpaRepository<Article, Integer>, JpaSpecificationExecutor<Article> {

    Article findTopByTitle(String title);
}
