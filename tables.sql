CREATE TABLE voivodeship
(
    id                    INTEGER PRIMARY KEY AUTOINCREMENT,
    creation_date         TEXT DEFAULT CURRENT_TIMESTAMP,
    name                  TEXT NOT NULL,
    code                  TEXT NOT NULL UNIQUE,
    description_en        TEXT NOT NULL,
    description_pl        TEXT NOT NULL,
    coat_of_arms_filename TEXT NOT NULL
) strict;

CREATE TABLE product_type
(
    id            INTEGER PRIMARY KEY AUTOINCREMENT,
    creation_date TEXT DEFAULT CURRENT_TIMESTAMP,
    name          TEXT NOT NULL
) strict ;

CREATE TABLE product
(
    id              INTEGER PRIMARY KEY AUTOINCREMENT,
    name            TEXT    NOT NULL,
    product_type_id INTEGER NOT NULL,
    voivodeship_id  INTEGER NOT NULL,
    date_of_entry   TEXT    NOT NULL,
    creation_date   TEXT DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (product_type_id) REFERENCES product_type (id),
    FOREIGN KEY (voivodeship_id) REFERENCES voivodeship (id)
) strict;


INSERT INTO voivodeship (name, code, description_en, description_pl, coat_of_arms_filename)
VALUES
    ('dolnośląskie', 'DS',
     'Dolnośląskie stands out for its exceptional variety of culinary delights. Savor the unique flavors of heather and buckwheat honeys, both reflecting the region’s diverse landscapes. The area is celebrated for artisanal cheeses like Zgorzelec and Lomnica goat cheese, traditional cured meats including Kiełbasa niemczańska and Karkonosze salceson, and distinctive baked goods such as Chleb gogołowicki and Miodowe pierniczki from Przemków.',
     'Dolnośląskie wyróżnia się wyjątkową różnorodnością kulinarnych przysmaków. Skosztuj unikalnych smaków miodów wrzosowego i gryczanego, odzwierciedlających zróżnicowane krajobrazy regionu. Region słynie z serów rzemieślniczych, takich jak ser kozi z Zgorzelca i Łomnicy, tradycyjnych wędlin, w tym kiełbasy niemczańskiej i salcesonu karkonoskiego, oraz wypieków, takich jak chleb gogołowicki i miodowe pierniczki z Przemkowa.',
     '800px-pol_wojewodztwo_dolnoslaskie_coa.svg_.png'),
    ('kujawsko-pomorskie', 'KP',
     'Kujawsko-Pomorskie is known for its deep-rooted culinary traditions. Indulge in Powidła śliwkowe from the Lower Vistula Valley and savor homemade fruit and herbal liqueurs like Nalewka z czarnej porzeczki. The region’s meat specialties, including Półgęsek and Biała kiełbasa, showcase its rich meat traditions. Enjoy regional honeys and sweet treats like Chleb z makiem from Stolno, alongside Żur kujawski and the famous Toruń gingerbread.',
     'Kujawsko-Pomorskie słynie z głęboko zakorzenionych tradycji kulinarnych. Skosztuj powideł śliwkowych z Doliny Dolnej Wisły oraz domowych nalewek owocowych i ziołowych, takich jak nalewka z czarnej porzeczki. Specjały mięsne regionu, w tym półgęsek i biała kiełbasa, odzwierciedlają bogatą tradycję mięsną. Delektuj się regionalnymi miodami i słodkimi przysmakami, takimi jak chleb z makiem ze Stolna, obok żuru kujawskiego i słynnego toruńskiego piernika.',
     '800px-pol_wojewodztwo_kujawsko-pomorskie_coa.svg_.png'),
    ('lubelskie', 'LU',
     'Lubelskie delights with its extensive culinary offerings. Try unique honey varieties such as bean flower and raspberry honey, and enjoy baked goods like cebularz lubelski (onion bread) and sękacz podlaski (layered cake). The region is also known for its savory meats like kiełbasa nadwieprzańska and roast pork from Zwierzyniec, as well as local beverages including fruit liqueurs and herbal syrups.',
     'Lubelskie zachwyca bogactwem kulinarnych specjałów. Skosztuj unikalnych miodów, takich jak miód z kwiatów fasoli i maliny, oraz wypieków, takich jak cebularz lubelski i sękacz podlaski. Region słynie również z mięsnych przysmaków, takich jak kiełbasa nadwieprzańska i pieczeń wieprzowa ze Zwierzyńca, a także lokalnych napojów, w tym likierów owocowych i syropów ziołowych.',
     '800px-pol_wojewodztwo_lubelskie_coa.svg_-1.png'),
    ('lubuskie', 'LB',
     'Lubuskie offers a rich array of traditional foods. Its baked goods include starowiejski bread and Lubuskie pierniki, while beverages range from zielonogórskie wine to jarzębiak and pine needle liqueur. Enjoy local meats like kiełbasa żarska, fresh honey varieties, and fermented products such as nadnotecka sauerkraut. Lubuskie is also known for ready-to-eat dishes like bigos and wild boar ribs with honey.',
     'Lubuskie oferuje bogaty wachlarz tradycyjnych potraw. Wśród wypieków wyróżnia się chleb starowiejski i lubuskie pierniki, a napoje obejmują wino zielonogórskie, jarzębiak i likier z igieł sosnowych. Skosztuj lokalnych mięs, takich jak kiełbasa żarska, świeżych miodów i fermentowanych produktów, jak kapusta kiszona nadnotecka. Lubuskie jest również znane z gotowych dań, takich jak bigos i żeberka dzika z miodem.',
     '800px-pol_wojewodztwo_lubuskie_coa.svg_.png'),
    ('łódzkie', 'LD',
     'Łódź is celebrated for its diverse food products, including traditional cheeses like Twaróg tradycyjny and baked goods such as Chleb wiejski łęczycki. The region also features preserved vegetables like Powidła śliwkowe łowickie and Ogórki kiszone z Rogowa, alongside meat specialties like Kiełbasa nadolska tradycyjnie wędzona and Wędzonki z Dzietrznik.',
     'Łódź słynie z różnorodnych produktów spożywczych, w tym tradycyjnych serów, takich jak twaróg tradycyjny, oraz wypieków, takich jak chleb wiejski łęczycki. Region oferuje również warzywa konserwowe, takie jak powidła śliwkowe łowickie i ogórki kiszone z Rogowa, a także specjały mięsne, takie jak kiełbasa nadolska tradycyjnie wędzona i wędzonki z Dzietrznik.',
     'pol_wojewodztwo_lodzkie_coa.svg-2.png'),
    ('małopolskie', 'MA',
     'Małopolskie, in southern Poland, is famed for its rich culinary traditions. Experience the distinct flavors of Lisiecka sausage and Zatorski goose, along with artisanal cheeses like Oscypek and Bryndza Podhalańska. Enjoy regional baked goods such as the Kraków pretzel and Obwarzanek, complemented by beverages like Śliwowica (plum brandy) and local honey.',
     'Małopolskie, położone na południu Polski, słynie z bogatych tradycji kulinarnych. Spróbuj wyjątkowych smaków kiełbasy lisieckiej i gęsi zatorskiej, a także serów rzemieślniczych, takich jak oscypek i bryndza podhalańska. Delektuj się regionalnymi wypiekami, takimi jak krakowski obwarzanek, uzupełnionymi napojami, takimi jak śliwowica i lokalne miody.',
     '800px-pol_wojewodztwo_malopolskie_coa.svg_.png'),
    ('mazowieckie', 'MZ',
     'Mazowieckie, centrally located, boasts a diverse culinary heritage. Its offerings include traditional baked goods like Chleb razowy radziwiłłowski and sweets such as Pańska skórka. The region is renowned for meats such as Kiełbasa nadbużańska jałowcowa, artisanal cheeses, and honeys like Miód kampinoski. Enjoy a selection of unique beverages, including regional beers and fruit liqueurs.',
     'Mazowieckie, położone centralnie, może pochwalić się różnorodnym dziedzictwem kulinarnym. Oferuje tradycyjne wypieki, takie jak chleb razowy radziwiłłowski oraz słodycze, jak pańska skórka. Region słynie z mięs, takich jak kiełbasa nadbużańska jałowcowa, serów rzemieślniczych oraz miodów, w tym miodu kampinoskiego. Skosztuj również unikalnych napojów, w tym regionalnych piw i likierów owocowych.',
     '800px-pol_wojewodztwo_mazowieckie_coa.svg_.png'),
    ('opolskie', 'OP',
     'Opolskie is rich in traditional produce, with notable baked goods like Staropolski chleb sanacyjny and Jeż, a creamy blackcurrant cake. Cheeses such as Domowy ser parzony and unique beverages like Nalewka orzechowa (walnut liqueur) stand out. The region also features distinctive dishes including Gołąbki with buckwheat and Kartoffelsalat (potato salad with smoked bacon).',
     'Opolskie obfituje w tradycyjne produkty, w tym wypieki, takie jak staropolski chleb sanacyjny oraz Jeż, kremowe ciasto z czarnej porzeczki. Serwowane są tu również sery, jak domowy ser parzony, oraz unikalne napoje, takie jak nalewka orzechowa. Region wyróżniają także dania, takie jak gołąbki z kaszą gryczaną i sałatka ziemniaczana z boczkiem.',
     '800px-pol_wojewodztwo_opolskie_coa.svg_.png'),
    ('podkarpackie', 'PK',
     'Podkarpackie is celebrated for its diverse culinary heritage. Enjoy traditional meats like Markowska sausage and Dukielski salceson, along with dairy products such as “wołoski” goat cheese and Bryndza kozia. Baked goods include Chleb flisacki and Sędziszowski cake. The region is also known for preserved fruits like Pruchnicka dried plums and local honey varieties.',
     'Podkarpackie, położone na południowym wschodzie Polski, słynie z sycącej kuchni. Wśród regionalnych specjałów znajdują się kiełbasa wiejska i proziaki, tradycyjne placki na zakwasie, a także miody, takie jak podkarpacki miód lipowy. Region oferuje także unikalne alkohole, jak tarninówka, oraz wypieki, jak strudel sanocki z orzechami i makiem.',
     '800px-pol_wojewodztwo_podkarpackie_coa.svg_-1.png'),
    ('podlaskie', 'PD',
     'Podlaskie, in northeastern Poland, is renowned for its hearty traditional dishes such as kartacze and kiszka ziemniaczana. The region offers artisanal cheeses like ser koryciński and unique baked goods like sękacz and korowaj. Local meats and fish, including wędzonka and sejneński szczupak, are highlights, complemented by beverages like śliwowica and piwo podlaskie.',
     'Podlaskie słynie z wpływów wielokulturowych i kulinarnej różnorodności. Na uwagę zasługuje sękacz, kartacze oraz szeroki wybór produktów mlecznych, takich jak bryndza podlaska. Lokalnymi napojami są miody pitne oraz nalewki owocowe i ziołowe. Region jest również domem dla Puszczy Białowieskiej, co znajduje odzwierciedlenie w użyciu produktów leśnych w kuchni.',
     '800px-pol_wojewodztwo_podlaskie_coa.svg_-1.png'),
    ('pomorskie', 'PM',
     'Pomorskie, in northern Poland, features a rich culinary tradition influenced by the Kaszubian and Kociewian communities. Enjoy unique dishes like czernina kaszubska (duck blood soup) and kiszka kaszubska (traditional sausage). The region is also known for baked goods such as chleb słowiński and piernik z kamionki, along with artisanal beverages like nalewka jagodowa and piwo pomorskie.',
     'Pomorskie oferuje bogaty wybór owoców morza i specjałów znad Bałtyku. Skosztuj dań, takich jak gdańskie pierniki, chleb kociewski oraz pomorska gęś. Wśród napojów wyróżniają się Danziger Goldwasser oraz regionalne cydry. Wpływ nadmorski widać również w różnorodności ryb wędzonych, takich jak łosoś i śledź.',
     'pol_wojewodztwo_pomorskie_coa.svg_.png'),
    ('śląskie', 'SL',
     'Silesian Voivodeship offers a diverse range of traditional foods. Enjoy hearty dishes like Kluski białe śląskie and Żur śląski, featuring local meats such as Żymlok śląski and Siewierska gęś pieczona. The region is known for baked goods like Kołocz weselny śląski and Śląski piernik tradycyjny, alongside dairy products like Ser klagany and Bryndza żywiecka. Local beverages include Miód lipowo-spadziowy and Cieszyńska herbata.',
     'Śląskie, centrum przemysłowe, oferuje intensywne smaki, które odzwierciedlają bogate dziedzictwo kulinarne regionu. Do znanych dań należą żur śląski, krupniok oraz rolada z modrą kapustą. Region słynie również z przepysznego śląskiego kołocza i serów śląskich. Lokalnymi napojami są piwa warzone w tradycyjnych śląskich browarach.',
     '800px-pol_wojewodztwo_slaskie_coa.svg_.png'),
    ('świętokrzyskie', 'SK',
     'Świętokrzyskie is known for its diverse culinary offerings, including meats like Dziona rakowskie and Kiełbasa swojska z Kunowa. Enjoy artisanal cheeses such as Jędrzejowski twarożek and Ser kozi z Machor, and sweet treats like Krówka opatowska and Tort czekoladowo-orzechowy. The region’s honey, such as Miód spadziowy z Puszczy Jodłowej, highlights its commitment to high-quality products.',
     'Świętokrzyskie oferuje unikalne produkty, takie jak miód świętokrzyski, bryndza oraz wina regionalne. Tradycyjne dania obejmują zalewajkę i pierogi świętokrzyskie z nadzieniem z kaszy gryczanej. Region słynie także z dań z grzybami, które nawiązują do jego zalesionych terenów.',
     'pol_wojewodztwo_swietokrzyskie_coa.svg_-1.png'),
    ('warmińsko-mazurskie', 'WN',
     'Warmińsko-Mazurskie, with its scenic lakes and forests, offers a rich variety of regional foods. The region is celebrated for smoked meats like Mazurska szynka wędzona and Mazurska kiełbasa wędzona. Dairy products such as Ser salami mazurski and Mleko zsiadłe, alongside honey varieties like Miód lipowy z Barcji, reflect its rich agricultural heritage. Sweet baked goods like Sękacz mazurski and Fefernuszki complete the regional flavor.',
     'Warmińsko-Mazurskie słynie z naturalnych krajobrazów i dań z ryb słodkowodnych, takich jak węgorz wędzony oraz szczupak faszerowany. Region oferuje również tradycyjne wypieki, jak chleb orkiszowy, oraz potrawy z dzikich jagód i grzybów, które odzwierciedlają jego rozległe lasy i jeziora. Regionalnymi napojami są piwa rzemieślnicze i wina owocowe.',
     '800px-warminsko-mazurskie_herb.svg_.png'),
    ('wielkopolskie', 'WP',
     'Wielkopolska is celebrated for its rich culinary heritage. Enjoy high-quality meats like Wielkopolska wieprzowina and kiełbasa jałowcowa, along with dairy products such as Wielkopolski ser smażony and serek twarogowy kozi. The region is known for unique baked goods like Andruty kaliskie and chleb żytni wielkopolski, and beverages ranging from miodówka witosławska to piwo noteckie. Traditional dishes like czernina and bigos wielkopolski further highlight its hearty cuisine.',
     'Wielkopolskie słynie z obfitej i tradycyjnej kuchni. Do popularnych dań należą pyry z gzikiem oraz rogale świętomarcińskie. Region jest również znany z produkcji miodu, w tym miodu wrzosowego, oraz oferuje szeroką gamę piw rzemieślniczych, serów i kiełbas.',
     '800px-pol_wojewodztwo_wielkopolskie_coa.svg_.png'),
    ('zachodniopomorskie', 'ZP',
     'Zachodniopomorskie features a diverse range of regional specialties. Sample distinctive breads like Chleb razowy koprzywieński and Chleb szczeciński, and enjoy honey varieties such as Miód drahimski and Miód pitny trójniak. The region is also known for preserved goods like Kapusta kiszona z beczki and Jeziorowy ogórek kiszony. For fish lovers, Paprykarz szczeciński and Sielawa wędzona showcase the area’s connection to its freshwater resources.',
     'Zachodniopomorskie oferuje pyszne dania z owoców morza, w tym śledzia bałtyckiego i turbot. Region słynie także z regionalnych napojów, takich jak soki owocowe, piwa i cydry. Tradycyjne przepisy obejmują chleb ze słonecznikiem oraz kaszubską kiszkę, rodzaj kaszanki z regionu Kaszub.',
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
