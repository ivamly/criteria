package org.ivamly.criteria.repository.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.ivamly.criteria.composite.Group;
import org.ivamly.criteria.dto.CreateCriteriaGroupRq;
import org.ivamly.criteria.dto.CreateCriteriaGroupRs;
import org.ivamly.criteria.generated.Tables;
import org.ivamly.criteria.repository.AbstractJooqRepository;
import org.ivamly.criteria.repository.CriteriaGroupRepository;
import org.jooq.JSONB;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CriteriaGroupRepositoryImpl extends AbstractJooqRepository implements CriteriaGroupRepository {

    private final ObjectMapper objectMapper;

    @Override
    public CreateCriteriaGroupRs create(CreateCriteriaGroupRq request) {
        JSONB criteriaGroupJson = convertToJsonb(request.getGroup());

        UUID reportId = request.getReportId();

        return dslContext.update(Tables.REPORT)
                .set(Tables.REPORT.CRITERIA_GROUP, criteriaGroupJson)
                .where(Tables.REPORT.ID.eq(reportId))
                .returning(Tables.REPORT.ID, Tables.REPORT.CRITERIA_GROUP)
                .fetchOptional()
                .map(record -> {
                    CreateCriteriaGroupRs response = new CreateCriteriaGroupRs();
                    response.setReportId(record.get(Tables.REPORT.ID));
                    response.setCriteriaGroup(convertToGroup(record.get(Tables.REPORT.CRITERIA_GROUP)));
                    return response;
                })
                .orElseThrow(() -> new IllegalArgumentException("Report with id " + reportId + " not found"));
    }

    private JSONB convertToJsonb(Group group) {
        try {
            String json = objectMapper.writeValueAsString(group);
            return JSONB.valueOf(json);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Failed to serialize criteria group to JSONB", e);
        }
    }

    private Group convertToGroup(JSONB jsonb) {
        try {
            return objectMapper.readValue(jsonb.toString(), Group.class);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Failed to deserialize JSONB to criteria group", e);
        }
    }
}