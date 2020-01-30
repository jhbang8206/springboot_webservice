package org.sb.ws.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sb.ws.springboot.domain.BaseTimeEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter //LOMBOK
@NoArgsConstructor //LOMBOK 기본 자동 생성자 추
@Entity //JPA - DB 데이터 작업 시 해당 클래스의 수정을 통해 작업 (테이블과 링크)
//Entity에는 Setter 를 만들지 않는다 코드상으로 언제 변경 되어 야 하는지 명확하게 구분 할 수 없
public class Posts extends BaseTimeEntity {

    @Id //PK필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK 생성 규칙, IDENTITY 사용 시 Auto_increment 사용 가능
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder //해당 클래스의 빌더 패턴 클래스 생성
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
