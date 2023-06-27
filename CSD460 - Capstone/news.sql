DROP TABLE IF EXISTS news;
CREATE TABLE news (
    id int NOT NULL AUTO_INCREMENT,
    userID int NOT NULL,
    title varchar(100),
    publishDate date,
    description varchar(500),
    image varchar(500),
    PRIMARY KEY (id),
    FOREIGN KEY (userID) references users(id)
);

INSERT INTO news (userID, title, publishDate, description, image) values (0, 'New Hotel', '2022-11-07', 'We have a new hotel coming in december', '/images/newhotel.jpg');

INSERT INTO news (userID, title, publishDate, description, image) values (1, 'Test', '2022-12-07', 'We have a new hotel coming in december', '/images/newhotel.jpg');

INSERT INTO news (userID, title, publishDate, description, image) values (0, 'Great Value', '2022-05-07', 'Deals on hotel rooms this summer!', '/images/deals.jpg');