create database zportal
    if not exists
    default charset utf8
    collate utf8_general_ci;

use zportal;


create table users (
    `id`        int             not null        primary key     auto_increment,
    `name`      varchar(100)    not null
);

create table projects (
    `id`        int             not null        primary key     auto_increment,
    `name`      varchar(100)    not null
);
