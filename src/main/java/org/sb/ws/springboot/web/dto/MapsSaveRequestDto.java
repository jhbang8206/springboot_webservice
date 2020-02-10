package org.sb.ws.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sb.ws.springboot.domain.map.Maps;

@Getter
@NoArgsConstructor
public class MapsSaveRequestDto {
    private String mapnum;
    private String title;
    private String content;
    private String gps_x;
    private String gps_y;
    private String mapdate;

    @Builder
    public MapsSaveRequestDto(String mapnum, String title, String content, String gps_x, String gps_y, String mapdate) {
        this.mapnum = mapnum;
        this.title = title;
        this.content = content;
        this.gps_x = gps_x;
        this.gps_y = gps_y;
        this.mapdate = mapdate;
    }

    public Maps toEntity() {
        return Maps.builder()
                .mapnum(mapnum)
                .title(title)
                .content(content)
                .gps_x(gps_x)
                .gps_y(gps_y)
                .mapdate(mapdate)
                .build();
    }
}
