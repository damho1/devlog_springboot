package com.com.cnu.devlog_springboot.repository;

import com.com.cnu.devlog_springboot.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.webjars.NotFoundException;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    default Project getById(Long id) {
        return findById(id).orElseThrow(() -> new NotFoundException("project 가 존재하지 않음"));
    }
}
