CREATE DATABASE VideoLocadora;

CREATE TABLE actors (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);

INSERT INTO actors (name) VALUES
    ('Brad Pit'),
    ('Júlia Roberts'),
    ('Robert de Niro'),
    ('Leonardo D`Caprio'),
    ('Silvester Stalone'),
    ('Tom Cruise'),
    ('Will Smith'),
    ('Jessica Biel');
