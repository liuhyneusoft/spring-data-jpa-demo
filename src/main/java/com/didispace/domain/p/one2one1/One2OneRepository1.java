package com.didispace.domain.p.one2one1;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *生成2张表，author，book，其中book表有author的主键
 */

public interface One2OneRepository1 extends JpaRepository<CustomerEO1, Long> {

}