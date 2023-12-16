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
VALUES (1, 'ROLE_REGISTERED_USER');

INSERT INTO role(
    id, name)
VALUES (2, 'ROLE_COMPANY_ADMIN');

INSERT INTO role(
    id, name)
VALUES (3, 'ROLE_SYSTEM_ADMIN');


INSERT INTO users(
    email, enabled, first_name, last_name,username ,occupation, password, phone_number, address_id)
VALUES ( 'taraboskovic066@gmail.com', true, 'Tara', 'Boskovic','taric', 'student', '$2a$10$mD0kgZJFbHEdEM5ICKJbgecF3qjIzP.i3zVV.nszlWh8Adp4gs4K6', '066-2678-772', 1);


INSERT INTO users(
    email, enabled, first_name, last_name,username, occupation, password, phone_number, address_id)
VALUES ( 'example@gmail.com', false, 'Milos', 'Milosevic','anic', 'doctor', '2670', '064-3782-892', 2);

INSERT INTO users(
    email, enabled, first_name, last_name,username, occupation, password, phone_number, address_id)
VALUES ( 'nikolinaskiljevic@gmail.com',false, 'Nikolina', 'Skiljevic','aaa', 'nurse', '36782',  '069-3782-738', 3);
INSERT INTO users(
    email, enabled, first_name, last_name,username, occupation, password, phone_number, address_id)
VALUES ( 'janko@gmail.com',false, 'Janko', 'Jankovic','aaa', 'nurse', '36782',  '069-3782-738', 4);

INSERT INTO users(
    email, enabled, first_name, last_name, username, occupation, password, phone_number, address_id)
VALUES ( 'marko@gmail.com',false, 'Marko', 'Markovic', 'aaa', 'nurse', '222345',  '069-3782-738', 5);

INSERT INTO users(
    email, enabled, first_name, last_name,username, occupation, password, phone_number, address_id)
VALUES ( 'Mirko@gmail.com',false, 'Mirko', 'Mirkovic','banana', 'nurse', '36782',  '069-3782-738', 6);



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





INSERT INTO company(name, description, grade, address_id, work_start_time, work_end_time)
VALUES ('Corpore Sano', 'The best service', 5, 1, '08:00:00', '17:00:00');

INSERT INTO company(name, description, grade, address_id, work_start_time, work_end_time)
VALUES ('Health Company', 'Safe with us', 4, 2, '08:00:00', '17:00:00');

INSERT INTO company(name, description, grade, address_id, work_start_time, work_end_time)
VALUES ('HealthGroup', 'Best service', 4, 3, '08:00:00', '17:00:00');


INSERT INTO company_administrators(
    company_id,id)
VALUES (3,1);
INSERT INTO company_administrators(
    company_id,id)
VALUES (1,3);
INSERT INTO company_administrators(
    company_id,id)
VALUES (1,4);

INSERT INTO company_administrators(
    company_id,id)
VALUES (2,5);
INSERT INTO company_administrators(
    company_id,id)
VALUES (2,6);


INSERT INTO equipments(
    amount, grade, description, name)
VALUES ( 50, 5, 'Strong', 'Scissors');

INSERT INTO equipments(
    amount, grade, description, name)
VALUES ( 2000, 4, 'Medical', 'Gloves');

INSERT INTO equipments(
    amount, grade, description, name)
VALUES ( 500, 5, 'Cotton', 'Coat');

INSERT INTO equipments(
    amount, grade, description, name)
VALUES ( 500, 5, 'elastic', 'Bandage');


INSERT INTO equipment_stock(
    amount, company_id, equipment_id)
VALUES ( 100,1,1);

INSERT INTO equipment_stock(
    amount, company_id, equipment_id)
VALUES ( 200,1,2);

INSERT INTO equipment_stock(
    amount, company_id, equipment_id)
VALUES ( 200,2,3);

INSERT INTO equipment_stock(
    amount, company_id, equipment_id)
VALUES ( 200,3,1);

INSERT INTO equipment_stock(
    amount, company_id, equipment_id)
VALUES ( 200,3,2);


INSERT INTO appointments(date, end_time, start_time, administrator_id,appointment_status)
VALUES ('2023-12-22', '10:00:00','08:00:00', 3, 'TAKEN');

INSERT INTO appointments(date, end_time, start_time, administrator_id,  appointment_status)
VALUES ('2023-12-26', '10:00:00','08:00:00', 3,'PREDEFINED');

INSERT INTO appointments(date, end_time, start_time, administrator_id, appointment_status)
VALUES ('2023-12-27', '10:30:00','08:00:00', 4, 'PREDEFINED');

INSERT INTO appointments(date, end_time, start_time, administrator_id, appointment_status)
VALUES ('2023-12-27', '10:30:00','08:00:00', 4, 'PREDEFINED');

