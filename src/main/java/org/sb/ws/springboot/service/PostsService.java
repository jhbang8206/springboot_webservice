package org.sb.ws.springboot.service;

import lombok.RequiredArgsConstructor;
import org.sb.ws.springboot.domain.posts.Posts;
import org.sb.ws.springboot.domain.posts.PostsRepository;
import org.sb.ws.springboot.web.dto.PostsResponseDto;
import org.sb.ws.springboot.web.dto.PostsSaveRequestDto;
import org.sb.ws.springboot.web.dto.PostsUpdateRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestsDto) {
        return  postsRepository.save(requestsDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없숩니다. id =" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없숩니다. id =" + id));

        return new PostsResponseDto(entity);
    }
}
