CREATE TABLE IF NOT EXISTS voivodeship
(
    id                    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    creation_date         TEXT    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    name                  TEXT    NOT NULL UNIQUE,
    code                  TEXT    NOT NULL UNIQUE,
    description_en        TEXT    NOT NULL,
    description_pl        TEXT    NOT NULL,
    coat_of_arms_filename TEXT    NOT NULL,
    CHECK (TRIM(creation_date) != ''),
    CHECK (TRIM(name) != ''),
    CHECK (LENGTH(code) == 2),
    CHECK (TRIM(description_en) != ''),
    CHECK (TRIM(description_pl) != ''),
    CHECK (description_en != description_pl),
    CHECK (TRIM(coat_of_arms_filename) != ''),
    CHECK (coat_of_arms_filename LIKE '%.png')
) strict;

CREATE TABLE IF NOT EXISTS product_type
(
    id            INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    creation_date TEXT    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    name          TEXT    NOT NULL UNIQUE,
    CHECK (TRIM(creation_date) != ''),
    CHECK (TRIM(name) != '')
) strict;

CREATE TABLE IF NOT EXISTS product
(
    id              INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    name            TEXT    NOT NULL,
    product_type_id INTEGER NOT NULL,
    voivodeship_id  INTEGER NOT NULL,
    date_of_entry   TEXT    NOT NULL,
    creation_date   TEXT    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CHECK (TRIM(name) != ''),
    FOREIGN KEY (product_type_id) REFERENCES product_type (id),
    FOREIGN KEY (voivodeship_id) REFERENCES voivodeship (id),
    UNIQUE (name, product_type_id, voivodeship_id),
    CHECK (TRIM(date_of_entry) != ''),
    CHECK (TRIM(creation_date) != ''),
    CHECK (date_of_entry <= creation_date),
    CHECK (date_of_entry >= '1900-01-01')
) strict;

CREATE TABLE IF NOT EXISTS statistics
(
    id             INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    voivodeship_id INTEGER NOT NULL,
    date           TEXT    NOT NULL,
    count          TEXT    NOT NULL DEFAULT 0,
    FOREIGN KEY (voivodeship_id) REFERENCES voivodeship (id),
    UNIQUE (date, voivodeship_id),
    CHECK (TRIM(date) != ''),
    CHECK (count >= 0),
    CHECK (date >= '1900-01-01')
) strict;
