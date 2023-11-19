INSERT INTO public.addresses(
     city, country, number, street)
VALUES ( 'Novi Sad', 'Serbia', '37', 'Dimitrija Tucovica');

INSERT INTO addresses(
     city, country, number, street)
VALUES ( 'Belgrad', 'Serbia', '45', 'Knez Mihailova');

INSERT INTO addresses(
     city, country, number, street)
VALUES ( 'Nis', 'Serbia', '60', 'Mileve Maric');


INSERT INTO role(
    id, name)
VALUES (1, 'REGISTERED_USER');

INSERT INTO role(
    id, name)
VALUES (2, 'COMPANY_ADMIN');

INSERT INTO role(
    id, name)
VALUES (3, 'SYSTEM_ADMIN');


INSERT INTO users(
     email, enabled, first_name, last_name, occupation, password, phone_number, address_id)
VALUES ( 'taraboskovic066@gmail.com', false, 'Tara', 'Boskovic', 'student', '123', '066-2678-772', 1);

INSERT INTO users(
     email, enabled, first_name, last_name, occupation, password, phone_number, address_id)
VALUES ( 'example@gmail.com', false, 'Milos', 'Milosevic', 'doctor', '2670', '064-3782-892', 2);

INSERT INTO users(
     email, enabled, first_name, last_name, occupation, password, phone_number, address_id)
VALUES ( 'nikolinaskiljevic@gmail.com',false, 'Nikolina', 'Skiljevic', 'nurse', '36782',  '069-3782-738', 3);



INSERT INTO user_role(
    role_id, user_id)
VALUES (1, 1);

INSERT INTO user_role(
    role_id, user_id)
VALUES (1, 2);

INSERT INTO user_role(
    role_id, user_id)
VALUES (2, 3);



INSERT INTO registered_users(
    penalty_points, id, user_category)
VALUES (3, 1, 'REGULAR');

INSERT INTO registered_users(
    penalty_points, id, user_category)
VALUES (100, 2, 'GOLD');

INSERT INTO registered_users(
    penalty_points, id, user_category)
VALUES (27, 3, 'SILVER');