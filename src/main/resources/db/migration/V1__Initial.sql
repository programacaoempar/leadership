create schema if not exists public;

create table if not exists public.team
(
    id bigint not null
        constraint team_pkey
            primary key,
    name varchar(255)
);

create sequence team_id_seq;

create table if not exists public.led
(
    id bigint not null
        constraint led_pkey
            primary key,
    name varchar(255),
    team_id bigint not null
        constraint fk20i117qhfoimovmchfwhg5fdj
            references team
);

create sequence led_id_seq;



