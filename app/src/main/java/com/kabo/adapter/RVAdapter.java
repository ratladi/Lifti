package com.kabo.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.plus.model.people.Person;
import com.kabo.lifti.R;
import com.kabo.model.Trips;

import java.util.List;

/**
 * Created by kabo on 8/5/15.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.TripsViewHolder>{

    public static class TripsViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView destination;
        TextView date;
        //ImageView personPhoto;

        TripsViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            destination = (TextView)itemView.findViewById(R.id.destination);
            date = (TextView)itemView.findViewById(R.id.date);
           // personPhoto = (ImageView)itemView.findViewById(R.id.person_photo);
        }
    }
   public List<Trips> trips;

    public RVAdapter(List<Trips> trips){
        this.trips = trips;
    }

    @Override
    public int getItemCount() {
        return trips.size();
    }

    @Override
    public TripsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_trip_list, viewGroup, false);
        TripsViewHolder pvh = new TripsViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(TripsViewHolder tripsViewHolder, int i) {
        tripsViewHolder.destination.setText(trips.get(i).Destination);
        tripsViewHolder.date.setText(trips.get(i).date);
        //personViewHolder.personPhoto.setImageResource(persons.get(i).photoId);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}