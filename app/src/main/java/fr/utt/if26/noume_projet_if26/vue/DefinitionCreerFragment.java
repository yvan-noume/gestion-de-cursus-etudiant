package fr.utt.if26.noume_projet_if26.vue;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import fr.utt.if26.noume_projet_if26.R;


public class DefinitionCreerFragment extends Fragment {

    RadioButton radioButton_tn09;
    RadioButton radioButton_se;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_definition_creer, container, false);
        Button valider = view.findViewById(R.id.valider_def);
        RadioGroup radioGroup_tn09 = view.findViewById(R.id.tn09_group);
        RadioGroup radioGroup_se = view.findViewById(R.id.se_group);

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId_tn09 = radioGroup_tn09.getCheckedRadioButtonId();
                int radioId_se = radioGroup_se.getCheckedRadioButtonId();
                radioButton_tn09 = view.findViewById(radioId_tn09);
                radioButton_se = view.findViewById(radioId_se);
                Bundle bundle = new Bundle();
                bundle.putString("tn09",radioButton_tn09.getText().toString());
                bundle.putString("se",radioButton_se.getText().toString());
                CreerFragment fragment = new CreerFragment();
                fragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
            }
        });
        return view;
    }
}