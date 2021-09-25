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
    sub_total         double       not null,
    created_at        date         null,
    session_id        int          not null,
    shipping          double       null,
    order_status      varchar(255) not null,
    total             double       null,
    user_id           int          not null,
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
    product_created_at        date         null,
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
    file_name  varchar(255) not null,
    product_id bigint       null,
    constraint FKgpextbyee3uk9u6o2381m7ft1
        foreign key (product_id) references product (product_id)
);

create table order_item
(
    order_item_id       bigint not null
        primary key,
    order_item_added_at date   not null,
    order_item_price    double not null,
    order_item_quantity int    not null,
    product_id          bigint null,
    order_settings_id   bigint null,
    constraint FK551losx9j75ss5d6bfsqvijna
        foreign key (product_id) references product (product_id),
    constraint FKd8ucrjbxfk2xna396vx8qdov5
        foreign key (order_settings_id) references order_settings (order_settings_id)
);

create table role
(
    role_id   bigint       not null
        primary key,
    role_name varchar(255) null
);

create table user
(
    user_id         bigint       not null
        primary key,
    user_created_at date         not null,
    user_dob        date         null,
    user_email      varchar(255) not null,
    user_first_name varchar(255) not null,
    user_gender     varchar(255) null,
    user_last_login date         null,
    user_last_name  varchar(255) not null,
    user_password   varchar(255) not null,
    user_phone      varchar(255) null,
    user_username   varchar(255) not null,
    constraint UK_j09k2v8lxofv2vecxu2hde9so
        unique (user_email),
    constraint UK_jnu1quvkutdk73q9fa4d7abe3
        unique (user_username)
);

create table cart
(
    cart_id    bigint       not null
        primary key,
    cart_token varchar(255) null,
    session_id varchar(255) null,
    user_id    bigint       null,
    constraint FKl70asp4l4w0jmbm1tqyofho4o
        foreign key (user_id) references user (user_id)
);

create table cart_item
(
    cart_item_id         bigint not null
        primary key,
    cart_item_created_at date   not null,
    quantity             int    not null,
    cart_id              bigint not null,
    product_id           bigint not null,
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
    user_address_line_1    varchar(255) not null,
    user_address_line_2    varchar(255) null,
    user_address_city      varchar(255) not null,
    user_address_region    varchar(255) not null,
    user_address__zip_code varchar(255) not null,
    country_country_id     bigint       null,
    user_user_id           bigint       null,
    constraint FKcp5ewg2f9dl5bi95u5ebqu265
        foreign key (user_user_id) references user (user_id),
    constraint FKlsxee070n0ut1litg89bouy6e
        foreign key (country_country_id) references country (country_id)
);

create table user_review
(
    user_review_id         bigint       not null
        primary key,
    user_review            varchar(255) not null,
    user_review_created_at date         not null,
    user_rating            int          null,
    user_id                bigint       null,
    product_id             bigint       null,
    constraint FKdar2k0tl4t2m2j7pbvgxn9reo
        foreign key (product_id) references product (product_id),
    constraint FKk4378yigvs29qpwh8ughgs4gk
        foreign key (user_id) references user (user_id)
);

create table user_role
(
    user_id bigint not null,
    role_id bigint not null,
    constraint FK859n2jvi8ivhui0rl0esws6o
        foreign key (user_id) references user (user_id),
    constraint FKa68196081fvovjhkek5m97n3y
        foreign key (role_id) references role (role_id)
);

INSERT INTO product_category VALUES
                                 (1,'2021-09-19','Phones & Accessories'),
                                 (2,'2021-09-16','Garden'),
                                 (3,'2021-09-21','Computers & Netbooks');



LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'2021-09-21','The Samsung Galaxy Z Fold3 5G speaks volumes about the South Korean electronics maker Samsung’s efforts to add finesse to its foldable devices.',1620,15,'Samsung Galaxy Z Fold3 5G',1),
                             (2,'2021-09-20','Samsung Galaxy s21 5G',830.25,32,'Samsung Galaxy s21 5G',1),
                             (3,'2021-09-19','The iPhone 13 Pro and iPhone 13 Pro Max are Apple\'s new high-end flagship iPhones. Now available.',1599,10,'Apple iPhone 13 Pro Max',1),
                             (4,'2021-09-18','Text text text text text text text text text text text text text text text text text',456,15,'HONOR Magic3 PRO',1),
                             (5,'2021-09-17','Text text text text text text text text text text text text text text text text text',258,26,'HTC Desire 20+',2),
                             (6,'2021-09-16','Text text text text text text text text text text text text text text text text text',985,32,'NOKIA C30',2),
                             (7,'2021-09-15','Text text text text text text text text text text text text text text text text text',1256.45,5,'XIAOMI Redmi 10 Prime',2),
                             (8,'2021-09-14','Text text text text text text text text text text text text text text text text text',999.99,41,'OPPO  Reno6',2),
                             (9,'2021-09-13','Text text text text text text text text text text text text text text text text text',300,30,'SONY Xperia 5 III',1),
                             (10,'2021-09-12','Text text text text text text text text text text text text text text text text text',687.49,0,'MOTOROLA Moto E20',1),
                             (11,'2021-09-25','Sākuma nots: aldehīdi, ananass, zaļais mandarīns, galbanums, persiks. Sirds nots: neļķe, āda, dzeltenā narcise, muskuss, orhideja. Beigu nots: ambra, sandalkoks, tonka pupiņas, vaniļa, vetivērija.',687.49,0,'Tualetes ūdens Cartier Must de Cartier 100ml EDT',3);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;