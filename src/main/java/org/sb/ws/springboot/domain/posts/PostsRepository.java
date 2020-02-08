package org.sb.ws.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    //기존 MyBatis 의 DAO를 대신하는 Repository
    //Extends JpaRepository 시 기본 CRUD생성
    //Entity and Repository는 함께 존재

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
