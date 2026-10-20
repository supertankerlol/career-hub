package com.careerhub.core.vacancy;

import com.careerhub.core.vacancy.dto.VacancyRequest;
import com.careerhub.core.vacancy.dto.VacancyResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vacancies")
@RequiredArgsConstructor
public class VacancyController {

    private final VacancyService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VacancyResponse create(@Valid @RequestBody VacancyRequest request) {
        return service.create(request);
    }

    @GetMapping("/{id}")
    public VacancyResponse get(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public Page<VacancyResponse> list(Pageable pageable) {
        return service.list(pageable);
    }

    @PutMapping("/{id}")
    public VacancyResponse update(@PathVariable Long id, @Valid @RequestBody VacancyRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}