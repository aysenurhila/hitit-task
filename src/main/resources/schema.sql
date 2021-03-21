drop table if exists CONTACT;

CREATE TABLE CONTACT (
                      id INT AUTO_INCREMENT  PRIMARY KEY,
                      firstName VARCHAR(50) NOT NULL,
                      lastName VARCHAR(50),
                      gender VARCHAR(50) NOT NULL,
                      phoneNumber INT(11) NOT NULL
);