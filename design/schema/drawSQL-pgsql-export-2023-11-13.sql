CREATE TABLE "role"(
    "id" SERIAL NOT NULL,
    "role_name" TEXT NOT NULL
);
ALTER TABLE
    "role" ADD PRIMARY KEY("id");
CREATE TABLE "band"(
    "id" SERIAL NOT NULL,
    "name" VARCHAR(255) NOT NULL,
    "logo_url" BIGINT NOT NULL,
    "rate" DECIMAL(8, 2) NOT NULL
);
ALTER TABLE
    "band" ADD PRIMARY KEY("id");
CREATE TABLE "card_payment"(
    "id" SERIAL NOT NULL,
    "card_number" VARCHAR(8) NOT NULL,
    "holder" VARCHAR(255) NOT NULL,
    "bank" VARCHAR(255) NOT NULL,
    "ticket_id" INTEGER NOT NULL
);
ALTER TABLE
    "card_payment" ADD PRIMARY KEY("id");
CREATE TABLE "event_act"(
    "id" SERIAL NOT NULL,
    "start_time" TIME(0) WITHOUT TIME ZONE NOT NULL,
    "end_time" TIME(0) WITHOUT TIME ZONE NOT NULL,
    "band_id" INTEGER NOT NULL,
    "event_id" BIGINT NOT NULL
);
ALTER TABLE
    "event_act" ADD PRIMARY KEY("id");
CREATE TABLE "event"(
    "id" SERIAL NOT NULL,
    "name" TEXT NOT NULL,
    "description" TEXT NOT NULL,
    "realization_date" DATE NOT NULL,
    "banner_url" TEXT NOT NULL,
    "cover_url" BIGINT NOT NULL,
    "entrance_fee" DECIMAL(8, 2) NOT NULL,
    "starting_time" TIME(0) WITHOUT TIME ZONE NOT NULL,
    "closing_time" TIME(0) WITHOUT TIME ZONE NOT NULL
);
ALTER TABLE
    "event" ADD PRIMARY KEY("id");
CREATE TABLE "cash_payment"(
    "id" SERIAL NOT NULL,
    "fullname" TEXT NOT NULL,
    "dni" VARCHAR(255) NOT NULL,
    "ticket_id" INTEGER NOT NULL
);
ALTER TABLE
    "cash_payment" ADD PRIMARY KEY("id");
CREATE TABLE "ticket"(
    "id" SERIAL NOT NULL,
    "event_id" INTEGER NOT NULL,
    "customer_id" INTEGER NOT NULL,
    "net_entrance_fee" DECIMAL(8, 2) NOT NULL,
    "discount" DECIMAL(8, 2) NOT NULL
);
ALTER TABLE
    "ticket" ADD PRIMARY KEY("id");
CREATE TABLE "band_member"(
    "id" SERIAL NOT NULL,
    "fullname" VARCHAR(269) NOT NULL,
    "photo_url" VARCHAR(512) NULL,
    "band_id" INTEGER NOT NULL
);
ALTER TABLE
    "band_member" ADD PRIMARY KEY("id");
CREATE TABLE "genre"(
    "id" SERIAL NOT NULL,
    "name" TEXT NOT NULL
);
ALTER TABLE
    "genre" ADD PRIMARY KEY("id");
CREATE TABLE "account"(
    "id" SERIAL NOT NULL,
    "role_id" INTEGER NOT NULL,
    "username" TEXT NOT NULL,
    "email" TEXT NOT NULL,
    "hashed_password" CHAR(255) NOT NULL,
    "salt" CHAR(255) NOT NULL
);
ALTER TABLE
    "account" ADD PRIMARY KEY("id");
CREATE TABLE "locale"(
    "id" SERIAL NOT NULL,
    "manager_account_id" INTEGER NOT NULL,
    "name" TEXT NOT NULL,
    "address" TEXT NOT NULL,
    "geolocation" VARCHAR(255) NOT NULL,
    "capacity" SMALLINT NOT NULL,
    "opening_hour" TIME(0) WITHOUT TIME ZONE NOT NULL,
    "closing_time" TIME(0) WITHOUT TIME ZONE NOT NULL
);
ALTER TABLE
    "locale" ADD PRIMARY KEY("id");
CREATE TABLE "genres_bands"(
    "id" SERIAL NOT NULL,
    "genre_id" INTEGER NOT NULL,
    "band_id" INTEGER NOT NULL
);
ALTER TABLE
    "genres_bands" ADD PRIMARY KEY("id");
ALTER TABLE
    "locale" ADD CONSTRAINT "locale_manager_account_id_foreign" FOREIGN KEY("manager_account_id") REFERENCES "account"("id");
ALTER TABLE
    "ticket" ADD CONSTRAINT "ticket_customer_id_foreign" FOREIGN KEY("customer_id") REFERENCES "account"("id");
ALTER TABLE
    "ticket" ADD CONSTRAINT "ticket_event_id_foreign" FOREIGN KEY("event_id") REFERENCES "event"("id");
ALTER TABLE
    "account" ADD CONSTRAINT "account_role_id_foreign" FOREIGN KEY("role_id") REFERENCES "role"("id");
ALTER TABLE
    "genres_bands" ADD CONSTRAINT "genres_bands_band_id_foreign" FOREIGN KEY("band_id") REFERENCES "band"("id");
ALTER TABLE
    "event_act" ADD CONSTRAINT "event_act_band_id_foreign" FOREIGN KEY("band_id") REFERENCES "band"("id");
ALTER TABLE
    "cash_payment" ADD CONSTRAINT "cash_payment_ticket_id_foreign" FOREIGN KEY("ticket_id") REFERENCES "ticket"("id");
ALTER TABLE
    "card_payment" ADD CONSTRAINT "card_payment_ticket_id_foreign" FOREIGN KEY("ticket_id") REFERENCES "ticket"("id");
ALTER TABLE
    "genres_bands" ADD CONSTRAINT "genres_bands_genre_id_foreign" FOREIGN KEY("genre_id") REFERENCES "genre"("id");
ALTER TABLE
    "event_act" ADD CONSTRAINT "event_act_event_id_foreign" FOREIGN KEY("event_id") REFERENCES "event"("id");
ALTER TABLE
    "band_member" ADD CONSTRAINT "band_member_band_id_foreign" FOREIGN KEY("band_id") REFERENCES "band"("id");