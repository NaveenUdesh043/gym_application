package com.example.gymapplication.adapter



import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gymapplication.domain.Workout
import com.example.gymapplication.WorkoutActivity
import com.example.gymapplication.databinding.ViewholderWorkoutBinding


class WorkoutAdapter(private val list: ArrayList<Workout>) : RecyclerView.Adapter<WorkoutAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val binding = ViewholderWorkoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val workout = list[position]


        holder.binding.titleTxt.text = workout.title


        val resId = context.resources.getIdentifier(workout.picPath, "drawable", context.packageName)
        Glide.with(context)
            .load(resId)
            .into(holder.binding.pic2)


        holder.binding.exerciseTxt.text = "${workout.lessons.size} Exercise"
        holder.binding.kcalTxt.text = "${workout.kcal} Kcal"
        holder.binding.durationTxt.text = workout.durationAll


        holder.binding.root.setOnClickListener {
            val intent = Intent(context, WorkoutActivity::class.java).apply {
                putExtra("object", workout)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(val binding: ViewholderWorkoutBinding) : RecyclerView.ViewHolder(binding.root)
}
