SELECT * FROM account;

--This adds some values to the tables of roles and accounts
INSERT INTO role (id, role_name, permissions)
VALUES (3, 'admin1', 00101010);
INSERT INTO account (id, role_id, username, email, hashed_password, salt) 
VALUES (2, 3,'admin1', 'unmsm', 123, 45);