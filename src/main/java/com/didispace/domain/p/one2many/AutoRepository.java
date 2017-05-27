package com.didispace.domain.p.one2many;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 生成3张表，Author，Book，一张关联关系表。author，book表内都没有对方的主键
 */

public interface AutoRepository extends JpaRepository<Author, Long> {

}