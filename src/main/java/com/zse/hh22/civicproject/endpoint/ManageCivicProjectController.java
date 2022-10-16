package com.zse.hh22.civicproject.endpoint;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zse.hh22.civicproject.service.ManageCivicProjectService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/civicproject/management")
class ManageCivicProjectController{
    
    private final ManageCivicProjectService manageCivicProjectService;

    @PostMapping("/verify/{title}")
    public ResponseEntity<Void> setCivicProjectStateToVerified(@PathVariable String title) {
        manageCivicProjectService.setCivicProjectStateToVerified(title);
        return ResponseEntity.ok().build();
    }

}
