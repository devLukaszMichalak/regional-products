CREATE TABLE IF NOT EXISTS voivodeship
(
    id                    INTEGER PRIMARY KEY AUTOINCREMENT,
    creation_date         TEXT DEFAULT CURRENT_TIMESTAMP,
    name                  TEXT NOT NULL UNIQUE,
    code                  TEXT NOT NULL UNIQUE,
    description_en        TEXT NOT NULL,
    description_pl        TEXT NOT NULL,
    coat_of_arms_filename TEXT NOT NULL,
    CHECK (trim(creation_date) != ''),
    CHECK (trim(name) != ''),
    CHECK (length(code) == 2),
    CHECK (trim(description_en) != ''),
    CHECK (trim(description_pl) != ''),
    CHECK (description_en != description_pl),
    CHECK (trim(coat_of_arms_filename) != ''),
    CHECK (coat_of_arms_filename LIKE '%.png')
) strict;

CREATE TABLE IF NOT EXISTS product_type
(
    id            INTEGER PRIMARY KEY AUTOINCREMENT,
    creation_date TEXT DEFAULT CURRENT_TIMESTAMP,
    name          TEXT NOT NULL UNIQUE,
    CHECK (trim(creation_date) != ''),
    CHECK (trim(name) != '')
) strict;

CREATE TABLE IF NOT EXISTS product
(
    id              INTEGER PRIMARY KEY AUTOINCREMENT,
    name            TEXT    NOT NULL UNIQUE,
    product_type_id INTEGER NOT NULL,
    voivodeship_id  INTEGER NOT NULL,
    date_of_entry   TEXT    NOT NULL,
    creation_date   TEXT DEFAULT CURRENT_TIMESTAMP,
    CHECK (trim(name) != ''),
    FOREIGN KEY (product_type_id) REFERENCES product_type (id),
    FOREIGN KEY (voivodeship_id) REFERENCES voivodeship (id),
    CHECK (trim(date_of_entry) != ''),
    CHECK (trim(creation_date) != ''),
    CHECK (date_of_entry <= creation_date),
    CHECK (date_of_entry >= '1900-01-01')
) strict;
