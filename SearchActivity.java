package pl.cba.radeckiuczony.mushroomer;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import static pl.cba.radeckiuczony.mushroomer.SQLHelper.TABLE_QUESTION;

public class SearchActivity extends AppCompatActivity {

    private ImageView lewa1, prawa1, lewa2, prawa2, lewa3, prawa3, lewa4, prawa4, lewa5, prawa5;
    private ImageView opcja1, opcja2, opcja3, opcja4, opcja5;
    private int currentImage1 = 0;
    private int currentImage2 = 0;
    private int currentImage3 = 0;
    private int currentImage4 = 0;
    private int currentImage5 = 0;
    int[] images1 = {R.drawable.t1,R.drawable.t2,R.drawable.t3,R.drawable.t4,R.drawable.t5,R.drawable.t6,R.drawable.t7,R.drawable.t8,R.drawable.t9, R.drawable.t10, R.drawable.next};
    int[] images2 = {R.drawable.def1,R.drawable.def2,R.drawable.def3,R.drawable.def4, R.drawable.next};
    int[] images3 = {R.drawable.poch, R.drawable.piers,R.drawable.next, R.drawable.dwa};
    int[] images4 = {R.drawable.blaszki, R.drawable.pory, R.drawable.next};
    int[] images5 = {R.drawable.iglasty, R.drawable.lisc, R.drawable.mieszany, R.drawable.laka};
    SQLHelper ps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        lewa1 = (ImageView) findViewById(R.id.l1);
        lewa2 = (ImageView) findViewById(R.id.l2);
        lewa3 = (ImageView) findViewById(R.id.l3);
        lewa4 = (ImageView) findViewById(R.id.l4);
        lewa5 = (ImageView) findViewById(R.id.l5);

        prawa1 = (ImageView) findViewById(R.id.p1);
        prawa2 = (ImageView) findViewById(R.id.p2);
        prawa3 = (ImageView) findViewById(R.id.p3);
        prawa4 = (ImageView) findViewById(R.id.p4);
        prawa5 = (ImageView) findViewById(R.id.p5);

        opcja1 = (ImageView) findViewById(R.id.img1);
        opcja2 = (ImageView) findViewById(R.id.img2);
        opcja3 = (ImageView) findViewById(R.id.img3);
        opcja4 = (ImageView) findViewById(R.id.img4);
        opcja5 = (ImageView) findViewById(R.id.img5);

        //prawa1.setOnClickListener((View.OnClickListener) this);
        //prawa1.setOnClickListener(imgButtonHandler);

        prawa1.setOnClickListener(iButtonChangeImageListener);
        lewa1.setOnClickListener(gButtonChangeImageListener);

        prawa2.setOnClickListener(iButtonChangeImageListener2);
        lewa2.setOnClickListener(gButtonChangeImageListener2);

        prawa3.setOnClickListener(iButtonChangeImageListener3);
        lewa3.setOnClickListener(gButtonChangeImageListener3);

        prawa4.setOnClickListener(iButtonChangeImageListener4);
        lewa4.setOnClickListener(gButtonChangeImageListener4);

