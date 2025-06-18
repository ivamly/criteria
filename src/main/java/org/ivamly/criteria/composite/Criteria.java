package org.ivamly.criteria.composite;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class SimpleCriteria extends CriteriaComponent {
    private UUID criteriaId;
}
