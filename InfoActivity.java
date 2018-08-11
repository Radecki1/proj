package pl.cba.radeckiuczony.mushroomer;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class InfoActivity extends AppCompatActivity {
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        TextView tv = (TextView)findViewById(R.id.info);
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP)
        {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
        tv.setText("Autor aplikacji nie ponosi odpowiedzialności za efekty i powikłania związane z korzystaniem z aplikacji, na przykład: niewłaściwe i niedokładne czytanie opisów i zdjęć. \n" +
                "Aplikacja została starannie sprawdzona, ale powinna być traktowana jako UZUPEŁNIENIE wieadomości ze sprawdzonych źródeł. \n" +
                "Każde grzybobranie powinno być zweryfikowane przez osobę z odpowiednimi kwalifikacjami, np. leśniczy. \n" +
                "Opisy i zdjęcia zostały zaczerpnięte ze stron: \n" +
                "Wikipedia \n" +
                "NaGrzyby \n" +
                "oraz zagranicznych stron. \n" +
                "Pytania można wysyłać na adres e-mail: deptuar@gmail.com \n"+"\n"+
        "Radecki Uczony Programming | Radosław Deptuła 2018");
    }
}
