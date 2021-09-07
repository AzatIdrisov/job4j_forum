create table posts (
                       id serial primary key,
                       name varchar(2000),
                       description text,
                       created timestamp without time zone not null default now()
);

create table messages (
                       id serial primary key,
                       content text,
                       created timestamp without time zone not null default now(),
                       posts_id  int not null references posts (id),
                       author text
);

insert into posts (name, description) values ('О чем этот форум?', '.');
insert into posts (name, description) values ('Правила форума.', '.');