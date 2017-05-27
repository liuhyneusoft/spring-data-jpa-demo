package com.didispace.domain.p.one2many1;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *生成2张表，author，book，其中book表有author的主键
 */

public interface AutoRepository1 extends JpaRepository<Author1, Long> {

}