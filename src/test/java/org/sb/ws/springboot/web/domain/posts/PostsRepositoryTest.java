package org.sb.ws.springboot.web.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sb.ws.springboot.domain.posts.Posts;
import org.sb.ws.springboot.domain.posts.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
//별도의 설정 없이 H2데이터베이스 실
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After //JUnit 후 실행 되는 메소드
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void BoardMsg_Read() {
        //given
        String title = "TEST Board Message";
        String content = "TEST Board Body";

        //insert, update 실행
        postsRepository.save((Posts.builder()
                .title(title)
                .content(content)
                .author("test@gmail.com")
                .build()));

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_Regist() {
        //given
        LocalDateTime now = LocalDateTime.of(2020,1,29,0,0,0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>> createDate=" + posts.getCreatedDate() + ", modifiedDate=" + posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
