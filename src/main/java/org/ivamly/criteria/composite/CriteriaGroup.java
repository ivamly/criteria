package org.ivamly.criteria.composite;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

import java.util.List;

@Data
@JsonTypeName("group")
public class CriteriaGroup implements Composite {
    private LogicalOperator logicalOperator;
    private List<Composite> composites;
}
