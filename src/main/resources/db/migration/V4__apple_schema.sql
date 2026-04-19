CREATE SCHEMA IF NOT EXISTS x_amazon;

CREATE TABLE IF NOT EXISTS x_amazon.merchant_user
(
    id       BIGSERIAL PRIMARY KEY,
    name     VARCHAR(255),
    surname  VARCHAR(255),
    email    VARCHAR(255),
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255)        NOT NULL
);

-- passwords 123
INSERT INTO x_amazon.merchant_user(name, surname, email, username, password)
VALUES ('adem', 'doğan', 'adem.dogan@iyzico.com', 'adogan',
        '$2a$12$033wbvafpsMqAzVwc2YvTe97qzqknR/6/8y3ezC0IJPKrTDWSDcvu');

CREATE TABLE IF NOT EXISTS x_amazon.merchant_member
(
    id      BIGSERIAL PRIMARY KEY,
    name    VARCHAR(255),
    surname VARCHAR(255),
    email   VARCHAR(255),
    phone   VARCHAR(50)
);

INSERT INTO x_amazon.merchant_member(name, surname, email, phone)
VALUES ('Mustafa', 'Demir', 'mustafa.demir@ornekmail.com', '+905301234567'),
       ('Zeynep', 'Şahin', 'zeynep.sahin@ornekmail.com', '+905301234567'),
       ('Ali', 'Veli', 'ali.veli@ornekmail.com', '+905333456789'),
       ('Aslı', 'Demir', 'asli.demir@ornekmail.com', '+905355678901'),
       ('İlker', 'Ak', 'İlker.ak@ornekmail.com', '+905344567890'),
       ('Elif', 'Öztürk', 'elif.ozturk@ornekmail.com', '+905301234567'),
       ('Caner', 'Koç', 'caner.koc@ornekmail.com', '+905301234567'),
       ('Selin', 'Aydın', 'selin.aydin@ornekmail.com', '+905333456789'),
       ('Burak', 'Korkmaz', 'burak.korkmaz@ornekmail.com', '+905355678901'),
       ('Merve', 'Yavuz', 'merve.yavuz@ornekmail.com', '+905344567890');


