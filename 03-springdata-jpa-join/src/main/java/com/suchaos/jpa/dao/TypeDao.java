package com.suchaos.jpa.dao;

import com.suchaos.jpa.domain.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * dao 层
 *
 * @author suchao
 * @date 2020/6/17
 */
public interface TypeDao extends JpaRepository<Type, Integer>, JpaSpecificationExecutor<Type> {

}
