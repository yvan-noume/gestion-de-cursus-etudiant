package fr.utt.if26.noume_projet_if26.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

import fr.utt.if26.noume_projet_if26.R;
import fr.utt.if26.noume_projet_if26.modele.BDOpenHelper;
import fr.utt.if26.noume_projet_if26.modele.Module;

public class ModuleAddActivity extends AppCompatActivity {

    RadioButton radioButton_categorie;
    RadioButton radioButton_parcours;
    EditText et_sigle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_add);
        RadioGroup radioGroup_categorie = findViewById(R.id.categorie_group);
        RadioGroup radioGroup_parcours = findViewById(R.id.parcours_group);

        Button ajouteBd = findViewById(R.id.button);
        ajouteBd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId_categorie = radioGroup_categorie.getCheckedRadioButtonId();
                int radioId_parcours = radioGroup_parcours.getCheckedRadioButtonId();
                radioButton_categorie = findViewById(radioId_categorie);
                radioButton_parcours = findViewById(radioId_parcours);
                ajoutModuleBase(radioButton_categorie.getText().toString(), radioButton_parcours.getText().toString());
                et_sigle.setText("");
            }
        });
    }

    public void ajoutModuleBase(String categorie, String parcours){
        et_sigle = findViewById(R.id.sigle);
        EditText et_credits = findViewById(R.id.credits);

        String sigle = et_sigle.getText().toString();
        int credits = Integer.valueOf(et_credits.getText().toString());

        Module module = new Module(sigle,categorie,parcours,credits);
        BDOpenHelper bdOH = new BDOpenHelper(this);
        ArrayList<String> sigles = getSigles(bdOH.getAllModules());

        if (sigles.contains(sigle)) {
            Toast.makeText(this,"le module " + sigle + " existe déjà!", Toast.LENGTH_LONG).show();
        }else {
            bdOH.createModule(module);
            Toast.makeText(this,"le module a été correctement ajouté", Toast.LENGTH_LONG).show();
        }
    }

    private ArrayList<String> getSigles(ArrayList<Module> profil) {
        ArrayList res = new ArrayList();
        Iterator iterateur = profil.iterator();
        while (iterateur.hasNext()) {
            Module m = (Module) (iterateur.next());
            res.add(m.getSigle());
        }
        return res;
    }
}