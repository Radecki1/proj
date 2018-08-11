package pl.cba.radeckiuczony.mushroomer;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class ListActivity extends AppCompatActivity {


    ListView lvDetail;
    Context context = ListActivity.this;
    ArrayList<ListData> myList = new ArrayList<ListData>();

    String[] title = new String[]{"Boczniak ostrygowaty", "Borowiec dęty", "Borowik brzozowy", "Borowik ceglastopory", "Borowik zółtopory", "Borowik kasztanowy", "Borowik omglony", "Borowik płowy", "Borowik ponury", "Borowik purpurowy", "Borowik sosnowy", "Borowik szlachetny", "Borowik usiatkowany",
            "Borowik zajęczy", "Borowik złotawy", "Borowik żółtobrązowy", "Bruzdniczek największy", "Buławka obcięta", "Czasznica olbrzymia", "Czernidłak błyszczący", "Czernidłak pospolity", "Czernidłak pstry", "Czubajeczka brązowoczer.", "Czubajeczka cuchnąca", "Czubajka czerwieniejąca",
            "Czubajka kania", "Długotrzonka popielata", "Dwupierścieniak cesarski", "Dzieżka pomarańczowa", "Dzwonkówka trująca", "Galaretek kolczasty", "Gałęziak groniasty", "Gąska biaława", "Gąska mydlana", "Gąska niekształtna" ,"Gąska ostra", "Gąska pieprzna",
            "Gąska siarkowa", "Gąska szerokoblaszkowa", "Gąska zielonka", "Gąska żółtobrunatna", "Gąsówka dwubarwna", "Gąsówka fioletowawa", "Gąsówka płowa", "Gołąbek białozielonawy", "Gołąbek błotny", "Gołąbek brzozowy", "Gołąbek cukrówka",
            "Gołąbek jasnożółty", "Gołąbek krwisty", "Gołąbek kunowy", "Gołąbek lazurowy", "Gołąbek płowiejący", "Gołąbek słodkawy", "Gołąbek smaczny", "Gołąbek śliczny", "Gołąbek winnoczerwony", "Gołąbek wyborny", "Gołąbek zielonawofiolet.", "Gołąbek zielonawy",
            "Gołąbek złotawy", "Goryczak purpurowozarod.", "Goryczak żółciowy", "Goździeniec fioletowy", "Goździeniec gliniasty", "Goździeńczyk grzebieniasty", "Goździeńczyk pomarsz.", "Goździeńczyk popielaty", "Grzybówka różowa", "Grzybówka ząbkowana",
            "Hełmówka błotna", "Hełmówka jadowita", "Kępkowiec białawy", "Kępkowiec ciemnoszary", "Kępkowiec jasnobrązowy", "Klejek lepki", "Klejówka świerkowa", "Kolczak obłączasty", "Kołpaczek mierzwiowy", "Kopułek łąkowy", "Kopułek śnieżny", "Koralówka gruba",
            "Koralówka strojna", "Koralówka złocista", "Koronica ozdobna", "Koźlarz babka", "Koźlarz białawy", "Koźlarz dębowy", "Koźlarz grabowy", "Koźlarz pomarańczowożółty", "Koźlarz świerkowy", "Koźlarz topolowy", "Krowiak podwinięty", "Kurzawka czerniejąca",
            "Lakówka ametystowa", "Lakówka pospolita", "Lejkoporek olszowy", "Lejkowiec dęty", "Lejkówka biaława", "Lejkówka buławotrzonowa", "Lejkówka liściowa", "Lejkówka śnieżysta", "Lejkówka zielonawa", "Lisówka pomarańczowa", "Łopatnica żółtawa", "Łuskowiec jeleni",
            "Łuszczak zmienny", "Łycznik późny", "Łysak wspaniały", "Łysiczka łuskowata", "Łysostopek pospolity", "Łysostopek pozrastany", "Łysostopek wrzec.trz.", "Majówka wiosenna", "Maślak pstry", "Maślak sitarz", "Maślak szary", "Maślak ziarnisty", "Maślak żółty",
            "Maślanka łagodna", "Maślanka wiązkowa", "Mitrówka półwolna", "Mleczaj bezstrefowy", " Mleczaj bladawy", "Mleczaj dołkowany", "Mleczaj jodłowy", "Mleczaj kamforowy", "Mleczaj płowy", "Mleczaj rydz", "Mleczaj świerkowy", "Mleczaj wełnianka", "Monetnica maślana", "Muchomor cesarski",
            "Muchomor cytrynowy", "Muchomor czerwieniejący", "Muchomor czerwony", "Muchomor jadowity", "Muchomor oliwkowy", "Muchomor plamisty", "Muchomor rdzawobrązowy", "Muchomor sromotnikowy", "Muchomor szarawy", "Muchomor szyszkowaty", "Naparstniczka stożkowata", "Naziemek białawy",
            "Naziemek ceglasty", "Opieńka bezpierścieniowa", "Opieńka miodowa", "Opieńka ciemna", "Ozorek dębowy", "Piaskowiec kasztanowaty", "Piaskowiec modrzak", "Pieczareczka amerykańska", "Pieczarka krótkotrzonowa", "Pieczarka leśna", "Pieczarka łąkowa", "Pieprznik jadalny",
            "Pieprznik szary", "Pieprznik trąbkowy", "Piestrak jadalny", "Piestrzenica infułowata", "Piestrzenica kasztanowata", "Piestrzyca kędzierzawa", "Piestrzyca zatokowata", "Płachetka kołpakowata", "Płomiennica zimowa", "Płomykówka galaretowata", "Podgrzybek czerwonawy",
            "Podgrzybek tęgoskórowy ", "Ponurnik aksamitny", "Przyczepka falista", "Purchaweczka spłaszczona", "Purchawka oczkowata", "Sarniak dachówkowaty", "Siatkolist maczugowaty", "Siedzuń dębowy", "Siedzuń sosnowy", "Smardz jadalny", "Soplówka bukowa", "Sromotnik smrodliwy",
            "Strzępiak ceglasty", "Szyszkowiec łuskowaty", "Tęgoskór cytrynowy", "Trufla letnia", "Twardówka anyżkowa", "Twardzioszek przydrożny", "Uchówka ośla", "Uszak bzowy", "Wilgotnica karminowa", "Wilgotnica żółknąca", "Włośnianka musztardowa", "Wodnicha biała", "Wodnicha brunatnobiała",
            "Wodnicha gołąbkowa", "Wodnicha modrzewiowa", "Wodnicha późna","Zasłonak ceglastożółty", "Zasłonak kleisty", "Zasłonak krwisty" ,"Zasłonak purpurowoblaszkowy", "Zasłonak rudawy", "Zasłonak wonny","Żagiew łuskowata"
    };

    String[] desc = new String[]{"Pleurotus ostreatus", "Boletinus cavipes", "Boletus betulicosa", "Boletus erythropus", "Boletus calopus", "Xerocomus badius", "Boletus pulverulentus", "Boletus impolitus", "Suillellus luridus", "Boletus rhodoxanthus", "Boletus pinicola",
            "Boletus edulis", "Boletus reticulatus", "Xerocomus subtomentosus", "Xerocomus chrysenteron", "Boletus appendiculatus", "Clitopilus prunulus", "Clavariadelphus truncatus", "Langermannia gigantea", "Coprinus micaceus", "Coprinopsis atramentaria",
            "Coprinopsis picacea", "Lepiota brunneoincarnata", "Lepiota cristata", "Chlorophyllum rachodes", "Macrolepiota procera", "Macroscyphus macropus", "Catathelasma imperiale", "Aleuria aurantia", "Entoloma sinuatum", "Pseudohydnum gelatinosum",
            "Ramaria botrytis", "Tricholoma album", "Tricholoma saponaceum", "Tricholoma portentosum" ,"Tricholoma sciodes", "Tricholoma virgatum", "Tricholoma sulphureum", "Tricholoma luridum", "Tricholoma flavovirens",
            "Tricholoma fulvum", "Lepista personata", "Lepista nuda", "Paralepista gilva", "Russula aeruginea", "Russula paludosa", "Russula betularum", "Russula alutacea", "Russula claroflava", "Russula sanguinaria", "Russula mustelina", "Russula azurea",
            "Russula decolorans", "Russula integra", "Russula delica", "Russula rosacea", "Russula vinosa", "Russula vesca", "Russula cyanoxantha", "Russula virescens", "Russula aurata", "Porphyrellus porphyrosporus", "Tylopilus felleus", "Clavaria zollingeri",
            "Clavaria argillacea", "Clavaria cristata", "Clavulina rugosa", "Clavaria cinerea", "Mycena rosea", "Mycena haematopus", "Galerina paludosa", "Galerina marginata", "Lyophyllum connatum", "Lyophyllum fumosum", "Lyophyllum decastes", "Gomphidius rutilus",
            "Gomphidius glutinosus", "Hydnum repandum", "Panaeolus papilionaceusn", "Camarophyllus pratensis", "Camarophyllus niveus", "Ramaria largentii", "Ramaria formosa", "Ramaria aurea", "Sarcosphaera coronaria", "Leccinum scabrum", "Leccinum holopus",
            "Leccinum quercinum", "Leccinum griseum", "Leccinum versipelle", "Leccinum piceinum", "Leccinum duriusculum", "Paxillus involutus", "Bovista nigrescens", "Laccaria amethystina", "Laccaria laccaria", "Gyrodon lividus", "Craterellus cornucopioides",
            "Leucocybe candicans", "Clitocybe claviceps", "Clitocybe phyllophila", "Leucopaxillus candidus", "Clitocybe odora", "Hygrophoropsis aurantiaca", "Spathularia flavida", "Pluteus cervinus", "Kuehneromyces mutabilis", "Panellus serotinus", "Gymnopilus junonius",
            "Leratiomyces squamosus", "Gymnopus dryophilus", "Gymnopus confluens", "Gymnopus fusipes", "Calocybe gambosa", "Suillus variegatus", "Suillus bovinus", "Suillus viscidus", "Suillus granulatus", "Suillus flavus", "Hypholoma capnoides", "Hypholoma fasciculare",
            "Mitrophora semilibera", "Lactarius azonites", "Lactarius pallidus", "Lactarius scrobiculatus", "Lactarius salmonicolor", "Lactarius camphoratus", "Lactarius helvus", "Lactarius deliciosus", "Lactarius deterrimus", "Lactarius torminosus", "Rhodocollybia butyracea",
            "Amanita caesarea", "Amanita citrina", "Amanita rubescens", "Amanita muscaria", "Amanita virosa", "Amanita battarae", "Amanita pantherina", "Amanita fulva", "Amanita phalloides", "Amanita vaginata", "Amanita strobiliformis", "Verpa conica", "Albatrellus ovinus",
            "Albatrellus confluens", "Armillaria tabascens", "Armillaria mellea", "Armillaria ostoyae", "Fistulina hepatica", "Gyroporus castaneus", "Gyroporus cyanescens", "Leucoagaricus americanus", "Agaricus placomyces", "Agaricus silvaticus", "Agaricus campestris",
            "Cantharellus cibarius", "Cantharellus cinereus", "Cantharellus tubaeformis", "Choiromyces meandriformis", "Gyromitra infula", "Gyromitra esculenta", "Helvella crispa", "Helvella lacunosa", "Pholiota caperata", "Flamullina velutipes", "Tremiscus helvelloides",
            "Boletus rubellus", "Xerocomus parasiticus", "Tapinella atrotomentosa", "Rhizina undulata", "Vascellum pratense", "Calvatia utriformis", "Sarcodon imbricatus", "Gomphus clavatus", "Sparassis brevipes", "Sparassis crispa", "Morchella esculenta", "Hericium clathroides",
            "Phallus impudicus", "Inocybe erubescens", "Strobilomyces floccopus", "Scleroderma citrinum", "Tuber aestivum", "Lentinellus cochleatus", "Marasmius oreades", "Otidea onotica", "Auricularia auricula-judae", "Hygrocybe punicea", "Hygrocybe chlorophana",
            "Hebeloma sinapizans", "Hygropgorus eburneus", "Hygrophorus latitabundus", "Hygrophorus russula", "Hygrophorus pudorinus", "Hygrophorus hypothejus", "Cortinarius varius", "Cortinarius mucosus", "Cortinarius sanguineus",
            "Cortinarius semisanguineus", "Cortinarius rubellus", "Cortinarius traganus", "Polyporus squamosus"
    };

    int[] img = new int[]{R.drawable.bigb, R.drawable.dety, R.drawable.gandhi, R.drawable.gopichand, R.drawable.kalam, R.drawable.kasztanowy, R.drawable.omglony, R.drawable.plowy, R.drawable.ponury, R.drawable.purpurowy, R.drawable.sosnowy, R.drawable.szlachetny, R.drawable.usiatkowany,
            R.drawable.zajeczy, R.drawable.zlotawy, R.drawable.zoltobrazowy, R.drawable.najwiekszybruz, R.drawable.obcieta, R.drawable.czasznica, R.drawable.czernidlaczek, R.drawable.czernidlak, R.drawable.pstry, R.drawable.brazowoczerwona, R.drawable.cuchnaca, R.drawable.czerwieniejaca,
            R.drawable.kania, R.drawable.dlpopielata, R.drawable.cesarski, R.drawable.dzpomaranczowa, R.drawable.dzwtrujaca, R.drawable.kolczasty, R.drawable.groniasty, R.drawable.bialawa, R.drawable.mydlana, R.drawable.nieksztaltna, R.drawable.ostra,
            R.drawable.pieprzna, R.drawable.siarkowa, R.drawable.szerokoblaszkowa, R.drawable.zielonka, R.drawable.zoltobrunatna, R.drawable.dwubarwna, R.drawable.fioletowawa, R.drawable.gaplowa, R.drawable.bialozielony,
            R.drawable.blotny, R.drawable.brzozowy, R.drawable.cukrowka, R.drawable.jasnozolty, R.drawable.krwisty, R.drawable.kunowy, R.drawable.lazurowy, R.drawable.plowiejacy, R.drawable.golslodkawy, R.drawable.smaczny, R.drawable.sliczny, R.drawable.winnoczerwony,
            R.drawable.wyborny, R.drawable.zielonofioletowy, R.drawable.zielonawy, R.drawable.zlotawy, R.drawable.purpurozarod, R.drawable.zolciowy  , R.drawable.fioletowy, R.drawable.gliniasty, R.drawable.grzebieniasty, R.drawable.pomarszczony, R.drawable.popielatygoz,
            R.drawable.rozowagrzy, R.drawable.zabkowana, R.drawable.heblotna, R.drawable.jadowita, R.drawable.bialawykep, R.drawable.ciemnoszarykap, R.drawable.jasnobrazowy, R.drawable.lepki, R.drawable.swierkowa, R.drawable.oblaczasty, R.drawable.motylkowaty, R.drawable.lakowy,
            R.drawable.sniezny, R.drawable.gruba, R.drawable.strojna, R.drawable.zlocista, R.drawable.ozdobna, R.drawable.babka, R.drawable.bialawy, R.drawable.debowy, R.drawable.grabowy, R.drawable.pomaranczowy, R.drawable.swierkowy, R.drawable.topolowy, R.drawable.podwiniety,
            R.drawable.czerniejaca, R.drawable.ametystowa, R.drawable.pospolitalek, R.drawable.olszowylej, R.drawable.detylej, R.drawable.bialawalej, R.drawable.bulawotrzon, R.drawable.lisciowa, R.drawable.sniezysta, R.drawable.zielonawalej, R.drawable.pomaranczowa,
            R.drawable.zoltawalopa, R.drawable.jeleni, R.drawable.zmienny, R.drawable.lypozny, R.drawable.wspanialylys, R.drawable.luskowata, R.drawable.pospolitylys, R.drawable.pozrastany, R.drawable.wrzecionowat, R.drawable.wiosenna, R.drawable.pstrymas, R.drawable.sitarz,
            R.drawable.szaryma, R.drawable.ziarnisty, R.drawable.zoltymasl, R.drawable.lagodnama, R.drawable.wiazkowa, R.drawable.polwolna, R.drawable.bezstresowy, R.drawable.bladawy,R.drawable.dolkowany ,R.drawable.jodlowy, R.drawable.komfortowy, R.drawable.plowymlecz, R.drawable.rydz, R.drawable.swierkowyml,
            R.drawable.welnianka, R.drawable.maslana, R.drawable.cesarskimuch, R.drawable.cytrynowy, R.drawable.czerwieniejacy, R.drawable.czerwonymuch, R.drawable.jadowity, R.drawable.oliwkowy, R.drawable.plamisty, R.drawable.rdzawobrazowy, R.drawable.sromotnikowy, R.drawable.szarawy,
            R.drawable.szyszkowaty, R.drawable.stozkowata, R.drawable.bialawynaz, R.drawable.ceglasty, R.drawable.bezpierscieniowa, R.drawable.miodowaopi, R.drawable.ciemnaopi, R.drawable.debowyozo, R.drawable.kasztanowypia, R.drawable.modrzak, R.drawable.amerykanskapie, R.drawable.krotkotrzonowa,
            R.drawable.lesnapie, R.drawable.polnapie, R.drawable.jadalnypie, R.drawable.szarypie, R.drawable.trabkowy, R.drawable.jadalnypiest, R.drawable.infolowata, R.drawable.kasztanowata, R.drawable.kedzierzawa, R.drawable.zatokowata, R.drawable.kolpakowata, R.drawable.zimowapl,
            R.drawable.galaretkowataplo, R.drawable.czerwonypod, R.drawable.tegoskorny, R.drawable.aksamitny, R.drawable.falista, R.drawable.splaszczona, R.drawable.oczkowata, R.drawable.dachowkowatysa, R.drawable.maczugowaty, R.drawable.debowysz, R.drawable.sosnowysie, R.drawable.jadalnysma,
            R.drawable.bukowasop, R.drawable.smrodliwysro, R.drawable.ceglastyst, R.drawable.luskowatyszy, R.drawable.cytrynowyteg, R.drawable.letniatru, R.drawable.anyzkowatw, R.drawable.przydrozny, R.drawable.oslauch, R.drawable.bzowyusz, R.drawable.karminowawi, R.drawable.zolknacawil,
            R.drawable.musztardowa, R.drawable.bialawod, R.drawable.brunatnobiala, R.drawable.golabkowawo, R.drawable.modrzewiowa, R.drawable.poznawod, R.drawable.ceglastozolty,  R.drawable.kleistyzas, R.drawable.krwistyzas, R.drawable.purpurowoblasz,
            R.drawable.rudawy, R.drawable.wonnyzas, R.drawable.luskowatazag
    };
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP)
        {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }

        lvDetail = findViewById(R.id.listView);
        getDataInList();
        lvDetail.setAdapter(new MyBaseAdapter(context, myList));

        lvDetail.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String TempListViewClickedValue = "blabla".toString();
                String TempListViewClickedValue2 = "blabla2".toString();
                String TempListViewClickedValue3 = "".toString();
                String TempListViewClickedValue4 = "Gatunki podobne to:".toString();

                String list1 = "uwaga".toString();
                String list2 = "error".toString();
                int qwe = R.drawable.aksamitny;
                int qwe2 = R.drawable.anyzkowatw;

                String list13 = "uwaga".toString();
                String list3 = "error".toString();
                int qwe3 = R.drawable.aksamitny;

                String list14 = "uwaga".toString();
                String list4 = "error".toString();
                int qwe4 = R.drawable.aksamitny;

                String list15 = "uwaga".toString();
                String list5 = "error".toString();
                int qwe5 = R.drawable.aksamitny;

                ImageView qimageView2 = findViewById(R.id.img1);
                TextView qtextView2 = findViewById(R.id.title11);
                TextView qtextView22 = findViewById(R.id.title12);

                ImageView qimageView3 = findViewById(R.id.img2);
                TextView qtextView3 = findViewById(R.id.title21);
                TextView qtextView23 = findViewById(R.id.titlee22);

                ImageView qimageView4 = findViewById(R.id.img3);
                TextView qtextView4 = findViewById(R.id.title13);
                TextView qtextView24 = findViewById(R.id.title23);

                ImageView qimageView5 = findViewById(R.id.img4);
                TextView qtextView5 = findViewById(R.id.title14);
                TextView qtextView25 = findViewById(R.id.title24);

               int jedzenie = R.drawable.aksamitnakru;
               int lasy = R.drawable.aksamitnakru;
               int typgrzyb = R.drawable.aksamitnakru;

                ImageView jadalnosc = findViewById(R.id.klasa);



                switch (position){
                    case 0:
                        TempListViewClickedValue = "Boczniak ostrygowaty" +"\n" + "Pleurotus ostreatus".toString();
                        TempListViewClickedValue2 = "Kapelusz o średnicy od 5 do 15 cm, kształtem przypomina ostrygę lub wydłużony język; kolor od białego do ciemnoszarego, gładki, matowy.\n" +
                                "\n" +
                                "Blaszki u młodych owocników białe, później brązowieją, zbiegają na trzon.\n" +
                                "\n" +
                                "Trzon białawy, głęboko osadzony w kapeluszu zwykle krótki. \n" +
                                "\n" +
                                "Miąższ masywny, biały, o łagodnym smaku i delikatnym zapachu. \n" +
                                "\n" +
                                "Występuje na pniach drzew liściastych, grzybnia powoduje białą zgniliznę drzewa, można go spotkać najczęściej koło dróg, na ściętych pniach topól i wierzb, w lesie na powalonych pniach bukowych.\n" +
                                "\n" +
                                "Zastosowanie - jadalny. \n".toString();
                        qwe = R.drawable.bialawozol;
                        qwe2 = R.drawable.ostrygobig;
                        list1 = "Boczniak białożółty Pleurotus dryinus,".toString();
                        list2 = "ma jaśniejszy, białawy kapelusz o powierzchni nieco kosmkowatej;";
                        list13 = "ma trąbkowaty kapelusz i rowkowany trzon;";
                        list3 = "Boczniak rowkowanotrzonowy Pleurotus cornucopiae,";
                        qwe3 = R.drawable.rowkowatorzo;
                        list14 = "ma jasny kapelusz, anyzkowy zapach i występuje wczesnym latem do jesieni;";
                        list4 = "Boczniak łyżkowaty Pleurotus pulmonarius,";
                        qwe4 = R.drawable.lyzkowatybocz;
                        list15 = "jest mniejszy i często ma zielonkawe odcienie.";
                        list5 = "Łycznik późny Sarcomyxa serotina,";
                        qwe5 = R.drawable.lypozny;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.def1;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 1:
                        TempListViewClickedValue = "Borowiec dęty Boletinus cavipes".toString();
                        TempListViewClickedValue3 = "Gatunek objęty ochroną częściową w Polsce!".toString();
                        TempListViewClickedValue2 = "Kapelusz o średnicy 6-17 cm, od jasnożółtego do ciemnobrązowego, niekiedy cynamonowobrązowy, pomarańczowożółty lub cytrynowożółty. \n" +
                                "\n" +
                                "Powierzchnia matowa, sucha, gęsto pokryta drobnymi kosmkami.\n" +
                                "\n" +
                                "Rurki żółte, później zielonożółtawe, bardzo szerokie i wydłużone, zbiegające na trzon.\n" +
                                "\n" +
                                "Trzon nieco jaśniejszy niż kapelusz, lekko kosmkowaty od młodości pusty z białawymi resztkami pierścienia. \n" +
                                "\n" +
                                "Miąższ kapelusza białawy, trzonu brązowawy, słaby zapach, łagodny smak.\n" +
                                "\n" +
                                "Występuje od sierpnia do października, rzadki, w górach częstszy zawsze pod modrzewiami (mikoryza).\n" +
                                "\n" +
                                "Zastosowanie - jadalny. \n".toString();
                        qwe = R.drawable.czerwonymas;
                        qwe2 = R.drawable.detybig;
                        list1 = "Maślak czerwony Sulillus lakei,".toString();
                        list2 = "trzon żółtawy, z czerwonymi smugami.";

                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 2:
                        TempListViewClickedValue = "Borowik brzozowy Boletus betulicosa".toString();
                        TempListViewClickedValue2 = "Owocnik o średnicy 5-15cm. Młody półkulisty, później wypukły. Barwy białej białoszarej lub jasnoochrowej. \n" +
                                "\n" +
                                "Powierzchnia gładka, sucha. W porze wilgotnej nieco lepka. \n" +
                                "\n" +
                                "Pory drobne, okrągłe. W kolorze rurek, uszkodzone nie zmieniają zabarwienia. \n" +
                                "\n" +
                                "Rurki długie, od 15 do 30 mm. przy trzonie wygięte. Początkowo białe, później jasnożółte i żółtozielonkawe. \n" +
                                "\n" +
                                "Trzon 5-12cm długości i 1,5-4 cm grubości. Początkowo bulwiasto zgrubiały przy podstawie, pękaty, z wiekiem cylindryczny. W kolorze biały do jasnoochrowego. \n" +
                                "\n" +
                                "Miąższ biały w kolorze. Pod skórką kapelusza z słabym odcieniem szarozielonkawym. Smak i zapach łagodny, przyjemny, grzybowy. \n" +
                                "\n" +
                                "Występuje rzadko, od lata do jesieni towarzyszy brzozom. \n" +
                                "\n" +
                                "Zastosowanie- jadalny. \n".toString();
                        qwe = R.drawable.usiatkowany;
                        qwe2 = R.drawable.brzozbig;
                        list1 = "Borowik usiatkowany Boletus reticulatus,".toString();
                        list2 = "występuje pod dębami i bukami; powierzchnia motowa, zamszowata.";

                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.t1;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 3:
                        TempListViewClickedValue = "Borowik ceglastopory Boletus erythropus".toString();
                        TempListViewClickedValue2 = "Kapelusz o średnicy 5-20 cm; ciemny, barwy zazwyczaj ciemnobrązowej, rzadziej ciemniejszy (kasztanowobrązowy); może też być ciemnoceglastoczerwony; kształt kapelusza u młodych egzemplarzy półkulisty, potem poduszkowaty, u starych płaski, mocny i mięsisty; skórka nie daje się oddzielić od miąższu. \n" +
                                "\n" +
                                "Sucha powierzchnia jest matowa, zamszowata, lepka tylko podczas deszczu.\n" +
                                "\n" +
                                "Rurki są drobne, za młodu żółtawooliwkowe, szybko pomarańczowe do krwistoczerwonych, stare bledsze, z oliwkowym odcieniem; pory i rurki po uszkodzeniu momentalnie sinieją; rurki żółte, z wiekiem oliwkowe; miąższ nad rurkami barwy żółtej. \n" +
                                "\n" +
                                "Trzon - na żółtym tle są widoczne czerwone kosmki lub ziarenka, brak rysunku siateczki, powierzchnia lekko filcowata. Już przy lekkim ucisku przebarwia się ciemnogranatowo. Za młodu pękaty lub ze zgrubiałą podstawą, potem coraz bardziej cylindryczny i smukły. \n" +
                                "\n" +
                                "Miąższ - żółty, po przecięciu momentalnie intensywnie sinieje, staje się czarnobłękitny; przebarwienie po pewnym czasie ustępuje. Bardzo zwarty i twardy, jędrny; smak łagodny; zapach słaby, przyjemny. \n" +
                                "\n" +
                                "Częsty w górach, w lasach świerkowych i pod jodłami, poza górami rzadki; rośnie na ziemi, w lasach iglastych, liściastych (pod dębami i bukami) i mieszanych; preferuje kwaśne gleby; owocniki od maja do października (listopada). \n" +
                                "\n" +
                                "Zastosowanie - jadalny po dokładnym ugotowaniu lub usmażeniu; surowy lub częściowo surowy jest trujący, bardzo smaczny. \n".toString();
                        qwe = R.drawable.zoltopory;
                        qwe2 = R.drawable.ceglastoporyborbig;
                        list1 = "Borowik żółtopory Caloboletus calopus,".toString();
                        list2 = "siatka na trzonie, żółte rurki, ciemniejszy kapelusz;";
                        list13 = "ma kapelusz oliwkowobrązowy, pomarańczowoczerwony lub ceglastoczerwony, pomarańczowe pory i trzon u podstawy karminowoczerwony.";
                        list3 = "Borowik gładkotrzonowy Suillellus queletii,";
                        qwe3 = R.drawable.gladkotrzon;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t1;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 4:
                        TempListViewClickedValue = "Borowik zółtopory Boletus calopus".toString();
                        TempListViewClickedValue2 = "Kapelusz o średnicy do 20 cm; stopniowo otwiera młodzieńczą półkulę i staje się poduchowato płaski; brzeg pozostaje podwinięty.\n" +
                                "\n" +
                                "Skórka gładka, niekiedy lekko pomarszczona, matowa, sucha, zamszowa, aksamitna. \n" +
                                "\n" +
                                "Rurki początkowo u młodych okazów cytrynowożółte, u starszych oliwkowe; pory cytrynowe, później oliwkowe, po dotknięciu sinieją. \n" +
                                "\n" +
                                "Trzon 3-15 cm wysokości, 1-5 cm grubości; u szczytu jasnożółty, cytrynowożółty, z żółtą siateczką; w części środkowej karminowy, z bardzo wyraźną czerwoną siateczką; w dolnej części brązowoczerwony. Oczka siatki ku dołowi są większe i bardziej wydłużone. Kształt maczugowaty, baryłkowaty, rzadziej cylindryczny; mocny i pełny. \n" +
                                "\n" +
                                "Miąższ bladokremowy do bladożółtego, u podstawy trzonu różowawy, błękitnieje po przekrojeniu; twardy, jędrny, mięsisty. zapach słaby, grzybowy,  smak początkowo łagodny, potem gorzki.  \n" +
                                "\n" +
                                "Najczęstszy w terenach górskich, na nizinach rzadszy; zasiedla lasy liściaste i iglaste na glebach ubogich, kwaśnych i umiarkowanie suchych. Pojawia się od czerwca do października. \n" +
                                "\n" +
                                "Zastosowanie - niejadalny (gorzki). \n".toString();
                        qwe = R.drawable.ponury;
                        qwe2 = R.drawable.zoltobig;
                        list1 = "Borowik ponury Suillellus luridus,".toString();
                        list2 = "ma rurki pomarańczowoczerwone i nie ma czerwonego trzonu;";
                        list13 = "podobne ubarwienie kapelusza;";
                        list3 = "Borowik szatański Rubroboletus satanas,";
                        qwe3 = R.drawable.szatanski;
                        list14 = "ubarwienie kapelusza.";
                        list4 = "Borowik korzeniasty Boletus radicans,";
                        qwe4 = R.drawable.korzeniasty;
                        jedzenie = R.drawable.niejadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t1;
                        jadalnosc.setImageResource(R.drawable.niejadalny);
                        break;
                    case 5:
                        TempListViewClickedValue = "Borowik kasztanowy Xerocomus badius"+"\n" +"jako Podgrzybek brunatny".toString();
                        TempListViewClickedValue2 = "Rozmiar kapelusza dochodzi do 15 cm średnicy. Jest nagi i gładki, u młodych egzemplarzy półkolisty z podwiniętymi brzegami, ciemnobrązowy z czerwonawym odcieniem lub kasztanowo-brunatny. U starszych egzemplarzy kapelusz jest rozpostarty, dość płaski, czasem z wywiniętymi do góry brzegami.\n" +
                                "\n" +
                                "Rurki lekko wcięte wokół trzonu. Barwa od bladoochrowej do oliwkowo-żółtej. Uszkodzone zmieniają kolor na niebieskozielony. Pory początkowo są białe, później żółte.\n" +
                                "\n" +
                                "Trzon o grubości do 4 cm, wysokości do 10 cm. Jasnobrązowy, ma podłużne, ciemniejsze pręgi. U młodych egzemplarzy trzon zazwyczaj jest pękaty, następnie cylindryczny. W miejscu uszkodzenia zmienia kolor na ciemnoniebieski.\n" +
                                "\n" +
                                "Miąższ twardy, w starszych trzonach zdrewniały. Biały, u starszych egzemplarzy lekko żółty. Przekrojony lekko sinieje. Smak i zapach przyjemny.\n" +
                                "\n" +
                                "Rośnie w lasach iglastych i mieszanych na ziemi, czasami tuż przy pniakach, często w mchu. Najczęściej spotykany jest pod sosną zwyczajną i świerkiem pospolitym. Tworzy owocniki od lata do późnej jesieni.\n" +
                                "\n" +
                                "Zastosowanie - grzyb jadalny. W surowym stanie jest trujący\n".toString();
                        qwe = R.drawable.zolciowy;
                        qwe2 = R.drawable.kasztanowybig;
                        list1 = "Goryczak żółciowy Tylopilus felleus,".toString();
                        list2 = "podobne młode owocniki. Wątpliwości rozstrzygnąć można próbą smakową (goryczak jest gorzki);";
                        list13 = "podobne starsze owocniki, który jednak ma jamkowato pusty trzon i jego miąższ nie zmienia barwy po przecięciu.";
                        list3 = "Piaskowiec kasztanowaty Gyroporus castaneus,";
                        qwe3 = R.drawable.kasztapis;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t1;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 6:
                        TempListViewClickedValue = "Borowik omglony Boletus pulverulentus".toString();
                        TempListViewClickedValue2 = "Owocnik zmiennej barwy, brązowy, ciemnobrązowy, czasem jasny orzechowobrązowy, szarooliwkowy, z wiekim z rdzawym odcieniem; 4-11 cm średnicy; początkowo półkulisty, z wiekiem wypukły do płaskiego; brzeg długo podgięty, pofałdowany. \n" +
                                "\n" +
                                "Powierzchnia gładka, aksamitna, z wiekiem także popękana, wilgotna nieco lepka.\n" +
                                "\n" +
                                "Pory cytrynowozłotożółte. \n" +
                                "\n" +
                                "Rurki oliwkowożółte, przyrośnięte do trzonu, nieco wykrojone do krótko zbiegających. \n" +
                                "\n" +
                                "Trzon w górnej części żółty, ku podstawie brązowoczerwony do purpurowoczerwonego, równogruby lub zwężający się ku podstawie, powierzchnia aksamitna. \n" +
                                "\n" +
                                "Miąższ żółty, natychmiast przebarwia się sino; zapach przyjemny; smak łagodny, przyjemny. \n" +
                                "\n" +
                                "Niezbyt częsty, występuje w lasach liściastych i iglastych, na glebach kwaśnych i ubogich, piaszczystych. Pojedynczo lub w grupach od lata do jesieni. \n" +
                                "\n" +
                                "Zastosowanie - jadalny.\n".toString();
                        qwe = R.drawable.korzeniasty;
                        qwe2 = R.drawable.omglonybig;
                        list1 = "Borowik korzeniasty Boletus radicans,".toString();
                        list2 = "ma zgrubiały u podstawy trzon, miąższ także natychmiast sinieje.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t1;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 7:
                        TempListViewClickedValue = "Borowik płowy Boletus impolitus".toString();
                        TempListViewClickedValue2 = "Owocnik 5-20 cm średnicy, za młodu półkolisty, potem wypukły, później poduszkowato spłaszczony, zamszowojedwabisty i lekko ziarnisto kropkowany. później gładki, nielepki. Rzadko z szerokim garbkiem i często spłaszczony w środku. Młody barwy bladoochrowej lub jasnoskórzastej, brzeg niekiedy brunatny. \n" +
                                "\n" +
                                "Rurki 15-30mm długie, przy trzonie wycięte, młode cytrynowożółte, u starszych okazów z zielonkawym lub oliwkowym odcieniem. Uciśnione nie zmieniają zabarwienia. \n" +
                                "\n" +
                                "Pory kanciasto-okrągłe, zabarwione podobnie jak rurki i podobnie jak one nie zmieniają zabarwienia przy uciśnięciu. \n" +
                                "\n" +
                                "Trzon 5-18cm długości i 2-8cm gruby, początkowo pękaty i masywny, potem maczugowato wydłużony lub cylindryczny. Początkowo zabarwiony jak kapelusz, później jednak coraz bardziej żółknie: rzadko zabarwiony jednolicie, często tylko z żółtym wierzchołkiem. \n" +
                                "\n" +
                                "Powierzchnia z wyrośniętymi włókienkami, szorstka, z kosmkami lub punktami przy podstawie, lecz bez żyłkowej siateczki. Często również z czerwonymi plamkami, paskami lub kropkami. \n" +
                                "\n" +
                                "Miąższ białawy lub jasnocytrynowy, pod rurkami i na obwodzie trzonu cytrynowy, na powietrzu nie zmienia zabarwienia. W trzonie włóknisty. Smak łagodny, zapach kwaskowaty, często karbolowy. \n" +
                                "\n" +
                                "Występuje rzadko, od lata do jesieni, na ciepłych-świetlistych siedliskach łęgowych i grądowych, lecz również w parkach. Na glebach wapiennych, najczęściej pod dębami i bukami. \n" +
                                "\n" +
                                "Zastosowanie- jadalny. \n".toString();
                        qwe2 = R.drawable.plowybig;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.t1;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 8:
                        TempListViewClickedValue = "Borowik ponury Suillellus luridus".toString();
                        TempListViewClickedValue2 = "Kapelusz 7-23 cm średnicy; koloru żółtopomarańczowego do brudnooliwkowego, ciemniejący przy dotknięciu; podczas wilgotnej pogody lekko lepki; skórki nie można oddziela od miąższu.\n" +
                                "\n" +
                                "Powierzchnia sucha, gładka, często zamszowa. \n" +
                                "\n" +
                                "Rurki żółte do oliwkowozielonawych, z czerwonymi porami (dlatego spód kapelusza ma barwę czerwonawą), na starość niekiedy tracą zabarwienie, przy skaleczeniu błękitnieją, długie, przy trzonie wykrojone. \n" +
                                "\n" +
                                "Trzon wielkości 5-13 na 2-5 cm, w górnej części jasnożółty lub pomarańczowożółty, w dolnej części purpurowy, pokryty wyraźną czerwonobrązową siateczką, której oczka są wyraźnie wyciągnięte wzdłuż trzonu; pod wpływem nacisku przebarwia się, podobnie jak kapelusz; cylindryczny lub w dole wydęty, wewnątrz pełny, podstawa trzonu zaostrzona. \n" +
                                "\n" +
                                "Miąższ jasnożółty, w podstawie trzonu purpurowy, przy podstawie rurek różowy; w miejscu przełamania staje się szarobłękitny z czerwonawym odcieniem; smak łagodny; zapach słaby.\n" +
                                "\n" +
                                "Występuje od czerwca do października, w lasach liściastych i mieszanych, w zaroślach, często w parkach, na glebach gliniastych, bogatych w wapń.\n" +
                                "\n" +
                                "Niedoświadczeni grzybiarze powinni na ogół unikać borowików z czerwonymi porami. \n" +
                                "\n" +
                                "Zastosowanie- jadalny, choć nieczęsto zbierany, spożyty w stanie surowym wykazuje właściwości trujące. \n".toString();
                        qwe = R.drawable.gopichand;
                        qwe2 = R.drawable.ponurybig;
                        list1 = "Borowik ceglastopory Boletus erythropus,".toString();
                        list2 = "ma czerwonokosmkowaty trzon bez siateczki;";
                        list13 = "odróżnia się tylko słabo błękitniejącym miąższem i białawym kapeluszem. ";
                        list3 = "Borowik szatański Rubroboletus satanas,";
                        qwe3 = R.drawable.szatanski;
                        jedzenie = R.drawable.niejadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t1;
                        jadalnosc.setImageResource(R.drawable.niejadalny);
                        break;
                    case 9:
                        TempListViewClickedValue = "Borowik purpurowy Boletus rhodoxanthus".toString();
                        TempListViewClickedValue3 = "Gatunek objęty ochroną ścisłą w Polsce, także w Austrii, Anglii, Belgii, Niemczech, Czechach, Norwegii, Holandii, Słowacji!".toString();
                        TempListViewClickedValue2 = "Owocnik 7-20cm średnicy, u młodych osobników półkolisty, później poduchowato wypukły, starszy płasko rozpostarty, spłaszczony, matowy. Białawobrunatnoszarawy z czasem także brudnobrązowożółty lecz od brzegów przebarwiający się na czerwonawo. Nagi lub lekko zamszowy. Przeważnie nieco lepki dający się ugniatać. \n" +
                                "\n" +
                                "Rurki 15-25mm długie, przy trzonie wygięte, początkowo żółte, później żółtawozielone. na przecięciu błękitnieją. \n" +
                                "\n" +
                                "Pory drobne, młode cytrynowożółtawe, potem szybko stają się czerwone, przy brzegu kapelusza troszkę jaśniejsze. \n" +
                                "\n" +
                                "Trzon 6-12cm wysokości i 3-5cm grubości, za młodu pękaty brzuchowatobulwiasty, później mniej więcej walcowaty: przy tym podstawa może być nieco zaostrzona. W górnej części żółty, w dolnej krwisty, pokryty na całej powierzchni czerwoną lub purpurowokrwistą siateczką o drobnych, później wzdłużnych oczkach lekko wypukłych, z drobnymi punkcikami. \n" +
                                "\n" +
                                "Miąższ w kapeluszu twardy, w trzonie miękki. Żywocytrynowożółty, ponad rurkami i w trzonie bardziej żółty, lekko błękitniejący. Po pewnym czasie jaśnieje i staje się szarożółtawy. Smak słaby, zapach łagodny. \n" +
                                "\n" +
                                "Występuje rzadko, od lata do jesieni w ciepłych świetlistych lasach liściastych, szczególnie pod dębami i bukami, na glebach wapiennych. \n" +
                                "\n" +
                                "Zastosowanie- niejadalny- trujący przynajmniej w stanie surowym. \n".toString();
                        qwe = R.drawable.rudopur;
                        qwe2 = R.drawable.purpurowybig;
                        list1 = "Borowik rudopurpurowy Boletus rhodopurpureus, ".toString();
                        list2 = "miąsz przebawia się intensywniej, kapelusz mięsistoczerwony;";
                        list13 = "barwy popielatoszarej lub szarosiwej z zielonkawym odcieniem, często czerwonawymi plamkami, na brzegu żółtawy.";
                        list3 = "Borowik wilczy Boletus lupinus,";
                        qwe3 = R.drawable.wilczy;
                        jedzenie = R.drawable.niejadalny;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.t1;
                        jadalnosc.setImageResource(R.drawable.niejadalny);
                        break;
                    case 10:
                        TempListViewClickedValue = "Borowik sosnowy Boletus pinicola".toString();
                        TempListViewClickedValue2 = "Owocnik do 30 cm średnicy, ciemnoczerwonobrązowy , winnoczerwonawy, wypukły, matowy; w czasie deszczu lepki. \n" +
                                "\n" +
                                "Rurki początkowo blade, potem żółtawe, długie; pory początkowo białawe, później żółte, wreszcie oliwkowożółte. \n" +
                                "\n" +
                                "Trzon najpierw białawy, potem żółtobrązowy, czerwonobrązowawy lub winnoczerwonawy, masywny, zgrubiały, z silnie wykształconą siateczką. \n" +
                                "\n" +
                                "Miąższ u młodych okazów biały, z winnoczerwoną strefą pod skórką, potem śmietankowobiaławy, ze słabym żółtym odcieniem, ściślejszy niż u innych borowików, a ponadto przy nacięciu wydziela nieprzyjemny zapach. Ze względu na wyjątkowo ścisły miąższ, borowik sosnowy jest bardzo wydajnym grzybem jadalnym, ma miły smak. \n" +
                                "\n" +
                                "Występowanie od maja do października, rośnie w lasach iglastych, zwłaszcza pod sosnami, lecz także pod świerkami, nieczęsty. Borowik sosnowy spotykany bywa też w lasach liściastych. \n" +
                                "\n" +
                                "Zastosowanie - bardzo dobry grzyb jadalny.\n".toString();
                        qwe = R.drawable.ciemnobraz;
                        qwe2 = R.drawable.sosnowybig;
                        list1 = "Borowik ciemnobrązowy Boletus cereus,".toString();
                        list2 = "rośnie pod dębami i jest grzybem ciepłolubnym;";
                        list13 = "jaśniejszy, jasno lub ciemnobrązowy kapelusz.";
                        list3 = "Borowik szlachetny Boletus edulis,";
                        qwe3 = R.drawable.szlachetny;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t1;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 11:
                        TempListViewClickedValue = "Borowik szlachetny Boletus edulis".toString();
                        TempListViewClickedValue2 = "Owocnik 6-25 cm średnicy; u młodych owocników białawy, potem piaskowy, jasnobrązowy do ciemnobrązowego, czasem z odcieniem karminowym; najpierw półkulisty, później wypukły, poduchowaty; skórka kapelusza sucha, gładka, matowa, nie oddziela się od miąższu.\n" +
                                "\n" +
                                "Powierzchnia gładka lub pomarszczona; podczas wilgotnej pogody i u starych egzemplarzy jest lepka. \n" +
                                "\n" +
                                "Rurki 8-30 mm długości; u młodych owocników białe, natomiast u starszych żółtawooliwkowe, żółtozielone, oliwkowozielone; wolne lub zatokowato wcięte; pory drobne, okrągławe, po uszkodzeniu nie przebarwiają się. \n" +
                                "\n" +
                                "Trzon 5-20 cm wysokości, 1,5-10 cm grubości; białawy, szarobiaławy, piaskowy, z delikatną białawą lub jasnobrązową siateczką, u podstawy biały, filcowaty; u młodych egzemplarzy trzon zazwyczaj jest pękaty,  potem maczugowaty, pełny. \n" +
                                "\n" +
                                "Miąższ biały, niezmienny, jędrny, twardy, mięsisty, u starych okazów gąbczasty; smak łagodny, grzybowy, przyjemny (orzechowy); zapach suszu charakterystyczny, przyjemny; zapach grzybowy. \n" +
                                "\n" +
                                "Występowanie od czerwca do listopada; w lasach iglastych, mieszanych i liściastych; najobficiej w górskich drzewostanach świerkowych; tworzy mikoryzę ze świerkami, sosnami i bukami; pojedynczo lub w niewielkich grupach;w miejscach świetlistych i na skraju lasu; dawniej pospolity, teraz coraz rzadszy.\n" +
                                "\n" +
                                "Zastosowanie- jadalny\n".toString();
                        qwe = R.drawable.ciemnobraz;
                        qwe2 = R.drawable.szlachetnybig;
                        list1 = "Borowik ciemnobrązowy Boletus aereus,".toString();
                        list2 = "ciemniejszy kapelusz;";
                        list13 = "ma popękaną skórkę kapelusza i ciemniejszy trzon z wyraźniejszą siatką, najczęściej znaleźć go można pod dębami i bukami;";
                        list3 = "Borowik usiatkowany Boletus reticulatus,";
                        qwe3 = R.drawable.usiatkowany;
                        list14 = "wyróżnia się zarówno kapeluszem, jak i trzonem o barwie czerwonobrązowej. Najczęściej znaleźć można go pod sosnami.";
                        list4 = "Borowik sosnowy Boletus pinophilus,";
                        qwe4 = R.drawable.sosnowy;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t1;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 12:
                        TempListViewClickedValue = "Borowik usiatkowany Boletus reticulatus".toString();
                        TempListViewClickedValue2 = "Owocnik początkowo półkulisty, potem wypukły do poduszkowatego. Barwy od bladobrązowawego, szarawobrązowawego, ochrowoszarawego. Brzeg w kolorze białawym. \n" +
                                "\n" +
                                "Powierzchnia gładka lub pomarszczona, matowa i zamszowata. \n" +
                                "\n" +
                                "Pory początkowo w kolorze białym lub białoszarym, z czasem zmieniające zabarwienie na żółtozielonkawe. Przy brzegu kapelusza niekiedy różowawe. Drobne i okrągłe.\n" +
                                "\n" +
                                "Rurki takiej samej barwy, z wiekiem przy brzegu kapelusza czerwonawe, łatwo oddzielają się od kapelusza; przy trzonie zatokowato wycięte.\n" +
                                "\n" +
                                "Trzon początkowo bulwiasty z wiekiem do cylindrycznego. Barwy bladoszarej do jasnobrązowawego. Na powierzchni z białawą lub kremową siateczką, która z czasem brązowieje i pokrywa cały lub połowę jego długości. Zazwyczaj jest ona jaśniejsza od barwy całego trzonu. \n" +
                                "\n" +
                                "Miąższ młody biały i zwarty, u starszych egzemplarzy gąbczasty, pod skórką zabarwiony na brązowo; niezmienny; zapach przyjemny; smak łagodny, przyjemny (orzechowy); zapach suszu charakterystyczny, intensywny, przyjemny.\n" +
                                "\n" +
                                "Występuje pojedynczo lub w małych grupach, od maja do końca czerwca, pod dębami i bukami.\n" +
                                "\n" +
                                "Zastosowanie- jadalny i bardzo smaczny.\n".toString();
                        qwe = R.drawable.szlachetny;
                        qwe2 = R.drawable.usiatkowanybig;
                        list1 = "Borowik szlachetny Boletus edulis,".toString();
                        list2 = "stare okazy o rozwartym, ciemnobrązowym kapeluszu;";
                        list13 = "rośnie głównie w lasach iglastych i ma bardzo gorzki smak.";
                        list3 = "Goryczak żółciowy Tylopilus felleus,";
                        qwe3 = R.drawable.zolciowy;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.t1;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 13:
                        TempListViewClickedValue = "Borowik zajęczy Xerocomus subtomentosus"+"\n"+"jako Podgrzybek zajączek".toString();
                        TempListViewClickedValue2 = "Kapelusz o średnicy 3-10 cm, u młodych egzemplarzy półkolisty u starszych egzemplarzy bardziej rozpłaszczony. Brzeg długo podwinięty. Skórka aksamitna lub pilśniowa, matowa i niedająca się ściągnąć. Podczas suchej pogody popękana jest na poletka. Kolor najczęściej oliwkowobrązowy, czasami żółtobrązowy lub siwobrązowy.\n" +
                                "\n" +
                                "Rurki 5-20 mm długości, żółte ciemnieją z wiekiem do zielonożółtych i oliwkowobrązowych początkowo przyrośniete i lekko zbiegające potem wolne. Pory duże kanciaste, nieregularne jasnożółte potem zielonkawożółte, uszkodzone nie zmieniają koloru, u starszych owocników mogą poszarzeć.\n" +
                                "\n" +
                                "Trzon wysokości 6-10 cm, grubości 1-2 cm, smukły, cylindryczny, pełny, zwężony u dołu, górą karbowany. Kolor od żółtego do czerwonobrązowego. Mogą występować podłużne, ciemniejsze pręgi lub siateczka o bardzo wydłużonych oczkach.\n" +
                                "\n" +
                                "Miąższ biały lub kremowy z żółtym odcieniem, w kapeluszu miękki i mięsisty, w trzonie włóknisty i twardy. Po przecięciu nie zmienia koloru.\n" +
                                "\n" +
                                "Rośnie w lasach iglastych i liściastych, parkach, na ziemi pod świerkiem pospolitym, limbą i dębem szkarłatnym.\n" +
                                "\n" +
                                " Zastosowanie - grzyb jadalny.\n".toString();
                        qwe = R.drawable.zlotopor;
                        qwe2 = R.drawable.zajeczybig;
                        list1 = "Borowik złotopory Xerocomellus chrysenteron,".toString();
                        list2 = "ma bardziej popękany kapelusz, jaśniejsze pory i trzon o czerwonawym odcieniu;";
                        list13 = "o oliwkowobrązowym kapeluszu, ";
                        list3 = "Borowik żeberkowany Boletus ferrugineus,";
                        qwe3 = R.drawable.zebrakowa;
                        list14 = "jego pory sinieją po ugnieceniu.";
                        list4 = "Borowik oprószony Xerocomellus pruinatus,";
                        qwe4 = R.drawable.opruszony;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t1;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 14:
                        TempListViewClickedValue = "Borowik złotawy Xerocomus chrysenteron"+"\n"+"jako Podgrzybek złotawy\n".toString();
                        TempListViewClickedValue2 = "Owocnik średnicy 3-7 cm, szarooliwkowy lub brązowooliwkowy, skórka sucha, matowa, zamszowata, u starszych popękana na drobne poletka, zwłaszcza na brzegu kapelusza, a powstałe rysy barwy cielistej z odcieniem różowym, poduszkowato wypukły. \n" +
                                "\n" +
                                "Pory jasnożółte, długości 5-10 mm, zwykle przyrośnięte do zbiegających. \n" +
                                "\n" +
                                "Rurki u młodych owocników kremowożółte, u starych zielonkawe, ciemnooliwkowe, uszkodzone zabarwiają się na zielononiebiesko, przyrosniete do trzonu. \n" +
                                "\n" +
                                "Trzon żółtawy, zwykle z czerwonymi smugami, zwłaszcza u podstawy 50-100 na 10-15 mm, równogruby, czasem wygięty, długi i wysmukły, podstawa przeważnie nieco zwężona, powierzchnia sucha, gładka lub wzdłużnie rowkowana, podstawa z białawo-żółtawą grzybnią. \n" +
                                "\n" +
                                "Miąższ żółtobiaławy, jasnożółty, pod skórką kapelusza czerwony, niezmienny lub słabo błękitniejący, w trzonie włóknisty, w kapeluszu gruby, miękki. Zapach słaby, smak łagodny, lekko kwaskowaty. \n" +
                                "\n" +
                                "Owocniki wyrastają od lata do jesieni, pojedynczo i w grupach, nieraz masowo, w lasach iglastych i liściastych, \n" +
                                "\n" +
                                "Zastosowanie- jadalny, o średniej jakości. \n".toString();
                        qwe = R.drawable.obcietozar;
                        qwe2 = R.drawable.zlotawybig;
                        list1 = "Borowik obciętozarodnikowy Xerocomus porosporus,".toString();
                        list2 = "rośnie głównie pod dębami;";
                        list13 = "za młodu czerwonej barwy jednak szybko blakną i mogą wtedy przypominać inne gatunki podgrzybków;";
                        list3 = "Borowik czerwonawy Xerocomus rubellus,";
                        qwe3 = R.drawable.czerwonawypod;
                        list14 = "ma raczej nie pękającą na poletka powierzchnią kapelusza;";
                        list4 = "Borowik opruszony Xerocomus pruinatus,";
                        qwe4 = R.drawable.opruszony;
                        list15 = "ma oliwkowożólty kapelusz, a pory są jaskrawo złotożółte.";
                        list5 = "Borowik zajęczy Xerocomus subtomentosus,";
                        qwe5 = R.drawable.zajeczy;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t1;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 15:
                        TempListViewClickedValue = "Borowik żółtobrązowy Boletus appendiculatus".toString();
                        TempListViewClickedValue3 = "Gatunek objęty ochroną częściową w Polsce!".toString();
                        TempListViewClickedValue2 = "Owocnik żółtobrązowy, czerwonobrązowy do jasnobrązowego, uciśnięte miejsca ciemnieją, 7-20cm mm średnicy, półkulisty, potem wypukły, w końcu spłaszczony. Brzeg początkowo podwinięty, ostry i skórka nieco wystająca poza rurki.\n" +
                                "\n" +
                                "Powierzchnia z wrośniętymi delikatnymi włókienkami, matowa, aksamitna lub naga, zamszowa z wiekiem może być popękana. \n" +
                                "\n" +
                                "Pory cytrynowożółte, z wiekiem jasnożółte, oliwkowożółte i brązowiejące uszkodzone przebarwiają się zielonobłękitnie, drobne, kanciaste. \n" +
                                "\n" +
                                "Rurki tej samej barwy, uszkodzone natychmiast błękitnieją, przy trzonie wycięte. \n" +
                                "\n" +
                                "Trzon złotożóły, uciśnięte miejsca ciemnieją, z delikatną żółą lub brązowawą siateczką widoczną zwłaszcza w górnej połowie z wiekiem zanikającą, z wiekiem cylindryczny, u podstawy silnie zwężony. \n" +
                                "\n" +
                                "Miąższ w kapeluszu białawy do jasnożółtego, słabo błękitniejący, zwłaszcza ponad rurkami. W trzonie żółty, w podstawie trzonu brązowawy. Zapach słaby, smak łagodny, przyjemny. \n" +
                                "\n" +
                                "Dość rzadki. Owocniki wyrastają od lata do jesieni, pojedynczo lub w grupach, gatunek ciepłolubny, głównie w lasach liściastych najczęściej pod bukami i dębami, czasami w iglastych, preferuje gleby wapienne. \n" +
                                "\n" +
                                "Zastosowanie- jadalny. \n".toString();
                        qwe = R.drawable.gorski;
                        qwe2 = R.drawable.zoltobrazowybig;
                        list1 = "Borowik górski Boletus subappendiculatus,".toString();
                        list2 = "rośnie w górskich lasach.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t1;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 16:
                        TempListViewClickedValue = "Bruzdniczek największy Clitopilus prunulus".toString();
                        TempListViewClickedValue2 = "Kapelusz o średnicy 3-6 cm, czysto biały lub z szarym odcieniem, o powierzchni matowej, biało oprószonej i o brzegu podwiniętym (zwłaszcza u młodych okazów). \n" +
                                "\n" +
                                "Blaszki początkowo białe, po dojrzeniu różowiejące, wąskie, gęsto ustawione, zbiegające na trzon. \n" +
                                "\n" +
                                "Trzon barwy kapelusza, od dołu ku górze rozszerzający się, wielkości 3-6 na 0,7-2 cm, na powierzchni lekko oprószony, czasem bywa umieszczony asymetrycznie. \n" +
                                "\n" +
                                "Miąższ biały, miękki, niezmienny, o smaku łagodnym i silnym, mącznym zapachu. \n" +
                                "\n" +
                                "Zarodniki szeroko wrzecionowate, o jednej lub kilku podłużych zmarszczkach na powierzchni. \n" +
                                "\n" +
                                "Dość częsty, wyrastający latem i jesienią w lasach liściastych i iglastych, czasem na łąkach śródleśnych. \n" +
                                "\n" +
                                "Zastosowanie - dobry grzyb jadalny. \n".toString();
                        qwe = R.drawable.lisciowa;
                        qwe2 = R.drawable.najwiekszybruzbig;
                        list1 = "Lejkówka liściowa Clitocybe phyllophila,".toString();
                        list2 = "blaszki nie różowieją.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t7;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 17:
                        TempListViewClickedValue = "Buławka obcięta Clavariadelphus truncatus".toString();
                        TempListViewClickedValue3 = "Gatunek objęty ochroną częściową w Polsce!".toString();
                        TempListViewClickedValue2 = "Owocnik o wysokości do 15 cm maczugowaty ucięty na szczycie żółtawy, ochrowy, cynamonowy, czasem z czerwonawym odcieniem gładki lub ze słabo widocznymi, pionowymi bruzdami \n" +
                                "\n" +
                                "Miąższ białawy, pod skórką żółtawy po przecięciu zmieniający się na szary lub brązowawy, smak i zapach słaby, przyjemny. \n" +
                                "\n" +
                                "Występuje latem i jesienią w borach iglastych, w Polsce rzadki .\n" +
                                "\n" +
                                "Zastosowanie- jadalna. \n".toString();
                        qwe = R.drawable.paleczkowata;
                        qwe2 = R.drawable.obcietabig;
                        list1 = "Buławka pałeczkowata Clavariadelphus pistillaris,".toString();
                        list2 = "z nieco większymi owocnikami;";
                        list13 = "ma podobny pokrój.";
                        list3 = "Siatkolist maczugowaty Gomphus clavatus,";
                        qwe3 = R.drawable.maczugowaty;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t5;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 18:
                        TempListViewClickedValue = "Czasznica olbrzymia Langermannia gigantea"+"\n"+"jako Purchawica olbrzymia".toString();
                        TempListViewClickedValue2 = "Owocnik kulisty nieco spłaszczony, bardzo duży, do 100-600 mm średnicy, biały, osłona zewnętrzna cienka, młode owocniki białe, z wiekiem jasnoochrowe do jasnobrązowego, osłona wewnętrzna cienka, papierowata, biała, z wiekiem ciemnieje, szarożółtawe do brudnobrązowego. \n" +
                                "\n" +
                                "Gleba zwarta, gąbczasta, początkowo biała, w miarę dojrzewania, szarożółta do brązowooliwkowej. Osłona pęka nieregularnie w wielu miejscach, na duże płaty i częściowo złuszcza się, w dolnej części owocnika słabo rozwinięte ściślejsze podglebie, nie wyróżniające się, stopniowo przechodzące w glebę. \n" +
                                "\n" +
                                "Dojrzały owocnik rozpada się na kawałki, a gleba na kłaczkowaty proszek. \n" +
                                "\n" +
                                "Trzon korzeniasty, dość cienki, z białym sznurem grzybni zagłębionym w podłożu. \n" +
                                "\n" +
                                "Średnio częsta. Owocniki wyrastają od lata do jesieni, pojedynczo lub po kilka, w miejscach żyznych, na trawnikach, w parkach, ogrodach, zaroślach. \n" +
                                "\n" +
                                "Zastosowanie- młode owocniki jadalne.\n".toString();
                       qwe2 = R.drawable.czasznicabig;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.laka;
                        typgrzyb = R.drawable.def4;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 19:
                        TempListViewClickedValue = "Czernidłak błyszczący Coprinus micaceus".toString();
                        TempListViewClickedValue2 = "Kapelusz o średnicy 2 do 4 cm. Dzwonkowaty, wyraźnie prążkowany. Z czasem bardziej rozpostarty. U młodych egzemplarzy brzeg podwinięty w dół, u najstarszych może wywijać się ku górze i pękać wzdłuż prążkowania. Kolor brązowawy, z odcieniami pomarańczu. Młode owocniki mają na sobie błyszczące, ziarenkowate resztki osłony. Z wiekiem kapelusz rozpływa się od brzegów w gęstą, czarną maź.\n" +
                                "\n" +
                                "Blaszki gęste. U młodych egzemplarzy jasne, z czasem ciemnieją aż do czerni. W końcu rozpływają się.\n" +
                                "\n" +
                                "Trzon centralny, cylindryczny. Gdy długi, często wygięty. cienki, długości do 10cm. Jasny i pusty w środku. Gładki.\n" +
                                "\n" +
                                "Miąższ kruchy i delikatny. U młodych owocników jasny, u starszych czernieje i rozpływa się.\n" +
                                "\n" +
                                "Występuje od maja do listopada.  Pospolity w lasach, parkach, ogrodach. Rośnie gromadnie w dużych kępach, często jedna obok drugiej.\n" +
                                "\n" +
                                "Zastosowanie - dopóki jasny, jest jadalny.\n".toString();
                        qwe = R.drawable.podw;
                        qwe2 = R.drawable.czernidlaczekbig;
                        list1 = "Czernidłak podwórzowy Coprinellus disseminatus,".toString();
                        list2 = "na kapeluszu nie posiada błyszczących ziarenek, lecz kosmki lub drobne łuski, będące resztkami osłony. Rośnie na gnijących pniach drzew;";
                        list13 = "ma matową powierzchnię i ostrza blaszek nie są białe;";
                        list3 = "Czernidłaczek kanciastozarodnikowy Coprinellus angulatus, ";
                        qwe3 = R.drawable.kanciastozarod;
                        list14 = "ma podobnie czerniejce blaszki, ale kapelusz bez promienistego pomarszczenia.";
                        list4 = "Kruchaweczka zaroślowa Psathyrella candolleana, ";
                        qwe4 = R.drawable.zaroslowa;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t9;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 20:
                        TempListViewClickedValue = "Czernidłak pospolity Coprinopsis atramentaria".toString();
                        TempListViewClickedValue2 = "Owocnik 3-6 cm średnicy; występują grupami po kilka, kilkanaście lub nawet kilkadziesiąt sztuk; jest średniej wielkości; w młodym wieku ma kształt jajowaty i barwę szarobiałą; starsze owocniki mają kapelusz kształtu dzwonkowatego, z poszarpanymi brzegami, na jego czubku występują delikatne, trochę ciemniejsze, brązowawe kosmyki; stopniowo ciemnie, najpierw staje się szarobrązowy, potem rozpływa się w czarną masę.\n" +
                                "\n" +
                                "Trzon długości 6-12 cm, biały, z obrączkowatym nabrzmieniem u dołu, wewnątrz pusty.\n" +
                                "\n" +
                                "Blaszki najpierw białe, potem szarobrązowe, wreszcie czarne.\n" +
                                "\n" +
                                "Miąższ pod blaszkami bardzo cienki.\n" +
                                "\n" +
                                "Pospolity, najczęściej na żyznych gruntach poza lasem, a więc koło gnojówek, inspektów, nasypów kompostowych, na trawnikach, pastwiskach, na brzegach lasu, od czerwca do października.\n" +
                                "\n" +
                                "Zastosowanie – niejadalny, z alkoholem trujący.\n".toString();
                        qwe2 = R.drawable.czernidlakbig;
                        jedzenie = R.drawable.niejadalny;
                        lasy = R.drawable.laka;
                        typgrzyb = R.drawable.t9;
                        jadalnosc.setImageResource(R.drawable.niejadalny);
                        break;
                    case 21:
                        TempListViewClickedValue = "Czernidłak pstry Coprinopsis picacea".toString();
                        TempListViewClickedValue2 = "Kapelusz owalny do dzwonkowatego, duży, do 9 cm wysokości i 6 cm średnicy; początkowo o jednolicie białej powierzchni, która z czasem rozrywa się w białe płatki odcinające się od czarnego, drobnoprążkowanego tła. \n" +
                                "\n" +
                                "Trzon 24 cm długości i 1,4 cm średnicy, cylindryczny, nieznacznie zwężający się, pusty w środku, biały, gładki lub delikatnie oprószony na powierzchni, w dolnej części mogą występować białe, odstające kosmki. \n" +
                                "\n" +
                                "Blaszki wolne, bardzo gęste, początkowo białoróżowe, z czasem stają się czarne i po dojrzeniu rozpływają się. \n" +
                                "\n" +
                                "Miąższ w kapeluszu bardzo cienki, kruchy, wodnisty, w trzonie trochę włóknisty, o niezbyt przyjemnym, słabym zapachu, smak łagodny. \n" +
                                "\n" +
                                "Wyrasta na liściastej ściółce; można go spotkać póżną jesienią, najczęściej pojedynczo, rzadziej w grupach.\n" +
                                "\n" +
                                "Zastosowanie - niejadalny. \n".toString();
                        qwe = R.drawable.szarawyczerni;
                        qwe2 = R.drawable.pstrybig;
                        list1 = "Czernidłak szarawy Coprinopsis cinerea,".toString();
                        list2 = "o mniejszym kapeluszu, zakorzeniającym się trzonie.";
                        jedzenie = R.drawable.niejadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t9;
                        jadalnosc.setImageResource(R.drawable.niejadalny);
                        break;
                    case 22:
                        TempListViewClickedValue = "Czubajeczka brązowoczerwonawa Lepiota brunneoincarnata".toString();
                        TempListViewClickedValue2 = "Kapelusz o średnicy 2-5cm, początkowo półkulisty, potem łukowaty do płaskiego, z tępym wybrzuszeniem. Barwy bladoróżowej z brązowymi, czerwonobrązowymi lub fioletowobrązowymi łuseczkami.\n" +
                                "\n" +
                                "Blaszki przy trzonie wolne, bladokremowe.\n" +
                                "\n" +
                                "Trzon białawy, u podstawy przebarwiony winnoczerwono, w połowie z fragmentami osłony barwy kapelusza i podobnie zabarwionymi łuseczkami i włókienkami, równogruby.\n" +
                                "\n" +
                                "Pierścień brązowawy, z wiekiem zanikający.\n" +
                                "\n" +
                                "Miąższ biały, zapach owocowy.\n" +
                                "\n" +
                                "Zastosowanie- śmiertelnie trująca !\n" +
                                "\n" +
                                "Występuje rzadko, w miejscach bogatych w resztki organiczne bogate w humus, wśród roślinności zielnej, na łąkach i obrzeżach lasów.\n".toString();
                        qwe = R.drawable.brazowofioletowa;
                        qwe2 = R.drawable.brazowoczerwonabig;
                        list1 = "Czubajeczka brązowofioletowa Lepiota brumneolilacea, ".toString();
                        list2 = "z zielonoszarym pierścieniem, rośnie na glebach piaszczystych.";
                        jedzenie = R.drawable.trujacy;
                        lasy = R.drawable.laka;
                        typgrzyb = R.drawable.t2;
                        jadalnosc.setImageResource(R.drawable.trujacy);
                        break;
                    case 23:
                        TempListViewClickedValue = "Czubajeczka cuchnąca Lepiota cristata".toString();
                        TempListViewClickedValue2 = "Kapelusz białawy kremowy z rdzawobrązowym gładkim wierzchołkiem i rdzawobrązowymi, nieregularnie rozmieszczonymi łuseczkami na pozostałej powierzchni kapelusza; 20-40 mm średnicy, początkowo stożkowaty, potem wypukły do płaskiego z płaskim garbkiem; brzeg ostry, długo podwinięty, czasem popękany.\n" +
                                "\n" +
                                "Trzon cylindryczny, smukły, 30-45 na 2-4 mm, z rozszerzoną podstawą, pusty, kruchy; powierzchnia gładka, naga; białawy z wiekiem z różowym lub czerwonym tonem; pierścień błoniasty, wzniesiony, delikatny, zanikający.\n" +
                                "\n" +
                                "Bardzo pospolita. Owocniki wyrastają pojedynczo lub gromadnie od sierpnia do października w różnego rodzaju lasach i na obrzeżach, zwłaszcza na poboczach dróg.\n" +
                                "\n" +
                                "Zastosowanie- trująca, ale lekko.\n".toString();
                        qwe = R.drawable.tarczowata;
                        qwe2 = R.drawable.cuchnacabig;
                        list1 = "Czubajeczka tarczowata Lepiota clypeolaria,".toString();
                        list2 = "włóknistą strukturę na trzonie.";
                        jedzenie = R.drawable.trujacy;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t2;
                        jadalnosc.setImageResource(R.drawable.trujacy);
                        break;
                    case 24:
                        TempListViewClickedValue = "Czubajka czerwieniejąca Chlorophyllum rachodes".toString();
                        TempListViewClickedValue2 = "Kapelusz 15-25 średnicy, początkowo półkolisty, potem łukowaty, w końcu płaski- duży i masywny. Barwa podłoża brązowawa do białawego, która jest pokryta kontrastowo ciemnobrązowymi łuseczkami. Wierzchołek gładki i matowy. Przy brzegu delikatnie włóknistołuskowaty. Brzeg tępy.\n" +
                                "\n" +
                                "Blaszki białawe potem kremowe, gęste, uciśnięte brązowieją.\n" +
                                "\n" +
                                "Trzon masywny, gruby i walcowaty, przy podstawie bulwiasto rozszerzony nawet do 5cm średnicy. Początkowo mięsisty z wiekiem pusty, uszkodzony brązowieje.\n" +
                                "\n" +
                                "Pierścień białawy, błoniasty, duży i ruchomy.\n" +
                                "\n" +
                                "Miąższ biały, przebarwiający się różowo-winno, brak wyraźnego smaku, zapach surowych ziemniaków.\n" +
                                "\n" +
                                "Zastosowanie- niejadalna, trująca !\n" +
                                "\n" +
                                "Występuje na terenach bogatych w humus na przydomowych ogródkowych kompostownikach, w parkach.\n".toString();
                        qwe = R.drawable.zolknaca;
                        qwe2 = R.drawable.czerwieniejacaczubbig;
                        list1 = "Czubajka żółknąca Leucoagaricus nympharum,".toString();
                        list2 = "bardziej wysmukłym i delikatnym owocniku pokrytym białymi łuseczkami. Różni się też miąższem, który jest biały i po uszkodzeniu lekko czerwienieje;";
                        list13 = "ma trzon z zygzakowatym wzorem i jej miąższ nie zmienia barwy po uszkodzeniu, a łuski na kapeluszu nie są tak odstające;";
                        list3 = "Czubajka kania Macrolepiota procera,";
                        qwe3 = R.drawable.kania;
                        list14 = "jest mniejsza, jej kapelusz na środku nie jest postrzępiony, łuski są przylegające, powierzchnia trzonu jest jasnobrązowa i pokryta drobnymi łuseczkami.";
                        list4 = "Czubajka gwiaździsta Macrolepiota konradii, ";
                        qwe4 = R.drawable.gwiezdzista;
                        jedzenie = R.drawable.trujacy;
                        lasy = R.drawable.laka;
                        typgrzyb = R.drawable.t2;
                        jadalnosc.setImageResource(R.drawable.trujacy);
                        break;
                    case 25:
                        TempListViewClickedValue = "Czubajka kania Macrolepiota procera".toString();
                        TempListViewClickedValue2 = "Kapelusz o średnicy 10-35cm , u młodych owocników kulisty, jajowaty, potem wypukły, u dojrzałych płaski z garbkiem na szczycie, parasolowaty. Młody brązowy, później jasnobrązowy,szarobrązowy, kremowy, białawy; garbek gładki, ciemnobrązowy; brzeg białawy, włókienkowaty \n" +
                                "\n" +
                                "Powierzchnia sucha, popękana, pokryta brązowymi, grubymi, odstającymi, dachówkowatymi łuskami, pomiędzy którymi prześwituje jaśniejsza skórka.\n" +
                                "\n" +
                                "Blaszki białawe, kremowe, wolne, gęste\n" +
                                "\n" +
                                "Trzon wysokości 15-50 cm, grubości 1-2,5 cm barwy kapelusza, z ciemniejszymi łuskami tworzącymi zygzakowaty deseń na jaśniejszym tle ,wysmukły, cylindryczny, bulwiasta podstawa grubości około 5 cm. Kremowy, podwójny, ruchomy pierścień,  początkowo wewnątrz gąbczasty, później pusty, łatwo odłamuje się od kapelusza.\n" +
                                "\n" +
                                "Miąższ biały, niezmienny. W kapeluszu miękki, gąbczasty. W trzonie łykowaty, włóknisty, zdrewniały. Rzadko zasiedlany przez owady. Smak orzechowy, zapach: miły grzybowy.\n" +
                                "\n" +
                                "Występuje od czerwca do listopada, w świetlistych lasach różnych typów, na skraju lasu, przy drogach leśnych, w zaroślach, na wrzosowiskach, zrębach, na łąkach i pastwiskach najczęściej pojedynczo lub po kilka sztuk , dość pospolity.\n" +
                                "\n" +
                                "Zastosowanie - grzyb jadalny, do spożycia nadają się tylko kapelusze.\n".toString();
                        qwe = R.drawable.plamisty;
                        qwe2 = R.drawable.kaniabig;
                        list1 = "Muchomor plamisty Amanita pantherina,".toString();
                        list2 = "śmiertelnie trujący, ma szarą barwę jak kania. Ma jednak bardziej przysadzisty trzon,  a pierścień nie jest ruchomy. Kropki ma jaśniejsze niż tło;";
                        list13 = "różni się brakiem łusek na trzonie, a jej miąższ czerwienieje po uszkodzeniu.";
                        list3 = "Czubajka czerwieniejąca Chlorophyllum rhacodes,";
                        qwe3 = R.drawable.czerwieniejacaczub;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.laka;
                        typgrzyb = R.drawable.t2;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 26:
                        TempListViewClickedValue = "Długotrzonka popielata Helvella macropus".toString();
                        TempListViewClickedValue2 = "Owocnik 2-4 cm średnicy; miseczkowaty, początkowo kulisty, z wiekiem szerzej rozpostarty, miseczkowaty, wklęsły, wewnętrzna część zarodnikonośna jest czarnoszara, szarobrązowa, gładka, natomiast zewnętrzna - jasna, szarobiała, krótko owłosina.\n" +
                                "\n" +
                                "Trzon białoszary, 30-50 na 2-4 mm, nieregularnie spłaszczony lub cylindryczny, z wiekiem pusty. \n" +
                                "\n" +
                                "Miąższ wodnisty, cienki, białawy do szarego, cienki, bez smaku i zapachu \n" +
                                "\n" +
                                "Występuje pospolicie, od lata do późnej jesieni, na wilgotnych terenach, wśród traw lub mchów, w lasach liściastych oraz w zaroślach, w grupach.\n" +
                                "\n" +
                                "Zastosowanie - jadalny.\n".toString();
                        qwe = R.drawable.gietka;
                        qwe2 = R.drawable.dlpopielatabig;
                        list1 = "Siodłówka giętka Helvella elastica,".toString();
                        list2 = "gładka szarobeżowa do żółtawobrązowawej, wewnętrzna jaśniejsza.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.t4;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 27:
                        TempListViewClickedValue = "Dwupierścieniak cesarski Catathelasma imperiale".toString();
                        TempListViewClickedValue3 = "Gatunek objęty ochroną ścisłą w Polsce, Austrii, Belgii, Niemczech, Estonii, Szwecji, Finlandii, Słowacji, Czechach!".toString();
                        TempListViewClickedValue2 = "Kapelusz o średnicy 5-16 cm; początkowo półkuliscie wypukły, póżniej rozpostarty i spłaszczony, rzadko lejkowty, na brzegach faliscie podwinięty; skóra sucha orzechowobrunatna, czesto pokryta resztkami osłony, u osobników starszych płatowato popękana; brzeg przez dłuższy czas pozostaje charakterystycznie ślimakowo zawinięty.\n" +
                                "\n" +
                                "Blaszki wąskie , gęsto ustawione zbiegaja się w trzon: początkowo białawe, później bladobrązowe z czerniawymi ostrzami. \n" +
                                "\n" +
                                "Trzon mocno zagłębiony w podłożu, w kolorze bladoochrowym, otoczony jest nieco łuskowatymi pasmami, dochodzi do 15 cm wysokości i 3-5 cm grubości, opatrzony jest dwoma skórzastymi pierścieniami, z których górny wywodzi się z osłony częściowej, a dolny z osłony calkowitej; podstawa trzonu zaostrzona . \n" +
                                "\n" +
                                "Miąższ bardzo ścisły, twardy. \n" +
                                "\n" +
                                "Nieczęsty. Owocniki wyrastają jesienią, pojedynczo lub po kilka w grupie, w górach, na glebach wapiennych, na łąkach i halach , w widnych lasach świerkowych . Owocniki są na pół podziemne, stąd zauważalne są dopiero wystające kapelusze dojrzewających egzemplarzy. \n" +
                                "\n" +
                                "Zastowowanie - jadalny.\n".toString();
                        qwe2 = R.drawable.cesarskibig;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.def4;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 28:
                        TempListViewClickedValue = "Dzieżka pomarańczowa Aleuria aurantia".toString();
                       TempListViewClickedValue2 = "Owocnik początkowo prawie kulisty, potem nieregularnie miseczkowaty z wiekiem rozpostarty, brzegiem pofalowany i powyginany z pęknięciami. Wewnętrzna strona bardziej jaskrawo zabarwiona, zewnętrzna bledsza, białawo omączona.  Siedzący bezpośrednio na ziemi, barwy  jaskrawo czarwono-pomarańczowej. Średnicy  2-12cm. Powierzchnia gładka.\n" +
                               "\n" +
                               "Miąższ bardzo cienki, bardzo kruchy, wodnisty. Siwobiały bez szczególnego smaku i zapachu.\n" +
                               "\n" +
                               "Zastosowanie – jadalny.\n" +
                               "\n" +
                               "Średnio pospolity. Stłoczone  w skupiskach   na nagiej, ubitej, wilgotnej ziemi , w miejscach otwartych, nasłonecznionych, przy drogach, w ogrodach, parkach, na brzegach lasów i zarośli. Między trawą i bylinami na trawnikach.\n".toString();
                        qwe = R.drawable.blyszczaca;
                        qwe2 = R.drawable.dzpomaranczowabig;
                        list1 = "Kielonka  błyszcząca Caloscypha fulgens,".toString();
                        list2 = "jest mniejsza i ma brązową  stronę zewnętrzną;";
                        list13 = "jaskrawo czerwona i rośnie na przełomie zimy i wiosny;";
                        list3 = "Czarka austriacka Sarcoscypha austriaca,";
                        qwe3 = R.drawable.austriacka;
                        list14 = "posiada niewielki  trzonek;";
                        list4 = "Dzieżka trzoneczkowata  Aleuria rhenana,";
                        qwe4 = R.drawable.trzoneczkowata;
                        list15 = "rośnie na wypaleniskach, wśród mchów, owocniki krążkowate.";
                        list5 = "Poduszeczka pomarańczowa Pulvinula constellatia,";
                        qwe5 = R.drawable.pomaranpodu;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.laka;
                        typgrzyb = R.drawable.t5;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 29:
                        TempListViewClickedValue = "Dzwonkówka trująca Entoloma sinuatum".toString();
                        TempListViewClickedValue2 = "Owocnik białawy, jasnoochrowy, szaroochrowy, 5-20cm średnicy, początkowo półkulistostożkowaty, z wiekiem wypukły do płaskiego, powierzchnia gładka, jedwabisto lśniąca, brzeg długo podwinięty, ostry. \n" +
                                "\n" +
                                "Blaszki za młodu jasnożółte, później łosiosiowato różowe, szeroko przyrośnięte, wykrojone ząbkiem lub wolne, ostrze faliste. \n" +
                                "\n" +
                                "Trzon biały do żółtoochrawego, równogruby, podstawa rozszerzona, bulwkowata. U góry biało oprószony, kruchy, środek pusty lub gąbczasty. \n" +
                                "\n" +
                                "Miąższ biały, w centrum owocnika gruby, zapach i smak mączny, przyjemny. \n" +
                                "\n" +
                                "Występuje nieczęsto, od lipca do października, pojedynczo i w grupach, w lasach liściastych, zwłaszcza pod bukami i dębami. Preferuje stanowiska wilgotne, na ciężkich glebach gliniastych lub wapiennych. \n" +
                                "\n" +
                                "Zastosowanie - niejadalna silnie trująca.\n".toString();
                        qwe = R.drawable.najwiekszybruz;
                        qwe2 = R.drawable.dzwtrujacabig;
                        list1 = "Bruzdniczek największy Clitopilus prunulus,".toString();
                        list2 = "blaszki różowawe, brzegi zawsze podwinięte;";
                        list13 = "szarawa barwa kapelusza.";
                        list3 = "Gąsówka szarawa Lepista nebularis, ";
                        qwe3 = R.drawable.szarawaga;
                        jedzenie = R.drawable.trujacy;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.trujacy);
                        break;
                    case 30:
                        TempListViewClickedValue = "Galaretek kolczasty Pseudohydnum gelatinosum".toString();
                        TempListViewClickedValue2 = "Owocnik siedzący, bokiem przyczepiony do substratu lub umocowany na krótkim trzonie. Szerokość od 10 do 100 mm. Grubość od 6 do 20 mm. Bywają niekiedy większe. Kształtem językowaty, muszlowaty. Zwykle wyrastające półeczkowato i bywa, że są pozrastane z sobą. Kolor białawy, jasnoszary z sinym odcieniem. Występują również owocniki o zabarwieniu fioletowawobrązowym, ciemnobrązowym. Galaretowaty. \n" +
                                "\n" +
                                "Górna powierzchnia jest drobno ziarnista, brodawkowata lub zamszowato owłosiona. Powierzchnia spodnia to kolczasty hymenofor. Kolce drobne, gęsto rozmieszczone, szpiczasto sterczące. Długości do 3 mm. Barwy biało-opalizującej, z błękitnawoszarą poświatą. \n" +
                                "\n" +
                                "Trzon osadzony ekscentrycznie, bocznie. Długość do 50 mm. W kształcie lekko pofałdowany. Barwy hymenoforu. Masywny. Tworzy jedną całość z owocnikiem. \n" +
                                "\n" +
                                "Miąższ u młodych egzemplarzy koloru mlecznego, później szarzejący, \"przezroczysty\". Galaretowaty i wodnisty. Elastyczny i żelatynowaty. Smak o tonacji lekko rybnej. Wyschnięty chrząstkowaty. Bez zapachu. Stare owocniki mocno nasycone wilgocią mogą się zupełnie rozpływać. \n" +
                                "\n" +
                                "Pospolity. Owocniki wyrastają w przeciągu całego roku, ale najczęściej od lata do jesieni, na silnie rozłożonym drewnie drzew iglastych (najczęściej na starych pniach świerkowych lub sosnowych). Spotykany przeważnie w miejscach wilgotnych i cienistych, od strony północnej pniaka. Porasta zwykle w grupach po kilka okazów. \n" +
                                "\n" +
                                "Zastosowanie – jadalny.\n".toString();
                        qwe = R.drawable.krotkokolczasty;
                        qwe2 = R.drawable.kolczastybig;
                        list1 = "Pierwoząb krótkokolczasty Protodontia subgelatinosa,".toString();
                        list2 = "rosnący na drewnie liściastym;";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.def1;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 31:
                        TempListViewClickedValue = "Koralówka czerwonowierzchołkowa Ramaria botrytis".toString();
                        TempListViewClickedValue3 = "Gatunek objęty ochroną częściową w Polsce!".toString();
                        TempListViewClickedValue2 = "Owocnik wielkości 60 do 150 na 20 do 200 mm. W zarysie kulisty, nieregularny. Rozgałęzienia gałązkowe cieńsze, proste, podłużnie karbowane; końce rozgałęzień krótkie, z 2-4 ząbkami, ostro zakończone, powierzchnia gałązek biaława, kremowa, ochrowa, końce kontrastujące, barwy różowej, fioletowej, z wiekiem brązowawej.\n" +
                                "\n" +
                                "Trzon gruby, krótki, białawy, rozgałęziający się na liczne odnóża.\n" +
                                "\n" +
                                "Miąższ soczysty, wodnisty, kruchy; białawy lub żółtawy; smak łagodny, zapach słaby, przyjemny.\n" +
                                "\n" +
                                "Występuje w lasach liściastych (pod bukami), mieszanych, rzadziej w iglastych ; wyrasta pojedynczo albo w koloniach; rzadki, częściej spotykany na pogórzu. Od lipca do października.\n" +
                                "\n" +
                                "Zastosowanie - jadalny. Smaczny, gdy młody.\n".toString();
                        qwe = R.drawable.lososiowrozowa;
                        qwe2 = R.drawable.groniastybig;
                        list1 = "Koralówka łososioworóżowa Ramaria subbotrytis,".toString();
                        list2 = "ma gałązki różowoochrowe z różowymi zakończeniami, rośnie przeważnie pod dębami;";
                        list13 = "ma białaworóżową podstawę, łososioworóżowe gałązki z żółtymi końcami.";
                        list3 = "Koralówka strojna Ramaria formosa,";
                        qwe3 = R.drawable.strojna;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.def2;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 32:
                        TempListViewClickedValue = "Gąska biaława Tricholoma album".toString();TempListViewClickedValue2 = "\n" +"".toString();
                        TempListViewClickedValue2 = "Owocnik 5-12cm średnicy początkowo dzwonkowaty, potem płasko rozpostarty. Brzeg często pofalowany. Barwy początkowo białawej potem kremowobiaławej, w części środkowej bladoochrowy. \n" +
                                "\n" +
                                "Powierzchnia gładka, sucha, promieniście włóknista. \n" +
                                "\n" +
                                "Blaszki gęste , cienkie, zbiegające na trzon, barwy białawej do kremowej, niekiedy z ciemniejszymi plamkami. \n" +
                                "\n" +
                                "Trzon barwy białawej, gruby, cylindryczny, pełny gładki, przy podstawie zwężony, z ochrowymi plamami. \n" +
                                "\n" +
                                "Miąższ twardy, zwarty, barwy białawej, na powietrzu nie zmieniający barwy. Smak początkowo cierpki potem gorzki. Zapach mącznoziemnisty. \n" +
                                "\n" +
                                "Częsta, w grupach, jesienią w lasach liściastych, pod dębami i brzozami. \n" +
                                "\n" +
                                "Zastosowanie- niejadalna. \n".toString();
                        qwe = R.drawable.jasna;
                        qwe2 = R.drawable.bialawabig;
                        list1 = "Gąska jasna Tricholoma stiparophyllum,".toString();
                        list2 = "jest większa i ma gęste blaszki;";
                        list13 = "nie ma nieprzyjemnego smaku ani zapachu, kapelusz w wilgotnych warunkach jest lepki, blaszki są rzadkie;";
                        list3 = "Gąska gołębia Tricholoma columbetta,";
                        qwe3 = R.drawable.golebia;
                        list14 = "ma nieprzyjemny zapach gazu świetlnego i rośnie w lasach iglastych.";
                        list4 = "Gąska nieprzyjemna Tricholoma inamoenum,";
                        qwe4 = R.drawable.nieprzyjemna;
                        jedzenie = R.drawable.niejadalny;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.niejadalny);
                        break;
                    case 33:
                        TempListViewClickedValue = "Gąska mydlana Tricholoma saponaceum".toString();
                        TempListViewClickedValue2 = "\n" +"".toString();
                        TempListViewClickedValue2 = "Owocnik o średnicy 8-11cm, niezbyt mięsisty, początkowo wypukły stopniowo zmienia się w silnie spłaszczony, o brzegu nieregularnie klapowanym, przez długi czas jeszcze wyraźnie podwiniętym. Barwa skórki zielonożóltawa, brązowawa lub brązowoszara, biała do lekko czerwonej. \n" +
                                "\n" +
                                "Blaszki luźno ustawione, zatokowo przyrośnięte do trzonu, blado zabarwione, bardzo często rdzawobrunatnie poplamione. \n" +
                                "\n" +
                                "Trzon do wysokości 10cm grubości 1,5-3cm może być wybrzuszony i krzywy albo walcowaty barwa podobna do koloru kapelusza ale bledsza, powierzchnia czasami oprószona warstwa drobnych łuseczek, ale bywa i gładki. \n" +
                                "\n" +
                                "Miąższ biały po przecięciu ukazuje czerwonawe plamy. Grzyb ma wyraźny stęchły zapach mydlin. W smaku łagodny lub lekko słodkawy, jednak często gorzki. \n" +
                                "\n" +
                                "Często występująca w lasach iglastych i liściastych. Zwykle na glebach kwaśnych ale nie tylko. Owocniki wyrastają gromadnie od września do listopada. \n" +
                                "\n" +
                                "Zastosowanie - niejadalna, ze względu na nieprzyjemny zapach i smak. \n".toString();
                        qwe = R.drawable.czerwieniejgas;
                        qwe2 = R.drawable.mydlanabig;
                        list1 = "Gąska czerwieniejąca Tricholoma orirubens,".toString();
                        list2 = "owocniki podobne kształtem i barwą. Miąższ ma wyraźny mączny zapach. Blaszki za młodu białawe, po dojrzeniu są różowawe.";
                        jedzenie = R.drawable.niejadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.niejadalny);
                        break;
                    case 34:
                        TempListViewClickedValue = "Gąska niekształtna Tricholoma portentosum".toString();
                        TempListViewClickedValue2 = "Owocnik o średnicy 4-12 cm, ciemnopopielaty, czasem z ochrowym lub brązowym odcieniem, w czasie deszczu nieco lepki, a podczas suchej pogody błyszczący, gładki, od środka ku brzegom pokryty prawie czarnymi, promieniście biegnącymi włókienkami skórka daje się dość łatwo zdejmować, początkowo dzwonkowaty, później szybko staje się płaski z nieznacznym garbkiem. \n" +
                                "\n" +
                                "Blaszki białe lub żółtawozielonkawe, dość grube, zatokowato wycięte lub zbiegające na trzon z nieznacznym ząbkiem, nieco wodniste, gęsto ustawione. \n" +
                                "\n" +
                                "Trzon wielkości 6-12 na 1-3 cm, białawy, czasem z odcieniem żółtawym lub zielonkawym, gładki, prosty lub lekko skręcony. Przy przełamaniu pęka na podłużne włókienka, które skręcają się spiralnie. \n" +
                                "\n" +
                                "Miąższ białawy, niekiedy o odcieniu szarawym, szczególnie wyraźnie pod skórką kapelusza, natomiast na wierzchołku trzonu bywa żółtawy, smak łagodny, zapach mączny. \n" +
                                "\n" +
                                "Występowanie od października do grudnia w lasach iglastych, najczęściej sosnowych na glebach piaszczystych, pospolita, rośnie niekiedy masowo. \n" +
                                "\n" +
                                "Zastosowanie- jadalna. \n".toString();
                        qwe = R.drawable.pieprzna;
                        qwe2 = R.drawable.nieksztaltnabig;
                        list1 = "Gąska pieprzna Tricholoma virgatum,".toString();
                        list2 = "kapelusz podobnie czarno włókienkowany bywa wyraźnie stożkowato zaostrzony, lecz o suchej powierzchni. Blaszki ma szarawe o czarniawych ostrzach.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 35:
                        TempListViewClickedValue = "Gąska ostra Tricholoma sciodes".toString();
                        TempListViewClickedValue2 = "Kapelusz początkowo stożkowo-dzwonkowaty, potem łuskowaty do płaskiego z tępym wybrzuszeniem, średnicy 3-9cm, gładki, jedwabiście błyszczący . Z wiekiem łuskowaty. Powierzchnia wilgotna kleista. Barwy ciemnoszarej z fioletowym odcieniem lub różowofioletowym, na starość brązowoszary. Brzeg białawy długo podwnięty.\n" +
                                "\n" +
                                "Blaszki barwy białawoszarej z odcieniem różowym, ostrze białawe z wiekiem czarnieje.\n" +
                                "\n" +
                                "Trzon biały do szarobiałego z słabym różowawym zabarwieniem, gruby i walcowaty dołem nieco zgrubiały, gładki i matowy. Pełny.\n" +
                                "\n" +
                                "Miąższ szarobiaławy z różowawym zabarwieniem, cienki, smak ostry, zapach ziemnisty. \n" +
                                "\n" +
                                "Zastosowanie- niejadalna.\n" +
                                "\n" +
                                "Występuje rzadko, na terenach podgórskich, w lasach liściastych i mieszanych, tylko pod bukami na terenach wapiennych.  W naszym kraju znaleźć go można w rejonach górskich oraz podgórskich.\n" +
                                "\n" +
                                "Zasosowanie - niejadalny.\n".toString();
                        qwe = R.drawable.pieprzna;
                        qwe2 = R.drawable.ostrabig;
                        list1 = "Gąska pieprzna Tricholoma virgatum,".toString();
                        list2 = "tak samo pikantna w smaku;";
                        list13 = "o wspaniałym orzechowym smaku;";
                        list3 = "Gąska niekształtna Tricholoma portentosum,";
                        qwe3 = R.drawable.nieksztaltna;
                        list14 = "charakteryzująca się łagodnym smakiem.";
                        list4 = "Gąska ziemistobalszkowa Tricholoma terreum,";
                        qwe4 = R.drawable.ziemiastobla;
                        jedzenie = R.drawable.niejadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.niejadalny);
                        break;
                    case 36:
                        TempListViewClickedValue = "Gąska pieprzna Tricholoma virgatum".toString();
                        TempListViewClickedValue2 = "Owocnik srebrzystoszary, szaroczarniawy, 3-7cm średnicy, młody stożkowaty, z wiekiem wypukły do płaskiego z charakterystycznym spiczastym szczytem. Brzeg ostry, długo podgięty, potem prosty. \n" +
                                "\n" +
                                "Powierzchnia sucha, gładka, naga, lecz także pękająca w promienistowłókienkowate łuseczki. \n" +
                                "\n" +
                                "Blaszki białe, z wiekiem szare, szerokie, wykrojone ząbkiem. Ostrze karbowane, nieznacznie czernieje. \n" +
                                "\n" +
                                "Trzon białawoszary jaśniejszy niż kapelusz, cylindryczny, podstawa często maczugowato rozszerzona. Powierzchnia sucha, jedwabiście lśniąca, z podłużnymi włókienkami, w górnej części biało oprószony. \n" +
                                "\n" +
                                "Miąższ białawy, pod skórką szary niezmieniający barwy, smak natychmiast piekący-ostry, gorzki. Zapach niewyraźny ziemisty. \n" +
                                "\n" +
                                "Częsta. Wyrasta pojedynczo lub gromadnie od lata do jesieni, w lasach iglastych pod świerkami, rzadko w liściastych. Preferuje kwaśne gleby. \n" +
                                "\n" +
                                "Zastosowanie- trująca.\n".toString();
                        qwe = R.drawable.ziemiastobla;
                        qwe2 = R.drawable.pieprznabig;
                        list1 = "Gąska ziemistoblaszkowa Tricholoma terreum, ".toString();
                        list2 = "ma kapelusz włóknisty i łagodny smak, nie posiada tak ostrego czubka kapelusza;";
                        list13 = "ma siwoczarne łuski na kapeluszu. Jest rzadka, nie posiada tak ostrego czubka kapelusza;";
                        list3 = "Gąska czarnołuskowa Tricholoma atrosquamosa,";
                        qwe3 = R.drawable.czarnolusko;
                        list14 = "kapelusz jedwabiście błyszczący, w smaku również jest ostra, ale dopiero po dłuższym czasie. Jest rzadka, nie posiada tak ostrego czubka kapelusza;";
                        list4 = "Gąska ostra Tricholoma sciodes,";
                        qwe4 = R.drawable.ostra;
                        list15 = "ma trzon i blaszki żółtawe, smak łagodny, orzechowy, nie posiada tak ostrego czubka kapelusza.";
                        list5 = "Gąska niekształtna Tricholoma portentosum,";
                        qwe5 = R.drawable.nieksztaltna;
                        jedzenie = R.drawable.trujacy;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.trujacy);
                        break;
                    case 37:
                        TempListViewClickedValue = "Gąska siarkowa Tricholoma sulphureum".toString();
                        TempListViewClickedValue2 = "Owocnik osiąga średnicę około 7 cm. Skórka kapelusza jest siarkowożółta i nie zmienia się w miarę dojrzewania. W środku zachowuje się mały garb nawet u zupełnie otwartych i płaskich egzemplarzy. Garbek wykazuje intensywne zabarwienie, które może przechodzić w nieco oliwkowożółtawe. \n" +
                                "\n" +
                                "Blaszki z małym ząbkiem przyrastają do trzonu. Również i one są siarkowożółte, grubawe i dość rzadko ustawione. \n" +
                                "\n" +
                                "Trzon zabarwiony tak samo jak kapelusz i blaszki, dochodzący do 8 cm, może być pełny lub pusty. Powierzchnia włóknista. \n" +
                                "\n" +
                                "Miąższ siarkowożółty. Nie zmienia koloru i po przekrojeniu. Przykry zapach przypomina karbid. \n" +
                                "\n" +
                                "Dość pospolita w lasach liściastych i iglastych na glebach wapiennych. Pojawia się latem się latem i jesienią. \n" +
                                "\n" +
                                "Zastosowanie- niejadalna. \n".toString();
                        qwe = R.drawable.zielonka;
                        qwe2 = R.drawable.siarkowabig;
                        list1 = "Gąska zielonka Tricholoma equestre,".toString();
                        list2 = "ma biały miąższ, gęściejsze blaszki i nie wydziela nieprzyjemnego zapachu.";
                        jedzenie = R.drawable.niejadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.niejadalny);
                        break;
                    case 38:
                        TempListViewClickedValue = "Gąska szerokoblaszkowa Tricholoma luridum".toString();
                        TempListViewClickedValue2 = "Kapelusz o średnicy 5-15cm, młody łukowaty potem dzwonkowaty do płasko rozłożystego z niewyraźnym tępym wybrzuszeniem. Barwy oliwkowobrązowawej z ciemniejszymi promienistymi włókienkami, środkiem ciemniejszy , brzeg jaśniejszy oliwkowożółtawy, na starość pofalowany i postrzępiony. \n" +
                                "\n" +
                                "Powierzchnia gładka matowa, tłusta.\n" +
                                "\n" +
                                "Blaszki barwy brudnawobiaławej do popielato szarych, rzadkie i szerokie.\n" +
                                "\n" +
                                "Trzon biały do szarawobiaławego czasami z żółtobrązowym zabarwieniem, gruby i walcowaty, przy podstawie zaostrzony, pełny. Powierzchnia delikatnie łuskowata lub włóknista.\n" +
                                "\n" +
                                "Miąższ białawy, szarobiaławy, cienki. Smak i zapach mączny, młode owocniki gorzkawe.\n" +
                                "\n" +
                                "Zastosowanie- niejadalna.\n" +
                                "\n" +
                                "Występuje w górskich świerczynach ale także w lasach liściastych i mieszanych.\n".toString();
                        qwe = R.drawable.cetkowana;
                        qwe2 = R.drawable.szerokoblaszkowabig;
                        list1 = "Gąska cętkowana Tricholoma fucatum,".toString();
                        list2 = "ma ciemnobrązowy cętkowany kapelusz.";
                        jedzenie = R.drawable.niejadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.niejadalny);
                        break;
                    case 39:
                        TempListViewClickedValue = "Gąska zielonka Tricholoma flavovirens".toString();
                        TempListViewClickedValue2 = "Owocnik żywo żółtozielonkawego koloru, z oliwkowym lub z ochrawymi włókniście wyrośniętymi łuseczkami, często popękana na brązoworude łuseczki, wilgotna słabo lepka. 5-12cm średnicy. Młody półkulisty, potem rozpostarty, czasami z tępym garbikiem, brzeg początkowo podwinięty, z wiekiem pofalowany. \n" +
                                "\n" +
                                "Blaszki niejednakowej długości, siarkowożółte wąsko przyrośnięte lub wykrojone ząbkiem, ciasno ustawione. \n" +
                                "\n" +
                                "Trzon jasnożółty, do 2 cm średnicy, walcowaty, powierzchnia gładka lub z pojedynczymi kosmykami, pełny. \n" +
                                "\n" +
                                "Miąższ białawy do bladożółtego, niezmienny, zwarty, smak łagodny, zapach słabo mączny. \n" +
                                "\n" +
                                "Występuje pospolicie. Owocniki wyrastają pojedynczo lub w grupach od września do późnej jesieni. Zwykle w lasach iglastych na piasku.\n" +
                                "\n" +
                                "Zastosowanie- jadalna. \n".toString();
                        qwe = R.drawable.sromotnikowy;
                        qwe2 = R.drawable.zielonkabig;
                        list1 = "Muchomor sromotnikowy Amanita phalloides,".toString();
                        list2 = "posiada również zielonkawy kapelusz, za to białe blaszki, pochwę u podstawy trzonu;";
                        list13 = "ma także żółte blaszki, jest mniejsza, kapelusz jest aksamitny, nie lepki, w dotyku;";
                        list3 = "Gąska siarkowa Tricholoma sulphureum,";
                        qwe3 = R.drawable.siarkowa;
                        list14 = "ma białe blaszki, kapelusz jest zielonkawy, ale czarnymi włókienkami.";
                        list4 = "Gąska zielonożółta Tricholoma sejunctum,";
                        qwe4 = R.drawable.zielonozolta;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 40:
                        TempListViewClickedValue = "Gąska żółtobrunatna Tricholoma fulvum".toString();
                        TempListViewClickedValue2 = "Kapelusz o średnicy 4-8 cm, początkowo półkulisty do stożkowato wypukłego, później płaski, z tępym szerokim garbkiem, niekiedy płytko wklęsły pośrodku, w wilgotnych warunkach lepki, w czasie suszy lśniący, z delikatnymi, wrośniętymi, promienistymi włókienkami, gładki, brązowy, żółtobrązowy, z ciemniejszym środkiem.\n" +
                                "\n" +
                                "Blaszki o szerokości od 6 do 10 mm, średnio gęste, jasnożółte do brązowawożółtych, na gładkim ostrzu z czerwonobrązowymi plamami.\n" +
                                "\n" +
                                "Trzon o wysokości od 5 do 11 cm, średnicy od 1 do 1,8 cm, cylindryczny, młody – pełny, później rurkowaty, z podłużnymi brązowymi włókienkami na żółtawym tle, w górnej części jaśniejszy, po oskrobaniu żółknący.\n" +
                                "\n" +
                                "Miąższ zwarty, na środku kapelusza dosyć gruby, biały do żółtawego. Zapach i smak lekko mączne,  gorzkawy w smaku.\n" +
                                "\n" +
                                "Zastosowanie - według niektórych autorów w stanie surowym jest grzybem niejadalnym, gdyż może powodować zaburzenia w trawieniu, ale nadaje się do spożycia, gdy zostanie poddany obróbce termicznej. Według innych autorów jest grzybem trującym!\n".toString();
                        qwe = R.drawable.czerwonobrazo;
                        qwe2 = R.drawable.zoltobrunatnabig;
                        list1 = "Gąska czerwonobrązowa Tricholoma batschii,".toString();
                        list2 = "o blaszkach kremowobiałych i trzonie u podstawy klinowato zwężonym;";
                        list13 = "o kapeluszu gładkim i błyszczącym, a blaszkach rdzawych;";
                        list3 = "Gąska bukowa Tricholoma ustale,";
                        qwe3 = R.drawable.bukowaga;
                        list14 = "ma delikatnie łuseczkowaty kapelusz, biały miąższ, kremowe blaszki i rośnie w lasach iglastych;";
                        list4 = "Gąska dachówkowata Tricholoma imbricatum,";
                        qwe4 = R.drawable.dachowkowata;
                        list15 = "nie ma zapachu i rośnie tylko pod modrzewiem.";
                        list5 = "Gąska modrzewiowa Tricholoma psammopus,";
                        qwe5 = R.drawable.modrzewiowagas;
                        jedzenie = R.drawable.niejadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.niejadalny);
                        break;
                    case 41:
                        TempListViewClickedValue = "Gąsówka dwubarwna Lepista saeva".toString();
                        TempListViewClickedValue2 = "Kapelusz o średnicy 6-18cm, początkowo półkoliście łukowaty z długo podwiniętym brzegiem, potem płaskołukowaty z wiekiem do całkiem płaskiego. Barwy ochrobrązowy, szarobeżowy z domieszką fioletu, z czasem płowiejący i zmieniający się na kolor jasnobrązowy do szrawobrązowego. Z wiekiem środek jaśniejszy. Gładki, nagi, matowy.\n" +
                                "\n" +
                                "Blaszki początkowo białawe, potem kremowe z wiekiem ochrawokremowe. Cienkie i gęste, łamliwe. Przyrośnięte lub zbiegające.\n" +
                                "\n" +
                                "Trzon walcowaty, krótki, masywny i pełny. Barwy: na kremowym tle ciemnofioletowo włóknisty.\n" +
                                "\n" +
                                "Miąższ biały, zwarty i twardy, niezmienny, zapach przyjemny słaby, smak słaby przyjemny.\n" +
                                "\n" +
                                "Zastosowanie- jadalna.\n" +
                                "\n" +
                                "Częsta, od lata do późnej jesieni w lasach na otwartej przestrzeni- na terenach trawiastych, łąkach i pastwiskach w sadach i ogrodach. Często gromadnie. \n".toString();
                        qwe = R.drawable.fioletowawa;
                        qwe2 = R.drawable.dwubarwnabig;
                        list1 = "Gąsówka fioletowawa Lepista nuda,".toString();
                        list2 = "ma fioletowy nie tylko trzon, ale również blaszki i kapelusz;";
                        list13 = "jest podobna kształtem i barwą, ale dużo mniejsza (kapelusz ma średnicę do 6 cm);";
                        list3 = "Gąsówka brudnofioletowa Lepista sordida,";
                        qwe3 = R.drawable.brudnofiol;
                        list14 = "ma trzon szarawy, blaszki jasnokremowe i jest białawo omszona.";
                        list4 = "Lejkówka szarawa Clitocybe nebularis,";
                        qwe4 = R.drawable.szarawalej;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.laka;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 42:
                        TempListViewClickedValue = "Gąsówka fioletowawa Lepista nuda".toString();
                        TempListViewClickedValue2 = "Kapelusz o średnicy 6-15cm, młody barwy intensywnie fioletowej, lilowofioletowy, brązowawofioletowy, do szrawofioletowego i bladoniebieskiego. Środek ciemniejszy  brązowawofioletowe. Z wiekiem blednie.  Młody  wypukły, potem  rozpostarty i wywinięty. Skórka sucha, matowa. Powierzchnia gładka i jedwabista. \n" +
                                "\n" +
                                "Blaszki barwy fioletowej, z wiekiem zmieniające kolor na amarantowobrązowy. Kruche i łamliwe. Przy trzonie przyrośnięte, lub zatokowato wycięte. \n" +
                                "\n" +
                                "Trzon cylindryczny do maczugowatego, pełny, podstawa silnie przerośnięta z podłożem, pokryta fioletowawą lub brązowofioletową grzybnią, bez osłony. Barwy fioletowej   z wrośniętymi białymi włókienkami, z wiekiem blednie. \n" +
                                "\n" +
                                "Miąższ początkowo fioletowy, potem blednący i szarzejący,  zwarty i twardy, z wiekiem miękki. Zapach przyjemny smak łagodny.\n" +
                                "\n" +
                                "Zastosowanie-  jadalna.\n" +
                                "\n" +
                                "Pospolita. w grupach, szeregach lub w czarcich kręgach, rzadziej pojedynczo, w lasach liściastych i iglastych, w ogrodach i  parkach.\n".toString();
                        qwe = R.drawable.brudnofiol;
                        qwe2 = R.drawable.fioletowawabig;
                        list1 = "Gąsówka brudnofioletowa Lepista sordida,".toString();
                        list2 = "jest od niej dużo mniejsza;";
                        list13 = "ma żółty, gorzki i brzydko pachnący miąższ.";
                        list3 = "Zasłonak wonny Cortinarius traganus,";
                        qwe3 = R.drawable.wonnyzas;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t1;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 43:
                        TempListViewClickedValue = "Gąsówka płowa Paralepista gilva".toString();
                        TempListViewClickedValue2 ="Owocnik do 4-10cm średnicy, młody płaski, z długo podwiniętym filcowatym brzegiem, z wiekiem nieregularnie powyginany, szybko płytko lejkowaty. Wilgotny żółtawoochrowy, jasny, często z ciemniejszymi wodnistymi plamami, zwłaszcza na brzegu kapelusza, suchy bladożółtawy. Powierzchnia gładka, nieco połyskliwa. \n" +
                                "\n" +
                                "Blaszki młode białawe z czasem żółknące, ochrowożółte, cienkie i gęste. Zbiegające na trzon. \n" +
                                "\n" +
                                "Trzon barwy kapelusza lub troszkę jaśniejszy, cylindryczny, cienki. Podstawa z białą grzybnią. \n" +
                                "\n" +
                                "Miąższ jasnoochrowy, zwarty. Zapach i smak nieco ziołowy. \n" +
                                "\n" +
                                "Miejscami częsta. W grupach i czarcich kręgach w lasach liściastych i iglastych. Od sierpnia do października. \n" +
                                "\n" +
                                "Zastosowanie- jadalna. \n".toString();
                        qwe = R.drawable.rudawaga;
                        qwe2 = R.drawable.gaplowabig;
                        list1 = "Gąsówka rudawa Lepista flaccida,".toString();
                        list2 = "miąższ sprężysty, smak cierpki.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t1;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 44:
                        TempListViewClickedValue = "Gołąbek białozielonawy Russula aeruginea".toString();
                        TempListViewClickedValue2 = "Kapelusz początkowo półkolisty potem płaskołukowaty, na starość rozpostarty, środkiem wklęsły cienkomięsisty, kruchy, nagi lepki. Barwy zielonej, oliwkowozielonej do żółtozielonej, w centrum ciemniejszy, przy brzegu karbowany, skórka ściągalna prawie do samego środka.\n" +
                                "\n" +
                                "Blaszki białawe z wiekiem kremowożółtawe, przy trzonie rozwidlone, z międzyblaszkami, cienkie, wolne lub nieznacznie przyrośnięte.\n" +
                                "\n" +
                                "Miąższ białawy lub szarawy, początkowo twardy, kruchy. Smak słaby szczypiący i niewyraźnym zapachu.\n" +
                                "\n" +
                                "Trzon biały, u podstawy często z rdzawymi plamami, dość krótki, zaostrzony, podłużnie pomarszczony. Pełny i jędrny, szybko  gąbczasty i miękki.\n" +
                                "\n" +
                                "Zastosowanie – jadalny gorszej jakości.\n" +
                                "\n" +
                                "Występuje często w lasach iglastych pod brzozami, dębami i bukami.\n".toString();
                        qwe = R.drawable.sromotnikowy;
                        qwe2 = R.drawable.bialozielonybig;
                        list1 = "Muchomor sromotnikowy Amanita phalloides,".toString();
                        list2 = "często występują białe resztki osłony  pierścień;";
                        list13 = "nie ma szczypiącego smaku i jego skórkę można ściągnąć tylko do jednej trzeciej promienia kapelusza.";
                        list3 = "Gołąbek oliwkowozielony Russula heterophylla,";
                        qwe3 = R.drawable.oliwkowoziel;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 45:
                        TempListViewClickedValue = "Gołąbek błotny Russula paludosa".toString();
                        TempListViewClickedValue2 = "Kapelusz mięsisty, intensywnie zabarwiony krwisto lub brązowoczerwony, ochrowobrązowy, czasem z jaśniejszymi miejscami, 100-160 mm średnicy; młody półkulisty, potem płaski do lekko wklęśniętego; mięsisty, mocny, skórka wilgotna lepka, błyszcząca, brzeg tępy, z wiekiem nieco karbowany i gruzełkowaty. \n" +
                                "\n" +
                                "Blaszki bladokremowe, kremowe, kruche, zaokrąglone przy brzegu kapelusza. \n" +
                                "\n" +
                                "Trzon biały, z silniejszym lub słabym czerwonym nalotem; masywny, równogruby, u szczytu nieco zwężony, twardy, powierzchnia żyłkowana. \n" +
                                "\n" +
                                "Miąższ o smaku łagodnym, bez zapachu; biały, twardy, dość kruchy. \n" +
                                "\n" +
                                "Pospolity. Owocniki wyrastają masowo od lata do jesieni, w wilgotnych lasach iglastych. \n" +
                                "\n" +
                                "Zastosowanie - jadalny. \n".toString();
                        qwe = R.drawable.plowiejacy;
                        qwe2 = R.drawable.blotnybig;
                        list1 = "Gołąbek płowiejący Russula decolorans,".toString();
                        list2 = "szybko i wyraźnie szarzeje miąższ;";
                        list13 = "ma palący miąższ, jest mniejszy, a kapelusz ma ciemniejszą barwę krwistoczerwoną.";
                        list3 = "Gołąbek brunatny Russula badia,";
                        qwe3 = R.drawable.brunatnygol;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 46:
                        TempListViewClickedValue = "Gołąbek brzozowy Russula betularum".toString();
                        TempListViewClickedValue2 = "Kapelusz 2-5 cm średnicy, trochę mięsisty, kruchy, płaski, później wklęsły, początkowo ciemny, różowoczerwony, odbarwiający się do żółtawego, jedynie podczas wilgotnej pogody z różowymi plamami na kremowym tle, ale najczęściej brudno-lila-różowy. Brzeg tępy, falisty, krótko i nie zawsze wyraźnie karbowany. \n" +
                                "\n" +
                                "Skórka lepka i błyszcząca; można ją łątwo zerwać prawie całkowicie oderwać. \n" +
                                "\n" +
                                "Blaszki dosyć rzadkie, kruche, białe, szerokie przy brzegu kapelusza, zatokowato przyrośnięte, niekiedy z blaszeczkami; między nimi delikatne zmarszczki. \n" +
                                "\n" +
                                "Trzon o wymiarach 2,5-6,5 na 0,7-1,2 cm; biały, równogruby, bardzo kruchy. \n" +
                                "\n" +
                                "Miąższ pod skórką biały. Zapach słaby, lecz wyraźny, trochę przypominający miodowy. Smak ostry. \n" +
                                "\n" +
                                "Występuje często w sąsiedztwie brzóz. \n" +
                                "\n" +
                                "Zastosowanie- niejadalny. \n".toString();
                        qwe2 = R.drawable.brzozowybig;
                        jedzenie = R.drawable.niejadalny;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.niejadalny);
                        break;
                    case 47:
                        TempListViewClickedValue = "Gołąbek cukrówka Russula alutacea".toString();
                        TempListViewClickedValue2 = "Owocnik 7-13 cm średnicy, jędrny, mięsisty, półkulisty, stopniowo rozpostarty i wklęsły w środku, o zmiennych barwach, ciemnopurpurowy, winny, brązowoczarny, w środkowej części nabiegły oliwkowobrązowawo, ale często z czerwonawymi plamami. Brzeg tępy, zaokrąglony, podgięty, równy, na starość krótko karbowany.\n" +
                                "\n" +
                                "Skórka gładka, wilgotna lepka; można ją zedrzeć prawie do połowy promienia kapelusza. \n" +
                                "\n" +
                                "Blaszki grube, dosyć rzadkie, nieraz rozwidlone lub anastomozujące, zaokrąglone przy brzegu kapelusza, zwężone, żółtawe, ale szybko stają się żółtoochrowe; zmarszczki stosunkowo silne i obfite. \n" +
                                "\n" +
                                "Trzon o wymiarach 4-8 na 1,5-3 cm, jędrny, walcowaty, rozszerzony u szczytu, dosyć gładki, nawet jedwabisto błyszczący, z wiekiem nieco żeberkowany, biały, często trochę nabiegły różowo, pełny, później watowaty. \n" +
                                "\n" +
                                "Miąższ gruby, jędrny, ścisły, biały, żółtawy przy brzegu. Zapach słaby, owocowy. Smak łagodny. \n" +
                                "\n" +
                                "Występuje od lipca do września głównie w lasach liściastych. Znajdowany był jednak również w lasach jodłowych.\n" +
                                "\n" +
                                "Zastosowanie- jadalny. \n".toString();
                        qwe = R.drawable.oliwkowy;
                        qwe2 = R.drawable.cukrowkabig;
                        list1 = "Gołąbek oliwkowy Russula olivacea,".toString();
                        list2 = "występuje brzy świerkach i bukach.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 48:
                        TempListViewClickedValue = "Gołąbek jasnożółty Russula claroflava".toString();
                        TempListViewClickedValue2 = "Kapelusz do 12 cm średnicy, mięsisty, jędrny, półkulisty, wcześnie spłaszczony i wklęsły w środkowej części, jaskrawożółty, barwy chromowej, czasem w odcieniu cytrynowym albo trochę ochrowym. Brzeg długo podwinięty, tępy, równy, z wiekiem krótko karbowany, bardzo rzadko spękany. \n" +
                                "\n" +
                                "Skórka w okresie wilgotnej pogody nieco błyszcząca, a podczas suszy matowa, gładka, dająca się względnie łatwo zedrzeć na długości dwóch trzecich promienia kapelusza. \n" +
                                "\n" +
                                "Blaszki dosyć długie, równodługie, łamilwe, zaokrąglone przy brzegu kapelusza, wolne lub zatokowate, nieco anastomozujące przy trzonie, bladokremowe, potem cytrynowoochrowe, często z szarawym odcieniem, w starych okazach nieraz o brzegu czerniejącym. \n" +
                                "\n" +
                                "Trzon o wymiarach 4-7 na 1,5-2,5 cm, jędrny, mocny, równogruby, niekiedy trochę zgrubiały w części środkowej, prawie gładki, zamszowaty, biały, czasem ze słabym odcieniem cytrynowym, po dotknięciu lub z wiekiem wyraźnie szarzejący, watowaty i nawet komorowaty. \n" +
                                "\n" +
                                "Miąższ gruby, jędrny, mocny, ale łamliwy, z wiekiem miękki, biały, na powietrzu szarzeje i plami się czarniawo, bezpośrednio pod skórą żółty. Zapachu brak lub słabo owocowy. Smak łagodny. \n" +
                                "\n" +
                                "Występuje on w bardzo wilgotnych miejscach, zatorfionych, w lasach mieszanych. \n" +
                                "\n" +
                                "Zastosowanie- jadalny, ale nie ceniony. \n".toString();
                        qwe = R.drawable.plowiejacy;
                        qwe2 = R.drawable.jasnozoltybig;
                        list1 = "Gołąbek płowiejący Russula decolorans".toString();
                        list2 = "odznacza się ostrym smakiem oraz białym lub białawym wysypem zarodników.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 49:
                        TempListViewClickedValue = "Gołąbek krwisty Russula sanguinaria".toString();
                        TempListViewClickedValue2 = "Owocnik mięsisty, dosyć jędrny, do 10 cm średnicy, wypukły, z wiekiem nieraz wklęsły w środku, jasnokrwisty, brzoskwiniowoczerwony, niekiedy przechodzący w odcień purpurowy, na starość wypłowiały do bladoróżowego, zwłaszcza na brzegu, nieraz z ochrową plamą w części centralnej, rzadko brudnobiały lub zupełnie biały. \n" +
                                "\n" +
                                "Brzeg stosunkowo ostry, równy lub trochę pofalowany, rzadziej spękany, gładki, ale u starych okazów może być krótko karbowany. \n" +
                                "\n" +
                                "Powierzchnia zwykle trochę błyszcząca gdy mokra, a matowa gdy sucha, bardzo delikatnie chropowata, jak gdyby pokryta promienistymi ciemniejsymi żyłkami lub mikroskopijnymi kosmkami, mocno przyrośnięta; można ją oderwać tylko od samego brzegu kapelusza. \n" +
                                "\n" +
                                "Blaszki dosyć grube i względnie rzadkie, przeważnie tej samej szerokości co grubość miąższu, niekiedy z różną ilością blaszeczek, przyrośnięte lub nawet zbiegające u starszych okazów, często rozwidlone lub anastomozujące w różnych miejscach, przy brzegu raczej ostre, najpierw biłae, później bladokremowe do kremowych. \n" +
                                "\n" +
                                "Trzon o wymiarach 2-7 na 0,8-3 cm, względnie gruby, walcowaty, matowy lub nieco szorstki, przeważnie zabarwiony różowo, bladoróżowo, rzadko zupełnie biały, niekiedy w miejscu dotknięcia przybierjący kolor żołtawy, ścisły, bardzo długo pełen, lecz z wiekiem watowaty, a nawet pustawy. \n" +
                                "\n" +
                                "Miąższ gruby, ale przy brzegu zupełnie cienki, jędrny, ścisły, biały, pod skórką różowy. Zapach słaby, owocowy. Smak ostry, zmienny w swej intensywności. \n" +
                                "\n" +
                                "Występuje od sierpnia do października w trawiastych lasach iglastych, głównie sosnowych, oraz mieszanych z udziałem sosny.\n" +
                                "\n" +
                                "Zastosowanie- niejadalny.\n".toString();
                        qwe2 = R.drawable.krwistybig;
                        jedzenie = R.drawable.niejadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.niejadalny);
                        break;
                    case 50:
                        TempListViewClickedValue = "Gołąbek kunowy Russula mustelina".toString();
                        TempListViewClickedValue2 = "Owocnik ochrowobrązowy do brązowego, cynamonowożółty; 60-140 mm średnicy; początkowo kulistawy, potem poduchowaty, w końcu spłaszczony do nieco wklęsłego; brzeg ostry, długo podgięty, gładki, u starych egzemplarzy krótko karbowany lub gruzełkowaty;\n" +
                                "\n" +
                                "Skórka silnie zespolona z miąższem, zdzieralna w 1/3, wilgotna tłusto połyskująca, sucha matowa i naga. \n" +
                                "\n" +
                                "Blaszki jasnokremowe, z wiekiem nieco ochrowe, gęste, grube, zwężone przy końcach, o tłustym wyglądzie, zatokowate, równodługie, czasem rozwidlone, z nielicznymi blaszeczkami. \n" +
                                "\n" +
                                "Trzon gruby, gładki, nieco szerszy u podstawy, biały z wiekiem z nielicznymi ochrowymi lub brązowymi plamami; twardy. \n" +
                                "\n" +
                                "Miąższ gruby, zwarty; biały; smak łagodny, bez szczególnego zapachu. \n" +
                                "\n" +
                                "Występuje dość licznie, przede wszystkim w górskich lasach iglastych, głównie pod świerkiem i jodłą , w lecie i jesieni. \n" +
                                "\n" +
                                "Zastosowanie - jadalny.\n".toString();
                        qwe = R.drawable.smierdzacy;
                        qwe2 = R.drawable.kunowybig;
                        list1 = "Gołąbek śmierdzący Russula foetens,".toString();
                        list2 = "odróżnia go duszący i nieprzyjemny zapach;";
                        list13 = "rosnący na glebach wapiennych.";
                        list3 = "Gołąbek słodkawy Russula integra,";
                        qwe3 = R.drawable.golslodkawy;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 51:
                        TempListViewClickedValue = "Gołąbek lazurowy Russula azurea".toString();
                        TempListViewClickedValue2 = "Kapelusz o średnicy 3-8cm, początkowo półkolisty potem wklęsły i to znacznie, czasami z garbkiem, na brzegu gładki i tępy. Barwy fioletowoametystowej do brązowofioletowego środkiem ciemniejszy. Skórka ściągalna do połowy.\n" +
                                "\n" +
                                "Blaszki białe, wolne i kruche.\n" +
                                "\n" +
                                "Trzon biały, walcowaty, oszroniony, młody pełny z wiekiem pusty watowaty.\n" +
                                "\n" +
                                "Miąższ białawy, o niewyraźnym smaku i zapachu.\n" +
                                "\n" +
                                "Zastosowanie- jadalny.\n" +
                                "\n" +
                                "Występuje  w rejonach podgórskich i górskich, w lasach iglastych.\n".toString();
                        qwe = R.drawable.liliowa;
                        qwe2 = R.drawable.lazurowybig;
                        list1 = "Gołąbek liliowy Russula lilacea,".toString();
                        list2 = "rośnie wyłącznie w liściastych lasach i często ma trzon czerwonawy;";
                        list13 = "różni się charakterystycznym zapachem jodoformu i ma żółte blaszki;";
                        list3 = "Gołąbek turecki Russula turci,";
                        qwe3 = R.drawable.turacki;
                        list14 = "ma żółte blaszki i żółte zarodniki.";
                        list4 = "Gołąbek ametystowy Russula amethystina,";
                        qwe4 = R.drawable.ametystowy;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 52:
                        TempListViewClickedValue = "Gołąbek płowiejący Russula decolorans".toString();
                        TempListViewClickedValue2 = "Kapelusz o średnicy 5-12cm początkowo półkolisty z wiekiem płaski, środkiem zapadnięty. Barwy pomarańczowomorelowej, środkiem blednący, na starość miejscami na brzegu z brązowoczarnymi plamami.\n" +
                                "\n" +
                                "Blaszki młode białe, wolne, brzuchowate, potem barwy śmietankowe do ochrowych z wiekiem ostrza siwieją. Uszkodzone czernieją.\n" +
                                "\n" +
                                "Trzon biały wkrótce szarzejący, walcowaty, mięsisty, pełny. Uszkodzony i z wiekiem siwiejący na starość ciemno siwy do czerniejącego.\n" +
                                "\n" +
                                "Miąższ biały do szarzejącego niekiedy z czerwonawym nalotem. Smak i zapach słaby.\n" +
                                "\n" +
                                "Zastosowanie- jadalny.\n" +
                                "\n" +
                                "Miejscami częsty, w wilgotnych lasach iglastych, pod świerkami i sosnami. na glebach kwaśnych i piaszczystych.\n".toString();
                        qwe = R.drawable.brudnozolty;
                        qwe2 = R.drawable.plowiejacybig;
                        list1 = "Gołąbek brudnożółty Russula ochroleuca,".toString();
                        list2 = "ma kapelusz barwy ochrowożółtej i po przełamaniu nie siwieje;";
                        list13 = "posiada różowopurpurowe plamy na kapeluszu i trzonie, po przełamaniu również nie siwieje;";
                        list3 = "Gołąbek plamisty Russula maculata,";
                        qwe3 = R.drawable.plamistygol;
                        list14 = "miąższ po przełamaniu nie siwieje.";
                        list4 = "Gołąbek błotny Russula paludosa,";
                        qwe4 = R.drawable.blotny;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 53:
                        TempListViewClickedValue = "Gołąbek słodkawy Russula integra".toString();
                        TempListViewClickedValue2 = "Owocnik 3-12 cm średnicy, jędrny, mięsisty, półkulisty, stopniowo szeroko rozpostarty aż do wklęsłego, brązowawy, brązowopurpurowy, żółtobrązowy, zwykle w środku z oliwkowymi plamami, ablo w środku ciemnopurpurowy, a później odbarwiający się do jasnoochrowego. Brzeg często krótko karbowany i gruzełkowaty. \n" +
                                "\n" +
                                "Skórka gładka, wilgotna lepka i błyszcząca; daje się zedrzeć do połowy promienia kapelusza. \n" +
                                "\n" +
                                "Blaszki względnie rzadkie, grube, szerokie, zaokrąglone przy brzegu kapelusza, wolne, z blaszeczkami i dosyć licznymi rozwidleniami bliżej trzonu, białe, później żółknące do zupełnie żółtawych; zmarszczki liczne i grube. \n" +
                                "\n" +
                                "Trzon masywny, o wymiarach 3-9 na 1,2-3,5 cm; prawie równogruby, gładki, jedwabisto połyskujący, nastepnie trochę żeberkowany, biały, nieco rudawy u podstawy, pełny z wiekiem watowaty. \n" +
                                "\n" +
                                "Miąższ gruby, jędrny, twardy, biały, zaledwie żółtawy, pod skórką zabarwiony czerwono. Zapach słaby, owocowy. Smak łagodny. \n" +
                                "\n" +
                                "Występuje w lasach sosnowych i górskich jodłowych na glebach wapiennych. \n" +
                                "\n" +
                                "Zastosowanie- jadalny. \n".toString();
                        qwe = R.drawable.brunatnygol;
                        qwe2 = R.drawable.golslodkawybig;
                        list1 = "Gołąbek brunatny Russula badia,".toString();
                        list2 = "jest bardzo podobny, ale niejadalny. Różni się bardzo piekącym i długotrwale utrzymującym się w ustach smakiem. Ma też bardziej czerwonawe odcienie kapelusza;";
                        list13 = "ma również podobne ubarwienie. Jest jednak bardziej mięsisty, ma kremowe blaszki i biały wysyp zarodników.";
                        list3 = "Gołąbek kunowy Russula mustelina,";
                        qwe3 = R.drawable.kunowy;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 54:
                        TempListViewClickedValue = "Gołąbek smaczny Russula delica".toString();
                        TempListViewClickedValue2 = "Kapelusz o średnicy 10-15 cm, rzadko więcej, masywny, mięsisty, wklęsły w środku, białawy z wiekiem przybierający zabarwienie kremowoochrowe, potem jasne brązowordzawe, a także umbra lub - zwłaszcza w miejscach bardziej nasłonecznionych albo w okresach suszy - kolor skorupki orzecha. Brzeg za młodu długo podwinięty. \n" +
                                "\n" +
                                "Skórka słabo wykształcona, sucha, zamszowata, z wiekiem gładka, nawet błyszcząca, czasem trochę popękana; prawie nie można oderwać jej od miąższu. \n" +
                                "\n" +
                                "Blaszki względnie rzadkie, stosunkowo cienkie i wąskie, przyrośnięte do zbiegających, ostre na brzegu kapelusza, różnej długości, z licznymi blaszeczkami, rozwidlone na trzonie, często łzawiące, białe lub białawe; pomiędzy nimi występują poprzeczne zmarszczki. \n" +
                                "\n" +
                                "Trzon dość gruby, 2-8 na 1,5-3 cm, mocny, jędrny, biały, nieco brązowiejący, matowy pełny. \n" +
                                "\n" +
                                "Miąższ gruby, ścisły, twardy, biały, nie zmieniający barwy. Zapach specyficzny owoców lub świeżych ryb. Smak łagodny. \n" +
                                "\n" +
                                "Występuje od wczesnego lata do późnej jesieni w lasach iglastych i liściastych. \n" +
                                "\n" +
                                "Zastosowanie- jadalny. \n".toString();
                        qwe = R.drawable.bielmlecz;
                        qwe2 = R.drawable.smacznybig;
                        list1 = "Mleczaj biel Lactarius piperatus,".toString();
                        list2 = "wydziela po skaleczeniu bardzo piekące mleczko natychmiast obficie wypływające.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 55:
                        TempListViewClickedValue = "Gołąbek śliczny Russula rosacea".toString();
                        TempListViewClickedValue2 = "Kapelusz 4-11 cm średnicy, półkulisty, potem rozpostarty, mięsisty i twardy, karminowy, krwistoczerwony, cynobrowo-czerwony, a także karminoworóżowy, w środku może nieco wyblakły, ochrowy, a nawet białawy. W okresie suszy bywa spękany na dość duże poletka i przebarwiony na ochrowobrązowo; pęknięcia szerokie i białe. Brzeg równy, tępy, bez karbów. \n" +
                                "Skórka matowa, sucha, niegładka, podczas pogody deszczowej nielepka, przyrośnięta. \n" +
                                "\n" +
                                "Blaszki dojrzałych okazów gęste, grube, równodługie, zaokrąglone przy brzegu kapelusza, węższe przy trzonie i nieraz rozwidlone lub astomozujące, białe, z wiekiem kremowobiałe do jasnokremowych, czasem z odcieniem szarawym lub ostrzem zabarwionym czerwono, wolne, niekiedy miejscami zbiegające. \n" +
                                "\n" +
                                "Trzon o wymiarach 3-7 na 1,5-4 cm, cylindryczny lub trochę rozszerzony u podstawy, biały albo zabarwiony całkowicie lub miejscami na kolor karminoworóżowy, bez połysku, gładki, z delikatnym podłużnym prążkowaniem przypominającym siateczkę, bardzo twardy, pełny z wiekiem watowaty, a nawet z kilkoma komorami. \n" +
                                "\n" +
                                "Miąższ dosyć gruby, bardzo twardy, biały, niezmienny, chociaż przy wysychaniumoże trochę żółknąć; pod skórą bywa różowy. Zapach słaby, według różnych autorów słabo owocowy, suszonych jabłek lub owocowo-mentolowy. Smak łagodny, określany też jako mentolowy, gorzkawy w blaszkach. \n" +
                                "\n" +
                                "Pojawia się często w okresie letnio-jesiennym, w lasach liściastych, mieszanych, a także w lasach iglastych, zwłaszcza pod bukami, na glebach wapiennych.\n" +
                                "\n" +
                                "Zastosowanie - niejadalny. Jadalny jest tylko po kilkugodzinnym moczeniu i sparzeniu.\n".toString();
                        qwe2 = R.drawable.slicznybig;
                        jedzenie = R.drawable.niejadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.niejadalny);
                        break;
                    case 56:
                        TempListViewClickedValue = "Gołąbek winnoczerwony Russula vinosa".toString();
                        TempListViewClickedValue2 = "Kapelusz 4,5 – 12 cm średnicy, gruby, mięsisty, masywny, wypukły, ale szybko staje się spłaszczony, rozłożysty, szeroko wklęsy w środku, ciemnopurpurowy do krwistobrązowego, w centralnej części zwykle jaśniejszy, z odcieniem rudawym, a także nieco oliwkowym, a czasem ciemnobrązowym. Brzeg tępy, zaokrąglony, długo podwinięty, gładki, najwyżej krótko i słabo karbowany. \n" +
                                "\n" +
                                "Skórka wilgotna, lepka błyszcząca, daje się oderwać od miąższu na długość do połowy promienia kapelusza. \n" +
                                "\n" +
                                "Blaszki u dojrzałych okazów stosunkowo rzadkie i szerokie, łamliwe, z pewną ilością blaszeczek, tępe i zaokrąglone przy brzegu kapelusza, do 1 mm grube, nieco rozwidlone przy trzonie, trochę zbiegające, później wolne, kremowe do kremowoochrowych, z wiekiem szarzejące. \n" +
                                "\n" +
                                "Trzon o wymiarach 3-8 na 1-2,5 cm, mięsisty, równogruby, biały z szarawym odcieniem, szybko staje się popielaty, pełny, z wiekiem o rdzeniu watowatym i o cienkiej korze. \n" +
                                "\n" +
                                "Miąższ gruby w części środkowej, nie twardy, łamliwy, biały, pod skórką czerwony, po przełamaniu szarzejący, niekiedy uprzednio z odcieniem różowym. Zapach słaby. Smak łagodny. \n" +
                                "\n" +
                                "Częsty w wilgotnych lasach iglastych, zatorfionych. \n" +
                                "\n" +
                                "Zastosowanie- jadalny. \n".toString();
                        qwe = R.drawable.golslodkawy;
                        qwe2 = R.drawable.winnoczerwonybig;
                        list1 = "Gołąbek słodkawy Russula integra,".toString();
                        list2 = "miąższ nie szarzeje po przełamaniu;";
                        list13 = "jaśniejszy kapelusz.";
                        list3 = "Gołąbek płowiejący Russula paludosa,";
                        qwe3 = R.drawable.plowiejacy;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 57:
                        TempListViewClickedValue = "Gołąbek wyborny Russula vesca".toString();
                        TempListViewClickedValue2 = "Kapelusz o średnicy 5-11cm. Młody półkulisty, szybko rozpostarty i płytko wklęsły. Barwy bardzo zmiennej- cielistoczerwony, środek ciemniejszy, często z odcieniami brązowym, różowym, purpurowym, często miejscami wyblakły żółtawy, białawy. Na starośc może przyjmować barwę zielonkawą, orzechową, szarawą z plamami ochrowymi.\n" +
                                "\n" +
                                "Blaszki dość gęste, często rozwidlone przy trzonie, wolne do zbiegających. Barwy białe do słabo kremowych lub z błękitnym połyskiem, ostrze często z rdzawymi punkcikami.\n" +
                                "\n" +
                                "Trzon krótki i cylindryczny lub zwężony u podstawy, z wiekiem komorowaty i watowaty. Barwy białej , u starszych okazów podstawa plamiąca się ochrowo lub rdzawo. Gładki z wiekiem mączysty i chropowaty.\n" +
                                "\n" +
                                "Miąższ biały, dość zwarty, bez wyraźnego zapachu. Smak łagodny, przyjemny, słodki i orzechowy.\n" +
                                "\n" +
                                "Zastosowanie- jadalny.\n" +
                                "\n" +
                                "Dość częsty, zwykle pojedynczo lub w grupach po kilka, latem i jesienią, w lasach iglastych i liściastych. \n".toString();
                        qwe = R.drawable.buczynowy;
                        qwe2 = R.drawable.wybornybig;
                        list1 = "Gołąbek buczynowy Russula mairei,".toString();
                        list2 = "ma czerwony lub różowy kapelusz i jest lekko trujący, o ostrym smaku, bardziej lśniący, a miąższ mniej ściślejszy.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 58:
                        TempListViewClickedValue = "Gołąbek zielonawofioletowy Russula cyanoxantha".toString();
                        TempListViewClickedValue2 = "Kapelusz o średnicy 5-15 cm. Młody półkulisty z podgiętym brzegiem, później wypukły, stary wklęsły do lejkowatego. Skórka przeważnie bez połysku. W czasie wilgotnej pogody skórka jest lepka, w czasie suchej błyszcząca. Istnieje duża zmienność w ubarwieniu kapelusza. Ma on kolor w różnych odcieniach koloru fioletowego, niebieskiego, różowego, ochrowego i oliwkowego. Cały kapelusz może być ubarwiony jednolicie, ale może też być kombinacją wymienionych kolorów.\n" +
                                "\n" +
                                "Blaszki białe, dość gęste, o różnej długości Są giętkie (nie kruszą się przy dotknięciu palcem) – co jest wyjątkiem wśród gołąbków. Ten gatunek jest jedynym gołąbkiem, którego blaszki na starszych grzybach nie stają się kruche, lecz zachowują elastyczność.\n" +
                                "\n" +
                                "Trzono wysokości 5-12 cm, grubości 2-3 cm , walcowaty, początkowo twardy, później gąbczasty. Biały, rzadko zabarwiony na liliowoczerwono.\n" +
                                "\n" +
                                "Miąższ trwale biały, dość ścisły. Smak łagodny. W odróżnieniu od innych gołąbków miąższ nie barwi się pod wpływem siarczanu żelazawego na różowocielisto.\n" +
                                "\n" +
                                "Zastosowanie- jadalny.\n" +
                                "\n" +
                                "Rośnie od lipca do października, przeważnie w lasach liściastych, rzadziej iglastych, głównie pod dębami lub bukami. Rośnie na różnych glebach, unika tylko gleb wapiennych\n".toString();
                        qwe = R.drawable.oliwkowoziel;
                        qwe2 = R.drawable.zielonofioletowybig;
                        list1 = "Gołąbek oliwkowozielony Russula heterophylla,".toString();
                        list2 = "różni się gęstszymi i widelcowato pozrastanymi przy trzonie blaszkami oraz przewagą oliwkowozielonego koloru na kapeluszu;";
                        list13 = "o małych rozmiarach i z kruszącymi się blaszkami.";
                        list3 = "Gołąbek fiołkowozielony Russula ionochlora,";
                        qwe3 = R.drawable.fioletowozielony;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 59:
                        TempListViewClickedValue = "Gołąbek zielonawy Russula virescens".toString();
                        TempListViewClickedValue2 = "Kapelusz masywny, bardzo mięsisty i względnie twardy, jędrny, 5-12 cm średnicy, za młodu prawie kulisty, z wiekiem spłaszczony i trochę wklęsły, barwy szarozielonej, na brzegu mlecznozielonkawej wpdającej nawet w jasnopłową. Brzeg początkowo ostry, później raczej tępy i często falisty lub spękany promienisto, na starość krótko, lecz grubo karbowany. \n" +
                                "\n" +
                                "Skórka gruba, sucha, przyrośnięta tak silnie, że tylko w okresie wilgotnej pogody można ją miejscami trochę zedrzeć od brzegu, przeważnie razem z miąższem; ma ona wygląd mączysty i najczęściej jest popękana na małe poletka, nieraz tak drobne, że sprawiają wrażenie brodawek; bliżej brzegu kapelusza poletka są znacznie większe i jaśniejsze. \n" +
                                "\n" +
                                "Blaszki białe, później jasnokremowe, zwykle wolne, niektóre rozwidlone przy trzonie; pomiędzy nimi występują wyraźne zmarszczki, a czasem pojawiają się blaszeczki. \n" +
                                "\n" +
                                "Trzon masywny, zwykle równogruby lub trochę rozdęty, o wymiarach 2-9 na 2-4 cm, gładki, u szczytu nieco mączysty, biały u podstawy nekiedy nabiegły beżowo, pełny z wiekiem watowaty. \n" +
                                "\n" +
                                "Miąższ gruby, jędrny, biały, prawie zupełnie pozbawiony zapachu, chociaż na świeżo może nieznacznie pachnieć owocami, a na starość serem. Smak łagodny. \n" +
                                "\n" +
                                "Występuje pojedynczo, najwyżej w grupach po kilka. Spotykany jest w lasach jasnych, prześwietlonych, liściastych (buczynach, dąbrowach, grądach) oraz mieszanych. \n" +
                                "\n" +
                                "Zastosowanie- jest to jeden z najlepszych jadalnych gołąbków. \n".toString();
                        qwe = R.drawable.sromotnikowy;
                        qwe2 = R.drawable.zielonawybig;
                        list1 = "Muchomor sromotnikowy Amanita phalloides,".toString();
                        list2 = "ma u nasady trzonu bulwę z pochwą;";
                        list13 = "ma znacznie gorszy smak. Nie ma tak charakterystycznej 'kostkowatej' powierzchni i takiego odcienia koloru.";
                        list3 = "Gołąbek białozielonawy Russula aeruginea,";
                        qwe3 = R.drawable.bialozielony;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 60:
                        TempListViewClickedValue = "Gołąbek złotawy Russula aurata".toString();
                        TempListViewClickedValue2 = "Owocnik 5-9 cm średnicy; żywo zabarwiony w kolorach żółto-pomarańczowo-czerwonych; powierzchnia gładka, brzeg bez prążkowań. \n" +
                                "\n" +
                                "Blaszki początkowo kremowe, po dojrzeniu żółte, z ostrzem złocistym, dość szerokie, przy trzonie przyrośnięte lub zaokrąglone. \n" +
                                "\n" +
                                "Trzon biały, wielkość 3-8/1,5-2,5 cm, gładki, suchy, początkowo wewnątrz pełny, u starych okazów gąbczasty. \n" +
                                "\n" +
                                "Miąższ kremowy, pod skórką kapelusza różowy, czasem żółtawy, smak łagodny, bez zapachu. \n" +
                                "\n" +
                                "Występuje latem i jesienią, w różnych typach lasów, szczególnie na podłożu wapiennym, niezbyt częsty.\n" +
                                "\n" +
                                "Zastosowanie - jadalny.\n".toString();
                        qwe2 = R.drawable.golzlotawybig;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 61:
                        TempListViewClickedValue = "Goryczak purpurowozarodnikowy Porphyrellus porphyrosporus".toString();
                        TempListViewClickedValue2 = "Kapelusz 6-12 cm średnicy, ale bywają także 16-centymetrowe okazy. U młodych grzybów ma on kształt półkuli, u starszych rozpościera się poduszkowato. Jego brzeg jest początkowo podgięty i ostry. Kolor najpierw jasnoszarobrązowy, później ciemnobrązowy z czerwonawym nalotem. \n" +
                                "\n" +
                                "Powierzchnia początkowo delikatnie zamszowa, później gładka, zawsze sucha. \n" +
                                "\n" +
                                "Rurki przy trzonie zatokowo wycięte lub przyrośnięte, początkowo dość krótkie, w miarę wzrostu owocnika dochodzą do długości 1,5 cm. Barwa ich zmienia się od szarobrunatnej do brudnobrunatnej. Przy nacisku przebarwiają się, podobnie jak kapelusz, na kolor czarnobrunatny. \n" +
                                "\n" +
                                "Trzon zabarwiony podobnie jak kapelusz, jednak u podstawy jest białawy i z filcowatym nalotem. U młodych osobników zamszowaty, u starszych gładki; początkowo wybrzuszony, później bardziej maczugowaty lub walcowaty. \n" +
                                "\n" +
                                "Miąższ białawy lub białoszary, niekiedy czerwieniejący lub siniejący, twardawy. \n" +
                                "\n" +
                                "Występuje na ubogich glebach piaszczystych, w lasach iglastych, na żyznym podłożu lasów bukowych i jodłowych, woli jednak lasy świerkowe w regionach górskich; owocniki, rosnące pojedynczo lub w grupach, znajdowane bywają od czerwca do października.\n" +
                                "\n" +
                                "Zastosowanie - niejadalny, ale nie jest trujący. \n".toString();
                        qwe2 = R.drawable.purpurozarodbig;
                        jedzenie = R.drawable.niejadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t1;
                        jadalnosc.setImageResource(R.drawable.niejadalny);
                        break;
                    case 62:
                        TempListViewClickedValue = "Goryczak żółciowy Tylopilus felleus".toString();
                        TempListViewClickedValue2 = "Owocnik jasnobrązowy, płowobrązowy, szarobrązowy, matowy, zamszowaty, wilgotny słabo śluzowaty; 50-150 mm średnicy, początkowo półkulisty, potem wypukły i rozpostarty. Barwy brązowej z odcieniami szarego, płowego i nutką fioletu. Na powierzchni w zasadzie matowo-zamszowaty, ale spotykany też połyskliwy. Kiedy wilgotny jest lekko śluzowaty. Średnica kapelusza od 30 do 150 mm. W kształcie półkulisty, gdy młody, a gdy już starszy wypukły i rozpostarty. \n" +
                                "\n" +
                                "Pory młode, barwy białej lub z odcieniem szarego. U dojrzałych owocników różowieją i przybierają barwę cielistobrązową. \n" +
                                "\n" +
                                "Rurki barwy porów. Zatokowato wycięte przy trzonie. Uszkodzone brązowieją. Łatwo dające się oddzielić od miąższu.\n" +
                                "\n" +
                                "Trzon w barwie jest jaśniejszy od kapelusza, i przybiera kolor oliwkowożółty do oliwkowobrązowego. Posiada wyraźną, brązową siateczką o dużych okach, rozlokowaną zazwyczaj na całej powierzchni. Długość od 40 do 150 mm. Grubość od 20 do 50 mm. Może przybierać różne kształty. Od smukłego, cylindrycznego, równogrubego, do pękatego, gruszkowatego lub maczugowatego. Pełny. \n" +
                                "\n" +
                                "Miąższ gruby, biały niezmienny, młody twardy, z wiekiem gąbczasty, zapach przyjemny smak gorzki, piekący.\n" +
                                "\n" +
                                "Pospolity. Owocniki wyrastają od lata do jesieni, pojedynczo lub w grupach po kilka, pod sosnami, świerkami, na kwaśnych glebach.\n" +
                                "\n" +
                                "Zastosowanie- niejadalny.\n" +
                                "\n" +
                                "Jeśli po dotknięciu językiem poczujemy smak żółci jest to Goryczak żółciowy.\n".toString();
                        qwe2 = R.drawable.zolciowybig;
                        jedzenie = R.drawable.niejadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t1;
                        jadalnosc.setImageResource(R.drawable.niejadalny);
                        break;
                    case 63:
                        TempListViewClickedValue = "Goździeniec fioletowy Clavaria zollingeri".toString();
                        TempListViewClickedValue3 = "Gatunek objęty ochroną częściową w Polsce Czechach, Niemczech, Danii, Anglii, Norwegii, Szwecji i Finlandii! ".toString();
                        TempListViewClickedValue2 = "Owocnik ma postać cylindrycznej pałeczki rozszerzającej się ku wierzchołkowi, o wysokości do 2–10 cm i grubości 2–6 mm. Zazwyczaj jest pojedynczy, rzadko rozgałęziający się, prosty, czasami robakowato wygięty. \n" +
                                "\n" +
                                "Powierzchnia gładka, matowa, nieprzezroczysta, purpurowa lub różowofioletowa, przy podstawie jaśniejsza. Szczyt pałeczki jest zaokrąglony. \n" +
                                "\n" +
                                "Miąższ miękki i kruchy, bez wyraźnego zapachu i smaku.\n" +
                                "\n" +
                                "Rośnie w lasach, prawie zawsze w mchu pod drzewami. Zazwyczaj rośnie kępkami.\n" +
                                "\n" +
                                "Zastosowanie – niejadalny.\n".toString();
                        qwe = R.drawable.purpurowygo;
                        qwe2 = R.drawable.fioletowybig;
                        list1 = "Goździeniec purpurowy Alloclavaria purpurea,".toString();
                        list2 = "nie wytwarza owocnków rozgałęzionych.";
                        jedzenie = R.drawable.niejadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.def2;
                        jadalnosc.setImageResource(R.drawable.niejadalny);
                        break;
                    case 64:
                        TempListViewClickedValue = "Goździeniec gliniasty Clavaria argillacea".toString();
                        TempListViewClickedValue3 = "Gatunek objęty ochroną częściową w Polsce, Niemczech i Holandii!".toString();
                        TempListViewClickedValue2 = "Zazwyczaj owocniki tworzą niewielkie skupiska. Pojedynczy ma postać maczugowatej pałeczki o wysokości do 15 cm i grubości 2–12 mm, zazwyczaj prostej, czasami robakowato wygiętej. \n" +
                                "\n" +
                                "Powierzchnia gładka lub nieregularnie prążkowana, zazwyczaj matowa, cytrynowożółta, czasami z szarym lub oliwkowym odcienie. \n" +
                                "\n" +
                                "Miąższ białawy, kruchy i bez wyraźnego zapachu i smaku.\n" +
                                "\n" +
                                "Owocniki rosną na ziemi w lasach i zaroślach, wśród traw i mchów na wrzosowiskach, torfowiskach. Pojawiają się od lipca do listopada. Zazwyczaj rosną kępkami. Prawdopodobnie tworzy mikoryzę z roślinami z rodziny wrzosowatych.\n" +
                                "\n" +
                                "Zastosowanie – niejadalny.\n".toString();
                        qwe2 = R.drawable.gliniastybig;
                        jedzenie = R.drawable.niejadalny;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.def2;
                        jadalnosc.setImageResource(R.drawable.niejadalny);
                        break;
                    case 65:
                        TempListViewClickedValue = "Goździeńczyk grzebieniasty Clavaria cristata".toString();
                        TempListViewClickedValue2 = "Młode owocniki są czysto białe, później kremowe, w końcu szarawe, czasami cielistej barwy. Osiągają do 8 cm wysokości i 2-4 cm szerokości. Tak jak u innych gatunków rodziny, owocnik jest drzewkowato rozgałęziony. Zakończenia gałązek są drobnoząbkowane, często ciemnieją podczas suchej pogody. \n" +
                                "\n" +
                                "Miąższ białawy, kruchy, pozbawiony wyraźnego zapachu, łagodny w smaku (niekiedy trochę gorzkawy).\n" +
                                "\n" +
                                "W Polsce jest pospolity. Owocniki rosną pojedynczo lub w skupiskach na ziemi, czasem na rozkładającym się drewnie, w lasach iglastych i liściastych. Owocniki wytwarza od lipca do października.\n" +
                                "\n" +
                                "Zastosowanie – jadalny (twardy trzon)\n".toString();
                        qwe = R.drawable.blada;
                        qwe2 = R.drawable.grzebieniastybig;
                        list1 = "Koralówka blada Ramaria pallida,".toString();
                        list2 = "jest większa i ma równolegle rosnące odgałęzienia.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.def2;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 66:
                        TempListViewClickedValue = "Goździeńczyk pomarszczony Clavulina rugosa".toString();
                        TempListViewClickedValue2 = "Owocnik duży, wysokości 4-10 cm; biały, kremowy, zszarzały, młody czasem z fioletowym odcieniem; zbudowany z pojedynczych lub połączonych w grupy cienkich odgałęzień spłaszczonych ku wierzchołkowi, nierozgałęzione lub na końcu rozgałęzione na na 1-3 krótkich ramion, ich końce zaokrąglone lub z zębami, powierzchnia owocnika bruzdowana, nierówna do nieregularnie guzkowatej. \n" +
                                "\n" +
                                "Miąższ elastyczny, delikatny, miękki, białawy lub żółtawobiaławy; prawie bez zapachu i o łagodnym smaku. \n" +
                                "\n" +
                                "Średnio pospolity. Częściej spotykany na niżu i w górach. Owocniki wyrastają od końca lata do jesieni, pojedynczo lub w małych grupach, na podłożu bogatym w humus, w trawie i mchu, w lasach iglastych, rzadziej w lasach liściastych. \n" +
                                "\n" +
                                "Zastosowanie - jadalny, ale bez większej wartości. \n".toString();
                        qwe = R.drawable.grzebieniasty;
                        qwe2 = R.drawable.pomarszczonybig;
                        list1 = "Goździeńczyk grzebieniasty Clavulina cristata,".toString();
                        list2 = "są one silniej rozgałęzione, a końce gałązek zakończone szpiczastymi wyrostkami, ma też mniejsze zarodniki;";
                        list13 = "jej zarodniki nie mają dużej kropli, a strzępki są bez sprzążek.";
                        list3 = "Goździeniec robakowaty Clavaria vermicularis,";
                        qwe3 = R.drawable.robakowaty;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.def2;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 67:
                        TempListViewClickedValue = "Goździeńczyk popielaty Clavaria cinerea".toString();
                        TempListViewClickedValue2 = "Owocnik do 3-10 cm wysokości , koralowato rozgałęziony, gałązki mniej lub bardziej szare do fioletowawych. Wierzchołki jaśniejsze o tępych zakończeniach \n" +
                                "\n" +
                                "Miąższ białawy, kruchy, bez szczególnego smaku i zapachu. \n" +
                                "\n" +
                                "Występuje często, w dużych skupiskach, w lasach mieszanych ale rzadziej w iglastych. przeważnie na gołej ziemi, od lata do jesieni. \n" +
                                "\n" +
                                "Zastosowanie- jadalny. \n".toString();
                        qwe = R.drawable.grzebieniasty;
                        qwe2 = R.drawable.popielatygozbig;
                        list1 = "Goździeńczyk grzebieniasty Clavulina cristata,".toString();
                        list2 = "częściej spotykane jaśniejsze owocniki;";
                        list13 = "podobne, szare zabarwienie, ale jest bardziej maczugowaty.";
                        list3 = "Gożdzieńczyk pomarszczony Clavulina rugosa,";
                        qwe3 = R.drawable.pomarszczony;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.def2;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 68:
                        TempListViewClickedValue = "Grzybówka różowa Mycena rosea".toString();
                        TempListViewClickedValue2 = "Owocnik w różnych odcieniach różu. Od białoróżowego po intensywnie różowy, bez barwy fioletowej. Osiąga średnicę od 20 do 60 mm. W kształcie początkowo stożkowato - dzwonowaty, rozpostarty do płaskiego i wywiniętego. W centrum wklęśnięty, z płaskim garbkiem i intensywniejszym zabarwieniem w porze suchej. Brzeg ostry, jaśniejszy od reszty kapelusza. \n" +
                                "\n" +
                                "Skórka gładka, świecąca. Wilgotna, lekko śliska. Powierzchnia bruzdowana od prześwitujących blaszek do 2/3 średnicy. \n" +
                                "\n" +
                                "Blaszki w kolorze białawe lub białaworóżowe. Ustawione dość luźno. Zatokowato wycięte. Dość szerokie. Ostrze nieznacznie poszarpane. \n" +
                                "\n" +
                                "Trzon w kolorze białawy z mniej lub więcej różowawym odcieniem. W bardzo wilgotnym owocniku cielisty i w tym okresie intensywniej ubarwiony przy podstawie. Nagi, gładki, połyskliwy i walcowaty. Szerszy nieco przy podstawie, gdzie jest pokryty strzępkami żółtawej grzybni. Pusty wewnątrz. \n" +
                                "\n" +
                                "Miąższ barwy białej, wodnisty, kruchy i niezmienny. W trzonie nieco łykowaty. W smaku i zapach z nutką rzodkwi. \n" +
                                "\n" +
                                "Spotykana w okresie od lipca do października. Rośnie w lasach liściastych i mieszanych, ale jest związana z obecnością dębów i buków. Rzadsza w pojawach od grzybówki fioletowawej. \n" +
                                "\n" +
                                "Zastosowanie- niejadalna. Trująca. Zaliczana do grzybów halucynogennych. \n".toString();
                        qwe = R.drawable.fioletogrzy;
                        qwe2 = R.drawable.rozowagrzybig;
                        list1 = "Grzybka fioletowawa Mycena pura,".toString();
                        list2 = "mniejsza, częstsza, o fioletowawym zabarwieniu.";
                        jedzenie = R.drawable.trujacy;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.trujacy);
                        break;
                    case 69:
                        TempListViewClickedValue = "Grzybówka ząbkowana Mycena haematopus".toString();
                        TempListViewClickedValue2 = "Kapelusz 1,5-3,5 cm średnicy, 1-2 cm wysokości, dzwonkowaty lub szeroko-stożkowaty, z wyraźnym zaokrąglonym garbkiem na szczycie; barwa blado-szaropurpurowa z ciemniejszymi plamami. Brzeg nierówny, ząbkowany lub kosmkowato postrzępiony. \n" +
                                "\n" +
                                "Powierzchnia  skórki początkowo matowa, w miarę dojrzewania owocnika gładka i wilgotna, hygrofaniczna, delikatnie prążkowana do 2/3 wysokości kapelusza.\n" +
                                "\n" +
                                "Blaszki zatokowato wycięte, w liczbie 20-30, szerokie, nierównej długości, kruche, blado-szaro-fioletowe, u starych okazów z brązowopurpurowymi plamami. Ostrza drobno postrzępione barwy blaszek.\n" +
                                "\n" +
                                "Trzon o wymiarach 4-8 na 0,3-0,5 cm, jędrny, rurkowaty, zwykle wygięty, brązowopurpurowy, o podstawie słabo rozszerzonej, pokrytej beżowymi, rzadkimi ale dość długimi włoskami. Powierzchnia matowa, delikatnie prążkowana, biało oszroniona.\n" +
                                "\n" +
                                "Miąższ kruchy, przesycony sokiem barwy ciemnopurpurowej; bez woni i smaku.\n" +
                                "\n" +
                                "Występuje od lipca do listopada pojedynczo lub wiązkami po kilka owocników na zmurszałym drewnie, głównie na pniakach, opadłych gałęziach i próchniejących kłodach drzew liściastych, jak buk, dąb, olsza, rzadziej na drewnie drzew iglastych, np. świerka.\n" +
                                "\n" +
                                "Podczas suchej pogody może nie wydzielać charakterystycznego krwistego mleczka, ale i wówczas jest łatwa do odróżnienia dzięki oszronionemu trzonowi i strzępiastemu zazwyczaj brzegowi kapelusza. \n".toString();
                        qwe2 = R.drawable.zabkowanabig;
                        jedzenie = R.drawable.niejadalny;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.t7;
                        jadalnosc.setImageResource(R.drawable.niejadalny);
                        break;
                    case 70:
                        TempListViewClickedValue = "Hełmówka błotna Galerina paludosa".toString();
                        TempListViewClickedValue2 = "Kapelusz o średnicy 1-2 cm, szerokodzwonowaty, potem szybko rozpostarty, niekiedy z garbkiem; na brzegu słabo żłobkowany, jedwabisty, higrofaniczny; ochrowożółty, cynamonowożółty, żółtawozielonkawy, miodowożółty, niekiedy z białymi włókienkami na krawędzi. \n" +
                                "\n" +
                                "Blaszki średnio gęste, przyrośnięte albo ciut zbiegające; cynamonowożółte z białawą krawędzią. \n" +
                                "\n" +
                                "Trzon podługowaty, 8-10 cm, cienki, średnicy 0,2-0,3 cm; równy, wyraźnie okrągły; ochrowy, cynamonowożółty, żółtawozielonawy, z delikatnym płatkowatym nalotem o wyglądzie pasków i z resztkami zasnówki. \n" +
                                "\n" +
                                "Miąższ cienki, łamliwy, żółtawy, o słabym przyjemnym zapachu. \n" +
                                "\n" +
                                "Występuje od końca czerwca do połowy września w pobliżu błot, w lasach iglastych i mieszanych, w mchach, rośnie w grupach, nieczęsta. \n" +
                                "\n" +
                                "Zastosowanie – niejadalny\n".toString();
                        qwe2 = R.drawable.heblotnabig;
                        jedzenie = R.drawable.niejadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t7;
                        jadalnosc.setImageResource(R.drawable.niejadalny);
                        break;
                    case 71:
                        TempListViewClickedValue = "Hełmówka jadowita Galerina marginata".toString();
                        TempListViewClickedValue2 = "Kapelusz o średnicy 1-5 cm, początkowo łukowaty, lekko płaski do dzwonkowatego, potem płaski. Barwy ochrowobrązowawej, bursztynowej do czerwonobrązowej. Podczas suchej pogody jasnoochrowy, wilgotny - strefa brzegowa ciemnieje na brązowo lub umbrowobrązowawo. Często dwubarwny. Skórka ściągalna. Kapelusz silnie nasiąkający wodą. Brzeg ostry ze zwisającymi resztkami pokrycia, krawędź przezroczyście żłobkowana.\n" +
                                "\n" +
                                "Blaszki żółtawe do rdzawobrązowawych, łagodnie wybrzuszone, przy trzonie wykrojone ząbkiem i szeroko przyrośnięte, ostrza bledsze.\n" +
                                "\n" +
                                "Trzon początkowo barwy kapelusza, z wiekiem ciemniejszy, wysoki 2-5 cm, gruby do 0,5cm, suchy, pod pierścieniem podłużne włókienka bez łusek.\n" +
                                "\n" +
                                "Pierścień białawy, skórkowaty lub błoniasty, zwisający, nietrwały.\n" +
                                "\n" +
                                "Miąższ pod kapeluszem jasnoochrowy, w trzonie umbrowobrązowy. Smak i zapach mączny.\n" +
                                "\n" +
                                "Zastosowanie - niejadalna. Śmiertelnie trująca !\n" +
                                "\n" +
                                "Występuje często, od lata do jesieni, pojedynczo, częściej w grupach lub małych wiązkach, zwykle na obumarłych pniakach drzew iglastych (świerków i sosen) lub na innych pozostałościach drewna iglastego.\n".toString();
                        qwe = R.drawable.zmienny;
                        qwe2 = R.drawable.jadowitabig;
                        list1 = "Łuszczak zmienny Kuehneromyces mutabilis,".toString();
                        list2 = "poniżej strefy pierścieniowej na trzonie ma łuseczkowatą (a nie włókienkowatą) powierzchnię i występuje na obumarłym drewnie drzew liściastych.";
                        jedzenie = R.drawable.trujacy;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t7;
                        jadalnosc.setImageResource(R.drawable.trujacy);
                        break;
                    case 72:
                        TempListViewClickedValue = "Kępkowiec białawy Lyophyllum connatum".toString();
                        TempListViewClickedValue2 = "Owocnik biały do szarawo-białego; 2-10 cm, półkulisty, potem wypukły z podwiniętym brzegiem, w końcu rozpostarty i zwykle nieregularnie pofałdowany. \n" +
                                "\n" +
                                "Powierzchnia gładka, aksamitna. \n" +
                                "\n" +
                                "Blaszki białe, z wiekiem kremowe do żółtawych, bardzo gęste, wykrojone, ostrze równe. \n" +
                                "\n" +
                                "Trzon biały,  cylindryczny, podstawa zwężająca się i zrośnięta w wiązkę, powierzchnia matowa, podłużnie włókienkowata, u góry oprószona, trzony kilkunastu sąsiednich owocników są zrośnięte podstawami, czasami zrośnięte są także i kapelusze. \n" +
                                "\n" +
                                "Miąższ biały, w kapeluszu cienki, chrząstkowaty, zapach przyjemny, lekko spirytusowy aromatyczny, smak łagodny, przyjemny. \n" +
                                "\n" +
                                "Pospolity. Owocniki wyrastają od późnego lata do jesieni, zwykle w liczących kilkanaście owocników wiązkach, w lasach liściastych i iglastych, często w parkach, ogrodach, na poboczach dróg, wśród trawy i roślinności zielnej, w wilgotnych miejscach. \n" +
                                "\n" +
                                "Zastosowanie – niejadalny. \n".toString();
                        qwe = R.drawable.zrosly;
                        qwe2 = R.drawable.bialawykepbig;
                        list1 = "Podblaszek zrosły Lyophyllum connatum,".toString();
                        list2 = "blaszki ma niekiedy zbiegające i oszroniony kapelusz. Jednak  ma charakterystyczny zapach.";
                        jedzenie = R.drawable.niejadalny;
                        lasy = R.drawable.laka;
                        typgrzyb = R.drawable.t8;
                        jadalnosc.setImageResource(R.drawable.niejadalny);
                        break;
                    case 73:
                        TempListViewClickedValue = "Kępkowiec ciemnoszary Lyophyllum fumosum".toString();
                        TempListViewClickedValue2 = "Kapelusz ciemnoszarobrązowy do jasnoszarobrązowego, ku brzegowi jaśniejszy, początkowo wypukły, z wiekiem płaski, czasem z niewyraźnym garbkiem. Brzeg prosty, ostry.\n" +
                                "\n" +
                                "Powierzchnia naga i gładka. \n" +
                                "\n" +
                                "Blaszki białe od jasnokremowych; szerokie, gęste, szeroko przyrośnięte do wykrojonych i zbiegających ząbkiem.\n" +
                                "\n" +
                                "Trzon białawy, kremowy do jasnobrązowawego, z wiekiem ciemnieje, równogruby, zwykle powyginany, trzony sąsiadujących owocników zrośnięte u podstawy. Powierzchnia gładka, wzdłużnie włókienkowata. Uciśnięty wodniosto brązowieje.\n" +
                                "\n" +
                                "Miąższ białawy, elastyczny, zapach słaby mączny, smak łagodny.\n" +
                                "\n" +
                                "Zastosowanie - jadalny.\n" +
                                "\n" +
                                "Występuje często, w wiązkach po kilkadziesiąt owocników, w widnych lasach, parkach i na trawnikach.\n".toString();
                        qwe = R.drawable.jasnobrazowy;
                        qwe2 = R.drawable.ciemnoszarykapbig;
                        list1 = "Kępkowiec jasnobrązowy Lyophyllum decastes,".toString();
                        list2 = "brak zapachu, jaśniejszy kapelusz, mniej mięsisty miąsz.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.t8;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 74:
                        TempListViewClickedValue = "Kępkowiec jasnobrązowy Lyophyllum decastes".toString();
                        TempListViewClickedValue2 = "Kapelusz 6-15cm średnicy, brązowy do ochrowobrązowego, czasem też jasny, prawie biały. Początkowo półkulisty, z wiekiem wypukły do płaskiego, często z garbkiem. \n" +
                                "\n" +
                                "Powierzchia gładka, z połyskiem, brzeg ostry.\n" +
                                "\n" +
                                "Blaszki białawe, często z czerwonobrązowym do żółtobrązowego odcieniem,  gęste, przyrośnięte, ostrza gładkie.\n" +
                                "\n" +
                                "Trzon białawy do szarawego, równogruby, lub rozszerzony u podstawy, zwykle wygięty, często trzony sąsiednich owocników pozrastane  podstawą. Pełny, elastyczny; powierzchnia wzdłużnie włókienkowata.\n" +
                                "\n" +
                                "Miąższ  biały, elastyczny, w centrum kapelusza gruby i soczysty, w trzonie włóknisty i sprężysty , ku brzegom cienki. Bez zapachu,  smak łagodny, nieokreślony.\n" +
                                "\n" +
                                "Zastosowanie- jadalny.\n" +
                                "\n" +
                                "Niezbyt częsty.  Występuje w zrośniętych grupach. W lasach liściastych i iglastych, w miejscach trawiastych, parkach i rumowiskach  także w wykopach ziemnych i piwnicach.\n".toString();
                        qwe = R.drawable.ciemnoszarykap;
                        qwe2 = R.drawable.jasnobrazowybig;
                        list1 = "Kępkowiec ciemnoszary Lyophyllum fumosum,".toString();
                        list2 = "ma ciemniejszy kapelusz, mączysty zapach i jest bardziej mięsisty;";
                        list13 = "ma ciemniejszy kapelusz i jest chrząstkowaty.";
                        list3 = "Kępkowiec twardoskórkowy Lyophyllum loricatum,";
                        qwe3 = R.drawable.twardoskory;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t8;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 75:
                        TempListViewClickedValue = "Klejek lepki Gomphidius rutilus".toString();
                        TempListViewClickedValue2 = "Owocnik kapelusz miedzianoczerwony, czerwonobrązowy, brązowopomarańczowy, później nieco wyblakły, w czasie deszczu silnie lepki, śluzowaty; suchy - gładki i błyszczący. Młody stożkowaty, wypukły, z charakterystycznym spiczastym garbkiem w środku, z podwiniętym brzegiem, średnicy 4- 10 cm max. do 15 cm, stary spłaszczony, bardzo gruby, mięsisty. Młode grzyby mają między kapeluszem a trzonem zanikającą osnuwkę z cienkich włókien, pod którą początkowo ukryte są blaszki. \n" +
                                "\n" +
                                "Blaszki początkowo różowe, purpurowobrązowe z brudnooliwkowobrązowym odcieniem później ciemno purpurowobrązowe, czerniawe od zarodników, grubawe, rzadkie, często rozwidlone, wyraźnie zbiegające na trzon, łatwo dające się oddzielić od miąższu kapelusza. \n" +
                                "\n" +
                                "Trzon barwy kapelusza lub nieco jaśniejszy, u dołu szafranowożółty, suchy, wysmukły, w dole zwężony, o wysokości 5-12 cm i grubości 1- 2 cm, pełny, mięsisty, bardzo mocny, zwęża się ku podstawie. \n" +
                                "\n" +
                                "Miąższ jaśniejszy przy trzonie, żółtoochrowy, pomarańczowożółty, po naciśnięciu po pewnym czasie przebarwia się karminowo, o łagodnym smaku, bez zapachu. \n" +
                                "\n" +
                                "Występuje w lasach iglastych pod sosnami, chętniej rośnie na glebach wapiennych, od lipca do listopada, dawniej bardzo pospolity, obecnie częsty tylko w niektórych regionach. \n" +
                                "\n" +
                                "Zastosowanie – jadalny.\n".toString();
                        qwe = R.drawable.alpejski;
                        qwe2 = R.drawable.lepkibig;
                        list1 = "Klejek alpejski Chroogomphus Helvetius,".toString();
                        list2 = "ma delikatnie filcowaty, prawie suchy kapelusz i rośnie w górach pod świerkami.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t1;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 76:
                        TempListViewClickedValue = "Klejówka świerkowa Gomphidius glutinosus"+"\n"+"jako Klejówka kleista".toString();
                        TempListViewClickedValue2 = "Owocnik 40-130 mm średnicy, wypukły, o brzegu podwiniętym, z czasem rozpostarty, w części centralnej zagłębiony lub z małym garbkiem, o powierzchni mocno śluzowatej; szary, brudnourpurowy, lilowo-brązowy.\n" +
                                "\n" +
                                "Blaszki zbiegające, rzadko ustawione, grube, rozwidlone, białe, z czasem szare do brązowo-czarnych. Osłona przeświecająca, śluzowata i lepka, niekiedy z lilowym odcieniem, zanikająca.\n" +
                                "\n" +
                                "Trzon o wymiarach 50-100 na 10-20mm, równogruby, pełny, w górnej części białawy, u podstawy wyraźnie cytrynowożółty do rdzawego; w młodym stadium pokryty śluzowatą osłoną, później o powierzchni lepkiej.\n" +
                                "\n" +
                                "Miąższ miękki, biały, w trzonie żółty.\n" +
                                "\n" +
                                "Zapach nieokreślony.\n" +
                                "\n" +
                                "Smak łagodny.\n" +
                                "\n" +
                                "Występuje od lipca do listopada w lasach iglastych i mieszanych, na ziemi – w próchnicy, w sąsiedztwie świerków.\n".toString();
                        qwe = R.drawable.plamistakl;
                        qwe2 = R.drawable.swierkowabig;
                        list1 = "Klejówka plamista Gomphidius maculatus,".toString();
                        list2 = "występująca pod modrzewiami. Różni się barwą kapelusza i pokryta jest ciemnobrązowymi plamami;";
                        list13 = "nie jest śliski i ma owocnik pomarańczowobrązowy do różowofioletowego;";
                        list3 = "Klejek alpejski Chroogomphus Helvetius,";
                        qwe3 = R.drawable.alpejski;
                        list14 = "nie jest śliski i ma czerwonobrązowy kapelusz.";
                        list4 = "Klejek czerwonawy Chroogomphus rutilus,";
                        qwe4 = R.drawable.czerwonykl;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t1;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 77:
                        TempListViewClickedValue = "Kolczak obłączasty Hydnum repandum".toString();
                        TempListViewClickedValue2 = "Owocnik kremowoochrowy do bladopomarańczowego, suchy jaśniejszy, czasem białawy; początkowo wypukły, potem spłaszczony, z wiekiem nierówny, powierzchnia sucha, gładka, młoda zamszowata, brzeg z wiekiem pofałdowany; hymenofor kolczasty, zwykle zbiegający na trzon; kolce początkowo bladożółtawe, potem barwy kapelusza, z wiekiem kruche, łatwo się odłamują. \n" +
                                "\n" +
                                "Trzon centralny, białawy, równogruby lub rozszerzony u podstawy. \n" +
                                "\n" +
                                "Miąższ biały, bladopomarańczowy, kruchy; smak łagodny; zapach przyjemny. \n" +
                                "\n" +
                                "Pospolity. Owocniki wyrastają w dużych grupach, rzadziej pojedynczo, od lipca do października, na ziemi, głównie w lasach iglastych, rzadziej w liściastych. \n" +
                                "\n" +
                                "Zastosowanie - jadalny. \n".toString();
                        qwe = R.drawable.jadalnypie;
                        qwe2 = R.drawable.oblaczastybig;
                        list1 = "Pieprznik jadalny Cantharellus cibarius,".toString();
                        list2 = "brak u niego charakterystycznych kolców pod kapeluszem;";
                        list13 = "jest zabarwiony na pomarańczowobrunatno, występuje w górach.";
                        list3 = "Kolczak rudawy Hydnum rufescens,";
                        qwe3 = R.drawable.rudawykol;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t5;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 78:
                        TempListViewClickedValue = "Kołpaczek mierzwiowy  Panaeolus papilionaceus".toString();
                        TempListViewClickedValue2 = "Kapelusz szarobrunatny, szary, gliniastobrązowy, gładki, z czasem nieco jedwabiście lśniący; na brzegu u młodych egzemplarzy widać ząbkowane resztki białawej osłony częściowej; stożkowato - dzwonkowaty, z wiekiem nie spłaszcza się; 20- 40 mm średnicy. \n" +
                                "\n" +
                                "Blaszki szare, czarno-marmurkowate, w końcu czarne; szerokie, brzuchate, wykrojone i przyrośnięte. \n" +
                                "\n" +
                                "Trzon szaro-czerwono-brunatny, mięsnoczerwonawy; cienki, pusty, równogruby, bardzo wysmukły, 50- 110 na 1- 3 mm, w górnej części nieco oprószony. \n" +
                                "\n" +
                                "Miąższ żółtawy, w kapeluszu znikomy; smak łagodny; bez zapachu lub słaby grzybowy. \n" +
                                "\n" +
                                "Pospolity. Owocniki wyrastają pojedynczo lub w grupach, od maja do późnej jesieni, na łąkach i pastwiskach. \n" +
                                "\n" +
                                "Zastosowanie - niejadalny. \n".toString();
                        qwe = R.drawable.szorstko;
                        qwe2 = R.drawable.motylkowatybig;
                        list1 = "Kołpaczek szorstkozarodnikowy Panaeolous foenisecii,".toString();
                        list2 = "o kapeluszu półkolistym o barwie gliniastej, jest największym i jedynym gatunkiem, który ma pierścień na trzonie;";
                        list13 = "ma powierzchnię kapelusza siateczkowato pomarszczoną;";
                        list3 = "Kołpaczek siatkowany Panaeolous retirugis,";
                        qwe3 = R.drawable.siatkowany;
                        list14 = "o większym i jaśniejszym, często łuskowatym kapeluszu.";
                        list4 = "Kołpaczek motylkowaty Panaeolus papilionaceus,";
                        qwe4 = R.drawable.motylkowatyka;
                        jedzenie = R.drawable.niejadalny;
                        lasy = R.drawable.laka;
                        typgrzyb = R.drawable.t9;
                        jadalnosc.setImageResource(R.drawable.niejadalny);
                        break;
                    case 79:
                        TempListViewClickedValue = "Kopułek łąkowy Camarophyllus pratensis".toString();
                        TempListViewClickedValue2 = "Kapelusz o średnicy 0,5-2,0 cm, u młodych okazów półkulisto sklepiony, po dojrzeniu szeroko rozpostarty, u starszych okazów na szczycie zapadnięty, nieco higrofaniczny, wilgotny, koloru ciemnobrązowego, wysychający żółto-ochrowo-brązowy. \n" +
                                "\n" +
                                "Powierzchnia sucha, matowa lub nieco połyskująca.\n" +
                                "\n" +
                                "Trzon o wymiarach 2-4,5 na 0,2-0,5 cm, ku dołowi zwężający cię, brązowy (w kolorze kapelusza), na powierzchni suchy, gładki, włóknisty, czasem spłaszczony, wewnatrz pusty.\n" +
                                "\n" +
                                "Miąższ białawy, u wilgotnych okazów brązowawy, po wysuszeniu brudnobiały, po przełamaniu nie zmieniający koloru, o smaku łagodnym i słabym nieokreslonym zapachu.\n" +
                                "\n" +
                                "Blaszki szarobrązowe lub brązowe (tylko u młodych okazów białawe), różnej długości, rzadkie, przy trzonie zbiegające, na brzegu gładkie lub wyszczerbione.\n" +
                                "\n" +
                                "Występuje od lipca do października pojedynczo lub w grupach wśród traw na łąkach lub na brzegach lasów, w zaroślach olchowych, często na podłożu wapiennym. \n".toString();
                        qwe = R.drawable.snieznykop;
                        qwe2 = R.drawable.lakowybig;
                        list1 = "Kopułek śnieżny Cuphophyllus virgineus,".toString();
                        list2 = "jest mniejszy i bardziej delikatny;";
                        list13 = "wyrastająca w lasach liściastych (dąb). Kapelusz ma ciemniej brązowo zabarwiony, biały miąższ.";
                        list3 = "Wodnicha gajowa Hygrophorus nemoreus,";
                        qwe3 = R.drawable.gajowa;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.laka;
                        typgrzyb = R.drawable.t8;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 80:
                        TempListViewClickedValue = "Kopułek śnieżny Camarophyllus niveus".toString();
                        TempListViewClickedValue2 = "Kapelusz o średnicy od 2 do 4,5 cm, młody – półkulisty, wypukły, później płaski, a w środku nieco zapadnięty. W wilgotnych warunkach bladożółty do wodnistobiałego, nieco lepki, w czasie suszy śnieżnobiały.\n" +
                                "\n" +
                                "Blaszki rzadkie, zbiegające po trzonie, u podstawy szerokie, w ostrzu cienkie, wodniste, białożółtawe.\n" +
                                "\n" +
                                "Trzon o wysokości od 1,5 do 4,5 cm, średnica od 3 do 5 mm, równogruby, ku podstawy zwężony i spłaszczony, początkowo pełny, później pusty, kolor biały, czasami z różowym nalotem.\n" +
                                "\n" +
                                "Miąższ wodnistobiały, brak zapachu, smak łagodny.\n" +
                                "\n" +
                                "Zastosowanie - jadalny. \n".toString();
                        qwe2 = R.drawable.snieznybig;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.t8;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 81:
                        TempListViewClickedValue = "Koralówka gruba Ramaria largentii".toString();
                        TempListViewClickedValue2 = "Owocnik bogato rozgałęziony, dochodzi do 17 cm wysokości. Intensywnie żółty lub pomarańczowożółty, w miejscach skaleczeń oraz na końcach gałązek cytrynowożółty. Gałęzie bardzo gęsto ustawione, bogato rozczłonowane, z wiekiem kończą się krótkimi, tępymi i zębatymi lub wyglądającymi jak ułamane czubkami.\n" +
                                "\n" +
                                "Trzon mocny, u podstawy białawy, a przy przejściu w dolną, w górną gałąź jest przeważnie żółty.\n" +
                                "\n" +
                                "Miąższ brudnobiaławy, pod hymenoforem. Zapachem przypomina gumę, lub też zapach gabinetu dentystycznego.\n" +
                                "\n" +
                                "Rośnie od sierpnia do września. Często spotykany w górskich lasach świerkowych, na glebach zawierających wapń; w Alpach nierzadki.\n" +
                                "\n" +
                                "Zastosowanie – za młodu jadalny. \n" +
                                "\n" +
                                "Gatunki koralówek są cieżkie do rozróżnienia.\n".toString();
                        qwe2 = R.drawable.grubabig;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.def2;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 82:
                        TempListViewClickedValue = "Koralówka strojna  Ramaria formosa".toString();
                        TempListViewClickedValue2 = "Owocnik wysokości 8-20 cm i 6-16 cm szerokości, u podstawy mięsisty pień 2-4cm grubości, rozdzielający się na mniejsze rozgałęzienia i mniejsze gałązki. Zakończenia ząbkowane lub rozwidlone. Dolna część bladoochrowa, rozgałęzienia żółtoochrowe lub żółtoczerwone, zakończenia cytrynowożółte. \n" +
                                "\n" +
                                "Miąższ za młodu różowawy, z wiekiem biały, zapach grzybowy smak gorzki. \n" +
                                "\n" +
                                "Występuje rzadko, w lasach liściastych szczególnie bukowych. \n" +
                                "\n" +
                                "Zastosowanie – niejadalny, trujący. \n".toString();
                        qwe2 = R.drawable.strojnabig;
                        jedzenie = R.drawable.niejadalny;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.def2;
                        jadalnosc.setImageResource(R.drawable.niejadalny);
                        break;
                        case 83:
                        TempListViewClickedValue = "Koralówka złocista  Ramaria aurea".toString();
                        TempListViewClickedValue2 = "Owocnik- u podstawy białawy, częściowo rosnący pod ziemią 5-13 cm wysoki i 5-8 cm szerokości . Od podstawy rozdzielających się wiele nieregularnych grubości gałązek . Młode barwy jasnożółtych potem żółtoochrowe. Zakończenia gałązek cienkie i z 2 lub 3 ząbkami. \n" +
                                "\n" +
                                "Miąższ- twardy, białawy, kremowobiaławy, pod skórką żółtawy, bladawy delikatny o przyjemnym  smaku i korzennym zapachu. \n" +
                                "\n" +
                                "Występuje rzadko, od sierpnia do października w lasach mieszanych. \n" +
                                "\n" +
                                "Zastosowanie- niejadalna. Starsze owocniki są trujące.\n".toString();
                        qwe2 = R.drawable.zlocistabig;
                            jedzenie = R.drawable.niejadalny;
                            lasy = R.drawable.mieszany;
                            typgrzyb = R.drawable.def2;
                            jadalnosc.setImageResource(R.drawable.niejadalny);
                            break;
                    case 84:
                        TempListViewClickedValue = "Koronica ozdobna  Sarcosphaera coronaria".toString();
                        TempListViewClickedValue3 = "Gatunek objęty ochroną częściową w Polsce! ".toString();
                        TempListViewClickedValue2 = "Owocnik początkowo podziemny lub częściowo na powierzchni, kulisty. Dojrzewając stopniowo pęka do połowy owocnika na 4 do 10 trójkątnych płatków. I wystaje nad powierzchnie gleby. W końcowym stadium przybiera formę gwiaździstą, 3-20cm średnicy. Wnętrze początkowo białawe, potem fioletowe, z czasem blednie do jasnegobrązu, gładkie. Zewnętrzna powierzchnia szarobiaława, w początkom stadium z fioletowym odcieniem. \n" +
                                "\n" +
                                "Miąższ- biały, kruchy. \n" +
                                "\n" +
                                "Występuje rzadko, choć miejscami owocniki występują w większej ilości zwłaszcza w górach. Owocniki pojawiają się wiosną, pojedynczo lub w grupach, preferuje lasy mieszane, na wapiennym podłożu. \n" +
                                "\n" +
                                "Zastosowanie- trujący\n".toString();
                        qwe2 = R.drawable.ozdobnabig;
                        jedzenie = R.drawable.trujacy;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.def2;
                        jadalnosc.setImageResource(R.drawable.trujacy);
                        break;
                    case 85:
                        TempListViewClickedValue = "Koźlarz babka Leccinum scabrum".toString();
                        TempListViewClickedValue2 = "Owocnik od 30 do 200 mm średnicy. W szerokiej gamie barw - od jasnoorzechowej od ciemnobrązowej, szarawej, orzechowej po szarobrązową Początkowo w kształcie półkulisty, potem wypukły do poduszkowatego. Powierzchnia sucha, jedwabista, gładka, lub niekiedy drobno kosmkowata, połyskliwa. Słabo śluzowata, w porze wilgotnej. Skórka nie oddziela się od miąższu. \n" +
                                "\n" +
                                "Pory w barwie białawe, żółtawe, z wiekiem ochrowoszarawe. Drobne, okrągłe. \n" +
                                "\n" +
                                "Rurki w kolorze białawe, potem szarobrązowe, szare. Niezmienne. Długości od 10 do 25 mm. Przy trzonie głęboko wycięte. Wolne i oddzielające się od siebie. Łatwo oddzielające się od miąższu. \n" +
                                "\n" +
                                "Trzon długości od 80 do 200 mm. Grubość od 10 do 35 mm. W kolorze jest barwy białawej lub jasnożółtwej. U podstawy bywa nieco zielonkawy. Na zasadniczym tle usiany, ciemniejszymi ochrowobrązowawymi lub czarnymi łuseczkami. Pod kapeluszem niekiedy z siateczką. Powierzchnia wzdłużnie bruzdowana. Włókienka podłużne. Cylindryczny i smukły lub w maczugowaty, zwężający się ku szczytowi, a u podstawy rozszerzony. Często wygięty. Pełny. \n" +
                                "\n" +
                                "Miąższ w kapeluszu barwy białawej. W trzonie białawy, niekiedy zielonkawobiaławy lub żółtawy u podstawy. Powierzchnia cięcia u niektórych owocników niebieszczeje i powoli ponownie blednie. U młodych egzemplarzy zwarty, twardy, elastyczny, z wiekiem mięknie. W kapeluszu grubomięsisty, z wiekiem wodnisty. W trzonie włóknisty, łykowaty, z wiekiem drzewnieje. Zapach przyjemny. Smak łagodny, przyjemny. \n" +
                                "\n" +
                                "Bardzo pospolity. Zasięg tego grzyba związany jest z występowaniem brzozy (brodawkowata, omszona i gatunki introdukowane), z którą tworzy mikoryzę. Owocniki wyrastają od lipca do listopada. Występuje pojedynczo lub w grupach po kilka, w lasach liściastych i mieszanych. \n".toString();
                        qwe = R.drawable.zolciowy;
                        qwe2 = R.drawable.babkabig;
                        list1 = "Goryczak żółciowy Tylopilus felleus,".toString();
                        list2 = "gorzki smak i jest niejadalny;";
                        list13 = "rośnie on tylko pod grabami i jego miąższ po uszkodzeniu barwi się na kolor od brudnoróżowego do czarniawego;";
                        list3 = "Koźlarz grabowy Leccinum pseudoscabrum,";
                        qwe3 = R.drawable.grabowy;
                        list14 = "rośnie na bardziej wilgotnych miejscach;";
                        list4 = "Koźlarz różnobarwny Leccinum variicolor, ";
                        qwe4 = R.drawable.roznobarwny;
                        list15 = "występuje na wrzosowiskach, ma bardzo jasne, niemal białe ubarwienie.";
                        list5 = "Koźlarz białawy Leccinum holopus,";
                        qwe5 = R.drawable.bialawykoz;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t1;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 86:
                        TempListViewClickedValue = "Koźlarz białawy Leccinum holopus".toString();
                        TempListViewClickedValue2 = "Kapelusz  2-7cm średnicy, barwy białawej z niebieskawym lub szaro zielonym. Początkowo w kształcie półkulisty, potem wypukły do poduszkowatego, spłaszczonego. Powierzchnia sucha, jedwabista, gładka, aksamitna\n" +
                                "\n" +
                                "Pory w barwie rurek. Okrągłe i drobne\n" +
                                "\n" +
                                "Rurki młode  barwy białawej, potem szarozielonkawe, niezmienne\n" +
                                "\n" +
                                "Trzon barwy białawej. Na  tle usiany początkowo białymi, a następnie ochrowobrązowawymi kosmkam. Cylindryczny. Zwężający się ku szczytowi, a u podstawy nieco rozszerzony. Często wygięty. Pełny. \n" +
                                "\n" +
                                "Miąższ białawy, niekiedy z zielonkawobiaławym zabarwieniem. W zasadzie niezmienny, z wyjątkiem zielenienia w trzonie. Miękki. W kapeluszu grubomięsisty, z wiekiem wodnisty. W trzonie łykowaty. Zapach i smak grzybowy.\n" +
                                "\n" +
                                "Występuje rzadko, w mchach, lub  terenach wilgotnych. Pojedynczo  lub w grupach. Rośnie od lipca do października pod brzozami.\n" +
                                "\n" +
                                "Zastosowanie- jadalny.\n".toString();
                        qwe2 = R.drawable.bialawybig;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.t1;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 87:
                        TempListViewClickedValue = "Koźlarz dębowy Leccinum quercinum".toString();
                        TempListViewClickedValue2 = "Owocnik 4-18cm średnicy, barwy rdzawobrązowej, brązowoczerwonej brązowoomarańczowy. Młody kulisty, potem półkolisty, z wiekiem poduszkowaty, grubomięsisty. Skórka wystająca poza brzeg kapelusza. W czasie suchej pogody filcowaty, matowy. W okresie deszczowym nieco lepki. \n" +
                                "\n" +
                                "Rurki 15-35mm długości, białawe do brudnoochrawych lub skórzastobrązowawe z wiekiem jeszcze bardziej ciemniejace. Na przekroju wybarwiają sie fioletowo. \n" +
                                "\n" +
                                "Pory drobne, okrągłe. Młode białawe, często z szarawym odcieniem później śmietankowożółte. \n" +
                                "\n" +
                                "Trzon młody rozdęty, potem maczugowaty lub cylindryczny, u góry zwężony, u podstawy zgrubiały. Początkowo gładki, brązowoczerwonawy, pokryty początkowo białymi potem brazowoczerwonymi do czerniawoczarnych drobnymi łuseczkami. W miejscach ugniecenia staje się czerwonawy do niebieskozielonawego. \n" +
                                "\n" +
                                "Miąższ biały, po przekrojeniu najpierw czerwienieje, później staje się fioletowoszarawy do czarnego. Zapach słaby, smak delikatny, przyjemny. \n" +
                                "\n" +
                                "Występowanie na terenach podgórskich i górskich, pod dębami \n" +
                                "\n" +
                                "Zastosowanie- jadalny.\n".toString();
                        qwe = R.drawable.pomaranczowozolty;
                        qwe2 = R.drawable.debowybig;
                        list1 = "Koźlarz pomarańczowożółty Leccinum versipelle,".toString();
                        list2 = "jest jaśniejszy i rośnie pod brzozami. Najłatwiej odróżnić go po czarnych łuseczkach na trzonie;";
                        list13 = "rośnie tylko pod sosnami;";
                        list3 = "Koźlarz sosnowy Leccinum vulpinum,";
                        qwe3 = R.drawable.sosnowykoz;
                        list14 = "rośnie tylko pod świerkami.";
                        list4 = "Koźlarz świerkowy Leccinum piceinum,";
                        qwe4 = R.drawable.swierkowykoz;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.t1;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 88:
                        TempListViewClickedValue = "Koźlarz grabowy Leccinum griseum".toString();
                        TempListViewClickedValue2 = "Owocnik średnicy 4-12 cm; żółtawozielonkawy, szarooliwkowy, brązowooliwkowy, niekiedy całkiem brązowy lub prawie czarny, zwłaszcza za młodu z typowymi zmarszczkami, wgłębieniami; podczas suchej pogody często spękany na poletka, początkowo półkolisty, potem poduszkowaty, rzadko płasko rozpostarty. \n" +
                                "\n" +
                                "Rurki białawe, od szarawych do oliwkowobrązowych, po uszkodzeniu barwiące się; najpierw na fioletowoszaro, potem na czarno; długości do 3 cm, przy trzonie głęboko zatokowo wycięte, pory drobne, szarawe, białawe, szarożółte, potem oliwkowoszarawe, po dotknięciu szarzejące i czerniejące. \n" +
                                "\n" +
                                "Trzon białawoszary, szorstki z powodu szeregowo ułożonych ciemniejszych łuseczek, twardy, wysmukły. \n" +
                                "\n" +
                                "Miąższ białawy, na przekroju przebarwia się na szarofioletowo lub czarnofioletowo. \n" +
                                "\n" +
                                "Dość częsty, ciepłolubny. Owocniki wyrastają pod grabami, od początku lata, głównie w wilgotnych i cienistych lasach dębowo-grabowych i lipowo-grabowych. \n" +
                                "\n" +
                                "Zastosowanie - jadalny. \n".toString();
                        qwe = R.drawable.babka;
                        qwe2 = R.drawable.grabowybig;
                        list1 = "Koźlarz babka Leccinum scabrum,".toString();
                        list2 = "odróżnia się niezmiennym miąższem i występowaniem wyłącznie pod brzozami.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.t1;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 89:
                        TempListViewClickedValue = "Koźlarz pomarańczowożółty Leccinum versipelle".toString();
                        TempListViewClickedValue2 = "Kapelusz w kolorze pomarańczowożółty, pomarańczowobrązowy lub ceglastopomarańczowy do orzechowopomarańczowego. Pod wpływem działania promieni słonecznych ulega różnorakim wybarwieniom i płowieniu. Bardzo młody owocnik w kształcie kulisty, póżniej półkolisty, wypukły i poduszkowaty. średnica od 40 do 180 mm. Powierzchnia delikatnie zamszowata w porze suchej i delikatnie oślizła w porze wilgotnej. Skórka u młodych owocników lekko podwinięta i wystaje poza brzeg. \n" +
                                "\n" +
                                "Pory w barwie szarawe z oliwkowym odcieniem. Z wiekiem szarzejące, z żółtawym przebarwieniem. Drobne. Okrągławe. \n" +
                                "\n" +
                                "Rurki w kolorze białawe z jasnoszarym lub oliwkowoszarym odcieniem. Wycięte przy trzonie. Długości 7 do 30 mm. \n" +
                                "\n" +
                                "Trzon w kolorze jest biały lub szary. Powierzchnia pokryta drobnymi czarnymi kosmkami, o mniejszym lub bardzo dużym ich nasileniu. Z wiekiem mogą brunatnieć. Może być wzdłużnie bruzdowana. Długość od 60 do 180 mm. Grubość od 20 do 60 mm. Osadzony centrycznie w kapeluszu. Może być cylindryczny, równogruby lub gruby, odwrotnie maczugowaty. Stopniowo zwężający się ku górze. Powierzchnia podstawy trzonu przy otarciu może się przebarwiać. \n" +
                                "\n" +
                                "Miąższ w barwie biały. W wyniku uszkoszeń, cięcia i uciskania, przebarwiający się różowofioletowo, zielonkawoniebiesko, a następnie czerniejący. W masie zwarty, serowaty i jędrny, gdy młody i nieco watowaty, gdy starszy. Smak nieznaczny, przyjemny. Zapach grzybowy. \n" +
                                "\n" +
                                "Pospolity. Spotykany od lata do jesieni w pobliżu brzóz, z którymi tworzy mikoryzę. \n" +
                                "\n" +
                                "Zastosowanie – jadalny.\n".toString();
                        qwe = R.drawable.czerwonykoz;
                        qwe2 = R.drawable.pomaranczowybig;
                        list1 = "Kożlarz czerwony Leccinum aurantiacum,".toString();
                        list2 = "o ceglastoczerwonym zabarwiony kapelusz i początkowo białych łuseczkach na trzonie, które z wiekiem brązowieją; rośnie w towarzystwie topoli i osiki.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.t1;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 90:
                        TempListViewClickedValue = "Koźlarz świerkowy Leccinum piceinum".toString();
                        TempListViewClickedValue2 = "Kapelusz 3-9 cm średnicy, początkowo wypukły, potem poduszkowaty, rdzawy z pomarańczowym odcieniem, brązowordzawy, przy brzegu bywa bardziej czerwonawy, filcowaty \n" +
                                "\n" +
                                "Rurki 4-12 mm długie, za młodu białe, potem szarawe, pory trochę ciemniejsze z szarobrązowym odcieniem. \n" +
                                "\n" +
                                "Trzon 8-13 cm długości i 1,5-2,5 cm grubości, cylindryczny, w dolnej części zgrubiały, pod kapeluszem cieńszy. Biały, cały pokryty drobnymi łuseczkami. Za młodu w górnej części, białe, w dolnej czerwonawe, brązowawoczerwonawe, w końcu umbrowobrązowe lub czerwone. Trzon uszkodzony przy podstawie wybarwia się zielono. \n" +
                                "\n" +
                                "Miąższ biały z delikatnym śmietankowokremowym odcieniem. Na przekroju barwi się na szaroróżowo, szczególnie w górnej części trzonu, najmniej w kapeluszu. \n" +
                                "\n" +
                                "Występuje w lecie i jesieni, w lasach świerkowych. \n".toString();
                        qwe = R.drawable.debowy;
                        qwe2 = R.drawable.swierkowybig;
                        list1 = "Koźlarz dębowy Leccinum quercinum,".toString();
                        list2 = "rośnie pod dębami, topolami i osiekami;";
                        list13 = "brązowiejące łuski na trzonie;";
                        list3 = "Koźlarz pomarańczowożółty Leccinum versipelle,";
                        qwe3 = R.drawable.pomaranczowozolty;
                        list14 = "rośnie pod sosnami.";
                        list4 = "Koźlarz sosnowy Leccinum vulpinum,";
                        qwe4 = R.drawable.sosnowykoz;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t1;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 91:
                        TempListViewClickedValue = "Koźlarz topolowy Leccinum duriusculum".toString();
                        TempListViewClickedValue2 = "Owocnik średnicy 40-150 mm, wypukły, finalnie szczyt lekko spłaszczony; bardzo zmienny w kolorze, od dość bladego szarobrązowego z delikatnym fioletowym odcieniem do ciemnego szarego lub czerwonawobrązowego; cały pokryty znikomymi filcowatymi włókienkami, ew. bardzo nikłymi łuseczkami, często z wiekiem drobno spękany w bardzo małe filcowate łatki, które początkowo ubarwione identycznie jak tło, z wiekiem zaczynają kontrastować z jaśniejszym tłem. \n" +
                                "\n" +
                                "Rurki wąsko przyrośnięte do prawie wolnych, do 25mm długości, kremowobiałe, później szarawe, pory okrągłe 0,3-0,5mm średnicy, pod naciskiem brązowiejące. \n" +
                                "\n" +
                                "Trzon o wymiarach 80-170 na 14-20 mm, cylindryczny, lekko zbieżysty na szczycie, z walcowatą do maczugowatej podstawą; biały z podłużnymi czarnymi kosmkami; podstawa po uszkodzeniu przebarwia się na żółtozielono lub niebieskozielono. \n" +
                                "\n" +
                                "Miąższ biały, po przecięciu powoli przebarwiający się na fioletoworóżowo. \n" +
                                "\n" +
                                "Występuje głównie pod osikami, ale również pod innymi topolami; na wapiennych glinach, czasami na piaskach i iłach; od lipca do października.\n".toString();
                        qwe = R.drawable.babka;
                        qwe2 = R.drawable.topolowybig;
                        list1 = "Koźlarz babka Leccinum scabrum,".toString();
                        list2 = "nie ma zielonego odcienia na podstawie trzonu, występuje pod brzozami.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.t1;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 92:
                        TempListViewClickedValue = "Krowiak podwinięty Paxillus involutus".toString();
                        TempListViewClickedValue2 = "Kapelusz o średnicy 5-16cm, początkowo łagodnie łukowaty z widocznym podwiniętym brzegiem, z wiekiem płasko rozłożysty w środku zapadnięty brzeg stalepodwinięty. Powierzchnia barwy szaro-żółtobrązowo, oliwkowobrązowa, uszkodzona ciemnobrązowo cętkowana. Młody delikatnie pilśniowy, z wiekiem łysy, wilgotny śliski i lepki, suchy z jedwabistym połyskiem.\n" +
                                "\n" +
                                "Blaszki młode kremowe potem ochrowobrązowe do rdzawobrązowych, zbiegające, gęste i cienkie, u młodych owocników mocno pofalowane, zbiegające na trzon, uszkodzone brązowieją, łatwo dają się oddzielić od miąższu.\n" +
                                "\n" +
                                "Trzon gruby, walcowaty, krępy, twardy i pełny, nagi, brudnawożółty do rdzawobrązowego, uszkodzony brązowieje. 3-7cm wysoki i 1-2 cm gruby.\n" +
                                "\n" +
                                "Miąższ soczysty, miękki żółtawy, brązowiejący; w kapeluszu gruby; smak i zapach kwaskowate.owocowe.\n" +
                                "\n" +
                                "Zastosowanie- niejadalny, trujący.\n" +
                                "\n" +
                                "Bardzo pospolity, występuje gromadnie w lasach liściastych i iglastych, w parkach, zwykle na ziemi.\n".toString();
                        qwe = R.drawable.olszowykr;
                        qwe2 = R.drawable.podwinietybig;
                        list1 = "Krowiak olszowy Paxillus filamentosus,".toString();
                        list2 = "łuskowaty kapelusz i rośnie tylko pod olszami.";
                        jedzenie = R.drawable.trujacy;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t5;
                        jadalnosc.setImageResource(R.drawable.trujacy);
                        break;
                    case 93:
                        TempListViewClickedValue = "Kurzawka czerniejąca Bovista nigrescens".toString();
                        TempListViewClickedValue2 = "Owocnik kulisty średnicy 1,5-5cm, młody biały, starszy po odpadnięciu okrywy zewnętrznej, pergaminowa błyszcząca, brązowoczarna okrywa wewnętrzna, która otwiera się nieregularnym otworem, wnętrze wypełnione zarodnikami. \n" +
                                "\n" +
                                "Występuje często w górach, na łąkach, pastwiskach bogatych w składniki mineralne, od lata do jesieni , gromadnie. Stare owocniki pozostają do następnego roku. \n" +
                                "\n" +
                                "Zastosowanie- jadalny, tylko białe młode owocniki. \n".toString();
                        qwe = R.drawable.aksamitnakru;
                        qwe2 = R.drawable.czerniejacabig;
                        list1 = "Kruchawica aksamitna Lacrymaria lacrymabunda,".toString();
                        list2 = "matowa, szaroczarna powierzchnia.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.laka;
                        typgrzyb = R.drawable.def4;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 94:
                        TempListViewClickedValue = "Lakówka ametystowa Laccaria amethystina".toString();
                        TempListViewClickedValue2 = "Kapelusz o średnicy 2-6 cm, u młodych okazów półkulisty lub dzwonkowaty z podwiniętym brzegiem i wgłębieniem na środku, u starszych staje się łukowaty, w końcu płaski i lejkowaty o pofałdowanych brzegach. \n" +
                                "\n" +
                                "Skórka gładka, u dorosłych okazów delikatnie płatowata i o lekko żłobionych brzegach. W czasie wilgotnej pogody ma kolor fioletowy lub brązowofioletowy, w czasie suchej, lub u starszych okazów białawofioletowawy.\n" +
                                "\n" +
                                "Blaszki grube, rzadkie, często pofalowane. Są szeroko przyrośnięte do trzonu lub nieco tylko zbiegające. U młodych okazów fioletowe, później oprószone białawo zarodnikami. Nawet gdy owocniki są wyblaknięte, ich blaszki pozostają fioletowe.\n" +
                                "\n" +
                                "Trzon wysokości 3-12 cm i grubości 3-10 mm, pusty w środku, włóknisty, dołem nieco zgrubiały. Kolor taki sam, jak kapelusza.\n" +
                                "\n" +
                                "Miąższ wodnisty, w czasie wilgotnej pogody lekko fioletowy, w czasie suchej różowobrązowawy, o niewyraźnym zapachu i smaku.\n" +
                                "\n" +
                                "Rośnie w lasach, ogrodach, parkach na spróchniałym drewnie lub na ziemi, pod drzewami liściastymi, iglastymi, najczęściej jednak pod drzewami z rzędu bukowców. \n" +
                                "\n" +
                                "Zastosowanie- jadalny, niezbyt smaczny\n".toString();
                        qwe = R.drawable.fioletowawagrzy;
                        qwe2 = R.drawable.ametystowabig;
                        list1 = "Grzybówka fioletowawa Mycena pura,".toString();
                        list2 = "mniej smukły owocnik i charakterystyczny zapach rzodkiewki lub rzepy;";
                        list13 = "różni się garbkiem na kapeluszu i nieprzyjemnym zapachem.";
                        list3 = "Strzępiak ziemistoblaszkowy Inocybe geophylla,";
                        qwe3 = R.drawable.ziemiastoblasz;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.laka;
                        typgrzyb = R.drawable.t9;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 95:
                        TempListViewClickedValue = "Lakówka pospolita Laccaria laccaria".toString();
                        TempListViewClickedValue2 = "Kapelusz o średnicy 2-5cm, barwy brazowoczerwonej mniej lub bardziej pomarańczowawy, ochrowy, powierzchnia początkowo gładka potem pokryta drobnymi łuseczkami , kapelusz półkulisty z podwiniętym brzegiem, rozpościerający się do płaskiego, z niedużym wklęśnięciem w centrum, brzeg pofałdowany.\n" +
                                "\n" +
                                "Blaszki barwy kapelusza suche bardziej jaśniejsze, dość grube rzadko ustawione, przy trzonie przyrośnięte zaokrąglone zbiegające ząbkiem.\n" +
                                "\n" +
                                "Trzon barwy kapelusza lub ciemniejszy, czerwonobrązowy, równogruby, czasem wygięty, skręcony lub spłaszczony, smukły, u podstawy białawy, twardy, długowłóknisty, pełny, u podstawy z białawą grzybnią.\n" +
                                "\n" +
                                "Miąższ jaśniejszy od barwy kapelusza, niezmienny, smak łagodny, zapach słaby rzodkwi. \n" +
                                "\n" +
                                "Zastosowanie – jadalna.\n" +
                                "\n" +
                                "Pospolita, od lata do późnej jesieni w lasach wszelkiego typu.\n".toString();
                        qwe = R.drawable.okazala;
                        qwe2 = R.drawable.pospolitalekbig;
                        list1 = "Lakówka okazała Laccaria proxima,".toString();
                        list2 = "znacznie większa, rosnąca w wilgotnych lasach iglastych, z łuseczkowatym kapeluszem.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t9;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 96:
                        TempListViewClickedValue = "Lejkoporek olszowy Gyrodon lividus".toString();
                        TempListViewClickedValue2 = "Owocnik o średnicy 4-20 cm, piaskowożółty, u starszych okazów z rdzawym odcieniem, jedwabisty, nieco zamszowy lub prawie gładki, suchy, jedynie podczas deszczów lepki. \n" +
                                "\n" +
                                "Pory żółtooliwkowe, uciśnięte sinieją, potem brązowieją, nieregularne, labiryntowate. \n" +
                                "\n" +
                                "Trzon barwy kapelusza, o wymiarach 3-7 cm na 8-15 mm, cylindryczny, zwężający się ku podstawie, pełny. \n" +
                                "\n" +
                                "Miąższ kremowy, przecięty słabo siniejący, konsystencja gąbczasta, zapach słaby, smak kwaśny. \n" +
                                "\n" +
                                "Rośnie od sierpnia do października, pod olszami, na bagnach i torfowiskach, na brzegach stawów i strumieni, w wilgotnych miejscach w lasach; stosunkowo rzadki.\n" +
                                "\n" +
                                "Zastosowanie - jadalny.\n".toString();
                        qwe2 = R.drawable.olszowylejbig;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.t5;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 97:
                        TempListViewClickedValue = "Lejkowiec dęty Craterellus cornucopioides".toString();
                        TempListViewClickedValue2 = "Owocnik lejkowaty do trąbkowatego, pusty do spodu; 4-13 cm wysokości i 2-5 cm średnicy; cienkomięsisty; brzeg wywinięty, pofałdowany; strona wewnętrzna czarna, czarnobrązowa, łuseczkowato-gruczołkowata, natomiast strona zewnętrzna z hymenoforem jest szara do niebieskoszarej, gładka, pomarszczona i pofałdowana, z wiekiem biało oprószona przez zarodniki. \n" +
                                "\n" +
                                "Miąższ - cienki, szarobrązowy, czarniawy, kruchy; zapach aromatyczny, przyjemny; smak łagodny. \n" +
                                "\n" +
                                "Występuje często. Owocniki wyrastają od lata do jesieni, zwykle w dużych grupach składających się z pozrastanych ze sobą owocników, w lasach liściastych, często pod bukami. \n" +
                                "\n" +
                                "Zastosowanie - jadalny. \n".toString();
                        qwe2 = R.drawable.detylejbig;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.t5;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 98:
                        TempListViewClickedValue = "Lejkówka biaława Leucocybe candicans ".toString();
                        TempListViewClickedValue2 = "Kapelusz o średnicy 2-5cm, wypukły, łukowaty, z wiekiem prosto rozpostarty, środkiem płytko wgłębiony, na starość lejkowaty. Młody barwy białawej do brudnobiaławej. Mokry z namoczonymi kuliście cętkami, na starość lekko ceglasty. Powierzchnia delikatnie włóknista, pilśniowa jedwabiście błyszcząca.\n" +
                                "\n" +
                                "Blaszki białawe, szeroko przyrośnięte zbiegające ząbkiem, szerokie.\n" +
                                "\n" +
                                "Trzon białawy, oszroniony jak kapelusz, walcowaty, często powyginany, dołem szerszy i sprężysty. Z wiekiem pusty.\n" +
                                "\n" +
                                "Miąższ białawy, smak nie określony, zapach delikatnie słodkawokwaśny.\n" +
                                "\n" +
                                "Zastosowanie- niejadalny, lekko trujący.\n" +
                                "\n" +
                                "Występuje gromadnie w lasach liściastych pod bukami i dębami. W miejscach trawiastych , ogrodach i pastwiskach.\n".toString();
                        qwe = R.drawable.jadowitalej;
                        qwe2 = R.drawable.bialawalejbig;
                        list1 = "Lejkówka jadowita Clitocybe rivulosa,".toString();
                        list2 = "ma oszroniony kapelusz, a na jego powierzchni koncentrycznie ułożone mięsisto-kremowe plamy;";
                        list13 = "jest większa, blaszki słabo zbiegają i nie ma przebarwień na kapeluszu.";
                        list3 = "Lejkówka liściowa Clitocybe phyllophila,";
                        qwe3 = R.drawable.lisciowa;
                        jedzenie = R.drawable.trujacy;
                        lasy = R.drawable.laka;
                        typgrzyb = R.drawable.t9;
                        jadalnosc.setImageResource(R.drawable.trujacy);
                        break;
                    case 99:
                        TempListViewClickedValue = "Lejkówka buławotrzonowa Clitocybe claviceps".toString();
                        TempListViewClickedValue2 = "Owocnik higrofaniczny, wilgotny szarobrązowy do oliwkowoszarego, suchy bladoochrowy; 4-8 cm średnicy; początkowo wypukły, zazwyczaj z wyraźnym garbkiem, potem płaski, w końcu wklęsły, płytko lejkowaty. \n" +
                                "\n" +
                                "Powierzchnia gładka, sucha; brzeg kapelusza ostry, prążkowany. \n" +
                                "\n" +
                                "Blaszki młode białawe, potem żółtawe, zbiegające, szerokości 2-7 mm, z międzyblaszkami i czasem rozwidlone. \n" +
                                "\n" +
                                "Trzon białoszary, nieco jaśniejszy od kapelusza, o wymiarach 40-80 na 5-15 mm, przy nasadzie maczugowato zgrubiały i przerośnięty z podłożem białą grzybnią, powierzchnia sucha, włóknista. \n" +
                                "\n" +
                                "Miąższ biały, wodnisty, niezmienny, miękki, bez wyraźnego smaku czy zapachu. \n" +
                                "\n" +
                                "Pospolity. Rośnie w lasach iglastych, rzadziej liściastych i na brzegu lasu od sierpnia do listopada. W grupach, czarcich kręgach. \n" +
                                "\n" +
                                "Zastosowanie – jadalna.\n".toString();
                        qwe = R.drawable.szarawalej;
                        qwe2 = R.drawable.bulawotrzonbig;
                        list1 = "Lejkówka szarawa Clitocybe nebularis,".toString();
                        list2 = "jest większa i ma miąższ bardziej twardy i kwaskowaty. Jej blaszki przez potarcie palcem łatwo oddzielają się od kapelusza;";
                        list13 = "jej starsze okazy też mają podwinięty brzeg kapelusza, ponadto jest on pofałdowany. Zazwyczaj nie posiada garbu i ma odcienie bardziej brązowoczerwonawe.";
                        list3 = "Lejkówka karbowana Clitocybe costata,";
                        qwe3 = R.drawable.karbowana;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t9;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 100:
                        TempListViewClickedValue = "Lejkówka liściowa Clitocybe phyllophila".toString();
                        TempListViewClickedValue2 = "Kapelusz o średnicy 3-8cm, wypukły z wiekiem płaski i nieco wklęsły do rozpostartego. Brzeg powyginany i podwinięty. Barwy bladoczerwonawobrązowawej, brzegiem ciemniejszy.\n" +
                                "\n" +
                                "Blaszki barwy białawej z wiekiem kremowe na starość brudnożółte. Dość gęste i bardzo wąskie, poprzedzielane blaszeczkami, słabo zbiegające.\n" +
                                "\n" +
                                "Trzon białawy do brudnoochrawego, walcowaty lub skręcony. Postawa czasami zgrubiała, silnie przerośnięta do podłoża białą filcowatą grzybnią, młody pełny, z wiekiem pusty lub watowaty.\n" +
                                "\n" +
                                "Miąższ biały lub brudnobiały , cienki i sprężysty, twardy; zapach aromatyczny lekko anyżkowy. Smak łagodny, nieokreślony.\n" +
                                "\n" +
                                "Zastosowanie- śmiertelnie trująca!\n" +
                                "\n" +
                                "Występuje często w lasach iglastych i liściastych, pod świerkami, sosnami bukami i dębami, od lata do jesieni w grupach. Na ściółce.\n".toString();
                        qwe = R.drawable.bialawalej;
                        qwe2 = R.drawable.lisciowabig;
                        list1 = "Lejkówka biaława Clitocybe candicans,".toString();
                        list2 = "jest mniejsza, nie pachnie anyżem;";
                        list13 = "ma mączny smak, blaszki bardziej zbiegające, a na kapeluszu charakterystyczne plamy;";
                        list3 = "Lejkówka jadowita Clitocybe rivulosa,";
                        qwe3 = R.drawable.jadowitalej;
                        list14 = "ma mączysty zapach i rośnie kępkami przy drogach leśnych. Ma bardzo gęste blaszki;";
                        list4 = "Kępkowiec białawy Lyophyllum connatum,";
                        qwe4 = R.drawable.bialawykep;
                        list15 = "jego blaszki daleko zbiegają na trzon i różowieją z wiekiem. Miąższ ma silnie mączysty zapach.";
                        list5 = "Bruzdniczek największy Clitopilus prunulus,";
                        qwe5 = R.drawable.najwiekszybruz;
                        jedzenie = R.drawable.trujacy;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t9;
                        jadalnosc.setImageResource(R.drawable.trujacy);
                        break;
                    case 101:
                        TempListViewClickedValue = "Lejkówka śnieżysta Leucopaxillus candidus"+"\n"+"jako Białokrowiak śnieżysty".toString();
                        TempListViewClickedValue2 = "Kapelusz o średnicy 10-25 cm. Kolor białośnieżysty.\n" +
                                "\n" +
                                "Trzon biały, dość gruby.\n" +
                                "\n" +
                                "Blaszki szarawe.\n" +
                                "\n" +
                                "Zastosowanie - jadalny i smaczny.\n".toString();
                        qwe2 = R.drawable.sniezystabig;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t8;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 102:
                        TempListViewClickedValue = "Lejkówka zielonawa Clitocybe odora".toString();
                        TempListViewClickedValue2 = "Owocnik za młodu szaroniebieski, zielonkawoniebieski lub zielonkawy, z czasem płowieją przybierając barwe szarawo-białawą, owocnik średnicy 3-9cm początkowo wypukły, potem płaski, w końcu wklęsły z uwypukleniem w centrum. \n" +
                                "\n" +
                                "Powierzchnia gładka, sucha, brzeg podwinięty, u starszych płatowato falisty. \n" +
                                "\n" +
                                "Blaszki barwy kapelusza lub jaśniejsze, bladoniebieskie, niebieskozielone, szarobiaławe do prawie białych, zbiegające lub przyrośnięte, średnio gęste. \n" +
                                "\n" +
                                "Trzon barwy kapelusza ale jaśniejszy, krótki, ku podstawie zwężony, gładki, u nasady z białą grzybnią, z wiekiem pusty. \n" +
                                "\n" +
                                "Miąższ bladozielony do białawego, zapachu anyżu, w smaku korzenny. \n" +
                                "\n" +
                                "Pospolity, wyrasta od sierpnia do końca grudnia w grupach po kilka, w lasach liściastych i iglastych. \n" +
                                "\n" +
                                "Zastosowanie- jadalna. \n".toString();
                        qwe = R.drawable.grynszpanowy;
                        qwe2 = R.drawable.zielonawalejbig;
                        list1 = "Pierścieniak grynszpanowy Stropharia aeruginosa,".toString();
                        list2 = "nie posiada anyżowego zapachu.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 103:
                        TempListViewClickedValue = "Lisówka pomarańczowa Hygrophoropsis aurantiaca".toString();
                        TempListViewClickedValue2 = "Owocnik o średnicy 2-8cm, początkowo ciemnomiesisty, potem  pomarańczowożółty do pomarańczowego, różowopomarańczowego.  Młody nieco wypukły, płaski, potem wklęsły, środdkiem zapadniety, lejkowaty. Brzeg początkowo podwinięty  i pofalowany. \n" +
                                "\n" +
                                "Powierzchnia sucha, miejscami pilśniowa, matowa. \n" +
                                "\n" +
                                "Blaszki barwy pomarańczowej, cienkie, gęste, wąskie i zbiegające na trzon. \n" +
                                "\n" +
                                "Trzon barwy owocnika, nieco bledszy, u podstawy białawy, cienki,  równogruby, nieco rozszerzony ku górze, pełny. \n" +
                                "\n" +
                                "Miąższ barwy białawej lub kremowej, niezmienny, w kapeluszu cienki, smak łagodny, zapach słaby, nieokreślony. \n" +
                                "\n" +
                                "Występuje często. Owocniki pojawiają się jesienią, głównie w lasach iglastych i mieszanych, pojedynczo i w grupach, na ściółce i wśród mchów, także na  pniakach i spruchniałym drewie. \n" +
                                "\n" +
                                "Zastosowanie- niejadalna. \n".toString();
                        qwe = R.drawable.jadalnypie;
                        qwe2 = R.drawable.pomaranczowabig;
                        list1 = "Pieprznik jadalny Cantharellus cibarius,".toString();
                        list2 = "odróżnia się gęstszymi blaszkami i ciemniejszymi, bardziej pomarańczowymi owocnikami, zazwyczaj ma też cieńszy trzon.";
                        jedzenie = R.drawable.niejadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t5;
                        jadalnosc.setImageResource(R.drawable.niejadalny);
                        break;
                    case 104:
                        TempListViewClickedValue = "Łopatnica żółtawa Spathularia flavida".toString();
                        TempListViewClickedValue2 = "Owocnik dorasta maksymalnie do 6 cm wysokości, a wyjątkowo do 8 cm, jednak tak dorodne okazy spotyka się sporadycznie. Przeważnie owocniki mają po 3-4 cm wysokości. Składają się ze spłaszczonej, językowatej, nieregularnie pofałdowanej główki, wyraźnie oddzielającej się od części trzonowej, ponieważ główka zabarwiona jest soczyście żółto lub żółtoochrowo; z wiekiem soczysta barwa główki blednie. \n" +
                                "\n" +
                                "Trzon jest białawy lub kremowy, gładki na powierzchni, a w dolnej części może być rozszerzony. \n" +
                                "\n" +
                                "Miąższ białawy, o konsystencji chrząstkowato-galaretowatej; o nieznacznym, przyjemnym zapachu; w smaku łagodny. \n" +
                                "\n" +
                                "Występowanie na opadłych igłach sosnowych, czasem w mchu lub w trawie, na skrajach lasów lub polanach leśnych. Zwykle owocniki występują gromadnie.\n" +
                                "\n" +
                                "Zastosowanie - jadalna. \n".toString();
                        qwe = R.drawable.blotnamit;
                        qwe2 = R.drawable.zoltawalopabig;
                        list1 = "Mitróweczka błotna Mitrula paludosa,".toString();
                        list2 = "występujący w miejscach podmokłych, np. na skrajach torfowisk, owocnik składa się ze spłaszczonej, językowatej, jaskrawożółtej główki osadzonej na białawym, cienkim trzonku.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t4;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 105:
                        TempListViewClickedValue = "Łuskowiec jeleni Pluteus atricapillus".toString();
                        TempListViewClickedValue2 = "Owocnik 5-15 cm średnicy; brunatny, szarobrązowy lub szary; dzwonkowaty, wypukły, później płaski, dość często promieniście popękany; powierzchnia jest włóknista lub pokryta drobnymi łuseczkami. \n" +
                                "\n" +
                                "Blaszki 10-15 mm szerokości; białe, białawe, później różowe, u starszych owocników brązowoczerwone; przy trzonie zaokrąglone; dość rzadkie. \n" +
                                "\n" +
                                "Trzon 5-15 cm wysokości i 1-2 cm grubości; biały, białawo-siwy, brązowawy, walcowaty, u góry nieco zwężony, pełny, pokryty brązowymi, włóknistymi strzępkami; bez pierścienia; łatwo odłamuje się od kapelusza. \n" +
                                "\n" +
                                "Miąższ biały, nie zmienia barwy po przekrojeniu, miękki, wodnisty; smak łagodny, zapach nie wyróżnia się. \n" +
                                "\n" +
                                "Występuje od kwietnia do listopada saprofityczny, rozkłada drewno liściaste, głównie bukowe i dębowe, również gatunków iglastych, najczęściej w wilgotnych i cienistych lasach liściastych i mieszanych.\n" +
                                "\n" +
                                "Zastosowanie - jadalny, niezbyt smaczny. \n".toString();
                        qwe = R.drawable.szerokoblaszkowa;
                        qwe2 = R.drawable.jelenibig;
                        list1 = "Pieniążnica szerokoblaszkowa Megacollybia platyphylla,".toString();
                        list2 = "ma rzadsze, ale szersze i zawsze białe i przyrośnięte do trzonu blaszki, a u podstawy trzonu liczne ryzomorfy.";
                        list13 = "ma ciemnobrązowe lub czarne ostrza blaszek i rośnie na drewnie drzew iglastych.";
                        list3 = "Drobnołuszczak czarnoostrzowy Pluteus atromarginatus,";
                        qwe3 = R.drawable.czarnoostrzowy;
                        list14 = "ma szaroczarniawy kapelusz bez brązowych odcieni. Rośnie na drewnie wierzby.";
                        list4 = "Drobnołuszczak zielonawoszary Pluteus salicinus,";
                        qwe4 = R.drawable.zielonawoszary;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t1;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 106:
                        TempListViewClickedValue = "Łuszczak zmienny Kuehneromyces mutabilis".toString();
                        TempListViewClickedValue2 = "Kapelusz od 30 do 60 mm średnicy; barwy piaskowozłotej (w stanie suchym) do rudawobrązowej, miodowobrunatnej, gdy jest wilgotny; wysychając zmienia barwę od jaśniejszego środka do ciemniejszego brzegu; w kształcie wypukły, brzeg podwinięty u młodych owocników; u młodych owocników zanikające na powierzchni brązowe łuseczki, u starszych powierzchnia gładka; nasycony wilgocią ma powierzchnię nieco oślizłą, a brzeg prążkowany; suchy jest matowawy. \n" +
                                "\n" +
                                "Blaszki barwy białawej, przechodzące w kremowożółtawą do rudobrązowej; długość różna; szerokość od 3 do 5 mm; gęsto ułożone; zbiegające lub przyrośnięte do trzonu. \n" +
                                "\n" +
                                "Pierścień wywinięty w górę i zabarwiony na brązowo; wysoko osadzony; zanikając, pozostawia ślad w postaci łuseczek większych rozmiarów; błoniasty. \n" +
                                "\n" +
                                "Trzon przyjmuje barwę kapelusza, gdzie góra jest jaśniejsza, a podstawa ciemniejsza, do brunatnej; od 50 do 70 mm długości i od 4 do 8 mm grubości; cylindryczny i smukły; osadzony centralnie w kapeluszu; pełny, włóknisty i łykowaty; gładki powyżej zanikającego pierścienia, poniżej łuseczkowaty; w barwie brunatnej. \n" +
                                "\n" +
                                "Miąższ w kapeluszu barwy białawej, w trzonie przechodzący do rudawego; nie zmienia zabarwienia po uciśnięciu lub rozkrojeniu; w smaku łagodny; w zapachu przyjemny. \n" +
                                "\n" +
                                "Pospolity, spotykany od bardzo wczesnej wiosny do początku zimy, porasta gromadnie w wiązkach, na pniach drzew liściastych, w górach spotykany na iglastych. \n".toString();
                        qwe = R.drawable.jadowita;
                        qwe2 = R.drawable.zmiennybig;
                        list1 = "Hełmówka jadowita Galerina marginata,".toString();
                        list2 = "trzon pokryty jest białymi kosmkami osłony, które tworzą zygzakowaty wzorek, nie rośnie na drzewach liściastych, lecz wyłącznie na pniakach drzew iglastych;";
                        list13 = "ma blaszki w niebieskawym odcieniu.";
                        list3 = "Łysiczka łagodna Hypholoma capnoides,";
                        qwe3 = R.drawable.lagodnama;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t7;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 107:
                        TempListViewClickedValue = "Łycznik późny Panellus serotinus".toString();
                        TempListViewClickedValue2 = "Owocnik młody półkulisty, wkrótce muszelkowaty, z czasem nieregularnie płatowaty, grubo mięsisty; młody koloru żółtego, szybko staje się oliwkowozielony, delikatnie zamszowaty, w pobliżu trzonu szczeciniasto owłosiony, dalej nagi; w czasie wilgotnej pogody jest lepki, natomiast suchy jest żelatynowaty; zwykle od 4-10 cm szerokości. \n" +
                                "\n" +
                                "Blaszki początkowo jasne, kremowe, potem żółtawe, bladoochrowe, z wiekiem brązowe; gęste, rozwidlone; szerokie na obwodzie, zwężające się ku trzonowi, przyrośnięte. \n" +
                                "\n" +
                                "Trzon pomarańczowożólty, następnie pomarańczowobrązowy, usiany delikatną, ciemną ziarnistością na filcowatym tle; gruby i krótki; boczny. \n" +
                                "\n" +
                                "Miąższ blady, wodnistobiały; z żelatynową warstwą pod skórką kapelusza; gąbczasty, miękki; bez zapachu lub zapach słaby, przyjemny, grzybowy; smak łagodny. Pod skórką kapelusza jest galaretowata warstwa, atrakcyjna kulinarnie, a chroniąca owocniki przed mrozem. \n" +
                                "\n" +
                                "Owocniki wyrastają zwykle w skupieniach, jeden nad drugim, od września i zimą, na pniach żywych i kłodach drzew liściastych, rzadko również na drzewach iglastych, w lasach łęgowych, w jarach, na brzegach strumieni i terenach podmokłych. \n" +
                                "\n" +
                                "Zastosowanie- jadalny (nieoficjalnie trujący- rakotwórczy).\n".toString();
                        qwe = R.drawable.bigb;
                        qwe2 = R.drawable.lypoznybig;
                        list1 = "Boczniak ostrygowaty Pleurotus ostreatus,".toString();
                        list2 = "pokryty łuseczkami trzon, żółtoochrowe blaszki i zielonymi oraz ochrowymi odcieniami kapelusza.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.def1;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 108:
                        TempListViewClickedValue = "Łysak wspaniały Gymnopilus junonius".toString();
                        TempListViewClickedValue2 = "Kapelusz osiąga średnicę 10 cm a może być jeszcze większy. Jest zamszowato-pilśniowaty, matowy, najpierw półkulisty, potem spłaszczony, bez garbka lub tylko z całkiem płaskim, tępym wzniesieniem na środku, w okresie deszczowym  trochę śluzowaty.\n" +
                                "\n" +
                                "Stare owocniki mają skórkę kapelusza popękaną na poletka, które miejscami mają odcień purpurowy.\n" +
                                "\n" +
                                "Blaszki są początkowo blado-żółto-brązowe, dosyć wąskie, gęste, zaokrąglone i przyrośnięte lub wycięte i zbiegające ząbkiem.\n" +
                                "\n" +
                                "Trzon jest cylindryczny, często maczugowato rozszerzony i korzeniasto wydłużony w dolnej części. Ma długość 20 cm i grubość 1-3 cm, jest pełny, jasnożółty i pokryty ciemniejszymi włóknami lub łuseczkami, w dolnej części czerwono-brązowy. W górnej części trzonu znajduje się żółtawy nie zanikający pierścień, ponad którym trzon jest białawy.\n" +
                                "\n" +
                                "Miąższ jest zółtawy, ma bardzo gorzki smak.\n" +
                                "\n" +
                                "Zapach  silny , niekiedy przypominający zapach rzodkwi\n" +
                                "\n" +
                                "Zastosowanie – niejadalny.\n" +
                                "\n" +
                                "Występuje w jesieni ,od września do listopada ,w kępach na pniakach, korzeniach lub nasadach pni drzew liściastych, szczególnie dębu.\n".toString();
                        qwe = R.drawable.nastroszony;
                        qwe2 = R.drawable.wspanialylysbig;
                        list1 = "Łuskwiak nastroszony Pholiota squarosa,".toString();
                        list2 = "kapelusz i trzon posiadają łuski.";
                        jedzenie = R.drawable.niejadalny;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.t8;
                        jadalnosc.setImageResource(R.drawable.niejadalny);
                        break;
                    case 109:
                        TempListViewClickedValue = "Łysiczka łuskowata Leratiomyces squamosus".toString();
                        TempListViewClickedValue3 = "Gatunek objęty ochroną w Polsce, Niemczech i Norwegii! ".toString();
                        TempListViewClickedValue2 = "Owocnik o średnicy 3-8cm młody półkolisty potem łukowaty do płasko rozłożonego ochrowożółty do rudego, na brzegu białawe łuseczki osłony.\n" +
                                "\n" +
                                "Blaszki jasnoszarobrązowe, z wiekiem do prawie czarnych, szerokie, szeroko przyrośnięte, ostrze z białawymi kłaczkami.\n" +
                                "\n" +
                                "Trzon walcowaty i twardy w górze białawy i gładki, poniżej pierścienia ciemniejszy, brunatno łuskowany, cienki, pusty. Pierścień delikatny, zanikający.\n" +
                                "\n" +
                                "Miąższ białawy lub kremowożółty, w kapeluszu bardzo cienki, młody gorzkawy, z wiekiem bez wyróżniającego się smaku czy zapachu.\n" +
                                "\n" +
                                "Występuje rzadko, w lasach liściastych i iglastych pod bukami, od sierpnia do listopada, w gęstej rosliności na obrzeżach lasów i dróg.\n" +
                                "\n" +
                                "Zastosowanie–  grzyb trujący\n".toString();
                        qwe2 = R.drawable.luskowatabig;
                        jedzenie = R.drawable.trujacy;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t7;
                        jadalnosc.setImageResource(R.drawable.trujacy);
                        break;
                    case 110:
                        TempListViewClickedValue = "Łysostopek pospolity Gymnopus dryophilus".toString();
                        TempListViewClickedValue2 = "Owocnik higrofaniczny, bardzo zmienny w barwie, suchy bladokremowy, bladomięsisty, wilgotny brązowawoczerwonawy, żółtobrązowy, pomarańczowobrązowy, 2-7cm średnicy, początkowo wypukły, potem płaski, czasem wklęsły z powyginanym brzegiem, powierzchnia gładka, matowa, wilgotna nieco lepka. \n" +
                                "\n" +
                                "Blaszki białawe, kremowe lub żółtawe, wąskie, gęste, przy trzonie zaokrąglone. \n" +
                                "\n" +
                                "Trzon czerwonobrunatny, pomarańczowożółty, równogruby, podstawa nieco rozdęta, elastyczny, powierzchnia gładka. \n" +
                                "\n" +
                                "Miąższ białawy, wodnisty, w kapeluszu bardzo cienki; smak łagodny, zapach słaby, przyjemny, kwasny. \n" +
                                "\n" +
                                "Pospolity. Wyrasta pojedynczo lub po kilka w pobliżu siebie od maja do listopada, w lasach liściastych i iglastych. \n" +
                                "\n" +
                                "Zastosowanie- jadalny , trzony się usuwa.\n".toString();
                        qwe = R.drawable.przydrozny;
                        qwe2 = R.drawable.pospolitylysobig;
                        list1 = "Twardzioszek przydrożny Marasmius oreades,".toString();
                        list2 = "ma elastyczny trzon, rzadkie blaszki i rośnie na łąkach i pastwiskach;";
                        list13 = "ma zapach zgniłej kapusty i filcowato-szczeciniastą grzybnię u nasady trzony;";
                        list3 = "Łysostopek niemiły Gymnopus hariolorum,";
                        qwe3 = R.drawable.niemily;
                        list14 = "ma jaśniejszy kapelusz i zgrubiały trzon u postawy.";
                        list4 = "Łysostopek wodnisty Gymnopus aquosus,";
                        qwe4 = R.drawable.wodnisty;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t7;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 111:
                        TempListViewClickedValue = "Łysostopek pozrastany Gymnopus confluens".toString();
                        TempListViewClickedValue2 = "Owocnik higrofaniczny, suchy kremowocielisty do białego, wilgotny brązowoczerwony, mięsnobrązowy; powierzchnia gładka; brzeg cienki, wilgotny prążkowany, stary często postrzępiony; 2-4 cm średnicy; młody dzwonkowaty, potem spłaszczony z tępym garbkiem, powyginany, o cienkim miąższu. \n" +
                                "\n" +
                                "Blaszki początkowo białawe, później bladocieliste, bardzo ścieśnione, przy trzonie wolne. \n" +
                                "\n" +
                                "Trzon barwy kapelusza, białawy, brązowawy; cylindryczny, smukły, o wymiarach 40-80 na 2-4 mm; elastyczny, twardy, chrząstkowaty, rurkowaty, na całej długości z drobnymi włoskami; po oderwaniu kapelusza pozostaje trzon z tarczką u szczytu. \n" +
                                "\n" +
                                "Miąższ białawy, niezmienny, łykowaty, cienki; smak łagodny; zapach niewyraźny, przyjemny. \n" +
                                "\n" +
                                "Pospolity. Owocniki wyrastają od czerwca do października, w różnego typu lasach, na ściółce, zwykle gromadnie, w kępkach tworzących czasem czarcie kręgi. \n" +
                                "\n" +
                                "Zastosowanie - jadalny. \n".toString();
                        qwe = R.drawable.kepowy;
                        qwe2 = R.drawable.pozrastanybig;
                        list1 = "Lysostopek kępkowy Gymnopus acervatus,".toString();
                        list2 = "ma ciemniejszy kapelusz, czerwonobrązowy trzon, w górnej części nagi;";
                        list13 = "również rośnie w kępkach, trzon ma lśniący, czerwonobrązowy.";
                        list3 = "Łysostopek twardzioszkowaty Gymnopus erythropus,";
                        qwe3 = R.drawable.twardzioszkowaty;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t7;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 112:
                        TempListViewClickedValue = "Łysostopek wrzecionowatotrzonowy Gymnopus fusipes".toString();
                        TempListViewClickedValue2 = "Owocnik o średnicy 3-10cm, ciemnoczerwonobrązowy, ochrawoczerwony, higrofaniczny początkowo dzwonkowaty, potem rozpostarty, gładki. Często na powierzchni rdzawo poplamiony. \n" +
                                "\n" +
                                "Blaszki szerokie, gęsto ustawione, czerwonoochrowe, niekiedy z rdzawymi plamkami. \n" +
                                "\n" +
                                "Trzon kremowy do cielistego, bliżej podstawy z ciemnobrązowymi plamami. grubo podłużnie bruzdowany, wrzecionowato korzenisty, często skręcony. \n" +
                                "\n" +
                                "Miąższ białawy, łykowatoelastyczny, smak łagodny, zapach nieprzyjemny natrętny. \n" +
                                "\n" +
                                "Występuje dość często od lata do jesieni w dużych skupiskach kępach w lasach liściastych. U nasady pni i na korzeniach żywych dębów i buków, rzadziej na martwym drewnie. \n" +
                                "\n" +
                                "Zastosowanie- niejadalny. \n".toString();
                        qwe2 = R.drawable.wrzecionowatbig;
                        jedzenie = R.drawable.niejadalny;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.t7;
                        jadalnosc.setImageResource(R.drawable.niejadalny);
                        break;
                    case 113:
                        TempListViewClickedValue = "Majówka wiosenna Calocybe gambosa".toString();
                        TempListViewClickedValue2 = "Kapelusz o średnicy 3-10 cm, barwy kremowej, czasem z żółtawym odcieniem, na szczycie uwypuklony. Powierzchnia gładka, sucha, brzeg u młodych okazów podwinięty.\n" +
                                "\n" +
                                "Blaszki białawe, gęsto ustawione, wąskie, cienkie, przy trzonie zaokrąglone lub wycięte ząbkiem.\n" +
                                "\n" +
                                "Trzon barwy kapelusza, dość krótki (4-9 na 1,5-4 cm), na powierzchni gładki, wewnątrz pełny.\n" +
                                "\n" +
                                "Miąższ białawy, niezmienny, o smaku łagodnym i silnym zapachu świeżej mąki.\n" +
                                "\n" +
                                "Pospolity, wyrastający wiosną (od kwietnia do czerwca), na łąkach, pastwiskach, brzegach lasów. \n" +
                                "\n" +
                                "Zastosowanie - jadalny.\n".toString();
                        qwe = R.drawable.dzwtrujaca;
                        qwe2 = R.drawable.wiosennabig;
                        list1 = "Dzwonkówka trująca Entoloma sinuatum,".toString();
                        list2 = "ma podobny zapach, lecz blaszki po dojrzeniu sa różowoochrowe, ponieważ wysyp zarodników ma kolor różowy.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.laka;
                        typgrzyb = R.drawable.t1;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 114:
                        TempListViewClickedValue = "Maślak pstry Suillus variegatus".toString();
                        TempListViewClickedValue2 = "Kapelusz 6-15 cm średnicy; w stadium młodocianym jest półkolisty, z podgiętym brzegiem, później staje się poduchowato-wypukły, a wreszcie płaski i nieregularnie zgięty, niekiedy zapadnięty w środku; żółtobrunatna lub pomarańczowoochrawa powierzchnia kapelusza pokryta jest szorstkim, żółtawooliwkowoszarym filcem, gęstszym i silniej przyciśniętym w środku kapelusza; skórka niezbyt lepka w czasie wilgotnych dni, poza tym sucha. \n" +
                                "\n" +
                                "Pory piaskowożółte, drobne, okrągławe, uciśnięte ciemnieją. \n" +
                                "\n" +
                                "Rurki piaskowożółte, z wiekiem płowooliwkowe, uszkodzone błękitnieją. \n" +
                                "\n" +
                                "Trzon 7-10 cm wysokości, 1,5-2,5 cm grubości, początkowo słabo wybrzuszony, później walcowaty, jaśniejszego koloru niż kapelusz, u podstawy bardziej pomarańczowobrunatny, koło wierzchołka żywiej pomarańczowożółtawy, pokryty delikatnym filcem. \n" +
                                "\n" +
                                "Miąższ żółtawy lub pomarańczowy, silniej lub słabej niebieszczeje pod wpływem uszkodzenia; zapach słaby, smak łagodny.\n" +
                                "\n" +
                                "Pospolity. Owocniki wyrastają od lata do jesieni, w grupach pod sosną, na glebach kwaśnych, gliniastych. \n" +
                                "\n" +
                                "Zastosowanie - jadalny. \n".toString();
                        qwe = R.drawable.sitarz;
                        qwe2 = R.drawable.pstrymasbigprzod;
                        list1 = "Maślak sitarz Suillus bovinus,".toString();
                        list2 = "ma skórkę gładką i podczas wilgoci bardzo lepką.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t1;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 115:
                        TempListViewClickedValue = "Maślak sitarz Suillus bovinus".toString();
                        TempListViewClickedValue2 = "Owocnik 3-11 cm średnicy; za młodu poduchowato-wypukły, z lekko podgiętym brzegiem, później bardziej rozpostarty, niereguralnie spłaszczony; płowożółtobrunatny lub czerwonawy; wilgotna skóra bardzo lepka, szybko wysycha, jest naga, gładka lub nierówna od śluzu zasychającego w drobne zmarszczki. \n" +
                                "\n" +
                                "Rurki bladoszarożółtawe, później oliwkowo-żółte lub oliwkowobrązowe, szeroko przyrośnięte lub zbiegające i z trudem dające się oddzielić od miąższu kapelusza. \n" +
                                "\n" +
                                "Pory tego samego koloru co rurki lub nieco brudniejsze, szerokie i o nieregularnej strukturze, przeważnie ząbkowato wyciągnięte. \n" +
                                "\n" +
                                "Trzon 3-6 cm wysokości, 0,5-1 cm grubości, przeważnie mięsisty, za młodu nieco wybrzuszony, w kolorze kapelusza. \n" +
                                "\n" +
                                "Miąższ białawy, żółtawy, brązowawy, nieco błękitniejący, elastyczny; zapach i smak słabe. \n" +
                                "\n" +
                                "Pospolity w lasach iglastych, na glebach ubogich, piaszczystych, silnie zakwaszonych, rośnie pod sosnami od sierpnia do października. \n" +
                                "\n" +
                                "Zastosowanie - jadalny. \n".toString();
                        qwe = R.drawable.pstrymas;
                        qwe2 = R.drawable.sitarzbig;
                        list1 = "Maślak pstry Suillus variegatus,".toString();
                        list2 = "kapelusz pokryty ma szorstkimi filcowatymi łuseczkami, posiada bardzo wąskie pory.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t1;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 116:
                        TempListViewClickedValue = "Maślak szary Suillus viscidus".toString();
                        TempListViewClickedValue2 = "Owocnik szarożółtobrązowawy, jasnoszary, czasami z zielonkawym odcieniem; półkulisty, szybko wypukły, z wiekiem do rozpostartego.\n" +
                                "\n" +
                                "Powierzchnia nierówna, śluzowata, sucha kosmkowato-włóknista; brzeg długo podwinięty i ze zwieszającymi się białymi resztkami włóknistej osłony; skórka łatwo zdzieralna.\n" +
                                "\n" +
                                "Pory początkowo białe, potem szarobrązowawe, uciśnięte ciemnieją; rurki tej samej barwy. \n" +
                                "\n" +
                                "Rurki tej samej barwy co pory. \n" +
                                "\n" +
                                "Trzon szarożółtobrązowawy, z zanikającym białawym pierścieniem, powyżej pierścienia na powierzchni drobna siateczka, barwa powyżej pierścienia biaława do żółtawej, poniżej szaro-biała do czerwono-brązowawej; cylindryczny, czasem rozszerzający się ku podstawie. \n" +
                                "\n" +
                                "Miąższ białawy do żółtawego, czasami niebieskawozielony, w kapeluszu miękki, w trzonie nieco włóknisty; łagodny smak; zapach słaby. \n" +
                                "\n" +
                                "Występuje od lata do jesieni, pojedynczo lub w grupach, wyłącznie pod modrzewiami. \n" +
                                "\n" +
                                "Zastosowanie - jadalny. \n".toString();
                        qwe2 = R.drawable.szarymabig;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t1;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 117:
                        TempListViewClickedValue = "Maślak ziarnisty Suillus granulatus".toString();
                        TempListViewClickedValue2 = "Kapelusz 20 do 120 mm średnicy; początkowo o kształcie półkolistym, a później spłaszczonym i poduchowatym; barwy czerwonobrązowawej, rdzawoczerwonawej, żółtawoochrowej, piaskowobrązowej do ciemnobrązowej; \n" +
                                "\n" +
                                "Skórka lepka i bardzo śliska w czasie deszczu, a gładka, naga i błyszcząca w czasie suszy; oddziela się łatwo od miąższu. \n" +
                                "\n" +
                                "Pory o barwie jasnożółtej; młode owocniki wydzielają krople białego mleczka, które podczas suchej pogody wysychając pozostawiają na porach i trzonie ziarenka w kolorze brązowym; drobne, dojrzałe wielkości do 1 mm; w kształcie nieregularne i kanciaste. \n" +
                                "\n" +
                                "Rurki o długości od 5 do 10 mm; w pierwszej fazie bladożółte, a później ciemniejsze z odcieniem oliwkowym lub ochrowym; przyrośnięte do trzonu lub trochę zbiegające; łatwo oddzielają się od miąższu. \n" +
                                "\n" +
                                "Trzon od 40 do 60 mm wysokości, od 8 do 15 mm grubości; barwy żółtokremowej, oliwkowożółtej; u podstawy brązowiejący; równogruby, cylindryczny i pełny; gładki, a w górnej części usiany brązowymi brodaweczkami, powstałymi od mlecznego płynu, który zasychając przybiera brązowy kolor. \n" +
                                "\n" +
                                "Miąższ w kapeluszu i trzonie w kolorze początkowo białawym, a następnie żółtawym, u podstawy trzonu, brązowawym; po uszkodzeniu lub przecięciu nie zmienia barwy; w kapeluszu za młodu konsystencji masła, później miękki, soczysty, a nawet wodnisty, natomiast w trzonie lekko włóknisty; zapach łagodny, owocowy; smak przyjemny. \n" +
                                "\n" +
                                "Występuje w lasach sosnowych i mieszanych, na terenach trawiastych, w młodnikach sosnowych, na polanach i nieużytkach porośniętych samosiewem sosny; lubi gleby piaszczyste, o odczynie zasadowym; w okresie od maja do października. Tworzy mikoryzę z różnymi gatunkami sosen.\n".toString();
                        qwe = R.drawable.zwyczajnymas;
                        qwe2 = R.drawable.ziarnistybig;
                        list1 = "Maślak zwyczajny Suillus luteus,".toString();
                        list2 = "ma większe owocniki, pierścień na trzonie i żółtopomarańczowy kapelusz. Rośnie pod sosnami;";
                        list13 = "rośnie tylko na wapieniach i u podstawy trzonu ma różowawą grzybnię.";
                        list3 = "Maślak rdzawobrązowy Suillus collinitus,";
                        qwe3 = R.drawable.rdzawobrazowy;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t1;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 118:
                        TempListViewClickedValue = "Maślak żółty Suillus flavus".toString();
                        TempListViewClickedValue2 = "Kapelusz od 40 do 150 mm średnicy; początkowo o kształcie półkulistym, stożkowatym, a później spłaszczonym i poduchowatym; barwy złocistożółtej z odcieniem pomarańczowobrązowym lub żółtobrązowy; skórka gładka, naga i lepka; w czasie deszczu bardzo lepka, śluzowata i mazista, natomiast atowa w czasie suszy; trudno oddziela się od miąższu; brzeg ostry, początkowo podwinięty. \n" +
                                "\n" +
                                "Pory za młodu żółte, z wiekiem oliwkowe do brązowożółtych, uciśnięte lub uszkodzone barwią się na kolor różowawobrązowy; małe w kształcie zaokrąglone, później kanciaste. \n" +
                                "\n" +
                                "Rurki o długości od 6 do 12 mm; w pierwszej fazie żółte, a później oliwkowożółte; przyrośnięte z trzonem, oddzielające się od miąższu; po ucisku lub uszkodzeniu przebarwiają się na czerwonobrązowo lub brązowo; rurki młodych są owocników zakryte od spodu żółtawą osłoną tworzącą z czasem na trzonie rdzawe zgrubienie. \n" +
                                "\n" +
                                "Trzon o wysokości od 40 do 120 mm i grubości od 15 do 25 mm; o barwie żółtopomarańczowej lub złotożółtej nad pierścieniem, często pokryty siateczką i drobnymi ziarenkami w kolorze brązowym; poniżej pierścienia, ku dołu jest żółtawobrązowawy, podłużnie włóknisty. Równogruby, cylindryczny, niekiedy maczugowaty; pełny. \n" +
                                "\n" +
                                "Pierścień ma barwę białawą albo żółtawą. \n" +
                                "\n" +
                                "Miąższ w kapeluszu i trzonie w kolorze najpierw cytrynowożółtym, później żółtawobiałym; po uszkodzeniu lub przecięciu różowolilowy lub brązowawy; w kapeluszu mięsisty, miękki i soczysty, natomiast w trzonie twardawy i nieco włóknisty; o łagodnym smaku i przyjemnym zapachu. \n" +
                                "\n" +
                                "Występuje w lasach modrzewiowych, w lasach mieszanych z modrzewiem i pod pojedynczymi modrzewiami; z tymi drzewami tworzy wyłącznie mikoryzę; spotykany w okresie od czerwca do października; występując pojedynczo, ale najczęściej w grupach; gatunek dość rzadki i są rejony, gdzie jest coraz rzadszy; owocniki zanikają wraz z obumieraniem drzewa. \n".toString();
                        qwe = R.drawable.zoltawy;
                        qwe2 = R.drawable.zoltymaslbig;
                        list1 = "Maślak żółtawy Suills nueschii,".toString();
                        list2 = "ma bladoszarawe pory i błękitniejący miąższ. Jest także jadalny, ale jest rzadki.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t1;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 119:
                        TempListViewClickedValue = "Maślanka łagodna Hypholoma capnoides".toString();
                        TempListViewClickedValue2 = "Owocnik żółty do brązowożółtego, środek ciemniejszy pomarańczowobrązowy, 2-7cm średnicy, półkulisty, z wiekiem wypukły do spłaszczonego. Powierzchnia z zanikającą jedwabistą osłoną gładka, na brzegu widoczne resztki białawej włókienkowatej osłony. \n" +
                                "\n" +
                                "Blaszki młode białawe z wiekiem szarofioletowe, przyrośnięte do trzonu lub zaokrąglone. \n" +
                                "\n" +
                                "Trzon smukły, wygięty, pusty, ku górze białawy, przy podstawie rdzawobrązowy. \n" +
                                "\n" +
                                "Pieścień białawym włókienkowatym,z czasem zanikający. \n" +
                                "\n" +
                                "Miąższ białawy do jasnożółtawego, w trzonie brązowiejący, twardy, włóknisty. Zapach przyjemny, smak łagodny, grzybowy \n" +
                                "\n" +
                                "Występuje często, wyrasta w kępkach jesienią, na drewnie iglastym, zwłaszcza świerkowym. \n" +
                                "\n" +
                                "Zastosowanie- jadalna. \n".toString();
                        qwe = R.drawable.jadowita;
                        qwe2 = R.drawable.lagodnamabig;
                        list1 = "Hełmówka jadowita Galerina marginata,".toString();
                        list2 = "ma drobniejsze owocniki, kruche i rdzawobrązowe;";
                        list13 = "ma zielonkawe blaszki, ostry smak;";
                        list3 = "Maślanka wiązkowa Hypholoma fasciculare,";
                        qwe3 = R.drawable.wiazkowa;
                        list14 = "ma blaszki szaro-oliwkowo-brązowe, miąższ gorzki, a trzon korzeniasty.";
                        list4 = "Maślanka korzeniasta Hypholoma radicosum,";
                        qwe4 = R.drawable.korzeniastama;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t7;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 120:
                        TempListViewClickedValue = "Maślanka wiązkowa Hypholoma fasciculare".toString();
                        TempListViewClickedValue2 = "Owocnik początkowo kulisty, potem wypukły z czasem rozpostarty, siarkawożółtawy z pomarańczerwonobrązowawym środkiem, średnicy do 12 cm. Powierzchnia gładka, sucha, brzeg podwinięty z nietrwałymi resztkami żółtawej osłony.\n" +
                                "\n" +
                                "Blaszki młode siarkawożółte, potem zielonkawe z powodu wysypu dojrzałych zarodników, stają się oliwkowobrunatne; są gęsto ustawione, przy trzonie wygięte.\n" +
                                "\n" +
                                "Trzon do 10 cm wysokości; równogruby, zwężający się ku podstawie, wygięty, pusty; siarkowożółtawy, ku podstawie nieco ciemniejszy. Często z włókienkowatą strefą pierścieniową.\n" +
                                "\n" +
                                "Miąższ siarkowożółty, u podstawy trzonu brązowawy, w kapeluszu cienki, smak bardzo gorzki. Zapach niewyraźny.\n" +
                                "\n" +
                                "Bardzo pospolita masowo w kępkach, na murszejących pniakach i konarach drzew liściastych, rzadziej iglastych.\n" +
                                "\n" +
                                "Zastosowanie- niejadalna, trująca!\n".toString();
                        qwe = R.drawable.lagodnama;
                        qwe2 = R.drawable.wiazkowabig;
                        list1 = "Maślanka łagodna Hypholoma capnoides,".toString();
                        list2 = "ma blaszki niebieskawe, smak łagodny i rośnie tylko na drzewie iglastym;";
                        list13 = "jest większa, ma intensywniejsze zabarwienie i rośnie tylko na drewnie drzew liściastych.";
                        list3 = "Maślanka ceglasta Hypholoma lateritium,";
                        qwe3 = R.drawable.ceglastama;
                        jedzenie = R.drawable.trujacy;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.t7;
                        jadalnosc.setImageResource(R.drawable.trujacy);
                        break;
                    case 121:
                        TempListViewClickedValue = "Mitrówka półwolna Mitrophora semilibera".toString();
                        TempListViewClickedValue3 = "Gatunek objęty częściową ochroną w Polsce! ".toString();
                        TempListViewClickedValue2 = "Owocnik kapelusz tylko w połowie przyrośnięty do trzonu, reszta jest swobodna i może nieco odstawać; znacznie może różnić się rozmiarami, od 1 do 4 cm; powierzchnia żeberkowana, pomiędzy wysokimi i cienkimi pionowymi żebrami znajdują się alweole ustawione w pionowe rzędy i rozdzielone niskimi listewkami; barwa żółtobrązowa, jasnobrązowa do oliwkowobrązowej; żebra i listewki ciemnobrązowe do czarno-brązowych. \n" +
                                "\n" +
                                "Trzon białawy,żółtawy; posiada długość od 3 do 10 cm i średnicę ok. 1-2 cm; wewnątrz jest pusty. \n" +
                                "\n" +
                                "Miąższ jest mniej ceniony, raczej kruchy. Zapach wyraźny, przyjemny. \n" +
                                "\n" +
                                "Wystepuje wczesną wiosną, często gromadnie, ukryty w gęstej trawie. W cieplejszych strefach Europy rośnie w większych ilościach. Lubi gęste lasy łęgowe na żyznych glebach, wilgotnych stanowiskach, można go spotkać przy drogach i ścieżkach leśnych. \n" +
                                "\n" +
                                "Zastosowanie - jadalny. \n".toString();
                        qwe2 = R.drawable.polwolnabig;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.t3;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 122:
                        TempListViewClickedValue = "Mleczaj bezstrefowy Lactarius azonites".toString();
                        TempListViewClickedValue2 = "Owocnik szary, szaroorzechowy do rudobrązowego; 3-10cm średnicy, wypukły, z wiekiem spłaszczony do wklęsłego brzeg początkowo podwinięty, potem prosty, równy lub falisty, powierzchnia sucha, aksamitna, bez pręgowań. \n" +
                                "\n" +
                                "Blaszki kremowe, z wiekiem jasnoochrowe do jasnorudych, gęste, uszkodzone różowieją. \n" +
                                "\n" +
                                "Trzon jasny, początkowo biały, potem barwy kapelusza ale jaśniejszy, o wymiarach 30-70 na 5-15 mm, równogruby, łamliwy, miejsca uciśnięte różowieją, pełny, z wiekiem komorowaty. \n" +
                                "\n" +
                                "Miąższ białawy, mlecznego przebarwia się różowo, jędrny, dość gruby w kapeluszu, zapach niemiły, smak początkowo łagodny z czasem bardziej palący. \n" +
                                "\n" +
                                "Mleczko białe, obfite u młodych grzybów, na miąższu czerwienieje, w smaku łagodne, potem gorzkie i niemiłe w smaku. \n" +
                                "\n" +
                                "Występuje często. Owocniki wyrastają od lata do jesieni, w grupach, w lasach bukowych i pod dębami na glebach zasadowych. \n" +
                                "\n" +
                                "Zastosowanie- niejadalny. \n".toString();
                        qwe = R.drawable.ostryml;
                        qwe2 = R.drawable.bezstresowybig;
                        list1 = "Mleczaj ostry Lactarius acris,".toString();
                        list2 = "mleczko czerwienieje, ma gładki kapelusz;";
                        list13 = "jest pomarszczony, jego mleczko czerwienieje.";
                        list3 = "Mleczaj pomarszczony Lactarius pterosporus,";
                        qwe3 = R.drawable.pomarszczony;
                        jedzenie = R.drawable.niejadalny;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.niejadalny);
                        break;
                    case 123:
                        TempListViewClickedValue = "Mleczaj bladawy Lactarius pallidus".toString();
                        TempListViewClickedValue2 = "Owocnik bladocielisty, do różowoochrowego, ochrowożółtawego, ucisniony przebarwia się bladoochrowordzawo, 4-15cm średnicy, wypukły, z wiekiem rozpostarty i w centrum nieco wklęsły, brzeg długo podwinięty, blado omszony, potem rozpostarty, ostry, powierzchnia gładka, wilgotna silnie śluzowata i lepka, sucha błyszcząca. \n" +
                                "\n" +
                                "Blaszki początkowo białawe, z wiekiem barwy owocnika, uszkodzone barwią się brunatno, bardzo gęste, wąsko przyrośnięte do krótko zbiegających. \n" +
                                "\n" +
                                "Trzon białawy, miejscami ochrowy, krótki (30-70 na 6-20 mm), równogruby, powierzchnia gładka. \n" +
                                "\n" +
                                "Miąższ białawy, elastyczny, zapach słaby owocowy, sok mlecznobiały, niezmienny, łagodny, nieco gorzkawy. \n" +
                                "\n" +
                                "Występuje często, od lata do jesieni w lasach liściastych. \n" +
                                "\n" +
                                "Zastosowanie- niejadalny. \n".toString();
                        qwe = R.drawable.rudobrazowy;
                        qwe2 = R.drawable.bladawybig;
                        list1 = "Mleczaj rudobrązowy Lactarius hysginus,".toString();
                        list2 = "wyrastający w lasach świerkowych;";
                        list13 = "w suchych lasach sosnowych.";
                        list3 = "Mleczaj moszczobarwny Lactarius musteus,";
                        qwe3 = R.drawable.moszczobarwy;
                        jedzenie = R.drawable.niejadalny;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.niejadalny);
                        break;
                    case 124:
                        TempListViewClickedValue = "Mleczaj dołkowany Lactarius scrobiculatus".toString();
                        TempListViewClickedValue2 = "Kapelusz do 20 cm średnicy; początkowo półkuliście wypukły z pępkowato wygiętym środkiem, później przechodzi w mniej lub bardziej lejkowaty; brzeg długo pozostaje podwinięty, filcowaty; powierzchnia włóknista, koloru żółtego z lekkim odcieniem ochrowym do złotożółtego; daje się zaobserwować lekki pierścieniowaty rysunek powstały z przyklejonych, włóknistych łusek; środek kapelusza zwykle gładki z wodnistymi plamami. \n" +
                                "\n" +
                                "Blaszki i miedzyblaszki są gęsto ustawione, krótko zbiegające się przy trzonie, w kolorze białawym lub kremowożółtawym; miejsca uszkodzenia stają się brudnoczerwonawobrunatne. \n" +
                                "\n" +
                                "Trzon do 4-6 cm wysokości i do 3,5 cm grubości, koloru żółtawobiałego, powierzchnia ma liczne płaskie, nieregularne, owalne, ciemne zagłębienia. \n" +
                                "\n" +
                                "Miąższ białawy, twardy; pachnie owocowo; w smaku gorzki i piekący, podobnie jak wydzielany biały sok mleczny, który zabarwia się na żółto. \n" +
                                "\n" +
                                "Występuje niezbyt często, rośnie w lasach świerkowych, przeważnie na glebach wapiennych, często w gromadzie, od lipca do października. \n" +
                                "\n" +
                                "Zastosowanie - niejadalny. \n".toString();
                        qwe = R.drawable.piekacy;
                        qwe2 = R.drawable.dolkowanybig;
                        list1 = "Mleczaj piekący Lactifluus bertillonii,".toString();
                        list2 = "nie ma trzonu z zagłębieniami i rośnie w lasach liściastych;";
                        list13 = "rośnie w wilgotnych lasach świerkowych i pod brzozami.";
                        list3 = "Mleczaj żółtofioletowy Lactarius repraesentaneus, ";
                        qwe3 = R.drawable.zoltofiletowy;
                        jedzenie = R.drawable.niejadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.niejadalny);
                        break;
                    case 125:
                        TempListViewClickedValue = "Mleczaj jodłowy Lactarius salmonicolor".toString();
                        TempListViewClickedValue2 = "Kapelusz 5-15 cm średnicy, masywny, wypukły lecz z wklęśnięciem pośrodku, pomarańczowożółty, brzoskwiniowożółty, pomarańczowy, z koncentrycznymi wąskimi pręgami barwy rudawopomarańczowej, bez śladu zieleni (która może pojawiać się na starość jedynie jako odcień); brzeg podwinięty, delikatnie oszroniony, z wiekiem gładki; \n" +
                                "\n" +
                                "Powierzchnia sucha, ale na wilgotno mogą pojawiać się plamy o zabarwieniu winnobrązowym. \n" +
                                "\n" +
                                "Blaszki mieszane, względnie gęste, przy trzonie czasem rozgałęzione, początkowo jasnoochrowe z odcieniem pomarańćzowym, przyrośnieto-zbiegające. \n" +
                                "\n" +
                                "Trzon o wymiarach 3-6 na 1-2,5 cm, równogruby, łamliwy, w kolorze kapelusza, jasno i delikatnie oszroniony, gładki, z jamkami, wcześnie staje się pusty. \n" +
                                "\n" +
                                "Miąższ dość gruby, kremowy, natychmiast po przekrojeniu pokrywa się pomarańczowymi skupieniami wysychającego mleczka, które jest nieco gorzkawe. Zapach słaby owocowy. \n" +
                                "\n" +
                                "Mleczko obfite, pomarańćzowe, po około 10 minutach przebarwiające się na miniowo, a po 1-2 godzinach na winnoczerwono do pomarańćzowobrązowego. \n" +
                                "\n" +
                                "Występuje pojedynczo lub grupami w miejscach trawiastych w lasach jodłowych na glebie wapiennej. \n" +
                                "\n" +
                                "Zastosowanie- jadalny. \n".toString();
                        qwe = R.drawable.rydz;
                        qwe2 = R.drawable.jodlowybig;
                        list1 = "Mleczaj rydz Lactarius deliciosus,".toString();
                        list2 = "ma bardziej wyraziste prążki na kapeluszu i rośnie pod sosnami. Zielenieje tylko po uszkodzeniu;";
                        list13 = "występuje wyłącznie pod świerkami, o mleczku po ok. 30 min. przebarwiającym się czerwonofioletowo;";
                        list3 = "Mleczaj świerkowy Lactarius deterrimus,";
                        qwe3 = R.drawable.swierkowyml;
                        list14 = "ma mlecznobiały sok i rośnie tylko pod modrzewiami;";
                        list4 = "Mleczaj modrzewiowy Lactarius porninsis,";
                        qwe4 = R.drawable.modrzewiowy;
                        list15 = "sok winnoczerwony, kapelusz z domieszką zielonej barwy.";
                        list5 = "Mleczaj czerwieniejący Lactarius sanguifluus,";
                        qwe5 = R.drawable.czerwieniejacyml;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 126:
                        TempListViewClickedValue = "Mleczaj kamforowy Lactarius camphoratus".toString();
                        TempListViewClickedValue2 = "Kapelusz 3-6 cm średnicy, początkowo płaski, stopniowo staje się płytko ale szeroko wklęły, często z niewielkim garbkiem w głębi, ciemny, o posępnej czerwonobrązowej barwie, nieraz winnoczerwony, bez pręgowania, o powierzchni gładkiej, bez połysku, nie lepki; brzeg trochę podwinięty, szybko rozprostowujący się do pozycji poziomej, delikatnie oszroniony, z czasem gładki i ostry, równy. \n" +
                                "\n" +
                                "Blaszki gęste, mieszane, niekiedy przy trzonie rozwidlone, jasne, czerwonawobrązowawe, w miejscach uciśnięcia przebarwiający się brązowo, przyrośnięte. \n" +
                                "\n" +
                                "Trzon o wymiarach 3-5 na 0,4-0,7 cm, jaśniejszy od kapelusza lecz w dolnej części raczej brązowy, delikatnie oszroniony, gładki, pełny, do komorowatego na starość. \n" +
                                "\n" +
                                "Miąższ stosunkowo cienki, jasny, czerwonawobrązowawy, podczas wysychania wydzielający silny zapach korzenny. \n" +
                                "\n" +
                                "Mleczko dość obfite, rzadkie, wodnistobiałe, łągodne lecz pozostawiające gorzkawy posmak. \n" +
                                "\n" +
                                "Występuje od czerwca do października w lasach liściastych, zwłaszcza bukowych, oraz iglastych, jodłowych, a także świerkowych, bogatych w próchnicę. \n" +
                                "\n" +
                                "Zastosowanie- niejadalny. \n" +
                                "\n" +
                                "Charakterystycznymi cechami tego mleczaja są: posępna brązowoczerwona barwa kapelusza i korzenna woń wysychających okazów. \n".toString();
                        qwe = R.drawable.watrobowy;
                        qwe2 = R.drawable.komfortowybig;
                        list1 = "Mleczaj wątrobowy Lactariue hepaticus,".toString();
                        list2 = "brak charakterystycznego zapachu , siarkowożółty miąższ na przecięciu, jego mleczko przebarwia się na żółto.";
                        jedzenie = R.drawable.niejadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.niejadalny);
                        break;
                    case 127:
                        TempListViewClickedValue = "Mleczaj płowy Lactarius helvus".toString();
                        TempListViewClickedValue2 = "Owocnik młody ochrowoczerwonawy, później szaropłowy, płowożótawy. Powierzchnia matowa, pilśnionołuseczkowata, nieco pofałdowana. 4-16cm średnicy, młody wypukły, potem spłaszczony lub wklęśnięty, zwykle z garbkiem. Brzeg cienki. \n" +
                                "\n" +
                                "Blaszki młode białawe, z wiekiem ochroworóżowawe, czerwonoochrowe. Gęste, prosto przyrośnięte do zbiegających. \n" +
                                "\n" +
                                "Trzon barwy kapelusza, powierzchnia z drobnymi łuseczkami, cylindryczny. Podstawa z grzybnią, na starość pusty. \n" +
                                "\n" +
                                "Miąższ barwy jasnoochrowej, bladomięsistej, jasnoczerwonoochrowy. O zapachu lubczyku u świeżych owocników słaby a u starszych bardzo intensywny. Smak łagodny- korzenny potem z ostrym posmakiem. \n" +
                                "\n" +
                                "Sok mleczny wodnisty, skąpy, u starszych egzemplarzy zanikający. \n" +
                                "\n" +
                                "Pospolity. Wyrasta w grupach lub gromadnie od lipca do października w wilgotnych lasach, na kwaśnych glebach- torfowiskach. \n" +
                                "\n" +
                                "Zastosowanie- niejadalny. \n".toString();
                        qwe = R.drawable.kamforowy;
                        qwe2 = R.drawable.plowymleczbig;
                        list1 = "Mleczaj kamforowy Lactarius camphoratus,".toString();
                        list2 = "różni się ciemniejszym, rdzawobrązowym kapeluszem, jest mniejszy.";
                        jedzenie = R.drawable.niejadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.niejadalny);
                        break;
                    case 128:
                        TempListViewClickedValue = "Mleczaj rydz Lactarius deliciosus".toString();
                        TempListViewClickedValue2 = "Owocnik 5-12 cm średnicy; za młodu płasko wypukły, wkrótce rozpostarty, z wgniecionym środkiem, z czasem lejkowaty; mięsistoczerwony, pomarańczowopłowy; brzeg długo pozostaje podwinięty; \n" +
                                "\n" +
                                "Skórka kapelusza ma na jaskrawym tle ciemniejsze koliste kręgi i tylko miejscami i nie zawsze zielone podbarwienia, wilgotna jest kleisto-oslizgła. \n" +
                                "\n" +
                                "Blaszki tak samo zabarwione jak kapelusz, gęsto ustawione, różnej długości, wąskie i nieco zbiegające po trzonie, przy uciśnięciu barwi się na zielonkawo. \n" +
                                "\n" +
                                "Trzon 3-7 cm wysokości i 1-2,5 cm grubości; prawie walcowaty, u podstawy wyraźnie cieńszy, koloru owocnika, jednak na powierzchni znajdują się małe, płytkie wgłębienia; szybko staje się jamnisty, łamliwy. \n" +
                                "\n" +
                                "Miąższ biały, na brzegach i pod skórką trzonu pomarańczowy; sok mleczny pomarańczowo-czerwony, szybko blednie i w końcu staje się zielony; w smaku łagodny; zapach przyjemny. \n" +
                                "\n" +
                                "Miejscami dość częsty. Owocniki wyrastają od lata do jesieni, gromadnie pod sosnami, lubi gleby piaszczyste, obrzeża lasów, miejsca trawiaste. \n" +
                                "\n" +
                                "Zastosowanie – jadalny.\n" +
                                "\n" +
                                "Przede wszystkim ważne czy sok blednie, czy tez nie, ważne również miejsce występowania. \n".toString();
                        qwe = R.drawable.swierkowyml;
                        qwe2 = R.drawable.rydzbig;
                        list1 = "Mleczaj świerkowy Lactarius deterrimus,".toString();
                        list2 = "występuje wyłącznie pod świerkami, o mleczku po ok. 30 min. przebarwiającym się czerwonofioletowo;";
                        list13 = "występuje pod jodłam, nie zielenieje po uszkodzeniu;";
                        list3 = "Mleczaj jodłowy Lactarius salmonicolor,";
                        qwe3 = R.drawable.jodlowy;
                        list14 = "o bardziej oliwkowozielonym kapeluszu, mleczku przebarwiającym się winnoczerwono przy wysychaniu,";
                        list4 = "Mleczaj zmienny Lactarius semisanguifluus,";
                        qwe4 = R.drawable.zmienny;
                        list15 = "występujący wyłącznie pod modrzewiami, o białym mleczku.";
                        list5 = "Mleczaj modrzewiowy Lactarius porninsis,";
                        qwe5 = R.drawable.modrzewiowy;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 129:
                        TempListViewClickedValue = "Mleczaj świerkowy Lactarius deterrimus".toString();
                        TempListViewClickedValue2 = "Owocnik 3-11 cm średnicy; początkowo wypukły, a gdy się rozszerzy – wklęsły i w kształcie płaskiego lejka, przy czym brzeg kapelusza długo pozostaje podwinięty; kolor ma pomarańczowy, często pomarańczowoczerwonawy z zielonawymi strefami; w miejscu uciśnięcia jest początkowo pomarańczowoczerwony, a później zielony; \n" +
                                "\n" +
                                "Skórka wilgotnieje i staje się kleista, przy brzegu daje się zdzierać. \n" +
                                "\n" +
                                "Blaszki przyrośnięte do trzonu lub lekko zbiegające, gęsto ustawione, pomieszane i rozwidlone, początkowo bladoochrowego koloru, później pomarańczowoochrowego, zielono poplamione. \n" +
                                "\n" +
                                "Trzon 3-7 cm długości i 1-2,7 cm grubości, mniej lub bardziej walcowaty; na jego powierzchni zabarwionej na kolor pomarańczowy często znajdują się ciemniejsze, pomarańczowe plamki. \n" +
                                "\n" +
                                "Miąższ żółtawoblady, w trzonie biały, pod skórką kapelusza nieco zielony; w trzonie gąbczasty, łamliwy; pomarańczowoczerwony sok mleczny po kilku minutach zabarwia się powoli na winnoczerwony; w smaku lekko gorzki. \n" +
                                "\n" +
                                "Związany ze świerkami, występuje zarówno na glebach wapiennych jak i kwaśnych, często masowo na nowych nasadzeniach; wyrasta od sierpnia do końca października. \n" +
                                "\n" +
                                "Zastosowanie - jadalny. \n".toString();
                        qwe = R.drawable.rydz;
                        qwe2 = R.drawable.swierkowymlbig;
                        list1 = "Mleczaj rydz Lactarius deliciosus,".toString();
                        list2 = "ma bardziej wyraziste prążki na kapeluszu i rośnie pod sosnami. Zielenieje tylko po uszkodzeniu;";
                        list13 = "ma pomarańczowy sok nie zmieniający barwy i kapelusz bez śladu zielonkawego zabarwienia. Rośnie pod jodłami;";
                        list3 = "Mleczaj jodłowy Lactarius salmonicolor,";
                        qwe3 = R.drawable.jodlowy;
                        list14 = "ma mlecznobiały sok i rośnie tylko pod modrzewiami;";
                        list4 = "Mleczaj modrzewiowy Lactarius porninsis,";
                        qwe4 = R.drawable.modrzewiowy;
                        list15 = "sok winnoczerwony, kapelusz z domieszką zielonej barwy.";
                        list5 = "Mleczaj czerwieniejący Lactarius sanguifluus,";
                        qwe5 = R.drawable.czerwieniejacyml;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 130:
                        TempListViewClickedValue = "Mleczaj wełnianka Lactarius torminosus".toString();
                        TempListViewClickedValue2 = "Owocnik 5-12 cm średnicy; początkowo wypukły, coraz bardziej się rozpłaszcza, aż w końcu staje się lejkowaty; brzeg jest pokryty nieregularnie rozsypanymi, długimi włoskami; pokryty wyrośniętymi włóknami; powleczony śluzem, który podczas wilgoci staje się kleisty i śliski; barwa soczyście karminowoczerwona, różowawa, która blednie z czasem do bladoochrawej.\n" +
                                "\n" +
                                "Skóra poznaczona jest ciemniejszymi, wodnistymi, koncentrycznymi strefami. \n" +
                                "\n" +
                                "Blaszki białe, z wiekiem kremowe, z różowym odcieniem, wąskie, gęste, zbiegające na trzon. \n" +
                                "\n" +
                                "Trzon kremowy, ochrowy, często z różowym odcieniem, czasem z ciemniejszymi plamkami; 30-100 na 15-30 mm; walcowaty, zwykle dość krótki; powierzchnia często dołkowana, poza tym gładki. \n" +
                                "\n" +
                                "Miąższ w kapeluszu białawy, z odcieniem różowawym, w trzonie silniej czerwonawy; zapach lekko owocowy lub terpentyny; smak ostry; białawy sok mleczny początkowo płynie obficie, nie przebarwia się, ma palący smak. \n" +
                                "\n" +
                                "Pospolity pojedynczo lub w grupach, pod brzozami, w lasach iglastych i mieszanych, na glebach kwaśnych, pisakach i glinach. \n" +
                                "\n" +
                                "Zastosowanie - trujący. \n".toString();
                        qwe = R.drawable.francuskiml;
                        qwe2 = R.drawable.welniankabig;
                        list1 = "Mleczaj francuski Lactarius mairei,".toString();
                        list2 = "ma mniejsze owocniki;";
                        list13 = "ma pomarańczowo zabarwiony sok mleczny.";
                        list3 = "Mleczaj rydz Lactarius deliciosus,";
                        qwe3 = R.drawable.rydz;
                        jedzenie = R.drawable.trujacy;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.trujacy);
                        break;
                    case 131:
                        TempListViewClickedValue = "Monetnica maślana Rhodocollybia butyracea".toString();
                        TempListViewClickedValue2 = "Owocnik higrofaniczny, czerwonociemnobrązowy, żółtobrązowy do prawie białego, gdy suchy, brzeg jaśniejszy, wyraźnie prążkowany u wilgotnych kapeluszy; 3-10 cm średnicy; początkowo nieco wypukły, potem spłaszczony, z niewysokim garbkiem, z wiekiem czasem z wywiniętym brzegiem.\n" +
                                "\n" +
                                "Powierzchnia gładka, jedwabista, w dotyku tłusta. \n" +
                                "\n" +
                                "Blaszki białawe, szerokie, gęste, przy trzonie wykrojone do wolnych; ostrza drobno karbowane. \n" +
                                "\n" +
                                "Trzon jaśniejszy od kapelusza; 40-80 na 7-15 mm, równomiernie rozszerzajacy się ku podstawie; powierzchnia włóknisto-prążkowana; elastyczny, wnętrze gąbczaste, z wiekiem pusty; podstawa pokryta filcowato białą grzybnią. \n" +
                                "\n" +
                                "Miąższ białawy, niezmienny; smak łagodny; bez zapachu. \n" +
                                "\n" +
                                "Bardzo pospolity. Owocniki wyrastają zwykle gromadnie, od lata do późnej jesieni, w lasach liściastych i iglastych. \n" +
                                "\n" +
                                "Zastosowanie - jadalny, bez trzonów. \n".toString();
                        qwe = R.drawable.mydlana;
                        qwe2 = R.drawable.maslanabig;
                        list1 = "Gąska mydlana Tricholoma saponaceum,".toString();
                        list2 = "młode i ciemno wybarwione osobniki mogą być pomylone;";
                        list13 = "podobny wygląd starszych osobników.";
                        list3 = "Kępkowiec brązowooliwkowy Lyophyllum inolens,";
                        qwe3 = R.drawable.brazowooliwkowy;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t7;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 132:
                        TempListViewClickedValue = "Muchomor cesarski Amanita caesarea".toString();
                        TempListViewClickedValue2 = "Owocnik młode całkowicie pokryte stosunkowo grubą, białą skórkowatą osłoną. w formie „jaja” wystającym tylko częściowo nad powierzchnie gleby. Później półkolisty, w końcu płasko wypukły, gładki. Brzeg wyraźnie na brzegu prążkowany, bruzdowaty. Barwy pomarańczowej z wiekiem złotożółty z pomarańczowym odcieniem. 8-18cm średnicy. \n" +
                                "\n" +
                                "Blaszki początkowo jasnożółte, potem złotożółte, ostrze drobno ząbkowane. Dość gęste i wolne, szerokie, początkowo pokryte żółtą osłoną. \n" +
                                "\n" +
                                "Trzon 8-15cm wysoki 2-3 cm grubości. Cylindryczny żółty do złotożółtego. Osłona zostaje przy podstawie trzonu w postaci wysokiej, odstającej bulwiastej pochwy. \n" +
                                "\n" +
                                "Pierścień delikatny, zwisający prążkowany, cienko skórkowy, barwy trzonu. \n" +
                                "\n" +
                                "Miąższ biały, tylko pod skórką kapelusza i trzonu złotożółty. Zapach i smak przyjemny. \n" +
                                "\n" +
                                "Występuje na przełomie lata i jesieni, na wapiennych glebach, w świetlistych starodrzewiach liściastych, przeważnie pod dębami i kasztanowcami. \n" +
                                "\n" +
                                "Zastosowanie - jadalny. \n".toString();
                        qwe = R.drawable.czerwonymuch;
                        qwe2 = R.drawable.cesarskimuchbig;
                        list1 = "Muchomor czerwony Amanita muscaria,".toString();
                        list2 = "białe blaszki i trzon.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.t6;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 133:
                        TempListViewClickedValue = "Muchomor cytrynowy Amanita citrina".toString();
                        TempListViewClickedValue2 = "Owocnik cytrynowożółty, bladożółty, z nielicznymi, nieregularnie ułożonymi, dużymi, grubymi, filcowatymi łatkami, powstałymi z resztek osłony; łatki białawe, z wiekiem żółknące; średnica kapelusza 4-10 cm; początkowo półkulisty, potem wypukły do rozpostartego.\n" +
                                "\n" +
                                "Skórka kleiście połyskująca, daje się ściągnąć; brzeg kapelusza bez prążków. \n" +
                                "\n" +
                                "Blaszki białawe do bladożółtawych, dość szerokie, wybrzuszone; gęsto ustawione, o płatkowatym wygięciu, wolne, miękkie. \n" +
                                "\n" +
                                "Trzon białawy lub z żółtawym odcieniem, z bladożółtym, zygzakowatym wzorem, do 12 cm na 7-20 mm; cylindryczny, wysmukły, szczyt nieco zwężony; początkowo pełny, potem z kanałem; pochwa ściśle przyrośnięta do dużej, bulwiaście zgrubiałej podstawy trzonu; bulwa ostro zarysowana, kulista. \n" +
                                "\n" +
                                "Pierścień biały jasnożółtawy, zwisający, nieprążkowany, trwały. \n" +
                                "\n" +
                                "Miąższ biały, niezmienny, miękki i kruchy; zapach wyraźny, charakterystyczny dla kiełkujących ziemniaków. \n" +
                                "\n" +
                                "Bardzo pospolity. Owocniki pojawiają się od lata do jesieni, w lasach iglastych i liściastych. \n" +
                                "\n" +
                                "Zastosowanie - niejadalny. \n".toString();
                        qwe = R.drawable.zielonawymuch;
                        qwe2 = R.drawable.cytrynowybig;
                        list1 = "Muchomor zielonawy Amanita phalloides,".toString();
                        list2 = "o wyraźnej otwartej pochwie i innym zapachu.";
                        jedzenie = R.drawable.niejadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t6;
                        jadalnosc.setImageResource(R.drawable.niejadalny);
                        break;
                    case 134:
                        TempListViewClickedValue = "Muchomor czerwieniejący Amanita rubescens"+"\n"+"jako Muchomor czerwonawy".toString();
                        TempListViewClickedValue2 = "Owocnik do 15 cm średnicy; jasnobrązowy, ochrowobrązowy, zazwyczaj mniej lub bardziej czerwony, brązowawoczerwony; kapelusz pokryty delikatnymi białożółtymi lub różowymi łatkami, zwykle dość drobnymi i koncentrycznie ułożonymi.\n" +
                                "\n" +
                                "Powierzchnia wilgotna jest nieco lepka, poza tym sucha; półkulisty, potem wypukły, szeroko parasolowaty. \n" +
                                "\n" +
                                "Trzon do 15 cm wysokości i 1-4 cm grubości, mięsisty; początkowo na białym tle pojawia się lekko różowe zabarwienie, z czasem przechodzi w winnoczerwone, ku podstawie rozszerza się bulwiasto, niekiedy z słabo wyraźnym brodawkowym pasem. \n" +
                                "\n" +
                                "Pierścień zwisający, białaworóżowy, silnie bruzdkowaty. \n" +
                                "\n" +
                                "Miąższ biały, przebarwiający się czerwonawo, zwłaszcza wokół korytarzy wyjedzonych przez larwy owadów, kruchy; smak łagodny; zapach słaby. \n" +
                                "\n" +
                                "Bardzo pospolity. Owocniki pojawiają się od czerwca do października, w lasach iglastych i liściastych. \n" +
                                "\n" +
                                "Zastosowanie - jadalny po dostatecznym ugotowaniu, zalecana ostrożność. \n".toString();
                        qwe = R.drawable.twardawy;
                        qwe2 = R.drawable.czerwieniejacybig;
                        list1 = "Muchomor twardawy Amanita spissa,".toString();
                        list2 = "z niezmiennym miąższem i brakiem czerwonawych odcieni;";
                        list13 = "jego miąższ nie czerwienieje, pierścień nie jest bruzdowany, a bulwa u podstawy trzonu jest obrzeżona.";
                        list3 = "Muchomor plamisty Amanita pantherina,";
                        qwe3 = R.drawable.plamisty;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t6;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 135:
                        TempListViewClickedValue = "Muchomor czerwony Amanita muscaria".toString();
                        TempListViewClickedValue2 = "Owocnik czerwony lub pomarańczowy, pokryty białymi plamkami; w stadium młodocianym pojawia się jako biała kulka, wkrótce rozwija się w kapelusz 5-15 cm średnicy; biała osłona rozpada się na białe płatki, które zostają przyczepione do powierzchni kapelusza.\n" +
                                "\n" +
                                "Skóra błyszcząca, ściągalna, w czasie wilgotnej pogody lepka; brzeg kapelusza długo gładki, u starych okazów prążkowany. \n" +
                                "\n" +
                                "Blaszki białe do kremowych, dość gęste, brzuchate, wolne. \n" +
                                "\n" +
                                "Trzon biały lub żółtawy; 6-15 cm na 15-30 mm; cylindryczny; podstawa bulwiasta, kulista do jajowatej. \n" +
                                "\n" +
                                "Pierścień wyraźny, biały lub białożółtawy, zwieszony, nieprążkowany, brzeg pierścienia biały lub żółtawo ząbkowany. \n" +
                                "\n" +
                                "Miąższ bez smaku i zapachu, pod skórką kapelusza żółtawy. \n" +
                                "\n" +
                                "Bardzo pospolity, wyrastaja pojedynczo i w grupach, od lata do jesieni, w lasach iglastych i liściastych, często w towarzystwie brzóz. \n" +
                                "\n" +
                                "Zastosowanie - niejadalny, trujący. \n".toString();
                        qwe = R.drawable.krolewski;
                        qwe2 = R.drawable.czerwonymuchbig;
                        list1 = "Muchomor królewski Amanita regalis,".toString();
                        list2 = "kapelusz koloru umbrowobrunatnego.";
                        jedzenie = R.drawable.trujacy;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t6;
                        jadalnosc.setImageResource(R.drawable.trujacy);
                        break;
                    case 136:
                        TempListViewClickedValue = "Muchomor jadowity Amanita virosa".toString();
                        TempListViewClickedValue2 = "Kapelusz biały, kremowy, z wiekiem może żółknąć; 4-8 cm średnicy, początkowo owalny, potem stożkowato-dzwonkowaty, z szerokim, obłym garbkiem; brzeg kapelusza ostry, długo podwinięty, zwykle nieregularny, czasem ze zwieszającymi się resztkami osłony. \n" +
                                "\n" +
                                "Powierzchnia kapelusza gładka, wilgotna kleista, sucha połyskuje matowo.\n" +
                                "\n" +
                                "Blaszki białe, z kremowym odcieniem, szerokie, wolne, ostrza z kłaczkami. \n" +
                                "\n" +
                                "Trzon cylindryczny, w górze zwężony, z bulwiastą podstawą, z wiekiem wysmukły; 7-15 cm na 0,8-2 cm, powierzchnia z dużymi włóknistymi łuskami, białymi resztkami osłony; biały; bulwiasta podstawa z przylegającą, błoniastą pochwą z odstającym brzegiem; pełny, z wiekiem z pustym kanałem; twardy, łamliwy. \n" +
                                "\n" +
                                "Pierścień biały, żółknący, błoniasty, nietrwały szybko pozostają tylko jego strzępy. \n" +
                                "\n" +
                                "Miąższ biały, gruby w centrum kapelusza, cienki na brzegach, zapach nieco nieprzyjemny, smak łagodny, nie wyróżniający się. \n" +
                                "\n" +
                                "Występuje nieczęsto w lasach szpilkowych, rzadziej liściastych. Owocniki wyrastają pojedynczo lub w małych grupach, od lata do jesieni, na ubogich, wilgotnych, kwaśnych glebach. \n" +
                                "\n" +
                                "Zastosowanie - śmiertelnie trujący!\n".toString();
                        qwe = R.drawable.wiosenny;
                        qwe2 = R.drawable.jadowitybig;
                        list1 = "Muchomor wiosenny Amanita verna,".toString();
                        list2 = "ma kapelusz czysto biały oraz gładki trzon;";
                        list13 = "powierzchnia szarozielona.";
                        list3 = "Muchomor sromotnikowy Amanita phalloides,";
                        qwe3 = R.drawable.sromotnikowy;
                        jedzenie = R.drawable.trujacy;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t6;
                        jadalnosc.setImageResource(R.drawable.trujacy);
                        break;
                    case 137:
                        TempListViewClickedValue = "Muchomor oliwkowy Amanita battarae".toString();
                        TempListViewClickedValue2 = "Kapelusz młody  początkowo stozkowaty, potem łukowaty do płasko rozpostartego. Wierzchołek tępy lub nieco  wklęsły. Barwy żółtobrązowej, oliwkowobrązowej oliwkowoszarej. \n" +
                                "\n" +
                                "Powierzchnia jest gładka, lepka, strefowana. Brzeg kapelusza jest prążkowany.\n" +
                                "\n" +
                                "Blaszki białe, w kierunku do środka brązowieją; ostrza blaszek są gładkie; średno gęste.\n" +
                                "\n" +
                                "Trzon szarobrązowy, brudnobrązowy,brudnobiały, pokryty włókienkami, cylindryczny i zwężający się ku górze. Początkowo jest pełny, później pusty w środku. Podstawa trzonu otoczona wolną, błoniastą pochwą o brudnobiałym kolorze, czasami poszarpaną na fragmenty.\n" +
                                "\n" +
                                "Miąższ biały, kruchy, smak ma łagodny i bez wyraźnego zapachu.\n" +
                                "\n" +
                                "Występuje od czerca do września; lasy liściaste i iglaste; pod sosnami, świerkami, jodłami i bukami.\n".toString();
                        qwe2 = R.drawable.oliwkowybig;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t6;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 138:
                        TempListViewClickedValue = "Muchomor plamisty Amanita pantherina".toString();
                        TempListViewClickedValue2 = "Owocnik brązowożółty, jasnobrązowy do ciemnobrązowego, na skórce znajduje się wiele białych regularnie rozmieszczonych łatek, z czasem spłukiwane przez deszcz zanikają. Kapelusz 4-12cm średnicy, młody półkulisty, potem wypukły i płaski.\n" +
                                "\n" +
                                "Powierzchnia wilgotna nieco lepka, sucha jedwabista, brzeg wyraźnie prążkowany, długo podwinięty. \n" +
                                "\n" +
                                "Blaszki białe, gęste, wolne; ostrza z białymi kłaczkami. \n" +
                                "\n" +
                                "Trzon biały o wymiarach 5-15cm na 1-2.5cm, równogruby, podstawa bulwiasto zgrubiała, z ostro zaznaczonym brzegiem, młody pełny, z wiekiem pusty. \n" +
                                "\n" +
                                "Pierścień błoniasty, zwisający, górna powierzchnia pierścienia gładka, nie prążkowana, resztki osłony w postaci jednego lub kilku wałeczkowatych pierścieni nad bulwką. \n" +
                                "\n" +
                                "Bulwa posiada zgrubienie zagięte do wewnątrz tak zwana skarpetą taternicka. \n" +
                                "\n" +
                                "Miąższ biały, kruchy, posiada słaby zapach rzodkwi, smak łagodny. \n" +
                                "\n" +
                                "Pospolity od lata do jesieni, pojedynczo lub w grupach w lasach liściastych i iglastych, częstszy w suchych lasach sosnowych na piaskach. i glebach kwaśnych, jak i w górskich lasach świerkowych. \n" +
                                "\n" +
                                "Zastosowanie- silnie trujący!\n".toString();
                        qwe = R.drawable.czerwonymuch;
                        qwe2 = R.drawable.plamistybig;
                        list1 = "Muchomor czerwony Amanita muscaria,".toString();
                        list2 = "kolor kapelusza czerwony;";
                        list13 = "kapelusz pokryty dużymi, białoszarymi łatami;";
                        list3 = "Muchomor twardawy Amanita excelsa,";
                        qwe3 = R.drawable.twardawy;
                        list14 = "powierzchnia sucha, pokryta brązoworóżowymi łatkami różnej wielkości.";
                        list4 = "Muchomor czerwieniejący Amanita rubescens,";
                        qwe4 = R.drawable.czerwieniejacy;
                        jedzenie = R.drawable.trujacy;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t6;
                        jadalnosc.setImageResource(R.drawable.trujacy);
                        break;
                    case 139:
                        TempListViewClickedValue = "Muchomor rdzawobrązowy Amanita fulva".toString();
                        TempListViewClickedValue2 = "Owocnik pomarańczowobrązowy do ciemnobrązowego, młody dzwonkowaty, potem wypukły, w końcu rozpostarty z niewielkim garbkiem 3-11cm średnicy.\n" +
                                "\n" +
                                "Powierzchnia gładka, wilgotna błyszcząca, lepka, brzeg silnie, promieniście bruzdkowaty. \n" +
                                "\n" +
                                "Blaszki wolne, białawe, szerokie, gęsto ułożone, kruche. \n" +
                                "\n" +
                                "Trzon pusty, 7-12cm na 5-20 mm, cylindryczny, stopniowo zwężający się ku szczytowi, białawy, bez pierścienia, z delikatnymi przylegającymi łuseczkami, u podstawy trzonu wyraźna, workowata, poszarpana pochwa, biała z pomarańczowo-brązowymi plamami na zewnętrznej powierzchni. \n" +
                                "\n" +
                                "Miąższ biały, delikatny, kruchy, bez określonego zapachu i łagodnym smaku. \n" +
                                "\n" +
                                "Pospolity w lasach liściastych i iglastych od lipca do października. \n" +
                                "\n" +
                                "Zastosowanie- jadalny. \n".toString();
                        qwe = R.drawable.mglejarka;
                        qwe2 = R.drawable.rdzawobrazowybig;
                        list1 = "Muchomor mglejarka Amanita vaginata,".toString();
                        list2 = "o popielatym kapeluszu;";
                        list13 = "jest pomarańczowordzawy, masywniejszy, z pomarańczowym trzonem.";
                        list3 = "Muchomor żółtawy Amanita crocea,";
                        qwe3 = R.drawable.zoltawymu;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t6;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 140:
                        TempListViewClickedValue = "Muchomor sromotnikowy Amanita phalloides".toString();
                        TempListViewClickedValue2 = "Kapelusz o średnicy 5-15 cm, za młodu półkulisty, potem dzwonkowato-łukowaty, w końcu rozpostarty. Kolor biało zielonkawy, oliwkowo zielonkawy, szarozielony, brunatnozielony, na brzegu zwykle jaśniejszy, czasem żółtawy. Na słońcu, oraz u starszych okazów kolor jest wypłowiały. \n" +
                                "\n" +
                                "Skórka gładka, przy brzegu nieprążkowana, składa się z przylegających i promieniście ułożonych włókienek. Łatwo daje się ściągnąć i często występują na niej białe resztki osłony.\n" +
                                "\n" +
                                "Trzon o wysokości do 15 cm, grubości do 2 cm. Jest walcowaty, w nasadzie zakończony bulwą o średnicy do 4 cm. Bulwa otoczona jest wysoką, białawą i odstającą pochwą. Kolor trzonu białawy z odcieniem żółtawo-zielonkawym. Posiada wyraźny, zwisający pierścień o kolorze od białego do żółtawego. Powyżej pierścienia trzon jest gładki, pod pierścieniem występują delikatne łuski, czasami tworzące zygzakowaty wzór.\n" +
                                "\n" +
                                "Miąższ biały, nie zmienia koloru po przełamaniu. U młodych okazów miąższ ma łagodny zapach, u starych pachnie nieco ziemniakami. Smak przyjemny.\n" +
                                "\n" +
                                "Blaszki gęste, białe, u starych okazów z lekkim odcieniem żółtawo-zielonkawym. U młodych okazów są niewidoczne, gdyż przykryte są białawą osłoną.\n" +
                                "\n" +
                                "Występuje najczęściej w lasach liściastych; rośnie pojedynczo, lub w małych grupkach. Najczęściej rośnie pod dębami, (bukami, kasztanowcami, sosnami i świerkami). Owocniki wyrastają od czerwca do listopada.\n" +
                                "\n" +
                                "Zastosowanie - niejadalny, trujący. \n".toString();
                        qwe = R.drawable.zielonka;
                        qwe2 = R.drawable.sromotnikowybig;
                        list1 = "Gąska zielonka Tricholoma equestre,".toString();
                        list2 = "rośnie w piaskach, jest mała i od spodu jest żółta.";
                        list13 = "ma kapelusz o barwie oliwkowozielonej, szarozielonej lub żółtawozielonej, blaszki białawe, po skaleczeniu oraz u starszych owocników rdzawe lub brązowe, twardy miąższ;";
                        list3 = "Gołąbek zielonawy Russula virescens,";
                        qwe3 = R.drawable.zielonawymuch;
                        list14 = "na nóżce ma pierścień i wewnątrz nóżki ma dziurkę.";
                        list4 = "Czubajeczka kania Macrolepiota procera,";
                        qwe4 = R.drawable.kania;
                        jedzenie = R.drawable.trujacy;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t6;
                        jadalnosc.setImageResource(R.drawable.trujacy);
                        break;

                    case 141:
                        TempListViewClickedValue = "Muchomor szarawy Amanita vaginata".toString();
                        TempListViewClickedValue2 = "Kapelusz początkowo dzwonkowaty, później płaskołukowaty, w końcu całkiem płaski, Ma średnicę 3-10 cm i na środku garb, czasami wyraźny, czasami słabo widoczny. Kolor od siwego poprzez siwobrązowy i popielaty do żółtosiwobrązowego.\n" +
                                "\n" +
                                "Powierzchnia gładka, naga i silnie prążkowana, szczególnie na brzegach. W czasie wilgotnej pogody jest lepki i śliski. \n" +
                                "\n" +
                                "Blaszki średnio gęste, spręzyste, nie przyrastają do trzonu, nieco wybrzuszone i zawsze białe.\n" +
                                "\n" +
                                "Trzon o wysokości 10-20 cm, grubości 8-20 mm, walcowaty, z czasem pusty w środku, zwężający się ku górze, wyrastający z białej, wolnej i płatowatej pochwy. Powierzchnia gładka lub pokryta bardzo drobnymi kosmkami, czasami promieniście popękany. Barwa między białą a różnymi odcieniami jasnej szarości.\n" +
                                "\n" +
                                "Miąższ u młodych okazów zwarty, później kruchy. Biały, o łagodnym smaku i bez specjalnego zapachu.\n" +
                                "\n" +
                                "Występuje w lasach iglastych i liściastych. Można go spotkać pojedynczo lub w małych grupach. \n" +
                                "\n" +
                                "Zastosowanie - jadalny, choć w stanie surowym trujący.\n".toString();
                        qwe = R.drawable.srebrzysty;
                        qwe2 = R.drawable.szarawybig;
                        list1 = "Muchomor srebrzysty Amanita mairei,".toString();
                        list2 = "jest większy i nie tak szary.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t6;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 142:
                        TempListViewClickedValue = "Muchomor szyszkowaty Amanita strobiliformis".toString();
                        TempListViewClickedValue2 = "Owocnik białawoszary do jasnoszarego 8-20cm, początkowo półkulisty, później wypukły, płaski, w centrum zagłębiony, płatowate łatki tej samej barwy lub ciemniejsze, miękkie i delikatne, zwieszające się z brzegu kapelusza, brzeg ostry. \n" +
                                "\n" +
                                "Blaszki białe, gęste, szerokie, ostrza gładkie. \n" +
                                "\n" +
                                "Trzon biały, 12-20cm na 20-35mm, nasada bulkowata głęboko tkwiąca w podłożu, nieco rozszerzający się ku podstawie, twardy, trzon pełny. \n" +
                                "\n" +
                                "Pierścień nietrwały szybko odpadający, kłaczkowaty, z wierzchu prążkowany. \n" +
                                "\n" +
                                "Miąższ biały, w owocniku gruby, zapach słaby, przyjemny rzodkwi, smak słaby, łagodny. \n" +
                                "\n" +
                                "Występuje rzadko, latem, zazwyczaj pojedynczo, w miejscach ciepłych, wilgotnych i żyznych, w lasach liściastych, mieszanych. \n" +
                                "\n" +
                                "Zastosowanie-jadalny. \n".toString();
                        qwe = R.drawable.jadowity;
                        qwe2 = R.drawable.szyszkowatybig;
                        list1 = "Muchomor jadowity Amanita virosa,".toString();
                        list2 = "równeż ma bulwiastą nasadę, zwykle ma cieńszy trzon.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t6;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 143:
                        TempListViewClickedValue = "Naparstniczka stożkowata Verpa conica".toString();
                        TempListViewClickedValue3 = "Gatunek objęty ochroną częściową w Polsce!  ".toString();
                        TempListViewClickedValue2 = "Główka prawie gładka, dzwonkowata, szeroko stożkowana. Gładka lub nieregularnie jamkowata. 2-4 cm wysokości, 1-1,5 cm szerokośći. Barwa ochrowobrązowa do brązowej. \n" +
                                "\n" +
                                "Trzon  u wyrośniętej naparstniczki jest o wiele dłuższy niż kapelusz, od 3 do 10 cm przy szerokości od 0,5 do 1,5 cm. Wnętrze trzonu jest puste. \n" +
                                "\n" +
                                "Miąższ bardzo cienki. \n" +
                                "\n" +
                                "Występuje w lasach liściastych, pod osikami, jarzębinami, olchami, krzakami tarniny, w zaroślach nadrzecznych, w środkowym paśmie półkuli północnej, jest rzadka w rejonach bardzo chłodnych. Pojawia się wcześnie. \n" +
                                "\n" +
                                "Zastosowanie - jadalna.\n".toString();
                        qwe2 = R.drawable.stozkowatabig;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t9;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 144:
                        TempListViewClickedValue = "Naziemek białawy Albatrellus ovinus"+"\n"+"jako Bielaczek owczy".toString();
                        TempListViewClickedValue3 = "Gatunek objęty ochroną w Polsce!".toString();
                        TempListViewClickedValue2 = "Kapelusz o średnicy do 6 cm, młody wypukły, później często nieregularny, barwy białoszarej, zmieniającej się z wiekiem w szarobrązową, często przebija kolor żółty. \n" +
                                "\n" +
                                "Rurki szerokości 5-10 mm, białe, białawe, kremowobiałe, zatokowato wycięte, cienkie, gęste. \n" +
                                "\n" +
                                "Trzon krótki i gruby, mocny i mięsisty, w kolorze kapelusza. \n" +
                                "\n" +
                                "Miąższ biały, stary zabarwiający się na żółto, o zapachu migdałów. \n" +
                                "\n" +
                                "Występuje od lipca do października gromadnie w lasach iglastych, pod świerkiem, częściej w górach.\n" +
                                "\n" +
                                "Zastosowanie- jadalny.\n".toString();
                        qwe = R.drawable.ceglasty;
                        qwe2 = R.drawable.bialawynazbig;
                        list1 = "Naziemek ceglasty Albatrellus confluens,".toString();
                        list2 = "ma wysyp zarodników wyraźnie amyloidalny, a nie elipsoidalny.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.def2;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 145:
                        TempListViewClickedValue = "Naziemek ceglasty Albatrellus confluens"+"\n"+"jako Bielaczek pozrastany".toString();
                        TempListViewClickedValue3 = "Gatunek objęty ochroną w Polsce!".toString();
                        TempListViewClickedValue2 = "Kapelusz średnicy 30 do 150 mm, półkulisty albo nieregularnie okrągły, przy brzegach płatkowaty. \n" +
                                "\n" +
                                "Powierzchnia kremowa, morelowa, niekiedy z odcieniem pomarańczowym, czerwonomięsistym, czerwonobrązowym; matowa, w okresie suchym popękana.\n" +
                                "\n" +
                                "Rurki długości do 3 mm, krótkie, zbiegające na trzon, białe.\n" +
                                "\n" +
                                "Pory bardzo małe, koliste; najpierw białe, potem kremowe.\n" +
                                "\n" +
                                "Trzon 30 do 60 mm wysokości, 20 do 25 mm grubości, krótki, mało wyraźny, centralny, ekcentryczny lub boczny; biały, czasami z morelowym, rdzawym odcieniem i plamkami.\n" +
                                "\n" +
                                "Miąższ spoisty, mięsisty, nierobaczywiejący, biały, kremowy; przy zasychaniu różowieje. Zapach słaby, przyjemny; smak gorzkawy.\n" +
                                "\n" +
                                "Występuje w borach iglastych i mieszanych, najczęściej w górskich lasach świerkowych; wyrasta w stłoczonych kępach, od lipca do października.\n" +
                                "\n" +
                                "Zastosowanie – jadalny, starsze niesmaczne.\n".toString();
                        qwe = R.drawable.zoltopomaran;
                        qwe2 = R.drawable.ceglastybig;
                        list1 = "Naziemek żółtopomarańczowy Albatrellus subrubescens,".toString();
                        list2 = "ma owocnik kapeluszowaty, z wyraźniejszym trzonem, kapelusz brązowofioletowy, trzon białawy z pomarańczowofioletowymi plamami, rośnie w borach sosnowych;";
                        list13 = "ma jasny kapelusz, pory cytrynowożółte, miąższ zasychając żółknie i nie rośnie w pozrastanych kępach;";
                        list3 = "Naziemek białawy Albatrellus ovinus,";
                        qwe3 = R.drawable.bialawynaz;
                        list14 = "ma kapelusz w barwie żółtozielonej, do brązowej i rośnie w lasach liściastych, głównie w buczynach, choć spotkać go można również w górskich lasach iglastych.";
                        list4 = "Naziemek zielonawy Albatrellus cristatus,";
                        qwe4 = R.drawable.zielonawynaz;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.def2;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 146:
                        TempListViewClickedValue = "Opieńka bezpierścieniowa Armillaria tabascens"+"\n"+"jako Opieńka nietrwała".toString();
                        TempListViewClickedValue2 = "Kapelusz o średnicy 2-10 cm, początkowo płasko półkulisty z garbem na środku, następnie płaski. Brzeg kapelusza długi czas pozostaje podwinięty. Kolor rdzawobrązowy, ochrowobrązowy z ziarnistymi, drobnymi brązowymi łuseczkami, wyraźniej skupionymi pośrodku kapelusza.\n" +
                                "\n" +
                                "Blaszki gęste, nieco zbiegające na trzon, najpierw kremowe, później brązowe.\n" +
                                "\n" +
                                "Trzon grubości do 1,5 cm i wysokości 5-15 cm, walcowaty, zagięty, pełny i włóknisty. U starszych okazów wydrążony albo z watowatym jednolitym wypełnieniem. Pod kapeluszem białawy i błyszczący, niżej w kolorze od ochrowobrązowego do brązowoczerwonego, u nasady ciemniejszy. Charakterystyczną cechą jest brak pierścienia.\n" +
                                "\n" +
                                "Miąższ W kapeluszu białawy, sprężysty i twardy w trzonie brązowy, włóknisty, twardy. smak i zapach niewyraźny.\n" +
                                "\n" +
                                "Rośnie zarówno na martwych, jak i żywych drzewach liściastych, głównie na bukach.\n" +
                                "\n" +
                                "Zastosowanie - jadalny. \n".toString();
                        qwe = R.drawable.miodowaopi;
                        qwe2 = R.drawable.bezpierscieniowabig;
                        list1 = "Opieńka miodowa Armillaria mellea,".toString();
                        list2 = "ma kapelusz z bardzo drobnymi kosmkami, nieraz całkowicie trzonu;";
                        list13 = "ma na kapeluszu wyraźne, duże kosmki i występuje tylko na drzewach iglastych (głównie na świerku).";
                        list3 = "Opieńka ciemna Armillaria ostoyae,";
                        qwe3 = R.drawable.ciemnaopi;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.t7;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 147:
                        TempListViewClickedValue = "Opieńka miodowa Armillaria mellea".toString();
                        TempListViewClickedValue2 = "Kapelusz o średnicy 3-13 cm. Najpierw jest półkulisty, wypukły, później spłaszczony. Za młodu barwy miodowożółtej, oliwkowożółtej potem oliwkowobrązowy, ciemnoczerwonobrązowy. Pokryty drobnymi czerwonobrązowymi, brązowymi lub czarniawymi łuseczkami, które są najciemniejsze i najgęstsze pośrodku. U starych okazów łuski często zanikają i kapelusz jest nagi.\n" +
                                "\n" +
                                "Blaszki początkowo białawe, później beżoworóżowawe, żółtawe z brązowawymi plamami zbiegające, cienkie.\n" +
                                "\n" +
                                "Trzon wysokości 8-18 cm, grubości 0,5-2,5 cm; żółtawy, miodowobrązowy, czerwonobrązowy, czarnobrązowy, u szczytu bledszy wysmukły, cylindryczny, wygięty, o podstawie rozszerzonej, szorstkiej i ciemniejszej. Trzony sąsiednich grzybów często są zrośnięte razem. Posiada szeroki błoniasty pierścień złotożółtego koloru, który w dolnej części pokryty jest żółtymi kosmkami.\n" +
                                "\n" +
                                "Miąższ białawy, bladocielisty, nie zmienia barwy po przekrojeniu, u młodych owocników miękki, mięsisty, u starych twardy i łykowaty (zwłaszcza w trzonie).\n" +
                                "\n" +
                                "Występuje najczęściej jesienią od września do listopada, ale czasami może pojawić się nawet na początku sierpnia. Zwykle występuje gromadnie, czasami bardzo licznie. Rośnie na drewnie różnych gatunków drzew liściastych.\n" +
                                "\n" +
                                "Zastosowanie - jadalny.\n".toString();
                        qwe = R.drawable.ciemnaopi;
                        qwe2 = R.drawable.miodowaopibig;
                        list1 = "Opieńka ciemna Armillaria ostoyae,".toString();
                        list2 = "występuje tylko na drzewach iglastych i ma kapelusz z wyraźnymi kosmkami;";
                        list13 = "nie posiada pierścienia na trzonie.";
                        list3 = "Opieńka bezpierścieniowa Armillaria tabescens,";
                        qwe3 = R.drawable.bezpierscieniowa;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.t7;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 148:
                        TempListViewClickedValue = "Opieńka ciemna Armillaria ostoyae".toString();
                        TempListViewClickedValue2 = "Kapelusz młody, wypukły, z podwiniętym brzegiem, z czasem płaski i gładki, różowobrązowwy do ciemnobrązowego, z bardzo licznymi, skupionymi w pęczkach, ciemnobrązowymi łuskami na całej powierzchni, najgęściej w środkowej części, rzadziej na brzegu.\n" +
                                "\n" +
                                "Blaszki na początku jasnokremowe, z czasem brązowawe, z brązowymi plamami, gęste, zbiegające po trzonie.\n" +
                                "\n" +
                                "Trzon walcowaty, z licznymi trwałymi nalotami białej grzybni z ciemnobrązowymi kosmkami; z pierścieniem, bardzo wyraźnym, dobrze uformowanym, białym, z regularnie rozmieszczonymi, ciemnobrązowymi włókienkami grzybni.\n" +
                                "\n" +
                                "Miąższ początkowo białawy, potem brązowawy; bez zapachu i o łagodnym smaku.\n" +
                                "\n" +
                                "Występowanie na pniakach, pniach drzew i krzewów iglastych i liściastych; pojawiają się już na początku lub w połowie września i w drugiej połowie października, aż do pierwszych mrozów.\n" +
                                "\n" +
                                "Zastosowanie - jadalny.\n".toString();
                        qwe = R.drawable.miodowaopi;
                        qwe2 = R.drawable.ciemnaopibig;
                        list1 = "Opieńka miodowa Armillaria mellea,".toString();
                        list2 = "występuje na obumarłych drzewach liściastych i ma kapelusz z bardzo drobnymi kosmkami, nieraz całkowicie nagi;";
                        list13 = "nie posiada pierścienia na trzonie.";
                        list3 = "Opieńka bezpierścieniowa Armillaria tabescens,";
                        qwe3 = R.drawable.bezpierscieniowa;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t7;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;

                        case 149:
                        TempListViewClickedValue = "Ozorek dębowy Fistulina hepatica".toString();
                        TempListViewClickedValue3 = "Gatunek objęty ochroną częściową w Polsce!".toString();
                        TempListViewClickedValue2 = "Językowaty, konsolkowaty kapelusz. Miewa on średnicę 10-20 cm, grubość 2-6 cm i kolor pomarańczowo-krwistoczerwony lub czerwonobrązowy. Dolna strona kapelusza składa się z pojedynczych rurek nie zrośniętych z sobą ściankami. Pory o jednolitym, żółtawobiałym zabarwieniu, różowieją pod wpływem nacisku i później. \n" +
                                "\n" +
                                "Górną powierzchnię pokrywa elastyczna, żelatynowata, promieniście pręgowana skórka, dająca się ściągać, wydzielająca śluzowatą substancję, z której mogą powstawać czerwone krople na zaokrąglonym brzegu kapelusza.\n" +
                                "\n" +
                                "Miąższ czerwony, soczysty, z ciemniejszymi pręgami w miejscu rozłamania, poprzecinany promienistymi włókienkami, łatwy do rozerwania. Ma odświeżający owocowy zapach i nieco kwaskowaty, czasami lekko gorzkawy smak. \n" +
                                "\n" +
                                "Występuje na drewnie starych dębów żywych i martwych, przy korzeniach lub wyżej, na pniu; innym gospodarzem może być kasztan jadalny, natomiast zasiedlenie innych drzew liściastych zdarza się dużo rzadziej. Owocniki pojawiają się od lata do jesieni. \n" +
                                "\n" +
                                "Zastosowanie - młody jadalny.\n".toString();
                        qwe2 = R.drawable.debowyozobig;
                            jedzenie = R.drawable.jadalny;
                            lasy = R.drawable.lisc;
                            typgrzyb = R.drawable.def1;
                            jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 150:
                        TempListViewClickedValue = "Piaskowiec kasztanowaty Gyroporus castaneus".toString();
                        TempListViewClickedValue2 = "Owocnik początkowo kasztanowaty, rdzawobrązowy, cynamonowobrązowy, z wiekiem jaśniejszy, słomkowy do ochrowego; 2-5 cm średnicy, początkowo półkulisty, potem wypukły i spłaszczony, stary jest wklęsły.\n" +
                                "\n" +
                                "Powierzchnia sucha, matowa, gładka lub omszona; brzeg ostry. \n" +
                                "\n" +
                                "Pory początkowo białe, z wiekiem bladocytrynowo-żółte, drobne, poniżej 1 mm średnicy. \n" +
                                "\n" +
                                "Rurki tej samej barwy, zwykle silnie wykrojone, do prawie wolnych. \n" +
                                "\n" +
                                "Trzon barwy kapelusza lub trochę jaśniejszy; początkowo pełny, ale wkrótce pusty, bardzo kruchy; gładki lub nieco filcowaty; centralny lub ekscentryczny, nieregularnie cylindryczny lub maczugowaty, różnie powyginany; powierzchnia sucha. \n" +
                                "\n" +
                                "Miąższ białawy do kremowego, nie błękitniejący; za młodu twardy, jędrny, u starszych okazów kruchy; smak łagodny; zapach niewyraźny. \n" +
                                "\n" +
                                "Występuje rzadko. Owocniki wyrastają od lata do jesieni, na glebach kwaśnych, piaszczystych, w lasach liściastych, zwykle dębowych, rzadziej w iglastych. \n" +
                                "\n" +
                                "Zastosowanie- jadalny.\n".toString();
                        qwe = R.drawable.modrzak;
                        qwe2 = R.drawable.kasztanowypiabig;
                        list1 = "Pisakowirec modrzak  Gyroporus cyanescens,".toString();
                        list2 = "ma miąższ zmieniający barwę na atramentowo niebieską i jaśniejszy kapelusz oraz trzon.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t1;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 151:
                        TempListViewClickedValue = "Piaskowiec modrzak Gyroporus cyanescens".toString();
                        TempListViewClickedValue3 = "Gatunek objęty ochroną częściową w Polsce!  ".toString();
                        TempListViewClickedValue2 = "Kapelusz o średnicy 3-15cm w kolorze słomkowożółtym z odcieniem ochrowym, do brązowawoochrowego. W kształcie półkolisty, wypukły do poduszkowatego. \n" +
                                "\n" +
                                "Powierzchnia matowa, drobno kosmkowata, zawsze sucha. Brzeg długo podwinięty.\n" +
                                "\n" +
                                "Pory z wiekiem duże, szerokoowalne. W barwie rurek. Barwią się na niebiesko. \n" +
                                "\n" +
                                "Rurki w barwie żółtawe. Uszkodzone sinieją. \n" +
                                "\n" +
                                "Trzon barwy jasnożółty, słomkowożółty, ciemniejszy w kierunku podstawy, cylindryczny lub zgrubiały u dołu. Początkowo pełny, następnie watowaty i komorowaty. \n" +
                                "\n" +
                                "Miąższ biały, następnie odbarwiający się do szaroochrowego, uciśnięty natychmiast niebieszczeje, kruchy. Smak łagodny, zapach słaby. \n" +
                                "\n" +
                                "Występuje rzadko, w lasach iglastych i mieszanych. Wyłącznie na glebach piaszczystych. Mikoryzuje z bukiem, brzozą i sosną. \n" +
                                "\n" +
                                "Zastosowanie- jadalny i smaczny. \n".toString();
                        qwe = R.drawable.zonkilowy;
                        qwe2 = R.drawable.modrzakbig;
                        list1 = "Borowik żonkilowy Neoboletus junquilleus,".toString();
                        list2 = "bawi się na ciemniejszy kolor;";
                        list13 = "nie barwi się po dotknięciu.";
                        list3 = "Piaskowiec kasztanowaty Gyroporus castaneus,";
                        qwe3 = R.drawable.kasztanowypia;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t1;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 152:
                        TempListViewClickedValue = "Pieczareczka amerykańska Leucoagaricus americanus".toString();
                        TempListViewClickedValue2 = "Kapelusz o średnicy 3-12 cm, u młodych okazów kulisty, później półkulistołukowaty, na koniec płaski, często z garbem na środku. Początkowo ma barwę od białawej do brązowej, potem różowobrązową.\n" +
                                "\n" +
                                "Powierzchnia początkowo gładka, potem coraz bardziej złuszczająca się.\n" +
                                "\n" +
                                "Blaszki gęste, wolne, u młodych okazów białe, potem różowawe, w końcu czerwonobrązowe.\n" +
                                "\n" +
                                "Trzon o wysokości 4,5–12 cm, grubości 1–4 cm, kształt walcowaty, w dolnej części wyraźnie nabrzmiały. Powierzchnia naga lub drobno jedwabista, początkowo biaława, potem coraz bardziej czerwonawa, w końcu czerwonobrązowa. Po uszkodzeniu zmienia barwę na żółtą, potem czerwonawą. Posiada wysoki, podobny do kołnierza, zwisający pierścień, początkowo biały, potem plamisto czerwonawy. U podstawy trzonu biała grzybnia z cienkimi sznurami grzybniowymi.\n" +
                                "\n" +
                                "Miąższ gruby, biały, po przekrojeniu powoli barwiący się na żółto, po wysuszeniu czerwony. Bez wyraźnego zapachu i smaku.\n" +
                                "\n" +
                                "Rośnie w rozproszeniu lub stadnie na zrębkach, w pobliżu wysypisk odpadów, na siedliskach ruderalnych i na pniakach. Sporadycznie pojawia się w lesie, gdzie rośnie na pniakach lub wokół martwych drzew. Owocniki wytwarza od lata do jesieni lato i jesień\n" +
                                "\n" +
                                "Zastosowanie – jadalna.\n".toString();
                        qwe2 = R.drawable.amerykanskapiebig;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.laka;
                        typgrzyb = R.drawable.t2;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 153:
                        TempListViewClickedValue = "Pieczarka krótkotrzonowa Agaricus placomyces".toString();
                        TempListViewClickedValue2 = "Kapelusz mięsisty, o średnicy do 12 cm, czasami nawet do 25 cm. Początkowo półkulisty, później płaski, czasami z wklęsłym środkiem. \n" +
                                "\n" +
                                "Powierzchnia biała z brązowymi łatkami, brzeg cienki, nie podwinięty i przeważnie z resztkami osłony częściowej.\n" +
                                "\n" +
                                "Blaszki cienkie, gęste, wolne. Tylko u bardzo młodych okazów białe, szybko stają się różowe, potem od zarodników stają się coraz ciemniejsze; czekoladowobrązowe i ciemnobrązowe.\n" +
                                "\n" +
                                "Trzon o wysokości 5-16 cm i grubości 1,5-2,5 cm, cylindryczny, u podstawy rozszerzony, w środku pusty. Posiada charakterystycznie żebrowany pierścień. Na powierzchni trzonu pod pierścieniem drobne, gęste i odstające jasnobrązowe kosmki, czasami łuseczki. Z podstawy trzonu wyrasta krótka, żółta ryzomorfa.\n" +
                                "\n" +
                                "Miąższ białawy, na przekroju lekko różowiejący. Zapach przyjemny.\n" +
                                "\n" +
                                "Rośnie w parkach, ogrodach, liściastych lasach i na siedliskach ruderalnych. \n".toString();
                        qwe = R.drawable.lesnapie;
                        qwe2 = R.drawable.krotkotrzonowabig;
                        list1 = "Pieczarka leśna Agaricus silvaticus,".toString();
                        list2 = "odróżnia się drobniejszymi łuseczkami, niemal gładkim trzonem i zapachem świeżego drewna lub stearyny;";
                        list13 = "miąższ po nacięciu natychmiast barwi się na czerwono.";
                        list3 = "Pieczarka krwawiąca Agaricus langei,";
                        qwe3 = R.drawable.krwawiacapie;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.laka;
                        typgrzyb = R.drawable.t2;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 154:
                        TempListViewClickedValue = "Pieczarka leśna Agaricus silvaticus".toString();
                        TempListViewClickedValue2 = "Kapelusz pokryty ciemnobrązowymi, włóknistymi, przylegającymi łuskami, miejsca uszkodzone silnie czerwienieją; 4-9 cm średnicy; początkowo stożkowaty, potem półkulisty, wypukły, do rozpostartego. \n" +
                                "\n" +
                                "Blaszki białawe, następnie szaroróżowawe i czekoladowobrunatne, szerokie, wolne; ostrza jaśniejsze. \n" +
                                "\n" +
                                "Trzon białawy, z wiekiem szarzejący; 100-160 na 10-15 mm, podstawa rozszerzona, z pierścieniem; powierzchnia z białawymi kłaczkami, otarta przebarwia się czerwono i brązowieje; młody pełny, potem z kanałem. \n" +
                                "\n" +
                                "Miąższ białawy, uszkodzony dość szybko przebarwia się czerwonokarminowobrązowo; smak łagodny; zapach przyjemny migdałowy. \n" +
                                "\n" +
                                "Występuje często. Od lata do jesieni, pojedynczo lub w grupach, zwykle w lasach iglastych, zwłaszcza pod świerkami. \n" +
                                "\n" +
                                "Zastosowanie - jadalna. \n".toString();
                        qwe = R.drawable.karbolowa;
                        qwe2 = R.drawable.lesnapiebig;
                        list1 = "Pieczarka karbolowa Agaricus xanthodermus,".toString();
                        list2 = "ma zapach karbolu oraz żółknąca podstawa trzonu;";
                        list13 = "miąższ po uszkodzeniu żółknie, ma też nieco inną barwę kapelusza.";
                        list3 = "Pieczarka liliowoczerwonawa Agaricus porphyrizon,";
                        qwe3 = R.drawable.liliowoczer;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t2;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 155:
                        TempListViewClickedValue = "Pieczarka łąkowa Agaricus campestris"+"\n"+"jako Pieczarka szlachetna".toString();
                        TempListViewClickedValue2 = "Kapelusz biały, stary z brązowym odcieniem; 5-13 cm średnicy; początkowo półkulisty, z wiekiem wypukły i w końcu rozpostarty; brzeg długo podwinięty, młody ze zwieszającymi się fragmentami osłony.\n" +
                                "\n" +
                                "Powierzchnia gładka i lśniąca, z wiekiem czasem słabo spękana na drobne łuseczki. \n" +
                                "\n" +
                                "Blaszki początkowo szaroróżowe, dojrzałe czekoladowobrązowe, wąskie, wolne, ostrza gładkie. \n" +
                                "\n" +
                                "Trzon biały, brązowiejący z wiekiem; 50-80 na 10-25 mm, cylindryczny, powierzchnia włóknista. \n" +
                                "\n" +
                                "Pierścień błoniasty, zwisający, słaby, delikatny, zanikający. \n" +
                                "\n" +
                                "Miąższ biały, na cięciu powoli różowiejący; zapach przyjemny, grzybowy; smak przyjemny, korzenny. \n" +
                                "\n" +
                                "Pospolita. Owocniki wyrastają od lata do jesieni, zwykle w grupach, na pastwiskach, łąkach, polach. \n" +
                                "\n" +
                                "Zastosowanie - jadalna. \n".toString();
                        qwe = R.drawable.jadowity;
                        qwe2 = R.drawable.polnapiebig;
                        list1 = "Muchomor jadowity Amanita virosa,".toString();
                        list2 = "ma blaszki zawsze czystobiałe, a nigdy różowe czy ciemnobrązowe! Oprócz tego pieczarki nie wyrastają z otwartej pochwy.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.laka;
                        typgrzyb = R.drawable.def4;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 156:
                        TempListViewClickedValue = "Pieprznik jadalny Cantharellus cibarius".toString();
                        TempListViewClickedValue2 = "Owocnik 1-7 cm średnicy; gatunek ten ma charakterystyczną żółtą; u bardzo młodych wypukły, płaski, później wklęsły, lejkowaty; brzeg podwinięty lub falisto powyginany, u starszych okazów postrzępiony; gładki, nagi, matowy. \n" +
                                "\n" +
                                "Listewki barwy kapelusza; w postaci żylastych fałd zbiegających na trzon, często rozwidlonych lub łączących się. \n" +
                                "\n" +
                                "Trzon 3-8 cm wysokości, 0,8-2,5 cm grubości; tej samej barwy lub nieco jaśniejszy od kapelusza; cylindryczny, zwężający się ku dołowi; może być nieco wygięty; pełny; powierzchnia gładka. \n" +
                                "\n" +
                                "Miąższ białawy z odcieniem żółtym, jasnożółty; jędrny, zwarty, mięsisty; smak u młodych owocników łagodny, u starych lekko pieprzny; zapach korzenny, owocowy. \n" +
                                "\n" +
                                "Występuje od czerwca do listopada, pod sosną i świerkiem, a także dębem, bukiem i grabem; gromadnie (czasami tworzy czarcie kręgi.\n" +
                                "\n" +
                                "Zastosowanie - jadalny. \n".toString();
                        qwe = R.drawable.ametystowypie;
                        qwe2 = R.drawable.jadalnypiebig;
                        list1 = "Pieprznik ametystowy Cantharellus amethysteus,".toString();
                        list2 = "kapelusz pokryty jest filcowatymi, fioletowymi łuseczkami (zwłaszcza u młodych egzemplarzy). Występuje głównie w górach pod bukami;";
                        list13 = "jest intensywnie pomarańczowy i rośnie tylko w buczynach;";
                        list3 = "Pieprznik pomarańczowy Cantharellus friesii,";
                        qwe3 = R.drawable.pomaranpie;
                        list14 = "ma blaszkowate, cienkie i gęste blaszki oraz ciemniejsze, pomarańczowe owocniki.";
                        list4 = "Lisówka pomarańczowa Hygrophoropsis aurantiaca,";
                        qwe4 = R.drawable.pomaranlis;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t5;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 157:
                        TempListViewClickedValue = "Pieprznik szary Cantharellus cinereus".toString();
                        TempListViewClickedValue2 = "Owocnik szarobrązowy, na brzegu jaśniejszy żółtobrązowy, 2-6cm średnicy, zagłębiony prawie od początku, brzeg podwinięty, z wiekiem pofalowany.\n" +
                                "\n" +
                                "Powierzchnia promieniście pomarszczona, drobno kosmkowata. \n" +
                                "\n" +
                                "Hymenofor popielaty, z rzadkimi żyłkami, żeberkami, daleko zbiegającymi. \n" +
                                "\n" +
                                "Trzon brązowy, barwy kapelusza lub jaśniejszy, ciemniejący z wiekiem, podstawa z białym nalotem, równogruby, pusty w środku, bocznie spłaszczony. \n" +
                                "\n" +
                                "Miąższ cienki, elastyczny, szarobrązowy. Zapach słaby, owocowy; smak łagodny. \n" +
                                "\n" +
                                "Występuje rzadko wsród liści i mchów w lasach bukowych. \n" +
                                "\n" +
                                "Zastosowanie- jadalny. \n".toString();
                        qwe = R.drawable.detylej;
                        qwe2 = R.drawable.szarypiebig;
                        list1 = "Lejkowiec dęty Craterellus cornucopioides,".toString();
                        list2 = "większy, brak listew lub listwy lekko pomarszczone;";
                        list13 = "nieregularnie kędzierzawy brzeg kapelusza.";
                        list3 = "Lejkowniczek pełnotrzonowy Pseudocraterellus undulatus,";
                        qwe3 = R.drawable.pelnotrzonowy;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.t5;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 158:
                        TempListViewClickedValue = "Pieprznik trąbkowy Cantharellus tubaeformis".toString();
                        TempListViewClickedValue2 = "Owocnik 2-4 cm średnicy; żółtobrązowy do szarobrązowego, oliwkowoszarobrązowawy, rdzawoszary; wypukły, szybko wgłębiony, potem często lejkowaty, następnie trąbkowaty, cienkomięsisty; pokryty drobnymi przylegającymi łuseczkami lub gładki; u młodych brzeg podgięty i równy, u starych wygięty do góry, silnie.\n" +
                                "\n" +
                                "Listewki w odcieniach szaro-żółtawych: szarobrązowawe do szarożółtych, białoszare, niebieskoszarawe, czerwonożółtawe, zielonawożółte; wyraźne i grube, niewysokie, żyłkowate,rzadkie; połączone poprzecznymi żyłkami.\n" +
                                "\n" +
                                "Trzon o wysokości 2 - 8 i 0.5 - 1 cm grubości; szarożółty, żółtawobrunatny (młody żółty), ku podstawie żółtawy; gładki lub z zagłębieniami: jamisty i bruzdy biegną wzdłuż trzonu; często wygięty. rurkowaty (wewnątrz pusty), smukły; u podstawy zwężony. \n" +
                                "\n" +
                                "Miąższ żółtawobiały, biały, żółtawoszary, jasnoszary; włóknisty, cienki; zapach słaby, trochę ziemisty, stęchły, przy potarciu charakterystycznie korzenny, ale niezbyt przyjemny; smak łagodny, słaby. \n" +
                                "\n" +
                                "Występuje od czerwca do listopada w cienistych lasach iglastych, głównie pod świerkami, rzadziej pod sosnami, w wilgotnym mchu i na rozkładającym się drewnie, często przy pniakach, \n" +
                                "\n" +
                                "Zastosowanie - jadalny. \n".toString();
                        qwe = R.drawable.zoltawy;
                        qwe2 = R.drawable.trabkowybig;
                        list1 = "Pieprznik żółtawy Craterellus lutescens,".toString();
                        list2 = "charakteryzuje się gładszym hymenoforem, jaskrawiej zabarwionym, pomarańczowo-żółtym trzonem i podobnymi tonami kapelusza; ma wyraźny owocowy zapach i smak,";
                        list13 = "o podobnie zabarwionym kapeluszu, który ma popielatoszary hymenofor.";
                        list3 = "Pieprznik szary Cantharellus cinereus,";
                        qwe3 = R.drawable.szarypie;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.laka;
                        typgrzyb = R.drawable.t5;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 159:
                        TempListViewClickedValue = "Piestrak jadalny Choiromyces meandriformis".toString();
                        TempListViewClickedValue2 = "Owocnik bulwiasty; osiągający wielkość pięści, 5-8 cm; barwy jasnobrązowej lub żółtawobiałej; wnętrze piestraków jest charakterystyczne, posiada marmurkowaty deseń w postaci brunatnych żyłek na szarym tle.\n" +
                                "\n" +
                                "Powierzchnia bez wyraźnej skórki, przeważnie gładka, czasem porysowana, spękana; w stadium dojrzałym wystaje z ziemi przeważnie tylko 1/3 owocnika;\n" +
                                "\n" +
                                "Miąższ dość silny i przyjemny zapach zwabia owady, które przyczyniają się do rozsiewania zarodników. \n" +
                                "\n" +
                                "Jadalny, bardzo smaczny i wysoko ceniony.\n" +
                                "\n" +
                                "Występuje w lasach liściastych jak i iglastych, przeważnie na glebach wapiennych, pod dębami. Pojawia się pod koniec lata, lipiec-wrzesień. \n".toString();
                        qwe = R.drawable.bialatru;
                        qwe2 = R.drawable.jadalnypiestbig;
                        list1 = "Trufla biała Tuber magnatum,".toString();
                        list2 = "ma siatkowate zarodniki;";
                        list13 = "ma mniejszy i ciemniejszy owocnik.";
                        list3 = "Piestrak brązowy Choiromyces magnusii,";
                        qwe3 = R.drawable.brazowypi;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.def3;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 160:
                        TempListViewClickedValue = "Piestrzenica infułowata Gyromitra infula".toString();
                        TempListViewClickedValue2 = "Główka ciemna, od czerwonobrązowej do kasztanowobrązowej, z dwoma unoszącymi się ku górze, mniej lub bardziej zaostrzonymi fałdami; 20-130 na 30-110 mm; środek pusty. \n" +
                                "\n" +
                                "Trzon brudnobiały, różowawy do mięsnoczerwonawego; 30-110 na 5-30 mm; zwykle nieco spłaszczony, u góry rozszerzony, u podstawy zwężony; powierzchnia czasem pofałdowana lub z jamkowatymi zagłębieniami; u starszych owocników komorowaty lub pusty. \n" +
                                "\n" +
                                "Miąższ woskowaty, bardzo kruchy; smak i zapach przyjemne. \n" +
                                "\n" +
                                "Występuje dość rzadko, jesienią, w lasach iglastych; na pniakach i leżącym w ziemi drewnie; częściej w górach. Czasami może pojawiać się wiosną.\n" +
                                "\n" +
                                "Zastosowanie - jadalna. \n".toString();
                        qwe = R.drawable.kasztanowypia;
                        qwe2 = R.drawable.infolowatabig;
                        list1 = "Piestrzenica kasztanowata Gyromitra esculenta,".toString();
                        list2 = "ma bardziej mózgowato pofałdowany kapelusz i występuje tylko wczesną wiosną.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t4;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 161:
                        TempListViewClickedValue = "Piestrzenica kasztanowata Gyromitra esculenta".toString();
                        TempListViewClickedValue2 = "Główka nieregularnie pofałdowana, na wierzchu przypomina fałdy mózgowia lub zwiniętą, pofałdowaną szmatkę; ciemny, ochrowobrązowy, kasztanowaty, czerwonobrązowy, czasem jaśniejszy (biała forma owocnika); matowy; średnica kapelusza od 2 do 8 cm; wewnątrz biały i pusty; kapelusz jest zrośnięty z trzonem. \n" +
                                "\n" +
                                "Trzon na zewnątrz biały albo lekko żółtawy wewnątrz pusty i biały, często posiada jamki; wysokość trzonu od 3 do 7 cm; średnica ok. 1,5 do 3 cm. \n" +
                                "\n" +
                                "Miąższ zwięzły, grubości 1-2 mm o przyjemnym zapachu niedojrzałych orzechów. \n" +
                                "\n" +
                                "Występuje zwykle od kwietnia do maja, wyrasta głównie w piaszczystych lasach sosnowych i świerkowych, na nizinach i w terenach podgórskich, na zrębach, w uprawach leśnych (szkółkach), na nagiej glebie leśnej, w sąsiedztwie pni drzew lub między ich korzeniami. \n" +
                                "\n" +
                                "Zastosowanie - trująca!\n".toString();
                        qwe = R.drawable.olbrzymia;
                        qwe2 = R.drawable.kasztanowatabig;
                        list1 = "Piestrzenica olbrzymia Gyromitra gigas,".toString();
                        list2 = "ma większe owocniki, zazwyczaj jaśniej ubarwione. Owocniki nie od razu są duże, trafiają się mniejsze okazy także wśród dojrzałych owocników.";
                        jedzenie = R.drawable.trujacy;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t4;
                        jadalnosc.setImageResource(R.drawable.trujacy);
                        break;
                    case 162:
                        TempListViewClickedValue = "Piestrzyca kędzierzawa Helvella crispa".toString();
                        TempListViewClickedValue2 = "Owocnik 4-15 cm wysokości; główka o średnicy 20-50 mm; nieregularna, zbudowana z kilku pofałdowanych płatów, siodłowata; brzeg zwykle podwinięty, lecz nie zrośnięty z trzonem; wierzchnia strona płatów jest gładka, biaława do brudnoochrowej, potem brunatnieje, spodnia strona jest omszona. \n" +
                                "\n" +
                                "Trzon białawy, 30-110 na 5-25 mm, u podstawy rozszerzony, o powierzchni wyraźnie żłobkowanej lub jamkowanej, wewnątrz z podłużnymi komorami. \n" +
                                "\n" +
                                "Miąższ białawy, w trzonie elastyczny, w kapeluszu kruchy; smak łagodny; bez zapachu. \n" +
                                "\n" +
                                "Średnio pospolita. Owocniki wyrastają od sierpnia do listopada, pojedynczo i w grupach, w lasach i zaroślach liściastych, w parkach, w trawie, chętnie na poboczach dróg; na glebach wapiennych. \n" +
                                "\n" +
                                "Zastosowanie - jadalna. \n".toString();
                        qwe = R.drawable.zatokowata;
                        qwe2 = R.drawable.kedzierzawabig;
                        list1 = "Piestrzyca zatokowa Helvella lacunosa,".toString();
                        list2 = "występująca w tym samym okresie i w podobnych siedliskach, różniąca się jednak znacznie ubarwieniem.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.laka;
                        typgrzyb = R.drawable.t4;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 163:
                        TempListViewClickedValue = "Piestrzyca zatokowata Helvella lacunosa".toString();
                        TempListViewClickedValue3 = "Gatunek objęty ochroną częściową w Polsce!".toString();
                        TempListViewClickedValue2 = "Owocnik składający się z główki i trzonu; 50-130 mm wysokości; główka ciemna, niebieskoszara do prawie czarnej, nieregularnie pofałdowana w 2-3 płaty, dolna krawędź główki przyrośnięta do trzonu. \n" +
                                "\n" +
                                "Trzon jasnoszary, ciemniejący z wiekiem, szarooliwkowy, szaroczarny, pusty, o powierzchni nieregularnej, wzdłużnie bruzdowanej i pofałdowanej. \n" +
                                "\n" +
                                "Miąższ białawy, szarawy, cienki, kruchy, bez wyróżniającego się smaku lub zapachu. \n" +
                                "\n" +
                                "Wystepuje często od wiosny do jesieni, w lasach liściastych i zaroślach.\n" +
                                "\n" +
                                "Zastosowanie - jadalny. \n".toString();
                        qwe = R.drawable.kedzierzawa;
                        qwe2 = R.drawable.zatokowatabig;
                        list1 = "Piestrzyca kędzierzawa Helvella crispa,".toString();
                        list2 = "jest jaśniej zabarwiona.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.t4;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 164:
                        TempListViewClickedValue = "Płachetka kołpakowata Pholiota caperata".toString();
                        TempListViewClickedValue2 = "Owocnik o średnicy 6-10 cm, szarożółtawy, beżowożółty, ochrowożółty, z bladofioletowym lub jasnoniebieskim odcieniem zwłaszcza za młodu z białawym, często pomarszczony, u młodych owocników jajowaty, kulisty, u dojrzałych wypukły, spłaszczony z garbkiem, brzeg u młodych owocników ma resztki białej, błoniastej osłony. \n" +
                                "\n" +
                                "Skórka pokryta delikatnymi białawymi, białosrebrzystymi łuseczkami, podczas suszy promieniście pomarszczony, na brzegach popękany.\n" +
                                "\n" +
                                "Blaszki szerokość 7-8 mm, barwy gliniastej, gliniastożółtej, później rdzawoochrowe, rdzawobrązowe, ostrze białe, zatokowato wycięte, gęste, o ostrzu karbowanym. \n" +
                                "\n" +
                                "Trzon brudnobiaławy, 100 na 25 mm, powierzchnia nad pierścieniem z nalotem, poniżej pierścienia jedwabisty, długowłóknisty, pełny. \n" +
                                "\n" +
                                "Pierścień biały, żółtawy, błoniasty, odstający, gładki, niekiedy słabo prążkowany. \n" +
                                "\n" +
                                "Miąższ białawy, beżowy, pod skórką kapelusza i powierzchnią trzonu żółtawy, niekiedy bladolila w dolnej części trzonu, mięsisty; smak łagodny, zapach słaby, przyjemny. \n" +
                                "\n" +
                                "Pospolity od sierpnia do października w lasach iglastych, na kwaśnych glebach, często w towarzystwie borówki czarnej, w pobliżu brzóz. Rzadko spotyka się je w lasach liściastych. \n" +
                                "\n" +
                                "Zastosowanie- jadalny.\n".toString();
                        qwe = R.drawable.wonnyzas;
                        qwe2 = R.drawable.kolpakowatabig;
                        list1 = "Zasłonak wonny Cortinarus traganus,".toString();
                        list2 = "miąższ ma szafranowożółty, o nieprzyjemnym zapachu.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 165:
                        TempListViewClickedValue = "Płomiennica zimowa Flamullina velutipes"+"\n"+"jako zimówka aksamitnotrzonowa".toString();
                        TempListViewClickedValue2 = "Owocnik pomarańczowożółty, miodowożółty do brązowawożółtego, w centrum ciemniejszy, 2-12 cm, młody wypukły, potem spłaszczony, stary powyginany. \n" +
                                "\n" +
                                "Powierzchnia gładka, lekko przyprószona, w czasie wilgoci silnie śluzowata i błyszcząca. Brzeg jaśniejszy. \n" +
                                "\n" +
                                "Blaszki dość rzadko ustawione, różnej długości, przyrastają do trzonu, barwy białawej z wiekiem żółtawe lub ochrowożółtawe. \n" +
                                "\n" +
                                "Trzon wysokość 3-12 cm, grubość 0,2-0,5cm; kolor szczytu żółtawy, żółtoczerwony, w pozostałej części ciemnobrązowy; cylindryczny, centralny u podstawy niekiedy korzeniasty u szczytu nagi, w pozostałej części aksamitny (ciemnieje stopniowo w dolnej części). \n" +
                                "\n" +
                                "Miąższ biały, kremowy, później żółtawy, nie zmienia barwy po przekrojeniu, cienki; smak - łagodny i nieokreślony; zapach - łagodny, niewyraźny lub korzenny. \n" +
                                "\n" +
                                "Bardzo rozpowszechniony grzyb, występuje od późnej jesieni do zimy, w okresach bezmroźnych i wczesną wiosną. Płomiennice znoszą mrozy i po ich ustąpieniu rozwijają się dalej. Owocniki wyrastają w kępkach na drewnie drzew liściastych- głownie wierzb, olsz, topoli, wiązów.\n" +
                                "\n" +
                                "Zastosowanie - bardzo dobry grzyb jadalny.\n".toString();
                        qwe = R.drawable.wiazkowa;
                        qwe2 = R.drawable.zimowaplbig;
                        list1 = "Maślanka wiązkowa Hypholoma fasciculare,".toString();
                        list2 = "rośnie również kępkami na drzewach.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.t7;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 166:
                        TempListViewClickedValue = "Płomykówka galaretowata Tremiscus helvelloides".toString();
                        TempListViewClickedValue3 = "Gatunek objęty ochroną częściową w Polsce!   ".toString();
                        TempListViewClickedValue2 = "Owocnik czerwonopomarańczowy, różowopomarańczowy, z wiekiem ciemniejszy, ku podstawie jaśniejszy ochrowożółty do białawego, 3-15cm wysokości, 3-8 cm szerokości i 2-4 mm grubości, łopatkowaty, w miarę wzrostu nieregularny lub lejkowaty z falistym i nieregularnie karbowanym brzegiem, ku podstawie zwężony w trzon, szerokości do 15 mm, do 50 mm długości, owocniki wyrastają w grupach w kępkach. Hyemnofor znajduje się w górnej części zewnętrznej powierzchni owocnika. \n" +
                                "Wewnętrzna powierzchnia biaława i pokryta białawym (białawo-liliowym) nalotem, który łatwo się ściera, zewnętrzna czasem bruzdowana i żyłkowana. \n" +
                                "\n" +
                                "Miąższ galaretowaty, jaśniejszy niż powierzchnia owocnika, zapach słaby, grzybowy. \n" +
                                "\n" +
                                "Występuje rzadko od lata do jesieni, na resztkach drewna, także zagrzebanych w ziemi, głównie drewna drzew iglastych, rzadko liściastych, u podnóża pni drzew i pniaków, na glebach wapiennych. Częściej w górach, w miejscach wilgotnych, cienistych. \n" +
                                "\n" +
                                "Zastosowanie- jadalny lecz bez smaku. \n".toString();
                        qwe2 = R.drawable.galaretkowataplobig;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t5;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 167:
                        TempListViewClickedValue = "Podgrzybek czerwonawy Boletus rubellus".toString();
                        TempListViewClickedValue2 = "Owocnik młody barwy żywo karminowoczerwonej lub w różnych odcieniach czerwieni z wiekiem blednie i jest matoworóżowy, 3-10cm średnicy, początkowo półkulisty, potem rozpostarty do płaskiego, u starych okazów pofałdowany.\n" +
                                "\n" +
                                "Powierzchnia sucha, zamszowa, w czasie suszy może być popękana, w pęknięciach miąższ żółtawy, skórka nie daje się oddzielić od miąższu. \n" +
                                "\n" +
                                "Pory cytrynowe do jasnożółtych, z wiekiem oliwkowe, uciśnięte zwykle błekitnieja, średniej wielkości, kanciaste. \n" +
                                "\n" +
                                "Rurki zielonkawożółte, długości 6-15mm, przy trzonie zatokowato wycięte do nieco zbiegających. \n" +
                                "\n" +
                                "Trzon jasnożółty z czerwonymi smugami lub nakrapianymi strefami, 30-120 na 4-25 mm, równogruby, często powyginany. \n" +
                                "\n" +
                                "Miąższ żółtawy, pod skórką kapelusza czerwonawy, po przekrojeniu nieco błękitnieje, miękki. Zapach słaby, smak łagodny. \n" +
                                "\n" +
                                "Występuje gromadnie, latem, w lasach liściastych, w miejscach trawiastych i nasłonecznionych. Dość rzadki. \n" +
                                "\n" +
                                "Zastosowanie - jadalny. \n".toString();
                        qwe = R.drawable.zlotopor;
                        qwe2 = R.drawable.czerwonypodbig;
                        list1 = "Podgrzybek złotopory Xerocomus chrysenteron,".toString();
                        list2 = "podobny gdy p. czerwonawy jest wyblakły i brązowy.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.t1;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 168:
                        TempListViewClickedValue = "Podgrzybek tęgoskórowy Xerocomus parasiticus".toString();
                        TempListViewClickedValue3 = "Gatunek objęty ochroną częściową w Polsce!".toString();
                        TempListViewClickedValue2 = "Owocnik szarożółty, oliwkowoszary, młode półkuliste z wiekiem poduszkowate, 2-8cm średnicy, \n" +
                                "\n" +
                                "Powierzchnia sucha, zamszowa, może być spękana na poletka, skórka na brzegu kapelusz wystaje poza rurki. \n" +
                                "\n" +
                                "Rurki jasnożółte do białawych; 5-10 mm długości; przyrośnięte \n" +
                                "\n" +
                                "Pory barwy rurek, z wiekiem plamią się rdzawo-czerwono. \n" +
                                "\n" +
                                "Trzon barwy kapelusza o wymiarach 20-60 na 5-20 mm zwężający się ku podstawie; powierzchnia pomarszczona z drobnymi kłaczkami. \n" +
                                "\n" +
                                "Miąższ szarożółtawy. Smak łagodny, zapach słaby. \n" +
                                "\n" +
                                "Występuje rzadko, można go znaleźć latem i jesienią w towarzystwie tęgoskóra pospolitego. \n" +
                                "\n" +
                                "Zastosowanie - jadalny. \n".toString();
                        qwe = R.drawable.zajeczy;
                        qwe2 = R.drawable.tegoskornybig;
                        list1 = "Podgrzybek zajączek Boletus subtomentosus,".toString();
                        list2 = "występuje w lasach iglastych i liściastych, pod świerkiem pospolitym, limbą i dębem szkarłatnym.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t1;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 169:
                        TempListViewClickedValue = "Ponurnik aksamitny Tapinella atrotomentosa".toString();
                        TempListViewClickedValue2 = "Owocnik jasnobrązowy, ochrowy, rdzawobrązowy do ciemnobrązowego, duży, 5-30 cm średnicy, młody wypukły, lejkowaty, także może być muszlowaty z bocznym trzonem.\n" +
                                "\n" +
                                "Powierzchnia aksamitna, matowa, sucha, z wiekiem popękana, brzeg długo podwinięty. \n" +
                                "\n" +
                                "Blaszki barwy żółtawej w odcieniu gliny, zbiegające w dół po trzonie, w miejscach zgniecionych wysytępują na nich ciemne brunatne plamy. \n" +
                                "\n" +
                                "Trzon krótki i gruby, 6 na 4 cm, pokryty ciemnobrązowym kutnerem, filcowaty, aksamitny, najczęściej boczny lub wyraźnie ekscentryczny. \n" +
                                "\n" +
                                "Miąższ gruby, mięsisty, białawy, niezmienny, bez zapachu, o gorzkawym smaku. \n" +
                                "\n" +
                                "Występuje często latem i jesienią, pojedynczo lub w grupach, saprotroficznie, na zbutwiałym drewnie i korzeniach drzew iglastych, często wokół murszejących pieńków. \n" +
                                "\n" +
                                "Zastosowanie - niejadalny. \n".toString();
                        qwe2 = R.drawable.aksamitnybig;
                        jedzenie = R.drawable.niejadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t1;
                        jadalnosc.setImageResource(R.drawable.niejadalny);
                        break;
                    case 170:
                        TempListViewClickedValue = "Przyczepka falista Rhizina undulata".toString();
                        TempListViewClickedValue2 = "Owocnik rozpostarty, nieco wypukłe, o pofałdowanej powierzchni, 2-11cm szerokości i 2-4 mm grubości, czerwonobrązowe, oliwkowobrązowe, do brązowoczarnych, od spodniej strony białawe, przytwierdzone licznymi sznurami grzybni do podłoża. \n" +
                                "\n" +
                                "Miąższ ochrowy, kruchy, woskowy, z wiekiem twardszy, skórzasty. \n" +
                                "\n" +
                                "Występuje często, wyrasta od wiosny do jesieni, w grupach, na miejscach po starych ogniskach, czy wypaleniskach, zwłaszcza w terenach górskich. \n" +
                                "\n" +
                                "Zastosowanie- niejadalna. \n".toString();
                        qwe = R.drawable.wrebiasta;
                        qwe2 = R.drawable.falistabig;
                        list1 = "Krążkownica wrębiasta Discina perlata,".toString();
                        list2 = "jest przytwierdzona do podłoża jednym, grubym korzeniem.";
                        jedzenie = R.drawable.niejadalny;
                        lasy = R.drawable.laka;
                        typgrzyb = R.drawable.t4;
                        jadalnosc.setImageResource(R.drawable.niejadalny);
                        break;
                    case 171:
                        TempListViewClickedValue = "Purchaweczka spłaszczona Vascellum pratense".toString();
                        TempListViewClickedValue2 = "Owocnik młody kulisty, starszy odwrotnie gruszkowaty, górna część spłaszczona, do 20-60 na 20-50 mm, podstawa pofałdowana, zwężająca się, zewnętrzna osłona biała, jest pokryta małymi ziarnistymi kolcami, tworzące gwiazdkowate skupienia, z czasem odpadają. \n" +
                                "\n" +
                                "Osłona wewnętrzna biaława, z wiekiem brązowawa do szarobrązowawej, gładka, łamliwa otwiera się na szczycie i odpada płatami . \n" +
                                "\n" +
                                "Gleba biała, z wiekiem oliwkowobrązowa do brązowej, podglebie oddzielone od gleby wyraźną błyszczącą diafragmą; jest ono dobrze rozwinięta, komorowata, biała. \n" +
                                "\n" +
                                "Występoawanie- owocniki wyrastają pojedynczo lub w grupach poza lasami, na łąkach, pastwiskach. \n" +
                                "\n" +
                                "Zastosowanie - jadalna. \n".toString();
                        qwe = R.drawable.oczkowata;
                        qwe2 = R.drawable.splaszczonabig;
                        list1 = "Purchawka oczkowana Lycoperdon utriforme,".toString();
                        list2 = "jej powierzchnia pęka na drobne poletka;";
                        list13 = "ektoperydium wcześnie złuszcza się.";
                        list3 = "Purchawka łatkowata Lycoperdon mamiforme,";
                        qwe3 = R.drawable.lakowanapu;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.laka;
                        typgrzyb = R.drawable.def4;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 172:
                        TempListViewClickedValue = "Purchawka oczkowata Calvatia utriformis"+"\n"+"jako czasznica oczkowata".toString();
                        TempListViewClickedValue2 = "Owocniki duże, krótko maczugowate, rzadziej bulwiaste, 5-15cm średnicy, szczyt spłaszczony, pomarszczony lub płytko dołkowany. Osłona dwuwarstwowa.\n" +
                                "\n" +
                                "Osłona zewnętrzna początkowo biała, pilśniowate, z wiekiem szarobrązowawe, popękane na duże poletka, u dojrzałych owocników egzoperydium odpada.\n" +
                                "\n" +
                                "Osłona wewnętrzna szarobrązowa, matowa do nieznacznie połyskującej, konsystencji papierowej; pęka od szczytu owocnika na duże, nieregularne fragmenty i odpada. Podglebie sztywne, zbudowane z dużych komór, początkowo białe, z wiekiem szarobrązowe do brązowego.\n" +
                                "\n" +
                                "Zastosowanie- jadalna.\n" +
                                "\n" +
                                "Występuje często; poza lasami, na terenach trawiastych, na ciepłych stanowiskach i żyznych, łąkach i pastwiskach.\n".toString();
                        qwe = R.drawable.fioletowapu;
                        qwe2 = R.drawable.oczkowatabig;
                        list1 = "Purchawka fiolowata Lycoperdon excipuliforme,".toString();
                        list2 = "podobne, szczególnie okazy beztrzonowe.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.laka;
                        typgrzyb = R.drawable.def4;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 173:
                        TempListViewClickedValue = "Sarniak dachówkowaty Sarcodon imbricatus".toString();
                        TempListViewClickedValue2 = "Owocnik brązowy, z czerwonym odcieniem, brzeg jaśniejszy, do białawego; duży, 6-25 cm średnicy.\n" +
                                "\n" +
                                "Powierzchnia z ciemniejszymi łuskami, ciemnobrązowymi do czarnobrązowych, grubymi, trójkątnymi, odstającymi łuskami; łuski ułożone zwykle koncentrycznie; nieregularnie okrągły, początkowo wypukły, z wiekiem rozpostarty, z zagłębionym w centrum, pofałdowany. \n" +
                                "\n" +
                                "Hymenofor kolczasty; kolce początkowo białawe, potem szare i brązowe z purpurowym odcieniem; 5-10 mm długości, 1 mm grubości; hymenofor zbiegający na trzon. \n" +
                                "\n" +
                                "Trzon młody białawy, z wiekiem szarawy, brązowawy, podstawa jaśniejsza, 30-80 na 10-30; powierzchnia aksamitna, gładka; cylindryczny do maczugowatego; pełny. \n" +
                                "\n" +
                                "Miąższ w młodych okazach białawy, z wiekiem szarawobrązowy; zwarty, ale dosyć kruchy; w podstawie u starszych egzemplarzach jest zdrewniały. Zapach przyjemny, korzenny chociaż niezbyt mocny. Smak łagodny, przyjemny, z wiekiem może być trochę gorzkawy. \n" +
                                "\n" +
                                "Występuje rzadko, częściej spotykany zwłaszcza w górach. Owocniki wyrastają pojedynczo, w grupach lub zrośnięte po kilka, czasem masowo; w lasach świerkowych i sosnowych; preferuje gleby kwaśne, piaszczyste. Może tworzyc kręgi. \n" +
                                "\n" +
                                "Zastosowanie – jadalny. \n".toString();
                        qwe = R.drawable.piekacyser;
                        qwe2 = R.drawable.dachowkowatysabig;
                        list1 = "Sarniak piekący Sarcodon fuligineo-violaceus,".toString();
                        list2 = "ma więcej niebieskich i fioletowych odcieni;";
                        list13 = "owocnik koloru kawy; rośnie w lasach liściastych;";
                        list3 = "Sarniak fiołkowy Sarcodon joeides,";
                        qwe3 = R.drawable.fiolkowyser;
                        list14 = "ma rurkowy hymenofor.";
                        list4 = "Szyszkowiec łuskowaty Strobilomyces strobilaceus,";
                        qwe4 = R.drawable.luskowatyszy;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t8;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 174:
                        TempListViewClickedValue = "Siatkolist maczugowaty Gomphus clavatus".toString();
                        TempListViewClickedValue3 = "Gatunek objęty ochroną częściową w Polsce!".toString();
                        TempListViewClickedValue2 = "Owocnik 4-10 cm wysokości, 2-6 cm średnicy; liliowy do fioletowego, z wierzchu z wiekiem brązowawożóltawy; młody maczugowaty z uciętym szczytem, potem w kształcie kręgu i lejkowato wgłębiony.\n" +
                                "\n" +
                                "Powierzchnia gładka do falisto zmarszczonej na stronie zewnętrznej; listwy główne podłużne i poprzeczne, fioletowe do różowożółtawych. \n" +
                                "\n" +
                                "Hymenofor początkowo fioletowy, z wiekiem coraz bardziej z dominującą czerwonobrązową barwą, z wiekiem blednie; pokrywa boki owocnika, w formie grubych, nieregularnych rozwidlonych listewek, fałd, niekiedy połączonych w siateczkę; zbiegający nisko na niewyraźny trzon. \n" +
                                "\n" +
                                "Miąższ biały, miękki, pełny, bez szczególnego zapachu, smak łagodny. \n" +
                                "\n" +
                                "Występuje rzadko, w lasach iglastych i liściastych, często w czarcich kręgach, owocniki od sierpnia do października. \n" +
                                "\n" +
                                "Zastosowanie - jadalny.\n".toString();
                        qwe2 = R.drawable.maczugowatybig;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t5;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 175:
                        TempListViewClickedValue = "Siedzuń dębowy Sparassis brevipes".toString();
                        TempListViewClickedValue2 = "Owocnik kulisty do 40 cm szerokości i 20 cm wysokości, kalarofiowaty, słożony z krótkiego mięsistego trzonu , z którego wyrastają liczne, rozgałęziające się gałązki zakończone tępymi, falistymi , listkowatymi płatkami. Za młodu barwa owocników jest biaława z czasem staje się kremowa do bladoochrowej.\n" +
                                "\n" +
                                "Miąższ białawy, elastyczny o przyjemnym zapachu i nieco łagodnym kwaskowatym smaku.\n" +
                                "\n" +
                                "Występuje na korzeniach dębów wyjątkowo pod innymi gatunkami, od lipca do października.\n" +
                                "\n" +
                                "Zastosowanie – jadalny.\n".toString();
                        qwe = R.drawable.sosnowysie;
                        qwe2 = R.drawable.debowyszbig;
                        list1 = "Siedzeń sosnowy Sparassis crispa,".toString();
                        list2 = "ma ciemniejsze owocniki, wąskie rozgałęzienia.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.def2;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 176:
                        TempListViewClickedValue = "Siedzuń sosnowy Sparassis crispa".toString();
                        TempListViewClickedValue2 = "Owocnik duży; nieregularnie kulisty, elipsoidalny; 10-30 cm szerokości i 10-15 cm wysokości; składa się z krótkiego trzonu, od którego odchodzą liczne, gęsto ułożone odgałęzienia zakończone płaskimi, zaokrąglonymi, łopatkami o gładkiej powierzchni; barwa listków kremowa, z czasem ciemnieją do żółtawej, ochrowej, a zakończenia brązowieją. \n" +
                                "\n" +
                                "Miąższ białawy, bardzo łamliwy, woskowaty; zapach przyjemny; smak łagodny. \n" +
                                "\n" +
                                "Występuje nieczęsto, pojedynczo, od lipca do października, u podstawy drzew iglastych, zazwyczaj sosny, rzadziej świerka. \n" +
                                "\n" +
                                "Zastosowanie - jadalny. \n".toString();
                        qwe = R.drawable.debowysz;
                        qwe2 = R.drawable.sosnowysiebig;
                        list1 = "Szmaciak dębowy Sparassis laminosa,".toString();
                        list2 = "jest białawy, słomiastożółty;";
                        list13 = "wyrastający na korzeniach jodeł.";
                        list3 = "Szmaciak jodłowy Sparassis nemecii,";
                        qwe3 = R.drawable.jodlowyszm;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.def2;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 177:
                        TempListViewClickedValue = "Smardz jadalny Morchella esculenta".toString();
                        TempListViewClickedValue3 = "Gatunek objęty ochroną częściową w Polsce!".toString();
                        TempListViewClickedValue2 = "Owocnik o wysokości do 20 cm; prawie okrągły, tylko rzadko nieco wydłużony; na calej główce znajdują się szerokie zagłebienia, tak zwane alweole, powstają one z żeberek i ścieżek, często faliscie połączonych z sobą; barwa jasnoochrowa albo jasnożółta z odcieniem brązowym; w środku pusty podobnie jak jaśniejszy, jednolicie zabarwiony trzon. \n" +
                                "\n" +
                                "Trzon o średnicy 2-4 cm. Grubieje u podstawy; powierzchnię ma pomarszczoną, pokrytą drobnymi, lepkimi ziarenkami. \n" +
                                "\n" +
                                "Miąższ białawy, kremowy , kruchy; smak i zapach przyjemne. \n" +
                                "\n" +
                                "Wystepuje gromadnie, ale spotyka się również pojedynczo wyrastające okazy. Owocniki pojawiają się wiosną, od kwietnia do początku czerwca, na żyznych glebach, na brzegach rzek i potoków, wśród lepiężników, w trawie, na trawiastych skrajach lasów, wsród żywopłotów, na rabatach kwiatowych. \n" +
                                "\n" +
                                "Zastosowanie – jadalny.\n".toString();
                        qwe = R.drawable.kasztanowata;
                        qwe2 = R.drawable.jadalnysmabig;
                        list1 = "Piestrzenica kasztanowata Gyromitra esculenta,".toString();
                        list2 = "występuje w lasach iglastych.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.laka;
                        typgrzyb = R.drawable.t3;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 178:
                        TempListViewClickedValue = "Soplówka bukowa Hericium clathroides".toString();
                        TempListViewClickedValue3 = "Gatunek objęty ochroną częściową w Polsce!".toString();
                        TempListViewClickedValue2 = "Owocnik nieregularny, kulisty lub wydłużony; szerokości do 40 cm i wysokośći do 25 cm, jest zbudowany z gałązek, igiełki porastają równomiernie odgałęzienia, a na jego końcach tworzą skupienia; długość kolców dochodzi do 1 cm, grubość 1.5-3 mm; barwa owocnika początkowo biała, w miarę wysychania żółknie i brązowieje. Przypomina kształtem koralowca. \n" +
                                "\n" +
                                "Miąższ zabarwiony jak owocnik, gąbczasty, bez szczególnego zapachu i smaku. \n" +
                                "\n" +
                                "Występuje rzadko, od lata do jesieni; owocniki tworzą się na kłodach drzew liściastych, zwłaszcza buka i dębu , rzadziej na brzozie brodawkowatej i topoli osice.\n" +
                                "\n" +
                                "Zastosowanie - bez zastosowania kulinarnego, z uwagi na ochronę.\n".toString();
                        qwe = R.drawable.jodlowasop;
                        qwe2 = R.drawable.bukowasopbig;
                        list1 = "Soplówka jodłowa Hericium coralloides, ".toString();
                        list2 = "tworzy owocniki na drewnie jodły i świerka;";
                        list13 = "jej owocniki wyrastają na drewnie liściastym.";
                        list3 = "Soplówka jeżowata Hericium erinaceum,";
                        qwe3 = R.drawable.jezykowatasop;
                        jedzenie = R.drawable.niejadalny;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.def2;
                        jadalnosc.setImageResource(R.drawable.niejadalny);
                        break;
                    case 179:
                        TempListViewClickedValue = "Sromotnik smrodliwy Phallus impudicus".toString();
                        TempListViewClickedValue2 = "Owocnik o wymiarach 4-5 na 3-5 cm wielkości; białawy, kremowy z żółtawym odcieniem; kulisty lub jajowaty; częściowo w ziemi, od spodu przytwierdzony do podłoża za pomocą dość grubych, przypominających korzenie, białych sznurów grzybni; w dojrzewającym owocniku osłona pęka i tworzy się 2-3 warstwowa, wewnątrz galaretowata, odstająca pochwa.\n" +
                                "\n" +
                                "Główka 2-6 cm wysokości i 2-5 cm szerokości; początkowo pokryta oliwkowozielonawym, oliwkowobrązowym lub czarnooliwkowym śluzem, zawierającym zarodniki; po rozsianiu staje się biaława, żółtawa z wyraźnymi, jamkowatymi, pustymi komorami, naparstkowata lub stożkowata.\n" +
                                "\n" +
                                "Trzon 10-25 cm wysokości i 2,5-4 cm grubości; biały, białawy; wrzecionowaty, gąbczasty, porowaty, w środku pusty, bardzo kruchy. \n" +
                                "\n" +
                                "Miąższ białawy, żółtawy, zapach dojrzałych owocników jest bardzo silny, nieprzyjemny, przypominający padlinę, przywabia owady, które zjadają i rozsiewają zarodniki. \n" +
                                "\n" +
                                "Występuje od maja do listopada w różnych typach lasów, często w bukowych oraz w parkach i zaroślach, na glebach żyznych, zasobnych w próchnicę, w miejscach cienistych i wilgotnych; pojedynczo lub w niewielkich grupach.\n".toString();
                        qwe = R.drawable.fiolkowysrom;
                        qwe2 = R.drawable.smrodliwysrobig;
                        list1 = "Sromotnik fiołkowy Phallus Hadrianie,".toString();
                        list2 = "wyróżnia się purpurową barwą osłony 'jaja', rośnie głównie na wydmach;";
                        list13 = "tworzy mniejsze i bardziej wiotkie owocniki.";
                        list3 = "Mądziak psi Mutinus caninus,";
                        qwe3 = R.drawable.psimad;
                        jedzenie = R.drawable.niejadalny;
                        lasy = R.drawable.laka;
                        typgrzyb = R.drawable.t3;
                        jadalnosc.setImageResource(R.drawable.niejadalny);
                        break;
                    case 180:
                        TempListViewClickedValue = "Strzępiak ceglasty Inocybe erubescens".toString();
                        TempListViewClickedValue2 = "Kapelusz 3-9 cm średnicy, stożkowato wypukły, mięsisty w części centralnej, cienki przy brzegu, który bywa początkowo podwinięty, a później staje się prosty i promienisto spękany. Kolor początkowo czysto biały lub bladokremowy, wcześnie zmieniający się na ceglasty do cynobrowoczerwonego; zabarwienie to zwykle występuje pod postacią plam najintensywniejszych na szczycie kapelusza.\n" +
                                "\n" +
                                "Powierzchnia sucha, jedwabista, gładka, bez śladu łuseczek, ale delikatnie włókienkowata.\n" +
                                "\n" +
                                "Blaszki dość gęste, cienkie, szerokie, zatokowato wycięte lub prawie wolne, białawe do ciemno-oliwkowo-rdzawych, przy nacisku czerwieniejące, o jaśniejszym, nierównym, oszronionym ostrzu.\n" +
                                "\n" +
                                "Trzon 5-20 na 0,8-2 cm, mięsisty, równogruby lub z bardzo nieznacznie zaznaczającą się  bulwką, pełny, biały, różowy lub prawie cały cynobrowy dzięki okrywającym go zabarwionym włókienkom, na samym szczycie oszroniony.\n" +
                                "\n" +
                                "Miąższ biały w kapeluszu, w trzonie intensywnie różowiejący, o miłej i dosyć silnej owocowej woni i o łagodnym smaku.\n" +
                                "\n" +
                                "Występuje grupami lub pojedynczo w lasach liściastych, głównie bukowych na podłożu wapiennym, lub na poboczach dróg pod lipami i dębami. Owocniki bywają znajdowane od maja aż do sierpnia włącznie. Częsty.\n" +
                                "\n" +
                                "Zastosowanie- trujący.\n".toString();
                        qwe = R.drawable.czerwieniejacystrz;
                        qwe2 = R.drawable.ceglastystbig;
                        list1 = "Strzępiak czerwieniejący Inocybe godeyi,".toString();
                        list2 = "ma trzon z dobrze wykształconą bulwką;";
                        list13 = "nie wykazuje śladów czerwieni.";
                        list3 = "Strzępiak porysowany Inocybe fastigiata,";
                        qwe3 = R.drawable.porysowanystrz;
                        jedzenie = R.drawable.trujacy;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.t9;
                        jadalnosc.setImageResource(R.drawable.trujacy);
                        break;
                    case 181:
                        TempListViewClickedValue = "Szyszkowiec łuskowaty Strobilomyces floccopus".toString();
                        TempListViewClickedValue3 = "Gatunek objęty ochroną częściową w Polsce!".toString();
                        TempListViewClickedValue2 = "Owocnik 5-15 cm średnicy; szarobrązowy do czarnobrązowego; u młodych wypukły, wkrótce szeroko sklepiony; gęsto pokryty brodowatymi, białoszarymi, na starść czerniejącymi łuskami. \n" +
                                "\n" +
                                "Pory najpierw białoszare, później szarobrązowe; szerokie; pod naciskiem czernieją; o dużych porach. \n" +
                                "\n" +
                                "Trzon smukły i długi; o twardym miąższu; bez pierścienia; pokryty szarymi łuseczkami, szary do czarnobrązowego, przy nacisku czerniejący. Dolna część trzonu wygląda jak węgiel drzewny. \n" +
                                "\n" +
                                "Miąższ białoszary, na przekroju lekko czerwienieje, potem czernieje; zapach nieprzyjemny ziemisty. \n" +
                                "\n" +
                                "Występuje rzadko; owocniki wyrastają latem, zwykle pojedynczo, w różnego typu lasach, częściej w górach.\n" +
                                "\n" +
                                "Zastosowanie - jadalne są młode owocniki. \n".toString();
                        qwe2 = R.drawable.luskowatyszybig;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 182:
                        TempListViewClickedValue = "Tęgoskór cytrynowy Scleroderma citrinum".toString();
                        TempListViewClickedValue2 = "Owocnik kulisty, owalny lub bulwiasty, duży, do 15 cm średnicy, trzon szczątkowy w postaci pęku białawych strzępek; w różnych odcieniach koloru żółtego, brązowego, pomarańczowego lub cytrynowego; powierzchnia spękana na duże poletka i często z odstającymi łuskami. \n" +
                                "\n" +
                                "Okrywa gruba, do kilku mm. Całkowicie dojrzałe owocniki otwierają się w środku okrągławym otworem i uwalniają zarodniki. \n" +
                                "\n" +
                                "Wnętrze początkowo białawe, z wiekiem czarnoczerwonofioletowe z białym marmurkowaniem, następnie szybko sucha i łupkowoszara, w końcu zmienia się w pylisty proszek. \n" +
                                "\n" +
                                "Bardzo pospolity latem i jesienią, zwykle w grupach, na powierzchni ziemi lub nieco zagłębione, czasem na pniakach i pniach, przeważnie na ubogich, piaszczystych glebach w lasach iglastych, na obrzeżach lasów i poboczach dróg leśnych. \n" +
                                "\n" +
                                "Zastosowanie - niejadalny, trujący!\n".toString();
                        qwe = R.drawable.brodawkowany;
                        qwe2 = R.drawable.cytrynowytegbig;
                        list1 = "Tęgoskór brodawkowy Scleroderma verrucosum,".toString();
                        list2 = "przeważnie posiada wyraźny trzonek.";
                        jedzenie = R.drawable.trujacy;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.def1;
                        jadalnosc.setImageResource(R.drawable.trujacy);
                        break;
                    case 183:
                        TempListViewClickedValue = "Trufla letnia Tuber aestivum".toString();
                        TempListViewClickedValue2 = "Owocnik podziemny, w formie bulwy, która może osiągać wielkość ziemniaka i wagę do 0.5 kg, średnicę 2-11 cm; powierzchnia ciemnobrązowa do czarnej, z grubymi brodawkami, brodawki dość regularne, piramidalne, wielokątne. \n" +
                                "\n" +
                                "Gleba początkowo biała, w miarę dojrzewania szarawa lub żółtawa i dojrzała brązowa do czerwonobrązowej z białymi żyłkami; zapach intensywny, przyjemny. \n" +
                                "\n" +
                                "Występuje na glebach zasadowych, wapiennych, w warstwie humusu, płytko pod powierzchnią (10-20 mm), pod dębami, bukami, grabami, jesionami. Owocniki często wyrastają w gniazdach po kilka. \n" +
                                "\n" +
                                "Zastosowanie - jadalna, wysoko ceniona z racji aromatu. \n".toString();
                        qwe = R.drawable.wglebionatr;
                        qwe2 = R.drawable.letniatrubig;
                        list1 = "Trufla wgłębiona Tuber mesentericum,".toString();
                        list2 = "ma drobniejsze brodawki i wgłębienie w owocniku.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.def3;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 184:
                        TempListViewClickedValue = "Twardówka anyżkowa Lentinellus cochleatus".toString();
                        TempListViewClickedValue2 = "Owocnik 2-6cm szerokości, cielisty do czerwonawobrązowego, lejkowaty do trąbkowatego, brzeg podwinięty. \n" +
                                "\n" +
                                "Blaszki zbiegające, młode białe, później jasno-cieliste, z karbowanym ostrzem. \n" +
                                "\n" +
                                "Trzon 20-50 na 8-15mm, umieszczony centralnie lub bocznie, czerwonawobrązowy, ciemniejący ku podstawie.\n" +
                                "\n" +
                                "Miąższ różowawy, łykowaty; smak łagodny, zapach anyżkowy. \n" +
                                "\n" +
                                "Występuje od lipca do października, na pniakach drzew liściastych, rzadko na iglastych, również na obumarłych gałęziach i korzeniach. \n" +
                                "\n" +
                                "Zastosowanie- jadalna, niezbyt smaczna. \n".toString();
                        qwe2 = R.drawable.anyzkowatwbig;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.mieszany;
                        typgrzyb = R.drawable.def2;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 185:
                        TempListViewClickedValue = "Twardzioszek przydrożny Marasmius oreades".toString();
                        TempListViewClickedValue2 = "Owocnik higrofaniczny, gdy jest suchy, ma kolor bladoochrowy, kremowocielisty, wilgotny jest ciemniejszy - brunatny, czerwonoochrowy; kształt początkowo półkulisty, tępo stożkowaty, z wiekiem prawie płaski i zwykle z szerokim, nieco ciemniejszym, garbkiem, 2-6 cm średnicy.\n" +
                                "\n" +
                                "Powierzchnia gładka, u wilgotnych okazów brzeg prążkowany. Podczas suszy owocniki tego grzyba więdną i stają się wyblakłe, po deszczach znów stają się jędrne. \n" +
                                "\n" +
                                "Blaszki barwy kapelusza; rzadkie, szerokości 3-6 mm; przy trzonie zaokrąglone. \n" +
                                "\n" +
                                "Trzon barwy kapelusza, równogruby, 40-70 na 3-4 mm; powierzchnia gładka, u postawy krótko owłosiona, włóknisty i łykowaty; u podstawy biaława grzybnia. \n" +
                                "\n" +
                                "Miąższ białawy, niezmienny; zapach przyjemny; smak łagodny. \n" +
                                "\n" +
                                "Występuje na pastwiskach, łąkach, placach tartacznych, brzegach lasów, najczęściej w pobliżu ścieżki lub drogi. Owocuje od wiosny do późnej jesieni. Jest to jeden z najsmaczniejszych i najpożywniejszych grzybów, mimo że ma niewielkie wymiary. Nadaje się również do suszenia. Twardy i stwardniały trzonek należy odrzucić. \n" +
                                "\n" +
                                "Zastosowanie - jadalny. \n".toString();
                        qwe = R.drawable.lisciowa;
                        qwe2 = R.drawable.przydroznybig;
                        list1 = "Lejkówka liściowa Clitocybe phyllophila,".toString();
                        list2 = "jej blaszki słabo zbiegają i nie ma przebarwień na kapeluszu;";
                        list13 = "ma mączny smak, blaszki bardziej zbiegające, a na kapeluszu charakterystyczne plamy.";
                        list3 = "Lejkówka jadowita Clitocybe dealbata,";
                        qwe3 = R.drawable.jadowitalej;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.laka;
                        typgrzyb = R.drawable.t7;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 186:
                        TempListViewClickedValue = "Uchówka ośla Otidea onotica".toString();
                        TempListViewClickedValue2 = "Owocnik miseczkowato-uchowaty, asymetryczny, brzeg zawinięty do środka, z krótkim trzoneczkiem zakończonym, biało filcowatą grzybnią. Wysokości 3-11 cm, szerokości 10-30 mm, żółtopomarańczowy, potem blednie. Po wewnętrznej stronie (zarodnikonośnej) jest intensywniej zabarwiony - różowoczerwonawo, gładki. Strona zewnętrzna trochę oprószona i pomarszczona, ochrowożółta. Często owocniki są pozrastane ze sobą po kilka. \n" +
                                "\n" +
                                "Miąższ białawy, woskowaty, cienki, kruchy. Zapach przyjemny, smak słodkawy.     \n" +
                                "\n" +
                                "Dość pospolity w lasach liściastych, buczynach, rzadziej iglastych. Owocniki wyrastają w grupach od lipca do listopada. \n" +
                                "\n" +
                                "Zastosowanie - jadalna. \n".toString();
                        qwe = R.drawable.zajeczauch;
                        qwe2 = R.drawable.oslauchbig;
                        list1 = "Uchówka zajęcza Otidea leporina,".toString();
                        list2 = "jest mniejsza, ciemniej zabarwiona;";
                        list13 = "owocniki ochrowo brązowawe,";
                        list3 = "Uchówka ślimakowata Otidea cochleata,";
                        qwe3 = R.drawable.slimakowata;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.t4;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 187:
                        TempListViewClickedValue = "Uszak bzowy Hirneola auricula-judae"+"\n"+"jako Ucho bzowe".toString();
                        TempListViewClickedValue2 = "Owocnik 4-10 cm szerokości; nazwa grzyba pochodzi od kształtu przypominające ucho. Jednakże to \"ucho'' może być również muszelkowate, odwrotnie miseczkowate, płatowe, skręcone lub u nasady zwężone w kształcie trzonu. Barwy czerwonobrązowej do oliwkowobrązowej lub fioletowoszarej. \n" +
                                "\n" +
                                "Na gładkiej, błyszczącej, poprzecinanej listwami stronie wewnętrznej znajduje się warstwa zarodnikonośna, podczas gdy bezpłodna strona zewnętrzna jest puszyście filcowata i szarawa. \n" +
                                "\n" +
                                "Miąższ ciemnobrązowy, wilgotny jest galaretowaty lub chrząstkowaty, elastyczny, prześwitujący; bez smaku i zapachu; wysuszony jest twardy, łamliwy, pomarszczony, bardzo lekki, silnie skurczony; przy wilgotnej pogodzie powraca do pierwotnych rozmiarów. \n" +
                                "\n" +
                                "Jest szeroko rozpowszechniony, ale nie występuje w wyższych partiach gór. Rośnie na gałęziach bzu czarnego, lecz również na innych drzewach i krzewach liściastych. Owocniki występują w przeciągu całego roku, w okresach bezmroźnych i wilgotnych. \n" +
                                "\n" +
                                "Zastosowanie - jadalny. \n".toString();
                        qwe = R.drawable.skornikowaty;
                        qwe2 = R.drawable.bzowyuszbig;
                        list1 = "Uszak skórnikowaty Auricularia mesenterica,".toString();
                        list2 = "ma silnie filcowato owłosioną i strefowaną zewnętrzną powierzchnię owocnika. Kształt jest bardziej rozpostarty, miąższ zdecydowanie grubszy.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.def1;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 188:
                        TempListViewClickedValue = "Wilgotnica karminowa Hygrocybe punicea".toString();
                        TempListViewClickedValue3 = "Gatunek objęty ochroną w Niemczech!".toString();
                        TempListViewClickedValue2 = "Kapelusz 4-12 cm, higrofaniczny,początkowo półkulisto sklepiony, później płasko rozpostarty, ale szczyt zawsze tępo uwypuklony, brzeg u starszych okazów porozrywany, a nawet pękniety prawie do połowy kapelusza. Konsystencja mięsista, ale dość krucha.Wilgotne okazy karminowoczerwone, pomarańczowoczerwone lub żółtoczerwone o brzegu zawsze jaśniejszym, przeschnięte okazy blado-żółto-pomarańczowe, tylko miejscami czerwone. \n" +
                                "\n" +
                                "Powierzchnia gładka, lepka, jedwabista, czasem połyskująca.\n" +
                                "\n" +
                                "Trzon o wymiarach 6-10 na 1-1,5cm, równowąski, czasem u nasady lekko zwężony, dość masywny, mięsisty, pełny. Barwa pomarańczowo-żółto-czerwona, u podstawy jaśniejsza, żółtawa lub biaława. Powierzchnia sucha, bardzo drobno prążkowana od wzdłużnie przebiegających czerwonych włókienek, czasem bardzo drobno kosmkowa ta.\n" +
                                "\n" +
                                "Miąższ początkowo białawy, później blado-pomarańczowo-żółty, wodnisty, miękki, pod skórką kapelusza czerwonawy. Smak łagodny, zapachu brak.\n" +
                                "\n" +
                                "Blaszki bladożółte do czerwonopomarańczowych, grube, szerokie, różnej długości, przy trzonie ząbkiem wykrojone, a nawet lekko zbiegające. U starszych okazów przy brzegu kapelusza połączone anastomozami i często porozrywane. Ostrza gładkie lub grubo ząbkowane.\n" +
                                "\n" +
                                "Występuje od siepnia do października przeważnie gromadnie, rzadziej pojedynczo na łąkach, polanach śródleśnych, trawiastych stokach nadrzecznych, na brzegach lasów.\n".toString();
                        qwe = R.drawable.okazalawil;
                        qwe2 = R.drawable.karminowawibig;
                        list1 = "Wilgotnica okazała Hygrocybe splendidissima,".toString();
                        list2 = "smuklejsza, kapelusz ma pomidorowoczerwony, trzon na żółtym tle pomarańczowo włóknisty, zaś miąższ żywo pomarańczowy;";
                        list13 = "ma kapelusz czereśniowoczerwony, miąższ czerwony, zaś blaszki szeroko przyrośnięte do trzonu.";
                        list3 = "Wilgotnica szkarłatna Hygrocybe coccinea,";
                        qwe3 = R.drawable.szkarlatnawil;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.laka;
                        typgrzyb = R.drawable.t9;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 189:
                        TempListViewClickedValue = "Wilgotnica żółknąca Hygrocybe chlorophana".toString();
                        TempListViewClickedValue3 = "Gatunek objęty ochroną w Niemczech!".toString();
                        TempListViewClickedValue2 = "Kapelusz 2-4 cm, początkowo wypukły, po dojrzeniu płasko rozpostarty, o brzegu u wilgotnych owocników delikatnie prążkowanym od prześwitających blaszek. \n" +
                                "\n" +
                                "Powierzchnia gładka, śluzowata, po wyschnięciu błyszcząca, o barwie siarkawożółtej lub żółtej z odcieniem pomarańczowym na szczycie.\n" +
                                "\n" +
                                "Trzon 3-6 na 0,4-0,7 cm, wysmukły, równowąski, łatwo łamliwy, wewnątrz pusty, na powierzchni gładki, suchy, o barwie siarkawożółtej, u podstawy czasem blednący.\n" +
                                "\n" +
                                "Miąższ żółty, w kapeluszu i trzonie cienki, kruchy, nie czerniejący, o smaku łagodnym i bez zapachu.\n" +
                                "\n" +
                                "Blaszki cytrynowożółte, stosunkowo szerokie, dość gęste, różnej długości, przyrośnięte lub zaokrąglone przy trzonie, o ostrzu równym i gładkim.\n" +
                                "\n" +
                                "Występuje pojedynczo lub w nielicznych grupach wśród traw na łąkach, brzegach lasów, polanach śródleśnych, głównie w murawach alpejskich lub rzadkich prześwietlonych lasach.\n".toString();
                        qwe = R.drawable.wypuklawil;
                        qwe2 = R.drawable.zolknacawilbig;
                        list1 = "Wilgotnica wypukła Hygrocybe quieta,".toString();
                        list2 = "ma nieco ciemniejszy kapelusz z pomarańczowym wierzchołkiem, blaszki też nieco ciemniejsze.";
                        jedzenie = R.drawable.trujacy;
                        lasy = R.drawable.laka;
                        typgrzyb = R.drawable.t9;
                        jadalnosc.setImageResource(R.drawable.trujacy);
                        break;
                    case 190:
                        TempListViewClickedValue = "Włośnianka musztardowa Hebeloma sinapizans".toString();
                        TempListViewClickedValue2 = "Kapelusz o średnicy 4–12 cm. U młodych okazów wypukły z podwiniętym brzegiem, później płaski, u starszych szeroko rozpostarty, dość często z niewielkim, tępym garbem. \n" +
                                "\n" +
                                "Powierzchnia kapelusza śliska i gładka, u młodych okazów na brzegach białokremowa, w środku rdzawożólta, u starszych ciemnieje do koloru czerwonoochrowego lub brudnobrązowego.\n" +
                                "\n" +
                                "Blaszki gęste, wolne lub wąsko przyrośnięte. Początkowo mają białawy lub kremowy kolor, z czasem ciemnieją przyjmując kolor kawy z mlekiem, w końcu stają się cynamonowobrązowe.\n" +
                                "\n" +
                                "Trzon o wysokości 4–10 cm, grubości 1–2 cm, cylindryczny, włóknisty z bulwkowato rozszerzoną podstawą. W górnej części pokryty jest białawymi łuseczkami, które z czasem ciemnieją do brązowego koloru, w dolnej jest ciemniejszy.\n" +
                                "\n" +
                                "Miąższ białawy, twardy, gruby, nie zmieniający barwy po uciśnięciu. U młodych okazów jest miękki, u starszych twardy. Ma gorzki smak i zapach podobny do rzodkwi.\n" +
                                "\n" +
                                "Występuje w lasach liściastych, głównie pod bukami. Często można ją spotkać także w parkach i ogrodach. Rośnie głównie na glebach o odczynie zasadowym.\n" +
                                "\n" +
                                "Zastosowanie - grzyb trujący. \n" +
                                "\n" +
                                "Rośnie głównie pod bukami, rzadko pod lipami, szczególnie chętnie na glebach wapiennych. Owocniki pojawiają się od czerwca do października.\n".toString();
                        qwe = R.drawable.wrzecionowatozar;
                        qwe2 = R.drawable.musztardowabig;
                        list1 = "Włośnianka wrzecionowatozarodnikowa Hebeloma laterinum,".toString();
                        list2 = "rośnie pod sosnami, świerkami i modrzewiami;";
                        list13 = "mniejsza i często na jej blaszkach i górnej części trzonu występują krople mleczka, lub plamki po jego zaschnięciu.";
                        list3 = "Włośnianka rosista Hebeloma crustuliniforme,";
                        qwe3 = R.drawable.rosistawlo;
                        jedzenie = R.drawable.trujacy;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.trujacy);
                        break;
                    case 191:
                        TempListViewClickedValue = "Wodnicha biała Hygropgorus eburneus".toString();
                        TempListViewClickedValue2 = "Owocnik 2-10cm średnicy, biały do lekko kremowego, półkulisty z czasem prawie płaski z szerokim garbkiem, podczas wilgotnej pogody śluzowaty, podczas suchych dni lepki, tłusty, błyszczący; brzeg podwinięty; dojrzały czasami falisto powyginany do góry. \n" +
                                "\n" +
                                "Blaszki białe do kremowych, woskowe, grube, dość odległe, umiarkowanie szerokie, nieco zbiegające. \n" +
                                "\n" +
                                "Trzon o wymiarach 4-12 na 0,5-1,5cm, równogruby na całej długości lub ku podstawie zbieżysty i lekko wygięty, dojrzały jest pusty w środku, na szczycie drobno nakrapiany, poniżej gładki, biały, lepki, bez pierścienia. \n" +
                                "\n" +
                                "Miąższ biały, delikatny, gruby tylko na środku. \n" +
                                "\n" +
                                "Występuje od sierpnia do października w lasach liściastych i mieszanych, z gatunkami o twardym drewnie, zazwyczaj pod bukami, na wapiennych glebach, pojedynczo bądź gromadnie. \n" +
                                "\n" +
                                "Zastosowanie – jadalna.\n".toString();
                        qwe = R.drawable.swierkowawod;
                        qwe2 = R.drawable.bialawodbig;
                        list1 = "Wodnicha świerkowa Hygrophorus piceae,".toString();
                        list2 = "rosnąca pod świerkami;";
                        list13 = "jest mniejszy i rośnie na łąkach.";
                        list3 = "Kopułek śnieżny Cuphophyllus virgineus,";
                        qwe3 = R.drawable.snieznykop;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 192:
                        TempListViewClickedValue = "Wodnicha brunatnobiała Hygrophorus latitabundus".toString();
                        TempListViewClickedValue3 = "Gatunek objęty ochroną częściową w Polsce!".toString();
                        TempListViewClickedValue2 = "Kapelusz 4-10 cm, początkowo wypukły, po dojrzeniu szeroko rozpostarty, na szczycie mniej lub bardziej wypukły, na brzegu dość długo podwinięty i u młodych okazów biało oszroniony. Powierzchnia śluzowata, u starszych okazów w czasie suszy wysychająca (lub lekko lepka), gładka, ciemnobrązowa, czasem z szarym lub oliwkowym odcieniem.\n" +
                                "\n" +
                                "Trzon 5-8 na 1,5-3 cm, walcowaty, czasem u podstawy zwężający się, wewnatrz pełny. Powierzchnia śluzowata, z mniej lub bardziej wyraźnym śluzowatym pierścieniem, poniżej którego na białym tle widoczne są drobne, szarobrunatne łuseczki. Powyżej pieścienia powierzchnia sucha, biała, z drobnymi białymi brodaweczkami lub kropelkami płynu.\n" +
                                "\n" +
                                "Miąższ biały, po przekrojeniu nie zmieniający barwy, zwarty, masywny, o smaku łagodnym i słabym słodkawym zapachu.\n" +
                                "\n" +
                                "Blaszki białe, dość grube, rzadkie, różnej długości, przy trzonie szeroko przyrośnięte lub lekko zbiegające, na brzegu równe.\n" +
                                "\n" +
                                "Występuje od sierpnia do listopada w lasach iglastych, głównie sosnowych, często wśród mchów.\n" +
                                "\n" +
                                "Zastosowanie – jadalny\n".toString();
                        qwe = R.drawable.oliwkowobiala;
                        qwe2 = R.drawable.brunatnobialabig;
                        list1 = "Wodnicha oliwkowobiała Hygrophorus olivaceoalbus,".toString();
                        list2 = "cieńszy trzon, do 12 mm, rzadkie blaszki.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 193:
                        TempListViewClickedValue = "Wodnicha gołąbkowa Hygrophorus russula".toString();
                        TempListViewClickedValue2 = "Owocnik początkowo półkolisty, potem łukowaty, płaski, w końcu środkiem wgłębiony do słabo lejkowaty z długo podwiniętym brzegiem. Średnicy 4-10cm, na białawym tle ma purpurowo lub winnoczerwone plamki, nieżółknący. Skórka mazista \n" +
                                "\n" +
                                "Blaszki szerokie, grube i gęste, przy trzonie zbiegające. Barwy białej potem białawe z winnoczerwonymi plamkami. \n" +
                                "\n" +
                                "Trzon cylindryczny, pełny, barwy białej, bez pierścienia, podłużnie włóknisty. Uszkodzony wybarwia się na różowo do czerwonego \n" +
                                "\n" +
                                "Miąższ biały uszkodzony czerwienieje. Smak gorzkawy i o niewyraźnym zapachu. \n" +
                                "\n" +
                                "Występuje rzadko, w szeregach lub czarcich kręgach. Na ciepłych stanowiskach wapiennych wiosną i latem w lasach liściastych. Pod bukami i dębami.\n" +
                                "\n" +
                                "Zastosowanie- jadalna. \n".toString();
                        qwe = R.drawable.zarozowiona;
                        qwe2 = R.drawable.golabkowawobig;
                        list1 = "Wodnicha zaróżowiona Hygrophorus erubescens,".toString();
                        list2 = "na kapeluszu i podstawie trzonu żółknie, trzon ma purpurowoczerwono nakrapiany i rośnie w górskich lasach świerkowych,";
                        list13 = "cała jest winnoczerwona.";
                        list3 = "Wodnicha kozia Hygrophorus capreolarius,";
                        qwe3 = R.drawable.koziawod;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 194:
                        TempListViewClickedValue = "Wodnicha modrzewiowa Hygrophorus pudorinus".toString();
                        TempListViewClickedValue2 = "Owocnik 2-5cm średnicy, młody wypukły, potem płasko rozpostarty, czasami z garbkiem lub lekko wkłęsły w centrum, jaskrawocytrynowożółty lub złocistożółty, w środku zazwyczaj ciemniejszy. Powierzchnia kapelusza gładka  naga, mazista. \n" +
                                "\n" +
                                "Blaszki początkowo białawe, później żółtawe, dość grube, różnej długości, znacznie oddalone od siebie, przyrośnięte lub lekko zbiegające.\n" +
                                "\n" +
                                "Trzon jaśniejszy od kapelusza, u góry białawy, cylindryczny, wilgotna powierzchnia śluzowata, sucha kosmkowata. Młode owocniki posiadają nietrwałą nitkowatą osłonę łączącą trzon z brzegiem kapelusza.\n" +
                                "\n" +
                                "Miąższ białawy lub żółtawy, pod skórką kapelusza chromowożółty, miękkawy, bez wyraźnego zapachu, w smaku cierpka. \n" +
                                "\n" +
                                "Dość często spotykana. Wyrasta gromadnie, wyłącznie pod modrzewiami. Pojawia się późną jesienią.  rośnie wyłącznie pod modrzewiami. Owocniki pojawiają się jesienią, aż do silniejszych mrozów, czasami, również w zimie\n" +
                                "\n" +
                                "Zastosowanie- jadalna. \n".toString();
                        qwe = R.drawable.ozdobnewod;
                        qwe2 = R.drawable.modrzewiowabig;
                        list1 = "Wodnicha ozdobna Hygrophorus speciosus,".toString();
                        list2 = "o pomarańczowym kapeluszu.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 195:
                        TempListViewClickedValue = "Wodnicha późna Hygrophorus hypothejus".toString();
                        TempListViewClickedValue2 = "Owocnik oliwkowobrunatny, brudnooliwkowy, żółtooliwkowy, ciemniejszy w centrum, zmienny, z czasem zaczynają dominować odcienie żółci i czerwieni, 2-12cm  średnicy. Początkowo półkulisty, z wiekiem wypukły do płaskiego i wklęsłego, czasem ze słabo zaznaczonym garbkiem, powierzchnia gładka, śluzowata, brzeg długo podgięty, początkowo połączony śluzowatą osłoną z trzonem. \n" +
                                "\n" +
                                "Listewki początkowo białe, później żółte, u starych okazów pomarańczowoczerwone, dość rzadko ustawione, różnej długości, lekko zbiegające. \n" +
                                "\n" +
                                "Trzon początkowo biały, później ciemnieje i staje się żółty do pomarańczowoczerwonego, równogruby lub nieco zwężony u podstawy, śluzowaty; powierzchnia trzonu wzdłużnie włókienkowata. \n" +
                                "\n" +
                                "Pierścień słabo zaznaczony. \n" +
                                "\n" +
                                "Miąższ żółtawy, niezmienny, smak łagodny, słaby zapach, czasem delikatnie owocowy. \n" +
                                "\n" +
                                "Występuje od października do grudnia w lasach iglastych, przeważnie pod sosnami, często pojawia się także po pierwszych nocnych przymrozkach, często gromadnie. \n" +
                                "\n" +
                                "Zastosowanie - jadalna. \n".toString();
                        qwe = R.drawable.oliwkowobiala;
                        qwe2 = R.drawable.poznawodbig;
                        list1 = "Wodnicha oliwkowobiała Hygrophorus olivaceoalbus,".toString();
                        list2 = "ma oliwkowy odcień kapelusza, a trzon jest zygzakowato paseczkowany,";
                        list13 = "jest cytrynowożółta, mniej śluzowata i rośnie tylko pod modrzewiami.";
                        list3 = "Wodnicha modrzewiowa Hygrophorus lucorum,";
                        qwe3 = R.drawable.modrzewiowa;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 196:
                        TempListViewClickedValue = "Zasłonak ceglastożółty Cortinarius varius".toString();
                        TempListViewClickedValue2 = "Kapelusz barwy żółtopomarańczowej beżowobrązowy środkiem czerwonobrazowy, średnicy 5-10cm początkowo półkolisty dzwonkowaty potem łukowaty do rozpostartego bez garbka, gładki. W okresie wilgotnym błyszczący i śliski, porą suchą jedwabnie błyszczacy. Brzeg długo podwinięty, gładki i ostry.\n" +
                                "\n" +
                                "Blaszki młode jasnoróżowwofioletowe potem niebieskofioletowe, z wiekiem cynamonowobrązowe od zarodników, ostrza gładkie. Wąskie przyrośnięte do trzonu.\n" +
                                "\n" +
                                "Trzon biały z niebieskawym nalotem, potem miejscami z resztkami zasnówki bladokremowy. Rzadko walcowaty, pełny.\n" +
                                "\n" +
                                "Miąższ białawy, grubomięsisty, o słabym smaku bez zapachu.\n" +
                                "\n" +
                                "Zastosowanie- jadalny.\n" +
                                "\n" +
                                "Występuje często na podgórskich i górskich lasach świerkowych i sosnowych na glebach wapiennych.\n".toString();
                        qwe = R.drawable.brunatnoplamista;
                        qwe2 = R.drawable.ceglastozoltybig;
                        list1 = "Zasłonak brunatnoplamisty Cortinarius fulvoochrascens,".toString();
                        list2 = "z fioletowymi blaszkami bez niebieskawego odcienia.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 197:
                        TempListViewClickedValue = "Zasłonak kleisty Cortinarius mucosus".toString();
                        TempListViewClickedValue2 = "Owocnik żółtobrązowy do złocisto- lub pomarańczowobrązowego nawet kasztanowobrązowy, w centrum ciemniejszy. 3-8cm średnicy, wypukły, potem spłaszczony do wklęsłego, z garbkiem. \n" +
                                "\n" +
                                "Powierzchnia silnie śluzowata, lepka, wyschnięta błyszcząca i gładka.\n" +
                                "\n" +
                                "Blaszki młode ochrowe, cynamonowordzawe, ostrze żółtawe, ząbkowane, wąskie, przyrośnięte do zbiegających. \n" +
                                "\n" +
                                "Trzon pokryty białym śluzem, u dołu nieco zwężony, cylindryczny, resztki zasnówki białawe, fioletowawe, potem rdzawe. \n" +
                                "\n" +
                                "Miąższ żółtawy, jasnoochrowy, niezmienny. Smak łagodny, bez zapachu. \n" +
                                "\n" +
                                "Pospolity w grupach lub gromadnie nawet masowo. Od sierpnia do października w lasach sosnowych, na glebach kwaśnych i piaszczystych. \n" +
                                "\n" +
                                "Zastosowanie- jadalny. \n".toString();
                        qwe = R.drawable.sluzofatyzas;
                        qwe2 = R.drawable.kleistyzasbig;
                        list1 = "Zasłonak śluzowaty Cortinarius collinitus,".toString();
                        list2 = "ma tylko nieco inny kolor kapelusza (od żółtopomarańczowego do brązowopomarańczowego) i trzon fioletowo-brązowy, często zwężony dołem. Rośnie tylko pod świerkami;";
                        list13 = "ma ochrowożółtobrązowy kapelusz i wałeczki śluzu na trzonie.";
                        list3 = "Zasłonak pospolity Cortinarius trivialis,";
                        qwe3 = R.drawable.pospolityzas;
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                    case 198:
                        TempListViewClickedValue = "Zasłonak krwisty Cortinarius sanguineus".toString();
                        TempListViewClickedValue2 = "Owocnik początkowo półkolisty, później płaski lub rozpostarty, młody ciemnokrwistoczerwony, stary czarnoczerwony; powierzchnia sucha, drobno łuseczkowata; średnica 2- 4 cm.\n" +
                                "\n" +
                                "Blaszki ciemnokrwiste, gdy dojrzewają zarodniki przyjmują odcień rdzawobrązowy, dość szerokie, gęste, przy trzonie zaokrąglone. \n" +
                                "\n" +
                                "Trzon krwistoczerwony z jaśniejszą czerwonawą zasnuwką na pomarańczowym tle; cylindryczny, przeważnie długi (do 10 cm) i wysmukły. \n" +
                                "\n" +
                                "Miąższ zabarwiony krwiście, na ogół o słabym zapachu ziemi i łagodnym smaku. \n" +
                                "\n" +
                                "Występuje pojedynczo lub w małych grupach, w wilgotnych lasach iglastych, na torfowiskach, olszynach, stosunkowo częsty. Rośnie w lasach świerkowych na torfowiskach i w wilgotnych miejscach. \n" +
                                "\n" +
                                "Zastosowanie - niejadalny. \n".toString();
                        qwe = R.drawable.krwistoczerwonyzas;
                        qwe2 = R.drawable.krwistyzasbig;
                        list1 = "Zasłonak krwistoczerwony Cortinarius anthracinus,".toString();
                        list2 = "różni się ciemnopurpurowobrązowym kapeluszem z karminowożółtym brzegiem;";
                        list13 = "podobny jest do starszych, wypłowiałych okazów zasłonaka krwistego, ale nie ma krwistoczerwonych łusek;";
                        list3 = "Zasłonak cynamonowy Cortinarius cinnamomeus,";
                        qwe3 = R.drawable.cynamonowyzas;
                        list14 = "ma podobnego koloru blaszki, ale kapelusz i trzon są oliwkowobrązowe.";
                        list4 = "Zasłonak purpurowoblaszkowy Cortinarius semisanguineus,";
                        qwe4 = R.drawable.purpurowoblasz;
                        jedzenie = R.drawable.niejadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.niejadalny);
                        break;
                    case 199:
                        TempListViewClickedValue = "Zasłonak purpurowoblaszkowy Cortinarius semisanguineus".toString();
                        TempListViewClickedValue2 = "Owocnik 2-5cm średnicy oliwkowobrązowy, umbrowbrązowy lub żółtobrązowy, młody dzwonkowaty, potem rozpostarty, z garbkiem.\n" +
                                "\n" +
                                "Skórka kapelusza sucha i naga, błyszcząca, za młodu z drobnymi łuseczkami. \n" +
                                "\n" +
                                "Blaszki krwistoczerwone, z wiekiem cynobromowoczerwone mniej lub bardziej zatokowato wycięte i przyrośnięte, stosunkowo cienkie i szerokie. \n" +
                                "\n" +
                                "Trzon chromowożółty, podłużnie włókienkowaty, niekiedy czerwonawy u podstawy. Równogruby, często powyginany, łamliwy. \n" +
                                "\n" +
                                "Miąższ żółtawy, o słabym zapachu i smaku rzodkwi. \n" +
                                "\n" +
                                "Bardzo częsty, gromadnie od sierpnia do listopada, głównie w lasach iglastych pod świerkami i sosnami na kwaśnych glebach, na torfowiskach. \n" +
                                "\n" +
                                "Zastosowanie- niejadalny. \n".toString();
                        qwe = R.drawable.cynamonowyzas;
                        qwe2 = R.drawable.purpurowoblaszbig;
                        list1 = "Zasłonak cynamonowy Cortinarius cinnamomeus,".toString();
                        list2 = "odróżnia się cynamonowożółtymi łuseczkami na kapeluszu;";
                        list13 = "ma czerwonobrązowy kapelusz, a trzon niemal cały jest czerwony i włóknisty;";
                        list3 = "Zasłonak miedzianordzawy Cortinarius purpureus,";
                        qwe3 = R.drawable.miedzianordzawyzas;
                        list14 = "ma rzadko ustawione blaszki i biały wysyp zarodników.";
                        list4 = "Lakówka pospolita Laccaria laccata,";
                        qwe4 = R.drawable.pospolitalek;
                        jedzenie = R.drawable.niejadalny;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.niejadalny);
                        break;
                    case 200:
                        TempListViewClickedValue = "Zasłonak rudawy Cortinarius rubellus".toString();
                        TempListViewClickedValue2 = "Owocnik średnica do 6 cm, młody stożkowaty, później rozłożysty, z wyraźnym spiczastym garbkiem soczyście pomarańczowym lub lisiobrązowym, delikatnie łuskowaty. \n" +
                                "\n" +
                                "Blaszki bardzo szerokie, grube, luźno upakowane wokół trzonu, zatokowate, rdzawobrązowe o odcieniu cynamonu. \n" +
                                "\n" +
                                "Trzon charakterystycznie długi, nieco maczugowaty, soczyście pomarańczowy, pokryty żółtawymi, włóknowatymi kosmykami, w młodości między krawędzią kapelusza i trzonem pajęczynowa zasnuwka. \n" +
                                "\n" +
                                "Miąższ w całej objętości pomarańczowobrązowy, o zapachu rzodkwi. \n" +
                                "\n" +
                                "Występuje najczęściej w wilgotnych lasach iglastych  zwłaszcza pod świerkami, na kwaśnych glebach, nawet wśród torfowców; dotychczas znany tylko z okolic alpejskich.\n" +
                                "\n" +
                                "Zastosowanie - śmiertelnie trujący. \n".toString();
                        qwe2 = R.drawable.rudawybig;
                        jedzenie = R.drawable.trujacy;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.trujacy);
                        break;
                    case 201:
                        TempListViewClickedValue = "Zasłonak wonny Cortinarius traganus".toString();
                        TempListViewClickedValue2 = "Owocnik młody liliowofioletowy z wiekiem wyblakły bladoochrowy 15 cm średnicy, młody kulisty, potem wypukły do rozpostartego; powierzchnia sucha, lśniąca, za młodu z brzegu zwieszają się resztki osłony. \n" +
                                "\n" +
                                "Blaszki młode ochrowe, dojrzałe ciemne, rdzawobrązowe, dość gęste, szerokie, o jaśniejszych, nierównych ostrzach. \n" +
                                "\n" +
                                "Trzon młody fioletowy potem bladolila, blaknący, z ochrowym zabarwieniem poczynając od podstawy, zasnówka szybko ochrowa, tworząca rdzawą strefę pierścieniową, powierzchnia sucha, lśniąca, z resztkami osłony, 50-100 na 10-30 mm, nasada silnie bulwiasta, masywny, maczugowaty, pełny. \n" +
                                "\n" +
                                "Miąższ bladożółtawy, szafranowożółtawy, rdzawobrązowy, nie fioletowy, niezmienny, z nieprzyjemnym zapachem przypominającym karbid, smak gorzkawy. \n" +
                                "\n" +
                                "Występuje często od sierpnia do września w grupach w lasach iglastych, pod sosnami, rzadziej w lasach liściastych. \n" +
                                "\n" +
                                "Zastosowanie- trujący. \n".toString();
                        qwe = R.drawable.odrazajacyzas;
                        qwe2 = R.drawable.wonnyzasbig;
                        list1 = "Zasłonak odrażający Cortinarius camphoratus,".toString();
                        list2 = "odróżnia się fioletowym miąższem, ma on nieprzyjemny słodkawy zapach;";
                        list13 = "jest cały zabarwiony ciemnofioletowo.";
                        list3 = "Zasłonak fioletowy Cortinarius violaceus,";
                        qwe3 = R.drawable.fioletowyzas;
                        jedzenie = R.drawable.trujacy;
                        lasy = R.drawable.iglasty;
                        typgrzyb = R.drawable.t10;
                        jadalnosc.setImageResource(R.drawable.trujacy);
                        break;
                    case 202:
                        TempListViewClickedValue = "Żagiew łuskowata Polyporus squamosus".toString();
                        TempListViewClickedValue2 = "Kapelusz kremowy, ochrowy, 5-60cm szerokości, do 5cm grubości, spłaszczony, mniej lub bardziej wachlarzowaty. \n" +
                                "\n" +
                                "Górna powierzchnia owocników nieco lepka, kremowa, ochrowa, płowa lub żółtawa pokryta koncentrycznymi rzędami trójkątnych łusek barwy brązowej, kasztanowatej lub czarnej.\n" +
                                "\n" +
                                "Pory stosunkowo duże, nieregularne, kanciaste, białawe, wysychając stają się kremowe.\n" +
                                "\n" +
                                "Rurki długości od 5 do 10 mm zbiegają na trzon, barwy białawej, młode do brudnocielistych z wiekiem żółtawokremowe.\n" +
                                "\n" +
                                "Trzon boczny, rzadziej ekscentryczny, wyjątkowo centralny, krótki, u szczytu pokryty zbiegającymi siateczkowatymi porami, białawy lub brudnocielisty, u dołu z warstwą czarnobrązowego lub czarnego kutneru. Hymenofor porowaty.\n" +
                                "\n" +
                                "Miąższ soczysto-mięsisty, białawy lub słomkowożółty, wysychając ciemnieje i staje się korkowaty, lekki i łamliwy. Zapach silny, przyjemny, mączysty. Smak łagodny.\n" +
                                "\n" +
                                "Pospolity, na żywych i martwych drzewach liściastych, w lasach, parkach, ogrodach i zaroślach oraz na przydrożnych drzewach.\n" +
                                "\n" +
                                "Zastosowanie- jadalne tylko młode owocniki.\n".toString();
                        qwe = R.drawable.bulwiastazag;
                        qwe2 = R.drawable.luskowatazagbig;
                        list1 = "Żagiew bulwiasta Polyporus tuberaster,".toString();
                        list2 = "owocnik dużo mniejszy (do 15 cm średnicy). Kapelusz lejkowaty, trzon centralny.";
                        jedzenie = R.drawable.jadalny;
                        lasy = R.drawable.lisc;
                        typgrzyb = R.drawable.def1;
                        jadalnosc.setImageResource(R.drawable.jadalny);
                        break;
                }

                int liczba = position+1;

                Intent myintent = new Intent(view.getContext(),M1Activity.class);
                myintent.putExtra("ListViewClickedValue", TempListViewClickedValue);
                myintent.putExtra("ListViewClickedValue3", TempListViewClickedValue3);
                myintent.putExtra("ListViewClickedValue2", TempListViewClickedValue2);
                myintent.putExtra("ListViewClickedValue4", TempListViewClickedValue4);
                myintent.putExtra("list1", list1);
                myintent.putExtra("list2", list2);
                myintent.putExtra("qwe", qwe);
                myintent.putExtra("qwe2", qwe2);

                myintent.putExtra("list13", list13);
                myintent.putExtra("list3", list3);
                myintent.putExtra("qwe3", qwe3);

                myintent.putExtra("list14", list14);
                myintent.putExtra("list4", list4);
                myintent.putExtra("qwe4", qwe4);

                myintent.putExtra("list15", list15);
                myintent.putExtra("list5", list5);
                myintent.putExtra("qwe5", qwe5);
                myintent.putExtra("liczba",liczba);

                myintent.putExtra("jedzenie", jedzenie);
                myintent.putExtra("lasy", lasy);
                myintent.putExtra("typgrzyb",typgrzyb);
                startActivity(myintent);

            }
        });

    }



    private void getDataInList() {
        for (int i = 0; i < title.length; i++) {
            // Create a new object for each list item
            ListData ld = new ListData();
            ld.setTitle(title[i]);
            ld.setDescription(desc[i]);
            ld.setImgResId(img[i]);
            // Add this object into the ArrayList myList
            myList.add(ld);
        }
    }

}
