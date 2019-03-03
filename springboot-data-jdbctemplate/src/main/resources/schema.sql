
create table PRODUCT
(
   PRODUCT_ID integer not null,
   PRODUCT_NAME varchar(255) not null,
   PRODUCT_PRICE integer not null,
   PRODUCT_DESC varchar(255) not null,

   primary key(PRODUCT_ID)
);