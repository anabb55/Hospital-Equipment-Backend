INSERT INTO public.addresses(
    city, country, number, street,latitude,longitude)
VALUES ( 'Novi Sad', 'Serbia', '37', 'Dimitrija Tucovica','45.24702032809865', '19.840907344141257');

INSERT INTO addresses(
    city, country, number, street,latitude,longitude)
VALUES ( 'Belgrad', 'Serbia', '45', 'Knez Mihailova','44.818869399625825', '20.455416881235333');

INSERT INTO addresses(city, country, number, street, latitude, longitude)
VALUES ('Novi Sad', 'Serbia', '60', 'Mileve Maric', '45.254191', '19.845277');
INSERT INTO addresses(
    city, country, number, street,latitude,longitude)
VALUES ( 'Trebinje', 'Bih', '1', 'Knez Mihajlova','42.71764591197575', '18.353486891668506');

INSERT INTO addresses(
    city, country, number, street,latitude,longitude)
VALUES ( 'Nis', 'Serbia', '13', 'Vozda Karadjordja','43.32111628016304', '21.897958796493494');

INSERT INTO addresses(
    city, country, number, street,latitude,longitude)
VALUES ( 'Beograd', 'Serbia', '36', 'Nemanjina','44.802974458685824', '20.464545191207794');
INSERT INTO addresses(city, country, number, street, latitude, longitude)
VALUES ('Novi Sad', 'Serbia', '22', 'Dunavska', '45.255783', '19.842033');
INSERT INTO addresses(city, country, number, street, latitude, longitude)
VALUES ('Niš', 'Serbia', '55', 'Obrenovićeva', '43.320902', '21.895758');
INSERT INTO addresses(city, country, number, street, latitude, longitude)
VALUES ('Kragujevac', 'Serbia', '77', 'Kneza Miloša', '44.012793', '20.926231');
INSERT INTO addresses(city, country, number, street, latitude, longitude)
VALUES ('Subotica', 'Serbia', '10', 'Trg Slobode', '46.100271', '19.667762');



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
    email, enabled, firstname, lastname,username ,occupation, password, phone_number, address_id,waslogged)
VALUES ( 'dajanaskocajic18@gmail.com', true, 'Tara', 'Boskovic','taric', 'student', '$2a$10$mD0kgZJFbHEdEM5ICKJbgecF3qjIzP.i3zVV.nszlWh8Adp4gs4K6', '066-2678-772', 1,false);

INSERT INTO users(
    email, enabled, firstname, lastname,username, occupation, password, phone_number, address_id,waslogged)

VALUES ( 'h.jovix@gmail.com', true, 'Milos', 'Milosevic','anic', 'doctor', '$2a$10$mD0kgZJFbHEdEM5ICKJbgecF3qjIzP.i3zVV.nszlWh8Adp4gs4K6', '064-3782-892', 2,false);


INSERT INTO users(
    email, enabled, firstname, lastname,username, occupation, password, phone_number, address_id,waslogged)
VALUES ( 'dajanaskocajic18@gmail.com',true, 'Nikolina', 'Skiljevic','nina', 'nurse', '$2a$10$mD0kgZJFbHEdEM5ICKJbgecF3qjIzP.i3zVV.nszlWh8Adp4gs4K6',  '069-3782-738', 3,false);
INSERT INTO users(
    email, enabled, firstname, lastname,username, occupation, password, phone_number, address_id,waslogged)
VALUES ( 'janko@gmail.com',true, 'Janko', 'Jankovic','aaa', 'nurse', '$2a$10$mD0kgZJFbHEdEM5ICKJbgecF3qjIzP',  '069-3782-738', 4,false);

INSERT INTO users(
    email, enabled, firstname, lastname, username, occupation, password, phone_number, address_id,waslogged)
VALUES ( 'marko@gmail.com',true, 'Marko', 'Markovic', 'aaa', 'nurse', '$2a$10$mD0kgZJFbHEdEM5ICKJbgecF3qjIzP',  '069-3782-738', 5,false);

INSERT INTO users(
    email, enabled, firstname, lastname,username, occupation, password, phone_number, address_id,waslogged)
VALUES ( 'ana.boskovicc18@gmail.com',true, 'Mirko', 'Mirkovic','mikica', 'nurse', '$2a$10$WtyrzCE8BuUc.6hd/T66ZuX1HsfMqCXzORWIfgJayO6fvB36fK6dm',  '069-3782-738', 6,false);

INSERT INTO users(
    email, enabled, firstname, lastname,username, occupation, password, phone_number, address_id,waslogged)
VALUES ( 'ana.boskovicc18@gmail.com',true, 'Selena', 'Rakic','lenica', 'nurse', '$2a$10$WtyrzCE8BuUc.6hd/T66ZuX1HsfMqCXzORWIfgJayO6fvB36fK6dm',  '069-3782-738', 7,false);
INSERT INTO users(
    email, enabled, firstname, lastname,username, occupation, password, phone_number, address_id,waslogged)
VALUES ( 'ana.boskovicc18@gmail.com',true, 'Dajana', 'Kovacevic','dajanica', 'nurse', '$2a$10$WtyrzCE8BuUc.6hd/T66ZuX1HsfMqCXzORWIfgJayO6fvB36fK6dm',  '069-3782-738', 8,false);
INSERT INTO users(
    email, enabled, firstname, lastname,username, occupation, password, phone_number, address_id,waslogged)
VALUES ( 'ana.boskovicc18@gmail.com',true, 'Nina', 'Srajer','ninica', 'nurse', '$2a$10$mD0kgZJFbHEdEM5ICKJbgecF3qjIzP.i3zVV.nszlWh8Adp4gs4K6',  '069-3782-738', 9,false);


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

INSERT INTO user_role(
    role_id, user_id)
