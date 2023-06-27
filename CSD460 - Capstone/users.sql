DROP TABLE IF EXISTS users;
CREATE TABLE users (
    id int NOT NULL AUTO_INCREMENT,
    email varchar(255),
    lastName varchar(255),
    firstName varchar(255),
    phone varchar(20),
    joinDate date,
    loyaltyPoints int,
    isAdmin boolean,
    password varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO users (id, email, lastName, firstName, phone, joinDate, loyaltyPoints, isAdmin, password) values (1, 'jason@test.com', 'Palmeri', 'Jason', '123-456-7890', '2022-11-07', '99', true, 'testPassword');

INSERT INTO users (id, email, lastName, firstName, phone, joinDate, loyaltyPoints, isAdmin, password) values (2, 'john@test.com', 'Moore', 'John', '123-456-7890', '2022-12-02', '39', false, 'testPassword');

INSERT INTO users (id, email, lastName, firstName, phone, joinDate, loyaltyPoints, isAdmin, password) values (3, 'mishaela@test.com', 'Pedersen', 'Mishaela', '123-456-7890', '2022-11-22', '79', false, 'testPassword');