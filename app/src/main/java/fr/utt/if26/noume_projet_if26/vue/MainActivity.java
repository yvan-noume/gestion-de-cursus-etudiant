package fr.utt.if26.noume_projet_if26.vue;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import fr.utt.if26.noume_projet_if26.R;
import fr.utt.if26.noume_projet_if26.modele.BDOpenHelper;

public class MainActivity extends AppCompatActivity {

    BDOpenHelper bdOH = new BDOpenHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AcccueilFragment()).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nouveau_module :
                moduleAdd();
                return  true;
            case R.id.liste_module :
                moduleList();
                return  true;
            case R.id.ajout_auto :
                if(bdOH.countModule() < 20){
                    Toast.makeText(this,"les modules ont été automatiquement créés", Toast.LENGTH_LONG).show();
                    bdOH.initModules();
                }else {
                    Toast.makeText(this,"les modules existent déjà", Toast.LENGTH_LONG).show();
                }
                return  true;
            case R.id.cursus_auto :
                if(bdOH.countModule() < 20){
                    Toast.makeText(this,"veuillez d'abord créer automatiquement les modules", Toast.LENGTH_LONG).show();
                }else {
                    bdOH.initCursus();
                    Toast.makeText(this,"les cursus ont été qutomatiquement créés", Toast.LENGTH_LONG).show();
                }
                return  true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()){
                        case R.id.nav_accueil:
                            selectedFragment = new AcccueilFragment();
                            break;
                        case R.id.nav_créer:
                            selectedFragment = new DefinitionCreerFragment();
                            break;
                        case R.id.nav_liste:
                            selectedFragment = new ListeFragment();
                            break;
                        case R.id.nav_propos:
                            selectedFragment = new ProposFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

                    return true;
                }
            };

    public void moduleAdd() {
        Toast.makeText(this,"je veux ajouter un module", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, ModuleAddActivity.class);
        startActivity(intent);
    }

    public void moduleList() {
        Intent intent = new Intent(this, BDModuleListActivity.class);
        startActivity(intent);
    }

}