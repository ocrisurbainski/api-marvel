create table "STORIES" (
    "ID" bigint primary key,
    "NAME" varchar,
    "TYPE" int,
    "ID_CHARACTERS" bigint not null,
    foreign key ("ID_CHARACTERS") references "CHARACTERS" ("ID")
);