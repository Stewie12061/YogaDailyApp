package vn.edu.huflit.yogadaily;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Food2Adapter extends RecyclerView.Adapter<Food2Adapter.Food2VH> {

    ArrayList<Food2> arrayList;

    public Food2Adapter(ArrayList<Food2> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Food2VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_food2, parent,false);
        return new Food2VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Food2VH holder, int position) {
        Food2 food2 = arrayList.get(position);
        holder.foodName2.setText(food2.foodName2);
        holder.foodDes2.setText(food2.foodDes2);
        holder.foodImg2.setImageResource(food2.foodImg2);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class Food2VH extends RecyclerView.ViewHolder{

        TextView foodName2, foodDes2;
        ImageView foodImg2;

        public Food2VH(@NonNull View itemView) {
            super(itemView);

            foodName2 = itemView.findViewById(R.id.FoodName2);
            foodDes2 = itemView.findViewById(R.id.FoodDes2);
            foodImg2 = itemView.findViewById(R.id.Img_food_item2);
        }
    }
}
