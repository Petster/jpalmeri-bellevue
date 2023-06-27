DROP TABLES IF EXISTS locations;
CREATE TABLE locations (
    id int NOT NULL AUTO_INCREMENT,
    address varchar(255),
    title varchar(255),
    PRIMARY KEY (id)
);

INSERT INTO locations (address, title) values ('12 street st, nashua, nh', 'Nashua Hotel');

INSERT INTO locations (address, title) values ('456 main street, columbus, oh', 'Main Street Hotel');

INSERT INTO locations (address, title) values ('15 national blvd, lincoln, NE', 'Premier Hotel & Suites');