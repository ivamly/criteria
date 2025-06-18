package org.ivamly.criteria.composite;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class LogicalGroup extends CriteriaComponent {
    private LogicalOperator logicalOperator;
    private List<CriteriaComponent> criteriaComponents;
}
