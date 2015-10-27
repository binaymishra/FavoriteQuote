DROP TABLE quote IF EXISTS;
DROP TABLE author IF EXISTS;

CREATE TABLE author(
  	id         					SMALLINT,		
  	firstName 					VARCHAR(40),
  	middleName 					VARCHAR(40),
  	lastName 					VARCHAR(40),
  	CONSTRAINT pk_author PRIMARY KEY (id)
);

CREATE TABLE quote(
  	id         				SMALLINT,		
  	quote 					VARCHAR(4000),
  	author_id				SMALLINT,
  	CONSTRAINT pk_quote PRIMARY KEY (id),
  	CONSTRAINT fk_author FOREIGN KEY (author_id) REFERENCES author (id)
);

