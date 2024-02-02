package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.PostJpaDto;
import com.chuwa.redbook.service.PostJpaService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author Diana
 */
@RestController
@RequestMapping("/api/v1")
public class PostController {
    private static final Logger log = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private PostJpaService postJpaService;

    @PostMapping("/posts")
    public ResponseEntity<?> createPost(@RequestBody PostJpaDto postDto,
                                        @CookieValue(name = "cookieFromReq", defaultValue = "defaultCookieValue") String cookieValue,
                                        HttpServletRequest request, HttpServletResponse response) {
        try {
            // 记录请求信息
            log.info("Request URI: " + request.getRequestURI());
            log.info("Request Method: " + request.getMethod());

            PostJpaDto postResponse = postJpaService.createPost(postDto);

            // 创建并添加 Cookie
            Cookie cookie = new Cookie("myCookieName", "myCookieValue");
            response.addCookie(cookie);

            return new ResponseEntity<>(postResponse, HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            String error = "A post with the same information already exists.";
            return new ResponseEntity<>(error, HttpStatus.CONFLICT);
        }
    }

}
