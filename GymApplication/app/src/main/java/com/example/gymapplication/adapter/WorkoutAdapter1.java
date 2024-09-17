package com.example.gymapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gymapplication.domain.Workout;
import com.example.gymapplication.WorkoutActivity;
import com.example.gymapplication.databinding.ViewholderWorkoutBinding;

import java.util.ArrayList;

public class WorkoutAdapter1 extends RecyclerView.Adapter<WorkoutAdapter1.ViewHolder> {

    private final ArrayList<Workout> list;
    private Context context;

    public WorkoutAdapter1(ArrayList<Workout> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        ViewholderWorkoutBinding binding = ViewholderWorkoutBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Workout workout = list.get(position);

        // Set workout title
        holder.binding.titleTxt.setText(workout.getTitle());

        // Load image using Glide
        int resId = context.getResources().getIdentifier(workout.getPicPath(), "drawable", context.getPackageName());
        Glide.with(context)
                .load(resId)
                .into(holder.binding.pic2);

        // Set exercise count, calories, and duration
        holder.binding.exerciseTxt.setText(workout.getLessons().size() + " Exercise");
        holder.binding.kcalTxt.setText(workout.getKcal() + " Kcal");
        holder.binding.durationTxt.setText(workout.getDurationAll());

        // Set click listener on the root view
        holder.binding.getRoot().setOnClickListener(v -> {
            Intent intent = new Intent(context, WorkoutActivity.class);
            intent.putExtra("object", workout);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ViewholderWorkoutBinding binding;

        public ViewHolder(ViewholderWorkoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
