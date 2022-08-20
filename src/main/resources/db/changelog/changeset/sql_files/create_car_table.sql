create table car(
    id bigserial primary key,
    model varchar,
    horsepower int,
    person_id bigserial,
    constraint fk_owner_id foreign key (person_id) references person(id) on delete cascade
);