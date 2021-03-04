package fr.utt.if26.noume_projet_if26.vue;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.zip.Inflater;

import fr.utt.if26.noume_projet_if26.R;

public class NombreSemestreFragment extends Fragment {

    RadioButton radioButton;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_nombre_semestre, container, false);
        Button valider = view.findViewById(R.id.valider);
        RadioGroup radioGroup = view.findViewById(R.id.nombre_semestre);

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = view.findViewById(radioId);
                Bundle bundle = new Bundle();
                bundle.putInt("nombre_semestre", Integer.parseInt(radioButton.getText().toString()));
                CreerFragment fragment = new CreerFragment();
                fragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
            }
        });
        return view;
    }
}
