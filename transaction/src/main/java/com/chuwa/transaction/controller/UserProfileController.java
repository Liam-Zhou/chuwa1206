package com.chuwa.transaction.controller;

import com.chuwa.transaction.payload.UserProfileDto;
import com.chuwa.transaction.service.UserProfileService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserProfileController {
    private final UserProfileService userProfileService;
    private static final Logger logger = LoggerFactory.getLogger(UserProfileController.class);

    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @PostMapping
    public ResponseEntity<UserProfileDto> createUserProfile(@RequestBody UserProfileDto userProfileDto) {
        UserProfileDto user = this.userProfileService.createUserProfile(userProfileDto);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<UserProfileDto>> getAllUserProfiles() {
        List<UserProfileDto> res = this.userProfileService.getAllUserProfiles();
        return ResponseEntity.ok(res);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserProfileDto> updateUserProfilesById(@PathVariable(name = "id") long id, @RequestBody UserProfileDto userProfileDto) {
        UserProfileDto updated = this.userProfileService.updateUserProfile(userProfileDto, id);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserProfileById(@PathVariable(name="id") long id) {
        this.userProfileService.deleteUserProfileById(id);
        return new ResponseEntity<>("Delete successfully", HttpStatusCode.valueOf(200));
    }

    @PostMapping("/{id}/login")
    public ResponseEntity<String> exampleMethod(HttpServletResponse response, HttpServletRequest request,
                                                @CookieValue(value = "exampleCookie", defaultValue = "defaultValue") String exampleCookie) {
        try {
            logger.info("exampleCookie: {}", exampleCookie);
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    logger.info("Cookie Name: {}, Value: {}", cookie.getName(), cookie.getValue());
                }
            } else {
                logger.info("No cookies present in the request.");
            }
            logger.info("request.getMethod {}", request.getMethod());

            // Add a cookie to the response
            Cookie cookie = new Cookie("exampleCookie", "cookieValue");
            cookie.setMaxAge(3600); // Set the cookie's expiration time in seconds
            response.addCookie(cookie);

            // Set custom headers in the response
            HttpHeaders headers = new HttpHeaders();
            headers.add("Custom-Header", "headerValue");
            response.addHeader("Another-Custom-Header", "anotherHeaderValue");


            // Return a response
            return ResponseEntity.ok()
                    .headers(headers)
                    .contentType(MediaType.TEXT_PLAIN)
                    .body("API called successfully. Check the response's cookies and headers.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error occurred during API call.");
        }
    }

}
