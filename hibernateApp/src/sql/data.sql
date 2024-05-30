create table Person
(
    id   int PRIMARY KEY,
    name varchar(100),
    age  int
);

insert into Person (id, name, age) values (1, 'Test person', 20);

select * from Person