create table if not exists room (
    id int NOT NULL AUTO_INCREMENT,
    name varchar (10) not null ,
    acreage float not null ,
    type varchar (20) not null ,
    PRIMARY KEY (id)
);