package org.ivamly.criteria.repository;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractJooqRepository {

    @Autowired
    protected DSLContext dslContext;
}
