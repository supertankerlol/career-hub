package com.careerhub.core.vacancy.dto;

import com.careerhub.core.vacancy.Vacancy;
import com.careerhub.core.vacancy.VacancyStatus;
import com.careerhub.core.vacancy.VacancyType;

import java.time.Instant;

public record VacancyResponse(
        Long id,
        String title,
        String description,
        VacancyType type,
        String location,
        boolean remote,
        Integer salaryMin,
        Integer salaryMax,
        VacancyStatus status,
        Instant createdAt
) {
    public static VacancyResponse from(Vacancy v) {
        return new VacancyResponse(
                v.getId(), v.getTitle(), v.getDescription(), v.getType(),
                v.getLocation(), v.isRemote(), v.getSalaryMin(), v.getSalaryMax(),
                v.getStatus(), v.getCreatedAt()
        );
    }
}