package org.sb.ws.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    //기존 MyBatis 의 DAO를 대신하는 Repository
    //Extends JpaRepository 시 기본 CRUD생성
    //Entity and Repository는 함께 존재
}
