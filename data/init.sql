SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE IF EXISTS exercicedb;
CREATE DATABASE exercicedb WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'en_US.UTF-8';

REVOKE ALL ON SCHEMA public FROM PUBLIC;
GRANT ALL ON SCHEMA public TO PUBLIC;

CREATE TABLE IF NOT EXISTS T_RATES (
    ID PRIMARY KEY VARCHAR(36) NOT NULL,
    BRAND_ID  VARCHAR(36) NOT NULL,
    PRODUCT_ID VARCHAR(36) NOT NULL,
    START_DATE DATE NOT NULL,
    END_DATE DATE NOT NULL,
    PRICE INT NOT NULL,
    CURRENCY_CODE VARCHAR(3) NOT NULL
);

CREATE INDEX rates_brand_id_index ON T_RATES USING btree (brand_id);
CREATE INDEX rates_product_id_index ON T_RATES USING btree (product_id);
CREATE INDEX rates_currency_code_index ON T_RATES USING btree (currency_code);

1d305069-f083-44ff-a123-9e575c01f36f

de8eba5b-2457-483b-bfc6-f3982aec6068

58f8723a-93cf-4f17-8877-421c6f0382ab

9a7ab14b-19e1-4535-be38-a965c00390d5
INSERT INTO public.t_rates
(id, brand_id, product_id, start_date, end_date, price, currency_code)
VALUES('1d305069-f083-44ff-a123-9e575c01f36f','93e1c2e7-76f7-4121-bc1d-66e9499f7adc', '05063301-f2a3-44d7-b034-1aea95d9b143', '2022-01-01', '2022-05-31', 1550, 'EUR');
INSERT INTO public.t_rates
(brand_id, product_id, start_date, end_date, price, currency_code)
VALUES('de8eba5b-2457-483b-bfc6-f3982aec6068', '93e1c2e7-76f7-4121-bc1d-66e9499f7adc', '05063301-f2a3-44d7-b034-1aea95d9b143', '2022-06-01', '2022-12-31', 1850, 'USD');
INSERT INTO public.t_rates
(brand_id, product_id, start_date, end_date, price, currency_code)
VALUES('58f8723a-93cf-4f17-8877-421c6f0382ab', '93e1c2e7-76f7-4121-bc1d-66e9499f7adc', '63294db3-f305-4f7f-8bb7-ad2fe93a73a9', '2022-01-01', '2022-05-31', 2050, 'EUR');
INSERT INTO public.t_rates
(brand_id, product_id, start_date, end_date, price, currency_code)
VALUES('9a7ab14b-19e1-4535-be38-a965c00390d5', '93e1c2e7-76f7-4121-bc1d-66e9499f7adc', '63294db3-f305-4f7f-8bb7-ad2fe93a73a9', '2022-06-01', '2022-12-31', 2250, 'USD');
