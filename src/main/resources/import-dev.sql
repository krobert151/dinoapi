insert into person (id, username, password, name, last_name, email, phone_number, account_non_expired, account_non_locked, credentials_non_expired, enabled) values ('80d768ef-831a-4cfe-94e6-fda1eb4452a6', 'rducker0', '{bcrypt}$2a$10$fHQTADM5GIlB1kIOR7iabON8te6lbUuH/6jlyjTo1zE/vHGJ14LrK', 'Rikki', 'Ducker', 'rducker0@epa.gov', '451-536-9651', true, true, true, true);
insert into admin (id, puesto) values ('80d768ef-831a-4cfe-94e6-fda1eb4452a6','administrator');
insert into person_roles (roles, person_id) values (0 ,'80d768ef-831a-4cfe-94e6-fda1eb4452a6');

insert into dinosaur (id, cientific_name, name, height, length, num_theeth, weight) values ('80d768ef-831a-4cfe-94e6-fda1eb4452a3', 'tiranosaurus-rex', 'tiranosaurus', 5, 12, 100, 6000);