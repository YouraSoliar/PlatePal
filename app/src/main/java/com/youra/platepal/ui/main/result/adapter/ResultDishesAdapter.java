package com.youra.platepal.ui.main.result.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.youra.platepal.R;
import com.youra.platepal.data.enteties.Dish;

import java.util.ArrayList;
import java.util.List;

public class ResultDishesAdapter extends RecyclerView.Adapter<ResultDishesAdapter.DishesViewHolder> {

    private List<Dish> dishes = new ArrayList<>();
    private OnNoteClickListener onNoteClickListener;

    public void setOnNoteClickListener(OnNoteClickListener onNoteClickListener) {
        this.onNoteClickListener = onNoteClickListener;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
        notifyDataSetChanged();
    }

    public List<Dish> getDishes() {
        return new ArrayList<>(dishes);
    }

    @NonNull
    @Override
    public ResultDishesAdapter.DishesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dish_item, parent, false);
        return new DishesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultDishesAdapter.DishesViewHolder holder, int position) {
        Dish dish = dishes.get(position);

        holder.textViewItem.setText(dish.getTitle());
//        Glide.with(holder.itemView.getContext())
//                .load("data:image/jpeg;base64," + bird.getStringBitmap())
//                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
//                .into(holder.imageViewItem);
        //holder.imageViewItem.setImageBitmap(Converter.toBitmap(bird.getStringBitmap()));

        holder.itemView.setOnClickListener(view -> onNoteClickListener.onNoteClick(dish));
    }

    @Override
    public int getItemCount() {
        return dishes.size();
    }

    public class DishesViewHolder extends RecyclerView.ViewHolder {

        private RelativeLayout relativeLayoutItem;
        private ImageView imageViewItem;
        private TextView textViewItem;

        public DishesViewHolder(@NonNull View itemView) {
            super(itemView);

            relativeLayoutItem = itemView.findViewById(R.id.relativeLayoutItem);
            imageViewItem = itemView.findViewById(R.id.imageViewItem);
            textViewItem = itemView.findViewById(R.id.textViewItem);
        }
    }

    public interface OnNoteClickListener {
        void onNoteClick(Dish dish);
    }
}
