create table wishlist (
    user_id bigint not null,
    product_id bigint not null,
    primary key (user_id, product_id),
    foreign key (user_id) references user(id) on delete cascade,
    foreign key (product_id) references product(id) on delete cascade
);