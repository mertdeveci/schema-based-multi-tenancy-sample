-- 2. Member (MerchantMember) tablosu
CREATE TABLE member
(
    id      BIGSERIAL PRIMARY KEY,
    name    VARCHAR(255),
    surname VARCHAR(255),
    email   VARCHAR(255),
    phone   VARCHAR(255)
);


-- 3. MerchantProduct tablosu
CREATE TABLE merchant_product
(
    id    BIGSERIAL PRIMARY KEY,
    name  VARCHAR(255),
    price VARCHAR(255) -- Not: Tavsiyeler bölümüne bakın
);

-- 4. MerchantUser tablosu
CREATE TABLE merchant_user
(
    id       BIGSERIAL PRIMARY KEY,
    name     VARCHAR(255),
    surname  VARCHAR(255),
    email    VARCHAR(255),
    password VARCHAR(255),
    merchant BIGINT NOT NULL
);