CREATE TABLE Person
(
    id            int primary key GENERATED BY DEFAULT AS IDENTITY,
    username      varchar(100) not null,
    year_of_birth int          not null,
    password      varchar      not null
);

ALTER TABLE Person
    ADD COLUMN role varchar(100) NOT NULL;

insert into Person(username, year_of_birth, password)
values ('test_user1', 1960, 'test_password');

insert into Person(username, year_of_birth, password)
values ('test_user2', 1960, 'test_password');

TRUNCATE TABLE Person;

UPDATE Person set role='ROLE_ADMIN' where id=9;

