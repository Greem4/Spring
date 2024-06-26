drop table Person;

create table Person
(
    id    int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name  varchar not null,
    age   int check ( age > 0 ),
    email varchar(100) UNIQUE
);

create table Item
(
    id int primary key generated by default as identity,
    person_id int references person(id) on delete set null,
    item_name varchar(100) not null
);

alter table Person add column email varchar(100) unique;


create table Director
(
    director_id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name        varchar(100) not null UNIQUE,
    age         int CHECK ( age > 10 )
);

drop table Movie;

create table Movie
(
    movie_id           int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    director_id        int          NOT NULL REFERENCES Director (director_id),
    name               varchar(200) not null,
    year_of_production int CHECK (year_of_production > 1900)
);

insert into Director(name, age)
values ('Quentin Tarantino', 57);
insert into Director(name, age)
values ('Martini Scorsese', 78);
insert into Director(name, age)
values ('Guy Richie', 52);
insert into Director(name, age)
values ('Woody Allen', 85);
insert into Director(name, age)
values ('David Lynch', 74);
insert into Director(name, age)
values ('Christopher Nolan', 50);

INSERT INTO Movie(director_id, name, year_of_production)
VALUES (1, 'Reservoir Dogs', 1992);
INSERT INTO Movie(director_id, name, year_of_production)
VALUES (1, 'Pulp Fiction', 1994);
INSERT INTO Movie(director_id, name, year_of_production)
VALUES (1, 'The Hateful Eight', 2015);
INSERT INTO Movie(director_id, name, year_of_production)
VALUES (1, 'Once Upon a Time in Hollywood', 2019);
INSERT INTO Movie(director_id, name, year_of_production)
VALUES (2, 'Taxi Driver', 1976);
INSERT INTO Movie(director_id, name, year_of_production)
VALUES (2, 'Good-fellas', 1990);
INSERT INTO Movie(director_id, name, year_of_production)
VALUES (2, 'The Wolf of Wall Street', 2013);
INSERT INTO Movie(director_id, name, year_of_production)
VALUES (3, 'Lock, Stock and Two Smoking Barrels', 1998);
INSERT INTO Movie(director_id, name, year_of_production)
VALUES (3, 'Snatch', 2000);
INSERT INTO Movie(director_id, name, year_of_production)
VALUES (4, 'Midnight in Paris', 2011);
INSERT INTO Movie(director_id, name, year_of_production)
VALUES (6, 'Inception', 2010);


create table Citizen
(
    citizen_id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name       varchar(100) not null,
    age        int check ( age > 0 )
);

create table Passport
(
    citizen_id      int PRIMARY KEY references Citizen (citizen_id),
    passport_number int
);

INSERT INTO Citizen(name, age)
VALUES ('Bob', 12);
INSERT INTO Citizen(name, age)
VALUES ('Tom', 24);
INSERT INTO Citizen(name, age)
VALUES ('Katy', 39);
INSERT INTO Citizen(name, age)
VALUES ('Alice', 45);

INSERT INTO Passport(citizen_id, passport_number)
VALUES (1, 12345);
INSERT INTO Passport(citizen_id, passport_number)
VALUES (2, 75124);
INSERT INTO Passport(citizen_id, passport_number)
VALUES (3, 91245);
INSERT INTO Passport(citizen_id, passport_number)
VALUES (4, 19259);

CREATE TABLE Actor
(
    actor_id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name     varchar(100) NOT NULL UNIQUE,
    age      int CHECK (age > 0)
);

INSERT INTO Actor(name, age)
VALUES ('Harvey Keitel', 81);
INSERT INTO Actor(name, age)
VALUES ('Robert De Niro', 77);
INSERT INTO Actor(name, age)
VALUES ('Leonardo DiCaprio', 46);
INSERT INTO Actor(name, age)
VALUES ('Jason Statham', 53);
INSERT INTO Actor(name, age)
VALUES ('Joe Pesci', 77);
INSERT INTO Actor(name, age)
VALUES ('Samuel L. Jackson', 72);

create table Actor_Movie
(
    actor_id int references Actor (actor_id),
    movie_id int references Movie (movie_id),
    PRIMARY KEY (actor_id, movie_id)
);

INSERT INTO Actor_Movie
VALUES (1, 1);
INSERT INTO Actor_Movie
VALUES (1, 2);
INSERT INTO Actor_Movie
VALUES (2, 5);
INSERT INTO Actor_Movie
VALUES (2, 6);
INSERT INTO Actor_Movie
VALUES (3, 4);
INSERT INTO Actor_Movie
VALUES (3, 7);
INSERT INTO Actor_Movie
VALUES (3, 11);
INSERT INTO Actor_Movie
VALUES (4, 8);
INSERT INTO Actor_Movie
VALUES (4, 9);
INSERT INTO Actor_Movie
VALUES (5, 6);
INSERT INTO Actor_Movie
VALUES (6, 2);
INSERT INTO Actor_Movie
VALUES (6, 3);

-- many to many
select actor.name, Movie.name
from actor
         join actor_movie
              on actor.actor_id = actor_movie.actor_id
         join movie
              on actor_movie.movie_id = movie.movie_id;

drop table "Order";
drop table Person;

CREATE TABLE Person(
    user_id int generated by default as identity primary key ,
    name varchar(100) not null ,
    age int
);

create table "Order"(
    order_id int generated by default as identity primary key ,
    user_id int references Person(user_id) on delete set null ,
    item_name varchar(100)
);

insert into Person (name, age, email) VALUES ('Tom', 25, 'tom@mail.com');
insert into Person (name, age, email) VALUES ('Bob', 31, 'bob1@mail.com');
insert into Person (name, age, email) VALUES ('Bob', 53, 'bob2@mail.com');
insert into Person (name, age, email) VALUES ('Bob', 20, 'bob3@mail.com');
insert into Person (name, age, email) VALUES ('Katy', 14, 'katy@mail.com');



drop table Item;

insert into Item(person_id, item_name) VALUES (1, 'Airpods');
insert into Item(person_id, item_name) VALUES (1, 'Playstation');
insert into Item(person_id, item_name) VALUES (1, 'Tv');



insert into Item(person_id, item_name) VALUES (1, 'Book');
insert into Item(person_id, item_name) VALUES (1, 'AirPods');
insert into Item(person_id, item_name) VALUES (2, 'Iphone');
insert into Item(person_id, item_name) VALUES (3, 'Kindle');
insert into Item(person_id, item_name) VALUES (3, 'TV');
insert into Item(person_id, item_name) VALUES (3, 'PlayStation');




alter table Person add column date_of_birth date;
alter table Person add column created_at timestamp;

alter table Person add column mood int;
alter table Person add column mood varchar;