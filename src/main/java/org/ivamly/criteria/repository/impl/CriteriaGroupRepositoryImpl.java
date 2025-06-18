package org.ivamly.criteria.repository.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.ivamly.criteria.dto.CreateCriteriaGroupRq;
import org.ivamly.criteria.dto.CreateCriteriaGroupRs;
import org.ivamly.criteria.generated.Tables;
import org.ivamly.criteria.repository.AbstractJooqRepository;
import org.ivamly.criteria.repository.CriteriaGroupRepository;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CriteriaGroupRepositoryImpl extends AbstractJooqRepository implements CriteriaGroupRepository {

    private final ObjectMapper objectMapper;

    @Override
    public CreateCriteriaGroupRs create(CreateCriteriaGroupRq request) {
        UUID criteriaGroupId = UUID.randomUUID();
        String criteriaGroupJson = getCriteriaGroupJson(request);

        return Objects.requireNonNull(dslContext.insertInto(Tables.CRITERIA_GROUP)
                        .set(Tables.CRITERIA_GROUP.ID, criteriaGroupId)
                        .set(Tables.CRITERIA_GROUP.REPORT_ID, request.getReportId())
                        .set(Tables.CRITERIA_GROUP.CRITERIA_GROUP_DATA, criteriaGroupJson)
                        .returning(Tables.CRITERIA_GROUP.ID,
                                Tables.CRITERIA_GROUP.REPORT_ID,
                                Tables.CRITERIA_GROUP.CRITERIA_GROUP_DATA)
                        .fetchOne())
                .map(record -> {
                    CreateCriteriaGroupRs response = new CreateCriteriaGroupRs();
                    response.setId(record.get(Tables.CRITERIA_GROUP.ID));
                    response.setReportId(record.get(Tables.CRITERIA_GROUP.REPORT_ID));
                    response.setCriteriaGroup(record.get(Tables.CRITERIA_GROUP.CRITERIA_GROUP_DATA));
                    return response;
                });
    }

    private String getCriteriaGroupJson(CreateCriteriaGroupRq request) {
        try {
            return objectMapper.writeValueAsString(request.getCriteriaGroup());
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
