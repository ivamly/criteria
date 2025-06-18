package org.ivamly.criteria.service.impl;

import lombok.RequiredArgsConstructor;
import org.ivamly.criteria.dto.CreateCriteriaGroupRq;
import org.ivamly.criteria.dto.CreateCriteriaGroupRs;
import org.ivamly.criteria.repository.CriteriaGroupRepository;
import org.ivamly.criteria.service.CriteriaGroupService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CriteriaGroupServiceImpl implements CriteriaGroupService {

    private final CriteriaGroupRepository criteriaGroupRepository;

    @Override
    public CreateCriteriaGroupRs create(CreateCriteriaGroupRq request) {
        return criteriaGroupRepository.create(request);
    }
}
