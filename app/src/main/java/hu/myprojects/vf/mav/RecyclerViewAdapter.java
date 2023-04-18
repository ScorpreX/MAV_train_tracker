package hu.myprojects.vf.mav;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import hu.myprojects.vf.mav.databinding.TrainitemlayoutBinding;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.TrainsViewHolder> {

    private final Train trains;

    public RecyclerViewAdapter(Train trains) {
        this.trains = trains;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.TrainsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View trainsView = LayoutInflater.from(parent.getContext()).inflate(R.layout.trainitemlayout,
                parent,
                false);
        return new TrainsViewHolder(trainsView);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.TrainsViewHolder holder, int position) {
        if (position % 2 == 0) {
            holder.binding.card.setBackgroundResource(R.color.elvira_lb);
        } else {
            holder.binding.card.setBackgroundResource(R.color.elvira_db);
        }

        holder.binding.card.setOnClickListener(view -> {
            int visibility = holder.binding.llDetails.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE;
            holder.binding.llDetails.setVisibility(visibility);
        });


        holder.binding.tvStartTime.setText(trains.getTimetable().get(position).getStarttime());
        holder.binding.tvDestinationTime.setText(trains.getTimetable().get(position).getDestinationtime());
        holder.binding.tvDuration.setText(trains.getTimetable().get(position).getTotaltime());
        holder.binding.tvDistance.setText(trains.getTimetable().get(position).getDistance());

        holder.binding.tvFrom.setText(trains.getTimetable().get(position).getDetails().get(0).getFrom());
        holder.binding.tvFromDeparture.setText(trains.getTimetable().get(position).getDetails().get(0).getDep());
        holder.binding.tvFromDepartureReal.setText(trains.getTimetable().get(position).getDetails().get(0).getDepReal());
        holder.binding.tvFromPlatform.setText(trains.getTimetable().get(position).getDetails().get(0).getPlatform());

        int detailsLength = trains.getTimetable().get(position).getDetails().size();
        holder.binding.tvTo.setText(trains.getTimetable().get(position).getDetails().get(detailsLength - 1).getFrom());
        holder.binding.tvToDeparture.setText(trains.getTimetable().get(position).getDetails().get(detailsLength - 1).getDep());
        holder.binding.tvToDepartureReal.setText(trains.getTimetable().get(position).getDetails().get(detailsLength - 1).getDepReal());
        holder.binding.tvToPlatform.setText(trains.getTimetable().get(position).getDetails().get(detailsLength - 1).getPlatform());

        holder.binding.tvTrainKlass.setText(trains.getTimetable().get(position).getKlass_() + ". osztály");
        holder.binding.tvTrainCode.setText(trains.getTimetable().get(position).getDetails().get(0).getTrainInfo().getCode());
        holder.binding.tvTrainType.setText(trains.getTimetable().get(position).getDetails().get(0).getTrainInfo().getInfo());
    }


    @Override
    public int getItemCount() {
        return trains.getTimetable().size();
    }

    public class TrainsViewHolder extends RecyclerView.ViewHolder {
        TrainitemlayoutBinding binding;

        public TrainsViewHolder(@NonNull View itemView) {
            super(itemView);

            binding = TrainitemlayoutBinding.bind(itemView);
        }
    }
}
