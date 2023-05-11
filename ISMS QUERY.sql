create database ISMS
use ISMS

create table PRODUCT(
P_NAME varchar(20),
P_ID varchar(10) PRIMARY KEY,
P_PRICE int,
P_QUANTITY INT,
P_PURCHASE INT,
S_ID VARCHAR(10) FOREIGN KEY REFERENCES SUPPLIER(S_ID),
P_TYPE VARCHAR(10),
P_WEIGHT INT
)

CREATE TABLE SUPPLIER(
S_ID VARCHAR(10) PRIMARY KEY,
S_NAME VARCHAR(30),
S_PHONE BIGINT
)

CREATE TABLE CUSTOMER(
C_ID VARCHAR(10) PRIMARY KEY,
C_NAME VARCHAR(20),
C_PHONE BIGINT,
C_EMAIL VARCHAR(50)
)

CREATE TABLE [ORDER](
O_ID VARCHAR(10) PRIMARY KEY,
C_ID VARCHAR(10),
O_TIME TIMESTAMP,
O_METHOD VARCHAR(5),
O_DISCOUNT INT,
E_ID VARCHAR(10) FOREIGN KEY REFERENCES CUSTOMER(C_ID),
O_STATUS VARCHAR(10)
)

CREATE TABLE PRO_ORD(
O_ID VARCHAR(10) FOREIGN KEY REFERENCES [ORDER](O_ID) ,
P_ID VARCHAR(10) FOREIGN KEY REFERENCES PRODUCT(P_ID),
PO_QUANTITY INT,
PO_PRICE INT,
PRIMARY KEY(O_ID, P_ID)
)



CREATE TABLE PURCHASE(
PUR_ID VARCHAR(10) PRIMARY KEY,
S_ID VARCHAR(10) FOREIGN KEY REFERENCES SUPPLIER(S_ID),
PUR_TIME DATETIME,
PUR_METHOD VARCHAR(5),
PUR_DISCOUNT INT,
E_ID VARCHAR(10) FOREIGN KEY REFERENCES EMPLOYEE(E_ID),
)

CREATE TABLE PRO_PUR(
PUR_ID VARCHAR(10) FOREIGN KEY REFERENCES PURCHASE(PUR_ID),
P_ID VARCHAR(10) FOREIGN KEY REFERENCES PRODUCT(P_ID),
PUR_QUANTITY INT,
PUR_PRICE INT,
PRIMARY KEY(PUR_ID, P_ID)
)

CREATE TABLE EMPLOYEE(
E_ID VARCHAR(10) PRIMARY KEY,
E_NAME VARCHAR(20),
E_PHONE BIGINT,
E_DESIGNATION VARCHAR(8),
E_SALARY INT
)

-- INSERTING DATA INTO TABLES
INSERT INTO SUPPLIER (S_ID, S_NAME, S_PHONE)
VALUES ('S000000001', 'Acme Inc.', 923001234567),
       ('S000000002', 'Beta Industries', 923001234568),
       ('S000000003', 'Gamma Corp', 923001234569),
       ('S000000004', 'Delta Co', 923001234570),
       ('S000000005', 'Epsilon LLC', 923001234571),
       ('S000000006', 'Zeta Enterprises', 923001234572),
       ('S000000007', 'Eta Corp', 923001234573);

