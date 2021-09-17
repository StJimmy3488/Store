create table address
(
    address_id     bigint       not null
        primary key,
    address_line_1 varchar(255) null,
    address_line_2 varchar(255) null,
    city           varchar(255) null,
    region         varchar(255) null,
    zip_code       varchar(255) null
);

create table category
(
    category_id bigint       not null
        primary key,
    created_at  date         not null,
    name        varchar(255) not null
);

create table country
(
    country_id       bigint       not null
        primary key,
    country_isd_code varchar(255) null,
    name             varchar(255) null
);

create table hibernate_sequence
(
    next_val bigint null
);

create table payment
(
    payment_id   bigint       not null
        primary key,
    account_no   varchar(255) not null,
    expiry       date         not null,
    payment_type varchar(255) not null,
    provider     varchar(255) not null
);

create table product
(
    product_id        bigint       not null
        primary key,
    created_at        date         not null,
    short_description varchar(255) not null,
    price             double       not null,
    name              bigint       not null,
    quantity          int          not null
);

create table review
(
    review_id  bigint                                   not null
        primary key,
    created_at date                                     not null,
    product_id bigint                                   not null,
    rating     enum ('A', 'AA', 'AAA', 'AAAA', 'AAAAA') not null,
    review     varchar(255)                             null,
    user_id    bigint                                   not null
);

create table user
(
    user_id    bigint                not null
        primary key,
    created_at date                  null,
    dob        date                  null,
    email      varchar(255)          null,
    first_name varchar(255)          null,
    gender     enum ('FEMALE, MALE') null,
    last_login date                  null,
    last_name  varchar(255)          null,
    password   varchar(255)          null,
    phone      varchar(255)          null,
    user_role  varchar(255)          null,
    username   varchar(255)          null
);

