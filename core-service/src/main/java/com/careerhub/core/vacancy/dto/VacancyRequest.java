package com.careerhub.core.vacancy.dto;

import com.careerhub.core.vacancy.VacancyType;
import jakarta.validation.constraints.*;

public record VacancyRequest(
        @NotBlank @Size(max = 200) String title,
        @NotBlank String description,
        @NotNull VacancyType type,
        @Size(max = 100) String location,
        boolean remote,
        @PositiveOrZero Integer salaryMin,
        @PositiveOrZero Integer salaryMax
) {
}