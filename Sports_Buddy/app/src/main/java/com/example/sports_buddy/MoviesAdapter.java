package com.example.sports_buddy;


import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {
    // private List<MovieModel> moviesList;
    private List<UserInformation> moviesList;


    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title, date, distance;
        ItemClickListener itemClickListener;


        MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            date = view.findViewById(R.id.date);
            distance = view.findViewById(R.id.distance);
            view.setOnClickListener(this);


        }


        @Override
        public void onClick(View v) {
            this.itemClickListener.onItemClick(v, getLayoutPosition());
        }

        public void setItemClickListener(ItemClickListener ic) {
            this.itemClickListener = ic;
        }
    }

    //  public MoviesAdapter(List<MovieModel> moviesList) {
    //    this.moviesList = moviesList;
    // }
    public MoviesAdapter(List<UserInformation> moviesList) {
        this.moviesList = moviesList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movies_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        // MovieModel movie = moviesList.get(position);
        UserInformation movie = moviesList.get(position);
        holder.title.setText(movie.getTITLE());
        holder.date.setText(movie.getDATE());
        holder.distance.setText(movie.getDISTANCE());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                String title = moviesList.get(pos).getTITLE();
                String date = moviesList.get(pos).getDATE();
                String distance = moviesList.get(pos).getDISTANCE();
                String time = moviesList.get(pos).getTIME();
                String part1 = moviesList.get(pos).getNumberOfParticipants();
                String duration = moviesList.get(pos).getDURATION();
                String max = moviesList.get(pos).getMaximumSpeed();
                String min = moviesList.get(pos).getMinimumSpeed();
                String theme = moviesList.get(pos).getTheme();
                String a = moviesList.get(pos).getA();
                String b = moviesList.get(pos).getB();
                String c = moviesList.get(pos).getC();
                String d = moviesList.get(pos).getD();
                String e = moviesList.get(pos).getE();
                String description = moviesList.get(pos).getDESCRIPTION();
                Intent i = new Intent(v.getContext(), InsideRecyclerItemClick.class);
                i.putExtra("TITLE", title);
                i.putExtra("DATE", date);
                i.putExtra("Distance", distance);
                i.putExtra("DESCRIPTION", description);
                i.putExtra("TIME", time);
                i.putExtra("NumberOfParticipants", part1);
                i.putExtra("DURATION", duration);
                i.putExtra("MaximumSpeed", max);
                i.putExtra("MinimumSpeed", min);
                i.putExtra("Theme", theme);
                i.putExtra("a", a);
                i.putExtra("b", b);
                i.putExtra("c", c);
                i.putExtra("d", d);
                i.putExtra("e", e);
                v.getContext().startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }


}