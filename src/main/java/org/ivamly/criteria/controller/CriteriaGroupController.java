package org.ivamly.criteria.controller;

import lombok.RequiredArgsConstructor;
import org.ivamly.criteria.dto.CreateCriteriaGroupRq;
import org.ivamly.criteria.dto.CreateCriteriaGroupRs;
import org.ivamly.criteria.service.CriteriaGroupService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/criteria-groups")
@RequiredArgsConstructor
public class CriteriaGroupController {

    private final CriteriaGroupService criteriaGroupService;

    @PostMapping
    public CreateCriteriaGroupRs create(@RequestBody CreateCriteriaGroupRq request) {
        return criteriaGroupService.create(request);
    }
}