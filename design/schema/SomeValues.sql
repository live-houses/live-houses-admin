SELECT * FROM account;

--This adds some values to the tables of roles and accounts
INSERT INTO role (id, role_name, permissions)
VALUES (1, 'admin1', 11);
INSERT INTO role (id, role_name, permissions)
VALUES (2, 'admin2', 10);
INSERT INTO role (id, role_name, permissions)
VALUES (3, 'normal_user', 00);
INSERT INTO account (id, role_id, username, email, hashed_password, salt) 
VALUES (1, 2,'Paolo Flores', 'unmsm', 123, 45);
INSERT INTO account (id, role_id, username, email, hashed_password, salt) 
VALUES (2, 2,'Rodrigo Alva', 'unmsm', 123, 45);