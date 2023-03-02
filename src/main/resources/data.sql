CREATE TABLE person (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  birthdate DATE NOT NULL
);

CREATE TABLE address (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  street VARCHAR(255) NOT NULL,
  zipcode VARCHAR(255) NOT NULL,
  number VARCHAR(255) NOT NULL,
  city VARCHAR(255) NOT NULL,
  person_id BIGINT NOT NULL,
  is_main BIT NOT NULL,
  FOREIGN KEY (person_id) REFERENCES person(id)
);


INSERT INTO person (name, birthdate) VALUES
('João Silva', '1990-03-15'),
('Maria Santos', '1985-05-10'),
('Pedro Oliveira', '1992-12-01'),
('Ana Paula Costa', '1987-07-20'),
('Lucas Pereira', '1995-02-28'),
('Julia Souza', '1988-11-05'),
('Rafaela Santos', '1993-08-16'),
('Daniel Silva', '1997-04-22'),
('Fernanda Castro', '1989-01-09'),
('Thiago Costa', '1994-09-18'),
('Carla Santos', '1986-06-25'),
('Henrique Oliveira', '1991-10-12'),
('Paulo Rodrigues', '1996-03-30'),
('Camila Almeida', '1999-12-05'),
('Gustavo Costa', '1998-08-24');

INSERT INTO address (street, zipcode, number, city, is_main, person_id) VALUES
('Rua A', '11111-111', '100', 'São Paulo', true, 1),
('Rua B', '22222-222', '200', 'Rio de Janeiro', false, 1),
('Rua C', '33333-333', '300', 'Belo Horizonte', false, 2),
('Rua D', '44444-444', '400', 'Brasília', true, 2),
('Rua E', '55555-555', '500', 'Curitiba', true, 3),
('Rua F', '66666-666', '600', 'Porto Alegre', false, 3),
('Rua G', '77777-777', '700', 'Florianópolis', true, 4),
('Rua H', '88888-888', '800', 'São Paulo', false, 4),
('Rua I', '99999-999', '900', 'Rio de Janeiro', true, 5),
('Rua J', '00000-000', '1000', 'Belo Horizonte', false, 5),
('Rua K', '11111-111', '1100', 'Brasília', true, 6),
('Rua L', '22222-222', '1200', 'Curitiba', false, 6),
('Rua M', '33333-333', '1300', 'Porto Alegre', true, 7),
('Rua N', '44444-444', '1400', 'Florianópolis', false, 7),
('Rua O', '55555-555', '1500', 'São Paulo', true, 8);
