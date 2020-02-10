package org.sb.ws.springboot.service;

import lombok.RequiredArgsConstructor;
import org.sb.ws.springboot.domain.map.MapsRepository;
import org.sb.ws.springboot.web.dto.MapsListResponseDto;
import org.sb.ws.springboot.web.dto.MapsSaveRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MapsService {
    private final MapsRepository mapsRepository;

    @Transactional
    public Long save(MapsSaveRequestDto requestsDto) {
        return mapsRepository.save(requestsDto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<MapsListResponseDto> findAllDesc() {
        return mapsRepository.findAllDesc().stream()
                .map(MapsListResponseDto::new)
                .collect(Collectors.toList());
    }

}
