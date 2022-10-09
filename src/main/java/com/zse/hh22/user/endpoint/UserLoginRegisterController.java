package com.zse.hh22.user.endpoint;

import com.zse.hh22.user.api.UserCredentialsDTO;
import com.zse.hh22.user.api.UserDTO;
import com.zse.hh22.user.api.UserRegisterDTO;
import com.zse.hh22.user.service.UserLoginService;
import com.zse.hh22.user.service.UserRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user/")
class UserLoginRegisterController {

    private final UserRegisterService userRegisterService;
    private final UserLoginService userLoginService;

    @PostMapping("register")
    public ResponseEntity<Void> registerNewUser(@RequestBody UserRegisterDTO requestDTO) {
        userRegisterService.registerNewUser(requestDTO);
        return ResponseEntity.ok().build();
    }

    @PostMapping("login")
    public ResponseEntity<UserDTO> userLogin(@RequestBody UserCredentialsDTO requestDTO) {
        return ResponseEntity.ok(userLoginService.userLogin(requestDTO));
    }
}
