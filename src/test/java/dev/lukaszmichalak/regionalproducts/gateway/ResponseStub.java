package dev.lukaszmichalak.regionalproducts.gateway;

import java.time.LocalDate;

class ResponseStub {

  // language=HTML
  static String en_voivodeships =
      """
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>Regional Products</title>
    <meta name="keywords" content="Regional products, Poland"/>
    <meta name="description" content="Discover regional products of Poland"/>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous"/>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous">
    </script>

    <link rel="stylesheet" type="text/css" href="/css/styles.css"/>

</head>

<body>

<header>
    <nav class="navbar bg-body-tertiary d-flex justify-content-center px-3 shadow">
        <div class="container-fluid page-size-constraint p-0">
            <a class="navbar-brand mb-0 h1 title-font"
               href="/en/voivodeships">Regional Products</a>

            <div class="border-start border-secondary d-flex flex-column ps-3">

                <a class="navbar-text p-0 transition-all fw-bolder link-dark"
                   href="/en/voivodeships">en
                </a>

                <a class="navbar-text p-0 transition-all link-secondary"
                   href="/pl/voivodeships">pl
                </a>

            </div>
        </div>

    </nav>
</header>

<main class="h-100 w-100 d-flex flex-column align-items-center px-3">

    <div class="page-size-constraint w-100">
        <img class="w-100 mb-3 rounded-bottom-4" src="/images/cooking.jpg" alt="Cooking banner"/>

        <div class="w-100 d-flex mb-3">
            <div>
                <section class="mb-4 w-100 card shadow rounded-4">
                    <div class="d-flex card-body">
                        <a href="/en/voivodeships/DS">
                            <img class="coat-of-arms-size"
                                 src="/images/800px-pol_wojewodztwo_dolnoslaskie_coa.svg_.png"
                                 alt="Coat of arms of dolnośląskie voivodesip"/>
                        </a>

                        <div class="d-flex flex-column ms-2 w-100">
                            <a href="/en/voivodeships/DS">
                                <h3 class="border-bottom border-secondary-subtle link-secondary text-dark border-1 mb-0 transition-all">
                                   \s
                                    <span>DOLNOŚLĄSKIE</span>
                                    <span> VOIVODESHIP</span>
                                </h3>
                            </a>

                            <div class="text-justify mt-2">Dolnośląskie stands out for its exceptional variety of culinary delights. Savor the unique flavors of heather and buckwheat honeys, both reflecting the region’s diverse landscapes. The area is celebrated for artisanal cheeses like Zgorzelec and Lomnica goat cheese, traditional cured meats including Kiełbasa niemczańska and Karkonosze salceson, and distinctive baked goods such as Chleb gogołowicki and Miodowe pierniczki from Przemków.</div>
                        </div>
                    </div>

                </section>
                <section class="mb-4 w-100 card shadow rounded-4">
                    <div class="d-flex card-body">
                        <a href="/en/voivodeships/KP">
                            <img class="coat-of-arms-size"
                                 src="/images/800px-pol_wojewodztwo_kujawsko-pomorskie_coa.svg_.png"
                                 alt="Coat of arms of kujawsko-pomorskie voivodesip"/>
                        </a>

                        <div class="d-flex flex-column ms-2 w-100">
                            <a href="/en/voivodeships/KP">
                                <h3 class="border-bottom border-secondary-subtle link-secondary text-dark border-1 mb-0 transition-all">
                                   \s
                                    <span>KUJAWSKO-POMORSKIE</span>
                                    <span> VOIVODESHIP</span>
                                </h3>
                            </a>

                            <div class="text-justify mt-2">Kujawsko-Pomorskie is known for its deep-rooted culinary traditions. Indulge in Powidła śliwkowe from the Lower Vistula Valley and savor homemade fruit and herbal liqueurs like Nalewka z czarnej porzeczki. The region’s meat specialties, including Półgęsek and Biała kiełbasa, showcase its rich meat traditions. Enjoy regional honeys and sweet treats like Chleb z makiem from Stolno, alongside Żur kujawski and the famous Toruń gingerbread.</div>
                        </div>
                    </div>

                </section>
                <section class="mb-4 w-100 card shadow rounded-4">
                    <div class="d-flex card-body">
                        <a href="/en/voivodeships/LU">
                            <img class="coat-of-arms-size"
                                 src="/images/800px-pol_wojewodztwo_lubelskie_coa.svg_-1.png"
                                 alt="Coat of arms of lubelskie voivodesip"/>
                        </a>

                        <div class="d-flex flex-column ms-2 w-100">
                            <a href="/en/voivodeships/LU">
                                <h3 class="border-bottom border-secondary-subtle link-secondary text-dark border-1 mb-0 transition-all">
                                   \s
                                    <span>LUBELSKIE</span>
                                    <span> VOIVODESHIP</span>
                                </h3>
                            </a>

                            <div class="text-justify mt-2">Lubelskie delights with its extensive culinary offerings. Try unique honey varieties such as bean flower and raspberry honey, and enjoy baked goods like cebularz lubelski (onion bread) and sękacz podlaski (layered cake). The region is also known for its savory meats like kiełbasa nadwieprzańska and roast pork from Zwierzyniec, as well as local beverages including fruit liqueurs and herbal syrups.</div>
                        </div>
                    </div>

                </section>
                <section class="mb-4 w-100 card shadow rounded-4">
                    <div class="d-flex card-body">
                        <a href="/en/voivodeships/LB">
                            <img class="coat-of-arms-size"
                                 src="/images/800px-pol_wojewodztwo_lubuskie_coa.svg_.png"
                                 alt="Coat of arms of lubuskie voivodesip"/>
                        </a>

                        <div class="d-flex flex-column ms-2 w-100">
                            <a href="/en/voivodeships/LB">
                                <h3 class="border-bottom border-secondary-subtle link-secondary text-dark border-1 mb-0 transition-all">
                                   \s
                                    <span>LUBUSKIE</span>
                                    <span> VOIVODESHIP</span>
                                </h3>
                            </a>

                            <div class="text-justify mt-2">Lubuskie offers a rich array of traditional foods. Its baked goods include starowiejski bread and Lubuskie pierniki, while beverages range from zielonogórskie wine to jarzębiak and pine needle liqueur. Enjoy local meats like kiełbasa żarska, fresh honey varieties, and fermented products such as nadnotecka sauerkraut. Lubuskie is also known for ready-to-eat dishes like bigos and wild boar ribs with honey.</div>
                        </div>
                    </div>

                </section>
                <section class="mb-4 w-100 card shadow rounded-4">
                    <div class="d-flex card-body">
                        <a href="/en/voivodeships/LD">
                            <img class="coat-of-arms-size"
                                 src="/images/pol_wojewodztwo_lodzkie_coa.svg-2.png"
                                 alt="Coat of arms of łódzkie voivodesip"/>
                        </a>

                        <div class="d-flex flex-column ms-2 w-100">
                            <a href="/en/voivodeships/LD">
                                <h3 class="border-bottom border-secondary-subtle link-secondary text-dark border-1 mb-0 transition-all">
                                   \s
                                    <span>ŁÓDZKIE</span>
                                    <span> VOIVODESHIP</span>
                                </h3>
                            </a>

                            <div class="text-justify mt-2">Łódź is celebrated for its diverse food products, including traditional cheeses like Twaróg tradycyjny and baked goods such as Chleb wiejski łęczycki. The region also features preserved vegetables like Powidła śliwkowe łowickie and Ogórki kiszone z Rogowa, alongside meat specialties like Kiełbasa nadolska tradycyjnie wędzona and Wędzonki z Dzietrznik.</div>
                        </div>
                    </div>

                </section>
                <section class="mb-4 w-100 card shadow rounded-4">
                    <div class="d-flex card-body">
                        <a href="/en/voivodeships/MA">
                            <img class="coat-of-arms-size"
                                 src="/images/800px-pol_wojewodztwo_malopolskie_coa.svg_.png"
                                 alt="Coat of arms of małopolskie voivodesip"/>
                        </a>

                        <div class="d-flex flex-column ms-2 w-100">
                            <a href="/en/voivodeships/MA">
                                <h3 class="border-bottom border-secondary-subtle link-secondary text-dark border-1 mb-0 transition-all">
                                   \s
                                    <span>MAŁOPOLSKIE</span>
                                    <span> VOIVODESHIP</span>
                                </h3>
                            </a>

                            <div class="text-justify mt-2">Małopolskie, in southern Poland, is famed for its rich culinary traditions. Experience the distinct flavors of Lisiecka sausage and Zatorski goose, along with artisanal cheeses like Oscypek and Bryndza Podhalańska. Enjoy regional baked goods such as the Kraków pretzel and Obwarzanek, complemented by beverages like Śliwowica (plum brandy) and local honey.</div>
                        </div>
                    </div>

                </section>
                <section class="mb-4 w-100 card shadow rounded-4">
                    <div class="d-flex card-body">
                        <a href="/en/voivodeships/MZ">
                            <img class="coat-of-arms-size"
                                 src="/images/800px-pol_wojewodztwo_mazowieckie_coa.svg_.png"
                                 alt="Coat of arms of mazowieckie voivodesip"/>
                        </a>

                        <div class="d-flex flex-column ms-2 w-100">
                            <a href="/en/voivodeships/MZ">
                                <h3 class="border-bottom border-secondary-subtle link-secondary text-dark border-1 mb-0 transition-all">
                                   \s
                                    <span>MAZOWIECKIE</span>
                                    <span> VOIVODESHIP</span>
                                </h3>
                            </a>

                            <div class="text-justify mt-2">Mazowieckie, centrally located, boasts a diverse culinary heritage. Its offerings include traditional baked goods like Chleb razowy radziwiłłowski and sweets such as Pańska skórka. The region is renowned for meats such as Kiełbasa nadbużańska jałowcowa, artisanal cheeses, and honeys like Miód kampinoski. Enjoy a selection of unique beverages, including regional beers and fruit liqueurs.</div>
                        </div>
                    </div>

                </section>
                <section class="mb-4 w-100 card shadow rounded-4">
                    <div class="d-flex card-body">
                        <a href="/en/voivodeships/OP">
                            <img class="coat-of-arms-size"
                                 src="/images/800px-pol_wojewodztwo_opolskie_coa.svg_.png"
                                 alt="Coat of arms of opolskie voivodesip"/>
                        </a>

                        <div class="d-flex flex-column ms-2 w-100">
                            <a href="/en/voivodeships/OP">
                                <h3 class="border-bottom border-secondary-subtle link-secondary text-dark border-1 mb-0 transition-all">
                                   \s
                                    <span>OPOLSKIE</span>
                                    <span> VOIVODESHIP</span>
                                </h3>
                            </a>

                            <div class="text-justify mt-2">Opolskie is rich in traditional produce, with notable baked goods like Staropolski chleb sanacyjny and Jeż, a creamy blackcurrant cake. Cheeses such as Domowy ser parzony and unique beverages like Nalewka orzechowa (walnut liqueur) stand out. The region also features distinctive dishes including Gołąbki with buckwheat and Kartoffelsalat (potato salad with smoked bacon).</div>
                        </div>
                    </div>

                </section>
                <section class="mb-4 w-100 card shadow rounded-4">
                    <div class="d-flex card-body">
                        <a href="/en/voivodeships/PK">
                            <img class="coat-of-arms-size"
                                 src="/images/800px-pol_wojewodztwo_podkarpackie_coa.svg_-1.png"
                                 alt="Coat of arms of podkarpackie voivodesip"/>
                        </a>

                        <div class="d-flex flex-column ms-2 w-100">
                            <a href="/en/voivodeships/PK">
                                <h3 class="border-bottom border-secondary-subtle link-secondary text-dark border-1 mb-0 transition-all">
                                   \s
                                    <span>PODKARPACKIE</span>
                                    <span> VOIVODESHIP</span>
                                </h3>
                            </a>

                            <div class="text-justify mt-2">Podkarpackie is celebrated for its diverse culinary heritage. Enjoy traditional meats like Markowska sausage and Dukielski salceson, along with dairy products such as “wołoski” goat cheese and Bryndza kozia. Baked goods include Chleb flisacki and Sędziszowski cake. The region is also known for preserved fruits like Pruchnicka dried plums and local honey varieties.</div>
                        </div>
                    </div>

                </section>
                <section class="mb-4 w-100 card shadow rounded-4">
                    <div class="d-flex card-body">
                        <a href="/en/voivodeships/PD">
                            <img class="coat-of-arms-size"
                                 src="/images/800px-pol_wojewodztwo_podlaskie_coa.svg_-1.png"
                                 alt="Coat of arms of podlaskie voivodesip"/>
                        </a>

                        <div class="d-flex flex-column ms-2 w-100">
                            <a href="/en/voivodeships/PD">
                                <h3 class="border-bottom border-secondary-subtle link-secondary text-dark border-1 mb-0 transition-all">
                                   \s
                                    <span>PODLASKIE</span>
                                    <span> VOIVODESHIP</span>
                                </h3>
                            </a>

                            <div class="text-justify mt-2">Podlaskie, in northeastern Poland, is renowned for its hearty traditional dishes such as kartacze and kiszka ziemniaczana. The region offers artisanal cheeses like ser koryciński and unique baked goods like sękacz and korowaj. Local meats and fish, including wędzonka and sejneński szczupak, are highlights, complemented by beverages like śliwowica and piwo podlaskie.</div>
                        </div>
                    </div>

                </section>
                <section class="mb-4 w-100 card shadow rounded-4">
                    <div class="d-flex card-body">
                        <a href="/en/voivodeships/PM">
                            <img class="coat-of-arms-size"
                                 src="/images/pol_wojewodztwo_pomorskie_coa.svg_.png"
                                 alt="Coat of arms of pomorskie voivodesip"/>
                        </a>

                        <div class="d-flex flex-column ms-2 w-100">
                            <a href="/en/voivodeships/PM">
                                <h3 class="border-bottom border-secondary-subtle link-secondary text-dark border-1 mb-0 transition-all">
                                   \s
                                    <span>POMORSKIE</span>
                                    <span> VOIVODESHIP</span>
                                </h3>
                            </a>

                            <div class="text-justify mt-2">Pomorskie, in northern Poland, features a rich culinary tradition influenced by the Kaszubian and Kociewian communities. Enjoy unique dishes like czernina kaszubska (duck blood soup) and kiszka kaszubska (traditional sausage). The region is also known for baked goods such as chleb słowiński and piernik z kamionki, along with artisanal beverages like nalewka jagodowa and piwo pomorskie.</div>
                        </div>
                    </div>

                </section>
                <section class="mb-4 w-100 card shadow rounded-4">
                    <div class="d-flex card-body">
                        <a href="/en/voivodeships/SL">
                            <img class="coat-of-arms-size"
                                 src="/images/800px-pol_wojewodztwo_slaskie_coa.svg_.png"
                                 alt="Coat of arms of śląskie voivodesip"/>
                        </a>

                        <div class="d-flex flex-column ms-2 w-100">
                            <a href="/en/voivodeships/SL">
                                <h3 class="border-bottom border-secondary-subtle link-secondary text-dark border-1 mb-0 transition-all">
                                   \s
                                    <span>ŚLĄSKIE</span>
                                    <span> VOIVODESHIP</span>
                                </h3>
                            </a>

                            <div class="text-justify mt-2">Silesian Voivodeship offers a diverse range of traditional foods. Enjoy hearty dishes like Kluski białe śląskie and Żur śląski, featuring local meats such as Żymlok śląski and Siewierska gęś pieczona. The region is known for baked goods like Kołocz weselny śląski and Śląski piernik tradycyjny, alongside dairy products like Ser klagany and Bryndza żywiecka. Local beverages include Miód lipowo-spadziowy and Cieszyńska herbata.</div>
                        </div>
                    </div>

                </section>
                <section class="mb-4 w-100 card shadow rounded-4">
                    <div class="d-flex card-body">
                        <a href="/en/voivodeships/SK">
                            <img class="coat-of-arms-size"
                                 src="/images/pol_wojewodztwo_swietokrzyskie_coa.svg_-1.png"
                                 alt="Coat of arms of świętokrzyskie voivodesip"/>
                        </a>

                        <div class="d-flex flex-column ms-2 w-100">
                            <a href="/en/voivodeships/SK">
                                <h3 class="border-bottom border-secondary-subtle link-secondary text-dark border-1 mb-0 transition-all">
                                   \s
                                    <span>ŚWIĘTOKRZYSKIE</span>
                                    <span> VOIVODESHIP</span>
                                </h3>
                            </a>

                            <div class="text-justify mt-2">Świętokrzyskie is known for its diverse culinary offerings, including meats like Dziona rakowskie and Kiełbasa swojska z Kunowa. Enjoy artisanal cheeses such as Jędrzejowski twarożek and Ser kozi z Machor, and sweet treats like Krówka opatowska and Tort czekoladowo-orzechowy. The region’s honey, such as Miód spadziowy z Puszczy Jodłowej, highlights its commitment to high-quality products.</div>
                        </div>
                    </div>

                </section>
                <section class="mb-4 w-100 card shadow rounded-4">
                    <div class="d-flex card-body">
                        <a href="/en/voivodeships/WN">
                            <img class="coat-of-arms-size"
                                 src="/images/800px-warminsko-mazurskie_herb.svg_.png"
                                 alt="Coat of arms of warmińsko-mazurskie voivodesip"/>
                        </a>

                        <div class="d-flex flex-column ms-2 w-100">
                            <a href="/en/voivodeships/WN">
                                <h3 class="border-bottom border-secondary-subtle link-secondary text-dark border-1 mb-0 transition-all">
                                   \s
                                    <span>WARMIŃSKO-MAZURSKIE</span>
                                    <span> VOIVODESHIP</span>
                                </h3>
                            </a>

                            <div class="text-justify mt-2">Warmińsko-Mazurskie, with its scenic lakes and forests, offers a rich variety of regional foods. The region is celebrated for smoked meats like Mazurska szynka wędzona and Mazurska kiełbasa wędzona. Dairy products such as Ser salami mazurski and Mleko zsiadłe, alongside honey varieties like Miód lipowy z Barcji, reflect its rich agricultural heritage. Sweet baked goods like Sękacz mazurski and Fefernuszki complete the regional flavor.</div>
                        </div>
                    </div>

                </section>
                <section class="mb-4 w-100 card shadow rounded-4">
                    <div class="d-flex card-body">
                        <a href="/en/voivodeships/WP">
                            <img class="coat-of-arms-size"
                                 src="/images/800px-pol_wojewodztwo_wielkopolskie_coa.svg_.png"
                                 alt="Coat of arms of wielkopolskie voivodesip"/>
                        </a>

                        <div class="d-flex flex-column ms-2 w-100">
                            <a href="/en/voivodeships/WP">
                                <h3 class="border-bottom border-secondary-subtle link-secondary text-dark border-1 mb-0 transition-all">
                                   \s
                                    <span>WIELKOPOLSKIE</span>
                                    <span> VOIVODESHIP</span>
                                </h3>
                            </a>

                            <div class="text-justify mt-2">Wielkopolska is celebrated for its rich culinary heritage. Enjoy high-quality meats like Wielkopolska wieprzowina and kiełbasa jałowcowa, along with dairy products such as Wielkopolski ser smażony and serek twarogowy kozi. The region is known for unique baked goods like Andruty kaliskie and chleb żytni wielkopolski, and beverages ranging from miodówka witosławska to piwo noteckie. Traditional dishes like czernina and bigos wielkopolski further highlight its hearty cuisine.</div>
                        </div>
                    </div>

                </section>
                <section class="mb-4 w-100 card shadow rounded-4">
                    <div class="d-flex card-body">
                        <a href="/en/voivodeships/ZP">
                            <img class="coat-of-arms-size"
                                 src="/images/800px-pol_wojewodztwo_zachodniopomorskie_coa.svg_.png"
                                 alt="Coat of arms of zachodniopomorskie voivodesip"/>
                        </a>

                        <div class="d-flex flex-column ms-2 w-100">
                            <a href="/en/voivodeships/ZP">
                                <h3 class="border-bottom border-secondary-subtle link-secondary text-dark border-1 mb-0 transition-all">
                                   \s
                                    <span>ZACHODNIOPOMORSKIE</span>
                                    <span> VOIVODESHIP</span>
                                </h3>
                            </a>

                            <div class="text-justify mt-2">Zachodniopomorskie features a diverse range of regional specialties. Sample distinctive breads like Chleb razowy koprzywieński and Chleb szczeciński, and enjoy honey varieties such as Miód drahimski and Miód pitny trójniak. The region is also known for preserved goods like Kapusta kiszona z beczki and Jeziorowy ogórek kiszony. For fish lovers, Paprykarz szczeciński and Sielawa wędzona showcase the area’s connection to its freshwater resources.</div>
                        </div>
                    </div>

                </section>

                <div class="border-top border-light-subtle mt-4 pb-4"></div>

                <section class="mb-4 w-100 card shadow rounded-4">
                    <div class="d-flex card-body">
                        <a href="/en/poland">
                            <img class="coat-of-arms-size"
                                 src="/images/Coat_of_arms_of_Poland-official.png"
                                 alt="Coat of arms of Poland"/>
                        </a>

                        <div class="d-flex flex-column ms-2 w-100">
                            <a href="/en/poland">
                                <h3 class="border-bottom border-secondary-subtle link-secondary text-dark border-1 mb-0 transition-all">
                                    <span>COUNTRY OF POLAND</span>
                                </h3>
                            </a>

                            <div class="text-justify mt-2">Poland’s culinary heritage is a rich blend of regional specialties that reflect its diverse landscapes and traditions. Each voivodeship offers unique products, from smoked meats like Kiełbasa nadbużańska and Lisiecka sausage to artisanal cheeses such as Oscypek and Bryndza. Traditional baked goods, like Toruń gingerbread and Chleb wiejski, highlight the country’s deep baking traditions, while a wide variety of honeys, including Miod drahimski, showcase local flora. The country’s beverages, from Śliwowica to fruit liqueurs, complement its hearty cuisine.</div>
                        </div>
                    </div>

                </section>

            </div>

            <div class="border-start border-light-subtle ms-5 pe-5"></div>

            <aside class="position-sticky top-1rem h-fit card shadow rounded-4 min-w-min-content">
                <div class="card-body px-0 pb-0">
                    <h5 class="text-center p-2">Total number of products for each voivodeship</h5>
                    <div class="overflow-clip rounded-bottom-4 border-top">
                        <table class="table mb-0">
                            <thead class="table-light">
                            <tr>
                                <th scope="col">Name</th>
                                <th scope="col" class="border-start">Count</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td class="py-1 word-break-keep-all">dolnośląskie</td>
                                <td class="py-1 border-start">6</td>
                            </tr>
                            <tr>
                                <td class="py-1 word-break-keep-all">kujawsko-pomorskie</td>
                                <td class="py-1 border-start">0</td>
                            </tr>
                            <tr>
                                <td class="py-1 word-break-keep-all">lubelskie</td>
                                <td class="py-1 border-start">0</td>
                            </tr>
                            <tr>
                                <td class="py-1 word-break-keep-all">lubuskie</td>
                                <td class="py-1 border-start">0</td>
                            </tr>
                            <tr>
                                <td class="py-1 word-break-keep-all">mazowieckie</td>
                                <td class="py-1 border-start">0</td>
                            </tr>
                            <tr>
                                <td class="py-1 word-break-keep-all">małopolskie</td>
                                <td class="py-1 border-start">0</td>
                            </tr>
                            <tr>
                                <td class="py-1 word-break-keep-all">opolskie</td>
                                <td class="py-1 border-start">0</td>
                            </tr>
                            <tr>
                                <td class="py-1 word-break-keep-all">podkarpackie</td>
                                <td class="py-1 border-start">0</td>
                            </tr>
                            <tr>
                                <td class="py-1 word-break-keep-all">podlaskie</td>
                                <td class="py-1 border-start">0</td>
                            </tr>
                            <tr>
                                <td class="py-1 word-break-keep-all">pomorskie</td>
                                <td class="py-1 border-start">0</td>
                            </tr>
                            <tr>
                                <td class="py-1 word-break-keep-all">warmińsko-mazurskie</td>
                                <td class="py-1 border-start">0</td>
                            </tr>
                            <tr>
                                <td class="py-1 word-break-keep-all">wielkopolskie</td>
                                <td class="py-1 border-start">0</td>
                            </tr>
                            <tr>
                                <td class="py-1 word-break-keep-all">zachodniopomorskie</td>
                                <td class="py-1 border-start">0</td>
                            </tr>
                            <tr>
                                <td class="py-1 word-break-keep-all">łódzkie</td>
                                <td class="py-1 border-start">0</td>
                            </tr>
                            <tr>
                                <td class="py-1 word-break-keep-all">śląskie</td>
                                <td class="py-1 border-start">0</td>
                            </tr>
                            <tr>
                                <td class="py-1 word-break-keep-all">świętokrzyskie</td>
                                <td class="py-1 border-start">0</td>
                            </tr>
                            <tr>
                                <td class="py-1 fw-bolder">combined</td>
                                <td class="py-1 fw-bolder border-start">6</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </aside>
        </div>
    </div>
</main>

<footer>
    <nav class="navbar bg-body-tertiary d-flex justify-content-center gap-2">
        <div>© $$$CURRENT_YEAR$$$ Łukasz Michalak</div>
        <a href="https://github.com/devLukaszMichalak/regional-products" target="_blank" role="link" rel="external" class="navbar-brand">
            <svg height="32" aria-hidden="true" viewBox="0 0 24 24" version="1.1" width="32"
                 data-view-component="true" class="octicon octicon-mark-github v-align-middle color-fg-default">
                <path d="M12.5.75C6.146.75 1 5.896 1 12.25c0 5.089 3.292 9.387 7.863 10.91.575.101.79-.244.79-.546 0-.273-.014-1.178-.014-2.142-2.889.532-3.636-.704-3.866-1.35-.13-.331-.69-1.352-1.18-1.625-.402-.216-.977-.748-.014-.762.906-.014 1.553.834 1.769 1.179 1.035 1.74 2.688 1.25 3.349.948.1-.747.402-1.25.733-1.538-2.559-.287-5.232-1.279-5.232-5.678 0-1.25.445-2.285 1.178-3.09-.115-.288-.517-1.467.115-3.048 0 0 .963-.302 3.163 1.179.92-.259 1.897-.388 2.875-.388.977 0 1.955.13 2.875.388 2.2-1.495 3.162-1.179 3.162-1.179.633 1.581.23 2.76.115 3.048.733.805 1.179 1.825 1.179 3.09 0 4.413-2.688 5.39-5.247 5.678.417.36.776 1.05.776 2.128 0 1.538-.014 2.774-.014 3.162 0 .302.216.662.79.547C20.709 21.637 24 17.324 24 12.25 24 5.896 18.854.75 12.5.75Z"></path>
            </svg>
        </a>
    </nav>
</footer>

</body>
</html>
"""
          .replace("$$$CURRENT_YEAR$$$", Integer.toString(LocalDate.now().getYear()));
}
