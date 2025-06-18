SET search_path TO public;

CREATE TABLE IF NOT EXISTS report (
                                      id UUID PRIMARY KEY,
                                      name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS criteria_group (
                                              id UUID PRIMARY KEY,
                                              criteria_group_data TEXT,
                                              report_id UUID NOT NULL,
                                              CONSTRAINT fk_criteria_group_report
                                                  FOREIGN KEY (report_id) REFERENCES report(id)
);

CREATE TABLE IF NOT EXISTS criteria (
                                        id UUID PRIMARY KEY,
                                        name VARCHAR(255) NOT NULL,
                                        report_id UUID NOT NULL,
                                        criteria_group_id UUID,
                                        CONSTRAINT fk_criteria_report
                                            FOREIGN KEY (report_id) REFERENCES report(id),
                                        CONSTRAINT fk_criteria_criteria_group
                                            FOREIGN KEY (criteria_group_id) REFERENCES criteria_group(id)
);