package org.ivamly.criteria.composite;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

import java.util.UUID;

@Data
@JsonTypeName("criteria")
public class Criteria implements Composite {
    private UUID criteriaId;
}
