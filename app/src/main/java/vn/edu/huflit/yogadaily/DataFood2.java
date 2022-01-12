package vn.edu.huflit.yogadaily;

import android.content.Context;

import java.util.ArrayList;

public class DataFood2 {
    public static ArrayList<Food2> init_food2(Context context){
        ArrayList<Food2> arrayList = new ArrayList<>();

        arrayList.add(new Food2(context.getString(R.string.food_name_2_1), context.getString(R.string.food_des_2_1), R.drawable.fruit_juice));
        arrayList.add(new Food2(context.getString(R.string.food_name_2_2), context.getString(R.string.food_des_2_2), R.drawable.vegetable_salad));
        arrayList.add(new Food2(context.getString(R.string.food_name_2_3), context.getString(R.string.food_des_2_3), R.drawable.vegetable_soup_to_reduce_fat));
        arrayList.add(new Food2(context.getString(R.string.food_name_2_4), context.getString(R.string.food_des_2_4), R.drawable.green_tea));
        arrayList.add(new Food2(context.getString(R.string.food_name_2_5), context.getString(R.string.food_des_2_5), R.drawable.whole_grain_toast_with_egg_whites));

        return arrayList;
    }
}
