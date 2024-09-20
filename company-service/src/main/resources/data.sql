CREATE TABLE company (
                         id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                         name VARCHAR(255),
                         budget DECIMAL(15, 2)
);

CREATE TABLE company_employee_ids (
                                      company_id BIGINT NOT NULL,
                                      employee_ids BIGINT NOT NULL,
                                      PRIMARY KEY (company_id, employee_ids),
                                      FOREIGN KEY (company_id) REFERENCES company(id)
);

INSERT INTO company (name, budget) VALUES ('TechCorp', 1000000);
INSERT INTO company (name, budget) VALUES ('DevSolutions', 500000);

INSERT INTO company_employee_ids (company_id, employee_ids) VALUES (1, 1);
INSERT INTO company_employee_ids (company_id, employee_ids) VALUES (1, 2);

INSERT INTO company_employee_ids (company_id, employee_ids) VALUES (2, 2);