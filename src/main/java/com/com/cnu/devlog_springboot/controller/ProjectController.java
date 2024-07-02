package com.com.cnu.devlog_springboot.controller;

import com.com.cnu.devlog_springboot.model.Project;
import com.com.cnu.devlog_springboot.model.request.ProjectRequest;
import com.com.cnu.devlog_springboot.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    // GET /posts
    @GetMapping
    public ResponseEntity<List<Project>> findAll() {
        List<Project> projects = projectService.findAll();
        return ResponseEntity.ok(projects);
    }

    // GET /posts/{postId}
    @GetMapping("{projectId}")
    public ResponseEntity<Project> getById(
            @PathVariable("projectId") Long projectId
    ) {
        Project project = projectService.getById(projectId);
        return ResponseEntity.ok(project);
    }

    // POST /posts
    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody ProjectRequest projectRequest) {
        Project project = projectService.create(projectRequest);
        return ResponseEntity.ok(project);
    }

    // PUT /posts/{postId}
    // ex. localhost:8080/posts/3
    @PutMapping("{projectId}")
    public ResponseEntity<Project> updateProject(
            @PathVariable("projectId")Long projectId,
            @RequestBody ProjectRequest projectRequest
    ) {
        Project project = projectService.update(projectId, projectRequest);
        return ResponseEntity.ok(project);
    }

    // DELETE /posts/{postId}
    @DeleteMapping("{projectId}")
    public ResponseEntity<Void> deleteProject(
            @PathVariable("projectId") Long projectId
    ) {
        projectService.delete(projectId);
        return ResponseEntity.noContent().build();
    }
}
