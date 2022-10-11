package com.zse.hh22.civicproject.endpoint;

import java.security.Principal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zse.hh22.civicproject.service.LikeCivicProjectService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/civicproject/favourite")
public class LikeCivicProjectController {
    private final LikeCivicProjectService likeCivicProjectService;

    @PostMapping("/{title}")
    public ResponseEntity likeCivicProject(Principal loggedUser, @PathVariable String title) {
        likeCivicProjectService.likeCivicProject(loggedUser, title);
        return ResponseEntity.ok().build();
    }
}
