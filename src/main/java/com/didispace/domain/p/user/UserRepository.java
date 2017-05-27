package com.didispace.domain.p.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 无需提供实现类，Spring Data JPA会为我们搞定一切
 */

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByAgeLessThan(int age); //符合逻辑，不必自己写实现类

    public List<User> nqFindByAge(int age); //在User类中定义的，user中定义的名称需要时User.nqFindByAge

    //intellij idea 提示不能解析符号User，运行没问题
    //自定义查询
    @Query("select o from User o where o.age > ?1")
    public List<User> findByBigAge(int age);

    //intellij idea 也会提示%这里有错误，运行没问题
    @Query("select o from User o where o.name like %?1%")
    public List<User> findByName(String name);

    //不适用?1,?2,?3这种数字排列，使用参数名nn
    @Query(value="select o from User o where o.name like %:nn")
    public List<User> findByNameParam(@Param("nn") String name);

    //Modifying 调用的时候要加事务
    @Modifying
    @Query(value="update User o set o.name=:newName where o.name like %:nn")
    public int updateUserByName(@Param("nn") String name,@Param("newName") String newName);
}
