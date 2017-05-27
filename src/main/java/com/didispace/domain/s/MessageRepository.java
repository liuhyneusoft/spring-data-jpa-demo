package com.didispace.domain.s;

import org.springframework.data.jpa.repository.JpaRepository;


public interface MessageRepository extends JpaRepository<Message, Long> {
// 无需提供实现类，Spring Data JPA会为我们搞定一切
    //空的，可以什么都不用写

}
