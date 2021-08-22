create table posts (
                       id serial primary key,
                       name varchar(2000),
                       description text,
                       created timestamp without time zone not null default now()
);

insert into posts (name, description) values ('О чем этот форум?', '.');
insert into posts (name, description) values ('Правила форума.', '.');