package org.sb.ws.springboot.domain.map;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sb.ws.springboot.domain.BaseTimeEntity;

import javax.persistence.*;
import java.util.Date;

@Getter //LOMBOK
@NoArgsConstructor //LOMBOK 기본 자동 생성자 추
@Entity //JPA - DB 데이터 작업 시 해당 클래스의 수정을 통해 작업 (테이블과 링크)
public class Maps extends BaseTimeEntity {

    @Id //PK필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK 생성 규칙, IDENTITY 사용 시 Auto_increment 사용 가능
    private Long id;

    @Column(length = 500, nullable = false)
    private String mapnum;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String gps_x;
    private String gps_y;
    private String mapdate;

    @Builder //해당 클래스의 빌더 패턴 클래스 생성
    public Maps(String mapnum, String title, String content, String gps_x, String gps_y, String mapdate) {
        this.mapnum = mapnum;
        this.title = title;
        this.content = content;
        this.gps_x = gps_x;
        this.gps_y = gps_y;
        this.mapdate = mapdate;
    }

    /*
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
    */
}


