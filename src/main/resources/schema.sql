--CREATE USER som PASSWORD "password";
--CREATE SCHEMA drools;
CREATE TABLE rules (id VARCHAR(40) not null, merchant_name VARCHAR(100), merchant_jurisdiction VARCHAR(100), insurer VARCHAR(100), start_date DATE, end_date DATE);
GRANT ALL ON rules TO PUBLIC;
