
CREATE DATABASE adlister_db;

CREATE USER 'adUser'@'localhost' IDENTIFIED BY 'codeup';

GRANT ALL ON adlister_db.* TO 'adUser'@'localhost';
