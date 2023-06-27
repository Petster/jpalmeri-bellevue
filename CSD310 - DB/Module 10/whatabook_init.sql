CREATE TABLE user(
   user_id INT NOT NULL AUTO_INCREMENT,
   first_name VARCHAR(75) NOT NULL,
   last_name VARCHAR(75) NOT NULL
   PRIMARY KEY (user_id)
);

CREATE TABLE wishlist(
   wishlist_id INT NOT NULL AUTO_INCREMENT,
   user_id INT NOT NULL,
   book_id INT NOT NULL,
   PRIMARY KEY (wishlist_id),
   FOREIGN KEY (user_id) REFERENCES user(user_id),
   FOREIGN KEY (book_id) REFERENCES book(book_id)
);

CREATE TABLE book(
   book_id INT NOT NULL AUTO_INCREMENT,
   book_name VARCHAR(200) NOT NULL,
   details VARCHAR(500),
   author VARCHAR(200) NOT NULL,
   PRIMARY KEY (book_id),
);

CREATE TABLE store(
   store_id INT NOT NULL AUTO_INCREMENT,
   locale VARCHAR(500) NOT NULL,
   PRIMARY KEY (store_id)
);

INSERT INTO store(locale) VALUES('123 Northeastern Road, Brookline, NH 03033');

INSERT INTO book(book_name, author, details) VALUES('The Return of the King', 'J.R.Tolkien', 'The third part of The Lord of the Rings');

INSERT INTO book(book_name, author, details) VALUES('The Fellowship of the Ring', 'J.R.Tolkien', 'The first part of The Lord of the Rings');

INSERT INTO book(book_name, author, details) VALUES('The Two Towers', 'J.R.Tolkien', "The second part of The Lord of The Rings");

INSERT INTO book(book_name, author) VALUES('The Hobbit or There and Back Again', 'J.R.Tolkien');

INSERT INTO book(book_name, author) VALUES('Dune: Deluxe Edition', 'Frank Herbert');

INSERT INTO book(book_name, author) VALUES("Charlotee's Web", 'E.B. White');

INSERT INTO book(book_name, author) VALUES('The Great Gatsby', 'F. Scott Fitzgerald');

INSERT INTO book(book_name, author) VALUES('The Lion, the Witch, and the Wardrobe', 'C.S. Lewis');

INSERT INTO book(book_name, author) VALUES('The Catcher and the Rye', 'J.D. Salinger');

INSERT INTO user(first_name, last_name) VALUES ('Joe', 'Johnson');
INSERT INTO user(first_name, last_name) VALUES ('Ringo', 'Weesler');
INSERT INTO user(first_name, last_name) VALUES ('Anthony', 'Richards');

INSERT INTO wishlist(user_id, book_id) VALUES (
   (SELECT user_id FROM user WHERE first_name='Joe'),
   (SELECT book_id FROM book WHERE book_name = 'The Great Gatsby')
);

INSERT INTO wishlist(user_id, book_id) VALUES (
   (SELECT user_id FROM user WHERE first_name='Ringo'),
   (SELECT book_id FROM book WHERE book_name = "Charlotee's Web")
);

INSERT INTO wishlist(user_id, book_id) VALUES (
   (SELECT user_id FROM user WHERE first_name='Anthony'),
   (SELECT book_id FROM book WHERE book_name = 'Dune: Deluxe Edition')
);