        prawa5.setOnClickListener(iButtonChangeImageListener5);
        lewa5.setOnClickListener(gButtonChangeImageListener5);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP)
        {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
}

    View.OnClickListener iButtonChangeImageListener = new View.OnClickListener() {

        public void onClick(View v) {
            //Increase Counter to move to next Image
            currentImage1++;
            currentImage1 = currentImage1 % images1.length;

            opcja1.setImageResource(images1[currentImage1]);

        }
    };

    View.OnClickListener gButtonChangeImageListener = new View.OnClickListener() {

        public void onClick(View v) {
            //Increase Counter to move to next Image
            currentImage1--;
            currentImage1 = (currentImage1 + images1.length) % images1.length;

            opcja1.setImageResource(images1[currentImage1]);

        }
    };

    View.OnClickListener iButtonChangeImageListener2 = new View.OnClickListener() {

        public void onClick(View v) {
            //Increase Counter to move to next Image
            currentImage2++;
            currentImage2 = currentImage2 % images2.length;

            opcja2.setImageResource(images2[currentImage2]);

        }
    };

    View.OnClickListener gButtonChangeImageListener2 = new View.OnClickListener() {

        public void onClick(View v) {
            //Increase Counter to move to next Image
            currentImage2--;
            currentImage2 = (currentImage2 + images2.length) % images2.length;

            opcja2.setImageResource(images2[currentImage2]);

        }
    };

    View.OnClickListener iButtonChangeImageListener3 = new View.OnClickListener() {

        public void onClick(View v) {
            //Increase Counter to move to next Image
            currentImage3++;
            currentImage3 = currentImage3 % images3.length;

            opcja3.setImageResource(images3[currentImage3]);

        }
    };

    View.OnClickListener gButtonChangeImageListener3 = new View.OnClickListener() {

        public void onClick(View v) {
            //Increase Counter to move to next Image
            currentImage3--;
            currentImage3 = (currentImage3 + images3.length) % images3.length;

            opcja3.setImageResource(images3[currentImage3]);

        }
    };

    View.OnClickListener iButtonChangeImageListener4 = new View.OnClickListener() {

        public void onClick(View v) {
            //Increase Counter to move to next Image
            currentImage4++;
            currentImage4 = currentImage4 % images4.length;

            opcja4.setImageResource(images4[currentImage4]);

        }
    };

    View.OnClickListener gButtonChangeImageListener4 = new View.OnClickListener() {

        public void onClick(View v) {
            //Increase Counter to move to next Image
            currentImage4--;
            currentImage4 = (currentImage4 + images4.length) % images4.length;

            opcja4.setImageResource(images4[currentImage4]);

        }
    };

    View.OnClickListener iButtonChangeImageListener5 = new View.OnClickListener() {

        public void onClick(View v) {
            //Increase Counter to move to next Image
            currentImage4++;
            currentImage4 = currentImage4 % images5.length;

            opcja5.setImageResource(images5[currentImage4]);

        }
    };

    View.OnClickListener gButtonChangeImageListener5 = new View.OnClickListener() {

        public void onClick(View v) {
            //Increase Counter to move to next Image
            currentImage4--;
            currentImage4 = (currentImage4 + images5.length) % images5.length;

            opcja5.setImageResource(images5[currentImage4]);

        }
    };
    public String jedynka;
    public String trojka;
    public String czworka;
    public String piatka;
    public void Searching (View view){

        /*AlertDialog.Builder builder = new AlertDialog.Builder(SearchActivity.this);
        builder.setTitle("Aplikacja w budowie!");
        builder.setMessage("Już niedługo Mushroomer umożliwi wyszukiwanie grzybów.");
        builder.setPositiveButton("OK", null);
        builder.show();
*/


        /*if(images1[currentImage1]==R.drawable.t1){
            jedynka="KSZTALT LIKE 't1'";
        }
        if(images1[currentImage1]==R.drawable.t2){
            jedynka="KSZTALT LIKE 't2'";
        }
        if(images1[currentImage1]==R.drawable.t3){
            jedynka="KSZTALT LIKE 't3'";
        }
        if(images1[currentImage1]==R.drawable.t4){
            jedynka="KSZTALT LIKE 't4'";
        }
        if(images1[currentImage1]==R.drawable.t5){
            jedynka="KSZTALT LIKE 't5'";
        }
        if(images1[currentImage1]==R.drawable.t6){
            jedynka="KSZTALT LIKE 't6'";
        }
        if(images1[currentImage1]==R.drawable.t7){
            jedynka="KSZTALT LIKE 't7'";
        }
        if(images1[currentImage1]==R.drawable.t8){
            jedynka="KSZTALT LIKE 't8'";
        }
        if(images1[currentImage1]==R.drawable.t9){
            jedynka="KSZTALT LIKE 't9'";
        }
        if(images1[currentImage1]==R.drawable.t10){
            jedynka="KSZTALT LIKE 't10'";
        }

        if(images2[currentImage2]==R.drawable.def1){
            jedynka="KSZTALT LIKE 'def1'";
        }
        if(images2[currentImage2]==R.drawable.def2){
            jedynka="KSZTALT LIKE 'def2'";
        }
        if(images2[currentImage2]==R.drawable.def3){
            jedynka="KSZTALT LIKE 'def3'";
        }
        if(images2[currentImage2]==R.drawable.def4){
            jedynka="KSZTALT LIKE 'def4'";
        }
        if((images2[currentImage2]==R.drawable.next)&&(images1[currentImage1]==R.drawable.next)){
            jedynka="KSZTALT LIKE 'nic'";
        }

        if(images3[currentImage3]==R.drawable.poch){
            trojka=" AND POCHPIERS LIKE 'poch'";
        }
        if(images3[currentImage3]==R.drawable.piers){
            trojka=" AND POCHPIERS LIKE 'piers'";
        }
        if(images3[currentImage3]==R.drawable.next){
            trojka=" AND POCHPIERS LIKE 'nic'";
        }
        if(images3[currentImage3]==R.drawable.dwa){
            trojka=" AND POCHPIERS LIKE 'dwa'";
        }

        if(images4[currentImage4]==R.drawable.blaszki){
            czworka=" AND BLASZKI LIKE 'blaszki'";
        }
        if(images4[currentImage4]==R.drawable.pory){
            czworka=" AND BLASZKI LIKE 'pory'";
        }
        if(images4[currentImage4]==R.drawable.next){
            czworka=" AND BLASZKI LIKE 'nic'";
        }

        if(images5[currentImage5]==R.drawable.iglasty){
            piatka=" AND LAS LIKE 'iglasty'";
        }
        if(images5[currentImage5]==R.drawable.lisc){
            piatka=" AND LAS LIKE 'lisc'";
        }
        if(images5[currentImage5]==R.drawable.mieszany){
            piatka=" AND LAS LIKE 'mieszany'";
        }
        if(images5[currentImage5]==R.drawable.laka) {
            piatka = " AND LAS LIKE 'laka'";
        }*/

        /*Drawable id = opcja1.getDrawable();
        Drawable id1 = opcja1.getDrawable();
        Drawable id2 = opcja1.getDrawable();
        Drawable id3 = opcja1.getDrawable();
        Drawable id4 = opcja1.getDrawable();*/

       // int resID = getResources().getIdentifier(String.valueOf(opcja1), "id", getPackageName());
        ImageView im = (ImageView) findViewById(R.id.img1);
        Context context = im.getContext();
        int id = context.getResources().getIdentifier(String.valueOf(opcja1), "drawable",
                context.getPackageName());
        im.setImageResource(id);

        //int resID1 = getResources().getIdentifier(String.valueOf(opcja2), "id", getPackageName());
        ImageView im1 = (ImageView) findViewById(R.id.img2);
        Context context1 = im1.getContext();
        int id1 = context1.getResources().getIdentifier(String.valueOf(opcja2), "drawable",
                context1.getPackageName());
        im1.setImageResource(id1);

       // int resID2 = getResources().getIdentifier(String.valueOf(opcja3), "id", getPackageName());
        ImageView im2 = (ImageView) findViewById(R.id.img3);
        Context context2 = im2.getContext();
        int id2 = context2.getResources().getIdentifier(String.valueOf(opcja3), "drawable",
                context2.getPackageName());
        im2.setImageResource(id2);

       // int resID3 = getResources().getIdentifier(String.valueOf(opcja4), "id", getPackageName());
        ImageView im3 = (ImageView) findViewById(R.id.img4);
        Context context3 = im3.getContext();
        int id3 = context3.getResources().getIdentifier(String.valueOf(opcja4), "drawable",
                context3.getPackageName());
        im3.setImageResource(id3);

       // int resID4 = getResources().getIdentifier(String.valueOf(opcja5), "id", getPackageName());
        ImageView im4 = (ImageView) findViewById(R.id.img5);
        Context context4 = im4.getContext();
        int id4 = context4.getResources().getIdentifier(String.valueOf(opcja5), "drawable",
                context4.getPackageName());
        im4.setImageResource(id4);


        Intent myintent1 = new Intent(SearchActivity.this,SearchingActivity.class);
        myintent1.putExtra("id", id);
        myintent1.putExtra("id1", id1);
        myintent1.putExtra("id2", id2);
        myintent1.putExtra("id3", id3);
        myintent1.putExtra("id4", id4);
        startActivity(myintent1);

        //public static String QUERY = "SELECT * FROM TABLE WHERE" + jedynka+trojka+czworka+piatka;

    }

}


