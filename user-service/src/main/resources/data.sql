CREATE TABLE users (
                       individual_number BIGINT PRIMARY KEY,
                       first_name VARCHAR(255),
                       last_name VARCHAR(255),
                       phone_number VARCHAR(20)
);


INSERT INTO users (individual_number, first_name, last_name, phone_number)
VALUES (1, 'Иван', 'Иванов', '1234567890');

INSERT INTO users (individual_number, first_name, last_name, phone_number)
VALUES (2, 'Петр', 'Петров', '0987654321');

INSERT INTO users (individual_number, first_name, last_name, phone_number)
VALUES (3, 'Даша', 'Метелькина', '0981654321');
