CREATE TABLE IF NOT EXISTS public.merchant
(
    id            BIGSERIAL PRIMARY KEY,
    tenant_name   VARCHAR(255) NOT NULL UNIQUE,
    client_id     VARCHAR(255) NOT NULL,
    client_secret VARCHAR(255) NOT NULL
);


INSERT INTO public.merchant(tenant_name, client_id, client_secret)
VALUES ('x_adidas', 'adidas', 'adidas'),
       ('x_amazon', 'amazon', 'amazon'),
       ('x.apple',  'apple',  'apple');
