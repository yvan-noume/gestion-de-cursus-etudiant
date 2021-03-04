package fr.utt.if26.noume_projet_if26.vue;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import fr.utt.if26.noume_projet_if26.R;
import fr.utt.if26.noume_projet_if26.modele.BDOpenHelper;
import fr.utt.if26.noume_projet_if26.modele.Cursus;
import fr.utt.if26.noume_projet_if26.vue.Adaptateur.AdapteurRecyclerCursus;

public class ListeFragment extends Fragment {

    private RecyclerView recyclerView;
    private AdapteurRecyclerCursus adapteur;
    private BDOpenHelper bdOH;
    private ArrayList<Cursus> getAllCursus;
    private EditText semestre6_module1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_liste, container, false);

        recyclerView = view.findViewById(R.id.liste_recycler);
        bdOH = new BDOpenHelper(view.getContext());

        getAllCursus = bdOH.getAllCursus();
        adapteur = new AdapteurRecyclerCursus(getAllCursus);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(adapteur);
        adapteur.setOnItemClickListener(new AdapteurRecyclerCursus.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                /*Bundle bundle = new Bundle();
                bundle.putStringArrayList("semestre1_module",modifierCursus(position,1,view));
                bundle.putStringArrayList("semestre2_module",modifierCursus(position,2,view));
                CreerFragment fragment = new CreerFragment();
                fragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();*/
                Intent intent = new Intent(view.getContext(), AfficherCursusActivity.class);
                intent.putExtra("semestre1_module",modifierCursus(position,1,view));
                intent.putExtra("semestre2_module",modifierCursus(position,2,view));
                intent.putExtra("semestre3_module",modifierCursus(position,3,view));
                intent.putExtra("semestre4_module",modifierCursus(position,4,view));
                intent.putExtra("semestre5_module",modifierCursus(position,5,view));
                intent.putExtra("semestre6_module",modifierCursus(position,6,view));
                intent.putExtra("nom_cursus", bdOH.getAllCursus().get(position).getLabel());
                intent.putExtra("liste_identifiants", identifiantsSemestre(position));
                startActivity(intent);
            }
        });
        return view;
    }

    public ArrayList<String> modifierCursus(int position, int numeroSemestre, View view){
        Cursus cursus = getAllCursus.get(position);

        if(numeroSemestre == 1){
            ArrayList<String> liste_module_semestre1 = new ArrayList<>();
            liste_module_semestre1.add(bdOH.getSemestre(cursus.getSemestre1()).getModule1());
            liste_module_semestre1.add(bdOH.getSemestre(cursus.getSemestre1()).getModule2());
            liste_module_semestre1.add(bdOH.getSemestre(cursus.getSemestre1()).getModule3());
            liste_module_semestre1.add(bdOH.getSemestre(cursus.getSemestre1()).getModule4());
            liste_module_semestre1.add(bdOH.getSemestre(cursus.getSemestre1()).getModule5());
            liste_module_semestre1.add(bdOH.getSemestre(cursus.getSemestre1()).getModule6());
            liste_module_semestre1.add(bdOH.getSemestre(cursus.getSemestre1()).getModule7());
            return liste_module_semestre1;
        }else if(numeroSemestre == 2){
            ArrayList<String> liste_module_semestre2 = new ArrayList<>();
            liste_module_semestre2.add(bdOH.getSemestre(cursus.getSemestre2()).getModule1());
            liste_module_semestre2.add(bdOH.getSemestre(cursus.getSemestre2()).getModule2());
            liste_module_semestre2.add(bdOH.getSemestre(cursus.getSemestre2()).getModule3());
            liste_module_semestre2.add(bdOH.getSemestre(cursus.getSemestre2()).getModule4());
            liste_module_semestre2.add(bdOH.getSemestre(cursus.getSemestre2()).getModule5());
            liste_module_semestre2.add(bdOH.getSemestre(cursus.getSemestre2()).getModule6());
            liste_module_semestre2.add(bdOH.getSemestre(cursus.getSemestre2()).getModule7());
            return liste_module_semestre2;
        }else if(numeroSemestre == 3){
            ArrayList<String> liste_module_semestre3 = new ArrayList<>();
            liste_module_semestre3.add(bdOH.getSemestre(cursus.getSemestre3()).getModule1());
            liste_module_semestre3.add(bdOH.getSemestre(cursus.getSemestre3()).getModule2());
            liste_module_semestre3.add(bdOH.getSemestre(cursus.getSemestre3()).getModule3());
            liste_module_semestre3.add(bdOH.getSemestre(cursus.getSemestre3()).getModule4());
            liste_module_semestre3.add(bdOH.getSemestre(cursus.getSemestre3()).getModule5());
            liste_module_semestre3.add(bdOH.getSemestre(cursus.getSemestre3()).getModule6());
            liste_module_semestre3.add(bdOH.getSemestre(cursus.getSemestre3()).getModule7());
            return liste_module_semestre3;
        }else if (numeroSemestre == 4){
            ArrayList<String> liste_module_semestre4 = new ArrayList<>();
            liste_module_semestre4.add(bdOH.getSemestre(cursus.getSemestre4()).getModule1());
            liste_module_semestre4.add(bdOH.getSemestre(cursus.getSemestre4()).getModule2());
            liste_module_semestre4.add(bdOH.getSemestre(cursus.getSemestre4()).getModule3());
            liste_module_semestre4.add(bdOH.getSemestre(cursus.getSemestre4()).getModule4());
            liste_module_semestre4.add(bdOH.getSemestre(cursus.getSemestre4()).getModule5());
            liste_module_semestre4.add(bdOH.getSemestre(cursus.getSemestre4()).getModule6());
            liste_module_semestre4.add(bdOH.getSemestre(cursus.getSemestre4()).getModule7());
            return liste_module_semestre4;
        }else if(numeroSemestre == 5){
            ArrayList<String> liste_module_semestre5 = new ArrayList<>();
            liste_module_semestre5.add(bdOH.getSemestre(cursus.getSemestre5()).getModule1());
            liste_module_semestre5.add(bdOH.getSemestre(cursus.getSemestre5()).getModule2());
            liste_module_semestre5.add(bdOH.getSemestre(cursus.getSemestre5()).getModule3());
            liste_module_semestre5.add(bdOH.getSemestre(cursus.getSemestre5()).getModule4());
            liste_module_semestre5.add(bdOH.getSemestre(cursus.getSemestre5()).getModule5());
            liste_module_semestre5.add(bdOH.getSemestre(cursus.getSemestre5()).getModule6());
            liste_module_semestre5.add(bdOH.getSemestre(cursus.getSemestre5()).getModule7());
            return liste_module_semestre5;
        }else if (numeroSemestre == 6){
            ArrayList<String> liste_module_semestre6 = new ArrayList<>();
            liste_module_semestre6.add(bdOH.getSemestre(cursus.getSemestre6()).getModule1());
            liste_module_semestre6.add(bdOH.getSemestre(cursus.getSemestre6()).getModule2());
            liste_module_semestre6.add(bdOH.getSemestre(cursus.getSemestre6()).getModule3());
            liste_module_semestre6.add(bdOH.getSemestre(cursus.getSemestre6()).getModule4());
            liste_module_semestre6.add(bdOH.getSemestre(cursus.getSemestre6()).getModule5());
            liste_module_semestre6.add(bdOH.getSemestre(cursus.getSemestre6()).getModule6());
            liste_module_semestre6.add(bdOH.getSemestre(cursus.getSemestre6()).getModule7());
            return liste_module_semestre6;
        }else {
            return null;
        }
    }

    //methode qui renvoie les identifiants des 6 semstres d'un cursus
    public ArrayList<Integer> identifiantsSemestre(int position){
        Cursus cursus = getAllCursus.get(position);
        ArrayList<Integer> listeIdentifiants = new ArrayList<Integer>();
        listeIdentifiants.add(cursus.getSemestre1());
        listeIdentifiants.add(cursus.getSemestre2());
        listeIdentifiants.add(cursus.getSemestre3());
        listeIdentifiants.add(cursus.getSemestre4());
        listeIdentifiants.add(cursus.getSemestre5());
        listeIdentifiants.add(cursus.getSemestre6());

        return listeIdentifiants;
    }
}
