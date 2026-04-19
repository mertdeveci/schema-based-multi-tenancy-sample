CREATE SCHEMA IF NOT EXISTS public;

CREATE TABLE IF NOT EXISTS public.merchant
(
    id            BIGSERIAL PRIMARY KEY,
    tenant_name   VARCHAR(255) NOT NULL UNIQUE,
    client_id     VARCHAR(255) NOT NULL,
    client_secret VARCHAR(255) NOT NULL
);


INSERT INTO public.merchant(tenant_name, client_id, client_secret)
VALUES ('x_adidas', 'adidas', '$2a$12$fJCU1Osd1uYY.mY0UCUstORE88D9TYnsZ6FQabhl546kr2xTpYaxO'),
       ('x_amazon', 'amazon', '$2a$12$fQSHoXfDtUdeuM7TDPA06eJS9PT7zy3GTFDAP.FZ4xp5sdIs95bIu'),
       ('x.apple',  'apple',  '$2a$12$NsFofPzHKXh.6U8.Op9NAe9uYptap/WctDZoELQdrQ5qtcOy436r2');
