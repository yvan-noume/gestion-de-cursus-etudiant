package fr.utt.if26.noume_projet_if26.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import fr.utt.if26.noume_projet_if26.R;
import fr.utt.if26.noume_projet_if26.modele.BDOpenHelper;
import fr.utt.if26.noume_projet_if26.modele.Module;

public class RegleEtudeActivity extends AppCompatActivity {

    private ArrayList<Module> liste_Module = new ArrayList();
    private ArrayList<Module> liste_Module_bis = new ArrayList();
    private ArrayList<String> liste_Module_sigle = new ArrayList();
    private String TAG = "test";
    private int total = 0;
    private int verification = 0;
    private BDOpenHelper bdOH;
    private TextView cs;
    private TextView tm;
    private TextView cs_tm_tcbr;
    private TextView cs_tm_fil;
    private TextView st;
    private TextView ec;
    private TextView he;
    private TextView ct;
    private TextView he_ct;
    private TextView hp;
    private TextView npml;
    private TextView total_credit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regle_etude);
        cs = findViewById(R.id.cs);
        tm = findViewById(R.id.tm);
        cs_tm_tcbr = findViewById(R.id.cs_tm_tcbr);
        cs_tm_fil = findViewById(R.id.cs_tm_fil);
        st = findViewById(R.id.st);
        ec = findViewById(R.id.ec);
        he = findViewById(R.id.he);
        ct = findViewById(R.id.ct);
        he_ct = findViewById(R.id.he_ct);
        hp = findViewById(R.id.hp);
        npml = findViewById(R.id.npml);
        total_credit = findViewById(R.id.total);
        bdOH = new BDOpenHelper(this);

        Intent intent = getIntent();
        liste_Module_sigle = intent.getStringArrayListExtra("liste_module");
        Log.i(TAG + ":liste_module = ", filtre(liste_Module_sigle).get(0));
        liste_Module_bis = liste_module(filtre(liste_Module_sigle));
        cs.setText((verification_cs(liste_Module_bis)));
        tm.setText((verification_tm(liste_Module_bis)));
        cs_tm_tcbr.setText((verification_tcbr(liste_Module_bis)));
        cs_tm_fil.setText((verification_fil(liste_Module_bis)));
        st.setText((verification_st(liste_Module_bis)));
        ec.setText((verification_ec(liste_Module_bis)));
        he.setText((verification_he(liste_Module_bis)));
        ct.setText((verification_ct(liste_Module_bis)));
        he_ct.setText((verification_he_ct(liste_Module_bis)));
        total_credit.setText(verification_total());
        //verification_generale();
        //Toast.makeText(this,"liste_Module_sigle : " + filtre(liste_Module_sigle) + " " + bdOH.getAllModules(), Toast.LENGTH_LONG).show();
    }


    public ArrayList<String> filtre(ArrayList<String> liste_module_sigle){
        ArrayList<String> liste= new ArrayList();
        for(int i=0;i<liste_module_sigle.size(); i++){
            if(!liste_module_sigle.get(i).isEmpty()){
                liste.add(liste_module_sigle.get(i));
            }
        }
        return liste;
    }

    public ArrayList<Module> liste_module(ArrayList<String> liste_Module_sigle){
        bdOH = new BDOpenHelper(this);
        for(int i = 0; i<liste_Module_sigle.size();i++){
            liste_Module.add(bdOH.getModule(liste_Module_sigle.get(i)));
        }
        return liste_Module;
    }

    private String verification_cs(ArrayList<Module> liste_Module){
        ImageView img_cs_green = findViewById(R.id.cs_green);
        //ImageView img_cs_red = findViewById(R.id.cs_red);
        TextView cs_list = findViewById(R.id.cs_list);

        int credit_cs = 0;
        String credit;
        String cs_list_text = "";
        for(int i = 0; i< liste_Module.size(); i++){
            if(liste_Module.get(i).getCategorie().equals("CS")){
                credit_cs += 6;
                cs_list_text += liste_Module.get(i).getSigle() + " ";
            }
        }
        if(credit_cs >= 30){
            //img_cs_red.setVisibility(View.INVISIBLE);
            img_cs_green.setImageResource(R.drawable.ic_done_green);
            verification += 1;
        }else {
            //img_cs_green.setVisibility(View.INVISIBLE);
            img_cs_green.setImageResource(R.drawable.ic_baseline_clear_red);
        }
        total += credit_cs;
        cs_list.setText("[ "+cs_list_text+ "]");
        credit = credit_cs + "/30";
        return credit;
    }

    private String verification_tm(ArrayList<Module> liste_Module){
        ImageView img_tm_green = findViewById(R.id.tm_green);
        //ImageView img_tm_red = findViewById(R.id.tm_red);
        TextView tm_list = findViewById(R.id.tm_list);

        int credit = 0;
        String credit_tm;
        String tm_list_text = "";
        for(int i = 0; i< liste_Module.size(); i++){
            if(liste_Module.get(i).getCategorie().equals("TM") ){
                credit += 6;
                tm_list_text += liste_Module.get(i).getSigle() + " ";
            }
        }

        if(credit >= 30){
            img_tm_green.setImageResource(R.drawable.ic_done_green);
            verification += 1;
        }else {
            img_tm_green.setImageResource(R.drawable.ic_baseline_clear_red);
        }
        total += credit;
        tm_list.setText("[ "+tm_list_text+ "]");
        credit_tm = credit + "/30";
        return credit_tm;
    }

    private String verification_tcbr(ArrayList<Module> liste_Module){
        ImageView cs_tm_green_tcbr = findViewById(R.id.cs_tm_green_tcbr);
        //ImageView cs_tm_red_tcbr = findViewById(R.id.cs_tm_red_tcbr);
        TextView tcbr_list = findViewById(R.id.tcbr_list);


        int credit = 0;
        String credit_tcbr;
        String tcbr_list_text = "";
        for(int i = 0; i< liste_Module.size(); i++){
            if(liste_Module.get(i).getParcours().equals("TCBR") && (liste_Module.get(i).getCategorie().equals("CS") || liste_Module.get(i).getCategorie().equals("TM"))){
                credit += 6;
                tcbr_list_text += liste_Module.get(i).getSigle() + " ";
            }
        }
        if(credit >= 54){
            cs_tm_green_tcbr.setImageResource(R.drawable.ic_done_green);
            verification += 1;
        }else {
            cs_tm_green_tcbr.setImageResource(R.drawable.ic_baseline_clear_red);
        }
        tcbr_list.setText("[ "+tcbr_list_text+ "]");
        credit_tcbr = credit + "/54";
        return credit_tcbr;
    }

    private String verification_fil(ArrayList<Module> liste_Module){
        ImageView cs_tm_green_fil = findViewById(R.id.cs_tm_green_fil);
        //ImageView cs_tm_red_fil = findViewById(R.id.cs_tm_red_fil);
        TextView fil_list = findViewById(R.id.fil_list);

        int credit = 0;
        String credit_fil;
        String fil_list_text = "";
        for(int i = 0; i< liste_Module.size(); i++){
            if(liste_Module.get(i).getParcours().equals("FIL") && (liste_Module.get(i).getCategorie().equals("CS") || liste_Module.get(i).getCategorie().equals("TM")) ){
                credit += 6;
                fil_list_text += liste_Module.get(i).getSigle() + " ";
            }
        }

        if(credit >= 30){
            cs_tm_green_fil.setImageResource(R.drawable.ic_done_green);
            verification += 1;
        }else {
            cs_tm_green_fil.setImageResource(R.drawable.ic_baseline_clear_red);
        }
        fil_list.setText("[ "+fil_list_text+ "]");
        credit_fil = credit + "/30";
        return credit_fil;
    }

    private String verification_st(ArrayList<Module> liste_Module){
        ImageView st_green = findViewById(R.id.st_green);
        //ImageView st_red = findViewById(R.id.st_red);
        TextView st_list = findViewById(R.id.st_list);

        int credit = 0;
        String credit_st;
        String st_list_text = "";
        for(int i = 0; i< liste_Module.size(); i++){
            if(liste_Module.get(i).getCategorie().equals("ST") ){
                credit += 30;
                st_list_text += liste_Module.get(i).getSigle() + " ";
            }
        }

        if(credit >= 60){
            st_green.setImageResource(R.drawable.ic_done_green);
            verification += 1;
        }else {
            st_green.setImageResource(R.drawable.ic_baseline_clear_red);
        }
        total += credit;
        st_list.setText("[ "+st_list_text+ "]");
        credit_st = credit + "/60";
        return credit_st;
    }


    private String verification_ec(ArrayList<Module> liste_Module){
        ImageView ec_green = findViewById(R.id.ec_green);
        //ImageView ec_red = findViewById(R.id.ec_red);
        TextView ec_list = findViewById(R.id.ec_list);

        int credit = 0;
        String credit_ec;
        String ec_list_text = "";
        for(int i = 0; i< liste_Module.size(); i++){
            if(liste_Module.get(i).getCategorie().equals("EC") ){
                credit += 4;
                ec_list_text += liste_Module.get(i).getSigle() + " ";
            }
        }

        if(credit >= 12){
            ec_green.setImageResource(R.drawable.ic_done_green);
            verification += 1;
        }else {
            ec_green.setImageResource(R.drawable.ic_baseline_clear_red);
        }
        total += credit;
        ec_list.setText("[ "+ec_list_text+ "]");
        credit_ec = credit + "/12";
        return credit_ec;
    }

    private String verification_he(ArrayList<Module> liste_Module){
        ImageView he_green = findViewById(R.id.he_green);
        //ImageView he_red = findViewById(R.id.he_red);
        TextView he_list = findViewById(R.id.he_list);

        int credit = 0;
        String credit_he;
        String he_list_text = "";
        for(int i = 0; i< liste_Module.size(); i++){
            if(liste_Module.get(i).getCategorie().equals("HE") ){
                credit += 4;
                he_list_text += liste_Module.get(i).getSigle() + " ";
            }
        }

        if(credit >= 4){
            he_green.setImageResource(R.drawable.ic_done_green);
            verification += 1;
        }else {
            he_green.setImageResource(R.drawable.ic_baseline_clear_red);
        }
        he_list.setText("[ "+he_list_text+ "]");
        credit_he = credit + "/4";
        return credit_he;
    }

    private String verification_ct(ArrayList<Module> liste_Module){
        ImageView ct_green = findViewById(R.id.ct_green);
        //ImageView ct_red = findViewById(R.id.ct_red);
        TextView ct_list = findViewById(R.id.ct_list);

        int credit = 0;
        String credit_ct;
        String ct_list_text = "";
        for(int i = 0; i< liste_Module.size(); i++){
            if(liste_Module.get(i).getCategorie().equals("CT") ){
                credit += 4;
                ct_list_text += liste_Module.get(i).getSigle() + " ";
            }
        }

        if(credit >= 4){
            ct_green.setImageResource(R.drawable.ic_done_green);
            verification += 1;
        }else {
            ct_green.setImageResource(R.drawable.ic_baseline_clear_red);
        }
        ct_list.setText("[ "+ct_list_text+ "]");
        credit_ct = credit + "/4";
        return credit_ct;
    }

    private String verification_he_ct(ArrayList<Module> liste_Module){
        ImageView he_ct_green = findViewById(R.id.he_ct_green);
        //ImageView he_ct_red = findViewById(R.id.he_ct_red);
        TextView he_ct_list = findViewById(R.id.he_cs_list);

        int credit = 0;
        String credit_he_ct;
        String he_ct_list_text = "";
        for(int i = 0; i< liste_Module.size(); i++){
            if(liste_Module.get(i).getCategorie().equals("HE") || liste_Module.get(i).getCategorie().equals("CT")){
                credit += 4;
                he_ct_list_text += liste_Module.get(i).getSigle() + " ";
            }
        }

        if(credit >= 16){
            he_ct_green.setImageResource(R.drawable.ic_done_green);
            verification += 1;
        }else {
            he_ct_green.setImageResource(R.drawable.ic_baseline_clear_red);
        }
        total += credit;
        he_ct_list.setText("[ "+he_ct_list_text+ "]");
        credit_he_ct = credit + "/16";
        return credit_he_ct;
    }

    private String verification_total(){
        ImageView total_green = findViewById(R.id.total_green);
        //ImageView ct_red = findViewById(R.id.ct_red);

        String ct_list_text = "";

        if(total >= 180 && verification == 9) {
            total_green.setImageResource(R.drawable.ic_done_green);
        }else {
            total_green.setImageResource(R.drawable.ic_baseline_clear_red);
        }
        String credit_ct = total + "/180";
        return credit_ct;
    }
     /*public void verification_generale(){
         ImageView img_cs_green = findViewById(R.id.cs_green);
         //ImageView img_cs_red = findViewById(R.id.cs_red);

         ImageView img_tm_green = findViewById(R.id.tm_green);
         ImageView img_tm_red = findViewById(R.id.tm_red);

         ImageView cs_tm_green_tcbr = findViewById(R.id.cs_tm_green_tcbr);
         ImageView cs_tm_red_tcbr = findViewById(R.id.cs_tm_red_tcbr);

         ImageView cs_tm_green_fil = findViewById(R.id.cs_tm_green_fil);
         ImageView cs_tm_red_fil = findViewById(R.id.cs_tm_red_fil);

         ImageView st_green = findViewById(R.id.st_green);
         ImageView st_red = findViewById(R.id.st_red);

         ImageView ec_green = findViewById(R.id.ec_green);
         ImageView ec_red = findViewById(R.id.ec_red);

         ImageView he_green = findViewById(R.id.he_green);
         ImageView he_red = findViewById(R.id.he_red);

         ImageView ct_green = findViewById(R.id.ct_green);
         ImageView ct_red = findViewById(R.id.ct_red);

         ImageView he_ct_green = findViewById(R.id.he_ct_green);
         ImageView he_ct_red = findViewById(R.id.he_ct_red);

         ImageView hp_green = findViewById(R.id.hp_green);
         ImageView hp_red = findViewById(R.id.hp_red);

         ImageView npml_green = findViewById(R.id.npml_green);
         ImageView npml_red = findViewById(R.id.npml_red);

         if(Integer.parseInt(cs.getText().toString()) > 30){
            //img_cs_red.setVisibility(View.INVISIBLE);
        }else {
             img_cs_green.setVisibility(View.INVISIBLE);
         }

         if(Integer.parseInt(tm.getText().toString()) > 30){
             img_tm_red.setVisibility(View.INVISIBLE);
         }else {
             img_tm_green.setVisibility(View.INVISIBLE);
         }

         if(Integer.parseInt(cs_tm_tcbr.getText().toString()) > 54){
             cs_tm_red_tcbr.setVisibility(View.INVISIBLE);
         }else {
             cs_tm_green_tcbr.setVisibility(View.INVISIBLE);
         }

         if(Integer.parseInt(cs_tm_fil.getText().toString()) > 30){
             cs_tm_red_fil.setVisibility(View.INVISIBLE);
         }else {
             cs_tm_green_fil.setVisibility(View.INVISIBLE);
         }

         if(Integer.parseInt(st.getText().toString()) >= 60){
             st_red.setVisibility(View.INVISIBLE);
         }else {
             st_green.setVisibility(View.INVISIBLE);
         }

         if(Integer.parseInt(ec.getText().toString()) > 12){
             ec_red.setVisibility(View.INVISIBLE);
         }else {
             ec_green.setVisibility(View.INVISIBLE);
         }

         if(Integer.parseInt(he.getText().toString()) > 4){
             he_red.setVisibility(View.INVISIBLE);
         }else {
             he_green.setVisibility(View.INVISIBLE);
         }

         if(Integer.parseInt(ct.getText().toString()) > 4){
             ct_red.setVisibility(View.INVISIBLE);
         }else {
             ct_green.setVisibility(View.INVISIBLE);
         }

         if(Integer.parseInt(he_ct.getText().toString()) > 16){
             he_ct_red.setVisibility(View.INVISIBLE);
         }else {
             he_ct_green.setVisibility(View.INVISIBLE);
         }

         if(Integer.parseInt(hp.getText().toString()) > 0){
             hp_red.setVisibility(View.INVISIBLE);
         }else {
             hp_green.setVisibility(View.INVISIBLE);
         }

         if(npml.getText().equals("NPML")){
             npml_red.setVisibility(View.INVISIBLE);
         }else {
             npml_red.setVisibility(View.INVISIBLE);
         }
    }*/
}