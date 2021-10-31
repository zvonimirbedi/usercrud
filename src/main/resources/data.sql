/* Database database_users */
-- -----------------------------------------------------------------------------------------------------

DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(250) NOT NULL,
    last_name VARCHAR(250) NOT NULL,
    username VARCHAR(250) NOT NULL,
    age INT NOT NULL,
    description VARCHAR(250) DEFAULT NULL
);


INSERT INTO users (id, username, first_name, last_name, age, description) VALUES (1, 'Ezekijel', 'Bluff', 'superhik', 35, 'Gives to the rich what he takes from the poor...');
INSERT INTO users (id, username, first_name, last_name, age, description) VALUES (2, 'Yngwie', 'Malmsteen', 'hmetal', 65, 'Always wanted to play ukulele...');
INSERT INTO users (id, username, first_name, last_name, age, description) VALUES (3, 'Kaiser', 'Soze', 'unknown', 80, 'Could be anyone...');