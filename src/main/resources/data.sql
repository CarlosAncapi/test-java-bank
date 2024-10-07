-- Insertando clientes con los campos de fechas y el campo is_active
INSERT INTO clients (name, email, password, created, modified, last_login, is_active)
VALUES ('Manuel Contreras', 'manuel.contreras@gmail.com', 'contra1234', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, TRUE);

INSERT INTO clients (name, email, password, created, modified, last_login, is_active)
VALUES ('Vanessa Riquelme', 'vanessa.riquelme@gmail.com', 'contra12345', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, TRUE);

-- Insertando teléfonos sin modificaciones
INSERT INTO phones (number, city_code, country_code)
VALUES ('123456789', '11', '1');

INSERT INTO phones (number, city_code, country_code)
VALUES ('987654321', '22', '1');

-- Insertando en la tabla intermedia client_phone para relacionar clientes con teléfonos
INSERT INTO client_phone (client_id, phone_id)
VALUES (1, 1);

INSERT INTO client_phone (client_id, phone_id)
VALUES (2, 2);