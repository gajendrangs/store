CREATE TABLE
  user (
    id bigint NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    PRIMARY KEY (id)
  );

CREATE TABLE
  address (
    id bigint NOT NULL AUTO_INCREMENT,
    street varchar(255) NOT NULL,
    city varchar(255) NOT NULL,
    zip varchar(255) NOT NULL,
    user_id bigint NOT NULL,
    PRIMARY KEY (id),
    KEY address_relation_1 (user_id),
    CONSTRAINT address_relation_1 FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE ON UPDATE CASCADE
  );