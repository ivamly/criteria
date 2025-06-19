package org.ivamly.criteria.composite;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Criteria.class, name = "CRITERIA"),
        @JsonSubTypes.Type(value = Group.class, name = "GROUP")
})
@Getter
@RequiredArgsConstructor
public abstract class Composite {
    private final Type type;
}