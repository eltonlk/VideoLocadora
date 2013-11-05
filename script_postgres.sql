CREATE DATABASE video_locadora;

CREATE TABLE states (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  uf VARCHAR(2) NULL,
  country VARCHAR(255) NOT NULL
);

insert into states (id, name, uf, country) values(1, 'Rio Grande do Sul', 'RS', 'Brasil');
insert into states (id, name, uf, country) values(2, 'São Paulo', 'SP', 'Brasil');
insert into states (id, name, uf, country) values(3, 'Rio de Janeiro', 'RJ', 'Brasil');
insert into states (id, name, uf, country) values(4, 'Minas Gerais', 'MG', 'Brasil');
insert into states (id, name, uf, country) values(5, 'Santa Catarina', 'SC', 'Brasil');

CREATE  TABLE cities (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  state_id INT references states(id)
);
CREATE INDEX fk_cities_state_id ON cities (state_id);

insert into cities (id, name, state_id) values(1, 'Teutônia', 1);
insert into cities (id, name, state_id) values(2, 'Lajeado', 1);
insert into cities (id, name, state_id) values(3, 'Porto Alegre', 1);
insert into cities (id, name, state_id) values(4, 'Blumenau', 5);
insert into cities (id, name, state_id) values(5, 'Campinas', 2);

CREATE TABLE people (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NULL,
  legal_name VARCHAR(255) NOT NULL,
  document_1 VARCHAR(15) NULL,
  document_2 VARCHAR(15) NULL,
  email VARCHAR(255) NULL,
  phone VARCHAR(15) NULL,
  cel VARCHAR(15) NULL,
  status VARCHAR(45) NOT NULL,
  kind VARCHAR(15) NOT NULL
);

insert into people (id, name, legal_name, document_1, document_2, email, phone, cel, status, kind) values(1, 'Elton', 'Elton Luis Kolling', '1234567890', '0987654321', 'eltonlk@gmail.com', '(051) 3762-9369', '(051) 98327358', 'employee', 'Ativo');
insert into people (id, name, legal_name, document_1, document_2, email, phone, cel, status, kind) values(2, '29Sul', 'Traichel & Dissel', '1234567890', '0987654321', 'contato@29sul.com.br', '(051) 3762-9369', '(051) 98327358', 'customer', 'Ativo');
insert into people (id, name, legal_name, document_1, document_2, email, phone, cel, status, kind) values(3, 'Vidraçaria Konrad', 'Vidraçaria Konrad LTDA.', '1234567890', '0987654321', 'contato@konrad.com', '(051) 3762-9369', '(051) 98327358', 'supplier', 'Ativo');

CREATE TABLE person_addresses (
  id SERIAL PRIMARY KEY,
  person_id INT references people(id),
  address VARCHAR(255) NULL,
  district VARCHAR(255) NULL,
  zip VARCHAR(10) NULL,
  city_id INT references cities(id)
);
CREATE INDEX fk_addresses_person_id ON person_addresses (person_id);
CREATE INDEX fk_addresses_city_id ON person_addresses (city_id);

insert into person_addresses (id, person_id, address, district, zip, city_id) values(1, 1, 'Rua Décio Pelegrini, 799', 'Canabarro', '95890-000', 1);
insert into person_addresses (id, person_id, address, district, zip, city_id) values(2, 1, 'Rua Major Bandeirras, 1034', 'Teutônia', '95890-000', 2);
insert into person_addresses (id, person_id, address, district, zip, city_id) values(3, 1, 'Rua 7 de Setembro, 145', 'Languiru', '95890-000', 3);

CREATE TABLE genres (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  status VARCHAR(45) NOT NULL
);

insert into genres (id, name, status) values(1, 'Aventura', 'Ativo');
insert into genres (id, name, status) values(2, 'Ação', 'Ativo');
insert into genres (id, name, status) values(3, 'Terror', 'Ativo');
insert into genres (id, name, status) values(4, 'Suspense', 'Ativo');
insert into genres (id, name, status) values(5, 'Comédia', 'Ativo');
insert into genres (id, name, status) values(6, 'Desenho', 'Ativo');
insert into genres (id, name, status) values(7, 'Anime', 'Ativo');
insert into genres (id, name, status) values(8, 'Velho Oeste', 'Ativo');

CREATE TABLE actors (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);

insert into actors (id, name) values(1, 'Brad Pit');
insert into actors (id, name) values(2, 'Júlia Roberts');
insert into actors (id, name) values(3, 'Robert de Niro');
insert into actors (id, name) values(4, 'Leonardo D`Caprio');
insert into actors (id, name) values(5, 'Silvester Stalone');
insert into actors (id, name) values(6, 'Tom Cruise');
insert into actors (id, name) values(7, 'Will Smith');
insert into actors (id, name) values(8, 'Jessica Biel');
