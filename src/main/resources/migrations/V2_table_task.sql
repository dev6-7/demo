create table if not exists tasker.task
(
    id   bigint not null
        primary key,
    name varchar(255),
    text varchar(255),
    group_id bigint,
    CONSTRAINT fk_group FOREIGN KEY(group_id) REFERENCES group(id)
);