VALUES (2, 7);

INSERT INTO user_role(
    role_id, user_id)
VALUES (2, 8);

INSERT INTO user_role(
    role_id, user_id)
VALUES (3, 9);





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
    accumulated_points, penalty_points, id, loyalty_id, user_category)
VALUES (0, 0, 1, 1, 'REGULAR');

INSERT INTO registered_users(
    accumulated_points, penalty_points, id, loyalty_id, user_category)
VALUES (0, 0, 2, 1, 'REGULAR');




INSERT INTO company(name, description, grade, address_id, work_start_time, work_end_time)
VALUES ('Corpore Sano', 'The best service', 5, 2, '08:00:00', '17:00:00');

INSERT INTO company(name, description, grade, address_id, work_start_time, work_end_time)
VALUES ('Health Company', 'Safe with us', 4, 1, '08:00:00', '17:00:00');

INSERT INTO company(name, description, grade, address_id, work_start_time, work_end_time)
VALUES ('HealthGroup', 'Best service', 4, 3, '08:00:00', '17:00:00');



INSERT INTO company_administrators(
    company_id,id)
VALUES (1,3);
INSERT INTO company_administrators(
    company_id,id)
VALUES (1,4);

INSERT INTO company_administrators(
    company_id,id)
VALUES (1,5);
INSERT INTO company_administrators(
    company_id,id)
VALUES (1,6);
INSERT INTO company_administrators(
    company_id,id)
VALUES (2,7);
INSERT INTO company_administrators(
    company_id,id)
VALUES (3,8);





INSERT INTO equipments(
    amount, grade, description, name,price)
VALUES ( 50, 5, 'Strong', 'Scissors', 0);

INSERT INTO equipments(
    amount, grade, description, name, price)
VALUES ( 2000, 4, 'Medical', 'Gloves',0);

INSERT INTO equipments(
    amount, grade, description, name, price)
VALUES ( 500, 5, 'Cotton', 'Coat', 0);

INSERT INTO equipments(
    amount, grade, description, name, price)
VALUES ( 500, 5, 'elastic', 'Bandage',0);


INSERT INTO equipment_stock (amount, company_id, equipment_id, price, version)
VALUES (100, 1, 1, 100, 0);

INSERT INTO equipment_stock (amount, company_id, equipment_id, price, version)
VALUES (200, 1, 2, 200, 0);

INSERT INTO equipment_stock (amount, company_id, equipment_id, price, version)
VALUES (200, 1, 3, 150, 0);

INSERT INTO equipment_stock (amount, company_id, equipment_id, price, version)
VALUES (200, 2, 1, 250, 0);

INSERT INTO equipment_stock (amount, company_id, equipment_id, price, version)
VALUES (200, 2, 2, 130, 0);

INSERT INTO equipment_stock (amount, company_id, equipment_id, price, version)
VALUES (200, 3, 1, 250, 0);

INSERT INTO equipment_stock (amount, company_id, equipment_id, price, version)
VALUES (200, 3, 2, 130, 0);



INSERT INTO appointments(date, end_time, start_time,version, administrator_id,appointment_status)
VALUES ('2024-02-12', '10:00:00','08:00:00',0, 3, 'TAKEN');

INSERT INTO appointments(date, end_time, start_time,version, administrator_id,appointment_status)
VALUES ('2024-02-10', '12:30:00','10:30:00',0, 3, 'TAKEN');

INSERT INTO appointments(date, end_time, start_time,version, administrator_id,appointment_status)
VALUES ('2024-02-09', '15:00:00','13:00:00',0, 3, 'TAKEN');

INSERT INTO appointments(date, end_time, start_time,version, administrator_id,appointment_status)
VALUES ('2024-02-09', '12:30:00','10:30:00',0, 3, 'TAKEN');

INSERT INTO appointments(date, end_time, start_time,version, administrator_id,  appointment_status)
VALUES ('2024-02-03', '10:00:00','08:00:00',0, 3,'PREDEFINED');

INSERT INTO appointments(date, end_time, start_time,version, administrator_id, appointment_status)
VALUES ('2024-02-04', '10:30:00','08:00:00',0, 4, 'PREDEFINED');

INSERT INTO appointments(date, end_time, start_time,version, administrator_id, appointment_status)
VALUES ('2024-02-04', '12:00:00','10:30:00',0, 5, 'PREDEFINED');

INSERT INTO appointments(date, end_time, start_time,version, administrator_id, appointment_status)
VALUES ('2024-02-05', '12:00:00','10:30:00',0, 6, 'PREDEFINED');

INSERT INTO appointments(date, end_time, start_time,version, administrator_id, appointment_status)
VALUES ('2024-02-06', '10:00:00','08:00:00',0, 7, 'PREDEFINED');

INSERT INTO appointments(date, end_time, start_time,version, administrator_id, appointment_status)
VALUES ('2024-02-07', '12:00:00','10:30:00',0, 8, 'PREDEFINED');

INSERT INTO contract(amount,equipment_type,company_id,date,contract_status,longitude,latitude)
VALUES(20,'Gloves',1,'2024-02-04','VALID','45.24702032809865', '19.840907344141257');

-- INSERT INTO reservations(
--     appointment_id, id,registered_user_id, reservation_status)
-- VALUES (1, 1, 1,'TAKEN');
--
-- INSERT INTO reservations(
--     appointment_id, id,registered_user_id, reservation_status)
-- VALUES (2, 2, 1,'RESERVED');
--
-- INSERT INTO reservations(
--     appointment_id, id,registered_user_id, reservation_status)
-- VALUES (3, 3, 1,'TAKEN');
--
-- INSERT INTO reservations(
--     appointment_id, id,registered_user_id, reservation_status)
-- VALUES (4, 4, 1,'RESERVED');