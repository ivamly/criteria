package org.ivamly.criteria.composite;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Group extends Composite {
    private LogicalOperator logicalOperator;
    private List<Composite> composites;

    public Group() {
        super(Type.GROUP);
    }
}
