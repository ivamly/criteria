package org.ivamly.criteria.service;

import org.ivamly.criteria.dto.CreateCriteriaGroupRq;
import org.ivamly.criteria.dto.CreateCriteriaGroupRs;

public interface CriteriaGroupService {

    CreateCriteriaGroupRs create(CreateCriteriaGroupRq request);
}
