package com.startfrombt.app.springboot.web;

import com.startfrombt.app.springboot.service.posts.PostsService;
import com.startfrombt.app.springboot.web.dto.PostsResponseDto;
import com.startfrombt.app.springboot.web.dto.PostsSaveRequestDto;
import com.startfrombt.app.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsController {

    private final PostsService postsService;

    // Posts 등록 API
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    // Posts 수정 API
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    // Posts 조회 API
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }
}
