package com.zse.hh22.user.endpoint;

import com.zse.hh22.user.api.UserCredentialsDTO;
import com.zse.hh22.user.api.UserDTO;
import com.zse.hh22.user.api.UserRegisterDTO;
import com.zse.hh22.user.service.UserLoginService;
import com.zse.hh22.user.service.UserRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
class UserLoginRegisterController {

    private final UserRegisterService userRegisterService;
    private final UserLoginService userLoginService;

    @PostMapping("/new")
    public ResponseEntity<Void> registerNewUser(@Valid @RequestBody UserRegisterDTO requestDTO) {
        userRegisterService.registerNewUser(requestDTO);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<UserDTO> userLogin(@Valid @RequestBody UserCredentialsDTO requestDTO) {
        return ResponseEntity.ok(userLoginService.userLogin(requestDTO));
    }
}
