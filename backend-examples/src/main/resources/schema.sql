create table if not exists `user_end`
(
    id          char(19) not null primary key,
    name        varchar(45) not null,
    account     varchar(16) not null,
    role        char(4) not null ,
    password    varchar(70) not null,
    create_time datetime not null default current_timestamp,
    update_time datetime not null default current_timestamp on update current_timestamp,

    unique(account)
);

