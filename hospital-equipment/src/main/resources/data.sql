INSERT INTO public.addresses(
     city, country, number, street)
VALUES ( 'Novi Sad', 'Serbia', '37', 'Dimitrija Tucovica');

INSERT INTO addresses(
     city, country, number, street)
VALUES ( 'Belgrad', 'Serbia', '45', 'Knez Mihailova');

INSERT INTO addresses(
     city, country, number, street)
VALUES ( 'Nis', 'Serbia', '60', 'Mileve Maric');
INSERT INTO addresses(
     city, country, number, street)
VALUES ( 'Trebinje', 'Bih', '60', 'Nemanjina');

INSERT INTO addresses(
     city, country, number, street)
VALUES ( 'Bijeljina', 'Bih', '50', 'Vozda Karadjordja');

INSERT INTO addresses(
     city, country, number, street)
VALUES ( 'Kragujevac', 'Serbia', '10', 'Mileve Maric');


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
VALUES ( 'taraboskovic066@gmail.com', false, 'Tara', 'Boskovic', 'student', '123', '066-2678-772',1);

INSERT INTO users(
     email, enabled, first_name, last_name, occupation, password, phone_number, address_id)
VALUES ( 'example@gmail.com', false, 'Milos', 'Milosevic', 'doctor', '2670', '064-3782-892', 2);

INSERT INTO users(
     email, enabled, first_name, last_name, occupation, password, phone_number, address_id)
VALUES ( 'nikolinaskiljevic@gmail.com',false, 'Nikolina', 'Skiljevic', 'nurse', '36782',  '069-3782-738', 3);
INSERT INTO users(
     email, enabled, first_name, last_name, occupation, password, phone_number, address_id)
VALUES ( 'janko@gmail.com',false, 'Janko', 'Jankovic', 'nurse', '36782',  '069-3782-738', 4);

INSERT INTO users(
     email, enabled, first_name, last_name, occupation, password, phone_number, address_id)
VALUES ( 'marko@gmail.com',false, 'Marko', 'Markovic', 'nurse', '222345',  '069-3782-738', 5);

INSERT INTO users(
     email, enabled, first_name, last_name, occupation, password, phone_number, address_id)
VALUES ( 'Mirko@gmail.com',false, 'Mirko', 'Mirkovic', 'nurse', '36782',  '069-3782-738', 6);



INSERT INTO user_role(
    role_id, user_id)
VALUES (1, 1);

INSERT INTO user_role(
    role_id, user_id)
VALUES (1, 2);

INSERT INTO user_role(
    role_id, user_id)
VALUES (2, 3);
INSERT INTO user_role(
    role_id, user_id)
VALUES (2, 4);

INSERT INTO user_role(
    role_id, user_id)
VALUES (2, 5);

INSERT INTO user_role(
    role_id, user_id)
VALUES (2, 6);


INSERT INTO loyalty_program(
    discount_percentage, penalty_threshold, points_per_equipment)
VALUES (10, 1, 10);

INSERT INTO loyalty_program(
    discount_percentage, penalty_threshold, points_per_equipment)
VALUES (20, 2, 10);

INSERT INTO loyalty_program(
    discount_percentage, penalty_threshold, points_per_equipment)
VALUES (30, 3, 10);


INSERT INTO registered_users(
    penalty_points, id,loyalty_id, user_category)
VALUES (3, 1,1, 'REGULAR');

INSERT INTO registered_users(
    penalty_points, id,loyalty_id, user_category)
VALUES (100, 2, 2,'GOLD');

INSERT INTO registered_users(
    penalty_points, id,loyalty_id, user_category)
VALUES (27, 3,3, 'SILVER');

INSERT INTO company(
     name, description, grade, address_id)
VALUES ( 'Corpore Sano', 'The best service', 5, 1);

INSERT INTO company(
     name, description, grade, address_id)
VALUES ( 'Health Company', 'Safe with us', 4, 2);

INSERT INTO company(
     name, description, grade, address_id)
VALUES ( 'HealthGroup', 'Best service', 4, 3);



INSERT INTO equipments(
     amount, grade, description, name,type)
VALUES ( 50, 5, 'Metal', 'Scissors','Strong');

INSERT INTO equipments(
     amount, grade, description, name,type)
VALUES ( 2000, 4, 'Medical', 'Gloves','Type1');

INSERT INTO equipments(
     amount, grade, description, name,type)
VALUES ( 500, 5, 'Cotton', 'Coat','White');

INSERT INTO equipments(
     amount, grade, description, name,type)
VALUES ( 500, 5, 'elastic', 'Bandage','Hard');

INSERT INTO company_administrators(
     company_id, id)
VALUES ( 1,3);
INSERT INTO company_administrators(
     company_id, id)
VALUES ( 1,6);
INSERT INTO company_administrators(
     company_id, id)
VALUES ( 2,4);
INSERT INTO company_administrators(
     company_id, id)
VALUES ( 3,5);


INSERT INTO public.equipment_stock(
	amount, company_id, equipment_id, id)
	VALUES (10, 1, 1, 1);
INSERT INTO public.equipment_stock(
	amount, company_id, equipment_id, id)
	VALUES (11, 2, 1, 2);

INSERT INTO public.equipment_stock(
	amount, company_id, equipment_id, id)
	VALUES (3, 3, 2, 3);

