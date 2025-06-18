package org.ivamly.criteria.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateCriteriaGroupRs {
    private UUID id;
    private UUID reportId;
    private String criteriaGroup;
}
