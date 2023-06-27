DROP TABLE IF EXISTS emails;
CREATE TABLE emails (
    id int NOT NULL AUTO_INCREMENT,
    userID int,
    dateSent date,
    reservationNum int,
    userEmail varchar(255),
    userFirstName varchar(255),
    subject varchar(255),
    message varchar(1000),
    PRIMARY KEY (id),
    FOREIGN KEY (userID) references users(id),
    FOREIGN KEY (reservationNum) references reservations(id)
);

INSERT INTO emails (userID, dateSent, reservationNum, userEmail, userFirstName, subject, message) values (1, '2022-11-07', 1, 'jason@test.com', 'Jason', 'Test', 'Test');

INSERT INTO emails (userID, dateSent, reservationNum, userEmail, userFirstName, subject, message) values (2, '2022-12-07', 1, 'john@test.com', 'John', 'Test', 'Test');

INSERT INTO emails (userID, dateSent, reservationNum, userEmail, userFirstName, subject, message) values (3, '2022-05-07', 1, 'mishaela@test.com', 'Mishaela', 'Test', 'Test');