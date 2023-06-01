-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-05-16 13:32:16.88

-- tables
-- Table: address
CREATE TABLE address (
    id serial  NOT NULL,
    street varchar(255)  NOT NULL,
    longtitude decimal(6,4)  NULL,
    latitude decimal(6,4)  NULL,
    CONSTRAINT address_pk PRIMARY KEY (id)
);

-- Table: availability
CREATE TABLE availability (
    id serial  NOT NULL,
    studio_id int  NOT NULL,
    start_date date  NOT NULL,
    end_date date  NOT NULL,
    start_hour int  NOT NULL,
    end_hour int  NOT NULL,
    CONSTRAINT availability_pk PRIMARY KEY (id)
);

-- Table: booking
CREATE TABLE booking (
    id serial  NOT NULL,
    studio_id int  NOT NULL,
    customer_id int NULL,
    date date  NOT NULL,
    total_price int  NOT NULL,
    CONSTRAINT booking_pk PRIMARY KEY (id)
);

-- Table: customer
CREATE TABLE customer (
    id serial  NOT NULL,
    name varchar(100)  NOT NULL,
    phone varchar(8)  NOT NULL,
    email varchar(100)  NOT NULL,
    CONSTRAINT customer_pk PRIMARY KEY (id)
);

-- Table: district
CREATE TABLE district (
    id serial  NOT NULL,
    name varchar(255)  NOT NULL,
    CONSTRAINT district_pk PRIMARY KEY (id)
);

-- Table: extra
CREATE TABLE extra (
    id serial  NOT NULL,
    name varchar(255)  NOT NULL,
    CONSTRAINT extra_pk PRIMARY KEY (id)
);

-- Table: extra_booking
CREATE TABLE extra_booking (
    id serial  NOT NULL,
    extra_id int  NOT NULL,
    booking_id int  NOT NULL,
    price int  NOT NULL,
    CONSTRAINT extra_booking_pk PRIMARY KEY (id)
);

-- Table: hour
CREATE TABLE hour (
    id serial  NOT NULL,
    booking_id int  NOT NULL,
    start int  NOT NULL,
    CONSTRAINT hour_pk PRIMARY KEY (id)
);

-- Table: image
CREATE TABLE image (
    id serial  NOT NULL,
    data bytea  NOT NULL,
    CONSTRAINT image_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role (
    id serial  NOT NULL,
    name varchar(20)  NOT NULL,
    CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: studio
CREATE TABLE studio (
    id serial  NOT NULL,
    owner_user_id int  NOT NULL,
    name varchar(255)  NOT NULL,
    url varchar(255)  NOT NULL,
    hour_price int  NOT NULL,
    status char(1)  NOT NULL,
    image_id int  NULL,
    address_id int  NOT NULL,
    district_id int  NOT NULL,
    CONSTRAINT studio_pk PRIMARY KEY (id)
);

-- Table: studio_extra
CREATE TABLE studio_extra (
    id serial  NOT NULL,
    studio_id int  NOT NULL,
    extra_id int  NOT NULL,
    price int  NOT NULL,
    CONSTRAINT studio_extra_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
    id serial  NOT NULL,
    role_id int  NOT NULL,
    username varchar(255)  NOT NULL,
    password varchar(255)  NOT NULL,
    email varchar(255)  NOT NULL,
    status char(1)  NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: booking_customer (table: booking)
ALTER TABLE booking ADD CONSTRAINT booking_customer
    FOREIGN KEY (customer_id)
    REFERENCES customer (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: booking_studio (table: booking)
ALTER TABLE booking ADD CONSTRAINT booking_studio
    FOREIGN KEY (studio_id)
    REFERENCES studio (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: extra_booking_booking (table: extra_booking)
ALTER TABLE extra_booking ADD CONSTRAINT extra_booking_booking
    FOREIGN KEY (booking_id)
    REFERENCES booking (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: extra_booking_extra (table: extra_booking)
ALTER TABLE extra_booking ADD CONSTRAINT extra_booking_extra
    FOREIGN KEY (extra_id)
    REFERENCES extra (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: hour_booking (table: hour)
ALTER TABLE hour ADD CONSTRAINT hour_booking
    FOREIGN KEY (booking_id)
    REFERENCES booking (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: schedule_studio (table: availability)
ALTER TABLE availability ADD CONSTRAINT schedule_studio
    FOREIGN KEY (studio_id)
    REFERENCES studio (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: studio_address (table: studio)
ALTER TABLE studio ADD CONSTRAINT studio_address
    FOREIGN KEY (address_id)
    REFERENCES address (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: studio_district (table: studio)
ALTER TABLE studio ADD CONSTRAINT studio_district
    FOREIGN KEY (district_id)
    REFERENCES district (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: studio_extra_extra (table: studio_extra)
ALTER TABLE studio_extra ADD CONSTRAINT studio_extra_extra
    FOREIGN KEY (extra_id)
    REFERENCES extra (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: studio_extra_studio (table: studio_extra)
ALTER TABLE studio_extra ADD CONSTRAINT studio_extra_studio
    FOREIGN KEY (studio_id)
    REFERENCES studio (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: studio_image (table: studio)
ALTER TABLE studio ADD CONSTRAINT studio_image
    FOREIGN KEY (image_id)
    REFERENCES image (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: studio_owner (table: studio)
ALTER TABLE studio ADD CONSTRAINT studio_owner
    FOREIGN KEY (owner_user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_role (table: user)
ALTER TABLE "user" ADD CONSTRAINT user_role
    FOREIGN KEY (role_id)
    REFERENCES role (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

