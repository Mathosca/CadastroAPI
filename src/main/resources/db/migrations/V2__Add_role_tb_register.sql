-- Migrations to add the roles column to the register table

ALTER TABLE tb_register
ADD COLUMN role VARCHAR(255);