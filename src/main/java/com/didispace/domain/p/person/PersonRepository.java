package com.didispace.domain.p.person;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA有什么
 主要来看看Spring Data JPA提供的接口，也是Spring Data JPA的核心概念：
 1：Repository：最顶层的接口，是一个空的接口，目的是为了统一所有Repository的类型，且能让组件扫描的时候自动识别。
 2：CrudRepository ：是Repository的子接口，提供CRUD的功能
 3：PagingAndSortingRepository：是CrudRepository的子接口，添加分页和排序的功能
 4：JpaRepository：是PagingAndSortingRepository的子接口，增加了一些实用的功能，比如：批量操作等。
 5：JpaSpecificationExecutor：用来做负责查询的接口
 6：Specification：是Spring Data JPA提供的一个查询规范，要做复杂的查询，只需围绕这个规范来设置查询条件即可
 */

public interface PersonRepository extends JpaRepository<Person, Long> {
   // 无需提供实现类，Spring Data JPA会为我们搞定一切
   //空的，可以什么都不用写
}
