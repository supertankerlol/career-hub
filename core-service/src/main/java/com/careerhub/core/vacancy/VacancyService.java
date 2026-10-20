package com.careerhub.core.vacancy;

import com.careerhub.core.vacancy.dto.VacancyRequest;
import com.careerhub.core.vacancy.dto.VacancyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class VacancyService {

    private final VacancyRepository repository;

    @Transactional
    public VacancyResponse create(VacancyRequest request) {
        Vacancy vacancy = new Vacancy();
        apply(vacancy, request);
        return VacancyResponse.from(repository.save(vacancy));
    }

    @Transactional(readOnly = true)
    public VacancyResponse getById(Long id) {
        return VacancyResponse.from(find(id));
    }

    @Transactional(readOnly = true)
    public Page<VacancyResponse> list(Pageable pageable) {
        return repository.findAll(pageable).map(VacancyResponse::from);
    }

    @Transactional
    public VacancyResponse update(Long id, VacancyRequest request) {
        Vacancy vacancy = find(id);
        apply(vacancy, request);
        return VacancyResponse.from(vacancy);
    }

    @Transactional
    public void delete(Long id) {
        repository.delete(find(id));
    }

    private Vacancy find(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new VacancyNotFoundException(id));
    }

    private void apply(Vacancy v, VacancyRequest r) {
        v.setTitle(r.title());
        v.setDescription(r.description());
        v.setType(r.type());
        v.setLocation(r.location());
        v.setRemote(r.remote());
        v.setSalaryMin(r.salaryMin());
        v.setSalaryMax(r.salaryMax());
    }
}