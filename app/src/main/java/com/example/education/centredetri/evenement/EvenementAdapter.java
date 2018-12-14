package com.example.education.centredetri.evenement;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import com.example.education.centredetri.R;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.education.centredetri.entity.evenement;

import java.util.ArrayList;

/**
 * Created by Education on 08/12/2018.
 */

public class EvenementAdapter extends RecyclerView.Adapter<EvenementAdapter.ViewHolder> {


private ArrayList<evenement> evenements;
private Context context;
private evenement evenement;

    public EvenementAdapter(ArrayList<evenement> evenements, Context context) {
        this.evenements = evenements;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.liste_item_event, parent, false);
        return new EvenementAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,final int position) {

   evenement=evenements.get(position);
   String titre = evenement.getNomevent();
   String dateD = evenement.getDatedebut();
   String heureD = evenement.getHeuredebut();

   holder.tv_titre.setText(titre);
   holder.tv_dateDebut.setText(dateD);
   holder.tv_heureDebut.setText(heureD);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick() {
                Intent i = new Intent(context, detailsEvent.class);
                i.putExtra("DateDebut", evenements.get(position).getDatedebut());
                i.putExtra("HeureDebut", evenements.get(position).getHeuredebut());
                i.putExtra("DateFin", evenements.get(position).getDatefin());
                i.putExtra("HeureFin", evenements.get(position).getHeurefin());
                i.putExtra("nbPart", evenements.get(position).getNbparticipant());
                i.putExtra("tvDetail", evenements.get(position).getDetails());

                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {

            return evenements.size();
    }


    protected class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv_titre, tv_dateDebut,tv_heureDebut;
        public View linearLayout;
        ItemClickListener itemClickListener;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_heureDebut=itemView.findViewById(R.id.tv_heureDebut);
            tv_dateDebut=itemView.findViewById(R.id.tv_dateDebut);
            tv_titre=itemView.findViewById(R.id.tv_titre);
           // tv_NumeroFacture = itemView.findViewById(R.id.tv_NumeroFacture);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            this.itemClickListener.onItemClick();
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }
    }
}
