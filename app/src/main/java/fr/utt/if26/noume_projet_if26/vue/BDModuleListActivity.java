package fr.utt.if26.noume_projet_if26.vue;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import fr.utt.if26.noume_projet_if26.R;
import fr.utt.if26.noume_projet_if26.modele.BDOpenHelper;
import fr.utt.if26.noume_projet_if26.modele.Module;
import fr.utt.if26.noume_projet_if26.vue.Adaptateur.AdaptateurRecylerModule;

public class BDModuleListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_recycler);
        RecyclerView list = findViewById(R.id.module_sigle_recycler);

        BDOpenHelper bdOH = new BDOpenHelper(this);

        ArrayList<Module> modules = bdOH.getAllModules();

        AdaptateurRecylerModule adapter = new AdaptateurRecylerModule(modules);
        list.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        list.setAdapter(adapter);
    }
}