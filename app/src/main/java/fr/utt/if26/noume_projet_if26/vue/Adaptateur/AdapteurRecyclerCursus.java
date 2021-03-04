package fr.utt.if26.noume_projet_if26.vue.Adaptateur;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Calendar;
import java.util.List;

import fr.utt.if26.noume_projet_if26.R;
import fr.utt.if26.noume_projet_if26.modele.Cursus;

public class AdapteurRecyclerCursus extends RecyclerView.Adapter<AdapteurRecyclerCursus.MyViewHolder> {

    private List<Cursus> listCursus;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public AdapteurRecyclerCursus(List<Cursus> listCursus) {
        this.listCursus = listCursus;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView nom_cursus;
        private TextView nom_cursus_bis;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nom_cursus = itemView.findViewById(R.id.nom_cursus_recycle);
            nom_cursus_bis = itemView.findViewById(R.id.nom_cursus_bis);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(mListener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }

        void display(Cursus cursus){
            nom_cursus.setText(cursus.getLabel());
            nom_cursus_bis.setText(cursus.getLabel());
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater  = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.cursus_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.display(listCursus.get(position));
    }

    @Override
    public int getItemCount() {
        return listCursus.size();
    }
}
