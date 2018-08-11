package pl.cba.radeckiuczony.mushroomer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.preference.DialogPreference;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.AdRequest;

public class M1Activity extends AppCompatActivity {

    ImageView imgbig1;
    TextView textview;
    TextView textview3;
    TextView textview2;
    TextView textview4;

    ImageView jedz;
    ImageView las;
    ImageView typg;

    int numerek;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m1);
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3255746204227301/8640500404");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP)
        {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }

        imgbig1 = (ImageView)findViewById(R.id.imgbig);
        textview = (TextView)findViewById(R.id.textView1);
        textview2 = (TextView)findViewById(R.id.textView2);
        textview3 = (TextView)findViewById(R.id.textView3);
        textview4 = (TextView)findViewById(R.id.textView4);
        ImageView qimageView2 = (ImageView) findViewById(R.id.img1);
        TextView qtextView2 = (TextView) findViewById(R.id.title11);
        TextView qtextView22 = (TextView) findViewById(R.id.title12);

        ImageView qimageView3 = (ImageView) findViewById(R.id.img2);
        TextView qtextView3 = (TextView) findViewById(R.id.title21);
        TextView qtextView23 = (TextView) findViewById(R.id.titlee22);

        ImageView qimageView4 = (ImageView) findViewById(R.id.img3);
        TextView qtextView4 = (TextView) findViewById(R.id.title13);
        TextView qtextView24 = (TextView) findViewById(R.id.title23);

        ImageView qimageView5 = (ImageView) findViewById(R.id.img4);
        TextView qtextView5 = (TextView) findViewById(R.id.title14);
        TextView qtextView25 = (TextView) findViewById(R.id.title24);

        //TextView numer = (TextView) findViewById(R.id.numer);

         jedz = (ImageView) findViewById(R.id.jedzenie);
         las = (ImageView) findViewById(R.id.lasy);
         typg = (ImageView) findViewById(R.id.typgrzyb);

        final String TempHolder = getIntent().getStringExtra("ListViewClickedValue");
        final String TempHolder2 = getIntent().getStringExtra("ListViewClickedValue2");
        String TempHolder3 = getIntent().getStringExtra("ListViewClickedValue3");
        String TempHolder4 = getIntent().getStringExtra("ListViewClickedValue4");

        String abc = getIntent().getStringExtra("list1");
        String abc2 = getIntent().getStringExtra("list2");
        int abw = getIntent().getIntExtra("qwe", 0);

        int abw2 = getIntent().getIntExtra("qwe2", 0);

        String abc13 = getIntent().getStringExtra("list13");
        String abc3 = getIntent().getStringExtra("list3");
        int abw3 = getIntent().getIntExtra("qwe3", 0);

        String abc14 = getIntent().getStringExtra("list14");
        String abc4 = getIntent().getStringExtra("list4");
        int abw4 = getIntent().getIntExtra("qwe4", 0);

        String abc15 = getIntent().getStringExtra("list15");
        String abc5 = getIntent().getStringExtra("list5");
        int abw5 = getIntent().getIntExtra("qwe5", 0);

        numerek = getIntent().getIntExtra("liczba", 0);

        int jedzenie = getIntent().getIntExtra("jedzenie", 0);
        int lasy = getIntent().getIntExtra("lasy", 0);
        int typgrzyb = getIntent().getIntExtra("typgrzyb", 0);

        jedz.setImageResource(jedzenie);
        las.setImageResource(lasy);
        typg.setImageResource(typgrzyb);

        imgbig1.setImageResource(abw2);

        textview.setText(TempHolder);
        if(TempHolder3!="") {
            textview3.setText(TempHolder3);

        }
        if(TempHolder3 == "")
        {
            textview3.setVisibility(View.GONE);
        }
        textview2.setText(TempHolder2);
        textview4.setText(TempHolder4);

        int foty =  abw;
        String pierwszy = abc;
        String drugi = abc2;

        int foty2 =  abw3;
        String pierwszy2 = abc3;
        String drugi2 = abc13;

        int foty3 =  abw4;
        String pierwszy3 = abc4;
        String drugi3 = abc14;

        int foty4 =  abw5;
        String pierwszy4 = abc5;
        String drugi4 = abc15;

        qimageView2.setImageResource(foty);
        qtextView2.setText(pierwszy);
        qtextView22.setText(drugi);

        qimageView3.setImageResource(foty2);
        qtextView3.setText(pierwszy2);
        qtextView23.setText(drugi2);

        qimageView4.setImageResource(foty3);
        qtextView4.setText(pierwszy3);
        qtextView24.setText(drugi3);

        qimageView5.setImageResource(foty4);
        qtextView5.setText(pierwszy4);
        qtextView25.setText(drugi4);

        TextView numer = (TextView) findViewById(R.id.numer);
        String nrgrzyba = String.valueOf(numerek);
        String wlasciwe = "Grzyb numer: "+nrgrzyba;
        numer.setText(wlasciwe);

        if (pierwszy4.contains("error"))
        {
            qimageView5.setVisibility(View.GONE);
            qtextView5.setVisibility(View.GONE);
            qtextView25.setVisibility(View.GONE);
        }

        if (pierwszy3.contains("error"))
        {
            qimageView4.setVisibility(View.GONE);
            qtextView4.setVisibility(View.GONE);
            qtextView24.setVisibility(View.GONE);

            qimageView5.setVisibility(View.GONE);
            qtextView5.setVisibility(View.GONE);
            qtextView25.setVisibility(View.GONE);
        }
        if (pierwszy2.contains("error"))
        {
            qimageView4.setVisibility(View.GONE);
            qtextView4.setVisibility(View.GONE);
            qtextView24.setVisibility(View.GONE);

            qimageView5.setVisibility(View.GONE);
            qtextView5.setVisibility(View.GONE);
            qtextView25.setVisibility(View.GONE);

            qimageView3.setVisibility(View.GONE);
            qtextView3.setVisibility(View.GONE);
            qtextView23.setVisibility(View.GONE);
        }
        if (pierwszy.contains("error"))
        {
            qimageView2.setVisibility(View.GONE);
            qtextView2.setVisibility(View.GONE);
            qtextView22.setVisibility(View.GONE);

            qimageView4.setVisibility(View.GONE);
            qtextView4.setVisibility(View.GONE);
            qtextView24.setVisibility(View.GONE);

            qimageView5.setVisibility(View.GONE);
            qtextView5.setVisibility(View.GONE);
            qtextView25.setVisibility(View.GONE);

            qimageView3.setVisibility(View.GONE);
            qtextView3.setVisibility(View.GONE);
            qtextView23.setVisibility(View.GONE);
            textview4.setVisibility(View.GONE);
        }

        if ((numerek==8)||(numerek==19)||(numerek==21)||(numerek==28)||(numerek==47)||(numerek==50)||(numerek==56)||(numerek==61)||(numerek==62)||(numerek==63)||(numerek==65)||(numerek==70)||(numerek==71)||(numerek==81)||(numerek==82)||(numerek==83)||(numerek==84)||(numerek==85)||(numerek==87)||(numerek==97)||(numerek==98)||(numerek==102)||(numerek==110)||(numerek==113)||(numerek==117)||(numerek==122)||(numerek==138)||(numerek==144)||(numerek==150)||(numerek==153)||(numerek==167)||(numerek==170)||(numerek==175)||(numerek==182)||(numerek==185)||(numerek==201)){
            textview4.setVisibility(View.GONE);
            qimageView2.setVisibility(View.GONE);
            qtextView2.setVisibility(View.GONE);
            qtextView22.setVisibility(View.GONE);
        }
    }
    public void Podobny (View view) {
        ImageView qimageView2 = (ImageView) findViewById(R.id.img1);
        TextView qtextView2 = (TextView) findViewById(R.id.title11);
        TextView qtextView22 = (TextView) findViewById(R.id.title12);

        ImageView qimageView3 = (ImageView) findViewById(R.id.img2);
        TextView qtextView3 = (TextView) findViewById(R.id.title21);
        TextView qtextView23 = (TextView) findViewById(R.id.titlee22);

        ImageView qimageView4 = (ImageView) findViewById(R.id.img3);
        TextView qtextView4 = (TextView) findViewById(R.id.title13);
        TextView qtextView24 = (TextView) findViewById(R.id.title23);

        ImageView qimageView5 = (ImageView) findViewById(R.id.img4);
        TextView qtextView5 = (TextView) findViewById(R.id.title14);
        TextView qtextView25 = (TextView) findViewById(R.id.title24);


        final String TempHolder = getIntent().getStringExtra("ListViewClickedValue");
        final String TempHolder2 = getIntent().getStringExtra("ListViewClickedValue2");
        String TempHolder3 = getIntent().getStringExtra("ListViewClickedValue3");
        String TempHolder4 = getIntent().getStringExtra("ListViewClickedValue4");

        String abc = getIntent().getStringExtra("list1");
        String abc2 = getIntent().getStringExtra("list2");
        int abw = getIntent().getIntExtra("qwe", 0);

        int abw2 = getIntent().getIntExtra("qwe2", 0);

        String abc13 = getIntent().getStringExtra("list13");
        String abc3 = getIntent().getStringExtra("list3");
        int abw3 = getIntent().getIntExtra("qwe3", 0);

        String abc14 = getIntent().getStringExtra("list14");
        String abc4 = getIntent().getStringExtra("list4");
        int abw4 = getIntent().getIntExtra("qwe4", 0);

        String abc15 = getIntent().getStringExtra("list15");
        String abc5 = getIntent().getStringExtra("list5");
        int abw5 = getIntent().getIntExtra("qwe5", 0);

        int foty = abw;
        String pierwszy = abc;
        String drugi = abc2;

        int foty2 = abw3;
        String pierwszy2 = abc3;
        String drugi2 = abc13;

        int foty3 = abw4;
        String pierwszy3 = abc4;
        String drugi3 = abc14;

        int foty4 = abw5;
        String pierwszy4 = abc5;
        String drugi4 = abc15;

        qimageView2.setImageResource(foty);
        qtextView2.setText(pierwszy);
        qtextView22.setText(drugi);

        qimageView3.setImageResource(foty2);
        qtextView3.setText(pierwszy2);
        qtextView23.setText(drugi2);

        qimageView4.setImageResource(foty3);
        qtextView4.setText(pierwszy3);
        qtextView24.setText(drugi3);

        qimageView5.setImageResource(foty4);
        qtextView5.setText(pierwszy4);
        qtextView25.setText(drugi4);

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "Reklama się nie załadowała");
        }

        if (abc.contains("Boczniak białożółty Pleurotus dryinus,") || abc.contains("Boczniak rowkowanotrzonowy Pleurotus cornucopiae,") || abc.contains("Boczniak łyżkowaty Pleurotus pulmonarius,")
                || abc.contains("Maślak czerwony Sulillus lakei,") || abc.contains("Borowik żółtopory Caloboletus calopus,") || abc.contains("Borowik gładkotrzonowy Suillellus queletii,") || abc.contains("Borowik szatański Rubroboletus satanas,")
                || abc.contains("Borowik korzeniasty Boletus radicans,") || abc.contains("Piaskowiec kasztanowaty Gyroporus castaneus,") || abc.contains("Borowik rudopurpurowy Boletus rhodopurpureus, ") || abc.contains("Borowik wilczy Boletus lupinus,")
                || abc.contains("Borowik ciemnobrązowy Boletus cereus,") || abc.contains("Podgrzybek złotopory Xerocomellus chrysenteron,") || abc.contains("Podgrzybek żeberkowany Boletus ferrugineus,") || abc.contains("Borowik oprószony Xerocomellus pruinatus,")
                || abc.contains("Podgrzybek obciętozarodnikowy Xerocomus porosporus,") || abc.contains("Podgrzybek czerwonawy Xerocomus rubellus,") || abc.contains("Borowik górski Boletus subappendiculatus,") || abc.contains("Buławka pałeczkowata Clavariadelphus pistillaris,")
                || abc.contains("Czernidłak podwórzowy Coprinellus disseminatus,") || abc.contains("Czernidłaczek kanciastozarodnikowy Coprinellus angulatus, ") || abc.contains("Kruchaweczka zaroślowa Psathyrella candolleana, ") || abc.contains("Czernidłak szarawy Coprinopsis cinerea,")
                || abc.contains("Czubajeczka brązowofioletowa Lepiota brumneolilacea, ") || abc.contains("Czubajeczka tarczowata Lepiota clypeolaria,") || abc.contains("Czubajka żółknąca Leucoagaricus nympharum,") || abc.contains("Czubajka gwiaździsta Macrolepiota konradii, ")
                || abc.contains("Czubajka czerwieniejąca Chlorophyllum rhacodes,") || abc.contains("Siodłówka giętka Helvella elastica,") || abc.contains("Kielonka  błyszcząca Caloscypha fulgens,") || abc.contains("Czarka austriacka Sarcoscypha austriaca,") || abc.contains("Dzieżka trzoneczkowata  Aleuria rhenana,")
                || abc.contains("Poduszeczka pomarańczowa Pulvinula constellatia,") || abc.contains("Gąsówka szarawa Lepista nebularis, ") || abc.contains("Pierwoząb krótkokolczasty Protodontia subgelatinosa,") || abc.contains("Koralówka łososioworóżowa Ramaria subbotrytis,") || abc.contains("Gąska jasna Tricholoma stiparophyllum,")
                || abc.contains("Gąska gołębia Tricholoma columbetta,") || abc.contains("Gąska nieprzyjemna Tricholoma inamoenum,") || abc.contains("Gąska czerwieniejąca Tricholoma orirubens,") || abc.contains("Gąska niekształtna Tricholoma portentosum,") || abc.contains("Gąska ziemistobalszkowa Tricholoma terreum,")
                || abc.contains("Gąska czarnołuskowa Tricholoma atrosquamosa,") || abc.contains("Gąska cętkowana Tricholoma fucatum,") || abc.contains("Gąska zielonożółta Tricholoma sejunctum,") || abc.contains("Gąska czerwonobrązowa Tricholoma batschii,") || abc.contains("Gąska bukowa Tricholoma ustale,") || abc.contains("Gąska dachówkowata Tricholoma imbricatum,")
                || abc.contains("Gąska modrzewiowa Tricholoma psammopus,") || abc.contains("Gąsówka brudnofioletowa Lepista sordida,") || abc.contains("Lejkówka szarawa Clitocybe nebularis,") || abc.contains("Gąsówka rudawa Lepista flaccida,") || abc.contains("Gołąbek oliwkowozielony Russula heterophylla,")
                || abc.contains("Gołąbek brunatny Russula badia,") || abc.contains("Gołąbek śmierdzący Russula foetens,") || abc.contains("Gołąbek liliowy Russula lilacea,") || abc.contains("Gołąbek turecki Russula turci,") || abc.contains("Gołąbek ametystowy Russula amethystina,") || abc.contains("Gołąbek brudnożółty Russula ochroleuca,")
                || abc.contains("Gołąbek plamisty Russula maculata,") || abc.contains("Mleczaj biel Lactarius piperatus,") || abc.contains("Gołąbek buczynowy Russula mairei,") || abc.contains("Gołąbek fiołkowozielony Russula ionochlora,") || abc.contains("Goździeniec purpurowy Alloclavaria purpurea,") || abc.contains("Koralówka blada Ramaria pallida,")
                || abc.contains("Goździeniec robakowaty Clavaria vermicularis,") || abc.contains("Grzybka fioletowawa Mycena pura,") || abc.contains("Podblaszek zrosły Lyophyllum connatum,") || abc.contains("Kępkowiec twardoskórkowy Lyophyllum loricatum,") || abc.contains("Klejek alpejski Chroogomphus Helvetius,") || abc.contains("Klejówka plamista Gomphidius maculatus,")
                || abc.contains("Klejek czerwonawy Chroogomphus rutilus,") || abc.contains("Kolczak rudawy Hydnum rufescens,") || abc.contains("Kołpaczek szorstkozarodnikowy Panaeolous foenisecii,") || abc.contains("Kołpaczek siatkowany Panaeolous retirugis,") || abc.contains("Kołpaczek motylkowaty Panaeolus papilionaceus,") || abc.contains("Kopułek śnieżny Cuphophyllus virgineus,")
                || abc.contains("Wodnicha gajowa Hygrophorus nemoreus,") || abc.contains("Koźlarz różnobarwny Leccinum variicolor, ") || abc.contains("Koźlarz białawy Leccinum holopus,") || abc.contains("Koźlarz pomarańczowożółty Leccinum versipelle,") || abc.contains("Koźlarz sosnowy Leccinum vulpinum,") || abc.contains("Koźlarz świerkowy Leccinum piceinum,")
                || abc.contains("Kożlarz czerwony Leccinum aurantiacum,") || abc.contains("Krowiak olszowy Paxillus filamentosus,") || abc.contains("Kruchawica aksamitna Lacrymaria lacrymabunda,") || abc.contains("Grzybówka fioletowawa Mycena pura,") || abc.contains("Strzępiak ziemistoblaszkowy Inocybe geophylla,") || abc.contains("Lakówka okazała Laccaria proxima,")
                || abc.contains("Lejkówka jadowita Clitocybe rivulosa,") || abc.contains("Lejkówka karbowana Clitocybe costata,") || abc.contains("Pierścieniak grynszpanowy Stropharia aeruginosa,") || abc.contains("Mitróweczka błotna Mitrula paludosa,") || abc.contains("Drobnołuszczak czarnoostrzowy Pluteus atromarginatus,") || abc.contains("Drobnołuszczak zielonawoszary Pluteus salicinus,")
                || abc.contains("Łuskwiak nastroszony Pholiota squarosa,") || abc.contains("Łysostopek niemiły Gymnopus hariolorum,") || abc.contains("Łysostopek wodnisty Gymnopus aquosus,") || abc.contains("Lysostopek kępkowy Gymnopus acervatus,") || abc.contains("Łysostopek twardzioszkowaty Gymnopus erythropus,") || abc.contains("Maślak zwyczajny Suillus luteus,") || abc.contains("Maślak żółtawy Suills nueschii,")
                || abc.contains("Maślanka korzeniasta Hypholoma radicosum,") || abc.contains("Maślanka ceglasta Hypholoma lateritium,") || abc.contains("Mleczaj ostry Lactarius acris,") || abc.contains("Mleczaj rudobrązowy Lactarius hysginus,") || abc.contains("Mleczaj moszczobarwny Lactarius musteus,") || abc.contains("Mleczaj piekący Lactifluus bertillonii,") || abc.contains("Mleczaj żółtofioletowy Lactarius repraesentaneus, ")
                || abc.contains("Mleczaj modrzewiowy Lactarius porninsis,") || abc.contains("Mleczaj czerwieniejący Lactarius sanguifluus,") || abc.contains("Mleczaj wątrobowy Lactariue hepaticus,") || abc.contains("Mleczaj kamforowy Lactarius camphoratus,") || abc.contains("Mleczaj francuski Lactarius mairei,") || abc.contains("Kępkowiec brązowooliwkowy Lyophyllum inolens,") || abc.contains("Muchomor zielonawy Amanita phalloides,")
                || abc.contains("Muchomor twardawy Amanita spissa,") || abc.contains("Muchomor królewski Amanita regalis,") || abc.contains("Muchomor wiosenny Amanita verna,") || abc.contains("Muchomor mglejarka Amanita vaginata,") || abc.contains("Muchomor żółtawy Amanita crocea,") || abc.contains("Muchomor srebrzysty Amanita mairei,") || abc.contains("Naziemek żółtopomarańczowy Albatrellus subrubescens,")
                || abc.contains("Naziemek zielonawy Albatrellus cristatus,") || abc.contains("Borowik żonkilowy Neoboletus junquilleus,") || abc.contains("Pieczarka krwawiąca Agaricus langei,") || abc.contains("Pieczarka karbolowa Agaricus xanthodermus,") || abc.contains("Pieczarka liliowoczerwonawa Agaricus porphyrizon,") || abc.contains("Pieprznik ametystowy Cantharellus amethysteus,") || abc.contains("Pieprznik pomarańczowy Cantharellus friesii,")
                || abc.contains("Lisówka pomarańczowa Hygrophoropsis aurantiaca,") || abc.contains("Lejkowniczek pełnotrzonowy Pseudocraterellus undulatus,") || abc.contains("Trufla biała Tuber magnatum,") || abc.contains("Piestrak brązowy Choiromyces magnusii,") || abc.contains("Piestrzenica olbrzymia Gyromitra gigas,") || abc.contains("Krążkownica wrębiasta Discina perlata,") || abc.contains("Purchawka łatkowata Lycoperdon mamiforme,") || abc.contains("Purchawka fiolowata Lycoperdon excipuliforme,")
                || abc.contains("Sarniak piekący Sarcodon fuligineo-violaceus,") || abc.contains("Sarniak fiołkowy Sarcodon joeides,") || abc.contains("Szmaciak jodłowy Sparassis nemecii,") || abc.contains("Soplówka jodłowa Hericium coralloides, ") || abc.contains("Soplówka jeżowata Hericium erinaceum,") || abc.contains("Sromotnik fiołkowy Phallus Hadrianie,") || abc.contains("Mądziak psi Mutinus caninus,")
                || abc.contains("Strzępiak czerwieniejący Inocybe godeyi,") || abc.contains("Strzępiak porysowany Inocybe fastigiata,") || abc.contains("Tęgoskór brodawkowy Scleroderma verrucosum,") || abc.contains("Trufla wgłębiona Tuber mesentericum,") || abc.contains("Uchówka zajęcza Otidea leporina,") || abc.contains("Uchówka ślimakowata Otidea cochleata,") || abc.contains("Uszak skórnikowaty Auricularia mesenterica,") || abc.contains("Wilgotnica okazała Hygrocybe splendidissima,")
                || abc.contains("Wilgotnica szkarłatna Hygrocybe coccinea,") || abc.contains("Wilgotnica wypukła Hygrocybe quieta,") || abc.contains("Włośnianka wrzecionowatozarodnikowa Hebeloma laterinum,") || abc.contains("Włośnianka rosista Hebeloma crustuliniforme,") || abc.contains("Wodnicha świerkowa Hygrophorus piceae,") || abc.contains("Wodnicha oliwkowobiała Hygrophorus olivaceoalbus,") || abc.contains("Wodnicha zaróżowiona Hygrophorus erubescens,")
                || abc.contains("Wodnicha kozia Hygrophorus capreolarius,") || abc.contains("Wodnicha ozdobna Hygrophorus speciosus,") || abc.contains("Zasłonak brunatnoplamisty Cortinarius fulvoochrascens,") || abc.contains("Zasłonak śluzowaty Cortinarius collinitus,") || abc.contains("Zasłonak pospolity Cortinarius trivialis,") || abc.contains("Zasłonak krwistoczerwony Cortinarius anthracinus,") || abc.contains("Zasłonak cynamonowy Cortinarius cinnamomeus,")
                || abc.contains("Zasłonak miedzianordzawy Cortinarius purpureus,") || abc.contains("Zasłonak odrażający Cortinarius camphoratus,") || abc.contains("Zasłonak fioletowy Cortinarius violaceus,") || abc.contains("Żagiew bulwiasta Polyporus tuberaster,")) {


            AlertDialog.Builder builder = new AlertDialog.Builder(M1Activity.this);
            builder.setTitle("Brak gatunku!");
            builder.setMessage("Ten grzyb nie ma jeszcze opisu");
            builder.setPositiveButton("OK", null);
            builder.show();
        }
        else if (abc3.contains("Boczniak białożółty Pleurotus dryinus,") || abc3.contains("Boczniak rowkowanotrzonowy Pleurotus cornucopiae,") || abc3.contains("Boczniak łyżkowaty Pleurotus pulmonarius,")
                || abc3.contains("Maślak czerwony Sulillus lakei,") || abc3.contains("Borowik żółtopory Caloboletus calopus,") || abc3.contains("Borowik gładkotrzonowy Suillellus queletii,") || abc3.contains("Borowik szatański Rubroboletus satanas,")
                || abc3.contains("Borowik korzeniasty Boletus radicans,") || abc3.contains("Piaskowiec kasztanowaty Gyroporus castaneus,") || abc3.contains("Borowik rudopurpurowy Boletus rhodopurpureus, ") || abc3.contains("Borowik wilczy Boletus lupinus,")
                || abc3.contains("Borowik ciemnobrązowy Boletus cereus,") || abc3.contains("Podgrzybek złotopory Xerocomellus chrysenteron,") || abc3.contains("Podgrzybek żeberkowany Boletus ferrugineus,") || abc3.contains("Borowik oprószony Xerocomellus pruinatus,")
                || abc3.contains("Podgrzybek obciętozarodnikowy Xerocomus porosporus,") || abc3.contains("Podgrzybek czerwonawy Xerocomus rubellus,") || abc3.contains("Borowik górski Boletus subappendiculatus,") || abc3.contains("Buławka pałeczkowata Clavariadelphus pistillaris,")
                || abc3.contains("Czernidłak podwórzowy Coprinellus disseminatus,") || abc3.contains("Czernidłaczek kanciastozarodnikowy Coprinellus angulatus, ") || abc3.contains("Kruchaweczka zaroślowa Psathyrella candolleana, ") || abc3.contains("Czernidłak szarawy Coprinopsis cinerea,")
                || abc3.contains("Czubajeczka brązowofioletowa Lepiota brumneolilacea, ") || abc3.contains("Czubajeczka tarczowata Lepiota clypeolaria,") || abc3.contains("Czubajka żółknąca Leucoagaricus nympharum,") || abc3.contains("Czubajka gwiaździsta Macrolepiota konradii, ")
                || abc3.contains("Czubajka czerwieniejąca Chlorophyllum rhacodes,") || abc3.contains("Siodłówka giętka Helvella elastica,") || abc3.contains("Kielonka  błyszcząca Caloscypha fulgens,") || abc3.contains("Czarka austriacka Sarcoscypha austriaca,") || abc3.contains("Dzieżka trzoneczkowata  Aleuria rhenana,")
                || abc3.contains("Poduszeczka pomarańczowa Pulvinula constellatia,") || abc3.contains("Gąsówka szarawa Lepista nebularis, ") || abc3.contains("Pierwoząb krótkokolczasty Protodontia subgelatinosa,") || abc3.contains("Koralówka łososioworóżowa Ramaria subbotrytis,") || abc3.contains("Gąska jasna Tricholoma stiparophyllum,")
                || abc3.contains("Gąska gołębia Tricholoma columbetta,") || abc3.contains("Gąska nieprzyjemna Tricholoma inamoenum,") || abc3.contains("Gąska czerwieniejąca Tricholoma orirubens,") || abc3.contains("Gąska niekształtna Tricholoma portentosum,") || abc3.contains("Gąska ziemistobalszkowa Tricholoma terreum,")
                || abc3.contains("Gąska czarnołuskowa Tricholoma atrosquamosa,") || abc3.contains("Gąska cętkowana Tricholoma fucatum,") || abc3.contains("Gąska zielonożółta Tricholoma sejunctum,") || abc3.contains("Gąska czerwonobrązowa Tricholoma batschii,") || abc3.contains("Gąska bukowa Tricholoma ustale,") || abc3.contains("Gąska dachówkowata Tricholoma imbricatum,")
                || abc3.contains("Gąska modrzewiowa Tricholoma psammopus,") || abc3.contains("Gąsówka brudnofioletowa Lepista sordida,") || abc3.contains("Lejkówka szarawa Clitocybe nebularis,") || abc3.contains("Gąsówka rudawa Lepista flaccida,") || abc3.contains("Gołąbek oliwkowozielony Russula heterophylla,")
                || abc3.contains("Gołąbek brunatny Russula badia,") || abc3.contains("Gołąbek śmierdzący Russula foetens,") || abc3.contains("Gołąbek liliowy Russula lilacea,") || abc3.contains("Gołąbek turecki Russula turci,") || abc3.contains("Gołąbek ametystowy Russula amethystina,") || abc3.contains("Gołąbek brudnożółty Russula ochroleuca,")
                || abc3.contains("Gołąbek plamisty Russula maculata,") || abc3.contains("Mleczaj biel Lactarius piperatus,") || abc3.contains("Gołąbek buczynowy Russula mairei,") || abc3.contains("Gołąbek fiołkowozielony Russula ionochlora,") || abc3.contains("Goździeniec purpurowy Alloclavaria purpurea,") || abc3.contains("Koralówka blada Ramaria pallida,")
                || abc3.contains("Goździeniec robakowaty Clavaria vermicularis,") || abc3.contains("Grzybka fioletowawa Mycena pura,") || abc3.contains("Podblaszek zrosły Lyophyllum connatum,") || abc3.contains("Kępkowiec twardoskórkowy Lyophyllum loricatum,") || abc3.contains("Klejek alpejski Chroogomphus Helvetius,") || abc3.contains("Klejówka plamista Gomphidius maculatus,")
                || abc3.contains("Klejek czerwonawy Chroogomphus rutilus,") || abc3.contains("Kolczak rudawy Hydnum rufescens,") || abc3.contains("Kołpaczek szorstkozarodnikowy Panaeolous foenisecii,") || abc3.contains("Kołpaczek siatkowany Panaeolous retirugis,") || abc3.contains("Kołpaczek motylkowaty Panaeolus papilionaceus,") || abc3.contains("Kopułek śnieżny Cuphophyllus virgineus,")
                || abc3.contains("Wodnicha gajowa Hygrophorus nemoreus,") || abc3.contains("Koźlarz różnobarwny Leccinum variicolor, ") || abc3.contains("Koźlarz białawy Leccinum holopus,") || abc3.contains("Koźlarz pomarańczowożółty Leccinum versipelle,") || abc3.contains("Koźlarz sosnowy Leccinum vulpinum,") || abc3.contains("Koźlarz świerkowy Leccinum piceinum,")
                || abc3.contains("Kożlarz czerwony Leccinum aurantiacum,") || abc3.contains("Krowiak olszowy Paxillus filamentosus,") || abc3.contains("Kruchawica aksamitna Lacrymaria lacrymabunda,") || abc3.contains("Grzybówka fioletowawa Mycena pura,") || abc3.contains("Strzępiak ziemistoblaszkowy Inocybe geophylla,") || abc3.contains("Lakówka okazała Laccaria proxima,")
                || abc3.contains("Lejkówka jadowita Clitocybe rivulosa,") || abc3.contains("Lejkówka karbowana Clitocybe costata,") || abc3.contains("Pierścieniak grynszpanowy Stropharia aeruginosa,") || abc3.contains("Mitróweczka błotna Mitrula paludosa,") || abc3.contains("Drobnołuszczak czarnoostrzowy Pluteus atromarginatus,") || abc3.contains("Drobnołuszczak zielonawoszary Pluteus salicinus,")
                || abc3.contains("Łuskwiak nastroszony Pholiota squarosa,") || abc3.contains("Łysostopek niemiły Gymnopus hariolorum,") || abc3.contains("Łysostopek wodnisty Gymnopus aquosus,") || abc3.contains("Lysostopek kępkowy Gymnopus acervatus,") || abc3.contains("Łysostopek twardzioszkowaty Gymnopus erythropus,") || abc3.contains("Maślak zwyczajny Suillus luteus,") || abc3.contains("Maślak żółtawy Suills nueschii,")
                || abc3.contains("Maślanka korzeniasta Hypholoma radicosum,") || abc3.contains("Maślanka ceglasta Hypholoma lateritium,") || abc3.contains("Mleczaj ostry Lactarius acris,") || abc3.contains("Mleczaj rudobrązowy Lactarius hysginus,") || abc3.contains("Mleczaj moszczobarwny Lactarius musteus,") || abc3.contains("Mleczaj piekący Lactifluus bertillonii,") || abc3.contains("Mleczaj żółtofioletowy Lactarius repraesentaneus, ")
                || abc3.contains("Mleczaj modrzewiowy Lactarius porninsis,") || abc3.contains("Mleczaj czerwieniejący Lactarius sanguifluus,") || abc3.contains("Mleczaj wątrobowy Lactariue hepaticus,") || abc3.contains("Mleczaj kamforowy Lactarius camphoratus,") || abc3.contains("Mleczaj francuski Lactarius mairei,") || abc3.contains("Kępkowiec brązowooliwkowy Lyophyllum inolens,") || abc3.contains("Muchomor zielonawy Amanita phalloides,")
                || abc3.contains("Muchomor twardawy Amanita spissa,") || abc3.contains("Muchomor królewski Amanita regalis,") || abc3.contains("Muchomor wiosenny Amanita verna,") || abc3.contains("Muchomor mglejarka Amanita vaginata,") || abc3.contains("Muchomor żółtawy Amanita crocea,") || abc3.contains("Muchomor srebrzysty Amanita mairei,") || abc3.contains("Naziemek żółtopomarańczowy Albatrellus subrubescens,")
                || abc3.contains("Naziemek zielonawy Albatrellus cristatus,") || abc3.contains("Borowik żonkilowy Neoboletus junquilleus,") || abc3.contains("Pieczarka krwawiąca Agaricus langei,") || abc3.contains("Pieczarka karbolowa Agaricus xanthodermus,") || abc3.contains("Pieczarka liliowoczerwonawa Agaricus porphyrizon,") || abc3.contains("Pieprznik ametystowy Cantharellus amethysteus,") || abc3.contains("Pieprznik pomarańczowy Cantharellus friesii,")
                || abc3.contains("Lisówka pomarańczowa Hygrophoropsis aurantiaca,") || abc3.contains("Lejkowniczek pełnotrzonowy Pseudocraterellus undulatus,") || abc3.contains("Trufla biała Tuber magnatum,") || abc3.contains("Piestrak brązowy Choiromyces magnusii,") || abc3.contains("Piestrzenica olbrzymia Gyromitra gigas,") || abc3.contains("Krążkownica wrębiasta Discina perlata,") || abc3.contains("Purchawka łatkowata Lycoperdon mamiforme,") || abc3.contains("Purchawka fiolowata Lycoperdon excipuliforme,")
                || abc3.contains("Sarniak piekący Sarcodon fuligineo-violaceus,") || abc3.contains("Sarniak fiołkowy Sarcodon joeides,") || abc3.contains("Szmaciak jodłowy Sparassis nemecii,") || abc3.contains("Soplówka jodłowa Hericium coralloides, ") || abc3.contains("Soplówka jeżowata Hericium erinaceum,") || abc3.contains("Sromotnik fiołkowy Phallus Hadrianie,") || abc3.contains("Mądziak psi Mutinus caninus,")
                || abc3.contains("Strzępiak czerwieniejący Inocybe godeyi,") || abc3.contains("Strzępiak porysowany Inocybe fastigiata,") || abc3.contains("Tęgoskór brodawkowy Scleroderma verrucosum,") || abc3.contains("Trufla wgłębiona Tuber mesentericum,") || abc3.contains("Uchówka zajęcza Otidea leporina,") || abc3.contains("Uchówka ślimakowata Otidea cochleata,") || abc3.contains("Uszak skórnikowaty Auricularia mesenterica,") || abc3.contains("Wilgotnica okazała Hygrocybe splendidissima,")
                || abc3.contains("Wilgotnica szkarłatna Hygrocybe coccinea,") || abc3.contains("Wilgotnica wypukła Hygrocybe quieta,") || abc3.contains("Włośnianka wrzecionowatozarodnikowa Hebeloma laterinum,") || abc3.contains("Włośnianka rosista Hebeloma crustuliniforme,") || abc3.contains("Wodnicha świerkowa Hygrophorus piceae,") || abc3.contains("Wodnicha oliwkowobiała Hygrophorus olivaceoalbus,") || abc3.contains("Wodnicha zaróżowiona Hygrophorus erubescens,")
                || abc3.contains("Wodnicha kozia Hygrophorus capreolarius,") || abc3.contains("Wodnicha ozdobna Hygrophorus speciosus,") || abc3.contains("Zasłonak brunatnoplamisty Cortinarius fulvoochrascens,") || abc3.contains("Zasłonak śluzowaty Cortinarius collinitus,") || abc3.contains("Zasłonak pospolity Cortinarius trivialis,") || abc3.contains("Zasłonak krwistoczerwony Cortinarius anthracinus,") || abc3.contains("Zasłonak cynamonowy Cortinarius cinnamomeus,")
                || abc3.contains("Zasłonak miedzianordzawy Cortinarius purpureus,") || abc3.contains("Zasłonak odrażający Cortinarius camphoratus,") || abc3.contains("Zasłonak fioletowy Cortinarius violaceus,") || abc3.contains("Żagiew bulwiasta Polyporus tuberaster,")) {
            AlertDialog.Builder builder = new AlertDialog.Builder(M1Activity.this);
            builder.setTitle("Brak gatunku!");
            builder.setMessage("Ten grzyb nie ma jeszcze opisu");
            builder.setPositiveButton("OK", null);
            builder.show();
        }
       else if (abc4.contains("Boczniak białożółty Pleurotus dryinus,") || abc4.contains("Boczniak rowkowanotrzonowy Pleurotus cornucopiae,") || abc4.contains("Boczniak łyżkowaty Pleurotus pulmonarius,")
                || abc4.contains("Maślak czerwony Sulillus lakei,") || abc4.contains("Borowik żółtopory Caloboletus calopus,") || abc4.contains("Borowik gładkotrzonowy Suillellus queletii,") || abc4.contains("Borowik szatański Rubroboletus satanas,")
                || abc4.contains("Borowik korzeniasty Boletus radicans,") || abc4.contains("Piaskowiec kasztanowaty Gyroporus castaneus,") || abc4.contains("Borowik rudopurpurowy Boletus rhodopurpureus, ") || abc4.contains("Borowik wilczy Boletus lupinus,")
                || abc4.contains("Borowik ciemnobrązowy Boletus cereus,") || abc4.contains("Podgrzybek złotopory Xerocomellus chrysenteron,") || abc4.contains("Podgrzybek żeberkowany Boletus ferrugineus,") || abc4.contains("Borowik oprószony Xerocomellus pruinatus,")
                || abc4.contains("Podgrzybek obciętozarodnikowy Xerocomus porosporus,") || abc4.contains("Podgrzybek czerwonawy Xerocomus rubellus,") || abc4.contains("Borowik górski Boletus subappendiculatus,") || abc4.contains("Buławka pałeczkowata Clavariadelphus pistillaris,")
                || abc4.contains("Czernidłak podwórzowy Coprinellus disseminatus,") || abc4.contains("Czernidłaczek kanciastozarodnikowy Coprinellus angulatus, ") || abc4.contains("Kruchaweczka zaroślowa Psathyrella candolleana, ") || abc4.contains("Czernidłak szarawy Coprinopsis cinerea,")
                || abc4.contains("Czubajeczka brązowofioletowa Lepiota brumneolilacea, ") || abc4.contains("Czubajeczka tarczowata Lepiota clypeolaria,") || abc4.contains("Czubajka żółknąca Leucoagaricus nympharum,") || abc4.contains("Czubajka gwiaździsta Macrolepiota konradii, ")
                || abc4.contains("Czubajka czerwieniejąca Chlorophyllum rhacodes,") || abc4.contains("Siodłówka giętka Helvella elastica,") || abc4.contains("Kielonka  błyszcząca Caloscypha fulgens,") || abc4.contains("Czarka austriacka Sarcoscypha austriaca,") || abc4.contains("Dzieżka trzoneczkowata  Aleuria rhenana,")
                || abc4.contains("Poduszeczka pomarańczowa Pulvinula constellatia,") || abc4.contains("Gąsówka szarawa Lepista nebularis, ") || abc4.contains("Pierwoząb krótkokolczasty Protodontia subgelatinosa,") || abc4.contains("Koralówka łososioworóżowa Ramaria subbotrytis,") || abc4.contains("Gąska jasna Tricholoma stiparophyllum,")
                || abc4.contains("Gąska gołębia Tricholoma columbetta,") || abc4.contains("Gąska nieprzyjemna Tricholoma inamoenum,") || abc4.contains("Gąska czerwieniejąca Tricholoma orirubens,") || abc4.contains("Gąska niekształtna Tricholoma portentosum,") || abc4.contains("Gąska ziemistobalszkowa Tricholoma terreum,")
                || abc4.contains("Gąska czarnołuskowa Tricholoma atrosquamosa,") || abc4.contains("Gąska cętkowana Tricholoma fucatum,") || abc4.contains("Gąska zielonożółta Tricholoma sejunctum,") || abc4.contains("Gąska czerwonobrązowa Tricholoma batschii,") || abc4.contains("Gąska bukowa Tricholoma ustale,") || abc4.contains("Gąska dachówkowata Tricholoma imbricatum,")
                || abc4.contains("Gąska modrzewiowa Tricholoma psammopus,") || abc4.contains("Gąsówka brudnofioletowa Lepista sordida,") || abc4.contains("Lejkówka szarawa Clitocybe nebularis,") || abc4.contains("Gąsówka rudawa Lepista flaccida,") || abc4.contains("Gołąbek oliwkowozielony Russula heterophylla,")
                || abc4.contains("Gołąbek brunatny Russula badia,") || abc4.contains("Gołąbek śmierdzący Russula foetens,") || abc4.contains("Gołąbek liliowy Russula lilacea,") || abc4.contains("Gołąbek turecki Russula turci,") || abc4.contains("Gołąbek ametystowy Russula amethystina,") || abc4.contains("Gołąbek brudnożółty Russula ochroleuca,")
                || abc4.contains("Gołąbek plamisty Russula maculata,") || abc4.contains("Mleczaj biel Lactarius piperatus,") || abc4.contains("Gołąbek buczynowy Russula mairei,") || abc4.contains("Gołąbek fiołkowozielony Russula ionochlora,") || abc4.contains("Goździeniec purpurowy Alloclavaria purpurea,") || abc4.contains("Koralówka blada Ramaria pallida,")
                || abc4.contains("Goździeniec robakowaty Clavaria vermicularis,") || abc4.contains("Grzybka fioletowawa Mycena pura,") || abc4.contains("Podblaszek zrosły Lyophyllum connatum,") || abc4.contains("Kępkowiec twardoskórkowy Lyophyllum loricatum,") || abc4.contains("Klejek alpejski Chroogomphus Helvetius,") || abc4.contains("Klejówka plamista Gomphidius maculatus,")
                || abc4.contains("Klejek czerwonawy Chroogomphus rutilus,") || abc4.contains("Kolczak rudawy Hydnum rufescens,") || abc4.contains("Kołpaczek szorstkozarodnikowy Panaeolous foenisecii,") || abc4.contains("Kołpaczek siatkowany Panaeolous retirugis,") || abc4.contains("Kołpaczek motylkowaty Panaeolus papilionaceus,") || abc4.contains("Kopułek śnieżny Cuphophyllus virgineus,")
                || abc4.contains("Wodnicha gajowa Hygrophorus nemoreus,") || abc4.contains("Koźlarz różnobarwny Leccinum variicolor, ") || abc4.contains("Koźlarz białawy Leccinum holopus,") || abc4.contains("Koźlarz pomarańczowożółty Leccinum versipelle,") || abc4.contains("Koźlarz sosnowy Leccinum vulpinum,") || abc4.contains("Koźlarz świerkowy Leccinum piceinum,")
                || abc4.contains("Kożlarz czerwony Leccinum aurantiacum,") || abc4.contains("Krowiak olszowy Paxillus filamentosus,") || abc4.contains("Kruchawica aksamitna Lacrymaria lacrymabunda,") || abc4.contains("Grzybówka fioletowawa Mycena pura,") || abc4.contains("Strzępiak ziemistoblaszkowy Inocybe geophylla,") || abc4.contains("Lakówka okazała Laccaria proxima,")
                || abc4.contains("Lejkówka jadowita Clitocybe rivulosa,") || abc4.contains("Lejkówka karbowana Clitocybe costata,") || abc4.contains("Pierścieniak grynszpanowy Stropharia aeruginosa,") || abc4.contains("Mitróweczka błotna Mitrula paludosa,") || abc4.contains("Drobnołuszczak czarnoostrzowy Pluteus atromarginatus,") || abc4.contains("Drobnołuszczak zielonawoszary Pluteus salicinus,")
                || abc4.contains("Łuskwiak nastroszony Pholiota squarosa,") || abc4.contains("Łysostopek niemiły Gymnopus hariolorum,") || abc4.contains("Łysostopek wodnisty Gymnopus aquosus,") || abc4.contains("Lysostopek kępkowy Gymnopus acervatus,") || abc4.contains("Łysostopek twardzioszkowaty Gymnopus erythropus,") || abc4.contains("Maślak zwyczajny Suillus luteus,") || abc4.contains("Maślak żółtawy Suills nueschii,")
                || abc4.contains("Maślanka korzeniasta Hypholoma radicosum,") || abc4.contains("Maślanka ceglasta Hypholoma lateritium,") || abc4.contains("Mleczaj ostry Lactarius acris,") || abc4.contains("Mleczaj rudobrązowy Lactarius hysginus,") || abc4.contains("Mleczaj moszczobarwny Lactarius musteus,") || abc4.contains("Mleczaj piekący Lactifluus bertillonii,") || abc4.contains("Mleczaj żółtofioletowy Lactarius repraesentaneus, ")
                || abc4.contains("Mleczaj modrzewiowy Lactarius porninsis,") || abc4.contains("Mleczaj czerwieniejący Lactarius sanguifluus,") || abc4.contains("Mleczaj wątrobowy Lactariue hepaticus,") || abc4.contains("Mleczaj kamforowy Lactarius camphoratus,") || abc4.contains("Mleczaj francuski Lactarius mairei,") || abc4.contains("Kępkowiec brązowooliwkowy Lyophyllum inolens,") || abc4.contains("Muchomor zielonawy Amanita phalloides,")
                || abc4.contains("Muchomor twardawy Amanita spissa,") || abc4.contains("Muchomor królewski Amanita regalis,") || abc4.contains("Muchomor wiosenny Amanita verna,") || abc4.contains("Muchomor mglejarka Amanita vaginata,") || abc4.contains("Muchomor żółtawy Amanita crocea,") || abc4.contains("Muchomor srebrzysty Amanita mairei,") || abc4.contains("Naziemek żółtopomarańczowy Albatrellus subrubescens,")
                || abc4.contains("Naziemek zielonawy Albatrellus cristatus,") || abc4.contains("Borowik żonkilowy Neoboletus junquilleus,") || abc4.contains("Pieczarka krwawiąca Agaricus langei,") || abc4.contains("Pieczarka karbolowa Agaricus xanthodermus,") || abc4.contains("Pieczarka liliowoczerwonawa Agaricus porphyrizon,") || abc4.contains("Pieprznik ametystowy Cantharellus amethysteus,") || abc4.contains("Pieprznik pomarańczowy Cantharellus friesii,")
                || abc4.contains("Lisówka pomarańczowa Hygrophoropsis aurantiaca,") || abc4.contains("Lejkowniczek pełnotrzonowy Pseudocraterellus undulatus,") || abc4.contains("Trufla biała Tuber magnatum,") || abc4.contains("Piestrak brązowy Choiromyces magnusii,") || abc4.contains("Piestrzenica olbrzymia Gyromitra gigas,") || abc4.contains("Krążkownica wrębiasta Discina perlata,") || abc4.contains("Purchawka łatkowata Lycoperdon mamiforme,") || abc4.contains("Purchawka fiolowata Lycoperdon excipuliforme,")
                || abc4.contains("Sarniak piekący Sarcodon fuligineo-violaceus,") || abc4.contains("Sarniak fiołkowy Sarcodon joeides,") || abc4.contains("Szmaciak jodłowy Sparassis nemecii,") || abc4.contains("Soplówka jodłowa Hericium coralloides, ") || abc4.contains("Soplówka jeżowata Hericium erinaceum,") || abc4.contains("Sromotnik fiołkowy Phallus Hadrianie,") || abc4.contains("Mądziak psi Mutinus caninus,")
                || abc4.contains("Strzępiak czerwieniejący Inocybe godeyi,") || abc4.contains("Strzępiak porysowany Inocybe fastigiata,") || abc4.contains("Tęgoskór brodawkowy Scleroderma verrucosum,") || abc4.contains("Trufla wgłębiona Tuber mesentericum,") || abc4.contains("Uchówka zajęcza Otidea leporina,") || abc4.contains("Uchówka ślimakowata Otidea cochleata,") || abc4.contains("Uszak skórnikowaty Auricularia mesenterica,") || abc4.contains("Wilgotnica okazała Hygrocybe splendidissima,")
                || abc4.contains("Wilgotnica szkarłatna Hygrocybe coccinea,") || abc4.contains("Wilgotnica wypukła Hygrocybe quieta,") || abc4.contains("Włośnianka wrzecionowatozarodnikowa Hebeloma laterinum,") || abc4.contains("Włośnianka rosista Hebeloma crustuliniforme,") || abc4.contains("Wodnicha świerkowa Hygrophorus piceae,") || abc4.contains("Wodnicha oliwkowobiała Hygrophorus olivaceoalbus,") || abc4.contains("Wodnicha zaróżowiona Hygrophorus erubescens,")
                || abc4.contains("Wodnicha kozia Hygrophorus capreolarius,") || abc4.contains("Wodnicha ozdobna Hygrophorus speciosus,") || abc4.contains("Zasłonak brunatnoplamisty Cortinarius fulvoochrascens,") || abc4.contains("Zasłonak śluzowaty Cortinarius collinitus,") || abc4.contains("Zasłonak pospolity Cortinarius trivialis,") || abc4.contains("Zasłonak krwistoczerwony Cortinarius anthracinus,") || abc4.contains("Zasłonak cynamonowy Cortinarius cinnamomeus,")
                || abc4.contains("Zasłonak miedzianordzawy Cortinarius purpureus,") || abc4.contains("Zasłonak odrażający Cortinarius camphoratus,") || abc4.contains("Zasłonak fioletowy Cortinarius violaceus,") || abc4.contains("Żagiew bulwiasta Polyporus tuberaster,")) {
            AlertDialog.Builder builder = new AlertDialog.Builder(M1Activity.this);
            builder.setTitle("Brak gatunku!");
            builder.setMessage("Ten grzyb nie ma jeszcze opisu");
            builder.setPositiveButton("OK", null);
            builder.show();
        }
        else if (abc5.contains("Boczniak białożółty Pleurotus dryinus,") || abc5.contains("Boczniak rowkowanotrzonowy Pleurotus cornucopiae,") || abc5.contains("Boczniak łyżkowaty Pleurotus pulmonarius,")
                || abc5.contains("Maślak czerwony Sulillus lakei,") || abc5.contains("Borowik żółtopory Caloboletus calopus,") || abc5.contains("Borowik gładkotrzonowy Suillellus queletii,") || abc5.contains("Borowik szatański Rubroboletus satanas,")
                || abc5.contains("Borowik korzeniasty Boletus radicans,") || abc5.contains("Piaskowiec kasztanowaty Gyroporus castaneus,") || abc5.contains("Borowik rudopurpurowy Boletus rhodopurpureus, ") || abc5.contains("Borowik wilczy Boletus lupinus,")
                || abc5.contains("Borowik ciemnobrązowy Boletus cereus,") || abc5.contains("Podgrzybek złotopory Xerocomellus chrysenteron,") || abc5.contains("Podgrzybek żeberkowany Boletus ferrugineus,") || abc5.contains("Borowik oprószony Xerocomellus pruinatus,")
                || abc5.contains("Podgrzybek obciętozarodnikowy Xerocomus porosporus,") || abc5.contains("Podgrzybek czerwonawy Xerocomus rubellus,") || abc5.contains("Borowik górski Boletus subappendiculatus,") || abc5.contains("Buławka pałeczkowata Clavariadelphus pistillaris,")
                || abc5.contains("Czernidłak podwórzowy Coprinellus disseminatus,") || abc5.contains("Czernidłaczek kanciastozarodnikowy Coprinellus angulatus, ") || abc5.contains("Kruchaweczka zaroślowa Psathyrella candolleana, ") || abc5.contains("Czernidłak szarawy Coprinopsis cinerea,")
                || abc5.contains("Czubajeczka brązowofioletowa Lepiota brumneolilacea, ") || abc5.contains("Czubajeczka tarczowata Lepiota clypeolaria,") || abc5.contains("Czubajka żółknąca Leucoagaricus nympharum,") || abc5.contains("Czubajka gwiaździsta Macrolepiota konradii, ")
                || abc5.contains("Czubajka czerwieniejąca Chlorophyllum rhacodes,") || abc5.contains("Siodłówka giętka Helvella elastica,") || abc5.contains("Kielonka  błyszcząca Caloscypha fulgens,") || abc5.contains("Czarka austriacka Sarcoscypha austriaca,") || abc5.contains("Dzieżka trzoneczkowata  Aleuria rhenana,")
                || abc5.contains("Poduszeczka pomarańczowa Pulvinula constellatia,") || abc5.contains("Gąsówka szarawa Lepista nebularis, ") || abc5.contains("Pierwoząb krótkokolczasty Protodontia subgelatinosa,") || abc5.contains("Koralówka łososioworóżowa Ramaria subbotrytis,") || abc5.contains("Gąska jasna Tricholoma stiparophyllum,")
                || abc5.contains("Gąska gołębia Tricholoma columbetta,") || abc5.contains("Gąska nieprzyjemna Tricholoma inamoenum,") || abc5.contains("Gąska czerwieniejąca Tricholoma orirubens,") || abc5.contains("Gąska niekształtna Tricholoma portentosum,") || abc5.contains("Gąska ziemistobalszkowa Tricholoma terreum,")
                || abc5.contains("Gąska czarnołuskowa Tricholoma atrosquamosa,") || abc5.contains("Gąska cętkowana Tricholoma fucatum,") || abc5.contains("Gąska zielonożółta Tricholoma sejunctum,") || abc5.contains("Gąska czerwonobrązowa Tricholoma batschii,") || abc5.contains("Gąska bukowa Tricholoma ustale,") || abc5.contains("Gąska dachówkowata Tricholoma imbricatum,")
                || abc5.contains("Gąska modrzewiowa Tricholoma psammopus,") || abc5.contains("Gąsówka brudnofioletowa Lepista sordida,") || abc5.contains("Lejkówka szarawa Clitocybe nebularis,") || abc5.contains("Gąsówka rudawa Lepista flaccida,") || abc5.contains("Gołąbek oliwkowozielony Russula heterophylla,")
                || abc5.contains("Gołąbek brunatny Russula badia,") || abc5.contains("Gołąbek śmierdzący Russula foetens,") || abc5.contains("Gołąbek liliowy Russula lilacea,") || abc5.contains("Gołąbek turecki Russula turci,") || abc5.contains("Gołąbek ametystowy Russula amethystina,") || abc5.contains("Gołąbek brudnożółty Russula ochroleuca,")
                || abc5.contains("Gołąbek plamisty Russula maculata,") || abc5.contains("Mleczaj biel Lactarius piperatus,") || abc5.contains("Gołąbek buczynowy Russula mairei,") || abc5.contains("Gołąbek fiołkowozielony Russula ionochlora,") || abc5.contains("Goździeniec purpurowy Alloclavaria purpurea,") || abc5.contains("Koralówka blada Ramaria pallida,")
                || abc5.contains("Goździeniec robakowaty Clavaria vermicularis,") || abc5.contains("Grzybka fioletowawa Mycena pura,") || abc5.contains("Podblaszek zrosły Lyophyllum connatum,") || abc5.contains("Kępkowiec twardoskórkowy Lyophyllum loricatum,") || abc5.contains("Klejek alpejski Chroogomphus Helvetius,") || abc5.contains("Klejówka plamista Gomphidius maculatus,")
                || abc5.contains("Klejek czerwonawy Chroogomphus rutilus,") || abc5.contains("Kolczak rudawy Hydnum rufescens,") || abc5.contains("Kołpaczek szorstkozarodnikowy Panaeolous foenisecii,") || abc5.contains("Kołpaczek siatkowany Panaeolous retirugis,") || abc5.contains("Kołpaczek motylkowaty Panaeolus papilionaceus,") || abc5.contains("Kopułek śnieżny Cuphophyllus virgineus,")
                || abc5.contains("Wodnicha gajowa Hygrophorus nemoreus,") || abc5.contains("Koźlarz różnobarwny Leccinum variicolor, ") || abc5.contains("Koźlarz białawy Leccinum holopus,") || abc5.contains("Koźlarz pomarańczowożółty Leccinum versipelle,") || abc5.contains("Koźlarz sosnowy Leccinum vulpinum,") || abc5.contains("Koźlarz świerkowy Leccinum piceinum,")
                || abc5.contains("Kożlarz czerwony Leccinum aurantiacum,") || abc5.contains("Krowiak olszowy Paxillus filamentosus,") || abc5.contains("Kruchawica aksamitna Lacrymaria lacrymabunda,") || abc5.contains("Grzybówka fioletowawa Mycena pura,") || abc5.contains("Strzępiak ziemistoblaszkowy Inocybe geophylla,") || abc5.contains("Lakówka okazała Laccaria proxima,")
                || abc5.contains("Lejkówka jadowita Clitocybe rivulosa,") || abc5.contains("Lejkówka karbowana Clitocybe costata,") || abc5.contains("Pierścieniak grynszpanowy Stropharia aeruginosa,") || abc5.contains("Mitróweczka błotna Mitrula paludosa,") || abc5.contains("Drobnołuszczak czarnoostrzowy Pluteus atromarginatus,") || abc5.contains("Drobnołuszczak zielonawoszary Pluteus salicinus,")
                || abc5.contains("Łuskwiak nastroszony Pholiota squarosa,") || abc5.contains("Łysostopek niemiły Gymnopus hariolorum,") || abc5.contains("Łysostopek wodnisty Gymnopus aquosus,") || abc5.contains("Lysostopek kępkowy Gymnopus acervatus,") || abc5.contains("Łysostopek twardzioszkowaty Gymnopus erythropus,") || abc5.contains("Maślak zwyczajny Suillus luteus,") || abc5.contains("Maślak żółtawy Suills nueschii,")
                || abc5.contains("Maślanka korzeniasta Hypholoma radicosum,") || abc5.contains("Maślanka ceglasta Hypholoma lateritium,") || abc5.contains("Mleczaj ostry Lactarius acris,") || abc5.contains("Mleczaj rudobrązowy Lactarius hysginus,") || abc5.contains("Mleczaj moszczobarwny Lactarius musteus,") || abc5.contains("Mleczaj piekący Lactifluus bertillonii,") || abc5.contains("Mleczaj żółtofioletowy Lactarius repraesentaneus, ")
                || abc5.contains("Mleczaj modrzewiowy Lactarius porninsis,") || abc5.contains("Mleczaj czerwieniejący Lactarius sanguifluus,") || abc5.contains("Mleczaj wątrobowy Lactariue hepaticus,") || abc5.contains("Mleczaj kamforowy Lactarius camphoratus,") || abc5.contains("Mleczaj francuski Lactarius mairei,") || abc5.contains("Kępkowiec brązowooliwkowy Lyophyllum inolens,") || abc5.contains("Muchomor zielonawy Amanita phalloides,")
                || abc5.contains("Muchomor twardawy Amanita spissa,") || abc5.contains("Muchomor królewski Amanita regalis,") || abc5.contains("Muchomor wiosenny Amanita verna,") || abc5.contains("Muchomor mglejarka Amanita vaginata,") || abc5.contains("Muchomor żółtawy Amanita crocea,") || abc5.contains("Muchomor srebrzysty Amanita mairei,") || abc5.contains("Naziemek żółtopomarańczowy Albatrellus subrubescens,")
                || abc5.contains("Naziemek zielonawy Albatrellus cristatus,") || abc5.contains("Borowik żonkilowy Neoboletus junquilleus,") || abc5.contains("Pieczarka krwawiąca Agaricus langei,") || abc5.contains("Pieczarka karbolowa Agaricus xanthodermus,") || abc5.contains("Pieczarka liliowoczerwonawa Agaricus porphyrizon,") || abc5.contains("Pieprznik ametystowy Cantharellus amethysteus,") || abc5.contains("Pieprznik pomarańczowy Cantharellus friesii,")
                || abc5.contains("Lisówka pomarańczowa Hygrophoropsis aurantiaca,") || abc5.contains("Lejkowniczek pełnotrzonowy Pseudocraterellus undulatus,") || abc5.contains("Trufla biała Tuber magnatum,") || abc5.contains("Piestrak brązowy Choiromyces magnusii,") || abc5.contains("Piestrzenica olbrzymia Gyromitra gigas,") || abc5.contains("Krążkownica wrębiasta Discina perlata,") || abc5.contains("Purchawka łatkowata Lycoperdon mamiforme,") || abc5.contains("Purchawka fiolowata Lycoperdon excipuliforme,")
                || abc5.contains("Sarniak piekący Sarcodon fuligineo-violaceus,") || abc5.contains("Sarniak fiołkowy Sarcodon joeides,") || abc5.contains("Szmaciak jodłowy Sparassis nemecii,") || abc5.contains("Soplówka jodłowa Hericium coralloides, ") || abc5.contains("Soplówka jeżowata Hericium erinaceum,") || abc5.contains("Sromotnik fiołkowy Phallus Hadrianie,") || abc5.contains("Mądziak psi Mutinus caninus,")
                || abc5.contains("Strzępiak czerwieniejący Inocybe godeyi,") || abc5.contains("Strzępiak porysowany Inocybe fastigiata,") || abc5.contains("Tęgoskór brodawkowy Scleroderma verrucosum,") || abc5.contains("Trufla wgłębiona Tuber mesentericum,") || abc5.contains("Uchówka zajęcza Otidea leporina,") || abc5.contains("Uchówka ślimakowata Otidea cochleata,") || abc5.contains("Uszak skórnikowaty Auricularia mesenterica,") || abc5.contains("Wilgotnica okazała Hygrocybe splendidissima,")
                || abc5.contains("Wilgotnica szkarłatna Hygrocybe coccinea,") || abc5.contains("Wilgotnica wypukła Hygrocybe quieta,") || abc5.contains("Włośnianka wrzecionowatozarodnikowa Hebeloma laterinum,") || abc5.contains("Włośnianka rosista Hebeloma crustuliniforme,") || abc5.contains("Wodnicha świerkowa Hygrophorus piceae,") || abc5.contains("Wodnicha oliwkowobiała Hygrophorus olivaceoalbus,") || abc5.contains("Wodnicha zaróżowiona Hygrophorus erubescens,")
                || abc5.contains("Wodnicha kozia Hygrophorus capreolarius,") || abc5.contains("Wodnicha ozdobna Hygrophorus speciosus,") || abc5.contains("Zasłonak brunatnoplamisty Cortinarius fulvoochrascens,") || abc5.contains("Zasłonak śluzowaty Cortinarius collinitus,") || abc5.contains("Zasłonak pospolity Cortinarius trivialis,") || abc5.contains("Zasłonak krwistoczerwony Cortinarius anthracinus,") || abc5.contains("Zasłonak cynamonowy Cortinarius cinnamomeus,")
                || abc5.contains("Zasłonak miedzianordzawy Cortinarius purpureus,") || abc5.contains("Zasłonak odrażający Cortinarius camphoratus,") || abc5.contains("Zasłonak fioletowy Cortinarius violaceus,") || abc5.contains("Żagiew bulwiasta Polyporus tuberaster,")) {
            new AlertDialog.Builder(this)
                    .setTitle("Brak gatunku!")
                    .setMessage("Ten grzyb nie ma jeszcze opisu")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
        } else {
            String TempListViewClickedValue = "costam".toString();
            String TempListViewClickedValue2 = "costam".toString();
            int qwe = R.drawable.okazala;
            int qwe2 = R.drawable.szarypie;
            String list1 = "niema".toString();
            String list2 = "niema";
            String list13 = "niema";
            String list3 = "niema";
            int qwe3 = R.drawable.szarypie;
            String list14 = "niema";
            String list4 = "niema";
            int qwe4 = R.drawable.szarypie;
            String list15 = "niema";
            String list5 = "niema";
            int qwe5 = R.drawable.szarypie;
            String TempListViewClickedValue3 = "niema";
            String TempListViewClickedValue4 = "Gatunki podobne to:";

            if (abc.contains("Borowik usiatkowany")) {
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
                        "Miąższ młody biały i zwarty, u starszych egzemplarzy gąbczasty, pod skórką zabarwiony na brązowo; niezmienny; zapach przyjemny; smak łagodny, przyjemny (orzechowy); zapach suszu charakterystyczny,  ensywny, przyjemny.\n" +
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
            }
            if (abc.contains("Borowik ponury")) {
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
                qwe = R.drawable.ceglastyst;
                qwe2 = R.drawable.ponurybig;
                list1 = "Borowik ceglastopory Boletus erythropus,".toString();
                list2 = "ma czerwonokosmkowaty trzon bez siateczki;";
                list13 = "odróżnia się tylko słabo błękitniejącym miąższem i białawym kapeluszem. ";
                list3 = "Borowik szatański Rubroboletus satanas,";
                qwe3 = R.drawable.szatanski;
            }
            if (abc.contains("Goryczak żółciowy")) {
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
            }
            if (abc.contains("Borowik ceglastopory")) {
                TempListViewClickedValue = "Borowik ceglastopory Boletus erythropus".toString();
                TempListViewClickedValue2 = "Kapelusz o średnicy 5-20 cm; ciemny, barwy zazwyczaj ciemnobrązowej, rzadziej ciemniejszy (kasztanowobrązowy); może też być ciemnoceglastoczerwony; kształt kapelusza u młodych egzemplarzy półkulisty, potem poduszkowaty, u starych płaski, mocny i mięsisty; skórka nie daje się oddzielić od miąższu. \n" +
                        "\n" +
                        "Sucha powierzchnia jest matowa, zamszowata, lepka tylko podczas deszczu.\n" +
                        "\n" +
                        "Rurki są drobne, za młodu żółtawooliwkowe, szybko pomarańczowe do krwistoczerwonych, stare bledsze, z oliwkowym odcieniem; pory i rurki po uszkodzeniu momentalnie sinieją; rurki żółte, z wiekiem oliwkowe; miąższ nad rurkami barwy żółtej. \n" +
                        "\n" +
                        "Trzon - na żółtym tle są widoczne czerwone kosmki lub ziarenka, brak rysunku siateczki, powierzchnia lekko filcowata. Już przy lekkim ucisku przebarwia się ciemnogranatowo. Za młodu pękaty lub ze zgrubiałą podstawą, potem coraz bardziej cylindryczny i smukły. \n" +
                        "\n" +
                        "Miąższ - żółty, po przecięciu momentalnie  ensywnie sinieje, staje się czarnobłękitny; przebarwienie po pewnym czasie ustępuje. Bardzo zwarty i twardy, jędrny; smak łagodny; zapach słaby, przyjemny. \n" +
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
            }
            if (abc.contains("Borowik szlachetny")) {
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
                list4 = "Borowik sosnowy Boletus pinophilus, ";
                qwe4 = R.drawable.sosnowy;
            }
            if (abc.contains("Borowik usiatkowany")) {
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
                        "Miąższ młody biały i zwarty, u starszych egzemplarzy gąbczasty, pod skórką zabarwiony na brązowo; niezmienny; zapach przyjemny; smak łagodny, przyjemny (orzechowy); zapach suszu charakterystyczny,  ensywny, przyjemny.\n" +
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
            }
            if (abc.contains("Borowik sosnowy")) {
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
            }
            if (abc.contains("Podgrzybek zajączek")) {
                TempListViewClickedValue = "Borowik zajęczy Xerocomus subtomentosus" + "\n" + "jako Podgrzybek zajączek".toString();
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
                list1 = "Podgrzybek złotopory Xerocomellus chrysenteron,".toString();
                list2 = "ma bardziej popękany kapelusz, jaśniejsze pory i trzon o czerwonawym odcieniu;";
                list13 = "o oliwkowobrązowym kapeluszu, ";
                list3 = "Podgrzybek żeberkowany Boletus ferrugineus,";
                qwe3 = R.drawable.zebrakowa;
                list14 = "jego pory sinieją po ugnieceniu.";
                list4 = "Borowik oprószony Xerocomellus pruinatus,";
                qwe4 = R.drawable.opruszony;
            }
            if (abc.contains("Lejkówka liściowa")) {
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
            }
            if (abc.contains("Siatkolist maczugowaty")) {
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
            }
            if (abc.contains("Czubajka kania")) {
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
            }
            if (abc.contains("Muchomor plamisty")) {
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
            }
            if (abc.contains("Gąska pieprzna")) {
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
            }
            if (abc.contains("Gąska ostra")) {
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
                qwe3 = R.drawable.nieksztaltnabig;
                list14 = "charakteryzująca się łagodnym smakiem.";
                list4 = "Gąska ziemistobalszkowa Tricholoma terreum,";
                qwe4 = R.drawable.ziemiastobla;
            }
            if (abc.contains("Gąska niekształtna")) {
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
            }
            if (abc.contains("Gąska zielonka")) {
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
            }
            if (abc.contains("Muchomor sromotnikowy")) {
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
            }
            if (abc.contains("Gąska siarkowa")) {
                TempListViewClickedValue = "Gąska siarkowa Tricholoma sulphureum".toString();
                TempListViewClickedValue2 = "Owocnik osiąga średnicę około 7 cm. Skórka kapelusza jest siarkowożółta i nie zmienia się w miarę dojrzewania. W środku zachowuje się mały garb nawet u zupełnie otwartych i płaskich egzemplarzy. Garbek wykazuje  ensywne zabarwienie, które może przechodzić w nieco oliwkowożółtawe. \n" +
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
            }
            if (abc.contains("Gąsówka fioletowawa")) {
                TempListViewClickedValue = "Gąsówka fioletowawa Lepista nuda".toString();
                TempListViewClickedValue2 = "Kapelusz o średnicy 6-15cm, młody barwy  ensywnie fioletowej, lilowofioletowy, brązowawofioletowy, do szrawofioletowego i bladoniebieskiego. Środek ciemniejszy  brązowawofioletowe. Z wiekiem blednie.  Młody  wypukły, potem  rozpostarty i wywinięty. Skórka sucha, matowa. Powierzchnia gładka i jedwabista. \n" +
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
            }
            if (abc.contains("Zasłonak wonny")) {
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
            }
            if (abc.contains("Gołąbek płowiejący")) {
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
            }
            if (abc.contains("Muchomor oliwkowy")) {
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
            }
            if (abc.contains("Gołąbek słodkawy")) {
                TempListViewClickedValue = "Gołąbek słodkawy Russula  egra".toString();
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
            }
            if (abc.contains("Gołąbek błotny")) {
                TempListViewClickedValue = "Gołąbek błotny Russula paludosa".toString();
                TempListViewClickedValue2 = "Kapelusz mięsisty,  ensywnie zabarwiony krwisto lub brązowoczerwony, ochrowobrązowy, czasem z jaśniejszymi miejscami, 100-160 mm średnicy; młody półkulisty, potem płaski do lekko wklęśniętego; mięsisty, mocny, skórka wilgotna lepka, błyszcząca, brzeg tępy, z wiekiem nieco karbowany i gruzełkowaty. \n" +
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
            }
            if (abc.contains("Gołąbek kunowy")) {
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
                list3 = "Gołąbek słodkawy Russula  egra,";
                qwe3 = R.drawable.golslodkawy;
            }
            if (abc.contains("Gołąbek białozielonawy")) {
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
            }
            if (abc.contains("Goździeńczyk grzebieniasty")) {
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
            }
            if (abc.contains("Gożdzieńczyk pomarszczony")) {
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
            }
            if (abc.contains("Łuszczak zmienny")) {
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
            }
            if (abc.contains("Kępkowiec jasnobrązowy")) {
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
            }
            if (abc.contains("Kępkowiec ciemnoszary")) {
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
            }
            if (abc.contains("Pieprznik jadalny")) {
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
                list13 = "jest  ensywnie pomarańczowy i rośnie tylko w buczynach;";
                list3 = "Pieprznik pomarańczowy Cantharellus friesii,";
                qwe3 = R.drawable.pomaranpie;
                list14 = "ma blaszkowate, cienkie i gęste blaszki oraz ciemniejsze, pomarańczowe owocniki.";
                list4 = "Lisówka pomarańczowa Hygrophoropsis aurantiaca,";
                qwe4 = R.drawable.pomaranlis;
            }
            if (abc.contains("Koźlarz grabowy")) {
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
            }
            if (abc.contains("Koźlarz babka")) {
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
                        "Bardzo pospolity. Zasięg tego grzyba związany jest z występowaniem brzozy (brodawkowata, omszona i gatunki  rodukowane), z którą tworzy mikoryzę. Owocniki wyrastają od lipca do listopada. Występuje pojedynczo lub w grupach po kilka, w lasach liściastych i mieszanych. \n".toString();
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
            }
            if (abc.contains("Koźlarz dębowy")) {
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
            }
            if (abc.contains("Lejkówka biaława")) {
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
            }
            if (abc.contains("Kępkowiec białawy")) {
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
            }
            if (abc.contains("Pieniążnica szerokoblaszkowa")) {
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
                //do1();
            }
            if (abc.contains("Hełmówka jadowita")) {
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
                //do1();
            }
            if (abc.contains("Boczniak ostrygowaty")) {
                TempListViewClickedValue = "Boczniak ostrygowaty" + "\n" + "Pleurotus ostreatus".toString();
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
            }
            if (abc.contains("Twardzioszek przydrożny")) {
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
            }
            if (abc.contains("Dzwonkówka trująca")) {
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
            }
            if (abc.contains("Maślak sitarz")) {
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
            }
            if (abc.contains("Maślak pstry")) {
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
            }
            if (abc.contains("Maślak rdzawobrązowy")) {
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
            }
            if (abc.contains("Maślanka wiązkowa")) {
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
                list13 = "jest większa, ma  ensywniejsze zabarwienie i rośnie tylko na drewnie drzew liściastych.";
                list3 = "Maślanka ceglasta Hypholoma lateritium,";
                qwe3 = R.drawable.ceglastama;
            }
            if (abc.contains("Mleczaj rydz")) {
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
            }
            if (abc.contains("Mleczaj świerkowy")) {
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
            }
            if (abc.contains("Mleczaj jodłowy")) {
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
            }
            if (abc.contains("Gąska mydlana")) {
                TempListViewClickedValue = "Gąska mydlana Tricholoma saponaceum".toString();
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
            }
            if (abc.contains("Muchomor czerwony")) {
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
            }
            if (abc.contains("Muchomor czerwieniejący")) {
                TempListViewClickedValue = "Muchomor czerwieniejący Amanita rubescens" + "\n" + "jako Muchomor czerwonawy".toString();
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
            }
            if (abc.contains("Muchomor jadowity")) {
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
            }
            if (abc.contains("Naziemek ceglasty")) {
                TempListViewClickedValue = "Naziemek ceglasty Albatrellus confluens" + "\n" + "jako Bielaczek pozrastany".toString();
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
            }
            if (abc.contains("Naziemek białawy")) {
                TempListViewClickedValue = "Naziemek białawy Albatrellus ovinus" + "\n" + "jako Bielaczek owczy".toString();
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
                //do1();
            }
            if (abc.contains("Opieńka miodowa")) {
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
            }
            if (abc.contains("Opieńka ciemna")) {
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
            }
            if (abc.contains("Opieńka bezpierścieniowa")) {
                TempListViewClickedValue = "Opieńka bezpierścieniowa Armillaria tabascens" + "\n" + "jako Opieńka nietrwała".toString();
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
            }
            if (abc.contains("Pisakowirec modrzak")) {
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
            }
            if (abc.contains("Piaskowiec kasztanowaty")) {
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
            }
            if (abc.contains("Pieczarka leśna")) {
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
            }
            if (abc.contains("Lejkowiec dęty")) {
                TempListViewClickedValue = "Lejkowiec dęty Craterellus cornucopioides".toString();
                TempListViewClickedValue2 = "Owocnik lejkowaty do trąbkowatego, pusty do spodu; 4-13 cm wysokości i 2-5 cm średnicy; cienkomięsisty; brzeg wywinięty, pofałdowany; strona wewnętrzna czarna, czarnobrązowa, łuseczkowato-gruczołkowata, natomiast strona zewnętrzna z hymenoforem jest szara do niebieskoszarej, gładka, pomarszczona i pofałdowana, z wiekiem biało oprószona przez zarodniki. \n" +
                        "\n" +
                        "Miąższ - cienki, szarobrązowy, czarniawy, kruchy; zapach aromatyczny, przyjemny; smak łagodny. \n" +
                        "\n" +
                        "Występuje często. Owocniki wyrastają od lata do jesieni, zwykle w dużych grupach składających się z pozrastanych ze sobą owocników, w lasach liściastych, często pod bukami. \n" +
                        "\n" +
                        "Zastosowanie - jadalny. \n".toString();
                qwe2 = R.drawable.detylejbig;
            }
            if (abc.contains("Pieprznik szary")) {
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
            }
            if (abc.contains("Piestrzyca zatokowa")) {
                TempListViewClickedValue = "Piestrzyca zatokowa Helvella lacunosa".toString();
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
            }
            if (abc.contains("Piestrzyca kędzierzawa")) {
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
                //do1();
            }
            if (abc.contains("Purchawka oczkowana")) {
                TempListViewClickedValue = "Purchawka oczkowata Calvatia utriformis" + "\n" + "jako czasznica oczkowata".toString();
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
            }
            if (abc.contains("Szyszkowiec łuskowaty")) {
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
            }
            if (abc.contains("Siedzeń sosnowy")) {
                TempListViewClickedValue = "Siedzuń sosnowy Sparassis crispa".toString();
                TempListViewClickedValue2 = "Owocnik duży; nieregularnie kulisty, elipsoidalny; 10-30 cm szerokości i 10-15 cm wysokości; składa się z krótkiego trzonu, od którego odchodzą liczne, gęsto ułożone odgałęzienia zakończone płaskimi, zaokrąglonymi, łopatkami o gładkiej powierzchni; barwa listków kremowa, z czasem ciemnieją do żółtawej, ochrowej, a zakończenia brązowieją. \n" +
                        "\n" +
                        "Miąższ białawy, bardzo łamliwy, woskowaty; zapach przyjemny; smak łagodny. \n" +
                        "\n" +
                        "Występuje nieczęsto, pojedynczo, od lipca do października, u podstawy drzew iglastych, zazwyczaj sosny, rzadziej świerka. \n" +
                        "\n" +
                        "Zastosowanie - jadalny. \n".toString();
                qwe = R.drawable.debowy;
                qwe2 = R.drawable.sosnowysiebig;
                list1 = "Szmaciak dębowy Sparassis laminosa,".toString();
                list2 = "jest białawy, słomiastożółty;";
                list13 = "wyrastający na korzeniach jodeł.";
                list3 = "Szmaciak jodłowy Sparassis nemecii,";
                qwe3 = R.drawable.jodlowyszm;
            }
            if (abc.contains("Piestrzenica kasztanowata")) {
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
                //do1();
            }
            if (abc.contains("Wodnicha modrzewiowa")) {
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
                //do1();
            }
            if (abc.contains("Zasłonak purpurowoblaszkowy")) {
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
            }
            if (abc.contains("Lakówka pospolita")) {
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
                // do1();

            }
            if (abc3.contains("Borowik usiatkowany")) {
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
                        "Miąższ młody biały i zwarty, u starszych egzemplarzy gąbczasty, pod skórką zabarwiony na brązowo; niezmienny; zapach przyjemny; smak łagodny, przyjemny (orzechowy); zapach suszu charakterystyczny,  ensywny, przyjemny.\n" +
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
            }
            if (abc3.contains("Borowik ponury")) {
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
                qwe = R.drawable.ceglastyst;
                qwe2 = R.drawable.ponurybig;
                list1 = "Borowik ceglastopory Boletus erythropus,".toString();
                list2 = "ma czerwonokosmkowaty trzon bez siateczki;";
                list13 = "odróżnia się tylko słabo błękitniejącym miąższem i białawym kapeluszem. ";
                list3 = "Borowik szatański Rubroboletus satanas,";
                qwe3 = R.drawable.szatanski;
            }
            if (abc3.contains("Goryczak żółciowy")) {
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
            }
            if (abc3.contains("Borowik ceglastopory")) {
                TempListViewClickedValue = "Borowik ceglastopory Boletus erythropus".toString();
                TempListViewClickedValue2 = "Kapelusz o średnicy 5-20 cm; ciemny, barwy zazwyczaj ciemnobrązowej, rzadziej ciemniejszy (kasztanowobrązowy); może też być ciemnoceglastoczerwony; kształt kapelusza u młodych egzemplarzy półkulisty, potem poduszkowaty, u starych płaski, mocny i mięsisty; skórka nie daje się oddzielić od miąższu. \n" +
                        "\n" +
                        "Sucha powierzchnia jest matowa, zamszowata, lepka tylko podczas deszczu.\n" +
                        "\n" +
                        "Rurki są drobne, za młodu żółtawooliwkowe, szybko pomarańczowe do krwistoczerwonych, stare bledsze, z oliwkowym odcieniem; pory i rurki po uszkodzeniu momentalnie sinieją; rurki żółte, z wiekiem oliwkowe; miąższ nad rurkami barwy żółtej. \n" +
                        "\n" +
                        "Trzon - na żółtym tle są widoczne czerwone kosmki lub ziarenka, brak rysunku siateczki, powierzchnia lekko filcowata. Już przy lekkim ucisku przebarwia się ciemnogranatowo. Za młodu pękaty lub ze zgrubiałą podstawą, potem coraz bardziej cylindryczny i smukły. \n" +
                        "\n" +
                        "Miąższ - żółty, po przecięciu momentalnie  ensywnie sinieje, staje się czarnobłękitny; przebarwienie po pewnym czasie ustępuje. Bardzo zwarty i twardy, jędrny; smak łagodny; zapach słaby, przyjemny. \n" +
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
            }
            if (abc3.contains("Borowik szlachetny")) {
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
                list4 = "Borowik sosnowy Boletus pinophilus, ";
                qwe4 = R.drawable.sosnowy;
            }
            if (abc3.contains("Borowik usiatkowany")) {
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
                        "Miąższ młody biały i zwarty, u starszych egzemplarzy gąbczasty, pod skórką zabarwiony na brązowo; niezmienny; zapach przyjemny; smak łagodny, przyjemny (orzechowy); zapach suszu charakterystyczny,  ensywny, przyjemny.\n" +
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
            }
            if (abc3.contains("Borowik sosnowy")) {
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
            }
            if (abc3.contains("Podgrzybek zajączek")) {
                TempListViewClickedValue = "Borowik zajęczy Xerocomus subtomentosus" + "\n" + "jako Podgrzybek zajączek".toString();
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
                list1 = "Podgrzybek złotopory Xerocomellus chrysenteron,".toString();
                list2 = "ma bardziej popękany kapelusz, jaśniejsze pory i trzon o czerwonawym odcieniu;";
                list13 = "o oliwkowobrązowym kapeluszu, ";
                list3 = "Podgrzybek żeberkowany Boletus ferrugineus,";
                qwe3 = R.drawable.zebrakowa;
                list14 = "jego pory sinieją po ugnieceniu.";
                list4 = "Borowik oprószony Xerocomellus pruinatus,";
                qwe4 = R.drawable.opruszony;
            }
            if (abc3.contains("Lejkówka liściowa")) {
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
            }
            if (abc3.contains("Siatkolist maczugowaty")) {
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
            }
            if (abc3.contains("Czubajka kania")) {
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
            }
            if (abc3.contains("Muchomor plamisty")) {
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
            }
            if (abc3.contains("Gąska pieprzna")) {
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
            }
            if (abc3.contains("Gąska ostra")) {
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
                qwe3 = R.drawable.nieksztaltnabig;
                list14 = "charakteryzująca się łagodnym smakiem.";
                list4 = "Gąska ziemistobalszkowa Tricholoma terreum,";
                qwe4 = R.drawable.ziemiastobla;
            }
            if (abc3.contains("Gąska niekształtna")) {
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
            }
            if (abc3.contains("Gąska zielonka")) {
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
            }
            if (abc3.contains("Muchomor sromotnikowy")) {
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
            }
            if (abc3.contains("Gąska siarkowa")) {
                TempListViewClickedValue = "Gąska siarkowa Tricholoma sulphureum".toString();
                TempListViewClickedValue2 = "Owocnik osiąga średnicę około 7 cm. Skórka kapelusza jest siarkowożółta i nie zmienia się w miarę dojrzewania. W środku zachowuje się mały garb nawet u zupełnie otwartych i płaskich egzemplarzy. Garbek wykazuje  ensywne zabarwienie, które może przechodzić w nieco oliwkowożółtawe. \n" +
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
            }
            if (abc3.contains("Gąsówka fioletowawa")) {
                TempListViewClickedValue = "Gąsówka fioletowawa Lepista nuda".toString();
                TempListViewClickedValue2 = "Kapelusz o średnicy 6-15cm, młody barwy  ensywnie fioletowej, lilowofioletowy, brązowawofioletowy, do szrawofioletowego i bladoniebieskiego. Środek ciemniejszy  brązowawofioletowe. Z wiekiem blednie.  Młody  wypukły, potem  rozpostarty i wywinięty. Skórka sucha, matowa. Powierzchnia gładka i jedwabista. \n" +
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
            }
            if (abc3.contains("Zasłonak wonny")) {
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
            }
            if (abc3.contains("Gołąbek płowiejący")) {
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
            }
            if (abc3.contains("Muchomor oliwkowy")) {
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
            }
            if (abc3.contains("Gołąbek słodkawy")) {
                TempListViewClickedValue = "Gołąbek słodkawy Russula  egra".toString();
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
            }
            if (abc3.contains("Gołąbek błotny")) {
                TempListViewClickedValue = "Gołąbek błotny Russula paludosa".toString();
                TempListViewClickedValue2 = "Kapelusz mięsisty,  ensywnie zabarwiony krwisto lub brązowoczerwony, ochrowobrązowy, czasem z jaśniejszymi miejscami, 100-160 mm średnicy; młody półkulisty, potem płaski do lekko wklęśniętego; mięsisty, mocny, skórka wilgotna lepka, błyszcząca, brzeg tępy, z wiekiem nieco karbowany i gruzełkowaty. \n" +
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
            }
            if (abc3.contains("Gołąbek kunowy")) {
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
                list3 = "Gołąbek słodkawy Russula  egra,";
                qwe3 = R.drawable.golslodkawy;
            }
            if (abc3.contains("Gołąbek białozielonawy")) {
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
            }
            if (abc3.contains("Goździeńczyk grzebieniasty")) {
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
            }
            if (abc3.contains("Gożdzieńczyk pomarszczony")) {
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
            }
            if (abc3.contains("Łuszczak zmienny")) {
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
            }
            if (abc3.contains("Kępkowiec jasnobrązowy")) {
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
            }
            if (abc3.contains("Kępkowiec ciemnoszary")) {
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
            }
            if (abc3.contains("Pieprznik jadalny")) {
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
                list13 = "jest  ensywnie pomarańczowy i rośnie tylko w buczynach;";
                list3 = "Pieprznik pomarańczowy Cantharellus friesii,";
                qwe3 = R.drawable.pomaranpie;
                list14 = "ma blaszkowate, cienkie i gęste blaszki oraz ciemniejsze, pomarańczowe owocniki.";
                list4 = "Lisówka pomarańczowa Hygrophoropsis aurantiaca,";
                qwe4 = R.drawable.pomaranlis;
            }
            if (abc3.contains("Koźlarz grabowy")) {
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
            }
            if (abc3.contains("Koźlarz babka")) {
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
                        "Bardzo pospolity. Zasięg tego grzyba związany jest z występowaniem brzozy (brodawkowata, omszona i gatunki  rodukowane), z którą tworzy mikoryzę. Owocniki wyrastają od lipca do listopada. Występuje pojedynczo lub w grupach po kilka, w lasach liściastych i mieszanych. \n".toString();
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
            }
            if (abc3.contains("Koźlarz dębowy")) {
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
            }
            if (abc3.contains("Lejkówka biaława")) {
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
            }
            if (abc3.contains("Kępkowiec białawy")) {
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
            }
            if (abc3.contains("Pieniążnica szerokoblaszkowa")) {
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
                //do1();
            }
            if (abc3.contains("Hełmówka jadowita")) {
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
                //do1();
            }
            if (abc3.contains("Boczniak ostrygowaty")) {
                TempListViewClickedValue = "Boczniak ostrygowaty" + "\n" + "Pleurotus ostreatus".toString();
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
            }
            if (abc3.contains("Twardzioszek przydrożny")) {
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
            }
            if (abc3.contains("Dzwonkówka trująca")) {
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
            }
            if (abc3.contains("Maślak sitarz")) {
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
            }
            if (abc3.contains("Maślak pstry")) {
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
            }
            if (abc3.contains("Maślak rdzawobrązowy")) {
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
            }
            if (abc3.contains("Maślanka wiązkowa")) {
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
                list13 = "jest większa, ma  ensywniejsze zabarwienie i rośnie tylko na drewnie drzew liściastych.";
                list3 = "Maślanka ceglasta Hypholoma lateritium,";
                qwe3 = R.drawable.ceglastama;
            }
            if (abc3.contains("Mleczaj rydz")) {
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
            }
            if (abc3.contains("Mleczaj świerkowy")) {
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
            }
            if (abc3.contains("Mleczaj jodłowy")) {
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
            }
            if (abc3.contains("Gąska mydlana")) {
                TempListViewClickedValue = "Gąska mydlana Tricholoma saponaceum".toString();
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
            }
            if (abc3.contains("Muchomor czerwony")) {
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
            }
            if (abc3.contains("Muchomor czerwieniejący")) {
                TempListViewClickedValue = "Muchomor czerwieniejący Amanita rubescens" + "\n" + "jako Muchomor czerwonawy".toString();
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
            }
            if (abc3.contains("Muchomor jadowity")) {
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
            }
            if (abc3.contains("Naziemek ceglasty")) {
                TempListViewClickedValue = "Naziemek ceglasty Albatrellus confluens" + "\n" + "jako Bielaczek pozrastany".toString();
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
            }
            if (abc3.contains("Naziemek białawy")) {
                TempListViewClickedValue = "Naziemek białawy Albatrellus ovinus" + "\n" + "jako Bielaczek owczy".toString();
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
                //do1();
            }
            if (abc3.contains("Opieńka miodowa")) {
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
            }
            if (abc3.contains("Opieńka ciemna")) {
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
            }
            if (abc3.contains("Opieńka bezpierścieniowa")) {
                TempListViewClickedValue = "Opieńka bezpierścieniowa Armillaria tabascens" + "\n" + "jako Opieńka nietrwała".toString();
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
            }
            if (abc3.contains("Pisakowirec modrzak")) {
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
            }
            if (abc3.contains("Piaskowiec kasztanowaty")) {
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
            }
            if (abc3.contains("Pieczarka leśna")) {
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
            }
            if (abc3.contains("Lejkowiec dęty")) {
                TempListViewClickedValue = "Lejkowiec dęty Craterellus cornucopioides".toString();
                TempListViewClickedValue2 = "Owocnik lejkowaty do trąbkowatego, pusty do spodu; 4-13 cm wysokości i 2-5 cm średnicy; cienkomięsisty; brzeg wywinięty, pofałdowany; strona wewnętrzna czarna, czarnobrązowa, łuseczkowato-gruczołkowata, natomiast strona zewnętrzna z hymenoforem jest szara do niebieskoszarej, gładka, pomarszczona i pofałdowana, z wiekiem biało oprószona przez zarodniki. \n" +
                        "\n" +
                        "Miąższ - cienki, szarobrązowy, czarniawy, kruchy; zapach aromatyczny, przyjemny; smak łagodny. \n" +
                        "\n" +
                        "Występuje często. Owocniki wyrastają od lata do jesieni, zwykle w dużych grupach składających się z pozrastanych ze sobą owocników, w lasach liściastych, często pod bukami. \n" +
                        "\n" +
                        "Zastosowanie - jadalny. \n".toString();
                qwe2 = R.drawable.detylejbig;
            }
            if (abc3.contains("Pieprznik szary")) {
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
            }
            if (abc3.contains("Piestrzyca zatokowa")) {
                TempListViewClickedValue = "Piestrzyca zatokowa Helvella lacunosa".toString();
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
            }
            if (abc3.contains("Piestrzyca kędzierzawa")) {
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
                //do1();
            }
            if (abc3.contains("Purchawka oczkowana")) {
                TempListViewClickedValue = "Purchawka oczkowata Calvatia utriformis" + "\n" + "jako czasznica oczkowata".toString();
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
            }
            if (abc3.contains("Szyszkowiec łuskowaty")) {
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
            }
            if (abc3.contains("Siedzeń sosnowy")) {
                TempListViewClickedValue = "Siedzuń sosnowy Sparassis crispa".toString();
                TempListViewClickedValue2 = "Owocnik duży; nieregularnie kulisty, elipsoidalny; 10-30 cm szerokości i 10-15 cm wysokości; składa się z krótkiego trzonu, od którego odchodzą liczne, gęsto ułożone odgałęzienia zakończone płaskimi, zaokrąglonymi, łopatkami o gładkiej powierzchni; barwa listków kremowa, z czasem ciemnieją do żółtawej, ochrowej, a zakończenia brązowieją. \n" +
                        "\n" +
                        "Miąższ białawy, bardzo łamliwy, woskowaty; zapach przyjemny; smak łagodny. \n" +
                        "\n" +
                        "Występuje nieczęsto, pojedynczo, od lipca do października, u podstawy drzew iglastych, zazwyczaj sosny, rzadziej świerka. \n" +
                        "\n" +
                        "Zastosowanie - jadalny. \n".toString();
                qwe = R.drawable.debowy;
                qwe2 = R.drawable.sosnowysiebig;
                list1 = "Szmaciak dębowy Sparassis laminosa,".toString();
                list2 = "jest białawy, słomiastożółty;";
                list13 = "wyrastający na korzeniach jodeł.";
                list3 = "Szmaciak jodłowy Sparassis nemecii,";
                qwe3 = R.drawable.jodlowyszm;
            }
            if (abc3.contains("Piestrzenica kasztanowata")) {
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
                //do1();
            }
            if (abc3.contains("Wodnicha modrzewiowa")) {
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
                //do1();
            }
            if (abc3.contains("Zasłonak purpurowoblaszkowy")) {
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
            }
            if (abc3.contains("Lakówka pospolita")) {
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
                // do1();

            }
            if (abc4.contains("Borowik usiatkowany")) {
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
                        "Miąższ młody biały i zwarty, u starszych egzemplarzy gąbczasty, pod skórką zabarwiony na brązowo; niezmienny; zapach przyjemny; smak łagodny, przyjemny (orzechowy); zapach suszu charakterystyczny,  ensywny, przyjemny.\n" +
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
            }
            if (abc4.contains("Borowik ponury")) {
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
                qwe = R.drawable.ceglastyst;
                qwe2 = R.drawable.ponurybig;
                list1 = "Borowik ceglastopory Boletus erythropus,".toString();
                list2 = "ma czerwonokosmkowaty trzon bez siateczki;";
                list13 = "odróżnia się tylko słabo błękitniejącym miąższem i białawym kapeluszem. ";
                list3 = "Borowik szatański Rubroboletus satanas,";
                qwe3 = R.drawable.szatanski;
            }
            if (abc4.contains("Goryczak żółciowy")) {
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
            }
            if (abc4.contains("Borowik ceglastopory")) {
                TempListViewClickedValue = "Borowik ceglastopory Boletus erythropus".toString();
                TempListViewClickedValue2 = "Kapelusz o średnicy 5-20 cm; ciemny, barwy zazwyczaj ciemnobrązowej, rzadziej ciemniejszy (kasztanowobrązowy); może też być ciemnoceglastoczerwony; kształt kapelusza u młodych egzemplarzy półkulisty, potem poduszkowaty, u starych płaski, mocny i mięsisty; skórka nie daje się oddzielić od miąższu. \n" +
                        "\n" +
                        "Sucha powierzchnia jest matowa, zamszowata, lepka tylko podczas deszczu.\n" +
                        "\n" +
                        "Rurki są drobne, za młodu żółtawooliwkowe, szybko pomarańczowe do krwistoczerwonych, stare bledsze, z oliwkowym odcieniem; pory i rurki po uszkodzeniu momentalnie sinieją; rurki żółte, z wiekiem oliwkowe; miąższ nad rurkami barwy żółtej. \n" +
                        "\n" +
                        "Trzon - na żółtym tle są widoczne czerwone kosmki lub ziarenka, brak rysunku siateczki, powierzchnia lekko filcowata. Już przy lekkim ucisku przebarwia się ciemnogranatowo. Za młodu pękaty lub ze zgrubiałą podstawą, potem coraz bardziej cylindryczny i smukły. \n" +
                        "\n" +
                        "Miąższ - żółty, po przecięciu momentalnie  ensywnie sinieje, staje się czarnobłękitny; przebarwienie po pewnym czasie ustępuje. Bardzo zwarty i twardy, jędrny; smak łagodny; zapach słaby, przyjemny. \n" +
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
            }
            if (abc4.contains("Borowik szlachetny")) {
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
                list4 = "Borowik sosnowy Boletus pinophilus, ";
                qwe4 = R.drawable.sosnowy;
            }
            if (abc4.contains("Borowik usiatkowany")) {
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
                        "Miąższ młody biały i zwarty, u starszych egzemplarzy gąbczasty, pod skórką zabarwiony na brązowo; niezmienny; zapach przyjemny; smak łagodny, przyjemny (orzechowy); zapach suszu charakterystyczny,  ensywny, przyjemny.\n" +
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
            }
            if (abc4.contains("Borowik sosnowy")) {
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
            }
            if (abc4.contains("Podgrzybek zajączek")) {
                TempListViewClickedValue = "Borowik zajęczy Xerocomus subtomentosus" + "\n" + "jako Podgrzybek zajączek".toString();
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
                list1 = "Podgrzybek złotopory Xerocomellus chrysenteron,".toString();
                list2 = "ma bardziej popękany kapelusz, jaśniejsze pory i trzon o czerwonawym odcieniu;";
                list13 = "o oliwkowobrązowym kapeluszu, ";
                list3 = "Podgrzybek żeberkowany Boletus ferrugineus,";
                qwe3 = R.drawable.zebrakowa;
                list14 = "jego pory sinieją po ugnieceniu.";
                list4 = "Borowik oprószony Xerocomellus pruinatus,";
                qwe4 = R.drawable.opruszony;
            }
            if (abc4.contains("Lejkówka liściowa")) {
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
            }
            if (abc4.contains("Siatkolist maczugowaty")) {
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
            }
            if (abc4.contains("Czubajka kania")) {
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
            }
            if (abc4.contains("Muchomor plamisty")) {
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
            }
            if (abc4.contains("Gąska pieprzna")) {
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
            }
            if (abc4.contains("Gąska ostra")) {
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
                qwe3 = R.drawable.nieksztaltnabig;
                list14 = "charakteryzująca się łagodnym smakiem.";
                list4 = "Gąska ziemistobalszkowa Tricholoma terreum,";
                qwe4 = R.drawable.ziemiastobla;
            }
            if (abc4.contains("Gąska niekształtna")) {
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
            }
            if (abc4.contains("Gąska zielonka")) {
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
            }
            if (abc4.contains("Muchomor sromotnikowy")) {
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
            }
            if (abc4.contains("Gąska siarkowa")) {
                TempListViewClickedValue = "Gąska siarkowa Tricholoma sulphureum".toString();
                TempListViewClickedValue2 = "Owocnik osiąga średnicę około 7 cm. Skórka kapelusza jest siarkowożółta i nie zmienia się w miarę dojrzewania. W środku zachowuje się mały garb nawet u zupełnie otwartych i płaskich egzemplarzy. Garbek wykazuje  ensywne zabarwienie, które może przechodzić w nieco oliwkowożółtawe. \n" +
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
            }
            if (abc4.contains("Gąsówka fioletowawa")) {
                TempListViewClickedValue = "Gąsówka fioletowawa Lepista nuda".toString();
                TempListViewClickedValue2 = "Kapelusz o średnicy 6-15cm, młody barwy  ensywnie fioletowej, lilowofioletowy, brązowawofioletowy, do szrawofioletowego i bladoniebieskiego. Środek ciemniejszy  brązowawofioletowe. Z wiekiem blednie.  Młody  wypukły, potem  rozpostarty i wywinięty. Skórka sucha, matowa. Powierzchnia gładka i jedwabista. \n" +
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
            }
            if (abc4.contains("Zasłonak wonny")) {
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
            }
            if (abc4.contains("Gołąbek płowiejący")) {
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
            }
            if (abc4.contains("Muchomor oliwkowy")) {
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
            }
            if (abc4.contains("Gołąbek słodkawy")) {
                TempListViewClickedValue = "Gołąbek słodkawy Russula  egra".toString();
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
            }
            if (abc4.contains("Gołąbek błotny")) {
                TempListViewClickedValue = "Gołąbek błotny Russula paludosa".toString();
                TempListViewClickedValue2 = "Kapelusz mięsisty,  ensywnie zabarwiony krwisto lub brązowoczerwony, ochrowobrązowy, czasem z jaśniejszymi miejscami, 100-160 mm średnicy; młody półkulisty, potem płaski do lekko wklęśniętego; mięsisty, mocny, skórka wilgotna lepka, błyszcząca, brzeg tępy, z wiekiem nieco karbowany i gruzełkowaty. \n" +
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
            }
            if (abc4.contains("Gołąbek kunowy")) {
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
                list3 = "Gołąbek słodkawy Russula  egra,";
                qwe3 = R.drawable.golslodkawy;
            }
            if (abc4.contains("Gołąbek białozielonawy")) {
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
            }
            if (abc4.contains("Goździeńczyk grzebieniasty")) {
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
            }
            if (abc4.contains("Gożdzieńczyk pomarszczony")) {
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
            }
            if (abc4.contains("Łuszczak zmienny")) {
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
            }
            if (abc4.contains("Kępkowiec jasnobrązowy")) {
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
            }
            if (abc4.contains("Kępkowiec ciemnoszary")) {
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
            }
            if (abc4.contains("Pieprznik jadalny")) {
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
                list13 = "jest  ensywnie pomarańczowy i rośnie tylko w buczynach;";
                list3 = "Pieprznik pomarańczowy Cantharellus friesii,";
                qwe3 = R.drawable.pomaranpie;
                list14 = "ma blaszkowate, cienkie i gęste blaszki oraz ciemniejsze, pomarańczowe owocniki.";
                list4 = "Lisówka pomarańczowa Hygrophoropsis aurantiaca,";
                qwe4 = R.drawable.pomaranlis;
            }
            if (abc4.contains("Koźlarz grabowy")) {
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
            }
            if (abc4.contains("Koźlarz babka")) {
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
                        "Bardzo pospolity. Zasięg tego grzyba związany jest z występowaniem brzozy (brodawkowata, omszona i gatunki  rodukowane), z którą tworzy mikoryzę. Owocniki wyrastają od lipca do listopada. Występuje pojedynczo lub w grupach po kilka, w lasach liściastych i mieszanych. \n".toString();
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
            }
            if (abc4.contains("Koźlarz dębowy")) {
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
            }
            if (abc4.contains("Lejkówka biaława")) {
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
            }
            if (abc4.contains("Kępkowiec białawy")) {
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
            }
            if (abc4.contains("Pieniążnica szerokoblaszkowa")) {
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
                //do1();
            }
            if (abc4.contains("Hełmówka jadowita")) {
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
                //do1();
            }
            if (abc4.contains("Boczniak ostrygowaty")) {
                TempListViewClickedValue = "Boczniak ostrygowaty" + "\n" + "Pleurotus ostreatus".toString();
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
            }
            if (abc4.contains("Twardzioszek przydrożny")) {
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
            }
            if (abc4.contains("Dzwonkówka trująca")) {
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
            }
            if (abc4.contains("Maślak sitarz")) {
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
            }
            if (abc4.contains("Maślak pstry")) {
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
            }
            if (abc4.contains("Maślak rdzawobrązowy")) {
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
            }
            if (abc4.contains("Maślanka wiązkowa")) {
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
                list13 = "jest większa, ma  ensywniejsze zabarwienie i rośnie tylko na drewnie drzew liściastych.";
                list3 = "Maślanka ceglasta Hypholoma lateritium,";
                qwe3 = R.drawable.ceglastama;
            }
            if (abc4.contains("Mleczaj rydz")) {
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
            }
            if (abc4.contains("Mleczaj świerkowy")) {
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
            }
            if (abc4.contains("Mleczaj jodłowy")) {
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
            }
            if (abc4.contains("Gąska mydlana")) {
                TempListViewClickedValue = "Gąska mydlana Tricholoma saponaceum".toString();
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
            }
            if (abc4.contains("Muchomor czerwony")) {
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
            }
            if (abc4.contains("Muchomor czerwieniejący")) {
                TempListViewClickedValue = "Muchomor czerwieniejący Amanita rubescens" + "\n" + "jako Muchomor czerwonawy".toString();
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
            }
            if (abc4.contains("Muchomor jadowity")) {
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
            }
            if (abc4.contains("Naziemek ceglasty")) {
                TempListViewClickedValue = "Naziemek ceglasty Albatrellus confluens" + "\n" + "jako Bielaczek pozrastany".toString();
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
            }
            if (abc4.contains("Naziemek białawy")) {
                TempListViewClickedValue = "Naziemek białawy Albatrellus ovinus" + "\n" + "jako Bielaczek owczy".toString();
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
                //do1();
            }
            if (abc4.contains("Opieńka miodowa")) {
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
            }
            if (abc4.contains("Opieńka ciemna")) {
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
            }
            if (abc4.contains("Opieńka bezpierścieniowa")) {
                TempListViewClickedValue = "Opieńka bezpierścieniowa Armillaria tabascens" + "\n" + "jako Opieńka nietrwała".toString();
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
            }
            if (abc4.contains("Pisakowirec modrzak")) {
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
            }
            if (abc4.contains("Piaskowiec kasztanowaty")) {
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
            }
            if (abc4.contains("Pieczarka leśna")) {
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
            }
            if (abc4.contains("Lejkowiec dęty")) {
                TempListViewClickedValue = "Lejkowiec dęty Craterellus cornucopioides".toString();
                TempListViewClickedValue2 = "Owocnik lejkowaty do trąbkowatego, pusty do spodu; 4-13 cm wysokości i 2-5 cm średnicy; cienkomięsisty; brzeg wywinięty, pofałdowany; strona wewnętrzna czarna, czarnobrązowa, łuseczkowato-gruczołkowata, natomiast strona zewnętrzna z hymenoforem jest szara do niebieskoszarej, gładka, pomarszczona i pofałdowana, z wiekiem biało oprószona przez zarodniki. \n" +
                        "\n" +
                        "Miąższ - cienki, szarobrązowy, czarniawy, kruchy; zapach aromatyczny, przyjemny; smak łagodny. \n" +
                        "\n" +
                        "Występuje często. Owocniki wyrastają od lata do jesieni, zwykle w dużych grupach składających się z pozrastanych ze sobą owocników, w lasach liściastych, często pod bukami. \n" +
                        "\n" +
                        "Zastosowanie - jadalny. \n".toString();
                qwe2 = R.drawable.detylejbig;
            }
            if (abc4.contains("Pieprznik szary")) {
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
            }
            if (abc4.contains("Piestrzyca zatokowa")) {
                TempListViewClickedValue = "Piestrzyca zatokowa Helvella lacunosa".toString();
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
            }
            if (abc4.contains("Piestrzyca kędzierzawa")) {
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
                //do1();
            }
            if (abc4.contains("Purchawka oczkowana")) {
                TempListViewClickedValue = "Purchawka oczkowata Calvatia utriformis" + "\n" + "jako czasznica oczkowata".toString();
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
            }
            if (abc4.contains("Szyszkowiec łuskowaty")) {
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
            }
            if (abc4.contains("Siedzeń sosnowy")) {
                TempListViewClickedValue = "Siedzuń sosnowy Sparassis crispa".toString();
                TempListViewClickedValue2 = "Owocnik duży; nieregularnie kulisty, elipsoidalny; 10-30 cm szerokości i 10-15 cm wysokości; składa się z krótkiego trzonu, od którego odchodzą liczne, gęsto ułożone odgałęzienia zakończone płaskimi, zaokrąglonymi, łopatkami o gładkiej powierzchni; barwa listków kremowa, z czasem ciemnieją do żółtawej, ochrowej, a zakończenia brązowieją. \n" +
                        "\n" +
                        "Miąższ białawy, bardzo łamliwy, woskowaty; zapach przyjemny; smak łagodny. \n" +
                        "\n" +
                        "Występuje nieczęsto, pojedynczo, od lipca do października, u podstawy drzew iglastych, zazwyczaj sosny, rzadziej świerka. \n" +
                        "\n" +
                        "Zastosowanie - jadalny. \n".toString();
                qwe = R.drawable.debowy;
                qwe2 = R.drawable.sosnowysiebig;
                list1 = "Szmaciak dębowy Sparassis laminosa,".toString();
                list2 = "jest białawy, słomiastożółty;";
                list13 = "wyrastający na korzeniach jodeł.";
                list3 = "Szmaciak jodłowy Sparassis nemecii,";
                qwe3 = R.drawable.jodlowyszm;
            }
            if (abc4.contains("Piestrzenica kasztanowata")) {
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
                //do1();
            }
            if (abc4.contains("Wodnicha modrzewiowa")) {
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
                //do1();
            }
            if (abc4.contains("Zasłonak purpurowoblaszkowy")) {
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
            }
            if (abc4.contains("Lakówka pospolita")) {
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
                // do1();

            }
            if (abc5.contains("Borowik usiatkowany")) {
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
                        "Miąższ młody biały i zwarty, u starszych egzemplarzy gąbczasty, pod skórką zabarwiony na brązowo; niezmienny; zapach przyjemny; smak łagodny, przyjemny (orzechowy); zapach suszu charakterystyczny,  ensywny, przyjemny.\n" +
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
            }
            if (abc5.contains("Borowik ponury")) {
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
                qwe = R.drawable.ceglastyst;
                qwe2 = R.drawable.ponurybig;
                list1 = "Borowik ceglastopory Boletus erythropus,".toString();
                list2 = "ma czerwonokosmkowaty trzon bez siateczki;";
                list13 = "odróżnia się tylko słabo błękitniejącym miąższem i białawym kapeluszem. ";
                list3 = "Borowik szatański Rubroboletus satanas,";
                qwe3 = R.drawable.szatanski;
            }
            if (abc5.contains("Goryczak żółciowy")) {
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
            }
            if (abc5.contains("Borowik ceglastopory")) {
                TempListViewClickedValue = "Borowik ceglastopory Boletus erythropus".toString();
                TempListViewClickedValue2 = "Kapelusz o średnicy 5-20 cm; ciemny, barwy zazwyczaj ciemnobrązowej, rzadziej ciemniejszy (kasztanowobrązowy); może też być ciemnoceglastoczerwony; kształt kapelusza u młodych egzemplarzy półkulisty, potem poduszkowaty, u starych płaski, mocny i mięsisty; skórka nie daje się oddzielić od miąższu. \n" +
                        "\n" +
                        "Sucha powierzchnia jest matowa, zamszowata, lepka tylko podczas deszczu.\n" +
                        "\n" +
                        "Rurki są drobne, za młodu żółtawooliwkowe, szybko pomarańczowe do krwistoczerwonych, stare bledsze, z oliwkowym odcieniem; pory i rurki po uszkodzeniu momentalnie sinieją; rurki żółte, z wiekiem oliwkowe; miąższ nad rurkami barwy żółtej. \n" +
                        "\n" +
                        "Trzon - na żółtym tle są widoczne czerwone kosmki lub ziarenka, brak rysunku siateczki, powierzchnia lekko filcowata. Już przy lekkim ucisku przebarwia się ciemnogranatowo. Za młodu pękaty lub ze zgrubiałą podstawą, potem coraz bardziej cylindryczny i smukły. \n" +
                        "\n" +
                        "Miąższ - żółty, po przecięciu momentalnie  ensywnie sinieje, staje się czarnobłękitny; przebarwienie po pewnym czasie ustępuje. Bardzo zwarty i twardy, jędrny; smak łagodny; zapach słaby, przyjemny. \n" +
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
            }
            if (abc5.contains("Borowik szlachetny")) {
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
                list4 = "Borowik sosnowy Boletus pinophilus, ";
                qwe4 = R.drawable.sosnowy;
            }
            if (abc5.contains("Borowik usiatkowany")) {
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
                        "Miąższ młody biały i zwarty, u starszych egzemplarzy gąbczasty, pod skórką zabarwiony na brązowo; niezmienny; zapach przyjemny; smak łagodny, przyjemny (orzechowy); zapach suszu charakterystyczny,  ensywny, przyjemny.\n" +
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
            }
            if (abc5.contains("Borowik sosnowy")) {
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
            }
            if (abc5.contains("Podgrzybek zajączek")) {
                TempListViewClickedValue = "Borowik zajęczy Xerocomus subtomentosus" + "\n" + "jako Podgrzybek zajączek".toString();
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
                list1 = "Podgrzybek złotopory Xerocomellus chrysenteron,".toString();
                list2 = "ma bardziej popękany kapelusz, jaśniejsze pory i trzon o czerwonawym odcieniu;";
                list13 = "o oliwkowobrązowym kapeluszu, ";
                list3 = "Podgrzybek żeberkowany Boletus ferrugineus,";
                qwe3 = R.drawable.zebrakowa;
                list14 = "jego pory sinieją po ugnieceniu.";
                list4 = "Borowik oprószony Xerocomellus pruinatus,";
                qwe4 = R.drawable.opruszony;
            }
            if (abc5.contains("Lejkówka liściowa")) {
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
            }
            if (abc5.contains("Siatkolist maczugowaty")) {
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
            }
            if (abc5.contains("Czubajka kania")) {
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
            }
            if (abc5.contains("Muchomor plamisty")) {
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
            }
            if (abc5.contains("Gąska pieprzna")) {
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
            }
            if (abc5.contains("Gąska ostra")) {
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
                qwe3 = R.drawable.nieksztaltnabig;
                list14 = "charakteryzująca się łagodnym smakiem.";
                list4 = "Gąska ziemistobalszkowa Tricholoma terreum,";
                qwe4 = R.drawable.ziemiastobla;
            }
            if (abc5.contains("Gąska niekształtna")) {
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
            }
            if (abc5.contains("Gąska zielonka")) {
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
            }
            if (abc5.contains("Muchomor sromotnikowy")) {
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
            }
            if (abc5.contains("Gąska siarkowa")) {
                TempListViewClickedValue = "Gąska siarkowa Tricholoma sulphureum".toString();
                TempListViewClickedValue2 = "Owocnik osiąga średnicę około 7 cm. Skórka kapelusza jest siarkowożółta i nie zmienia się w miarę dojrzewania. W środku zachowuje się mały garb nawet u zupełnie otwartych i płaskich egzemplarzy. Garbek wykazuje  ensywne zabarwienie, które może przechodzić w nieco oliwkowożółtawe. \n" +
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
            }
            if (abc5.contains("Gąsówka fioletowawa")) {
                TempListViewClickedValue = "Gąsówka fioletowawa Lepista nuda".toString();
                TempListViewClickedValue2 = "Kapelusz o średnicy 6-15cm, młody barwy  ensywnie fioletowej, lilowofioletowy, brązowawofioletowy, do szrawofioletowego i bladoniebieskiego. Środek ciemniejszy  brązowawofioletowe. Z wiekiem blednie.  Młody  wypukły, potem  rozpostarty i wywinięty. Skórka sucha, matowa. Powierzchnia gładka i jedwabista. \n" +
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
            }
            if (abc5.contains("Zasłonak wonny")) {
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
            }
            if (abc5.contains("Gołąbek płowiejący")) {
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
            }
            if (abc5.contains("Muchomor oliwkowy")) {
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
            }
            if (abc5.contains("Gołąbek słodkawy")) {
                TempListViewClickedValue = "Gołąbek słodkawy Russula  egra".toString();
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
            }
            if (abc5.contains("Gołąbek błotny")) {
                TempListViewClickedValue = "Gołąbek błotny Russula paludosa".toString();
                TempListViewClickedValue2 = "Kapelusz mięsisty,  ensywnie zabarwiony krwisto lub brązowoczerwony, ochrowobrązowy, czasem z jaśniejszymi miejscami, 100-160 mm średnicy; młody półkulisty, potem płaski do lekko wklęśniętego; mięsisty, mocny, skórka wilgotna lepka, błyszcząca, brzeg tępy, z wiekiem nieco karbowany i gruzełkowaty. \n" +
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
            }
            if (abc5.contains("Gołąbek kunowy")) {
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
                list3 = "Gołąbek słodkawy Russula  egra,";
                qwe3 = R.drawable.golslodkawy;
            }
            if (abc5.contains("Gołąbek białozielonawy")) {
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
            }
            if (abc5.contains("Goździeńczyk grzebieniasty")) {
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
            }
            if (abc5.contains("Gożdzieńczyk pomarszczony")) {
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
            }
            if (abc5.contains("Łuszczak zmienny")) {
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
            }
            if (abc5.contains("Kępkowiec jasnobrązowy")) {
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
            }
            if (abc5.contains("Kępkowiec ciemnoszary")) {
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
            }
            if (abc5.contains("Pieprznik jadalny")) {
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
                list13 = "jest  ensywnie pomarańczowy i rośnie tylko w buczynach;";
                list3 = "Pieprznik pomarańczowy Cantharellus friesii,";
                qwe3 = R.drawable.pomaranpie;
                list14 = "ma blaszkowate, cienkie i gęste blaszki oraz ciemniejsze, pomarańczowe owocniki.";
                list4 = "Lisówka pomarańczowa Hygrophoropsis aurantiaca,";
                qwe4 = R.drawable.pomaranlis;
            }
            if (abc5.contains("Koźlarz grabowy")) {
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
            }
            if (abc5.contains("Koźlarz babka")) {
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
                        "Bardzo pospolity. Zasięg tego grzyba związany jest z występowaniem brzozy (brodawkowata, omszona i gatunki  rodukowane), z którą tworzy mikoryzę. Owocniki wyrastają od lipca do listopada. Występuje pojedynczo lub w grupach po kilka, w lasach liściastych i mieszanych. \n".toString();
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
            }
            if (abc5.contains("Koźlarz dębowy")) {
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
            }
            if (abc5.contains("Lejkówka biaława")) {
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
            }
            if (abc5.contains("Kępkowiec białawy")) {
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
            }
            if (abc5.contains("Pieniążnica szerokoblaszkowa")) {
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
                //do1();
            }
            if (abc5.contains("Hełmówka jadowita")) {
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
                //do1();
            }
            if (abc5.contains("Boczniak ostrygowaty")) {
                TempListViewClickedValue = "Boczniak ostrygowaty" + "\n" + "Pleurotus ostreatus".toString();
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
            }
            if (abc5.contains("Twardzioszek przydrożny")) {
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
            }
            if (abc5.contains("Dzwonkówka trująca")) {
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
            }
            if (abc5.contains("Maślak sitarz")) {
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
            }
            if (abc5.contains("Maślak pstry")) {
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
            }
            if (abc5.contains("Maślak rdzawobrązowy")) {
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
            }
            if (abc5.contains("Maślanka wiązkowa")) {
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
                list13 = "jest większa, ma  ensywniejsze zabarwienie i rośnie tylko na drewnie drzew liściastych.";
                list3 = "Maślanka ceglasta Hypholoma lateritium,";
                qwe3 = R.drawable.ceglastama;
            }
            if (abc5.contains("Mleczaj rydz")) {
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
            }
            if (abc5.contains("Mleczaj świerkowy")) {
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
            }
            if (abc5.contains("Mleczaj jodłowy")) {
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
            }
            if (abc5.contains("Gąska mydlana")) {
                TempListViewClickedValue = "Gąska mydlana Tricholoma saponaceum".toString();
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
            }
            if (abc5.contains("Muchomor czerwony")) {
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
            }
            if (abc5.contains("Muchomor czerwieniejący")) {
                TempListViewClickedValue = "Muchomor czerwieniejący Amanita rubescens" + "\n" + "jako Muchomor czerwonawy".toString();
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
            }
            if (abc5.contains("Muchomor jadowity")) {
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
            }
            if (abc5.contains("Naziemek ceglasty")) {
                TempListViewClickedValue = "Naziemek ceglasty Albatrellus confluens" + "\n" + "jako Bielaczek pozrastany".toString();
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
            }
            if (abc5.contains("Naziemek białawy")) {
                TempListViewClickedValue = "Naziemek białawy Albatrellus ovinus" + "\n" + "jako Bielaczek owczy".toString();
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
                //do1();
            }
            if (abc5.contains("Opieńka miodowa")) {
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
            }
            if (abc5.contains("Opieńka ciemna")) {
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
            }
            if (abc5.contains("Opieńka bezpierścieniowa")) {
                TempListViewClickedValue = "Opieńka bezpierścieniowa Armillaria tabascens" + "\n" + "jako Opieńka nietrwała".toString();
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
            }
            if (abc5.contains("Pisakowirec modrzak")) {
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
            }
            if (abc5.contains("Piaskowiec kasztanowaty")) {
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
            }
            if (abc5.contains("Pieczarka leśna")) {
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
            }
            if (abc5.contains("Lejkowiec dęty")) {
                TempListViewClickedValue = "Lejkowiec dęty Craterellus cornucopioides".toString();
                TempListViewClickedValue2 = "Owocnik lejkowaty do trąbkowatego, pusty do spodu; 4-13 cm wysokości i 2-5 cm średnicy; cienkomięsisty; brzeg wywinięty, pofałdowany; strona wewnętrzna czarna, czarnobrązowa, łuseczkowato-gruczołkowata, natomiast strona zewnętrzna z hymenoforem jest szara do niebieskoszarej, gładka, pomarszczona i pofałdowana, z wiekiem biało oprószona przez zarodniki. \n" +
                        "\n" +
                        "Miąższ - cienki, szarobrązowy, czarniawy, kruchy; zapach aromatyczny, przyjemny; smak łagodny. \n" +
                        "\n" +
                        "Występuje często. Owocniki wyrastają od lata do jesieni, zwykle w dużych grupach składających się z pozrastanych ze sobą owocników, w lasach liściastych, często pod bukami. \n" +
                        "\n" +
                        "Zastosowanie - jadalny. \n".toString();
                qwe2 = R.drawable.detylejbig;
            }
            if (abc5.contains("Pieprznik szary")) {
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
            }
            if (abc5.contains("Piestrzyca zatokowa")) {
                TempListViewClickedValue = "Piestrzyca zatokowa Helvella lacunosa".toString();
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
            }
            if (abc5.contains("Piestrzyca kędzierzawa")) {
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
                //do1();
            }
            if (abc5.contains("Purchawka oczkowana")) {
                TempListViewClickedValue = "Purchawka oczkowata Calvatia utriformis" + "\n" + "jako czasznica oczkowata".toString();
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
            }
            if (abc5.contains("Szyszkowiec łuskowaty")) {
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
            }
            if (abc5.contains("Siedzeń sosnowy")) {
                TempListViewClickedValue = "Siedzuń sosnowy Sparassis crispa".toString();
                TempListViewClickedValue2 = "Owocnik duży; nieregularnie kulisty, elipsoidalny; 10-30 cm szerokości i 10-15 cm wysokości; składa się z krótkiego trzonu, od którego odchodzą liczne, gęsto ułożone odgałęzienia zakończone płaskimi, zaokrąglonymi, łopatkami o gładkiej powierzchni; barwa listków kremowa, z czasem ciemnieją do żółtawej, ochrowej, a zakończenia brązowieją. \n" +
                        "\n" +
                        "Miąższ białawy, bardzo łamliwy, woskowaty; zapach przyjemny; smak łagodny. \n" +
                        "\n" +
                        "Występuje nieczęsto, pojedynczo, od lipca do października, u podstawy drzew iglastych, zazwyczaj sosny, rzadziej świerka. \n" +
                        "\n" +
                        "Zastosowanie - jadalny. \n".toString();
                qwe = R.drawable.debowy;
                qwe2 = R.drawable.sosnowysiebig;
                list1 = "Szmaciak dębowy Sparassis laminosa,".toString();
                list2 = "jest białawy, słomiastożółty;";
                list13 = "wyrastający na korzeniach jodeł.";
                list3 = "Szmaciak jodłowy Sparassis nemecii,";
                qwe3 = R.drawable.jodlowyszm;
            }
            if (abc5.contains("Piestrzenica kasztanowata")) {
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
                //do1();
            }
            if (abc5.contains("Wodnicha modrzewiowa")) {
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
                //do1();
            }
            if (abc5.contains("Zasłonak purpurowoblaszkowy")) {
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
            }
            if (abc5.contains("Lakówka pospolita")) {
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
                // do1();

            }
            imgbig1.setImageResource(qwe2);
            textview.setText(TempListViewClickedValue);
            if (TempHolder3 != "") {
                textview3.setText(TempListViewClickedValue3);

            }
            if (TempHolder3 == "") {
                textview3.setVisibility(View.GONE);
            }
            textview2.setText(TempListViewClickedValue2);
            textview4.setText(TempListViewClickedValue4);

            qimageView2.setImageResource(qwe);
            qtextView2.setText(list1);
            qtextView22.setText(list2);

            qimageView3.setImageResource(qwe3);
            qtextView3.setText(list3);
            qtextView23.setText(list13);

            qimageView4.setImageResource(qwe4);
            qtextView4.setText(list4);
            qtextView24.setText(list14);

            qimageView5.setImageResource(qwe5);
            qtextView5.setText(list5);
            qtextView25.setText(list15);

            if (pierwszy4.contains("error"))
            {
                qimageView5.setVisibility(View.GONE);
                qtextView5.setVisibility(View.GONE);
                qtextView25.setVisibility(View.GONE);
            }

            if (pierwszy3.contains("error"))
            {
                qimageView4.setVisibility(View.GONE);
                qtextView4.setVisibility(View.GONE);
                qtextView24.setVisibility(View.GONE);

                qimageView5.setVisibility(View.GONE);
                qtextView5.setVisibility(View.GONE);
                qtextView25.setVisibility(View.GONE);
            }
            if (pierwszy2.contains("error"))
            {
                qimageView4.setVisibility(View.GONE);
                qtextView4.setVisibility(View.GONE);
                qtextView24.setVisibility(View.GONE);

                qimageView5.setVisibility(View.GONE);
                qtextView5.setVisibility(View.GONE);
                qtextView25.setVisibility(View.GONE);

                qimageView3.setVisibility(View.GONE);
                qtextView3.setVisibility(View.GONE);
                qtextView23.setVisibility(View.GONE);
            }
            if (pierwszy.contains("error"))
            {
                qimageView2.setVisibility(View.GONE);
                qtextView2.setVisibility(View.GONE);
                qtextView22.setVisibility(View.GONE);

                qimageView4.setVisibility(View.GONE);
                qtextView4.setVisibility(View.GONE);
                qtextView24.setVisibility(View.GONE);

                qimageView5.setVisibility(View.GONE);
                qtextView5.setVisibility(View.GONE);
                qtextView25.setVisibility(View.GONE);

                qimageView3.setVisibility(View.GONE);
                qtextView3.setVisibility(View.GONE);
                qtextView23.setVisibility(View.GONE);


                textview4.setVisibility(View.GONE);
            }
            if ((numerek==8)||(numerek==19)||(numerek==21)||(numerek==28)||(numerek==47)||(numerek==50)||(numerek==56)||(numerek==61)||(numerek==62)||(numerek==63)||(numerek==65)||(numerek==70)||(numerek==71)||(numerek==81)||(numerek==82)||(numerek==83)||(numerek==84)||(numerek==85)||(numerek==87)||(numerek==97)||(numerek==98)||(numerek==102)||(numerek==110)||(numerek==113)||(numerek==117)||(numerek==122)||(numerek==138)||(numerek==144)||(numerek==150)||(numerek==153)||(numerek==167)||(numerek==170)||(numerek==175)||(numerek==182)||(numerek==185)||(numerek==201)){
                textview4.setVisibility(View.GONE);
                qimageView2.setVisibility(View.GONE);
                qtextView2.setVisibility(View.GONE);
                qtextView22.setVisibility(View.GONE);
            }
            //kedziezawa
        }
    }

    }