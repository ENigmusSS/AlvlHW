CREATE TABLE Customer (
                          login VARCHAR(255),
                          firstName VARCHAR(255),
                          lastName VARCHAR(255),
                          dateOfBirth DATE,
                          country VARCHAR(255),
                          sex enum('male', 'female'),
                          PRIMARY KEY (login)
);
