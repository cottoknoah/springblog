USE spring_db;

INSERT INTO users (username, email, password)
VALUES ('billy123', 'billy@email.com', 'password');

INSERT INTO posts (title, body, author_id)
VALUES  ('title 1', 'Body 1', 1),
('title 2', 'Body 2 -', 1),
('title 3', 'Body 3', 1),
('title 4', 'Body 4', 1),
('title 5', 'Body 5', 1);

