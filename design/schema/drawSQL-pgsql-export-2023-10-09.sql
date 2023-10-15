CREATE TABLE "events_acts"(
    "id" INTEGER NOT NULL,
    "act_id" INTEGER NOT NULL,
    "event_id" INTEGER NOT NULL
);
ALTER TABLE
    "events_acts" ADD PRIMARY KEY("id");
CREATE TABLE "role"(
    "id" INTEGER NOT NULL,
    "role_name" TEXT NOT NULL,
    "permissions" INTEGER NOT NULL
);
ALTER TABLE
    "role" ADD PRIMARY KEY("id");
CREATE TABLE "genres_bands"(
    "id" INTEGER NOT NULL,
    "band_id" INTEGER NOT NULL,
    "genre_id" INTEGER NOT NULL
);
ALTER TABLE
    "genres_bands" ADD PRIMARY KEY("id");
CREATE TABLE "account"(
    "id" INTEGER NOT NULL,
    "role_id" INTEGER NOT NULL,
    "username" TEXT NOT NULL,
    "email" TEXT NOT NULL,
    "hashed_password" CHAR(255) NOT NULL,
    "salt" CHAR(255) NOT NULL
);
ALTER TABLE
    "account" ADD PRIMARY KEY("id");
CREATE TABLE "act"(
    "id" INTEGER NOT NULL,
    "beginning" TIME(0) WITHOUT TIME ZONE NOT NULL,
    "finale" TIME(0) WITHOUT TIME ZONE NOT NULL,
    "band_id" INTEGER NOT NULL
);
ALTER TABLE
    "act" ADD PRIMARY KEY("id");
CREATE TABLE "band"(
    "id" INTEGER NOT NULL,
    "name" TEXT NOT NULL
);
ALTER TABLE
    "band" ADD PRIMARY KEY("id");
CREATE TABLE "genre"(
    "id" INTEGER NOT NULL,
    "name" TEXT NOT NULL
);
ALTER TABLE
    "genre" ADD PRIMARY KEY("id");
CREATE TABLE "event"(
    "id" INTEGER NOT NULL,
    "name" TEXT NOT NULL
);
ALTER TABLE
    "event" ADD PRIMARY KEY("id");
CREATE TABLE "local"(
    "id" INTEGER NOT NULL,
    "id_account_manager" INTEGER NOT NULL,
    "direccion" TEXT NOT NULL,
    "name" TEXT NOT NULL,
    "aforo" SMALLINT NOT NULL,
    "apertura" TIME(0) WITHOUT TIME ZONE NOT NULL,
    "cierre" TIME(0) WITHOUT TIME ZONE NOT NULL
);
ALTER TABLE
    "local" ADD PRIMARY KEY("id");
ALTER TABLE
    "local" ADD CONSTRAINT "local_id_account_manager_foreign" FOREIGN KEY("id_account_manager") REFERENCES "account"("id");
ALTER TABLE
    "events_acts" ADD CONSTRAINT "events_acts_event_id_foreign" FOREIGN KEY("event_id") REFERENCES "event"("id");
ALTER TABLE
    "account" ADD CONSTRAINT "account_role_id_foreign" FOREIGN KEY("role_id") REFERENCES "role"("id");
ALTER TABLE
    "events_acts" ADD CONSTRAINT "events_acts_act_id_foreign" FOREIGN KEY("act_id") REFERENCES "act"("id");
ALTER TABLE
    "genres_bands" ADD CONSTRAINT "genres_bands_band_id_foreign" FOREIGN KEY("band_id") REFERENCES "band"("id");
ALTER TABLE
    "act" ADD CONSTRAINT "act_band_id_foreign" FOREIGN KEY("band_id") REFERENCES "band"("id");
ALTER TABLE
    "genres_bands" ADD CONSTRAINT "genres_bands_genre_id_foreign" FOREIGN KEY("genre_id") REFERENCES "genre"("id");
