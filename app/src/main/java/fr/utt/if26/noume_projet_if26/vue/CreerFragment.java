package fr.utt.if26.noume_projet_if26.vue;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Iterator;

import fr.utt.if26.noume_projet_if26.R;
import fr.utt.if26.noume_projet_if26.modele.BDOpenHelper;
import fr.utt.if26.noume_projet_if26.modele.Cursus;
import fr.utt.if26.noume_projet_if26.modele.Module;
import fr.utt.if26.noume_projet_if26.modele.Semestre;

public class CreerFragment extends Fragment {

    private BDOpenHelper bdOH;
    private String TAG = "module";
    private int indice= 2;
    private boolean semestre1 = false;
    private boolean semestre2 = false;
    private boolean semestre3 = false;
    private boolean semestre4 = false;
    private boolean semestre5 = false;
    private boolean semestre6 = false;
    private TextView semestre2_tn09;
    private TextView semestre3_tn09;
    private TextView semestre4_tn09;
    private TextView semestre5_tn09;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_creer, container, false);
        EditText nom_cursus = view.findViewById(R.id.nom_cursus);
        TextView titre_page = view.findViewById(R.id.titre_page);

        semestre2_tn09 = view.findViewById(R.id.semestre2_tn09);
        semestre3_tn09 = view.findViewById(R.id.semestre3_tn09);
        semestre4_tn09 = view.findViewById(R.id.semestre4_tn09);
        semestre5_tn09 = view.findViewById(R.id.semestre5_tn09);

        TextView semestre1_se = view.findViewById(R.id.semestre1_se);
        TextView semestre2_se = view.findViewById(R.id.semestre2_se);
        TextView semestre3_se = view.findViewById(R.id.semestre3_se);
        TextView semestre4_se = view.findViewById(R.id.semestre4_se);
        TextView semestre5_se = view.findViewById(R.id.semestre5_se);
        TextView semestre6_se = view.findViewById(R.id.semestre6_se);

        Button valider_creer_semestre1 = view.findViewById(R.id.valider_creer_semestre1);
        Button valider_creer_semestre2 = view.findViewById(R.id.valider_creer_semestre2);
        Button valider_creer_semestre3 = view.findViewById(R.id.valider_creer_semestre3);
        Button valider_creer_semestre4 = view.findViewById(R.id.valider_creer_semestre4);
        Button valider_creer_semestre5 = view.findViewById(R.id.valider_creer_semestre5);
        Button valider_creer_semestre6 = view.findViewById(R.id.valider_creer_semestre6);
        Button valider_creer_cursus = view.findViewById(R.id.valider_creer_cursus);


        TextView semestre1_module1 = view.findViewById(R.id.semestre1_module1);
        TextView semestre1_module2 = view.findViewById(R.id.semestre1_module2);
        TextView semestre1_module3 = view.findViewById(R.id.semestre1_module3);
        TextView semestre1_module4 = view.findViewById(R.id.semestre1_module4);
        TextView semestre1_module5 = view.findViewById(R.id.semestre1_module5);
        TextView semestre1_module6 = view.findViewById(R.id.semestre1_module6);

        TextView semestre2_module1 = view.findViewById(R.id.semestre2_module1);
        TextView semestre2_module2 = view.findViewById(R.id.semestre2_module2);
        TextView semestre2_module3 = view.findViewById(R.id.semestre2_module3);
        TextView semestre2_module4 = view.findViewById(R.id.semestre2_module4);
        TextView semestre2_module5 = view.findViewById(R.id.semestre2_module5);
        TextView semestre2_module6 = view.findViewById(R.id.semestre2_module6);
        TextView semestre2_tn09 = view.findViewById(R.id.semestre2_tn09);

        TextView semestre3_module1 = view.findViewById(R.id.semestre3_module1);
        TextView semestre3_module2 = view.findViewById(R.id.semestre3_module2);
        TextView semestre3_module3 = view.findViewById(R.id.semestre3_module3);
        TextView semestre3_module4 = view.findViewById(R.id.semestre3_module4);
        TextView semestre3_module5 = view.findViewById(R.id.semestre3_module5);
        TextView semestre3_module6 = view.findViewById(R.id.semestre3_module6);

        TextView semestre4_module1 = view.findViewById(R.id.semestre4_module1);
        TextView semestre4_module2 = view.findViewById(R.id.semestre4_module2);
        TextView semestre4_module3 = view.findViewById(R.id.semestre4_module3);
        TextView semestre4_module4 = view.findViewById(R.id.semestre4_module4);
        TextView semestre4_module5 = view.findViewById(R.id.semestre4_module5);
        TextView semestre4_module6 = view.findViewById(R.id.semestre4_module6);

        TextView semestre5_module1 = view.findViewById(R.id.semestre5_module1);
        TextView semestre5_module2 = view.findViewById(R.id.semestre5_module2);
        TextView semestre5_module3 = view.findViewById(R.id.semestre5_module3);
        TextView semestre5_module4 = view.findViewById(R.id.semestre5_module4);
        TextView semestre5_module5 = view.findViewById(R.id.semestre5_module5);
        TextView semestre5_module6 = view.findViewById(R.id.semestre5_module6);

        TextView semestre6_module1 = view.findViewById(R.id.semestre6_module1);
        TextView semestre6_module2 = view.findViewById(R.id.semestre6_module2);
        TextView semestre6_module3 = view.findViewById(R.id.semestre6_module3);
        TextView semestre6_module4 = view.findViewById(R.id.semestre6_module4);
        TextView semestre6_module5 = view.findViewById(R.id.semestre6_module5);
        TextView semestre6_module6 = view.findViewById(R.id.semestre6_module6);

        Bundle bundle = this.getArguments();
        if(bundle != null){

            if(bundle.getStringArrayList("liste_Module_sigle_semestre1") != null){
                titre_page.setText("Modification du cursus");
                valider_creer_cursus.setText("Modifier cursus");
                nom_cursus.setText(bundle.getString("nom_cursus"));
                nom_cursus.setEnabled(false);

                semestre1_module1.setText(bundle.getStringArrayList("liste_Module_sigle_semestre1").get(0));
                semestre1_module2.setText(bundle.getStringArrayList("liste_Module_sigle_semestre1").get(1));
                semestre1_module3.setText(bundle.getStringArrayList("liste_Module_sigle_semestre1").get(2));
                semestre1_module4.setText(bundle.getStringArrayList("liste_Module_sigle_semestre1").get(3));
                semestre1_module5.setText(bundle.getStringArrayList("liste_Module_sigle_semestre1").get(4));
                semestre1_module6.setText(bundle.getStringArrayList("liste_Module_sigle_semestre1").get(5));

                semestre2_module1.setText(bundle.getStringArrayList("liste_Module_sigle_semestre2").get(0));
                semestre2_module2.setText(bundle.getStringArrayList("liste_Module_sigle_semestre2").get(1));
                semestre2_module3.setText(bundle.getStringArrayList("liste_Module_sigle_semestre2").get(2));
                semestre2_module4.setText(bundle.getStringArrayList("liste_Module_sigle_semestre2").get(3));
                semestre2_module5.setText(bundle.getStringArrayList("liste_Module_sigle_semestre2").get(4));
                semestre2_module6.setText(bundle.getStringArrayList("liste_Module_sigle_semestre2").get(5));
                semestre2_tn09.setText(bundle.getStringArrayList("liste_Module_sigle_semestre2").get(6));

                semestre3_module1.setText(bundle.getStringArrayList("liste_Module_sigle_semestre3").get(0));
                semestre3_module2.setText(bundle.getStringArrayList("liste_Module_sigle_semestre3").get(1));
                semestre3_module3.setText(bundle.getStringArrayList("liste_Module_sigle_semestre3").get(2));
                semestre3_module4.setText(bundle.getStringArrayList("liste_Module_sigle_semestre3").get(3));
                semestre3_module5.setText(bundle.getStringArrayList("liste_Module_sigle_semestre3").get(4));
                semestre3_module6.setText(bundle.getStringArrayList("liste_Module_sigle_semestre3").get(5));
                semestre3_tn09.setText(bundle.getStringArrayList("liste_Module_sigle_semestre3").get(6));

                semestre4_module1.setText(bundle.getStringArrayList("liste_Module_sigle_semestre4").get(0));
                semestre4_module2.setText(bundle.getStringArrayList("liste_Module_sigle_semestre4").get(1));
                semestre4_module3.setText(bundle.getStringArrayList("liste_Module_sigle_semestre4").get(2));
                semestre4_module4.setText(bundle.getStringArrayList("liste_Module_sigle_semestre4").get(3));
                semestre4_module5.setText(bundle.getStringArrayList("liste_Module_sigle_semestre4").get(4));
                semestre4_module6.setText(bundle.getStringArrayList("liste_Module_sigle_semestre4").get(5));
                semestre4_tn09.setText(bundle.getStringArrayList("liste_Module_sigle_semestre4").get(6));

                semestre5_module1.setText(bundle.getStringArrayList("liste_Module_sigle_semestre5").get(0));
                semestre5_module2.setText(bundle.getStringArrayList("liste_Module_sigle_semestre5").get(1));
                semestre5_module3.setText(bundle.getStringArrayList("liste_Module_sigle_semestre5").get(2));
                semestre5_module4.setText(bundle.getStringArrayList("liste_Module_sigle_semestre5").get(3));
                semestre5_module5.setText(bundle.getStringArrayList("liste_Module_sigle_semestre5").get(4));
                semestre5_module6.setText(bundle.getStringArrayList("liste_Module_sigle_semestre5").get(5));
                semestre5_tn09.setText(bundle.getStringArrayList("liste_Module_sigle_semestre5").get(6));

                semestre6_module1.setText(bundle.getStringArrayList("liste_Module_sigle_semestre6").get(0));
                semestre6_module2.setText(bundle.getStringArrayList("liste_Module_sigle_semestre6").get(1));
                semestre6_module3.setText(bundle.getStringArrayList("liste_Module_sigle_semestre6").get(2));
                semestre6_module4.setText(bundle.getStringArrayList("liste_Module_sigle_semestre6").get(3));
                semestre6_module5.setText(bundle.getStringArrayList("liste_Module_sigle_semestre6").get(4));
                semestre6_module6.setText(bundle.getStringArrayList("liste_Module_sigle_semestre6").get(5));

                ajoutSemestre6(view,6);
                if(!semestre2_tn09.getText().toString().isEmpty()){
                    valider_creer_semestre2.setEnabled(false);
                    ajoutSemestre2(view,2);
                }else if(!semestre3_tn09.getText().toString().isEmpty()){
                    valider_creer_semestre3.setEnabled(false);
                    ajoutSemestre3(view,3);
                }else if(!semestre4_tn09.getText().toString().isEmpty()){
                    valider_creer_semestre4.setEnabled(false);
                    ajoutSemestre4(view,4);
                }
                else if(!semestre5_tn09.getText().toString().isEmpty()){
                    valider_creer_semestre5.setEnabled(false);
                    ajoutSemestre5(view,5);
                }
            }else {
                Toast.makeText(view.getContext(),bundle.getString("tn09"), Toast.LENGTH_SHORT).show();
                Module module_tn09 = new Module("TN09","ST","TCBR",30);
                Module module_tn10 = new Module("TN10","ST","FIL",30);
                bdOH = new BDOpenHelper(view.getContext());
                bdOH.createModule(module_tn10);
                ajoutSemestre6(view,6);
                if(bundle.getString("tn09").equals("semestre 2")){
                    valider_creer_semestre2.setEnabled(false);
                    semestre2_tn09.setText("TN09");
                    bdOH.createModule(module_tn09);
                    ajoutSemestre2(view,2);
                }else if(bundle.getString("tn09").equals("semestre 3")){
                    valider_creer_semestre3.setEnabled(false);
                    semestre3_tn09.setText("TN09");
                    bdOH.createModule(module_tn09);
                    ajoutSemestre3(view,3);
                }else if(bundle.getString("tn09").equals("semestre 4")){
                    valider_creer_semestre4.setEnabled(false);
                    semestre4_tn09.setText("TN09");
                    bdOH.createModule(module_tn09);
                    ajoutSemestre4(view,4);
                }else if(bundle.getString("tn09").equals("semestre 5")){
                    valider_creer_semestre5.setEnabled(false);
                    semestre5_tn09.setText("TN09");
                    bdOH.createModule(module_tn09);
                    ajoutSemestre5(view,5);
                }

                if(bundle.getString("se").equals("semestre 1")){
                    semestre1_se.setText("SE");
                }else if(bundle.getString("se").equals("semestre 2")){
                    semestre2_se.setText("SE");
                }else if(bundle.getString("se").equals("semestre 3")){
                    semestre3_se.setText("SE");
                }else if(bundle.getString("se").equals("semestre 4")){
                    semestre4_se.setText("SE");
                }else if(bundle.getString("se").equals("semestre 5")){
                    semestre5_se.setText("SE");
                }else if(bundle.getString("se").equals("semestre 6")){
                    semestre6_se.setText("SE");
                }
            }

        }else {
            titre_page.setText("Création d'un cursus");
            valider_creer_cursus.setText("Créer cursus");
        }
        bdOH = new BDOpenHelper(view.getContext());

        valider_creer_semestre1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!semestre1){
                    ajoutSemestre1(view,1);
                    indice += 1;
                }else {
                    Toast.makeText(view.getContext(),"vous avez déjà créé ce semestre!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        valider_creer_semestre2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!semestre2){
                    ajoutSemestre2(view,2);
                    indice += 1;
                }else {
                    Toast.makeText(view.getContext(),"vous avez déjà créé ce semestre!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        valider_creer_semestre3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //valider_creer_semestre4.setVisibility(View.GONE);
                if(!semestre3){
                    ajoutSemestre3(view,3);
                    indice += 1;
                }else {
                    Toast.makeText(view.getContext(),"vous avez déjà créé ce semestre!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        valider_creer_semestre4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!semestre4){
                    ajoutSemestre4(view,4);
                    indice += 1;
                }else {
                    Toast.makeText(view.getContext(),"vous avez déjà créé ce semestre!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        valider_creer_semestre5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!semestre5){
                    ajoutSemestre5(view,5);
                    indice += 1;
                }else {
                    Toast.makeText(view.getContext(),"vous avez déjà créé ce semestre!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        valider_creer_semestre6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!semestre6){
                    ajoutSemestre6(view,6);
                    indice += 1;
                }else {
                    Toast.makeText(view.getContext(),"vous avez déjà créé ce semestre!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        valider_creer_cursus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom_cursus_text = nom_cursus.getText().toString();
                if(indice == 6){
                    if(bundle.getStringArrayList("liste_Module_sigle_semestre6") != null){
                        modifierCursus(view,bdOH.max(), nom_cursus.getText().toString());
                    }else {
                        ajoutCursus(view,bdOH.max(), nom_cursus.getText().toString());
                    }
                }else if(nom_cursus_text.isEmpty()){
                    Toast.makeText(view.getContext(),"veuillez donner un nom à votre cursus ", Toast.LENGTH_SHORT).show();
                }else if(!(indice == 6)) {
                    Toast.makeText(view.getContext(),"veuillez créer tous les semestres.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return  view;
    }

    //methode pour ajouter le 1er semestre dans le cursus
    public void ajoutSemestre1(View view, int numero_semestre){
        EditText semestre1_module1 = view.findViewById(R.id.semestre1_module1);
        EditText semestre1_module2 = view.findViewById(R.id.semestre1_module2);
        EditText semestre1_module3 = view.findViewById(R.id.semestre1_module3);
        EditText semestre1_module4 = view.findViewById(R.id.semestre1_module4);
        EditText semestre1_module5 = view.findViewById(R.id.semestre1_module5);
        EditText semestre1_module6 = view.findViewById(R.id.semestre1_module6);

        String sigle_semestre1_module1 = semestre1_module1.getText().toString();
        String sigle_semestre1_module2 = semestre1_module2.getText().toString();
        String sigle_semestre1_module3 = semestre1_module3.getText().toString();
        String sigle_semestre1_module4 = semestre1_module4.getText().toString();
        String sigle_semestre1_module5 = semestre1_module5.getText().toString();
        String sigle_semestre1_module6 = semestre1_module6.getText().toString();

        //verifie que le module saisie par l'utilisateur existe dans la base
        ArrayList<String> verifierModule = verifierModule(sigle_semestre1_module1,sigle_semestre1_module2,sigle_semestre1_module3,sigle_semestre1_module4,sigle_semestre1_module5,sigle_semestre1_module6);
        if(verifierModule.size()==0){
            Semestre semestre =  new Semestre(numero_semestre,sigle_semestre1_module1,sigle_semestre1_module2,sigle_semestre1_module3,sigle_semestre1_module4,sigle_semestre1_module5,sigle_semestre1_module6,"");
            bdOH.createSemestre(semestre);
            semestre1 = true;
            Toast.makeText(view.getContext(),"le semestre 1 a été correctement créé", Toast.LENGTH_LONG).show();
        }else{
            String message = "";
            for(int i=0;i<verifierModule.size();i++){
                message += verifierModule.get(i) + ",";
            }
            Toast.makeText(view.getContext(),"les modules " + message + " n'exitent pas!!!", Toast.LENGTH_LONG).show();
        }
    }

    public void ajoutSemestre2(View view, int numero_semestre){
        EditText semestre2_module1 = view.findViewById(R.id.semestre2_module1);
        EditText semestre2_module2 = view.findViewById(R.id.semestre2_module2);
        EditText semestre2_module3 = view.findViewById(R.id.semestre2_module3);
        EditText semestre2_module4 = view.findViewById(R.id.semestre2_module4);
        EditText semestre2_module5 = view.findViewById(R.id.semestre2_module5);
        EditText semestre2_module6 = view.findViewById(R.id.semestre2_module6);

        String sigle_semestre2_module1 = semestre2_module1.getText().toString();
        String sigle_semestre2_module2 = semestre2_module2.getText().toString();
        String sigle_semestre2_module3 = semestre2_module3.getText().toString();
        String sigle_semestre2_module4 = semestre2_module4.getText().toString();
        String sigle_semestre2_module5 = semestre2_module5.getText().toString();
        String sigle_semestre2_module6 = semestre2_module6.getText().toString();

        ArrayList<String> verifierModule = verifierModule(sigle_semestre2_module1,sigle_semestre2_module2,sigle_semestre2_module3,sigle_semestre2_module4,sigle_semestre2_module5,sigle_semestre2_module6);
        if(verifierModule.size()==0){
            Semestre semestre =  new Semestre(numero_semestre,sigle_semestre2_module1,sigle_semestre2_module2,sigle_semestre2_module3,sigle_semestre2_module4,sigle_semestre2_module5,sigle_semestre2_module6,semestre2_tn09.getText().toString());
            bdOH.createSemestre(semestre);
            semestre2 = true;
            Toast.makeText(view.getContext(),"le semestre 2 a été correctement créé", Toast.LENGTH_SHORT).show();
        }else{
            String message = "";
            for(int i=0;i<verifierModule.size();i++){
                message += verifierModule.get(i) + ",";
            }
            Toast.makeText(view.getContext(),"les modules " + message + " n'exitent pas!!!", Toast.LENGTH_SHORT).show();
        }
    }
    public void ajoutSemestre3(View view, int numero_semestre){
        EditText semestre3_module1 = view.findViewById(R.id.semestre3_module1);
        EditText semestre3_module2 = view.findViewById(R.id.semestre3_module2);
        EditText semestre3_module3 = view.findViewById(R.id.semestre3_module3);
        EditText semestre3_module4 = view.findViewById(R.id.semestre3_module4);
        EditText semestre3_module5 = view.findViewById(R.id.semestre3_module5);
        EditText semestre3_module6 = view.findViewById(R.id.semestre3_module6);

        String sigle_semestre3_module1 = semestre3_module1.getText().toString();
        String sigle_semestre3_module2 = semestre3_module2.getText().toString();
        String sigle_semestre3_module3 = semestre3_module3.getText().toString();
        String sigle_semestre3_module4 = semestre3_module4.getText().toString();
        String sigle_semestre3_module5 = semestre3_module5.getText().toString();
        String sigle_semestre3_module6 = semestre3_module6.getText().toString();

        ArrayList<String> verifierModule = verifierModule(sigle_semestre3_module1, sigle_semestre3_module2, sigle_semestre3_module3, sigle_semestre3_module4, sigle_semestre3_module5, sigle_semestre3_module6);
        if(verifierModule.size()==0){
            Semestre semestre =  new Semestre(numero_semestre, sigle_semestre3_module1, sigle_semestre3_module2, sigle_semestre3_module3, sigle_semestre3_module4, sigle_semestre3_module5, sigle_semestre3_module6,semestre3_tn09.getText().toString());
            bdOH.createSemestre(semestre);
            semestre3 = true;
            Toast.makeText(view.getContext(),"le semestre 3 a été correctement créé", Toast.LENGTH_SHORT).show();
        }else{
            String message = "";
            for(int i=0;i<verifierModule.size();i++){
                message += verifierModule.get(i) + ",";
            }
            Toast.makeText(view.getContext(),"les modules " + message + " n'exitent pas!!!", Toast.LENGTH_LONG).show();
        }
    }
    public void ajoutSemestre4(View view, int numero_semestre){
        EditText semestre4_module1 = view.findViewById(R.id.semestre4_module1);
        EditText semestre4_module2 = view.findViewById(R.id.semestre4_module2);
        EditText semestre4_module3 = view.findViewById(R.id.semestre4_module3);
        EditText semestre4_module4 = view.findViewById(R.id.semestre4_module4);
        EditText semestre4_module5 = view.findViewById(R.id.semestre4_module5);
        EditText semestre4_module6 = view.findViewById(R.id.semestre4_module6);

        String sigle_semestre4_module1 = semestre4_module1.getText().toString();
        String sigle_semestre4_module2 = semestre4_module2.getText().toString();
        String sigle_semestre4_module3 = semestre4_module3.getText().toString();
        String sigle_semestre4_module4 = semestre4_module4.getText().toString();
        String sigle_semestre4_module5 = semestre4_module5.getText().toString();
        String sigle_semestre4_module6 = semestre4_module6.getText().toString();

        ArrayList<String> verifierModule = verifierModule(sigle_semestre4_module1, sigle_semestre4_module2, sigle_semestre4_module3, sigle_semestre4_module4, sigle_semestre4_module5, sigle_semestre4_module6);
        if(verifierModule.size()==0){
            Semestre semestre =  new Semestre(numero_semestre, sigle_semestre4_module1, sigle_semestre4_module2, sigle_semestre4_module3, sigle_semestre4_module4, sigle_semestre4_module5, sigle_semestre4_module6,semestre4_tn09.getText().toString());
            bdOH.createSemestre(semestre);
            semestre4 = true;
            Toast.makeText(view.getContext(),"le semestre 4 a été correctement créé. module 7 " + semestre4_tn09.getText().toString(), Toast.LENGTH_SHORT).show();
        }else{
            String message = "";
            for(int i=0;i<verifierModule.size();i++){
                message += verifierModule.get(i) + ",";
            }
            Toast.makeText(view.getContext(),"les modules " + message + " n'exitent pas!!!", Toast.LENGTH_LONG).show();
        }
    }
    public void ajoutSemestre5(View view, int numero_semestre){
        EditText semestre5_module1 = view.findViewById(R.id.semestre5_module1);
        EditText semestre5_module2 = view.findViewById(R.id.semestre5_module2);
        EditText semestre5_module3 = view.findViewById(R.id.semestre5_module3);
        EditText semestre5_module4 = view.findViewById(R.id.semestre5_module4);
        EditText semestre5_module5 = view.findViewById(R.id.semestre5_module5);
        EditText semestre5_module6 = view.findViewById(R.id.semestre5_module6);

        String sigle_semestre5_module1 = semestre5_module1.getText().toString();
        String sigle_semestre5_module2 = semestre5_module2.getText().toString();
        String sigle_semestre5_module3 = semestre5_module3.getText().toString();
        String sigle_semestre5_module4 = semestre5_module4.getText().toString();
        String sigle_semestre5_module5 = semestre5_module5.getText().toString();
        String sigle_semestre5_module6 = semestre5_module6.getText().toString();

        ArrayList<String> verifierModule = verifierModule(sigle_semestre5_module1, sigle_semestre5_module2, sigle_semestre5_module3, sigle_semestre5_module4, sigle_semestre5_module5, sigle_semestre5_module6);
        if(verifierModule.size()==0){
            Semestre semestre =  new Semestre(numero_semestre, sigle_semestre5_module1, sigle_semestre5_module2, sigle_semestre5_module3, sigle_semestre5_module4, sigle_semestre5_module5, sigle_semestre5_module6,semestre5_tn09.getText().toString());
            bdOH.createSemestre(semestre);
            semestre5 = true;
            Toast.makeText(view.getContext(),"le semestre 5 a été correctement créé", Toast.LENGTH_SHORT).show();
        }else{
            String message = "";
            for(int i=0;i<verifierModule.size();i++){
                message += verifierModule.get(i) + ",";
            }
            Toast.makeText(view.getContext(),"les modules " + message + " n'exitent pas!!!", Toast.LENGTH_LONG).show();
        }
    }
    public void ajoutSemestre6(View view, int numero_semestre){
        EditText semestre6_module1 = view.findViewById(R.id.semestre6_module1);
        EditText semestre6_module2 = view.findViewById(R.id.semestre6_module2);
        EditText semestre6_module3 = view.findViewById(R.id.semestre6_module3);
        EditText semestre6_module4 = view.findViewById(R.id.semestre6_module4);
        EditText semestre6_module5 = view.findViewById(R.id.semestre6_module5);
        EditText semestre6_module6 = view.findViewById(R.id.semestre6_module6);

        String sigle_semestre6_module1 = semestre6_module1.getText().toString();
        String sigle_semestre6_module2 = semestre6_module2.getText().toString();
        String sigle_semestre6_module3 = semestre6_module3.getText().toString();
        String sigle_semestre6_module4 = semestre6_module4.getText().toString();
        String sigle_semestre6_module5 = semestre6_module5.getText().toString();
        String sigle_semestre6_module6 = semestre6_module6.getText().toString();

        ArrayList<String> verifierModule = verifierModule(sigle_semestre6_module1, sigle_semestre6_module2, sigle_semestre6_module3, sigle_semestre6_module4, sigle_semestre6_module5, sigle_semestre6_module6);
        if(verifierModule.size()==0){
            Semestre semestre =  new Semestre(numero_semestre, sigle_semestre6_module1, sigle_semestre6_module2, sigle_semestre6_module3, sigle_semestre6_module4, sigle_semestre6_module5, sigle_semestre6_module6,"TN10");
            bdOH.createSemestre(semestre);
            semestre6 = true;
            Toast.makeText(view.getContext(),"le semestre 6 a été correctement créé", Toast.LENGTH_SHORT).show();
        }else{
            String message = "";
            for(int i=0;i<verifierModule.size();i++){
                message += verifierModule.get(i) + ",";
            }
            Toast.makeText(view.getContext(),"les modules " + message + " n'exitent pas!!!", Toast.LENGTH_LONG).show();
        }
    }

    //methode pour ajouter un cursus après créer les semestres
    private  void  ajoutCursus(View view, int indice, String nom_cursus){
        int semestre1 = 0, semestre2 =0, semestre3 =0, semestre4 =0, semestre5 =0, semestre6 =0;
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
        }

        Cursus cursus = new Cursus(nom_cursus,semestre1,semestre2,semestre3,semestre4,semestre5,semestre6);

        bdOH.createCursus(cursus);
        Toast.makeText(view.getContext(),"le cursus a été correctement créé", Toast.LENGTH_LONG).show();
    }

    private  void  modifierCursus(View view, int indice, String nom_cursus){
        int semestre1 = 0, semestre2 =0, semestre3 =0, semestre4 =0, semestre5 =0, semestre6 =0;
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
        }

        Cursus cursus = new Cursus(nom_cursus,semestre1,semestre2,semestre3,semestre4,semestre5,semestre6);

        bdOH.updateCursus(cursus);
        Toast.makeText(view.getContext(),"le cursus a été correctement mis à jour", Toast.LENGTH_LONG).show();
    }

    //methode pour récuperer tous les sigle de module présente dans la base
    private ArrayList<String> getSigles(ArrayList<Module> profil) {
        ArrayList res = new ArrayList();
        Iterator iterateur = profil.iterator();
        while (iterateur.hasNext()) {
            Module m = (Module) (iterateur.next());
            res.add(m.getSigle());
        }
        return res;
    }

    //methode qui renvoie les modules saisies par l'etudiant mais n'appartenant pas à la base de données
    public ArrayList<String> verifierModule(String module1, String module2, String module3, String module4, String module5,String module6){
        ArrayList<String> liste_module = new ArrayList();
        bdOH = new BDOpenHelper(this.getContext());
        if(!getSigles(bdOH.getAllModules()).contains(module1) && !module1.isEmpty()){
            liste_module.add(module1);
        }
        if(!getSigles(bdOH.getAllModules()).contains(module2) && !module2.isEmpty()){
            liste_module.add(module2);
        }
        if(!getSigles(bdOH.getAllModules()).contains(module3) && !module3.isEmpty()){
            liste_module.add(module3);
        }
        if(!getSigles(bdOH.getAllModules()).contains(module4) && !module4.isEmpty()){
            liste_module.add(module4);
        }
        if(!getSigles(bdOH.getAllModules()).contains(module5) && !module5.isEmpty()){
            liste_module.add(module5);
        }
        if(!getSigles(bdOH.getAllModules()).contains(module6) && !module6.isEmpty()){
            liste_module.add(module6);
        }

        return liste_module;
    }
}
