alter table user
    drop column state;

alter table address
    add column state VARCHAR(255) NOT NULL;