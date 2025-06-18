package org.ivamly.criteria.composite;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Criteria.class, name = "criteria"),
        @JsonSubTypes.Type(value = CriteriaGroup.class, name = "group")
})
public interface Composite {
}