INSERT INTO CUSTOMER (C_ID, C_NAME, C_PHONE, C_EMAIL)
VALUES 
('C000000001', 'John Smith', 923001234567, 'john.smith@example.com'),
('C000000002', 'Jane Doe', 923001234568, 'jane.doe@example.com'),
('C000000003', 'Bob Johnson', 923001234569, 'bob.johnson@example.com'),
('C000000004', 'Alice Wong', 923001234570, 'alice.wong@example.com'),
('C000000005', 'Tom Wilson', 923001234571, 'tom.wilson@example.com'),
('C000000006', 'Sara Lee', 923001234572, 'sara.lee@example.com'),
('C000000007', 'Alex Kim', 923001234573, 'alex.kim@example.com'),
('C000000008', 'Emily Davis', 923001234574, 'emily.davis@example.com'),
('C000000009', 'Daniel Park', 923001234575, 'daniel.park@example.com'),
('C000000010', 'Kelly Brown', 923001234576, 'kelly.brown@example.com'),
('C000000011', 'George Taylor', 923001234577, 'george.taylor@example.com'),
('C000000012', 'Jenny Lee', 923001234578, 'jenny.lee@example.com'),
('C000000013', 'Mark Johnson', 923001234579, 'mark.johnson@example.com'),
('C000000014', 'Linda Wilson', 923001234580, 'linda.wilson@example.com'),
('C000000015', 'David Jones', 923001234581, 'david.jones@example.com'),
('C000000016', 'Cathy Kim', 923001234582, 'cathy.kim@example.com'),
('C000000017', 'Andrew Lee', 923001234583, 'andrew.lee@example.com'),
('C000000018', 'Grace Kim', 923001234584, 'grace.kim@example.com'),
('C000000019', 'Timothy Davis', 923001234585, 'timothy.davis@example.com'),
('C000000020', 'Ella Wilson', 923001234586, 'ella.wilson@example.com'),
('C000000021', 'Steven Lee', 923001234587, 'steven.lee@example.com'),
('C000000022', 'Amy Smith', 923001234588, 'amy.smith@example.com'),
('C000000023', 'Kevin Johnson', 923001234589, 'kevin.johnson@example.com'),
('C000000024', 'Sophie Brown', 923001234590, 'sophie.brown@example.com'),
('C000000025', 'Jacob Taylor', 923001234591, 'jacob.taylor@example.com'),
('C000000026', 'Olivia Lee', 923001234592, 'olivia.lee@example.com'),
('C000000027', 'Ryan Kim', 923001234593, 'ryan.kim@example.com'),
('C000000028', 'Isabella Davis', 923001234594, 'isabella.davis@example.com'),
('C000000029', 'William Wilson', 923001234595, 'william.wilson@example.com');

INSERT INTO EMPLOYEE(E_ID, E_NAME, E_PHONE, E_DESIGNATION, E_SALARY)
VALUES 
('E000000001', 'John Smith', 923334567890, 'manager', 100000),
('E000000002', 'Jane Doe', 923219876543, 'cashier', 50000),
('E000000003', 'Bob Johnson', 923456789123, 'worker', 25000),
('E000000004', 'Alice Wong', 923123456789, 'worker', 25000),
('E000000005', 'Tom Wilson', 923001234567, 'worker', 25000);
	
