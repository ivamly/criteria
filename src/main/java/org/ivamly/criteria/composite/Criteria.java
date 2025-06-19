package org.ivamly.criteria.composite;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Criteria extends Composite {
    private UUID criteriaId;

    public Criteria() {
        super(Type.CRITERIA);
    }
}
