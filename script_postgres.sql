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

insert into people (id, name, legal_name, document_1, document_2, email, phone, cel, status, kind) values(1, 'Elton', 'Elton Luis Kolling', '1234567890', '0987654321', 'eltonlk@gmail.com', '(051) 3762-9369', '(051) 98327358', 'Ativo', 'employee');
insert into people (id, name, legal_name, document_1, document_2, email, phone, cel, status, kind) values(2, '29Sul', 'Traichel & Dissel', '1234567890', '0987654321', 'contato@29sul.com.br', '(051) 3762-9369', '(051) 98327358', 'Ativo', 'customer');
insert into people (id, name, legal_name, document_1, document_2, email, phone, cel, status, kind) values(3, 'Vidraçaria Konrad', 'Vidraçaria Konrad LTDA.', '1234567890', '0987654321', 'contato@konrad.com', '(051) 3762-9369', '(051) 98327358', 'Ativo', 'supplier');

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

CREATE TABLE movies (
  id SERIAL PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  release_in DATE NULL,
  genre_id INT references genres(id),  
  synopsis TEXT NULL  
);
CREATE INDEX fk_movies_genre_id ON movies (genre_id);

insert into movies (id, title, release_in, genre_id, synopsis) values(1, 'Troya', '2010-10-17', 1, 'Destruição de Troya.');
insert into movies (id, title, release_in, genre_id, synopsis) values(2, 'Vanilla Sky', '2009-03-25', 4, 'labmda labmda lambda.');
insert into movies (id, title, release_in, genre_id, synopsis) values(3, 'Titanic', '2005-12-01', 4, 'Como um dos maiores navios naufragou.');
insert into movies (id, title, release_in, genre_id, synopsis) values(4, 'Rambo', '2001-07-30', 2, 'Rambo destroi tudo.');

CREATE TABLE actors_movies (
  actor_id INT references actors(id),
  movie_id INT references movies(id)
);
CREATE INDEX fk_actors_movies_actor_id ON actors_movies (actor_id);
CREATE INDEX fk_actors_movies_movie_id ON actors_movies (movie_id);

insert into actors_movies (actor_id, movie_id) values(1, 1);
insert into actors_movies (actor_id, movie_id) values(6, 2);
insert into actors_movies (actor_id, movie_id) values(4, 3);
insert into actors_movies (actor_id, movie_id) values(5, 4);

CREATE TABLE medias (
  id SERIAL PRIMARY KEY,
  movie_id INT references movies(id),
  supplier_id INT references people(id),
  kind VARCHAR(15) NOT NULL,
  amount DECIMAL(13,2) DEFAULT 0,
  purchased_at DATE NULL,
  amount_paid DECIMAL(13,2) DEFAULT 0,
  status VARCHAR(15) NOT NULL
);
CREATE INDEX fk_medias_movie_id ON medias (movie_id);
CREATE INDEX fk_medias_supplier_id ON medias (supplier_id);

insert into medias (id, movie_id, supplier_id, kind, amount, purchased_at, amount_paid, status) values(1, 1, 3, 'DVD', 3.45, '2010-10-25', 119.20, 'Funcionando');
insert into medias (id, movie_id, supplier_id, kind, amount, purchased_at, amount_paid, status) values(2, 1, 3, 'VHS', 2.00, '2010-10-20', 80.20, 'Perdido');
insert into medias (id, movie_id, supplier_id, kind, amount, purchased_at, amount_paid, status) values(3, 1, 3, 'Blu-Ray', 4.95, '2010-10-30', 175.84, 'Roubado');
insert into medias (id, movie_id, supplier_id, kind, amount, purchased_at, amount_paid, status) values(4, 2, 3, 'DVD', 3.45, '2009-04-25', 119.20, 'Estragado');
insert into medias (id, movie_id, supplier_id, kind, amount, purchased_at, amount_paid, status) values(5, 2, 3, 'Blu-Ray', 3.45, '2010-01-10', 119.20, 'Funcionando');
insert into medias (id, movie_id, supplier_id, kind, amount, purchased_at, amount_paid, status) values(6, 3, 3, 'DVD', 3.45, '2006-01-07', 119.20, 'Funcionando');
insert into medias (id, movie_id, supplier_id, kind, amount, purchased_at, amount_paid, status) values(7, 4, 3, 'DVD', 3.45, '2001-08-12', 119.20, 'Funcionando');

CREATE TABLE locations (
  id SERIAL PRIMARY KEY,
  customer_id INT references people(id),
  employee_id INT references people(id),
  booked_to DATE NULL,
  removed_at DATE NULL,
  returned_in DATE NULL,
  amount DECIMAL(13,2) DEFAULT 0
);
CREATE INDEX fk_locations_customer_id ON locations (customer_id);
CREATE INDEX fk_locations_employee_id ON locations (employee_id);

insert into locations (id, customer_id, employee_id, booked_to, removed_at, returned_in, amount) values(1, 2, 1, '2013-10-11', '2013-10-11', '2013-10-14', 10.35);
insert into locations (id, customer_id, employee_id, booked_to, removed_at, amount) values(2, 2, 1, '2013-10-11', '2013-10-11', 6.90);
insert into locations (id, customer_id, employee_id, booked_to, amount) values(3, 2, 1, '2013-11-05', 3.45);

CREATE TABLE medias_locations (
  media_id INT references medias(id),
  location_id INT references locations(id)
);
CREATE INDEX fk_medias_locations_media_id ON medias_locations (media_id);
CREATE INDEX fk_medias_locations_location_id ON medias_locations (location_id);

insert into medias_locations (media_id, location_id) values(1, 1);
insert into medias_locations (media_id, location_id) values(4, 1);
insert into medias_locations (media_id, location_id) values(6, 1);
insert into medias_locations (media_id, location_id) values(7, 2);
insert into medias_locations (media_id, location_id) values(1, 2);
insert into medias_locations (media_id, location_id) values(5, 3);

