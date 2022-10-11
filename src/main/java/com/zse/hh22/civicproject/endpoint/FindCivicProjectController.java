package com.zse.hh22.civicproject.endpoint;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zse.hh22.civicproject.api.CivicProjectDTO;
import com.zse.hh22.civicproject.service.FindCivicProjectService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/civicproject")
public class FindCivicProjectController {

    private final FindCivicProjectService findCivicProjectService;

    @GetMapping("/{title}")
    public ResponseEntity<CivicProjectDTO> findCivicProjectByTitle(@PathVariable String title) {
        return ResponseEntity.ok(findCivicProjectService.findCivicProjectEntityByTitleAndGetDTO(title));
    }

}
