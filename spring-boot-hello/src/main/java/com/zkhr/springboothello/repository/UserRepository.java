package com.zkhr.springboothello.repository;

import com.zkhr.springboothello.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @program: springboot-cloud-demo
 * @description: UserRepository
 * @author: DI CHENG
 * @create: 2018-01-17 10:38
 **/
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select t from User t where t.id = ?1")
    User findUserById(Integer id);

    @Query("select t from User t where t.name =?1 and t.age =?2")
    User findByNameAndAge(String name, Integer age);

    @Query("select t from User t where t.name like :name")
    Page<User> findByName(@Param("name") String name, Pageable pageRequest);

}
