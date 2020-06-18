package com.suchaos.jpa.dao;

import com.suchaos.jpa.domain.ArticleData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * dao 层
 *
 * @author suchao
 * @date 2020/6/17
 */
public interface ArticleDataDao extends JpaRepository<ArticleData, Integer>, JpaSpecificationExecutor<ArticleData> {
}
