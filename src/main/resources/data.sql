-- -- czyszczenie zawartości przy restarcie aplikacji
-- DELETE FROM users_roles WHERE users_user_id = 1 and roles_role_id = 1;
-- DELETE FROM users_roles WHERE users_user_id = 1 and roles_role_id = 2;
-- DELETE FROM users WHERE user_id = 1;
-- DELETE FROM roles WHERE role_id = 1;
-- DELETE FROM roles WHERE role_id = 2;

-- dodanie nowego użytkownika przy starcie aplikacji
INSERT INTO users VALUES (1, 'testowy1','test123');
-- dodatnie roli do nowego użytkownika
INSERT INTO roles VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles VALUES (2, 'ROLE_USER');
-- INSERT INTO users_roles VALUES (1, 1);
-- INSERT INTO users_roles VALUES (2, 1);