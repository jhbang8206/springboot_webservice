package org.sb.ws.springboot.web.dto;

import lombok.Getter;
import org.sb.ws.springboot.domain.map.Maps;
import java.time.LocalDateTime;

@Getter
public class MapsListResponseDto {
    private Long id;
    private String mapnum;
    private String title;
    private String content;
    private LocalDateTime modifiedDate;

    public MapsListResponseDto(Maps entity) {
        this.mapnum = entity.getMapnum();
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.modifiedDate = entity.getModifiedDate();
    }
}
