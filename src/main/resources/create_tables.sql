CREATE TABLE users (
    id     	int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name   	varchar(255) NOT NULL,
    email       varchar(255) NOT NULL,
    password	varchar(25) NOT NULL,
    created     date       NOT NULL,
    modified    date       NOT NULL,
    lastLogin 	date       NOT NULL
);

CREATE TABLE phones
(
    id 	int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ddd 	varchar(40) NULL,
    number	varchar(40) NULL
);