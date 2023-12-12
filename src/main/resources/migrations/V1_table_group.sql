create table if not exists tasker.group
(
    id   bigint not null
        primary key,
    name varchar(255),
    description varchar(255)
);

