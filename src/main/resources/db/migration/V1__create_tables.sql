DROP TABLE  IF EXISTS candidates;
DROP TABLE  IF EXISTS usuarios;
 CREATE TABLE candidates (
   id bigint NOT NULL AUTO_INCREMENT,
   name varchar(255) DEFAULT NULL,
   email varchar(255) DEFAULT NULL,
   gender enum('male','feminine') NOT NULL,
   salary double DEFAULT NULL,
   position varchar(255) DEFAULT NULL,
   status enum('pre_selection','selection','hiring','incorporation') NOT NULL,
   creation_date datetime DEFAULT NULL,   
   modification_date datetime DEFAULT NULL, 
 PRIMARY KEY (id)
);

CREATE TABLE usuarios (
  id bigint NOT NULL AUTO_INCREMENT,
  name varchar(255) DEFAULT NULL,
  lastname varchar(255) DEFAULT NULL,
  username varchar(255) DEFAULT NULL,
  password varchar(255) DEFAULT NULL,
  email varchar(255) DEFAULT NULL,
  creation_date datetime DEFAULT NULL,
  modification_date datetime DEFAULT NULL,
  PRIMARY KEY (id)
);