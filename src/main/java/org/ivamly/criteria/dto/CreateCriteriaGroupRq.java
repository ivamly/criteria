package org.ivamly.criteria.dto;

import lombok.Data;
import org.ivamly.criteria.composite.Group;

import java.util.UUID;

@Data
public class CreateCriteriaGroupRq {
    private UUID reportId;
    private Group group;
}
