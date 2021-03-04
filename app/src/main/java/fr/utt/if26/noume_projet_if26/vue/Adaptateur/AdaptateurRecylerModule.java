package fr.utt.if26.noume_projet_if26.vue.Adaptateur;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.utt.if26.noume_projet_if26.R;
import fr.utt.if26.noume_projet_if26.modele.Module;

public class AdaptateurRecylerModule extends RecyclerView.Adapter<AdaptateurRecylerModule.ModuleViewHolder> {

    List<Module> moduleList;

    public static class ModuleViewHolder extends RecyclerView.ViewHolder{

        TextView sigle;
        TextView categorie;
        TextView parcours;
        TextView nbCredit;

        public ModuleViewHolder(@NonNull View itemView) {
            super(itemView);
            sigle = itemView.findViewById(R.id.module_t1);
            categorie = itemView.findViewById(R.id.module_t2);
            parcours = itemView.findViewById(R.id.module_t3);
            nbCredit = itemView.findViewById(R.id.module_t4);
        }

        void display(Module module){
            sigle.setText(module.getSigle());
            categorie.setText(module.getCategorie());
            parcours.setText(module.getParcours());
            nbCredit.setText(Integer.toString(module.getCredit()));
        }
    }

    public AdaptateurRecylerModule(List<Module> moduleList) {
        this.moduleList = moduleList;
    }

    @NonNull
    @Override
    public ModuleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.module_item,parent,false);
        ModuleViewHolder moduleViewHolder = new ModuleViewHolder(view);
        return moduleViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ModuleViewHolder holder, int position) {
        holder.display(moduleList.get(position));
    }

    @Override
    public int getItemCount() {
        return moduleList.size();
    }

}
