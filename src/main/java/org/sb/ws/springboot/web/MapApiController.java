package org.sb.ws.springboot.web;

import lombok.RequiredArgsConstructor;
import org.sb.ws.springboot.service.MapsService;
import org.sb.ws.springboot.web.dto.MapsSaveRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MapApiController {

    private final MapsService mapsService;

    @PostMapping("/api/v1/maps")
    public Long save(@RequestBody MapsSaveRequestDto requestsDto) {

        return mapsService.save(requestsDto);
    }
}
