package fr.utt.if26.noume_projet_if26.vue;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import fr.utt.if26.noume_projet_if26.R;
import fr.utt.if26.noume_projet_if26.modele.BDOpenHelper;
import fr.utt.if26.noume_projet_if26.modele.Cursus;
import fr.utt.if26.noume_projet_if26.modele.Module;

public class AfficherCursusActivity extends AppCompatActivity {

    private BDOpenHelper bdOH;
    private ArrayList<String> liste_Module_sigle = new ArrayList();
    private ArrayList<String> liste_Module_sigle_semestre1 = new ArrayList();
    private ArrayList<String> liste_Module_sigle_semestre2 = new ArrayList();
    private ArrayList<String> liste_Module_sigle_semestre3 = new ArrayList();
    private ArrayList<String> liste_Module_sigle_semestre4 = new ArrayList();
    private ArrayList<String> liste_Module_sigle_semestre5 = new ArrayList();
    private ArrayList<String> liste_Module_sigle_semestre6 = new ArrayList();
    private String nom_cursus_text = "";
    private static int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficher_cursus);

        bdOH = new BDOpenHelper(this);
        TextView nom_cursus = findViewById(R.id.nom_curus_text);

        TextView semestre1_module1 = findViewById(R.id.semestre1_module1_text);
        TextView semestre1_module2 = findViewById(R.id.semestre1_module2_text);
        TextView semestre1_module3 = findViewById(R.id.semestre1_module3_text);
        TextView semestre1_module4 = findViewById(R.id.semestre1_module4_text);
        TextView semestre1_module5 = findViewById(R.id.semestre1_module5_text);
        TextView semestre1_module6 = findViewById(R.id.semestre1_module6_text);
        TextView semestre1_tn09 = findViewById(R.id.semestre1_tn09);

        TextView semestre2_module1 = findViewById(R.id.semestre2_module1_text);
        TextView semestre2_module2 = findViewById(R.id.semestre2_module2_text);
        TextView semestre2_module3 = findViewById(R.id.semestre2_module3_text);
        TextView semestre2_module4 = findViewById(R.id.semestre2_module4_text);
        TextView semestre2_module5 = findViewById(R.id.semestre2_module5_text);
        TextView semestre2_module6 = findViewById(R.id.semestre2_module6_text);
        TextView semestre2_tn09 = findViewById(R.id.semestre2_tn09);

        TextView semestre3_module1 = findViewById(R.id.semestre3_module1_text);
        TextView semestre3_module2 = findViewById(R.id.semestre3_module2_text);
        TextView semestre3_module3 = findViewById(R.id.semestre3_module3_text);
        TextView semestre3_module4 = findViewById(R.id.semestre3_module4_text);
        TextView semestre3_module5 = findViewById(R.id.semestre3_module5_text);
        TextView semestre3_module6 = findViewById(R.id.semestre3_module6_text);
        TextView semestre3_tn09 = findViewById(R.id.semestre3_tn09);

        TextView semestre4_module1 = findViewById(R.id.semestre4_module1_text);
        TextView semestre4_module2 = findViewById(R.id.semestre4_module2_text);
        TextView semestre4_module3 = findViewById(R.id.semestre4_module3_text);
        TextView semestre4_module4 = findViewById(R.id.semestre4_module4_text);
        TextView semestre4_module5 = findViewById(R.id.semestre4_module5_text);
        TextView semestre4_module6 = findViewById(R.id.semestre4_module6_text);
        TextView semestre4_tn09 = findViewById(R.id.semestre4_tn09);

        TextView semestre5_module1 = findViewById(R.id.semestre5_module1_text);
        TextView semestre5_module2 = findViewById(R.id.semestre5_module2_text);
        TextView semestre5_module3 = findViewById(R.id.semestre5_module3_text);
        TextView semestre5_module4 = findViewById(R.id.semestre5_module4_text);
        TextView semestre5_module5 = findViewById(R.id.semestre5_module5_text);
        TextView semestre5_module6 = findViewById(R.id.semestre5_module6_text);
        TextView semestre5_tn09 = findViewById(R.id.semestre5_tn09);

        TextView semestre6_module1 = findViewById(R.id.semestre6_module1_text);
        TextView semestre6_module2 = findViewById(R.id.semestre6_module2_text);
        TextView semestre6_module3 = findViewById(R.id.semestre6_module3_text);
        TextView semestre6_module4 = findViewById(R.id.semestre6_module4_text);
        TextView semestre6_module5 = findViewById(R.id.semestre6_module5_text);
        TextView semestre6_module6 = findViewById(R.id.semestre6_module6_text);
        TextView semestre6_tn09 = findViewById(R.id.semestre6_tn09);

        Intent intent = getIntent();
        liste_Module_sigle.addAll(intent.getStringArrayListExtra("semestre1_module"));
        liste_Module_sigle_semestre1.addAll(intent.getStringArrayListExtra("semestre1_module"));
        liste_Module_sigle.addAll(intent.getStringArrayListExtra("semestre2_module"));
        liste_Module_sigle_semestre2.addAll(intent.getStringArrayListExtra("semestre2_module"));
        liste_Module_sigle.addAll(intent.getStringArrayListExtra("semestre3_module"));
        liste_Module_sigle_semestre3.addAll(intent.getStringArrayListExtra("semestre3_module"));
        liste_Module_sigle.addAll(intent.getStringArrayListExtra("semestre4_module"));
        liste_Module_sigle_semestre4.addAll(intent.getStringArrayListExtra("semestre4_module"));
        liste_Module_sigle.addAll(intent.getStringArrayListExtra("semestre5_module"));
        liste_Module_sigle_semestre5.addAll(intent.getStringArrayListExtra("semestre5_module"));
        liste_Module_sigle.addAll(intent.getStringArrayListExtra("semestre6_module"));
        liste_Module_sigle_semestre6.addAll(intent.getStringArrayListExtra("semestre6_module"));

        ArrayList<String> test =new ArrayList<>();
        test = filtre(liste_Module_sigle);

        nom_cursus.setText(intent.getStringExtra("nom_cursus"));
        nom_cursus_text = intent.getStringExtra("nom_cursus");

        semestre1_module1.setText(intent.getStringArrayListExtra("semestre1_module").get(0));
        semestre1_module2.setText(intent.getStringArrayListExtra("semestre1_module").get(1));
        semestre1_module3.setText(intent.getStringArrayListExtra("semestre1_module").get(2));
        semestre1_module4.setText(intent.getStringArrayListExtra("semestre1_module").get(3));
        semestre1_module5.setText(intent.getStringArrayListExtra("semestre1_module").get(4));
        semestre1_module6.setText(intent.getStringArrayListExtra("semestre1_module").get(5));
        semestre1_tn09.setText(intent.getStringArrayListExtra("semestre1_module").get(6));

        semestre2_module1.setText(intent.getStringArrayListExtra("semestre2_module").get(0));
        semestre2_module2.setText(intent.getStringArrayListExtra("semestre2_module").get(1));
        semestre2_module3.setText(intent.getStringArrayListExtra("semestre2_module").get(2));
        semestre2_module4.setText(intent.getStringArrayListExtra("semestre2_module").get(3));
        semestre2_module5.setText(intent.getStringArrayListExtra("semestre2_module").get(4));
        semestre2_module6.setText(intent.getStringArrayListExtra("semestre2_module").get(5));
        semestre2_tn09.setText(intent.getStringArrayListExtra("semestre2_module").get(6));

        semestre3_module1.setText(intent.getStringArrayListExtra("semestre3_module").get(0));
        semestre3_module2.setText(intent.getStringArrayListExtra("semestre3_module").get(1));
        semestre3_module3.setText(intent.getStringArrayListExtra("semestre3_module").get(2));
        semestre3_module4.setText(intent.getStringArrayListExtra("semestre3_module").get(3));
        semestre3_module5.setText(intent.getStringArrayListExtra("semestre3_module").get(4));
        semestre3_module6.setText(intent.getStringArrayListExtra("semestre3_module").get(5));
        semestre3_tn09.setText(intent.getStringArrayListExtra("semestre3_module").get(6));

        semestre4_module1.setText(intent.getStringArrayListExtra("semestre4_module").get(0));
        semestre4_module2.setText(intent.getStringArrayListExtra("semestre4_module").get(1));
        semestre4_module3.setText(intent.getStringArrayListExtra("semestre4_module").get(2));
        semestre4_module4.setText(intent.getStringArrayListExtra("semestre4_module").get(3));
        semestre4_module5.setText(intent.getStringArrayListExtra("semestre4_module").get(4));
        semestre4_module6.setText(intent.getStringArrayListExtra("semestre4_module").get(5));
        semestre4_tn09.setText(intent.getStringArrayListExtra("semestre4_module").get(6));

        semestre5_module1.setText(intent.getStringArrayListExtra("semestre5_module").get(0));
        semestre5_module2.setText(intent.getStringArrayListExtra("semestre5_module").get(1));
        semestre5_module3.setText(intent.getStringArrayListExtra("semestre5_module").get(2));
        semestre5_module4.setText(intent.getStringArrayListExtra("semestre5_module").get(3));
        semestre5_module5.setText(intent.getStringArrayListExtra("semestre5_module").get(4));
        semestre5_module6.setText(intent.getStringArrayListExtra("semestre5_module").get(5));
        semestre5_tn09.setText(intent.getStringArrayListExtra("semestre5_module").get(6));

        semestre6_module1.setText(intent.getStringArrayListExtra("semestre6_module").get(0));
        semestre6_module2.setText(intent.getStringArrayListExtra("semestre6_module").get(1));
        semestre6_module3.setText(intent.getStringArrayListExtra("semestre6_module").get(2));
        semestre6_module4.setText(intent.getStringArrayListExtra("semestre6_module").get(3));
        semestre6_module5.setText(intent.getStringArrayListExtra("semestre6_module").get(4));
        semestre6_module6.setText(intent.getStringArrayListExtra("semestre6_module").get(5));
        semestre6_tn09.setText(intent.getStringArrayListExtra("semestre6_module").get(6));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu_cursus,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.regle_etude :
                Intent intent2 = new Intent(this, RegleEtudeActivity.class);
                intent2.putExtra("liste_module",liste_Module_sigle);
                startActivity(intent2);
                return  true;
            case R.id.modifier_cursus :
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("liste_Module_sigle_semestre1",liste_Module_sigle_semestre1);
                bundle.putStringArrayList("liste_Module_sigle_semestre2",liste_Module_sigle_semestre2);
                bundle.putStringArrayList("liste_Module_sigle_semestre3",liste_Module_sigle_semestre3);
                bundle.putStringArrayList("liste_Module_sigle_semestre4",liste_Module_sigle_semestre4);
                bundle.putStringArrayList("liste_Module_sigle_semestre5",liste_Module_sigle_semestre5);
                bundle.putStringArrayList("liste_Module_sigle_semestre6",liste_Module_sigle_semestre6);
                bundle.putString("nom_cursus",nom_cursus_text);
                CreerFragment fragment = new CreerFragment();
                fragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,fragment).commit();
                Toast.makeText(this, "modifier cursus cliquer", Toast.LENGTH_LONG).show();
                return  true;
            case R.id.dupliquer_cursus :
                Intent intent = getIntent();
                ajoutCursus(intent.getIntegerArrayListExtra("liste_identifiants"),intent.getStringExtra("nom_cursus"));

                return  true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private  void  ajoutCursus(ArrayList<Integer> indice, String nom_cursus){
        count++;
        for(int i = 0; i<count;i++){
            nom_cursus += "_x";
        }

        /*int semestre1 = 0, semestre2 =0, semestre3 =0, semestre4 =0, semestre5 =0, semestre6 =0;
        for(int i=(indice-5); i<=indice; i++) {
            if (bdOH.getSemestre(i).getSemestre() == 1) {
                semestre1 = i;
            } else if (bdOH.getSemestre(i).getSemestre() == 2) {
                semestre2 = i;
            } else if (bdOH.getSemestre(i).getSemestre() == 3) {
                semestre3 = i;
            } else if (bdOH.getSemestre(i).getSemestre() == 4) {
                semestre4 = i;
            } else if (bdOH.getSemestre(i).getSemestre() == 5) {
                semestre5 = i;
            } else if (bdOH.getSemestre(i).getSemestre() == 6) {
                semestre6 = i;
            }
        }*/

        Cursus cursus = new Cursus(nom_cursus,indice.get(0),indice.get(1),indice.get(2),indice.get(3),indice.get(4),indice.get(5));

        bdOH.createCursus(cursus);
        Toast.makeText(this,"le cursus a été correctement dupliqué", Toast.LENGTH_LONG).show();
    }

    public ArrayList<String> filtre(ArrayList<String> liste_module_sigle){
        ArrayList<String> liste= new ArrayList();
        int indice = 0;
        for(int i=0;i<liste_module_sigle.size(); i++){
            if(!liste_module_sigle.get(i).isEmpty()){
                liste.add(liste_module_sigle.get(i));
                indice++;
            }
        }
        return liste;
    }
}