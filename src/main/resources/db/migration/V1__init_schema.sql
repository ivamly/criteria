SET search_path TO public;

CREATE TABLE IF NOT EXISTS report (
                                      id UUID PRIMARY KEY,
                                      name VARCHAR(255) NOT NULL,
                                      criteria_group jsonb
);

CREATE TABLE IF NOT EXISTS criteria (
                                        id UUID PRIMARY KEY,
                                        name VARCHAR(255) NOT NULL,
                                        report_id UUID NOT NULL,
                                        CONSTRAINT fk_criteria_report
                                            FOREIGN KEY (report_id) REFERENCES report(id)
);