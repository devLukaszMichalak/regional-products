CREATE TABLE voivodeship
(
    id            INTEGER PRIMARY KEY AUTOINCREMENT,
    creation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    name          TEXT NOT NULL
);

CREATE TABLE product_type
(
    id            INTEGER PRIMARY KEY AUTOINCREMENT,
    creation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    name          TEXT NOT NULL
);

CREATE TABLE product
(
    id              INTEGER PRIMARY KEY AUTOINCREMENT,
    name            TEXT    NOT NULL,
    product_type_id INTEGER NOT NULL,
    voivodeship_id  INTEGER NOT NULL,
    date_of_entry   DATE    NOT NULL,
    creation_date   DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (product_type_id) REFERENCES product_type (id),
    FOREIGN KEY (voivodeship_id) REFERENCES voivodeship (id)
);


INSERT INTO voivodeship (name) VALUES ('dolnośląskie');

INSERT INTO product_type (name) VALUES ('Miody');
INSERT INTO product_type (name) VALUES ('Orzechy, nasiona, zboża, warzywa i owoce (przetworzone i nie)');
INSERT INTO product_type (name) VALUES ('Gotowe dania i potrawy');
INSERT INTO product_type (name) VALUES ('Napoje (alkoholowe i bezalkoholowe)');

INSERT INTO product (name, product_type_id, voivodeship_id, date_of_entry)
VALUES
    ('Miód wrzosowy z Borów Dolnośląskich', (SELECT id FROM product_type WHERE name = 'Miody'), (SELECT id FROM voivodeship WHERE name = 'dolnośląskie'), '2005-09-28'),
    ('Ogórki konserwowe ścinawskie', (SELECT id FROM product_type WHERE name = 'Orzechy, nasiona, zboża, warzywa i owoce (przetworzone i nie)'), (SELECT id FROM voivodeship WHERE name = 'dolnośląskie'), '2007-04-24'),
    ('Keselica / kysielnica / kysyłycia', (SELECT id FROM product_type WHERE name = 'Gotowe dania i potrawy'), (SELECT id FROM voivodeship WHERE name = 'dolnośląskie'), '2007-05-11'),
    ('Wielokwiatowy miód z Doliny Baryczy', (SELECT id FROM product_type WHERE name = 'Miody'), (SELECT id FROM voivodeship WHERE name = 'dolnośląskie'), '2007-05-11'),
    ('Juha – kompot z suszonych owoców', (SELECT id FROM product_type WHERE name = 'Napoje (alkoholowe i bezalkoholowe)'), (SELECT id FROM voivodeship WHERE name = 'dolnośląskie'), '2007-05-11'),
    ('Wino śląskie', (SELECT id FROM product_type WHERE name = 'Napoje (alkoholowe i bezalkoholowe)'), (SELECT id FROM voivodeship WHERE name = 'dolnośląskie'), '2007-06-11');
