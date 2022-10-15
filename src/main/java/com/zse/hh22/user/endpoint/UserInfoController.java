package com.zse.hh22.user.endpoint;

import com.zse.hh22.user.api.UserDTO;
import com.zse.hh22.user.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/user/info")
@RequiredArgsConstructor
public class UserInfoController {

    private final UserInfoService userInfoService;

    @GetMapping
    private ResponseEntity<UserDTO> getUserInfo(Principal loggedUser) {
        return ResponseEntity.ok(userInfoService.getUserInfo(loggedUser));
    }

}
