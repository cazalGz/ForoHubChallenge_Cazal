create table topics
(
    id        bigint       not null auto_increment,
    title     varchar(100) not null unique,
    message   varchar(500) not null unique,
    creation  datetime     not null,
    status    varchar(100) not null,
    author_id bigint       not null,
    course    varchar(100) not null,
    primary key (id),
    constraint fk_topics_author_id foreign key (author_id) references users (id)
);