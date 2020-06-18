package com.suchaos.jpa.dao;

import com.suchaos.jpa.domain.Article;
import com.suchaos.jpa.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * dao 层
 *
 * @author suchao
 * @date 2020/6/17
 */
public interface CommentDao extends JpaRepository<Comment, Integer>, JpaSpecificationExecutor<Comment> {

    //Article findTopByTitle(String title);
}
