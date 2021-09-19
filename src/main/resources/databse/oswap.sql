create table country
(
    country_id       bigint       not null
        primary key,
    country_isd_code varchar(255) not null,
    name             varchar(255) not null
);

create table hibernate_sequence
(
    next_val bigint null
);

create table order_settings
(
    order_settings_id bigint       not null
        primary key,
    sub_total         double       null,
    created_at        date         null,
    session_id        int          null,
    shipping          double       null,
    order_status      varchar(255) null,
    total             double       null,
    user_id           int          null,
    vat               double       null
);

create table product_category
(
    product_category_id         bigint       not null
        primary key,
    product_category_created_at date         not null,
    product_category_name       varchar(255) not null
);

create table product
(
    product_id                bigint       not null
        primary key,
    product_created_at        date         not null,
    product_short_description varchar(255) not null,
    product_price             double       not null,
    product_quantity          int          not null,
    product_name              varchar(255) not null,
    product_category_id       bigint       null,
    constraint FKcwclrqu392y86y0pmyrsi649r
        foreign key (product_category_id) references product_category (product_category_id)
);

create table image
(
    image_id   bigint       not null
        primary key,
    file_name  varchar(255) null,
    product_id bigint       null,
    constraint FKgpextbyee3uk9u6o2381m7ft1
        foreign key (product_id) references product (product_id)
);

create table order_item
(
    order_item_id       bigint not null
        primary key,
    order_item_added_at date   null,
    order_item_price    double null,
    order_item_quantity int    null,
    product_id          bigint null,
    order_settings_id   bigint null,
    constraint FK551losx9j75ss5d6bfsqvijna
        foreign key (product_id) references product (product_id),
    constraint FKd8ucrjbxfk2xna396vx8qdov5
        foreign key (order_settings_id) references order_settings (order_settings_id)
);

create table user
(
    user_id         bigint       not null
        primary key,
    user_created_at date         null,
    user_dob        date         null,
    user_email      varchar(255) not null,
    user_first_name varchar(255) not null,
    user_gender     varchar(255) null,
    user_last_login date         null,
    user_last_name  varchar(255) not null,
    user_phone      varchar(255) null,
    user_password   varchar(255) not null,
    user_user_role  varchar(255) null,
    user_username   varchar(255) not null
);

create table cart
(
    cart_id    bigint       not null
        primary key,
    cart_token varchar(255) not null,
    session_id varchar(255) not null,
    user_id    bigint       null,
    constraint FKl70asp4l4w0jmbm1tqyofho4o
        foreign key (user_id) references user (user_id)
);

create table cart_item
(
    cart_item_id         bigint not null
        primary key,
    cart_item_created_at date   null,
    quantity             int    null,
    cart_id              bigint null,
    product_id           bigint null,
    constraint FK1uobyhgl1wvgt1jpccia8xxs3
        foreign key (cart_id) references cart (cart_id),
    constraint FKjcyd5wv4igqnw413rgxbfu4nv
        foreign key (product_id) references product (product_id)
);

create table payment
(
    payment_id     bigint       not null
        primary key,
    account_number varchar(255) not null,
    expiry         date         not null,
    payment_type   varchar(255) not null,
    provider       varchar(255) not null,
    user_id        bigint       null,
    constraint FK4spfnm9si9dowsatcqs5or42i
        foreign key (user_id) references user (user_id)
);

create table user_address
(
    user_address_id        bigint       not null
        primary key,
    user_address_line_1    varchar(255) null,
    user_address_line_2    varchar(255) null,
    user_address_city      varchar(255) null,
    user_address_region    varchar(255) null,
    user_address__zip_code varchar(255) null,
    country_country_id     bigint       null,
    user_user_id           bigint       null,
    constraint FKcp5ewg2f9dl5bi95u5ebqu265
        foreign key (user_user_id) references user (user_id),
    constraint FKlsxee070n0ut1litg89bouy6e
        foreign key (country_country_id) references country (country_id)
);

create table user_review
(
    user_review_id         bigint                                   not null
        primary key,
    user_review            varchar(255)                             null,
    user_review_created_at date                                     not null,
    user_rating            enum ('A', 'AA', 'AAA', 'AAAA', 'AAAAA') not null,
    user_id                bigint                                   null,
    product_id             bigint                                   null,
    constraint FKdar2k0tl4t2m2j7pbvgxn9reo
        foreign key (product_id) references product (product_id),
    constraint FKk4378yigvs29qpwh8ughgs4gk
        foreign key (user_id) references user (user_id)
);

