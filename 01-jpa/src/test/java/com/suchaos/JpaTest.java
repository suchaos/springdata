package com.suchaos;

import com.suchaos.domain.Article;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;

/**
 * test jpa
 *
 * @author suchao
 * @date 2020/6/17
 */
public class JpaTest {

    @Test
    public void testSave() {
        Article article = new Article();
        article.setTitle("测试文章");
        article.setAuthor("苏超");
        article.setCreateTime(LocalDate.now());

        // 1. 创建一个持久化管理器工程
        String persistenceUnitName = "jpa01-mysql";
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);

        // 2. 创建持久化管理器 -- 重要， 事务以及 crud 都从这里完成
        EntityManager entityManager = managerFactory.createEntityManager();

        // 3. 得到事务，开启事务
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        // 4. 操作
        entityManager.persist(article);

        // 5. 提交事务
        transaction.commit();

        // 6. 关闭资源
        entityManager.close();
    }
}
