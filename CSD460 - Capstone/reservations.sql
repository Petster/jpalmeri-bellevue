DROP TABLE IF EXISTS reservations;
CREATE TABLE reservations (
    id int NOT NULL AUTO_INCREMENT,
    userID int NOT NULL,
    roomType int NOT NULL,
    reserveDate date,
    fromDate date,
    toDate date,
    price int,
    PRIMARY KEY (id),
    FOREIGN KEY (userID) references users(id),
    FOREIGN KEY (roomType) references rooms(id)
);

INSERT INTO reservations (userID, roomType, reserveDate, fromDate, toDate, price) values (0, 1, '2022-11-07', '2022-12-01', '2022-12-08', 299.99);

INSERT INTO reservations (userID, roomType, reserveDate, fromDate, toDate, price) values (1, 2, '2022-10-07', '2022-11-01', '2022-11-08', 499.99);

INSERT INTO reservations (userID, roomType, reserveDate, fromDate, toDate, price) values (2, 3, '2022-11-07', '2023-01-01', '2023-01-08', 399.99);