CREATE SCHEMA IF NOT EXISTS x_adidas;

CREATE TABLE IF NOT EXISTS x_adidas.merchant_user
(
    id       BIGSERIAL PRIMARY KEY,
    name     VARCHAR(255),
    surname  VARCHAR(255),
    email    VARCHAR(255),
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255)        NOT NULL
);

-- passwords 123
INSERT INTO x_adidas.merchant_user(name, surname, email, username, password)
VALUES ('mert', 'deveci', 'mertdeveci@iyzico.com', 'mdeveci',
        '$2a$12$033wbvafpsMqAzVwc2YvTe97qzqknR/6/8y3ezC0IJPKrTDWSDcvu');

CREATE TABLE IF NOT EXISTS x_adidas.merchant_member
(
    id      BIGSERIAL PRIMARY KEY,
    name    VARCHAR(255),
    surname VARCHAR(255),
    email   VARCHAR(255),
    phone   VARCHAR(50)
);

INSERT INTO x_adidas.merchant_member(name, surname, email, phone)
VALUES ('Ahmet', 'Yılmaz', 'ahmet.yilmaz@ornekmail.com', '+905301234567'),
       ('Ayşe', 'Kaya', 'ayse.kaya@ornekmail.com', '+905301234567'),
       ('Mehmet', 'Çelik', 'mehmet.celik@ornekmail.com', '+905333456789'),
       ('Mustafa', 'Demir', 'mustafa.demir@ornekmail.com', '+905355678901'),
       ('Fatma', 'Yıldız', 'fatma.yildiz@ornekmail.com', '+905344567890');


