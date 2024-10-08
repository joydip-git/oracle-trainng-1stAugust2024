DROP TABLE products;
--create table products (
--    isbn INT primary key not null,
--    product_id NUMBER generated by default as identity,
--    product_name varchar(50) not null,
--    price decimal(18,2) default 0
--);
--considering categories table exist
--create table products (
--    isbn INT not null,
--    product_id NUMBER generated by default as identity,
--    product_name varchar(50) not null,
--    price decimal(18,2) default 0,
--    category_id int,
--    constraint products_isbn_pk primary key (isbn),
--    constraint categories_products_category_id_fk FOREIGN KEY ( category_id ) references categories ( category_id )
--);
--create table products (
--    isbn INT not null,
--    product_id NUMBER generated by default as identity,
--    product_name varchar(50) not null,
--    price decimal(18,2) default 0
--);
--alter table products 
--add constraint products_isbn_pk primary key (isbn);

ALTER TABLE products ADD product_desc VARCHAR2(4000);

ALTER TABLE products DROP COLUMN product_desc;

ALTER TABLE products ADD "description" VARCHAR2(255);

INSERT INTO products (
    isbn,
    product_name,
    price,
    "description"
) VALUES (
    1,
    'dell xps',
    10000,
    'new laptop from dell'
);

INSERT INTO products (
    isbn,
    product_name,
    price,
    "description"
) VALUES (
    2,
    'hp probook',
    12000,
    'new laptop from hp'
);

INSERT INTO products (
    isbn,
    product_name,
    price,
    "description"
) VALUES (
    3,
    'lenovo',
    11000,
    'new laptop from lenovo'
);

select * from products;

CREATE TABLE categories (
    category_id   INT
        GENERATED BY DEFAULT AS IDENTITY
    NOT NULL,
    category_name VARCHAR2(50) NOT NULL,
    CONSTRAINT category_category_id_pk PRIMARY KEY ( category_id )
);

INSERT INTO categories ( category_name ) VALUES ( 'laptop' );

INSERT INTO categories ( category_name ) VALUES ( 'mobile' );

INSERT INTO categories ( category_name ) VALUES ( 'book' );

ALTER TABLE products ADD category_id INT;

ALTER TABLE products
    ADD CONSTRAINT categories_products_category_id_fk FOREIGN KEY ( category_id )
        REFERENCES categories ( category_id );
        
update products set category_id=1;