package com.didispace.domain.p.paginator;

import com.didispace.domain.p.user.User;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface PageRepository extends PagingAndSortingRepository<User, Long> {
}