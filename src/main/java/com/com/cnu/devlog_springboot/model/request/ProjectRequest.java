package com.com.cnu.devlog_springboot.model.request;

import java.time.LocalDate;
import com.com.cnu.devlog_springboot.model.Project;

public record ProjectRequest(
        String title,
        String summary,
        String contents,
        LocalDate startDate,
        LocalDate endDate
) {
    public Project toProject() {
        return new Project(
                null,
                title,
                summary,
                contents,
                startDate,
                endDate
        );
    }
}
