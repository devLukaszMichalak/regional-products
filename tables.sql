CREATE TABLE voivodeship
(
    id                    INTEGER PRIMARY KEY AUTOINCREMENT,
    creation_date         DATETIME DEFAULT CURRENT_TIMESTAMP,
    name                  TEXT NOT NULL,
    code                  TEXT NOT NULL,
    description           TEXT NOT NULL,
    coat_of_arms_filename TEXT NOT NULL
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


INSERT INTO voivodeship (name, code, description, coat_of_arms_filename)
VALUES
    ('dolnośląskie', 'DS',
     'Dolnośląskie stands out for its exceptional variety of culinary delights. Savor the unique flavors of heather and buckwheat honeys, both reflecting the region’s diverse landscapes. The area is celebrated for artisanal cheeses like Zgorzelec and Lomnica goat cheese, traditional cured meats including Kiełbasa niemczańska and Karkonosze salceson, and distinctive baked goods such as Chleb gogołowicki and Miodowe pierniczki from Przemków.',
     '800px-pol_wojewodztwo_dolnoslaskie_coa.svg_.png'),
    ('kujawsko-pomorskie', 'KP',
     'Kujawsko-Pomorskie is known for its deep-rooted culinary traditions. Indulge in Powidła śliwkowe from the Lower Vistula Valley and savor homemade fruit and herbal liqueurs like Nalewka z czarnej porzeczki. The region’s meat specialties, including Półgęsek and Biała kiełbasa, showcase its rich meat traditions. Enjoy regional honeys and sweet treats like Chleb z makiem from Stolno, alongside Żur kujawski and the famous Toruń gingerbread.',
     '800px-pol_wojewodztwo_kujawsko-pomorskie_coa.svg_.png'),
    ('lubelskie', 'LU',
     'Lubelskie delights with its extensive culinary offerings. Try unique honey varieties such as bean flower and raspberry honey, and enjoy baked goods like cebularz lubelski (onion bread) and sękacz podlaski (layered cake). The region is also known for its savory meats like kiełbasa nadwieprzańska and roast pork from Zwierzyniec, as well as local beverages including fruit liqueurs and herbal syrups.',
     '800px-pol_wojewodztwo_lubelskie_coa.svg_-1.png'),
    ('lubuskie', 'LB',
     'Lubuskie offers a rich array of traditional foods. Its baked goods include starowiejski bread and Lubuskie pierniki, while beverages range from zielonogórskie wine to jarzębiak and pine needle liqueur. Enjoy local meats like kiełbasa żarska, fresh honey varieties, and fermented products such as nadnotecka sauerkraut. Lubuskie is also known for ready-to-eat dishes like bigos and wild boar ribs with honey.',
     '800px-pol_wojewodztwo_lubuskie_coa.svg_.png'),
    ('łódzkie', 'LD',
     'Łódź is celebrated for its diverse food products, including traditional cheeses like Twaróg tradycyjny and baked goods such as Chleb wiejski łęczycki. The region also features preserved vegetables like Powidła śliwkowe łowickie and Ogórki kiszone z Rogowa, alongside meat specialties like Kiełbasa nadolska tradycyjnie wędzona and Wędzonki z Dzietrznik.',
     'pol_wojewodztwo_lodzkie_coa.svg-2.png'),
    ('małopolskie', 'MA',
     'Małopolskie, in southern Poland, is famed for its rich culinary traditions. Experience the distinct flavors of Lisiecka sausage and Zatorski goose, along with artisanal cheeses like Oscypek and Bryndza Podhalańska. Enjoy regional baked goods such as the Kraków pretzel and Obwarzanek, complemented by beverages like Śliwowica (plum brandy) and local honey.',
     '800px-pol_wojewodztwo_malopolskie_coa.svg_.png'),
    ('mazowieckie', 'MZ',
     'Mazowieckie, centrally located, boasts a diverse culinary heritage. Its offerings include traditional baked goods like Chleb razowy radziwiłłowski and sweets such as Pańska skórka. The region is renowned for meats such as Kiełbasa nadbużańska jałowcowa, artisanal cheeses, and honeys like Miód kampinoski. Enjoy a selection of unique beverages, including regional beers and fruit liqueurs.',
     '800px-pol_wojewodztwo_mazowieckie_coa.svg_.png'),
    ('opolskie', 'OP',
     'Opolskie is rich in traditional produce, with notable baked goods like Staropolski chleb sanacyjny and Jeż, a creamy blackcurrant cake. Cheeses such as Domowy ser parzony and unique beverages like Nalewka orzechowa (walnut liqueur) stand out. The region also features distinctive dishes including Gołąbki with buckwheat and Kartoffelsalat (potato salad with smoked bacon).',
     '800px-pol_wojewodztwo_opolskie_coa.svg_.png'),
    ('podkarpackie', 'PK',
     'Podkarpackie is celebrated for its diverse culinary heritage. Enjoy traditional meats like Markowska sausage and Dukielski salceson, along with dairy products such as “wołoski” goat cheese and Bryndza kozia. Baked goods include Chleb flisacki and Sędziszowski cake. The region is also known for preserved fruits like Pruchnicka dried plums and local honey varieties.',
     '800px-pol_wojewodztwo_podkarpackie_coa.svg_-1.png'),
    ('podlaskie', 'PD',
     'Podlaskie, in northeastern Poland, is renowned for its hearty traditional dishes such as kartacze and kiszka ziemniaczana. The region offers artisanal cheeses like ser koryciński and unique baked goods like sękacz and korowaj. Local meats and fish, including wędzonka and sejneński szczupak, are highlights, complemented by beverages like śliwowica and piwo podlaskie.',
     '800px-pol_wojewodztwo_podlaskie_coa.svg_-1.png'),
    ('pomorskie', 'PM',
     'Pomorskie, in northern Poland, features a rich culinary tradition influenced by the Kaszubian and Kociewian communities. Enjoy unique dishes like czernina kaszubska (duck blood soup) and kiszka kaszubska (traditional sausage). The region is also known for baked goods such as chleb słowiński and piernik z kamionki, along with artisanal beverages like nalewka jagodowa and piwo pomorskie.',
     'pol_wojewodztwo_pomorskie_coa.svg_.png'),
    ('śląskie', 'SL',
     'Silesian Voivodeship offers a diverse range of traditional foods. Enjoy hearty dishes like Kluski białe śląskie and Żur śląski, featuring local meats such as Żymlok śląski and Siewierska gęś pieczona. The region is known for baked goods like Kołocz weselny śląski and Śląski piernik tradycyjny, alongside dairy products like Ser klagany and Bryndza żywiecka. Local beverages include Miód lipowo-spadziowy and Cieszyńska herbata.',
     '800px-pol_wojewodztwo_slaskie_coa.svg_.png'),
    ('świętokrzyskie', 'SK',
     'Świętokrzyskie is known for its diverse culinary offerings, including meats like Dziona rakowskie and Kiełbasa swojska z Kunowa. Enjoy artisanal cheeses such as Jędrzejowski twarożek and Ser kozi z Machor, and sweet treats like Krówka opatowska and Tort czekoladowo-orzechowy. The region’s honey, such as Miód spadziowy z Puszczy Jodłowej, highlights its commitment to high-quality products.',
     'pol_wojewodztwo_swietokrzyskie_coa.svg_-1.png'),
    ('warmińsko-mazurskie', 'WN',
     'Warmińsko-Mazurskie, with its scenic lakes and forests, offers a rich variety of regional foods. The region is celebrated for smoked meats like Mazurska szynka wędzona and Mazurska kiełbasa wędzona. Dairy products such as Ser salami mazurski and Mleko zsiadłe, alongside honey varieties like Miód lipowy z Barcji, reflect its rich agricultural heritage. Sweet baked goods like Sękacz mazurski and Fefernuszki complete the regional flavor.',
     '800px-warminsko-mazurskie_herb.svg_.png'),
    ('wielkopolskie', 'WP',
     'Wielkopolska is celebrated for its rich culinary heritage. Enjoy high-quality meats like Wielkopolska wieprzowina and kiełbasa jałowcowa, along with dairy products such as Wielkopolski ser smażony and serek twarogowy kozi. The region is known for unique baked goods like Andruty kaliskie and chleb żytni wielkopolski, and beverages ranging from miodówka witosławska to piwo noteckie. Traditional dishes like czernina and bigos wielkopolski further highlight its hearty cuisine.',
     '800px-pol_wojewodztwo_wielkopolskie_coa.svg_.png'),
    ('zachodniopomorskie', 'ZP',
     'Zachodniopomorskie features a diverse range of regional specialties. Sample distinctive breads like Chleb razowy koprzywieński and Chleb szczeciński, and enjoy honey varieties such as Miód drahimski and Miód pitny trójniak. The region is also known for preserved goods like Kapusta kiszona z beczki and Jeziorowy ogórek kiszony. For fish lovers, Paprykarz szczeciński and Sielawa wędzona showcase the area’s connection to its freshwater resources.',
     '800px-pol_wojewodztwo_zachodniopomorskie_coa.svg_.png');

INSERT INTO product_type (name)
VALUES ('Miody');
INSERT INTO product_type (name)
VALUES ('Orzechy, nasiona, zboża, warzywa i owoce (przetworzone i nie)');
INSERT INTO product_type (name)
VALUES ('Gotowe dania i potrawy');
INSERT INTO product_type (name)
VALUES ('Napoje (alkoholowe i bezalkoholowe)');

INSERT INTO product (name, product_type_id, voivodeship_id, date_of_entry)
VALUES ('Miód wrzosowy z Borów Dolnośląskich', (SELECT id FROM product_type WHERE name = 'Miody'),
        (SELECT id FROM voivodeship WHERE name = 'dolnośląskie'), '2005-09-28'),
       ('Ogórki konserwowe ścinawskie',
        (SELECT id FROM product_type WHERE name = 'Orzechy, nasiona, zboża, warzywa i owoce (przetworzone i nie)'),
        (SELECT id FROM voivodeship WHERE name = 'dolnośląskie'), '2007-04-24'),
       ('Keselica / kysielnica / kysyłycia', (SELECT id FROM product_type WHERE name = 'Gotowe dania i potrawy'),
        (SELECT id FROM voivodeship WHERE name = 'dolnośląskie'), '2007-05-11'),
       ('Wielokwiatowy miód z Doliny Baryczy', (SELECT id FROM product_type WHERE name = 'Miody'),
        (SELECT id FROM voivodeship WHERE name = 'dolnośląskie'), '2007-05-11'),
       ('Juha – kompot z suszonych owoców',
        (SELECT id FROM product_type WHERE name = 'Napoje (alkoholowe i bezalkoholowe)'),
        (SELECT id FROM voivodeship WHERE name = 'dolnośląskie'), '2007-05-11'),
       ('Wino śląskie', (SELECT id FROM product_type WHERE name = 'Napoje (alkoholowe i bezalkoholowe)'),
        (SELECT id FROM voivodeship WHERE name = 'dolnośląskie'), '2007-06-11');
