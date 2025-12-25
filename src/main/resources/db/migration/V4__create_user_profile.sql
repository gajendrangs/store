create table profile (
  id bigint primary key,
  bio text,
  phone_number varchar(20),
  date_of_birth date,
  loyalty_points int unsigned default 0,

  foreign key (id)
    references user (id)
    on delete cascade
);