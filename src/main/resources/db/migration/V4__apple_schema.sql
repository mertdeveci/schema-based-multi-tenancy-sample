CREATE SCHEMA IF NOT EXISTS x_apple;

CREATE TABLE IF NOT EXISTS x_apple.merchant_user
(
    id       BIGSERIAL PRIMARY KEY,
    name     VARCHAR(255),
    surname  VARCHAR(255),
    email    VARCHAR(255),
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255)        NOT NULL
);

-- passwords 123
INSERT INTO x_apple.merchant_user(name, surname, email, username, password)
VALUES ('mahmut', 'nasifoğlu', 'mahmut.nasifoglu@iyzico.com', 'm.nasifoğlu',
        '$2a$12$033wbvafpsMqAzVwc2YvTe97qzqknR/6/8y3ezC0IJPKrTDWSDcvu');

CREATE TABLE IF NOT EXISTS x_apple.merchant_member
(
    id      BIGSERIAL PRIMARY KEY,
    name    VARCHAR(255),
    surname VARCHAR(255),
    email   VARCHAR(255),
    phone   VARCHAR(50)
);

INSERT INTO x_apple.merchant_member(name, surname, email, phone)
VALUES ('Pelin', 'Sönmez', 'pelin.sonmez@ornekmail.com', '+905301234567'),
       ('Ozan', 'Erdem', 'ozan.erdem@ornekmail.com', '+905301234567'),
       ('Seda', 'Baş', 'seda.bas@ornekmail.com', '+905333456789');


