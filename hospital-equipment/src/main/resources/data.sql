INSERT INTO public.addresses(
    city, country, number, street,latitude,longitude)
VALUES ( 'Novi Sad', 'Serbia', '37', 'Dimitrija Tucovica','45.24702032809865', '19.840907344141257');

INSERT INTO addresses(
    city, country, number, street,latitude,longitude)
VALUES ( 'Belgrad', 'Serbia', '45', 'Knez Mihailova','44.818869399625825', '20.455416881235333');

INSERT INTO addresses(
    city, country, number, street,latitude,longitude)
VALUES ( 'Nis', 'Serbia', '60', 'Mileve Maric','43.32885417815908', '21.9470735964939');
INSERT INTO addresses(
    city, country, number, street,latitude,longitude)
VALUES ( 'Trebinje', 'Bih', '1', 'Knez Mihajlova','42.71764591197575', '18.353486891668506');

INSERT INTO addresses(
    city, country, number, street,latitude,longitude)
VALUES ( 'Nis', 'Serbia', '13', 'Vozda Karadjordja','43.32111628016304', '21.897958796493494');

INSERT INTO addresses(
    city, country, number, street,latitude,longitude)
VALUES ( 'Beograd', 'Serbia', '36', 'Nemanjina','44.802974458685824', '20.464545191207794');


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
VALUES ( 'anoka1810@gmail.com', true, 'Tara', 'Boskovic','taric', 'student', '$2a$10$mD0kgZJFbHEdEM5ICKJbgecF3qjIzP.i3zVV.nszlWh8Adp4gs4K6', '066-2678-772', 1,false);


INSERT INTO users(
    email, enabled, firstname, lastname,username, occupation, password, phone_number, address_id,waslogged)

VALUES ( 'h.jovix@gmail.com', true, 'Milos', 'Milosevic','anic', 'doctor', '$2a$10$mD0kgZJFbHEdEM5ICKJbgecF3qjIzP.i3zVV.nszlWh8Adp4gs4K6', '064-3782-892', 2,false);


INSERT INTO users(
    email, enabled, firstname, lastname,username, occupation, password, phone_number, address_id,waslogged)
VALUES ( 'nikolinaskiljevic@gmail.com',true, 'Nikolina', 'Skiljevic','nina', 'nurse', '$2a$10$8Nm7wMyIxo7da3VfOJcE1eCI9JQOaWv5lVpehrMBSRAuODL2u/2Oq',  '069-3782-738', 3,false);
INSERT INTO users(
    email, enabled, firstname, lastname,username, occupation, password, phone_number, address_id,waslogged)
VALUES ( 'janko@gmail.com',false, 'Janko', 'Jankovic','aaa', 'nurse', '36782',  '069-3782-738', 4,false);

INSERT INTO users(
    email, enabled, firstname, lastname, username, occupation, password, phone_number, address_id,waslogged)
VALUES ( 'marko@gmail.com',false, 'Marko', 'Markovic', 'aaa', 'nurse', '222345',  '069-3782-738', 5,false);

INSERT INTO users(
    email, enabled, firstname, lastname,username, occupation, password, phone_number, address_id,waslogged)
VALUES ( 'Mirko@gmail.com',false, 'Mirko', 'Mirkovic','banana', 'nurse', '36782',  '069-3782-738', 6,false);



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
VALUES (0, 1,1, 'REGULAR');





INSERT INTO company(name, description, grade, address_id, work_start_time, work_end_time)
VALUES ('Corpore Sano', 'The best service', 5, 1, '08:00:00', '17:00:00');

INSERT INTO company(name, description, grade, address_id, work_start_time, work_end_time)
VALUES ('Health Company', 'Safe with us', 4, 2, '08:00:00', '17:00:00');

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
    amount, company_id, equipment_id,price)
VALUES ( 100,1,1,100);

INSERT INTO equipment_stock(
    amount, company_id, equipment_id,price)
VALUES ( 200,1,2,200);

INSERT INTO equipment_stock(
    amount, company_id, equipment_id,price)
VALUES ( 200,2,3,150);

INSERT INTO equipment_stock(
    amount, company_id, equipment_id,price)
VALUES ( 200,3,1,250);

INSERT INTO equipment_stock(
    amount, company_id, equipment_id,price)
VALUES ( 200,3,2,130);


INSERT INTO appointments(date, end_time, start_time, administrator_id,appointment_status)
VALUES ('2024-01-29', '10:00:00','08:00:00', 3, 'TAKEN');

INSERT INTO appointments(date, end_time, start_time, administrator_id,  appointment_status)
VALUES ('2024-02-03', '10:00:00','08:00:00', 3,'PREDEFINED');

INSERT INTO appointments(date, end_time, start_time, administrator_id, appointment_status)
VALUES ('2024-02-04', '10:30:00','08:00:00', 4, 'PREDEFINED');

INSERT INTO appointments(date, end_time, start_time, administrator_id, appointment_status)
VALUES ('2024-02-04', '12:00:00','10:30:00', 4, 'PREDEFINED');

