package pl.cba.radeckiuczony.mushroomer;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static pl.cba.radeckiuczony.mushroomer.SQLHelper.TABLE_QUESTION;

public class SearchingActivity extends AppCompatActivity {

   Button bn;
   SQLHelper ps;
    String queryfinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searching);

        bn = (Button)findViewById(R.id.dane);

        ps = new SQLHelper(this);
        ps.wstawdane("Boczniak ostrygowaty", "def1", "nic", "blaszki", "lisc");
        ps.wstawdane("Borowiec dęty", "t10", "nic", "blaszki", "iglasty");
        ps.wstawdane("Borowik brzozowy", "t1", "nic", "pory", "lisc");
        ps.wstawdane("Borowik ceglastopory", "t1", "nic", "pory", "iglasty");
        ps.wstawdane("Borowik grubotrzonowy", "t1", "nic", "pory", "mieszany");
        ps.wstawdane("Borowik kasztanowy", "t1", "nic", "pory", "mieszany");
        ps.wstawdane("Borowik omglony", "t1", "nic", "pory", "mieszany");
        ps.wstawdane("Borowik płowy", "t1", "nic", "pory", "lisc");
        ps.wstawdane("Borowik ponury", "t1", "nic", "pory", "mieszany");
        ps.wstawdane("Borowik purpurowy", "t1", "nic", "pory", "lisc");
        ps.wstawdane("Borowik sosnowy", "t1", "nic", "pory", "iglasty");
        ps.wstawdane("Borowik szlachetny", "t1", "nic", "pory", "mieszany");
        ps.wstawdane("Borowik usiatkowany", "t1", "nic", "pory", "lisc");
        ps.wstawdane("Borowik zajęczy", "t1", "nic", "pory", "mieszany");
        ps.wstawdane("Borowik złotawy", "t1", "nic", "pory", "mieszany");
        ps.wstawdane("Borowik żółtobrązowy", "t1", "nic", "pory", "mieszany");
        ps.wstawdane("Bruzdniczek największy", "t7", "nic", "blaszki", "mieszany");
        ps.wstawdane("Buławka obcięta", "t5", "nic", "nic", "iglasty");
        ps.wstawdane("Czasznica olbrzymia", "def4", "nic", "nic", "laka");
        ps.wstawdane("Czernidłak błyszczący", "t9", "nic", "blaszki", "mieszany");
        ps.wstawdane("Czernidłak pospolity", "t9", "nic", "blaszki", "laka");
        ps.wstawdane("Czernidłak pstry", "t9", "nic", "blaszki", "mieszany");
        ps.wstawdane("Czubajeczka brązowoczerwonawa", "t2", "piers", "blaszki", "laka");
        ps.wstawdane("Czubajeczka cuchnąca", "t2", "piers", "blaszki", "mieszany");
        ps.wstawdane("Czubajka czerwieniejąca", "t2", "piers", "blaszki", "laka");
        ps.wstawdane("Czubajka kania", "t2", "piers", "blaszki", "laka");
        ps.wstawdane("Długotrzonka popielata", "t4", "nic", "nic", "lisc");
        ps.wstawdane("Dwupierścieniak cesarski", "def4", "nic", "blaszki", "iglasty");
        ps.wstawdane("Dzieżka pomarańczowa", "t5", "nic", "nic", "laka");
        ps.wstawdane("Dzwonkówka trująca", "t10", "nic", "blaszki", "lisc");
        ps.wstawdane("Galaretek kolczasty", "def1", "nic", "nic", "iglasty");
        ps.wstawdane("Koralówka czerwonowierzchołkowa", "def2", "nic", "nic", "lisc");
        ps.wstawdane("Gąska biaława", "t10", "nic", "blaszki", "lisc");
        ps.wstawdane("Gąska mydlana", "t10", "nic", "blaszki", "mieszany");
        ps.wstawdane("Gąska niekształtna", "t10", "nic", "blaszki", "iglasty");
        ps.wstawdane("Gąska ostra", "t10", "nic", "blaszki", "mieszany");
        ps.wstawdane("Gąska pieprzna", "t10", "nic", "blaszki", "iglasty");
        ps.wstawdane("Gąska siarkowa", "t10", "nic", "blaszki", "iglasty");
        ps.wstawdane("Gąska szerokoblaszkowa", "t10", "nic", "blaszki", "mieszany");
        ps.wstawdane("Gąska zielonka", "t10", "nic", "blaszki", "iglasty");
        ps.wstawdane("Gąska żółtobrunatna", "t10", "nic", "blaszki", "mieszany");
        ps.wstawdane("Gąsówka dwubarwna", "t1", "nic", "blaszki", "laka");
        ps.wstawdane("Gąsówka fioletowawa", "t1", "nic", "blaszki", "mieszany");
        ps.wstawdane("Gąsówka płowa", "t10", "nic", "blaszki", "mieszany");
        ps.wstawdane("Gołąbek białozielonawy", "t10", "nic", "blaszki", "mieszany");
        ps.wstawdane("Gołąbek błotny", "t10", "nic", "blaszki", "iglasty");
        ps.wstawdane("Gołąbek brzozowy", "t10", "nic", "blaszki", "lisc");
        ps.wstawdane("Gołąbek cukrówka", "t10", "nic", "blaszki", "mieszany");
        ps.wstawdane("Gołąbek jasnożółty", "t10", "nic", "blaszki", "mieszany");
        ps.wstawdane("Gołąbek krwisty", "t10", "nic", "blaszki", "mieszany");
        ps.wstawdane("Gołąbek kunowy", "t10", "nic", "blaszki", "iglasty");
        ps.wstawdane("Gołąbek lazurowy", "t10", "nic", "blaszki", "iglasty");
        ps.wstawdane("Gołąbek płowiejący", "t10", "nic", "blaszki", "iglasty");
        ps.wstawdane("Gołąbek słodkawy", "t10", "nic", "blaszki", "iglasty");
        ps.wstawdane("Gołąbek smaczny", "t10", "nic", "blaszki", "mieszany");
        ps.wstawdane("Gołąbek śliczny", "t10", "nic", "blaszki", "mieszany");
        ps.wstawdane("Gołąbek winnoczerwony", "t10", "nic", "blaszki", "iglasty");
        ps.wstawdane("Gołąbek wyborny", "t10", "nic", "blaszki", "mieszany");
        ps.wstawdane("Gołąbek zielonawofioletowy", "t10", "nic", "blaszki", "iglasty");
        ps.wstawdane("Gołąbek zielonawy", "t10", "nic", "blaszki", "mieszany");
        ps.wstawdane("Gołąbek złotawy", "t10", "nic", "blaszki", "mieszany");
        ps.wstawdane("Goryczak purpurowozarodnikowy", "t1", "nic", "pory", "mieszany");
        ps.wstawdane("Goryczak żółciowy", "t1", "nic", "pory", "iglasty");
        ps.wstawdane("Goździeniec fioletowy", "def2", "nic", "nic", "mieszany");
        ps.wstawdane("Goździeniec gliniasty", "def2", "nic", "nic", "lisc");
        ps.wstawdane("Goździeńczyk grzebieniasty", "def2", "nic", "nic", "mieszany");
        ps.wstawdane("Goździeńczyk pomarszczony", "def2", "nic", "nic", "mieszany");
        ps.wstawdane("Goździeńczyk popielaty", "def2", "nic", "nic", "mieszany");
        ps.wstawdane("Grzybówka różowa", "t10", "nic", "blaszki", "mieszany");
        ps.wstawdane("Grzybówka ząbkowana", "t7", "nic", "blaszki", "lisc");
        ps.wstawdane("Hełmówka błotna", "t7", "nic", "blaszki", "mieszany");
        ps.wstawdane("Hełmówka jadowita", "t7", "nic", "blaszki", "iglasty");
        ps.wstawdane("Kępkowiec białawy", "t8", "nic", "blaszki", "laka");
        ps.wstawdane("Kępkowiec ciemnoszary", "t8", "nic", "blaszki", "lisc");
        ps.wstawdane("Kępkowiec jasnobrązowy", "t8", "nic", "blaszki", "mieszany");
        ps.wstawdane("Klejek lepki", "t1", "nic", "blaszki", "iglasty");
        ps.wstawdane("Klejówka świerkowa", "t1", "nic", "blaszki", "mieszany");
        ps.wstawdane("Kolczak obłączasty", "t5", "nic", "blaszki", "iglasty");
        ps.wstawdane("Kołpaczek mierzwiowy", "t9", "nic", "blaszki", "laka");
        ps.wstawdane("Kopułek łąkowy", "t8", "nic", "blaszki", "laka");
        ps.wstawdane("Kopułek śnieżny", "t8", "nic", "blaszki", "lisc");
        ps.wstawdane("Koralówka gruba", "def2", "nic", "nic", "iglasty");
        ps.wstawdane("Koralówka strojna", "def2", "nic", "nic", "lisc");
        ps.wstawdane("Koralówka złocista", "def2", "nic", "nic", "mieszany");
        ps.wstawdane("Koronica ozdobna", "def2", "nic", "nic", "mieszany");
        ps.wstawdane("Koźlarz babka", "t1", "nic", "pory", "mieszany");
        ps.wstawdane("Koźlarz białawy", "t1", "nic", "pory", "lisc");
        ps.wstawdane("Koźlarz dębowy", "t1", "nic", "pory", "lisc");
        ps.wstawdane("Koźlarz grabowy", "t1", "nic", "pory", "lisc");
        ps.wstawdane("Koźlarz pomarańczowożółty", "t1", "nic", "pory", "lisc");
        ps.wstawdane("Koźlarz świerkowy", "t1", "nic", "pory", "iglasty");
        ps.wstawdane("Koźlarz topolowy", "t1", "nic", "pory", "lisc");
        ps.wstawdane("Krowiak podwinięty", "t5", "nic", "blaszki", "mieszany");
        ps.wstawdane("Kurzawka czerniejąca", "def4", "nic", "nic", "laka");
        ps.wstawdane("Lakówka ametystowa", "t9", "nic", "blaszki", "laka");
        ps.wstawdane("Lakówka pospolita", "t9", "nic", "blaszki", "mieszany");
        ps.wstawdane("Lejkoporek olszowy", "t5", "nic", "pory", "lisc");
        ps.wstawdane("Lejkowiec dęty", "t5", "nic", "nic", "lisc");
        ps.wstawdane("Lejkówka biaława", "t9", "nic", "blaszki", "laka");
        ps.wstawdane("Lejkówka buławotrzonowa", "t9", "nic", "blaszki", "iglasty");
        ps.wstawdane("Lejkówka liściowa", "t9", "nic", "blaszki", "mieszany");
        ps.wstawdane("Lejkówka śnieżysta", "t8", "nic", "blaszki", "iglasty");
        ps.wstawdane("Lejkówka zielonawa", "t10", "nic", "blaszki", "mieszany");
        ps.wstawdane("Lisówka pomarańczowa", "t5", "nic", "blaszki", "mieszany");
        ps.wstawdane("Łopatnica żółtawa", "t4", "nic", "nic", "iglasty");
        ps.wstawdane("Łuskowiec jeleni", "t1", "nic", "blaszki", "mieszany");
        ps.wstawdane("Łuszczak zmienny", "t7", "nic", "blaszki", "mieszany");
        ps.wstawdane("Łycznik późny", "def1", "nic", "blaszki", "lisc");
        ps.wstawdane("Łysak wspaniały", "t8", "nic", "blaszki", "lisc");
        ps.wstawdane("Łysiczka łuskowata", "t7", "nic", "blaszki", "mieszany");
        ps.wstawdane("Łysostopek pospolity", "t7", "nic", "blaszki", "mieszany");
        ps.wstawdane("Łysostopek pozrastany", "t7", "nic", "blaszki", "mieszany");
        ps.wstawdane("Łysostopek wrzecionowatotrzonowy", "t7", "nic", "blaszki", "lisc");
        ps.wstawdane("Majówka wiosenna", "t1", "nic", "blaszki", "laka");
        ps.wstawdane("Maślak pstry", "t1", "nic", "pory", "iglasty");
        ps.wstawdane("Maślak sitarz", "t1", "nic", "pory", "iglasty");
        ps.wstawdane("Maślak szary", "t1", "nic", "pory", "iglasty");
        ps.wstawdane("Maślak ziarnisty", "t1", "nic", "pory", "iglasty");
        ps.wstawdane("Maślak żółty", "t1", "nic", "pory", "mieszany");
        ps.wstawdane("Maślanka łagodna", "t7", "nic", "blaszki", "iglasty");
        ps.wstawdane("Maślanka wiązkowa", "t7", "nic", "blaszki", "lisc");
        ps.wstawdane("Mitrówka półwolna", "t3", "nic", "nic", "lisc");
        ps.wstawdane("Mleczaj bezstrefowy", "t10", "nic", "blaszki", "lisc");
        ps.wstawdane("Mleczaj bladawy", "t10", "nic", "blaszki", "lisc");
        ps.wstawdane("Mleczaj dołkowany", "t10", "nic", "blaszki", "iglasty");
        ps.wstawdane("Mleczaj jodłowy", "t10", "nic", "blaszki", "iglasty");
        ps.wstawdane("Mleczaj kamforowy", "t10", "nic", "blaszki", "mieszany");
        ps.wstawdane("Mleczaj płowy", "t10", "nic", "blaszki", "iglasty");
        ps.wstawdane("Mleczaj rydz", "t10", "nic", "blaszki", "iglasty");
        ps.wstawdane("Mleczaj świerkowy", "t10", "nic", "blaszki", "iglasty");
        ps.wstawdane("Mleczaj wełnianka", "t10", "nic", "blaszki", "mieszany");
        ps.wstawdane("Monetnica maślana", "t7", "nic", "blaszki", "mieszany");
        ps.wstawdane("Muchomor cesarski", "t6", "dwa", "blaszki", "lisc");
        ps.wstawdane("Muchomor cytrynowy", "t6", "dwa", "blaszki", "mieszany");
        ps.wstawdane("Muchomor czerwieniejący", "t6", "dwa", "blaszki", "mieszany");
        ps.wstawdane("Muchomor czerwony", "t6", "dwa", "blaszki", "mieszany");
        ps.wstawdane("Muchomor jadowity", "t6", "dwa", "blaszki", "mieszany");
        ps.wstawdane("Muchomor oliwkowy", "t6", "dwa", "blaszki", "mieszany");
        ps.wstawdane("Muchomor plamisty", "t6", "dwa", "blaszki", "mieszany");
        ps.wstawdane("Muchomor rdzawobrązowy", "t6", "dwa", "blaszki", "mieszany");
        ps.wstawdane("Muchomor sromotnikowy", "t6", "dwa", "blaszki", "mieszany");
        ps.wstawdane("Muchomor  szarawy", "t6", "dwa", "blaszki", "mieszany");
        ps.wstawdane("Muchomor szyszkowaty", "t6", "dwa", "blaszki", "mieszany");
        ps.wstawdane("Naparstniczka stożkowata", "t9", "nic", "nic", "mieszany");
        ps.wstawdane("Naziemek białawy", "def2", "nic", "pory", "iglasty");
        ps.wstawdane("Naziemek ceglasty", "def2", "nic", "pory", "mieszany");
        ps.wstawdane("Opieńka bezpierścieniowa", "t7", "nic", "blaszki", "lisc");
        ps.wstawdane("Opieńka miodowa", "t7", "nic", "blaszki", "lisc");
        ps.wstawdane("Opieńka ciemna", "t7", "nic", "blaszki", "mieszany");
        ps.wstawdane("Ozorek dębowy", "def1", "nic", "nic", "lisc");
        ps.wstawdane("Piaskowiec kasztanowaty", "t1", "nic", "pory", "mieszany");
        ps.wstawdane("Piaskowiec modrzak", "t1", "nic", "pory", "mieszany");
        ps.wstawdane("Pieczareczka amerykańska", "t2", "nic", "blaszki", "laka");
        ps.wstawdane("Pieczarka krótkotrzonowa", "t2", "nic", "blaszki", "laka");
        ps.wstawdane("Pieczarka leśna", "t2", "nic", "blaszki", "iglasty");
        ps.wstawdane("Pieczarka łąkowa", "def4", "nic", "blaszki", "laka");
        ps.wstawdane("Pieprznik jadalny", "t5", "nic", "nic", "mieszany");
        ps.wstawdane("Pieprznik szary", "t5", "nic", "nic", "lisc");
        ps.wstawdane("Pieprznik trąbkowy", "t5", "nic", "nic", "laka");
        ps.wstawdane("Piestrak jadalny", "def3", "nic", "nic", "mieszany");
        ps.wstawdane("Piestrzenica infułowata", "t4", "nic", "nic", "iglasty");
        ps.wstawdane("Piestrzenica kasztanowata", "t4", "nic", "nic", "iglasty");
        ps.wstawdane("Piestrzyca kędzierzawa", "t4", "nic", "nic", "laka");
        ps.wstawdane("Piestrzyca zatokowata", "t4", "nic", "nic", "lisc");
        ps.wstawdane("Płachetka kołpakowata", "t10", "nic", "blaszki", "mieszany");
        ps.wstawdane("Płomiennica zimowa", "t7", "nic", "blaszki", "lisc");
        ps.wstawdane("Płomykówka galaretowata", "t5", "nic", "nic", "mieszany");
        ps.wstawdane("Podgrzybek czerwonawy", "t1", "nic", "pory", "lisc");
        ps.wstawdane("Podgrzybek tęgoskórowy", "t1", "nic", "pory", "mieszany");
        ps.wstawdane("Ponurnik aksamitny", "t1", "nic", "blaszki", "iglasty");
        ps.wstawdane("Przyczepka falista", "t4", "nic", "nic", "laka");
        ps.wstawdane("Purchaweczka spłaszczona", "def4", "nic", "nic", "laka");
        ps.wstawdane("Purchawka oczkowata", "def4", "nic", "nic", "laka");
        ps.wstawdane("Sarniak dachówkowaty", "t8", "nic", "nic", "iglasty");
        ps.wstawdane("Siatkolist maczugowaty", "t5", "nic", "nic", "mieszany");
        ps.wstawdane("Siedzuń dębowy", "def2", "nic", "nic", "lisc");
        ps.wstawdane("Siedzuń sosnowy", "def2", "nic", "nic", "iglasty");
        ps.wstawdane("Smardz jadalny", "t3", "nic", "nic", "laka");
        ps.wstawdane("Soplówka bukowa", "def2", "nic", "nic", "lisc");
        ps.wstawdane("Sromotnik smrodliwy", "t3", "nic", "nic", "laka");
        ps.wstawdane("Strzępiak ceglasty", "t9", "nic", "blaszki", "lisc");
        ps.wstawdane("Szyszkowiec łuskowaty", "t10", "nic", "pory", "mieszany");
        ps.wstawdane("Tęgoskór cytrynowy", "def1", "nic", "nic", "iglasty");
        ps.wstawdane("Trufla letnia", "def3", "nic", "nic", "lisc");
        ps.wstawdane("Twardówka anyżkowa", "def2", "nic", "blaszki", "mieszany");
        ps.wstawdane("Twardzioszek przydrożny", "t7", "nic", "blaszki", "laka");
        ps.wstawdane("Uchówka ośla", "t4", "nic", "nic", "lisc");
        ps.wstawdane("Uszak bzowy", "def1", "nic", "nic", "lisc");
        ps.wstawdane("Wilgotnica karminowa", "t9", "nic", "blaszki", "laka");
        ps.wstawdane("Wilgotnica żółknąca", "t9", "nic", "blaszki", "laka");
        ps.wstawdane("Włośnianka musztardowa", "t10", "nic", "blaszki", "lisc");
        ps.wstawdane("Wodnicha biała", "t10", "nic", "blaszki", "lisc");
        ps.wstawdane("Wodnicha brunatnobiała", "t10", "nic", "blaszki", "iglasty");
        ps.wstawdane("Wodnicha gołąbkowa", "t10", "nic", "blaszki", "lisc");
        ps.wstawdane("Wodnicha modrzewiowa", "t10", "nic", "blaszki", "iglasty");
        ps.wstawdane("Wodnicha późna", "t10", "nic", "blaszki", "iglasty");
        ps.wstawdane("Zasłonak ceglastożółty", "t10", "nic", "blaszki", "iglasty");
        ps.wstawdane("Zasłonak kleisty", "t10", "nic", "blaszki", "iglasty");
        ps.wstawdane("Zasłonak krwisty", "t10", "nic", "blaszki", "iglasty");
        ps.wstawdane("Zasłonak purpurowoblaszkowy", "t10", "nic", "blaszki", "iglasty");
        ps.wstawdane("Zasłonak rudawy", "t10", "nic", "blaszki", "iglasty");
        ps.wstawdane("Zasłonak wonny", "t10", "nic", "blaszki", "iglasty");
        ps.wstawdane("Żagiew łuskowata", "def1", "nic", "nic", "lisc");
        String jedynka = getIntent().getStringExtra("jedynka");
        String trojka = getIntent().getStringExtra("trojka");
        String czworka = getIntent().getStringExtra("czworka");
        String piatka = getIntent().getStringExtra("piatka");
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP)
        {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }

        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = getIntent().getIntExtra("id", 0);
                int id1 = getIntent().getIntExtra("id1", 0);
                int id2 = getIntent().getIntExtra("id2", 0);
                int id3 = getIntent().getIntExtra("id3", 0);
                int id4 = getIntent().getIntExtra("id4", 0);

                if((id==R.drawable.t1)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_IG, "t1");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_IG);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_IG, "t2");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_IG);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_IG, "t3");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_IG);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_IG, "t4");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_IG);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_IG, "t5");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_IG);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_IG, "t6");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_IG);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_IG, "t7");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_IG);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_IG, "t8");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_IG);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_IG, "t9");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_IG);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_IG, "t10");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_IG);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_IG, "def1");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_IG);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_IG, "def2");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_IG);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_IG, "def3");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_IG);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_IG, "def4");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_IG);
                }


                if((id==R.drawable.t1)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_IG, "t1");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_IG);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_IG, "t2");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_IG);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_IG, "t3");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_IG);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_IG, "t4");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_IG);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_IG, "t5");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_IG);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_IG, "t6");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_IG);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_IG, "t7");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_IG);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_IG, "t8");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_IG);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_IG, "t9");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_IG);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_IG, "t10");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_IG);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_IG, "def1");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_IG);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_IG, "def2");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_IG);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_IG, "def3");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_IG);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_IG, "def4");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_IG);
                }


                if((id==R.drawable.t1)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_IG, "t1");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_IG);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_IG, "t2");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_IG);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_IG, "t3");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_IG);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_IG, "t4");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_IG);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_IG, "t5");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_IG);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_IG, "t6");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_IG);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_IG, "t7");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_IG);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_IG, "t8");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_IG);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_IG, "t9");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_IG);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_IG, "t10");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_IG);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_IG, "def1");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_IG);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_IG, "def2");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_IG);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_IG, "def3");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_IG);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_IG, "def4");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_IG);
                }


                if((id==R.drawable.t1)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_IG, "t1");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_IG);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_IG, "t2");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_IG);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_IG, "t3");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_IG);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_IG, "t4");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_IG);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_IG, "t5");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_IG);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_IG, "t6");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_IG);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_IG, "t7");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_IG);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_IG, "t8");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_IG);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_IG, "t9");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_IG);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_IG, "t10");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_IG);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_IG, "def1");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_IG);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_IG, "def2");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_IG);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_IG, "def3");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_IG);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_IG, "def4");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_IG);
                }


                if((id==R.drawable.t1)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_IG, "t1");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_IG);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_IG, "t2");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_IG);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_IG, "t3");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_IG);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {



                    queryfinal = String.format(Queries.QUERY_POCH_POR_IG, "t4");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_IG);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_IG, "t5");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_IG);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_IG, "t6");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_IG);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_IG, "t7");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_IG);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_IG, "t8");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_IG);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_IG, "t9");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_IG);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_IG, "t10");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_IG);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_IG, "def1");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_IG);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_IG, "def2");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_IG);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_IG, "def3");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_IG);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_IG, "def4");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_IG);
                }


                if((id==R.drawable.t1)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_IG, "t1");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_IG);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_IG, "t2");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_IG);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_IG, "t3");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_IG);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_IG, "t4");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_IG);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_IG, "t5");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_IG);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_IG, "t6");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_IG);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_IG, "t7");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_IG);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_IG, "t8");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_IG);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_IG, "t9");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_IG);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_IG, "t10");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_IG);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_IG, "def1");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_IG);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_IG, "def2");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_IG);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_IG, "def3");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_IG);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_IG, "def4");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_IG);
                }

                if((id==R.drawable.t1)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_IG, "t1");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_IG);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_IG, "t2");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_IG);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_IG, "t3");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_IG);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_IG, "t4");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_IG);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_IG, "t5");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_IG);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_IG, "t6");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_IG);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_IG, "t7");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_IG);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_IG, "t8");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_IG);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_IG, "t9");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_IG);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_IG, "t10");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_IG);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_IG, "def1");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_IG);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_IG, "def2");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_IG);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_IG, "def3");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_IG);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_IG, "def4");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_IG);
                }

                if((id==R.drawable.t1)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_IG, "t1");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_IG);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_IG, "t2");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_IG);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_IG, "t3");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_IG);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_IG, "t4");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_IG);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_IG, "t5");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_IG);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_IG, "t6");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_IG);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_IG, "t7");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_IG);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_IG, "t8");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_IG);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_IG, "t9");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_IG);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_IG, "t10");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_IG);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_IG, "def1");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_IG);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_IG, "def2");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_IG);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_IG, "def3");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_IG);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_IG, "def4");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_IG);
                }

                if((id==R.drawable.t1)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_IG, "t1");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_IG);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_IG, "t2");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_IG);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_IG, "t3");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_IG);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_IG, "t4");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_IG);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_IG, "t5");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_IG);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_IG, "t6");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_IG);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_IG, "t7");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_IG);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_IG, "t8");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_IG);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_IG, "t9");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_IG);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_IG, "t10");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_IG);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_IG, "def1");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_IG);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_IG, "def2");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_IG);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_IG, "def3");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_IG);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_IG, "def4");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_IG);
                }

                if((id==R.drawable.t1)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_IG, "t1");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_IG);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_IG, "t2");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_IG);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_IG, "t3");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_IG);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_IG, "t4");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_IG);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_IG, "t5");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_IG);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_IG, "t6");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_IG);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_IG, "t7");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_IG);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_IG, "t8");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_IG);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_IG, "t9");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_IG);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_IG, "t10");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_IG);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_IG, "def1");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_IG);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_IG, "def2");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_IG);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_IG, "def3");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_IG);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_IG, "def4");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_IG);
                }

                if((id==R.drawable.t1)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_IG, "t1");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_IG);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_IG, "t2");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_IG);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_IG, "t3");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_IG);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_IG, "t4");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_IG);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_IG, "t5");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_IG);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_IG, "t6");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_IG);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_IG, "t7");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_IG);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_IG, "t8");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_IG);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_IG, "t9");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_IG);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_IG, "t10");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_IG);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_IG, "def1");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_IG);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_IG, "def2");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_IG);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_IG, "def3");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_IG);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_IG, "def4");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_IG);
                }

                if((id==R.drawable.t1)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_IG, "t1");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_IG);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_IG, "t2");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_IG);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_IG, "t3");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_IG);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_IG, "t4");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_IG);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_IG, "t5");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_IG);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_IG, "t6");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_IG);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_IG, "t7");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_IG);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_IG, "t8");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_IG);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_IG, "t9");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_IG);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_IG, "t10");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_IG);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_IG, "def1");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_IG);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_IG, "def2");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_IG);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_IG, "def3");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_IG);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.iglasty)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_IG, "def4");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_IG);
                }

                if((id==R.drawable.t1)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_LISC, "t1");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_LISC);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_LISC, "t2");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_LISC);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_LISC, "t3");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_LISC);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_LISC, "t4");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_LISC);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_LISC, "t5");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_LISC);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_LISC, "t6");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_LISC);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_LISC, "t7");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_LISC);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_LISC, "t8");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_LISC);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_LISC, "t9");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_LISC);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_LISC, "t10");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_LISC);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_LISC, "def1");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_LISC);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_LISC, "def2");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_LISC);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_LISC, "def3");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_LISC);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_LISC, "def4");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_LISC);
                }


                if((id==R.drawable.t1)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_LISC, "t1");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_LISC);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_LISC, "t2");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_LISC);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_LISC, "t3");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_LISC);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_LISC, "t4");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_LISC);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_LISC, "t5");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_LISC);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_LISC, "t6");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_LISC);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_LISC, "t7");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_LISC);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_LISC, "t8");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_LISC);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_LISC, "t9");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_LISC);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_LISC, "t10");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_LISC);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_LISC, "def1");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_LISC);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_LISC, "def2");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_LISC);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_LISC, "def3");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_LISC);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_LISC, "def4");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_LISC);
                }


                if((id==R.drawable.t1)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_LISC, "t1");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_LISC);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_LISC, "t2");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_LISC);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_LISC, "t3");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_LISC);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_LISC, "t4");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_LISC);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_LISC, "t5");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_LISC);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_LISC, "t6");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_LISC);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_LISC, "t7");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_LISC);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_LISC, "t8");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_LISC);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_LISC, "t9");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_LISC);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_LISC, "t10");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_LISC);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_LISC, "def1");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_LISC);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_LISC, "def2");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_LISC);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_LISC, "def3");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_LISC);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_LISC, "def4");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_LISC);
                }


                if((id==R.drawable.t1)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_LISC, "t1");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_LISC);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_LISC, "t2");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_LISC);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_LISC, "t3");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_LISC);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_LISC, "t4");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_LISC);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_LISC, "t5");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_LISC);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_LISC, "t6");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_LISC);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_LISC, "t7");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_LISC);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_LISC, "t8");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_LISC);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_LISC, "t9");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_LISC);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_LISC, "t10");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_LISC);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_LISC, "def1");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_LISC);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_LISC, "def2");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_LISC);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_LISC, "def3");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_LISC);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_LISC, "def4");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_LISC);
                }


                if((id==R.drawable.t1)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_LISC, "t1");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_LISC);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_LISC, "t2");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_LISC);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_LISC, "t3");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_LISC);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_LISC, "t4");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_LISC);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_LISC, "t5");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_LISC);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_LISC, "t6");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_LISC);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_LISC, "t7");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_LISC);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_LISC, "t8");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_LISC);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_LISC, "t9");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_LISC);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_LISC, "t10");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_LISC);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_LISC, "def1");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_LISC);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_LISC, "def2");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_LISC);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_LISC, "def3");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_LISC);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_LISC, "def4");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_LISC);
                }


                if((id==R.drawable.t1)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_LISC, "t1");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_LISC);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_LISC, "t2");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_LISC);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_LISC, "t3");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_LISC);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_LISC, "t4");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_LISC);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_LISC, "t5");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_LISC);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_LISC, "t6");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_LISC);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_LISC, "t7");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_LISC);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_LISC, "t8");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_LISC);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_LISC, "t9");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_LISC);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_LISC, "t10");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_LISC);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_LISC, "def1");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_LISC);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_LISC, "def2");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_LISC);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_LISC, "def3");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_LISC);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_LISC, "def4");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_LISC);
                }

                if((id==R.drawable.t1)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_LISC, "t1");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_LISC);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_LISC, "t2");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_LISC);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_LISC, "t3");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_LISC);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_LISC, "t4");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_LISC);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_LISC, "t5");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_LISC);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_LISC, "t6");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_LISC);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_LISC, "t7");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_LISC);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_LISC, "t8");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_LISC);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_LISC, "t9");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_LISC);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_LISC, "t10");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_LISC);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_LISC, "def1");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_LISC);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_LISC, "def2");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_LISC);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_LISC, "def3");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_LISC);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_LISC, "def4");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_LISC);
                }

                if((id==R.drawable.t1)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_LISC, "t1");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_LISC);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_LISC, "t2");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_LISC);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_LISC, "t3");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_LISC);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_LISC, "t4");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_LISC);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_LISC, "t5");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_LISC);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_LISC, "t6");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_LISC);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_LISC, "t7");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_LISC);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_LISC, "t8");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_LISC);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_LISC, "t9");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_LISC);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_LISC, "t10");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_LISC);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_LISC, "def1");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_LISC);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_LISC, "def2");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_LISC);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_LISC, "def3");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_LISC);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_LISC, "def4");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_LISC);
                }

                if((id==R.drawable.t1)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_LISC, "t1");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_LISC);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_LISC, "t2");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_LISC);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_LISC, "t3");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_LISC);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_LISC, "t4");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_LISC);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_LISC, "t5");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_LISC);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_LISC, "t6");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_LISC);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_LISC, "t7");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_LISC);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_LISC, "t8");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_LISC);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_LISC, "t9");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_LISC);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_LISC, "t10");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_LISC);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_LISC, "def1");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_LISC);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_LISC, "def2");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_LISC);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_LISC, "def3");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_LISC);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_LISC, "def4");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_LISC);
                }

                if((id==R.drawable.t1)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_LISC, "t1");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_LISC);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_LISC, "t2");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_LISC);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_LISC, "t3");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_LISC);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_LISC, "t4");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_LISC);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_LISC, "t5");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_LISC);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_LISC, "t6");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_LISC);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_LISC, "t7");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_LISC);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_LISC, "t8");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_LISC);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_LISC, "t9");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_LISC);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_LISC, "t10");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_LISC);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_LISC, "def1");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_LISC);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_LISC, "def2");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_LISC);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_LISC, "def3");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_LISC);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_LISC, "def4");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_LISC);
                }

                if((id==R.drawable.t1)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_LISC, "t1");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_LISC);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_LISC, "t2");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_LISC);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_LISC, "t3");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_LISC);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_LISC, "t4");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_LISC);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_LISC, "t5");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_LISC);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_LISC, "t6");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_LISC);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_LISC, "t7");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_LISC);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_LISC, "t8");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_LISC);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_LISC, "t9");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_LISC);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_LISC, "t10");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_LISC);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_LISC, "def1");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_LISC);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_LISC, "def2");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_LISC);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_LISC, "def3");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_LISC);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_LISC, "def4");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_LISC);
                }

                if((id==R.drawable.t1)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_LISC, "t1");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_LISC);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_LISC, "t2");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_LISC);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_LISC, "t3");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_LISC);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_LISC, "t4");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_LISC);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_LISC, "t5");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_LISC);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_LISC, "t6");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_LISC);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_LISC, "t7");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_LISC);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_LISC, "t8");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_LISC);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_LISC, "t9");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_LISC);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_LISC, "t10");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_LISC);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_LISC, "def1");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_LISC);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_LISC, "def2");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_LISC);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_LISC, "def3");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_LISC);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.lisc)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_LISC, "def4");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_LISC);
                }

                if((id==R.drawable.t1)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_MIESZANY, "t1");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_MIESZANY);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_MIESZANY, "t2");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_MIESZANY);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_MIESZANY, "t3");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_MIESZANY);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_MIESZANY, "t4");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_MIESZANY);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_MIESZANY, "t5");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_MIESZANY);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_MIESZANY, "t6");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_MIESZANY);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_MIESZANY, "t7");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_MIESZANY);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_MIESZANY, "t8");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_MIESZANY);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_MIESZANY, "t9");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_MIESZANY);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_MIESZANY, "t10");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_MIESZANY);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_MIESZANY, "def1");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_MIESZANY);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_MIESZANY, "def2");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_MIESZANY);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_MIESZANY, "def3");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_MIESZANY);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_MIESZANY, "def4");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_MIESZANY);
                }


                if((id==R.drawable.t1)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_MIESZANY, "t1");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_MIESZANY);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_MIESZANY, "t2");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_MIESZANY);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_MIESZANY, "t3");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_MIESZANY);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_MIESZANY, "t4");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_MIESZANY);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_MIESZANY, "t5");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_MIESZANY);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_MIESZANY, "t6");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_MIESZANY);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_MIESZANY, "t7");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_MIESZANY);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_MIESZANY, "t8");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_MIESZANY);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_MIESZANY, "t9");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_MIESZANY);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_MIESZANY, "t10");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_MIESZANY);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_MIESZANY, "def1");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_MIESZANY);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_MIESZANY, "def2");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_MIESZANY);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_MIESZANY, "def3");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_MIESZANY);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_MIESZANY, "def4");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_MIESZANY);
                }


                if((id==R.drawable.t1)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_MIESZANY, "t1");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_MIESZANY);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_MIESZANY, "t2");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_MIESZANY);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_MIESZANY, "t3");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_MIESZANY);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_MIESZANY, "t4");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_MIESZANY);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_MIESZANY, "t5");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_MIESZANY);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_MIESZANY, "t6");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_MIESZANY);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_MIESZANY, "t7");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_MIESZANY);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_MIESZANY, "t8");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_MIESZANY);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_MIESZANY, "t9");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_MIESZANY);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_MIESZANY, "t10");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_MIESZANY);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_MIESZANY, "def1");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_MIESZANY);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_MIESZANY, "def2");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_MIESZANY);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_MIESZANY, "def3");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_MIESZANY);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_MIESZANY, "def4");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_MIESZANY);
                }


                if((id==R.drawable.t1)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_MIESZANY, "t1");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_MIESZANY);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_MIESZANY, "t2");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_MIESZANY);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_MIESZANY, "t3");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_MIESZANY);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_MIESZANY, "t4");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_MIESZANY);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_MIESZANY, "t5");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_MIESZANY);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_MIESZANY, "t6");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_MIESZANY);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_MIESZANY, "t7");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_MIESZANY);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_MIESZANY, "t8");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_MIESZANY);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_MIESZANY, "t9");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_MIESZANY);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_MIESZANY, "t10");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_MIESZANY);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_MIESZANY, "def1");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_MIESZANY);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_MIESZANY, "def2");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_MIESZANY);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_MIESZANY, "def3");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_MIESZANY);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_MIESZANY, "def4");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_MIESZANY);
                }


                if((id==R.drawable.t1)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_MIESZANY, "t1");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_MIESZANY);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_MIESZANY, "t2");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_MIESZANY);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_MIESZANY, "t3");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_MIESZANY);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_MIESZANY, "t4");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_MIESZANY);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_MIESZANY, "t5");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_MIESZANY);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_MIESZANY, "t6");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_MIESZANY);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_MIESZANY, "t7");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_MIESZANY);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_MIESZANY, "t8");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_MIESZANY);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_MIESZANY, "t9");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_MIESZANY);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_MIESZANY, "t10");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_MIESZANY);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_MIESZANY, "def1");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_MIESZANY);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_MIESZANY, "def2");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_MIESZANY);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_MIESZANY, "def3");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_MIESZANY);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_MIESZANY, "def4");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_MIESZANY);
                }


                if((id==R.drawable.t1)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_MIESZANY, "t1");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_MIESZANY);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_MIESZANY, "t2");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_MIESZANY);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_MIESZANY, "t3");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_MIESZANY);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_MIESZANY, "t4");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_MIESZANY);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_MIESZANY, "t5");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_MIESZANY);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_MIESZANY, "t6");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_MIESZANY);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_MIESZANY, "t7");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_MIESZANY);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_MIESZANY, "t8");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_MIESZANY);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_MIESZANY, "t9");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_MIESZANY);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_MIESZANY, "t10");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_MIESZANY);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_MIESZANY, "def1");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_MIESZANY);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_MIESZANY, "def2");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_MIESZANY);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_MIESZANY, "def3");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_MIESZANY);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_MIESZANY, "def4");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_MIESZANY);
                }

                if((id==R.drawable.t1)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_MIESZANY, "t1");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_MIESZANY);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_MIESZANY, "t2");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_MIESZANY);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_MIESZANY, "t3");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_MIESZANY);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_MIESZANY, "t4");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_MIESZANY);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_MIESZANY, "t5");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_MIESZANY);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_MIESZANY, "t6");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_MIESZANY);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_MIESZANY, "t7");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_MIESZANY);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_MIESZANY, "t8");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_MIESZANY);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_MIESZANY, "t9");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_MIESZANY);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_MIESZANY, "t10");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_MIESZANY);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_MIESZANY, "def1");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_MIESZANY);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_MIESZANY, "def2");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_MIESZANY);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_MIESZANY, "def3");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_MIESZANY);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_MIESZANY, "def4");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_MIESZANY);
                }

                if((id==R.drawable.t1)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_MIESZANY, "t1");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_MIESZANY);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_MIESZANY, "t2");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_MIESZANY);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_MIESZANY, "t3");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_MIESZANY);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_MIESZANY, "t4");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_MIESZANY);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_MIESZANY, "t5");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_MIESZANY);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_MIESZANY, "t6");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_MIESZANY);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_MIESZANY, "t7");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_MIESZANY);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_MIESZANY, "t8");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_MIESZANY);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_MIESZANY, "t9");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_MIESZANY);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_MIESZANY, "t10");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_MIESZANY);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_MIESZANY, "def1");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_MIESZANY);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_MIESZANY, "def2");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_MIESZANY);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_MIESZANY, "def3");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_MIESZANY);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_MIESZANY, "def4");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_MIESZANY);
                }

                if((id==R.drawable.t1)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_MIESZANY, "t1");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_MIESZANY);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_MIESZANY, "t2");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_MIESZANY);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_MIESZANY, "t3");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_MIESZANY);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_MIESZANY, "t4");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_MIESZANY);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_MIESZANY, "t5");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_MIESZANY);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_MIESZANY, "t6");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_MIESZANY);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_MIESZANY, "t7");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_MIESZANY);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_MIESZANY, "t8");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_MIESZANY);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_MIESZANY, "t9");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_MIESZANY);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_MIESZANY, "t10");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_MIESZANY);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_MIESZANY, "def1");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_MIESZANY);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_MIESZANY, "def2");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_MIESZANY);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_MIESZANY, "def3");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_MIESZANY);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_MIESZANY, "def4");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_MIESZANY);
                }

                if((id==R.drawable.t1)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_MIESZANY, "t1");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_MIESZANY);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_MIESZANY, "t2");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_MIESZANY);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_MIESZANY, "t3");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_MIESZANY);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_MIESZANY, "t4");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_MIESZANY);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_MIESZANY, "t5");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_MIESZANY);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_MIESZANY, "t6");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_MIESZANY);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_MIESZANY, "t7");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_MIESZANY);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_MIESZANY, "t8");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_MIESZANY);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_MIESZANY, "t9");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_MIESZANY);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_MIESZANY, "t10");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_MIESZANY);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_MIESZANY, "def1");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_MIESZANY);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_MIESZANY, "def2");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_MIESZANY);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_MIESZANY, "def3");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_MIESZANY);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_MIESZANY, "def4");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_MIESZANY);
                }

                if((id==R.drawable.t1)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_MIESZANY, "t1");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_MIESZANY);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_MIESZANY, "t2");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_MIESZANY);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_MIESZANY, "t3");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_MIESZANY);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_MIESZANY, "t4");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_MIESZANY);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_MIESZANY, "t5");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_MIESZANY);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_MIESZANY, "t6");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_MIESZANY);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_MIESZANY, "t7");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_MIESZANY);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_MIESZANY, "t8");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_MIESZANY);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_MIESZANY, "t9");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_MIESZANY);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_MIESZANY, "t10");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_MIESZANY);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_MIESZANY, "def1");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_MIESZANY);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_MIESZANY, "def2");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_MIESZANY);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_MIESZANY, "def3");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_MIESZANY);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_MIESZANY, "def4");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_MIESZANY);
                }

                if((id==R.drawable.t1)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_MIESZANY, "t1");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_MIESZANY);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_MIESZANY, "t2");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_MIESZANY);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_MIESZANY, "t3");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_MIESZANY);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_MIESZANY, "t4");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_MIESZANY);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_MIESZANY, "t5");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_MIESZANY);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_MIESZANY, "t6");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_MIESZANY);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_MIESZANY, "t7");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_MIESZANY);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_MIESZANY, "t8");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_MIESZANY);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_MIESZANY, "t9");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_MIESZANY);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_MIESZANY, "t10");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_MIESZANY);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_MIESZANY, "def1");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_MIESZANY);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_MIESZANY, "def2");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_MIESZANY);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_MIESZANY, "def3");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_MIESZANY);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.mieszany)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_MIESZANY, "def4");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_MIESZANY);
                }

                if((id==R.drawable.t1)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_LAKA, "t1");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_LAKA);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_LAKA, "t2");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_LAKA);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_LAKA, "t3");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_LAKA);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_LAKA, "t4");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_LAKA);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_LAKA, "t5");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_LAKA);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_LAKA, "t6");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_LAKA);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_LAKA, "t7");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_LAKA);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_LAKA, "t8");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_LAKA);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_LAKA, "t9");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_LAKA);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_LAKA, "t10");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_LAKA);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_LAKA, "def1");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_LAKA);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_LAKA, "def2");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_LAKA);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_LAKA, "def3");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_LAKA);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.dwa)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_DWA_BLASZ_LAKA, "def4");
                    SQLHelper.getList(Queries.QUERY_DWA_BLASZ_LAKA);
                }


                if((id==R.drawable.t1)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_LAKA, "t1");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_LAKA);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_LAKA, "t2");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_LAKA);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_LAKA, "t3");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_LAKA);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_LAKA, "t4");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_LAKA);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_LAKA, "t5");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_LAKA);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_LAKA, "t6");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_LAKA);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_LAKA, "t7");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_LAKA);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_LAKA, "t8");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_LAKA);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_LAKA, "t9");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_LAKA);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_LAKA, "t10");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_LAKA);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_LAKA, "def1");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_LAKA);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_LAKA, "def2");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_LAKA);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_LAKA, "def3");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_LAKA);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.poch)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_POCH_BLASZ_LAKA, "def4");
                    SQLHelper.getList(Queries.QUERY_POCH_BLASZ_LAKA);
                }


                if((id==R.drawable.t1)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_LAKA, "t1");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_LAKA);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_LAKA, "t2");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_LAKA);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_LAKA, "t3");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_LAKA);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_LAKA, "t4");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_LAKA);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_LAKA, "t5");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_LAKA);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_LAKA, "t6");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_LAKA);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_LAKA, "t7");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_LAKA);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_LAKA, "t8");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_LAKA);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_LAKA, "t9");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_LAKA);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_LAKA, "t10");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_LAKA);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_LAKA, "def1");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_LAKA);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_LAKA, "def2");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_LAKA);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_LAKA, "def3");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_LAKA);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.next)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_NIC_BLASZ_LAKA, "def4");
                    SQLHelper.getList(Queries.QUERY_NIC_BLASZ_LAKA);
                }


                if((id==R.drawable.t1)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_LAKA, "t1");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_LAKA);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_LAKA, "t2");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_LAKA);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_LAKA, "t3");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_LAKA);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_LAKA, "t4");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_LAKA);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_LAKA, "t5");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_LAKA);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_LAKA, "t6");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_LAKA);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_LAKA, "t7");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_LAKA);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_LAKA, "t8");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_LAKA);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_LAKA, "t9");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_LAKA);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_LAKA, "t10");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_LAKA);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_LAKA, "def1");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_LAKA);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_LAKA, "def2");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_LAKA);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_LAKA, "def3");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_LAKA);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.piers)&&(id3==R.drawable.blaszki)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_BLASZ_LAKA, "def4");
                    SQLHelper.getList(Queries.QUERY_PIERS_BLASZ_LAKA);
                }


                if((id==R.drawable.t1)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_LAKA, "t1");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_LAKA);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_LAKA, "t2");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_LAKA);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_LAKA, "t3");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_LAKA);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_LAKA, "t4");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_LAKA);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_LAKA, "t5");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_LAKA);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_LAKA, "t6");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_LAKA);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_LAKA, "t7");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_LAKA);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_LAKA, "t8");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_LAKA);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_LAKA, "t9");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_LAKA);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_LAKA, "t10");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_LAKA);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_LAKA, "def1");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_LAKA);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_LAKA, "def2");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_LAKA);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_LAKA, "def3");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_LAKA);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.poch)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_POCH_POR_LAKA, "def4");
                    SQLHelper.getList(Queries.QUERY_POCH_POR_LAKA);
                }


                if((id==R.drawable.t1)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_LAKA, "t1");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_LAKA);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_LAKA, "t2");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_LAKA);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_LAKA, "t3");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_LAKA);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_LAKA, "t4");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_LAKA);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_LAKA, "t5");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_LAKA);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_LAKA, "t6");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_LAKA);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_LAKA, "t7");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_LAKA);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_LAKA, "t8");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_LAKA);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_LAKA, "t9");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_LAKA);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_LAKA, "t10");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_LAKA);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_LAKA, "def1");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_LAKA);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_LAKA, "def2");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_LAKA);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_LAKA, "def3");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_LAKA);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.piers)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_POR_LAKA, "def4");
                    SQLHelper.getList(Queries.QUERY_PIERS_POR_LAKA);
                }

                if((id==R.drawable.t1)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_LAKA, "t1");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_LAKA);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_LAKA, "t2");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_LAKA);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_LAKA, "t3");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_LAKA);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_LAKA, "t4");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_LAKA);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_LAKA, "t5");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_LAKA);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_LAKA, "t6");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_LAKA);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_LAKA, "t7");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_LAKA);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_LAKA, "t8");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_LAKA);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_LAKA, "t9");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_LAKA);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_LAKA, "t10");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_LAKA);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_LAKA, "def1");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_LAKA);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_LAKA, "def2");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_LAKA);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_LAKA, "def3");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_LAKA);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.next)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_NIC_POR_LAKA, "def4");
                    SQLHelper.getList(Queries.QUERY_NIC_POR_LAKA);
                }

                if((id==R.drawable.t1)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_LAKA, "t1");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_LAKA);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_LAKA, "t2");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_LAKA);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_LAKA, "t3");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_LAKA);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_LAKA, "t4");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_LAKA);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_LAKA, "t5");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_LAKA);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_LAKA, "t6");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_LAKA);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_LAKA, "t7");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_LAKA);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_LAKA, "t8");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_LAKA);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_LAKA, "t9");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_LAKA);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_LAKA, "t10");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_LAKA);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_LAKA, "def1");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_LAKA);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_LAKA, "def2");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_LAKA);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_LAKA, "def3");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_LAKA);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.dwa)&&(id3==R.drawable.pory)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_DWA_POR_LAKA, "def4");
                    SQLHelper.getList(Queries.QUERY_DWA_POR_LAKA);
                }

                if((id==R.drawable.t1)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_LAKA, "t1");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_LAKA);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_LAKA, "t2");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_LAKA);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_LAKA, "t3");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_LAKA);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_LAKA, "t4");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_LAKA);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_LAKA, "t5");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_LAKA);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_LAKA, "t6");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_LAKA);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_LAKA, "t7");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_LAKA);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_LAKA, "t8");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_LAKA);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_LAKA, "t9");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_LAKA);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_LAKA, "t10");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_LAKA);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_LAKA, "def1");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_LAKA);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_LAKA, "def2");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_LAKA);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_LAKA, "def3");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_LAKA);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.poch)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_POCH_NIC_LAKA, "def4");
                    SQLHelper.getList(Queries.QUERY_POCH_NIC_LAKA);
                }

                if((id==R.drawable.t1)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_LAKA, "t1");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_LAKA);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_LAKA, "t2");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_LAKA);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_LAKA, "t3");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_LAKA);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_LAKA, "t4");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_LAKA);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_LAKA, "t5");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_LAKA);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_LAKA, "t6");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_LAKA);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_LAKA, "t7");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_LAKA);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_LAKA, "t8");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_LAKA);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_LAKA, "t9");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_LAKA);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_LAKA, "t10");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_LAKA);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_LAKA, "def1");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_LAKA);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_LAKA, "def2");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_LAKA);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_LAKA, "def3");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_LAKA);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.piers)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_PIERS_NIC_LAKA, "def4");
                    SQLHelper.getList(Queries.QUERY_PIERS_NIC_LAKA);
                }

                if((id==R.drawable.t1)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_LAKA, "t1");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_LAKA);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_LAKA, "t2");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_LAKA);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_LAKA, "t3");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_LAKA);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_LAKA, "t4");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_LAKA);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_LAKA, "t5");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_LAKA);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_LAKA, "t6");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_LAKA);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_LAKA, "t7");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_LAKA);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_LAKA, "t8");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_LAKA);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_LAKA, "t9");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_LAKA);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_LAKA, "t10");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_LAKA);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_LAKA, "def1");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_LAKA);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_LAKA, "def2");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_LAKA);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_LAKA, "def3");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_LAKA);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.next)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_NIC_NIC_LAKA, "def4");
                    SQLHelper.getList(Queries.QUERY_NIC_NIC_LAKA);
                }

                if((id==R.drawable.t1)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_LAKA, "t1");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_LAKA);
                }
                if((id==R.drawable.t2)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_LAKA, "t2");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_LAKA);
                }
                if((id==R.drawable.t3)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_LAKA, "t3");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_LAKA);
                }
                if((id==R.drawable.t4)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_LAKA, "t4");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_LAKA);
                }
                if((id==R.drawable.t5)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_LAKA, "t5");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_LAKA);
                }
                if((id==R.drawable.t6)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_LAKA, "t6");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_LAKA);
                }
                if((id==R.drawable.t7)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_LAKA, "t7");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_LAKA);
                }
                if((id==R.drawable.t8)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_LAKA, "t8");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_LAKA);
                }
                if((id==R.drawable.t9)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_LAKA, "t9");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_LAKA);
                }
                if((id==R.drawable.t10)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_LAKA, "t10");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_LAKA);
                }

                if((id==R.drawable.def1)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_LAKA, "def1");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_LAKA);
                }
                if((id==R.drawable.def2)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_LAKA, "def2");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_LAKA);
                }
                if((id==R.drawable.def3)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_LAKA, "def3");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_LAKA);
                }
                if((id==R.drawable.def4)&&(id2==R.drawable.dwa)&&(id3==R.drawable.next)&&(id4==R.drawable.laka)) {
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_LAKA, "def4");
                    SQLHelper.getList(Queries.QUERY_DWA_NIC_LAKA);
                }

                else{AlertDialog.Builder builder = new AlertDialog.Builder(SearchingActivity.this);
                    queryfinal = String.format(Queries.QUERY_DWA_NIC_LAKA, "def4");
                    builder.setTitle("Błąd!");
                    builder.setMessage("W dwóch pierwszych oknach jaden musi być ustawiony na NEXT!");
                    builder.setPositiveButton("OK", null);
                    builder.show();}


                SQLiteCursor kursor = (SQLiteCursor) ps.getList(queryfinal);

                if(kursor.getCount()>0){
                    StringBuffer buff = new StringBuffer();
                    while (kursor.moveToNext()){
                        buff.append("ID: "+kursor.getString(0) + "\n");
                        buff.append("Grzyb: "+kursor.getString(1) + "\n");
                        buff.append("Kształt: "+kursor.getString(2) + "\n");
                        buff.append("Pochpier: "+kursor.getString(3) + "\n");
                        buff.append("Blaszki: "+kursor.getString(4) + "\n");
                        buff.append("Las: "+kursor.getString(5) + "\n");
                    }
                    Pokazto("Grzyby", buff.toString());
                }



            }
        });


    }
    public void Pokazto(String tytul, String wiadomosc){
        AlertDialog.Builder budowniczy = new AlertDialog.Builder(this);
        budowniczy.setMessage(wiadomosc);
        budowniczy.setTitle(tytul);
        budowniczy.show();
    }
}