INSERT INTO PRODUCT(P_ID, P_NAME, P_PRICE, P_QUANTITY, P_PURCHASE, S_ID, P_WEIGHT, P_TYPE)
VALUES
('P000000001', 'Apple', 50, 100, 40, 'S000000001', 1, 'W'),
('P000000002', 'Banana', 30, 200, 25, 'S000000003', 12, 'Q'),
('P000000003', 'Orange', 60, 150, 50, 'S000000002', 1, 'W'),
('P000000004', 'Grapes', 80, 100, 70, 'S000000002', 1, 'W'),
('P000000005', 'Mango', 100, 50, 80, 'S000000003', 1, 'W'),
('P000000006', 'Pineapple', 120, 70, 100, 'S000000003', 1, 'W'),
('P000000007', 'Watermelon', 80, 30, 60, 'S000000004', 1, 'W'),
('P000000008', 'Strawberry', 150, 80, 120, 'S000000004', 1, 'W'),
('P000000009', 'Milk', 80, 150, 70, 'S000000005', 1, 'Q'),
('P000000010', 'Butter', 200, 50, 150, 'S000000005', 1, 'W'),
('P000000011', 'Cheese', 300, 30, 250, 'S000000005', 1, 'W'),
('P000000012', 'Bread Loaf', 40, 200, 30, 'S000000006', 1, 'Q'),
('P000000013', 'Eggs', 100, 100, 80, 'S000000006', 12, 'Q'),
('P000000014', 'Chicken', 300, 50, 250, 'S000000007', 1, 'W'),
('P000000015', 'Beef', 400, 40, 300, 'S000000007', 1, 'W'),
('P000000016', 'Mutton', 500, 30, 400, 'S000000007', 1, 'W'),
('P000000017', 'Rice', 60, 300, 40, 'S000000002', 1, 'W'),
('P000000018', 'Flour', 40, 250, 30, 'S000000004', 1, 'W'),
('P000000019', 'Sugar', 50, 200, 35, 'S000000003', 1, 'W'),
('P000000020', 'Salt', 20, 300, 10, 'S000000006', 1, 'W'),
('P000000021', 'Tomato Ketchup', 150, 50, 100, 'S000000007', 1, 'Q'),
('P000000022', 'Mayonnaise', 200, 35, 150, 'S000000004', 1, 'Q'),
('P000000023', 'Burger Bun', 10, 200, 7, 'S000000007', 1, 'Q'),
('P000000024', 'Cheese Slice', 50, 100, 40, 'S000000002', 25, 'Q'),
('P000000025', 'Cheddar Cheese', 600, 20, 550, 'S000000001', 0.5, 'W'),
('P000000026', 'Mozzarella Cheese', 700, 20, 600, 'S000000002', 0.5, 'W'),
('P000000027', 'Olives', 80, 50, 70, 'S000000005', 0.5, 'W'),
('P000000028', 'Pickles', 100, 40, 80, 'S000000003', 0.5, 'W'),
('P000000029', 'Chicken Tikka', 400, 10, 350, 'S000000004', 1, 'W'),
('P000000030', 'Chicken Seekh Kabab', 450, 10, 400, 'S000000007', 6, 'Q'),
('P000000031', 'Beef Burger Patty', 150, 50, 120, 'S000000006', 4, 'Q'),
('P000000032', 'Beef Kofta', 300, 10, 250, 'S000000001', 1, 'W'),
('P000000033', 'Beef Chapli Kabab', 400, 10, 350, 'S000000001', 1, 'W'),
('P000000034', 'Chicken Wings', 200, 30, 170, 'S000000004', 0.5, 'W'),
('P000000035', 'Chicken Drumsticks', 250, 25, 200, 'S000000002', 0.5, 'W'),
('P000000036', 'Mutton Chops', 700, 15, 600, 'S000000001', 0.5, 'W'),
('P000000037', 'Mutton Karahi', 1000, 10, 850, 'S000000002', 1, 'W'),
('P000000038', 'Beef Karahi', 800, 10, 700, 'S000000005', 1, 'W'),
('P000000039', 'Chicken Biryani', 350, 20, 300, 'S000000001', 1, 'Q'),
('P000000040', 'Beef Biryani', 500, 15, 450, 'S000000006', 1, 'Q');

INSERT INTO PURCHASE (PUR_ID, PUR_METHOD, PUR_TIME, PUR_DISCOUNT, E_ID, S_ID)
VALUES 
('PUR0000001', 'cash', '2022-05-11 14:30:00', 5, 'E000000002', 'S000000001'),
('PUR0000002', 'card', '2022-06-11 12:00:00',7, 'E000000002', 'S000000002'),
('PUR0000003', 'cash', '2022-07-02 17:0:00', 2, 'E000000001', 'S000000003'),
('PUR0000004', 'cash', '2022-08-06 11:30:00', 0, 'E000000002', 'S000000004'),
('PUR0000005', 'card', '2022-09-08 12:30:00', 8, 'E000000001', 'S000000005'),
('PUR0000006', 'cash', '2022-10-01 19:15:00', 10, 'E000000002', 'S000000006'),
('PUR0000007', 'card', '2022-11-02 14:30:00', 2, 'E000000002', 'S000000007');


select * from product p
where p.P_NAME = 'Chicken Tikka'