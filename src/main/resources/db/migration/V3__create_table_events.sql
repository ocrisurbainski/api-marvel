create table "EVENTS" (
    "ID" bigint primary key,
    "NAME" varchar,
    "ID_CHARACTERS" bigint not null,
    foreign key ("ID_CHARACTERS") references "CHARACTERS" ("ID")
);