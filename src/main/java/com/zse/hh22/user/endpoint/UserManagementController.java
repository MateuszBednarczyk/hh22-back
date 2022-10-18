package com.zse.hh22.user.endpoint;

import com.zse.hh22.user.api.ChangePasswordDTO;
import com.zse.hh22.user.service.UserManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user/management")
public class UserManagementController {

    private final UserManagementService userManagementService;

    @PatchMapping("/password")
    public ResponseEntity<Void> changePassword(Principal loggedUser, @RequestBody ChangePasswordDTO changePasswordDTO) {
        userManagementService.changePassword(loggedUser, changePasswordDTO);
        return ResponseEntity.ok().build();
    }

}
