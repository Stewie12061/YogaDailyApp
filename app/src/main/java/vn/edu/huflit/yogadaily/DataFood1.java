package vn.edu.huflit.yogadaily;

import android.content.Context;

import java.util.ArrayList;

public class DataFood1 {

    public static ArrayList<Food1> init_food1(Context context){
        ArrayList<Food1> arrayList = new ArrayList<>();

        arrayList.add(new Food1(context.getString(R.string.food_name_1_1), context.getString(R.string.food_des_1_1), R.drawable.banana));
        arrayList.add(new Food1(context.getString(R.string.food_name_1_2), context.getString(R.string.food_des_1_2), R.drawable.fruit_juice));
        arrayList.add(new Food1(context.getString(R.string.food_name_1_3), context.getString(R.string.food_des_1_3), R.drawable.dried_fruit_and_nut));
        arrayList.add(new Food1(context.getString(R.string.food_name_1_4), context.getString(R.string.food_des_1_4), R.drawable.berry));
        arrayList.add(new Food1(context.getString(R.string.food_name_1_5), context.getString(R.string.food_des_1_5), R.drawable.almond));
        arrayList.add(new Food1(context.getString(R.string.food_name_1_6), context.getString(R.string.food_des_1_6), R.drawable.yogurt));

        return arrayList;
    }
}
