package org.ivamly.criteria.repository;

import org.ivamly.criteria.dto.CreateCriteriaGroupRq;
import org.ivamly.criteria.dto.CreateCriteriaGroupRs;

public interface CriteriaGroupRepository {

    CreateCriteriaGroupRs create(CreateCriteriaGroupRq request);
}
