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

public class Food1Adapter extends RecyclerView.Adapter<Food1Adapter.Food1VH> {

    ArrayList<Food1> arrayList;

    public Food1Adapter(ArrayList<Food1> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Food1VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_food1, parent,false);
        return new Food1VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Food1VH holder, int position) {
        Food1 food1 = arrayList.get(position);
        holder.foodName1.setText(food1.foodName1);
        holder.foodDes1.setText(food1.foodDes1);
        holder.foodImg1.setImageResource(food1.foodImg1);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class Food1VH extends RecyclerView.ViewHolder{

        TextView foodName1, foodDes1;
        ImageView foodImg1;

        public Food1VH(@NonNull View itemView) {
            super(itemView);

            foodName1 = itemView.findViewById(R.id.FoodName1);
            foodDes1 = itemView.findViewById(R.id.FoodDes1);
            foodImg1 = itemView.findViewById(R.id.Img_food_item1);

        }
    }
}
