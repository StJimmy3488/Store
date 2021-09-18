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
    payment_id     bigint       not null
        primary key,
    account_number varchar(255) not null,
    expiry         date         not null,
    payment_type   varchar(255) not null,
    provider       varchar(255) not null
);

create table product
(
    product_id                bigint       not null
        primary key,
    product_created_at        date         not null,
    product_short_description varchar(255) not null,
    product_price             double       not null,
    product_quantity          int          not null,
    product_name              varchar(255) not null
);

create table product_category
(
    product_category_id         bigint       not null
        primary key,
    product_category_created_at date         not null,
    product_category_name       varchar(255) not null
);

create table user
(
    user_id         bigint                not null
        primary key,
    user_created_at date                  null,
    user_dob        date                  null,
    user_email      varchar(255)          null,
    user_first_name varchar(255)          null,
    user_gender     enum ('FEMALE, MALE') null,
    user_last_login date                  null,
    user_last_name  varchar(255)          null,
    user_phone      varchar(255)          null,
    user_password   varchar(255)          null,
    user_user_role  varchar(255)          null,
    user_username   varchar(255)          null
);

create table user_address
(
    user_address_id        bigint       not null
        primary key,
    user_address_line_1    varchar(255) null,
    user_address_line_2    varchar(255) null,
    user_address_city      varchar(255) null,
    user_address_region    varchar(255) null,
    user_address__zip_code varchar(255) null
);

create table user_review
(
    user_review_id         bigint                                   not null
        primary key,
    user_review            varchar(255)                             null,
    user_review_created_at date                                     not null,
    user_rating            enum ('A', 'AA', 'AAA', 'AAAA', 'AAAAA') not null
);

